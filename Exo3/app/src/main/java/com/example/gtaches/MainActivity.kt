package com.example.gtaches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    object MySingleton {
        var taskList=  ArrayList<Note>()
        var lastTask=""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}
