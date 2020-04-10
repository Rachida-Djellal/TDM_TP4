package com.example.tp4exo4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.ArrayList

class ListViewAdapter(
    // Declare Variables

    internal var mContext: Context
) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Seance>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(MainActivity.movieNamesArrayList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null

        internal var name1: TextView? = null
        internal var name2: TextView? = null
       // internal var image: ImageView? = null
    }

    override fun getCount(): Int {
        return MainActivity.movieNamesArrayList.size
    }

    override fun getItem(position: Int):Seance{
        return MainActivity.movieNamesArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.lv_item, null)
            // Locate the TextViews in listview_item.xml
            holder.name = view!!.findViewById(R.id.date) as TextView
            holder.name1 = view!!.findViewById(R.id.module) as TextView
            holder.name2= view!!.findViewById(R.id.salle) as TextView
           // holder.image = view!!.findViewById(R.id.image) as ImageView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.setText(MainActivity.movieNamesArrayList[position].getDateS())
        holder.name1!!.setText(MainActivity.movieNamesArrayList[position].getNameM())
        holder.name2!!.setText(MainActivity.movieNamesArrayList[position].getSalle())
      // holder.image!!.setImageResource(BlankFragment.movieNamesArrayList[position].getImage())

        return view
    }



}