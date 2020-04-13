package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

import java.util.ArrayList
import java.util.Locale

class ListViewAdapter(
    // Declare Variables

    internal var mContext: Context
) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<LivreN>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(BlankFragment.LivreNamesArrayList)
    }

    inner class ViewHolder {
        internal var name: TextView? = null

       internal var name1: TextView? = null

        internal var image: ImageView? = null
    }

    override fun getCount(): Int {
        return BlankFragment.LivreNamesArrayList.size
    }

    override fun getItem(position: Int):LivreN {
        return BlankFragment.LivreNamesArrayList[position]
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
           holder.name = view!!.findViewById(R.id.image_name2) as TextView
            holder.name1 = view!!.findViewById(R.id.textView) as TextView
            holder.image = view!!.findViewById(R.id.image) as ImageView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.setText(BlankFragment.LivreNamesArrayList[position].payName)
        holder.name1!!.setText(BlankFragment.LivreNamesArrayList[position].image_name)
        holder.image!!.setImageResource(BlankFragment.LivreNamesArrayList[position].image)

        return view
    }



}