package com.example.gtaches

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gtaches.MainActivity.MySingleton.lastTask
import com.example.gtaches.MainActivity.MySingleton.taskList
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.util.*


class addNoteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setHasOptionsMenu(true)
    }

    private fun addNote() {
         lastTask=taskText.text.toString()



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.forwordbtn,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item!!.itemId){
            R.id.forwordBtn ->{
                addNote()
                view!!.findNavController().navigate(R.id.action_addNoteFragment_to_addDate)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
