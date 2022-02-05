package com.example.tunaandbk.System.UIExtension

import android.util.Log
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player

interface  ImageViewExtension {
    fun ImageView.changeHPLengthAnimation(dmgList:List<Int>, now:Int=0, app:AppCompatActivity)
    {
        if(now==dmgList.size)return
        var maxHp = 0F
        var nowHp = 0F
        var afterHP = 0F
        if(fighting.turn==0)
        {
            maxHp = nowMonster.fullHP.toFloat()
            nowHp = nowMonster.hp.toFloat()
            nowMonster.hp-=dmgList[now]
        }
        else
        {
            maxHp = player.fullHP.toFloat()
            nowHp = player.HP.toFloat()
            player.HP-=dmgList[now]
        }
        afterHP = nowHp-dmgList[now]
        val end = if((afterHP)>0)(afterHP)/maxHp else 0f
        val start = if(nowHp>0)nowHp/maxHp else 0f
        Log.v("???TEST","$start:$end")
        val animation = ScaleAnimation(
            start,// x起始縮放比例
            end, // x結束縮放比例
            1.0f,// x起始縮放比例
            1.0f, // y結束縮放比例
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f)
        animation.duration = 600/dmgList.size.toLong()
        animation.fillAfter=true
        this.startAnimation(animation)
        app.runOnUiThread{
            Thread{
                Thread.sleep(600/dmgList.size.toLong())
                changeHPLengthAnimation(dmgList, now+1, app)
            }.start()
        }
    }
    fun ImageView.changeMpLengthAnimation(mp:Int)
    {
        val animation = ScaleAnimation(
            player.MP.toFloat()/player.fullMP.toFloat(),// x起始縮放比例
            (player.MP-mp.toFloat())/player.fullMP, // x結束縮放比例
            1.0f,// x起始縮放比例
            1.0f, // y結束縮放比例
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f)
        animation.duration=600
        animation.fillAfter=true
        player.MP-=mp
        this.startAnimation(animation)
    }
}