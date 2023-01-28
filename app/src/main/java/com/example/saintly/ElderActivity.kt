package com.example.saintly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElderActivity : AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private lateinit var newarraylist : ArrayList<Eldernames>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elder)

        imageId = arrayOf(
          R.drawable.eld,
            R.drawable.elc,
            R.drawable.elb,
            R.drawable.elg,
            R.drawable.elf,
            R.drawable.old2,
            R.drawable.old3,
            R.drawable.old1,
            R.drawable.old4,
            R.drawable.elc
        )

        heading = arrayOf(
            "Mzee retirement home",
            "Rosewood nursing home",
            "Nyumbani home for the old",
            "Fadhili nursing home",
            "Fairseat home for the elderly",
            "Little sisters of the poor nursing home",
            "Healthy care nursing home",
            "Resting home for the old",
            "Eagles nest nursing home",
            "Springs nursing home",
        )
        newRecyclerview = findViewById(R.id.recycleview)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newarraylist = arrayListOf<Eldernames>()
        getuserdata()
    }

    private fun getuserdata() {
        for (i in imageId.indices){
            val elder = Eldernames(imageId[i],heading[i])
            newarraylist.add(elder)

        }
        var adapter = ElAdapter(newarraylist)
        newRecyclerview.adapter = adapter
        adapter.setonItemClickListener(object : ElAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val simToolkitLaunchIntent=
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolkitLaunchIntent?.let { startActivity(it) }

            }

        })
    }
}