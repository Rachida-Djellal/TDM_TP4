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


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment2.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
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
            val bundle = Bundle()


            if (index=="Ens Benkrid")
            {

            bundle.putString("name", array[1].getName())
            bundle.putString("prenom", array[1].getPrenom())
            bundle.putString("adresse", array[1].getAdresse())
            bundle.putString("age", array[1].getAge())
            bundle.putString("deplome", array[1].getDeplome())
            bundle.putString("telephone", array[1].getTelephne())
        }
            Toast.makeText(getActivity(), index,
                Toast.LENGTH_LONG).show();


            if (index.equals("Mostfai A"))
            {
                bundle.putString("name",array[0].getName())
                bundle.putString("prenom",array[0].getPrenom())
                bundle.putString("adresse",array[0].getAdresse())
                bundle.putString("age",array[0].getAge())
                bundle.putString("deplome",array[0].getDeplome())
                bundle.putString("telephone",array[0].getTelephne())

            }
            if (index.equals("Hassini Sabrina"))
            {
                bundle.putString("name",array[2].getName())
                bundle.putString("prenom",array[2].getPrenom())
                bundle.putString("adresse",array[2].getAdresse())
                bundle.putString("age",array[2].getAge())
                bundle.putString("deplome",array[2].getDeplome())
                bundle.putString("telephone",array[2].getTelephne())

            }
            if (index.equals("Hadji R"))
            {
                bundle.putString("name",array[3].getName())
                bundle.putString("prenom",array[3].getPrenom())
                bundle.putString("adresse",array[3].getAdresse())
                bundle.putString("age",array[3].getAge())
                bundle.putString("deplome",array[3].getDeplome())
                bundle.putString("telephone",array[3].getTelephne())

            }
            if (index.equals("Zakaria C"))
            {
                bundle.putString("name",array[4].getName())
                bundle.putString("prenom",array[4].getPrenom())
                bundle.putString("adresse",array[4].getAdresse())
                bundle.putString("age",array[4].getAge())
                bundle.putString("deplome",array[4].getDeplome())
                bundle.putString("telephone",array[4].getTelephne())

            }
            if (index.equals("Ens Tolba"))
            {
                bundle.putString("name",array[5].getName())
                bundle.putString("prenom",array[5].getPrenom())
                bundle.putString("adresse",array[5].getAdresse())
                bundle.putString("age",array[5].getAge())
                bundle.putString("deplome",array[5].getDeplome())
                bundle.putString("telephone",array[5].getTelephne())

            }
            if (index.equals("Hamdad L"))
            {
                bundle.putString("name",array[6].getName())
                bundle.putString("prenom",array[6].getPrenom())
                bundle.putString("adresse",array[6].getAdresse())
                bundle.putString("age",array[6].getAge())
                bundle.putString("deplome",array[6].getDeplome())
                bundle.putString("telephone",array[6].getTelephne())

            }
            if (index.equals("Chebeib A"))
            {
                bundle.putString("name",array[7].getName())
                bundle.putString("prenom",array[7].getPrenom())
                bundle.putString("adresse",array[7].getAdresse())
                bundle.putString("age",array[7].getAge())
                bundle.putString("deplome",array[7].getDeplome())
                bundle.putString("telephone",array[7].getTelephne())

            }

            val fragment = BlankFragment()

            val fragmentManager = activity!!.supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.contaner, fragment)
            fragment.arguments=bundle
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
