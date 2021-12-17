package com.example.tunaandbk.Item.Equipment

import com.example.tunaandbk.Item.Item

abstract class Equipment: Item() {
    override val type = "equipment"
    open val levelNeed=0
}