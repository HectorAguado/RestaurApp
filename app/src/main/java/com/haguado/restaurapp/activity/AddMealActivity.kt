package com.haguado.restaurapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.haguado.restaurapp.R
import com.haguado.restaurapp.adapter.MealListAdapter
import com.haguado.restaurapp.repository.MenuMealsRepo
import kotlinx.android.synthetic.main.activity_add_meal.*

class AddMealActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context) = Intent(context, AddMealActivity::class.java)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_meal)

        val meals = MenuMealsRepo.getAllMenuMeals()
        val adapter = MealListAdapter(meals)
        adapter.onClickListener = View.OnClickListener {  }
        menu_meal_list.adapter = adapter
        menu_meal_list.layoutManager = LinearLayoutManager(this)
    }
}
