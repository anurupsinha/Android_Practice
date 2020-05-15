package com.example.loginmain.ui.login

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginmain.R

/**
 * User details post authentication that is exposed to the UI
 */
class RecyclerExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_example)

        val recyclerview = findViewById<RecyclerView>(R.id.RecyclerView) as RecyclerView
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        fun generateList(size : Int): List<TextData> {

            val bands = ArrayList<TextData>()
            bands.add(TextData(R.drawable.nirvana_icon, "NIRVANA", "Descripton"))
            bands.add(TextData(R.drawable.pj_icon, "PEARL JAM", "Descripton"))
            bands.add(TextData(R.drawable.rhcp_logo, "RHCP", "Descripton"))
            bands.add(TextData(R.drawable.gd_icon, "GREEN DAY", "Descripton"))
            bands.add(TextData(R.drawable.foo_fighters, "FOO FIGHTERS", "Descripton"))

            return bands

        }


//        val adapter = MyAdapter(bands)
//
//        recyclerview.adapter=adapter

        val BandList = generateList(20)
        recyclerview.adapter = MyAdapter(BandList)
        recyclerview.layoutManager = LinearLayoutManager(this)


    }
}
