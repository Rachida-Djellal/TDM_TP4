package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (isTablet(this)) {

            val fragment = BlankFragment()
            val fragment1 = BlankFragment2()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contaner, fragment)
            transaction.replace(R.id.contaner1, fragment1)
            transaction.commit()

        } else {

            val fragment = BlankFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contaner, fragment)
            transaction.commit()

        }
    }
    fun isTablet(context: Context):Boolean
    {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }

}
