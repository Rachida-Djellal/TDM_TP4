package com.example.gtaches

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gtaches.MainActivity.MySingleton.taskList
import com.google.android.gms.common.util.DeviceProperties.isTablet
import kotlinx.android.synthetic.main.fragment_note_list.*
import kotlinx.android.synthetic.main.note_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


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






        load()



    }

    private fun load(){
        var myAdapter:BaseAdapter

        val orientation = getResources().getConfiguration().orientation
        if ((orientation == Configuration.ORIENTATION_LANDSCAPE)) {

            if (navigation!=null)
            {
                navigation.setNavigationItemSelectedListener {

                    when (it.itemId) {
                        R.id.today -> {
                            myAdapter=MyNOteAdapter(context!!,currentList(taskList))
                            listNote.adapter=myAdapter
                            true
                        }
                        R.id.week -> {
                            myAdapter=MyNOteAdapter(context!!,weekList(taskList))
                            listNote.adapter=myAdapter
                            true
                        }
                        R.id.all -> {
                            myAdapter=MyNOteAdapter(context!!,taskList)
                            listNote.adapter=myAdapter
                            true
                        }
                        else -> false
                    }
                }

            }


        }else{
            if(isTablet(context!!)  ){

                todayBtn.setOnClickListener {
                    myAdapter=MyNOteAdapter(context!!,currentList(taskList))
                    listNote.adapter=myAdapter
                }

                weekBtn.setOnClickListener {
                    myAdapter=MyNOteAdapter(context!!,weekList(taskList))
                    listNote.adapter=myAdapter
                }
                allBtn.setOnClickListener{
                    myAdapter=MyNOteAdapter(context!!,taskList)
                    listNote.adapter=myAdapter
                }
            }
            else{
                myAdapter=MyNOteAdapter(context!!,currentList(taskList))
                listNote.adapter=myAdapter
            }

        }


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



    private fun weekList(list:ArrayList<Note>):ArrayList<Note>{


        val cal = Calendar.getInstance()

        cal.setFirstDayOfWeek(Calendar.SUNDAY)

        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);


        val sunday=cal.time

        val nextSunday=Date(sunday.time+7*24*60*60*1000)

        val sdf = SimpleDateFormat("yy-MM-dd")




        var finalList=ArrayList<Note>()

        if(!list.isEmpty()){
            for (item in list){
                //after>0
                var after=dateMe.dayBetween(sdf.format(item.date)  ,sdf.format(sunday),dateMe.Type.jour)
                //before<0
                var before=dateMe.dayBetween(sdf.format(item.date)  ,sdf.format(nextSunday),dateMe.Type.jour)
                if((after >=0) and (before<0) )
                {

                    finalList.add(item)

                }
            }

        }

        return finalList
    }
    private fun currentList(list:ArrayList<Note>):ArrayList<Note>{
        val current: Date = Date()
        val sdf = SimpleDateFormat("yy-MM-dd")
        var finalList=ArrayList<Note>()

        if(!list.isEmpty()){
            for (item in list){
                if(sdf.format(item.date).equals(sdf.format(current)) )
                {
                    finalList.add(item)
                }
            }

        }

        return finalList
    }

    fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
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

            myview.deleat.setOnClickListener{
                taskList.remove(note)
                load()
            }

            //Toast.makeText(context,  sdf.format(note.date)+"**"+sdf.format(current), Toast.LENGTH_LONG).show()




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

