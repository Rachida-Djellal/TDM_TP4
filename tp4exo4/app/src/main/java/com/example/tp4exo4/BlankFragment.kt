package com.example.tp4exo4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.get
import java.util.ArrayList


class BlankFragment : Fragment() {
    private var adapter: ListViewAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_blank, container, false)
        val bundle1 = this.arguments
           val name=v.findViewById(R.id.nom) as TextView
            val prenom=v.findViewById(R.id.prenom) as TextView
            val adresse=v.findViewById(R.id.adresse) as TextView
            val age=v.findViewById(R.id.age) as TextView
            val telephone=v.findViewById(R.id.telephone) as TextView
            val deplome=v.findViewById(R.id.deplome) as TextView

          name.setText( bundle1?.getString("name"))

            prenom.setText( bundle1?.getString("prenom"))
            adresse.setText( bundle1?.getString("adresse"))
            age.setText( bundle1?.getString("age"))
            telephone.setText( bundle1?.getString("telephone"))
            deplome.setText( bundle1?.getString("deplome"))

        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Emploi De Temps"
    }


}

