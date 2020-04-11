package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter: ListViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isLandscape = this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE
        if (isTablet(this) || isLandscape) {
            var array = arrayOf( LivreN("Le monde S'enffondre",R.drawable.vkjvkjk,"1"),
                LivreN("Contes",R.drawable.rjyrjy,"2"),
                LivreN("L'etranger",R.drawable.iuytrdsdcvbn,"3"),
                LivreN("Les poèmes",R.drawable.vvvvvv,"4"))
            val lv = findViewById(R.id.liste) as ListView
            BlankFragment.movieNamesArrayList = ArrayList()

            for (i in array!!.indices) {
                val movieNames = array!![i]
                // Binds all strings into an array
                BlankFragment.movieNamesArrayList.add(movieNames)
            }

            adapter = ListViewAdapter(this)
            lv.adapter = adapter
            lv.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) { val bundle = Bundle()
                    bundle.putInt("amount", position)
                    val fragment = BlankFragment2()
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.contaner1, fragment)
                    fragment.arguments=bundle
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
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
