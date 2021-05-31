package com.ankush.constraintlayout.ui.Dashboard

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.adapter.DishesAdapter
import com.ankush.constraintlayout.model.DishesModel
import com.ankush.constraintlayout.model.FoodResponse
import com.ankush.constraintlayout.model.FoodResponseItem
import com.ankush.constraintlayout.ui.fragments.CreateFoodFragment
import com.ankush.constraintlayout.ui.fragments.ShowFoodFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel:FoodViewModel
    private var dishesList = ArrayList<FoodResponseItem>()
    private lateinit var dishesAdapter: DishesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Foods"

       val showFoodFragment = ShowFoodFragment()
        val createFoodFragment = CreateFoodFragment()
        setCurrentFragment(showFoodFragment,true)
        fab_icon.setOnClickListener{
            title = "Create Food"
           setCurrentFragment(createFoodFragment,false)
        }
    }

    private fun setCurrentFragment(fragment: Fragment,showFabIcon:Boolean){
        if(showFabIcon){
            fab_icon.show()
        }else{
            fab_icon.hide()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
    }
}