package com.haguado.restaurapp.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.haguado.restaurapp.R
import com.haguado.restaurapp.R.id.menu_meal_list
import com.haguado.restaurapp.activity.TableDetailActivity.Companion.EXTRA_TABLE_NUMBER
import com.haguado.restaurapp.adapter.MealListAdapter
import com.haguado.restaurapp.dialog.MealDialog
import com.haguado.restaurapp.repository.MenuMealsRepo
import com.haguado.restaurapp.repository.TablesRepo
import kotlinx.android.synthetic.main.activity_add_meal.*

class AddMealActivity : AppCompatActivity() {

    private val EXTRA_SENDER = 2
    private var tableNumber = 0

    companion object {
        val EXTRA_TABLE_NUMBER = "EXTRA_TABLE_NUMBER"
        fun intent(context: Context, tableNumber: Int): Intent {
            val intent = Intent(context, AddMealActivity::class.java)
            intent.putExtra(EXTRA_TABLE_NUMBER, tableNumber)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_meal)

        // Back Button
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = "Añadir nuevo plato"

        val meals = MenuMealsRepo.getAllMenuMeals()
        tableNumber = intent.getIntExtra(EXTRA_TABLE_NUMBER, 0)

        // Adapter
        val adapter = MealListAdapter(meals)
        // Al pulsar un elemento, mostramos en un AlertDialog el detalle del plato
        adapter.onClickListener = View.OnClickListener {
            val mealIndex = menu_meal_list.getChildAdapterPosition(it)
            val meal = MenuMealsRepo.getMealAt(mealIndex)
            val dialog = MealDialog.newInstance(meal.number, EXTRA_SENDER, tableNumber)
            dialog.show(this.supportFragmentManager, "meal_dialog")
        }

        menu_meal_list.adapter = adapter
        menu_meal_list.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        when (requestCode) {
//            EXTRA_SENDER -> {
//                if (resultCode == Activity.RESULT_OK && data != null) {
//                    val newMealNumber = data.getIntExtra(MealDialog.EXTRA_MEAL, 0)
//                    val newMeal = MenuMealsRepo.getMealByNumber(newMealNumber)
//                    newMeal?.let {
//                        TablesRepo.addMeal(tableNumber, newMeal)
//                        Toast.makeText(this, "Añadido ${newMeal.name} a Mesa ${tableNumber}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//
//    }
//}
//        adapter.onClickListener = View.OnClickListener {
//            val mealIndex = menu_meal_list.getChildAdapterPosition(it)
//            val meal = MenuMealsRepo.getMealAt(mealIndex)
//            // Dialog
//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle("Añadiendo ${meal.name} a mesa ${tablenumber}")
//            dialog.setMessage("¿Está seguro?")
//            dialog.setView(R.layout.dialog_meal)
//            dialog.setNegativeButton(android.R.string.cancel, null)
//            dialog.setPositiveButton(android.R.string.ok, { _, _ ->
//                TablesRepo.addMeal(tablenumber, meal)
//                Toast.makeText(this, "${meal.name} añadido a mesa ${tablenumber}", Toast.LENGTH_SHORT).show()
//                finish()
//            })
//            dialog.show()
//    }