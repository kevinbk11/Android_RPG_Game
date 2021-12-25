package com.example.tunaandbk.System

import android.content.res.Resources
import com.example.tunaandbk.R

interface GetResource {
    fun getImageResources(r: Resources, name: String, type: String, p: String?): Int {
        return r.getIdentifier(name, type, p)
    }

    fun getXml(key:String):Int?
    {
        val mapXml=mapOf(
            "0001" to R.layout.initial_city,
            "0002" to R.layout.bird_grassland
        )
        return mapXml[key]
    }
}