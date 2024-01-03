package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Video

private const val VIEW_TYPE_HEADER1=0
private const val VIEW_TYPE_LIST1=1
private const val VIEW_TYPE_FOOTER1=2
class VideoAdapter(private val list:ArrayList<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    class VideoViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageview:ImageView?=view.findViewById(R.id.imageView3)
        val textview1:TextView?=view.findViewById(R.id.textView6)
        val textView2:TextView?=view.findViewById(R.id.textView7)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return when(viewType){
            VIEW_TYPE_HEADER1 ->{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.heading,parent,false)
        VideoViewHolder(view)
            }
            VIEW_TYPE_FOOTER1 ->{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.footer,parent,false)
                VideoViewHolder(view)
            }
            else  ->{

                val view=LayoutInflater.from(parent.context).inflate(R.layout.slide,parent,false)
               VideoViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
      return list.size+2
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        when(getItemViewType(position)){
            VIEW_TYPE_HEADER1 ->{

            }
            VIEW_TYPE_FOOTER1 ->{

            }
            else ->{
                val f = list[position-1]
                holder.textview1?.apply {
                    holder.textview1.text=list[position-1].s1
                }
                holder.textView2?.apply {
                    holder.textView2.text=list[position-1].s2
                }
                holder.imageview?.apply {
                    holder.imageview.setImageResource(f.img)
                }
                }
            }
        }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_HEADER1
            itemCount-1 -> VIEW_TYPE_FOOTER1
            else -> VIEW_TYPE_LIST1
        }
    }

}