package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R.attr.defaultValue
import android.widget.ImageView
import android.widget.TextView

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vv = inflater.inflate(R.layout.fragment_blank_fragment2, container, false)

        val bundle = this.arguments
        val image = vv.findViewById(R.id.imagel) as ImageView
        val description = vv.findViewById(R.id.descriptionl) as TextView
        val auteur=vv.findViewById(R.id.auteurl) as TextView

        if (bundle != null) {
            val index = bundle.getInt("amount", defaultValue)

            auteur.text=resources.getStringArray(R.array.planets_array2)[index]
            description.text=resources.getStringArray(R.array.planets_array1)[index]

            var images = resources.obtainTypedArray(R.array.images1)
            var i= resources.getIntArray(R.array.images1)[index]
            image.setImageResource(images.getResourceId(index,-1))
        }




        return vv
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Ma Bibliotheque"
    }
}


