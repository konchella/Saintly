package com.example.saintly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class OpAdapter(private val orphanlist : ArrayList<Orphanames>):
    RecyclerView.Adapter<OpAdapter.MyviewHolder>() {

    private lateinit var mlistener : onitemClickListener
    interface onitemClickListener{

        fun onItemClick(position : Int)
    }
    fun setOnClickListener(listener:onitemClickListener){

        mlistener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,
            false)
        return MyviewHolder(itemview ,mlistener)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem =orphanlist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvheading.text =currentItem.heading
    }

    override fun getItemCount(): Int {
        return orphanlist.size
    }

    class MyviewHolder(itemview : View, listener :onitemClickListener) : RecyclerView.ViewHolder(itemview){
        val titleImage : ShapeableImageView = itemview.findViewById(R.id.title_image)
        val tvheading : TextView = itemview.findViewById(R.id.tvheading)

        init {
            itemview.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }
}