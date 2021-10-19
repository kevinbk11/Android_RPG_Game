package com.example.tunaandbk

import android.content.res.Resources
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.Player.Player

interface FileReadOrWrite {
    fun getImageResources(r: Resources, name:String, type:String, p:String?):Int
    {
        return r.getIdentifier(name,type,p)
    }

    abstract fun createUserData(toString: String, jobPager: JobPager)
    abstract fun rebuildUserData(toString: String)
    abstract fun getId(player: Player)
}