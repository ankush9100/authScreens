package com.ankush.constraintlayout.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.ui.Dashboard.AddFoodViewModel
import kotlinx.android.synthetic.main.fragment_create_food.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateFoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateFoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivityViewModel:AddFoodViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_food, container, false)
            btn_sub?.setOnClickListener { view ->
              Log.e("TAGS","Clicked")

//               addFoodItem(view)
            }
        return view
    }

    private fun addFoodItem(view:View){
        mainActivityViewModel = ViewModelProvider(this).get(AddFoodViewModel::class.java)
        var imageList = ArrayList<String>()
        imageList.add(" ")
        var name = edit_foodName.text.toString()
        var description = edit_description.text.toString()
        var categroy = edit_category.text.toString()
        var foodType = edit_foodType.text.toString()
        var price = Integer.parseInt(edit_price.text.toString())
        var readyTime = Integer.parseInt(edit_readyTime.text.toString())
        var images = imageList
        var token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGFlMjU1NjhiOWQzNDI2NTVmZmY5NDUiLCJlbWFpbCI6IlNob3AxQGdtYWlsLmNvbSIsImZvb2RUeXBlIjpbIlN3ZWV0Iiwic3BpY3kiXSwibmFtZSI6Ik5ldyBTaG9wIiwiaWF0IjoxNjIyMTgzNTk5LCJleHAiOjE2MjIyNjk5OTl9.11m0dije-V5C4MjL7Oti3ESk8Vuu8Sk2v9VwVLBxpQA"
        mainActivityViewModel.addNewFood(name,description,categroy,foodType,price,readyTime,images,token)!!.observe(viewLifecycleOwner,{
            Toast.makeText(view.context,it.category,Toast.LENGTH_LONG).show()

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateFoodFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                CreateFoodFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}