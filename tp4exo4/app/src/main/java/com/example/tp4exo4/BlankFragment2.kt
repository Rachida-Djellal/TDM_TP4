package com.example.tp4exo4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.widget.Toast



class BlankFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vv = inflater.inflate(R.layout.fragment_blank_fragment2, container, false)
        var array = arrayOf( Ens("Mostefai","Amine","Alger,Algerie","30 ans ","Enseignant,Chercheur,Developpeur","0725361849"),
            Ens("BENKRID","Selma ","Boumerdas","34 ans","Ingenieur informatique","0623154896"),
            Ens("Hassini","Sabrina","Tipazza","35 ans","Ingenieur Informatique","0526319845"),

            Ens("Hadji","Hakime","Msila","36 ans","Ingenieur,Chercheur","0623154898"),
            Ens("Zakaria","Chaima","Bejaia","30 ans","Ingenieur","0714623261"),
            Ens("Tolba","Moslim","Bouira","32 ans","Ingenieur","0623154896"),
            Ens("Hamdad","Leila","Media","33 ans","Ingenieur","0526132984"),
            Ens("Chbieb","Farid","Alger","34 ans","Ingenieur","0623159874"))

        val bundle = this.arguments
        val ens = vv.findViewById(R.id.ens) as Button
        val duree = vv.findViewById(R.id.duree) as TextView
        val intitule=vv.findViewById(R.id.intitule) as TextView
        val index = bundle?.getString("ens")
            val index1 = bundle?.getString("duree")
            val index2 = bundle?.getString("intitule")
            ens.setText(index)
            duree.setText(index1)
            intitule.setText(index2)


        ens.setOnClickListener {
            val bundle1 = Bundle()


            if (index=="Ens Benkrid")
            {

            bundle1.putString("name", array[1].Name)
            bundle1.putString("prenom", array[1].Prenom)
            bundle1.putString("adresse", array[1].Adresse)
            bundle1.putString("age", array[1].Age)
            bundle1.putString("deplome", array[1].Diplome)
            bundle1.putString("telephone", array[1].Telephone)
        }
            Toast.makeText(getActivity(), index,
                Toast.LENGTH_LONG).show();


            if (index.equals("Mostfai A"))
            {
                bundle1.putString("name",array[0].Name)
                bundle1.putString("prenom",array[0].Prenom)
                bundle1.putString("adresse",array[0].Adresse)
                bundle1.putString("age",array[0].Age)
                bundle1.putString("deplome",array[0].Diplome)
                bundle1.putString("telephone",array[0].Telephone)

            }
            if (index.equals("Hassini Sabrina"))
            {
                bundle1.putString("name",array[2].Name)
                bundle1.putString("prenom",array[2].Prenom)
                bundle1.putString("adresse",array[2].Adresse)
                bundle1.putString("age",array[2].Age)
                bundle1.putString("deplome",array[2].Diplome)
                bundle1.putString("telephone",array[2].Telephone)

            }
            if (index.equals("Hadji R"))
            {
                bundle1.putString("name",array[3].Name)
                bundle1.putString("prenom",array[3].Prenom)
                bundle1.putString("adresse",array[3].Adresse)
                bundle1.putString("age",array[3].Age)
                bundle1.putString("deplome",array[3].Diplome)
                bundle1.putString("telephone",array[3].Telephone)

            }
            if (index.equals("Zakaria C"))
            {
                bundle1.putString("name",array[4].Name)
                bundle1.putString("prenom",array[4].Prenom)
                bundle1.putString("adresse",array[4].Adresse)
                bundle1.putString("age",array[4].Age)
                bundle1.putString("deplome",array[4].Diplome)
                bundle1.putString("telephone",array[4].Telephone)

            }
            if (index.equals("Ens Tolba"))
            {
                bundle1.putString("name",array[5].Name)
                bundle1.putString("prenom",array[5].Prenom)
                bundle1.putString("adresse",array[5].Adresse)
                bundle1.putString("age",array[5].Age)
                bundle1.putString("deplome",array[5].Diplome)
                bundle1.putString("telephone",array[5].Telephone)

            }
            if (index.equals("HAMDAD L"))
            {
                bundle1.putString("name",array[6].Name)
                bundle1.putString("prenom",array[6].Prenom)
                bundle1.putString("adresse",array[6].Adresse)
                bundle1.putString("age",array[6].Age)
                bundle1.putString("deplome",array[6].Diplome)
                bundle1.putString("telephone",array[6].Telephone)

            }
            if (index.equals("Chebieb A"))
            {
                bundle1.putString("name",array[7].Name)
                bundle1.putString("prenom",array[7].Prenom)
                bundle1.putString("adresse",array[7].Adresse)
                bundle1.putString("age",array[7].Age)
                bundle1.putString("deplome",array[7].Diplome)
                bundle1.putString("telephone",array[7].Telephone)

            }

            val fragment = BlankFragment()

            val fragmentManager = activity!!.supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.contaner, fragment)
            fragment.arguments=bundle1
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        return vv
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Emploi De Temps"
    }
}
