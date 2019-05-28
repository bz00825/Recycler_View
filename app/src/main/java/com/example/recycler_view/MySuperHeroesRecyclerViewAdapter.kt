package com.example.recycler_view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


import com.example.recycler_view.SuperHeroesFragment.OnListFragmentInteractionListener
import com.example.recycler_view.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_superheroes.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MySuperHeroesRecyclerViewAdapter(
    private val activity: MainActivity,
    private val mValues: Array<String>
) : RecyclerView.Adapter<MySuperHeroesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_superheroes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mValues[position]

        holder.mContentView.text = item

        holder.mView.setOnClickListener {
            Toast.makeText(activity, item, Toast.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.content
    }
}
