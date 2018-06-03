package com.haguado.restaurapp.dialog

import android.app.AlertDialog
import android.app.Dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import com.haguado.restaurapp.R
import com.haguado.restaurapp.model.Alergen
import com.haguado.restaurapp.model.Meal
import kotlinx.android.synthetic.main.dialog_meal.*
import kotlinx.android.synthetic.main.dialog_meal.view.*


class MealDialog(): DialogFragment(){
    companion object {
        val EXTRA_MEAL = "EXTRA_MEAL"
        fun newInstance(meal: Meal): MealDialog{
            val arguments = Bundle()
            arguments.putSerializable(EXTRA_MEAL, meal)
            val dialog = MealDialog()
            dialog.arguments = arguments
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_meal, null, false)
        val meal = arguments?.getSerializable(EXTRA_MEAL) as Meal
        with(meal){
            dialogView.meal_imageview.setImageResource(img)
            dialogView.number_name_label.text = "Nº ${number}: ${name}"
            dialogView.description_label.text = description
            dialogView.price_label.text = context?.getString(R.string.currency_format, price )

            if (Alergen.EGG in alergens){
                dialogView.icon_egg.visibility = View.VISIBLE
            }else{
                dialogView.icon_egg.visibility = View.GONE
            }

            if (Alergen.LACTOSE in alergens){
                dialogView.icon_lactose.visibility = View.VISIBLE
            }else{
                dialogView.icon_lactose.visibility = View.GONE
            }

            if (Alergen.GLUTEN in alergens){
                dialogView.icon_gluten.visibility = View.VISIBLE
            }else{
                dialogView.icon_gluten.visibility = View.GONE
            }

            if (Alergen.SOY in alergens){
                dialogView.icon_soy.visibility = View.VISIBLE
            }else{
                dialogView.icon_soy.visibility = View.GONE
            }

            if (Alergen.SHRIMP in alergens){
                dialogView.icon_shrimp.visibility = View.VISIBLE
            }else{
                dialogView.icon_shrimp.visibility = View.GONE
            }
        }

        return AlertDialog.Builder(context)
                .setView(dialogView)
                .setPositiveButton("Volver", { _, _ -> dismiss()})
                .create()
    }

}