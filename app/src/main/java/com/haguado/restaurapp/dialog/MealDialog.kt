package com.haguado.restaurapp.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.haguado.restaurapp.R
import com.haguado.restaurapp.activity.AddMealActivity
import com.haguado.restaurapp.model.Alergen
import com.haguado.restaurapp.model.Meal
import com.haguado.restaurapp.model.Table
import com.haguado.restaurapp.repository.MenuMealsRepo
import com.haguado.restaurapp.repository.TablesRepo
import kotlinx.android.synthetic.main.dialog_meal.*
import kotlinx.android.synthetic.main.dialog_meal.view.*


class MealDialog(): DialogFragment(){
    companion object {
        val EXTRA_MEAL_NUMBER = "EXTRA_MEAL_NUMBER"
        val EXTRA_TABLE_NUMBER = "EXTRA_TABLE_NUMBER"
        val EXTRA_SENDER_CODE = "EXTRA_SENDER_CODE"
        fun newInstance(mealNumber: Int, senderCode: Int): MealDialog{
            val arguments = Bundle()
            arguments.putInt(EXTRA_SENDER_CODE, senderCode)
            arguments.putInt(EXTRA_MEAL_NUMBER, mealNumber)
            val dialog = MealDialog()
            dialog.arguments = arguments
            return dialog
        }
        fun newInstance(mealNumber: Int, senderCode: Int, tablenumber: Int): MealDialog{
            val arguments = Bundle()
            arguments.putInt(EXTRA_SENDER_CODE, senderCode)
            arguments.putInt(EXTRA_MEAL_NUMBER, mealNumber)
            arguments.putInt(EXTRA_TABLE_NUMBER, tablenumber)
            val dialog = MealDialog()
            dialog.arguments = arguments
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_meal, null, false)
        val mealNumber = arguments?.getInt(EXTRA_MEAL_NUMBER)
        val meal = mealNumber?.let { MenuMealsRepo.getMealByNumber(it) }
        meal?.let {
            // SetUp UI
            with(meal){
                dialogView.meal_imageview.setImageResource(img)
                dialogView.number_name_label.text = "Nº ${number}: ${name}"
                dialogView.description_label.text = description
                dialogView.price_label.text = context?.getString(R.string.currency_format, price )
                setUpAlergens(dialogView, alergens)
            }

            val senderCode = arguments?.getInt(EXTRA_SENDER_CODE,1)

            if (senderCode == 1 ) {
                return AlertDialog.Builder(context)
                        .setView(dialogView)
                        .setPositiveButton("Volver", { _, _ -> dismiss() })
                        .create()
            }else{
                val tableNumber = arguments?.getInt(EXTRA_TABLE_NUMBER, 0)
                tableNumber?.let {
                    return AlertDialog.Builder(context)
                            .setView(dialogView)
                            .setTitle("Añadiendo ${meal.name} a Mesa ${tableNumber}")
                            .setPositiveButton("Añadir", { _, _ ->
                                TablesRepo.addMeal(tableNumber, meal)
                                Toast.makeText(activity, "Añadido ${meal.name} a Mesa ${tableNumber}", Toast.LENGTH_SHORT).show()
                            })
                            .setNegativeButton(android.R.string.cancel, { _, _ ->  cancelAddMeal()})
                            .create()
                }
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    fun setUpAlergens(view: View, alergens: List<Alergen>){
        if (Alergen.EGG in alergens){
            view.icon_egg.visibility = View.VISIBLE
        }else{
            view.icon_egg.visibility = View.GONE
        }

        if (Alergen.LACTOSE in alergens){
            view.icon_lactose.visibility = View.VISIBLE
        }else{
            view.icon_lactose.visibility = View.GONE
        }

        if (Alergen.GLUTEN in alergens){
            view.icon_gluten.visibility = View.VISIBLE
        }else{
            view.icon_gluten.visibility = View.GONE
        }

        if (Alergen.SOY in alergens){
            view.icon_soy.visibility = View.VISIBLE
        }else{
            view.icon_soy.visibility = View.GONE
        }

        if (Alergen.SHRIMP in alergens){
            view.icon_shrimp.visibility = View.VISIBLE
        }else{
            view.icon_shrimp.visibility = View.GONE
        }
    }
    private fun cancelAddMeal() {
        // Indicamos que cancelamos el envío de datos
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_CANCELED, null)
        dismiss()
    }
    private fun acceptAddMeal(meal: Meal) {
        // Creamos los datos de regreso
        val returnIntent = Intent()
        returnIntent.putExtra(EXTRA_MEAL_NUMBER, meal.number)
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, returnIntent)
//        dismiss()
//        setResult(Activity.RESULT_OK, returnIntent)
//        finish()
    }
}