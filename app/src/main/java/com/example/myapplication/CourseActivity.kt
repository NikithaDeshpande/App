package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.VideoAdapter
import com.example.myapplication.model.Video

class CourseActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var list: ArrayList<Video>
    private lateinit var videoAdapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_layout)
        list = ArrayList()
        when (intent.getStringExtra("item1")) {
            "Design Thinking" -> loadDesignThinkingContent()
            "Coding" -> loadCodingContent()
            "Marketing" -> loadMarketingContent()
            // Add more cases as needed
            else -> loadDefaultContent()
        }
        init1()

    }

    private fun loadDefaultContent() {
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Concepts & Models", "Brining it all together"))
        list.add(Video(R.drawable.video_player, "Planning for success", "Why we are doing this?"))
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Concepts & Models", "Brining it all together"))
        list.add(Video(R.drawable.video_player, "Planning for success", "Why we are doing this?"))
    }

    private fun loadMarketingContent() {
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))


    }

    private fun loadCodingContent() {
        list.add(Video(R.drawable.video_player, "Coding 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 5", "Learn design basics"))

    }

    private fun loadDesignThinkingContent() {
        list.add(Video(R.drawable.video_player, "Design Basic 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 5", "Learn design basics"))

    }

    private fun init1() {
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)

        videoAdapter = VideoAdapter(list)
        recyclerview.adapter = videoAdapter


    }
}