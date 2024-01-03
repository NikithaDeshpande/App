package com.example.myapplication.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemsBinding
import com.example.myapplication.model.ItemViewModel

class ItemAdapter(private var list:ArrayList<ItemViewModel>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var onClickListener: OnClickListener? = null
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int)
    }
    @SuppressLint("NotifyDataSetChanged")
        fun setFilteredList(filterList:ArrayList<ItemViewModel>){
            filterList.also { list = it }
            notifyDataSetChanged()
        }

    class ItemViewHolder(private val binding: ItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(course:ItemViewModel ) {
            course.also { this.binding.model = it }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
      val inflate=LayoutInflater.from(parent.context)
        val binding=ItemsBinding.inflate(inflate,parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val f=list[position]
holder.bind(f)
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position)
            }
        }

    }

}


