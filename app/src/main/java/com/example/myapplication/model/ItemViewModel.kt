package com.example.myapplication.model

import androidx.lifecycle.ViewModel
import com.example.myapplication.R

class ItemViewModel: ViewModel(){
    var image: Int = R.drawable.image0// Provide a default image resource ID
    var item1: String = "Design "
    var item2: String = "19 courses"

}