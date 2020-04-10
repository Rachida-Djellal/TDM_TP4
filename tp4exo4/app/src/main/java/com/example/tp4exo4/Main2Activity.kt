package com.example.tp4exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val extras = intent.extras
      /*   val name=findViewById(R.id.nom) as TextView
        val prenom=findViewById(R.id.prenom) as TextView
        val adresse=findViewById(R.id.adresse) as TextView
        val age=findViewById(R.id.age) as TextView
        val telephone=findViewById(R.id.telephone) as TextView
        val deplome=findViewById(R.id.deplome) as TextView
*/
    /*    name.setText(extras?.getString("name"))

        prenom.setText(extras?.getString("prenom"))
        adresse.setText(extras?.getString("adresse"))
        age.setText(extras?.getString("age"))
        telephone.setText(extras?.getString("telephone"))
        deplome.setText(extras?.getString("deplome"))*/
        val bundle = Bundle()
        bundle.putString("ens",extras?.getString("ens"))
        bundle.putString("duree",extras?.getString("duree"))
        bundle.putString("intitule",extras?.getString("intitule"))

        val fragment = BlankFragment2()
        fragment.arguments=bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contaner, fragment)
        transaction.commit()
    }
}
