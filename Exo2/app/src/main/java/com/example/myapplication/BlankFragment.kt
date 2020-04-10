package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_blank.*
import android.R.attr.key
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private var adapter: ListViewAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_blank, container, false)


        var array = arrayOf( LivreN("Le monde S'enffondre",R.drawable.vkjvkjk,"1"),
           LivreN("Contes",R.drawable.rjyrjy,"2"),
            LivreN("L'etranger",R.drawable.iuytrdsdcvbn,"3"),

          LivreN("Les poèmes",R.drawable.vvvvvv,"4"))



        val lv = v.findViewById(R.id.liste) as ListView
        movieNamesArrayList = ArrayList()

        for (i in array!!.indices) {
            val movieNames = array!![i]
            // Binds all strings into an array
            movieNamesArrayList.add(movieNames)
        }

       adapter = ListViewAdapter(activity!!)

        // Binds the Adapter to the ListView

     //   val adapter = ArrayAdapter(activity!!, R.layout.lv_item, movieNamesArrayList)
        lv.adapter = adapter
       lv.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {

                // value of item that is clicked
            //    val itemValue = lv.getItemAtPosition(position) as String

                val bundle = Bundle()
              //  bundle.putString("item", itemValue)
                bundle.putInt("amount", position)
                // val intent: Intent  = Intent(,BlankFragment2::class.java)
                //intent.putExtra("item",itemValue)
                //intent.putExtra("amount",position)


                //   var bundle = bundleOf("item" to itemValue,"amount" to position)

                    val fragment = BlankFragment2()
                   //
                    val fragmentManager = activity!!.supportFragmentManager

                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.contaner, fragment)
                fragment.arguments=bundle
                fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()


                //   view.findNavController().navigate(R.id.action_mainFragment2_to_secondFragment, bundle)


            }
        }



        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Ma Bibliothéque"
    }
    companion object {
        var movieNamesArrayList = ArrayList<LivreN>()
    }

}
