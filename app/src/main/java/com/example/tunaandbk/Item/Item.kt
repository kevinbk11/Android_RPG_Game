package com.example.tunaandbk.Item


abstract class Item()
{
    open val type=""
    operator fun plusAssign(a:Int)
    {
        this.count+=a
    }
    open val name=""
    open var count=0
}
