package com.example.saintly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SpecialActivity : AppCompatActivity() {

    private  lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Specialnames>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special)

        imageId = arrayOf(
            R.drawable.spi,
            R.drawable.spc,
            R.drawable.spg,
            R.drawable.spf,
            R.drawable.sph,
            R.drawable.old2,
        )

        heading = arrayOf(
            "Heshima center",
            "Jacaranda center for the needy,Nairobi",
            "House of Mercy rescue center,Limuru",
            "Tumaini boys rescue center,Karen",
            "Rehema childrens rescue center,Ngong",
            "Dream home for the blind,Moyale",
        )

        newRecyclerView = findViewById(R.id.recycleview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Specialnames>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val special = Specialnames(imageId[i], heading[i])
            newArrayList.add(special)
        }
        var adapter = SpAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : SpAdapter.onitemClickListener {
            override fun onItemClick(position: Int) {
                val simToolkitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolkitLaunchIntent?.let { startActivity(it) }

            }

        })
    }

    }