package com.example.gtaches

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gtaches.MainActivity.MySingleton.id
import com.example.gtaches.MainActivity.MySingleton.lastTask
import com.example.gtaches.MainActivity.MySingleton.taskList
import kotlinx.android.synthetic.main.fragment_add_date.*
import java.util.*


class addDate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_date, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.backbtn,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item!!.itemId){
            R.id.backBtn ->{

                val date: Date = Date(datePicker.year, datePicker.month , datePicker.dayOfMonth)
                MainActivity.MySingleton.id+=1
                val note:Note=Note(date,lastTask,MainActivity.MySingleton.id )
                taskList.add(note)
                view!!.findNavController().navigate(R.id.noteListFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
