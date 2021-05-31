package com.ankush.constraintlayout.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.adapter.DishesAdapter
import com.ankush.constraintlayout.model.FoodResponseItem
import com.ankush.constraintlayout.ui.Dashboard.FoodViewModel
import kotlinx.android.synthetic.main.fragment_show_food.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowFoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowFoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivityViewModel:FoodViewModel
    private var dishesList = ArrayList<FoodResponseItem>()
    private lateinit var dishesAdapter: DishesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_show_food, container, false)
        prepareMovieData(view)
        return view
    }

    private fun prepareMovieData(view:View) {
        mainActivityViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        mainActivityViewModel.getFood(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGFlMjU1NjhiOWQzNDI2NTVmZmY5NDUiLCJlbWFpbCI6IlNob3AxQGdtYWlsLmNvbSIsImZvb2RUeXBlIjpbIlN3ZWV0Iiwic3BpY3kiXSwibmFtZSI6Ik5ldyBTaG9wIiwiaWF0IjoxNjIyMTgzNTk5LCJleHAiOjE2MjIyNjk5OTl9.11m0dije-V5C4MjL7Oti3ESk8Vuu8Sk2v9VwVLBxpQA")!!.observe(this,{

            for(item in it){
                dishesList.add(item)
            }
            dishesAdapter = DishesAdapter(dishesList)
            val layoutManager = LinearLayoutManager(view.context)
            view.recyclerView.layoutManager = LinearLayoutManager(activity)
            view.recyclerView.adapter = dishesAdapter
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowFoodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}