package com.example.saintly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ElAdapter(private val elderlist : ArrayList<Eldernames>) :
    RecyclerView.Adapter<ElAdapter.MyViewHolder>() {

    private lateinit var mlistener :  onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener : onItemClickListener){
        mlistener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater .from(parent.context).inflate(R.layout.list_item,
            parent,false)
        return MyViewHolder(itemView, mlistener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = elderlist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvheading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return elderlist.size
    }
    class MyViewHolder(itemView : View, listener : onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvheading : TextView = itemView.findViewById(R.id.tvheading)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }


}