package com.example.b3sync.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.b3sync.R
import com.example.b3sync.model.Affirmation

/**
 * adapter will receive the data[affirmations]
 * and adapt it each row of the recyclerview
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
var TAG = ItemAdapter::class.java.simpleName




    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //Log.i(TAG,"chirag received an row plank")

        val tvTitle: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
         Log.i(TAG,"rakshit bought a row plank from market")
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)

    }

    override fun getItemCount(): Int {
        Log.i(TAG,"aditya counting no of items ="+dataset.count())
        return  dataset.count()
    }

    override fun onBindViewHolder(chiragHolder: ItemViewHolder, position: Int) {
        Log.i(TAG,"varshita got a row plank from chirag and she's writing --"+dataset[position])
        val item = dataset[position]

        chiragHolder.tvTitle.text = context.resources.getString(item.stringResourceId)

    }

}