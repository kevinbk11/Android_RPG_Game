package com.example.tunaandbk.Pager.ViewPagerPackage

import androidx.viewpager2.widget.ViewPager2
import com.example.tunaandbk.ViewPage


class JobPager(v: ViewPager2): ViewPage(v) {
    var now=0
    init{
        v.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback()
            {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    now=position+1
                }
            })
    }
    fun getChoice():Int
    {
        return now
    }

}