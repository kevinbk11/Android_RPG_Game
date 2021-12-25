package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlinx.android.synthetic.main.activity_fight_end_page.*

class FightEndPage : AppCompatActivity() {
    private fun getBarAnimation(barNowLocation:Float,barNewLocation:Float, pivotValue:Float,duration:Long):ScaleAnimation
    {
        val animation = ScaleAnimation(
            barNowLocation,// x起始縮放比例
            barNewLocation, // x結束縮放比例
            1.0f,// x起始縮放比例
            1.0f, // y結束縮放比例
            Animation.RELATIVE_TO_SELF, pivotValue,
            Animation.RELATIVE_TO_SELF, 1f)
        animation.duration=duration
        animation.fillAfter=true
        return animation
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fight_end_page)
        val nowEXP=player.EXP.toFloat()
        val fullEXP=player.fullEXP.toFloat()
        val afterEXP=(player.EXP+nowMonster.exp).toFloat()
        val nowHp = player.HP
        val nowMp = player.MP
        val fullHP = player.fullHP.toFloat()
        val fullMP = player.fullMP.toFloat()
        hpBar.startAnimation(getBarAnimation(1.0f,player.HP.toFloat()/player.fullHP,0f,0))
        mpBar.startAnimation(getBarAnimation(1.0f,player.MP.toFloat()/player.fullMP,0f,0))
        expBar.startAnimation(getBarAnimation(1.0f,nowEXP/fullEXP,0f,0))
        Log.v("test","$nowEXP:$fullEXP:$afterEXP")
        player.getMoney(nowMonster.dropMoney())
        player.getExp(nowMonster.exp)
        Thread{
            runOnUiThread{
                Thread.sleep(1000)
                if(afterEXP<fullEXP)
                {
                    expBar.startAnimation(getBarAnimation(nowEXP/fullEXP,afterEXP/fullEXP,0f,1000))
                }
                else
                {

                    expBar.startAnimation(getBarAnimation(nowEXP/fullEXP,1.0f,0f,1000))
                    Toast.makeText(this,"LEVEL UP!",Toast.LENGTH_SHORT).show()
                    Thread{
                        Thread.sleep(1000)
                        expBar.startAnimation(getBarAnimation(1.0f,0.0f,0f,300))
                        Thread.sleep(500)
                        expBar.startAnimation(getBarAnimation(0.0f,player.EXP.toFloat()/player.fullEXP.toFloat(),0f,1000))
                        Thread.sleep(2000)
                        hpBar.startAnimation(getBarAnimation(nowHp/fullHP,1.0F,0f,763))
                        mpBar.startAnimation(getBarAnimation(nowMp/fullMP,1.0F,0f,763))
                    }.start()
                }
            }
        }.start()
    }
    fun backToMonsterChoice(view: View)
    {
        val intent = Intent(this@FightEndPage,ZoomInMap::class.java)
        val bundle = Bundle()
        bundle.putString("map",player.nowMapNumber)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}