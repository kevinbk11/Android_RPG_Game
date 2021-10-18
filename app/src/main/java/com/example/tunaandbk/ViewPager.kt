package com.example.tunaandbk

import android.content.res.Resources
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class ViewPage(v: ViewPager2)
{
    val viewPager = v
    val ImgList=ArrayList<Int>()
    fun buildViewPage2()
    {
        //設定viewpage2裡面圖片切換資料
        val compositePageTransformer = CompositePageTransformer();
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        viewPager.setPageTransformer(compositePageTransformer)
        viewPager.offscreenPageLimit = 1
        //繫結adapter
        val BgImgAdapter=Page2Adapter(ImgList)
        viewPager.adapter=BgImgAdapter
    }
    fun addimg(img:Int)
    {
        ImgList.add(img)
    }
}

fun getImageResources(r: Resources, name:String, type:String, p:String?):Int
{
    r.pack
    return r.getIdentifier(name,type,p)
}