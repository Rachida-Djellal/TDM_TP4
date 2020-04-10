package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R.attr.defaultValue
import android.widget.ImageView
import android.widget.TextView


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

        //val index=arguments!!.getInt("amount")

      // val item=arguments!!.getString("item")
        val bundle = this.arguments
        val image = vv.findViewById(R.id.imagel) as ImageView
        val description = vv.findViewById(R.id.descriptionl) as TextView
        val auteur=vv.findViewById(R.id.auteurl) as TextView

        if (bundle != null) {
            val index = bundle.getInt("amount", defaultValue)
           // val item=bundle.getString("item")
            auteur.text=resources.getStringArray(R.array.planets_array2)[index]

            description.text=resources.getStringArray(R.array.planets_array1)[index]

            var images = resources.obtainTypedArray(R.array.images)
            var i= resources.getIntArray(R.array.images1)[index]
            image.setImageResource(images.getResourceId(index,-1))
        }




        return vv
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Fragment2"
    }
}


