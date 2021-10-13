package com.example.tunaandbk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.page2_layout.view.*


//自定義Page2Adapter
class Page2Adapter(var ImgList: List<Int>) : RecyclerView.Adapter<Page2Adapter.ViewHolder>() {
    inner class ViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val Img=view.Img
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page2_layout, parent, false)
        val holder=ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Img=ImgList[position]
        holder.Img.setImageResource(Img)
    }

    override fun getItemCount(): Int {
        return ImgList.size
    }
}