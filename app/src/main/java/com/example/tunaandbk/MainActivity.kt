package com.example.tunaandbk

import android.content.Context
import android.graphics.Color
import android.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.page2_layout.view.*


class MainActivity : AppCompatActivity() {
    val ImgList=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildViewPage2()
    }

    //自定義向viewpage2這個控制元件新增圖片
    fun buildViewPage2()
    {
        //設定viewpage2裡面圖片切換資料
        val compositePageTransformer = CompositePageTransformer();
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        viewPager.setPageTransformer(compositePageTransformer)
        viewPager.offscreenPageLimit = 1
        //繫結adapter
        val BgImgAdapter=Page2Adapter(ImgList)
        initImg()
        viewPager.adapter=BgImgAdapter
    }
    fun initImg(){
        for(i in 1..5)
        {
            ImgList.add(resources.getIdentifier("b$i","mipmap",packageName))
        }
    }
}



