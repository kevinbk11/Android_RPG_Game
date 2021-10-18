package com.example.tunaandbk

import android.content.res.Resources
import android.os.Bundle
import android.util.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatCallback
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.page2_layout.view.*

class MainActivity : AppCompatActivity(),FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jobPager=JobPager(viewPager)
        for(i in 1..2)
        {
            jobPager.addimg(getImageResources(resources,"b$i","mipmap",packageName))
        }
        jobPager.buildViewPage2()
        Thread{
            while(true)
            {
                Log.v("test", jobPager.getChoice().toString())
                Thread.sleep(1000)
            }
        }.start()
    }
}



