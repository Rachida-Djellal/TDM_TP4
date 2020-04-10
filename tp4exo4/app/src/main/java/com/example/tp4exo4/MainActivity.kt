package com.example.tp4exo4

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import java.util.ArrayList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.GridView


class MainActivity : AppCompatActivity() {
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var array = arrayOf(
            Seance(
                "TP SGBD",
                "Demanche a 08h30",
                "Salle:CPI07",
                "Ens Benkrid",
                "30h",
                "SGBD et base de donees avancé "
            ),
            Seance(
                "TD IHM",
                "Demanche a 11h00 ",
                "Salle:CPI05",
                "Hassini Sabrina",
                "15h",
                "Interaction Homme Machine"
            ),
            Seance(
                "TDM",
                "Demanche a 13h00",
                "Salle:visio",
                "Mostfai A",
                "40h",
                "Technologie et Developpement Mobile"
            ),

            Seance("Cours HPC", "Lundi a 08h30", "Salle:A4", "Hadji R", "25h", ""),
            Seance("TP HPC", "Lundi a 10h00", "Salle:MC", "Hadji R", "30h", ""),
            Seance("Cour Alog", "Lundi a 13h00", "Salle:A2", "Zakaria C", "30", "Qualite Logiciel"),
            Seance(
                "Cours SGBD",
                "Mardi a 08h30 ",
                "Salle:17",
                "Ens Benkrid",
                "30h",
                "SGBD et base de donnes avancee"
            ),
            Seance("TD Alog", "Mardi a 10h00", "Salle:MC04", "Ens Tolba", "25h", ""),
            Seance("TP BDM", "Mercredi a 08h30", "Salle:CP05", "HAMDAD L", "30H", ""),
            Seance("Cours BDM", "Mercredi a 10h30", "Salle:A2", "HAMDAD L", "30H", ""),
            Seance(
                "Cours Alog",
                "Mercredi a 13h00",
                "Salle:A3",
                "Chebieb A",
                "30h",
                "Architectures Logiciels"
            ),
            Seance("TD Qlog", "Mercredi a 15h00", "Salle:CPI01", "ZAKARIA C", "30H", ""),
            Seance("PRJSIL", "Jeudi a 08h30 ", "Salle:Visio", "Batata et HAKIMI", "30H", ""),
            Seance(
                "Cour IHM ",
                "Jeudi a 13h00",
                "Salle:A04",
                "Hassini",
                "30h",
                "Interaction Homme Machine"
            )


        )




        movieNamesArrayList = ArrayList()

        for (i in array!!.indices) {
            val movieNames = array!![i]
            // Binds all strings into an array
            movieNamesArrayList.add(movieNames)
        }

        adapter = ListViewAdapter(this)

        // Binds the Adapter to the ListView

        //   val adapter = ArrayAdapter(activity!!, R.layout.lv_item, movieNamesArrayList)
        if (isTablet(this)) {

            val grid = findViewById(R.id.grid) as GridView
            grid.adapter = adapter
            grid.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {
                    val fragment = BlankFragment()
                    val fragment1 = BlankFragment2()

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner1, fragment)
                    transaction.replace(R.id.contaner2, fragment1)
                    transaction.commit()
                }
            }

        } else {


            val lv = findViewById(R.id.liste) as ListView

            lv.adapter = adapter
            lv.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {


                    val ens: String = array[position].getEnseignant()
                    val duree: String = array[position].getDureeTotal()
                    val intitule: String = array[position].getIntitule()


                    val intent = Intent(baseContext, Main2Activity::class.java)

                    intent.putExtra("ens", ens)
                    intent.putExtra("duree", duree)
                    intent.putExtra("intitule", intitule)



                    startActivity(intent)

                    //   view.findNavController().navigate(R.id.action_mainFragment2_to_secondFragment, bundle)


                }
            }


        }
    }
    companion object {
        var movieNamesArrayList = ArrayList<Seance>()
    }
    fun isTablet(context:Context):Boolean
    {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
                  or( context.resources.configuration.orientation and  Configuration.ORIENTATION_LANDSCAPE)
                )
    }
}
