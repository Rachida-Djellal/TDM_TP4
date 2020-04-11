package com.example.gtaches

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gtaches.MainActivity.MySingleton.taskList
import kotlinx.android.synthetic.main.fragment_note_list.*
import kotlinx.android.synthetic.main.note_item.view.*
import java.text.SimpleDateFormat


class noteListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        var myAdapter=MyNOteAdapter(context!!,taskList)

        listNote.adapter=myAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item!!.itemId){
            R.id.addNoteBtn ->{
                view!!.findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }




    inner class MyNOteAdapter:BaseAdapter{

        var listNotAdapter=ArrayList<Note>()
        var context:Context?=null
        constructor( context:Context,listNotAdapter:ArrayList<Note>){
            this.context=context
            this.listNotAdapter=listNotAdapter
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myview=layoutInflater.inflate(R.layout.note_item,null)
            val note=listNotAdapter[position]
            val sdf = SimpleDateFormat("yy-MM-dd")
            myview.textView.text=note.note
            myview.dateView.text= sdf.format(note.date)




            return myview


        }

        override fun getItem(position: Int): Any {
            return listNotAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listNotAdapter.size
        }
    }
}

