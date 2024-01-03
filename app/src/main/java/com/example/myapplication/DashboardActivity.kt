package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.databinding.DashboardActivityBinding
import com.example.myapplication.model.ItemViewModel


class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var list: ArrayList<ItemViewModel>
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var binding: DashboardActivityBinding
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchView =findViewById(R.id.et_search_bar)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true

            }

        })
        list = ArrayList()


        init()

    }

     fun filterList(newText: String?) {
         val filteredList:ArrayList<ItemViewModel> = ArrayList()
         list.forEach { s ->
             if (s.item1.lowercase().contains(newText?.lowercase() ?: " ")) {
                 filteredList.add(s)
             }
         }
         if (filteredList.isEmpty()) {
                 Toast.makeText(applicationContext, "not found ", Toast.LENGTH_LONG).show()
             } else {
                 itemAdapter.setFilteredList(filteredList)
             }
         }

        private fun init() {

            val itemViewModel = ItemViewModel().apply {
                image = R.drawable.img
                item1 = "Design Thinking"
                item2 = "19 courses"
            }
            val itemViewModel1 = ItemViewModel().apply {
                image = R.drawable.img1
                item1 = "Coding"
                item2 = "19 courses"
            }
            val itemViewModel2 = ItemViewModel().apply {
                image = R.drawable.img2
                item1 = "Marketing"
                item2 = "21 courses"
            }
            val itemViewModel3 = ItemViewModel().apply {
                image = R.drawable.img3
                item1 = "Security Expert"
                item2 = "19 courses"
            }
            val itemViewModel4 = ItemViewModel().apply {
                image = R.drawable.img4
                item1 = "Big Data"
                item2 = "15 courses"
            }
            list.add(itemViewModel)
            list.add(itemViewModel1)
            list.add(itemViewModel2)
            list.add(itemViewModel3)
            list.add(itemViewModel4)

            recyclerview = findViewById(R.id.recyclerview)
            recyclerview.setHasFixedSize(true)
            with(binding) {
                recyclerview.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

                itemAdapter = ItemAdapter(list)
                recyclerview.adapter = itemAdapter
                itemAdapter.setOnClickListener(object :
                    ItemAdapter.OnClickListener {
                    override fun onClick(position: Int) {
//                        val intent = Intent(this@DashboardActivity, CourseActivity::class.java)
//                        // Passing the data to the
//                        // EmployeeDetails Activity
//                        startActivity(intent)
                        val clickedItem = list[position] // Get the clicked item from the list
                        val intent = Intent(this@DashboardActivity, CourseActivity::class.java)
                        intent.putExtra("item1", clickedItem.item1) // Pass item1 data to CourseActivity
                        startActivity(intent)
                    }
                })
            }

            recyclerview.addItemDecoration(CustomItemDecoration(50))


        }

    }
