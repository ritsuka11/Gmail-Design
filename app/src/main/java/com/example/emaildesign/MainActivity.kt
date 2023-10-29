package com.example.emaildesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<Model>()
        for (i in 1..17) {
            val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            itemList.add(
                Model(
                    characters[Random().nextInt(characters.length)] + "random" + String.format("%03d", i) + "@gmail.com",
                    "Account Suspended",
                    "Your account has been suspended because we suspect you are engaging in improper activities.",
                    String.format(
                        "%02d:%02d %s",
                        Random().nextInt(12) + 1,
                        Random().nextInt(60),
                        if (Random().nextBoolean()) "AM" else "PM"
                    )
                )
            )
        }
        val adapter = Adapter(itemList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }
}
