package com.example.saintly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrhanActivity : AppCompatActivity() {
    private  lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Orphanames>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orhan)

        imageId = arrayOf(
            R.drawable.ch2,
            R.drawable.ch3,
            R.drawable.ch4,
            R.drawable.ch5,
            R.drawable.ch6,
            R.drawable.ch7,
            R.drawable.ch8,
            R.drawable.ch9,

        )

        heading = arrayOf(
            "Imani childrens home",
            "Wings of Hope ,Nairobi",
            "House of Mercy  center,Limuru",
            "Tumaini boys rescue center,Karen",
            "Rehema childrens home,Ngong",
            "Dream Girls  center,Moyale",
            "Joy divine childrens home",
            "st Teresa childrens home",


        )

        newRecyclerView = findViewById(R.id.recycleview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Orphanames>()
        getUserdata()
    }

    private fun getUserdata()  {
        for (i in imageId.indices) {
            val orphan = Orphanames(imageId[i], heading[i])
            newArrayList.add(orphan)
        }
        var adapter = OpAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : OpAdapter.onitemClickListener {
            override fun onItemClick(position: Int) {
                val simToolkitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolkitLaunchIntent?.let { startActivity(it) }

            }

        })
    }


}