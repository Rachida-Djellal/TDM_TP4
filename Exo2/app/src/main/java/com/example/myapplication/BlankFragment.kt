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


        var array = arrayOf(
            LivreN("Le monde S'enffondre",R.drawable.vkjvkjk,""),
           LivreN("Contes",R.drawable.rjyrjy,""),
            LivreN("L'etranger",R.drawable.iuytrdsdcvbn,""),
            LivreN("Les poèmes",R.drawable.vvvvvv,""))



        val lv = v.findViewById(R.id.liste) as ListView
        LivreNamesArrayList = ArrayList()

        for (i in array!!.indices) {
            val livreNames = array!![i]
            var j:Int=i
            livreNames.setimageName((j++).toString())
            LivreNamesArrayList.add(livreNames)
        }

       adapter = ListViewAdapter(activity!!)
        lv.adapter = adapter
       lv.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {
                val bundle = Bundle()
                bundle.putInt("amount", position)
                  val fragment = BlankFragment2()
                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.contaner, fragment)
                fragment.arguments=bundle
                fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
            }
        }
        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity!!.title = "Ma Bibliothéque"
    }
    companion object {
        var LivreNamesArrayList = ArrayList<LivreN>()
    }

}
