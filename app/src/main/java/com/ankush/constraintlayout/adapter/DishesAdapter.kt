package com.ankush.constraintlayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.model.DishesModel
import com.ankush.constraintlayout.model.FoodResponse
import com.ankush.constraintlayout.model.FoodResponseItem

class DishesAdapter(private var moviesList: List<FoodResponseItem>) :
    RecyclerView.Adapter<DishesAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var year: TextView = view.findViewById(R.id.year)
        var genre: TextView = view.findViewById(R.id.genre)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dish_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.name
        holder.genre.text = movie.category
        holder.year.text = movie.description
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }
}
