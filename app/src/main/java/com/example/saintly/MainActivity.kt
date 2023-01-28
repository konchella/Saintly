package com.example.saintly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    lateinit var Cardorph:CardView
    lateinit var Cardeld:CardView
    lateinit var Cardspec:CardView
    lateinit var Cardres:CardView
    lateinit var Cardsaint:CardView
    lateinit var Cardlogout: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cardorph=findViewById(R.id.Cardorph)
        Cardeld=findViewById(R.id.Cardeld)
        Cardspec=findViewById(R.id.Cardspec)
        Cardres=findViewById(R.id.Cardres)
        Cardsaint=findViewById(R.id.Cardsaint)
        Cardlogout=findViewById(R.id.Cardlogout)

        Cardorph.setOnClickListener {
            val orp=Intent(this,OrhanActivity::class.java)
            startActivity(orp)

            Toast.makeText(this,"yaay!", Toast.LENGTH_SHORT).show()
        }

        Cardeld.setOnClickListener {
            val eld=Intent(this,ElderActivity::class.java)
            startActivity(eld)
        }

        Cardspec.setOnClickListener {
            val spec=Intent(this,SpecialActivity::class.java)
            startActivity(spec)
        }

        Cardres.setOnClickListener {
            val res=Intent(this,RescueActivity::class.java)
            startActivity(res)
        }
    }
}