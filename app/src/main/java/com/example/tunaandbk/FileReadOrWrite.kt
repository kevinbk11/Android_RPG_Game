package com.example.tunaandbk

import android.content.res.Resources

interface FileReadOrWrite {
    fun getImageResources(r: Resources, name:String, type:String, p:String?):Int
    {
        return r.getIdentifier(name,type,p)
    }
}