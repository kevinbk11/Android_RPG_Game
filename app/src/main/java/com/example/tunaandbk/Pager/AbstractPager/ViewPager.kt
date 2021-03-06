package com.example.tunaandbk

import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tunaandbk.Pager.Adapter.Page2Adapter

abstract class ViewPage(v: ViewPager2)
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
        val BgImgAdapter= Page2Adapter(ImgList)
        viewPager.adapter=BgImgAdapter
    }
    fun addimg(img:Int)
    {
        ImgList.add(img)
    }
}