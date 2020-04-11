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
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isLandscape = this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE
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
            Seance("TD Alog", "Mardi a 10h00", "Salle:MC04", "Ens Tolba", "25h", "Architecture Logiciels"),
            Seance("TP BDM", "Mercredi a 08h30", "Salle:CP05", "HAMDAD L", "30H", "Big Data Maining"),
            Seance("Cours BDM", "Mercredi a 10h30", "Salle:A2", "HAMDAD L", "30H", "Big Data Maining"),
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
        if (isTablet(this) || isLandscape ) {

            val grid = findViewById(R.id.grid) as GridView
            grid.adapter = adapter
            grid.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {
                    val bundle = Bundle()
                    var array1 = arrayOf( Ens("Mostefai","Amine","Alger,Algerie","30 ans ","Enseignant,Chercheur,Developpeur","0725361849"),
                        Ens("BENKRID","Selma ","Boumerdas","34 ans","Ingenieur informatique","0623154896"),
                        Ens("Hassini","Sabrina","Tipazza","35 ans","Ingenieur Informatique","0526319845"),

                        Ens("Hadji","Hakime","Msila","36 ans","Ingenieur,Chercheur","0623154898"),
                        Ens("Zakaria","Chaima","Bejaia","30 ans","Ingenieur","0714623261"),
                        Ens("Tolba","Moslim","Bouira","32 ans","Ingenieur","0623154896"),
                        Ens("Hamdad","Leila","Media","33 ans","Ingenieur","0526132984"),
                        Ens("Chbieb","Farid","Alger","34 ans","Ingenieur","0623159874"))
                    val ens: String = array[position].getEnseignant()
                    val duree: String = array[position].getDureeTotal()
                    val intitule: String = array[position].getIntitule()

                    bundle.putString("ens", ens)
                    bundle.putString("duree", duree)
                    bundle.putString("intitule", intitule)

                    if (ens=="Ens Benkrid")
                    {

                        bundle.putString("name", array1[1].getName())
                        bundle.putString("prenom", array1[1].getPrenom())
                        bundle.putString("adresse", array1[1].getAdresse())
                        bundle.putString("age", array1[1].getAge())
                        bundle.putString("deplome", array1[1].getDeplome())
                        bundle.putString("telephone", array1[1].getTelephne())
                    }

                    Toast.makeText(this@MainActivity, ens,
                        Toast.LENGTH_LONG).show();

                    if (ens.equals("Mostfai A"))
                    {
                        bundle.putString("name",array1[0].getName())
                        bundle.putString("prenom",array1[0].getPrenom())
                        bundle.putString("adresse",array1[0].getAdresse())
                        bundle.putString("age",array1[0].getAge())
                        bundle.putString("deplome",array1[0].getDeplome())
                        bundle.putString("telephone",array1[0].getTelephne())

                    }
                    if (ens.equals("Hassini Sabrina"))
                    {
                        bundle.putString("name",array1[2].getName())
                        bundle.putString("prenom",array1[2].getPrenom())
                        bundle.putString("adresse",array1[2].getAdresse())
                        bundle.putString("age",array1[2].getAge())
                        bundle.putString("deplome",array1[2].getDeplome())
                        bundle.putString("telephone",array1[2].getTelephne())

                    }
                    if (ens.equals("Hadji R"))
                    {
                        bundle.putString("name",array1[3].getName())
                        bundle.putString("prenom",array1[3].getPrenom())
                        bundle.putString("adresse",array1[3].getAdresse())
                        bundle.putString("age",array1[3].getAge())
                        bundle.putString("deplome",array1[3].getDeplome())
                        bundle.putString("telephone",array1[3].getTelephne())

                    }
                    if (ens.equals("Zakaria C"))
                    {
                        bundle.putString("name",array1[4].getName())
                        bundle.putString("prenom",array1[4].getPrenom())
                        bundle.putString("adresse",array1[4].getAdresse())
                        bundle.putString("age",array1[4].getAge())
                        bundle.putString("deplome",array1[4].getDeplome())
                        bundle.putString("telephone",array1[4].getTelephne())

                    }
                    if (ens.equals("Ens Tolba"))
                    {
                        bundle.putString("name",array1[5].getName())
                        bundle.putString("prenom",array1[5].getPrenom())
                        bundle.putString("adresse",array1[5].getAdresse())
                        bundle.putString("age",array1[5].getAge())
                        bundle.putString("deplome",array1[5].getDeplome())
                        bundle.putString("telephone",array1[5].getTelephne())

                    }
                    if (ens.equals("HAMDAD L"))
                    {
                        bundle.putString("name",array1[6].getName())
                        bundle.putString("prenom",array1[6].getPrenom())
                        bundle.putString("adresse",array1[6].getAdresse())
                        bundle.putString("age",array1[6].getAge())
                        bundle.putString("deplome",array1[6].getDeplome())
                        bundle.putString("telephone",array1[6].getTelephne())

                    }
                    if (ens.equals("Chebieb A"))
                    {
                        bundle.putString("name",array1[7].getName())
                        bundle.putString("prenom",array1[7].getPrenom())
                        bundle.putString("adresse",array1[7].getAdresse())
                        bundle.putString("age",array1[7].getAge())
                        bundle.putString("deplome",array1[7].getDeplome())
                        bundle.putString("telephone",array1[7].getTelephne())

                    }
                    val fragment = BlankFragment()
                    val fragment1 = BlankFragment2()
                    fragment.arguments=bundle
                    fragment1.arguments=bundle
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
