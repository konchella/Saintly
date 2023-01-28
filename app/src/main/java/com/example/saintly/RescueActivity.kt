package com.example.saintly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RescueActivity : AppCompatActivity() {

    private  lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Rescuenames>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rescue)

        imageId = arrayOf(
            R.drawable.guitar1,
            R.drawable.gallery4,
            R.drawable.guitar,
            R.drawable.rescue1,
            R.drawable.gallery3,
            R.drawable.old2,
        )

        heading = arrayOf(
            "Rescue Dada rescue center",
            "Wings of Hope Rescue center,Nairobi",
            "House of Mercy rescue center,Limuru",
            "Tumaini  rescue center,Karen",
            "Rehema childrens rescue center,Ngong",
            "Dream Girls rescue center,Moyale",
        )

        newRecyclerView = findViewById(R.id.recycleview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Rescuenames>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val rescue= Rescuenames(imageId[i],heading[i])
            newArrayList.add(rescue)
        }
        var adapter= MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : MyAdapter.onitemClickListener{
            override fun onItemClick(position: Int) {
                val simToolkitLaunchIntent=
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolkitLaunchIntent?.let { startActivity(it) }

            }

        })

        }

        }

