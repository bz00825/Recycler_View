package com.example.recycler_view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.recycler_view.dummy.DummyContent.DummyItem

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [SuperHeroesFragment.OnListFragmentInteractionListener] interface.
 */
class SuperHeroesFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_superheroes_list, container, false)

        val names = arrayOf("Superman", "Spider-man”, “Wonder-woman”, “Thor”, “Black Panther”, “Batman”, “Cat”, “Invisible Woman”, “Iron man”, “Hulk”, “Aquaman")
        val powers = listOf(100, 90, 89, 92, 70)
        val genders = listOf("M", "M", "F", "M", "M")
        val superheroes = ArrayList<HashMap<String, Any>>()

        for(i in 0..names.size-1){
            val heroHashMap:HashMap<String, Any> = HashMap<String, Any>()

            heroHashMap.put("name", names[i])
            heroHashMap.put("powers", powers[i])
            heroHashMap.put("genders", genders[i])

            superheroes.add(heroHashMap)
        }

    // Set the adapter
    if (view is RecyclerView) {
        with(view) {
            layoutManager = LinearLayoutManager(context)
            adapter = MySuperHeroesRecyclerViewAdapter(activity as MainActivity, names)
        }
    }
    return view
}
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SuperHeroesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
