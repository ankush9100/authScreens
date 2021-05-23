package com.ankush.constraintlayout.ui

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.adapter.DishesAdapter
import com.ankush.constraintlayout.model.DishesModel

class DashboardActivity : AppCompatActivity() {
    private val dishesList = ArrayList<DishesModel>()
    private lateinit var dishesAdapter: DishesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "KotlinApp"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        dishesAdapter = DishesAdapter(dishesList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = dishesAdapter
        prepareMovieData()
    }

    private fun prepareMovieData() {
        var dish = DishesModel("Mad Max: Fury Road", "Action & Adventure", "2015")
        dishesList.add(dish)
         dish = DishesModel("Inside Out", "Animation, Kids & Family", "2015")
        dishesList.add(dish)
         dish = DishesModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        dishesList.add(dish)
        dish = DishesModel("The Martian", "Science Fiction & Fantasy", "2015")
        dishesList.add(dish)
        dish = DishesModel("The Martian", "Science Fiction & Fantasy", "2015")
        dishesList.add(dish)
        dish = DishesModel("The Martian", "Science Fiction & Fantasy", "2015")
        dishesList.add(dish)
        dish = DishesModel("The Martian", "Science Fiction & Fantasy", "2015")
        dishesList.add(dish)
        dish = DishesModel("The Martian", "Science Fiction & Fantasy", "2015")
        dishesList.add(dish)


//        movie = MovieModel("Inside Out", "Animation, Kids & Family", "2015")
//        movieList.add(movie)
//        movie = MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
//        movieList.add(movie)
//        movie = MovieModel("Shaun the Sheep", "Animation", "2015")
//        movieList.add(movie)
//        movie = MovieModel("The Martian", "Science Fiction & Fantasy", "2015")
//        movieList.add(movie)
//        movie = MovieModel("Mission: Impossible Rogue Nation", "Action", "2015")
//        movieList.add(movie)
//        movie = MovieModel("Up", "Animation", "2009")
//        movieList.add(movie)
//        movie = MovieModel("Star Trek", "Science Fiction", "2009")
//        movieList.add(movie)
//        movie = MovieModel("The LEGO MovieModel", "Animation", "2014")
//        movieList.add(movie)
//        movie = MovieModel("Iron Man", "Action & Adventure", "2008")
//        movieList.add(movie)
//        movie = MovieModel("Aliens", "Science Fiction", "1986")
//        movieList.add(movie)
//        movie = MovieModel("Chicken Run", "Animation", "2000")
//        movieList.add(movie)
//        movie = MovieModel("Back to the Future", "Science Fiction", "1985")
//        movieList.add(movie)
//        movie = MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981")
//        movieList.add(movie)
//        movie = MovieModel("Goldfinger", "Action & Adventure", "1965")
//        movieList.add(movie)
//        movie = MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
//        movieList.add(movie)
        dishesAdapter.notifyDataSetChanged()
    }
}