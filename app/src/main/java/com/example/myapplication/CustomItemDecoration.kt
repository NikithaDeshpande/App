package com.example.myapplication

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class CustomItemDecoration(private val margin:Int) :RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val lay=view.layoutParams as StaggeredGridLayoutManager.LayoutParams

        if(lay.spanIndex==0){
            outRect.top=margin
        }else{
            outRect.top=margin*2
        }
        outRect.left=margin
    }
}