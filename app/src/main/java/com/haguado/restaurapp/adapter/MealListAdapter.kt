package com.haguado.restaurapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.haguado.restaurapp.R
import com.haguado.restaurapp.model.Alergen
import com.haguado.restaurapp.model.Meal

class MealListAdapter(private val meals: MutableList<Meal>): RecyclerView.Adapter<MealListAdapter.MealViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder{
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_meal_list_item, parent, false)
        view.setOnClickListener(onClickListener)
        return MealViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder:MealViewHolder, position: Int) {
        holder.bindMealItem(meals[position])
    }

//    fun setTableMeals(meals: MutableList<Meal>){
//        meals.clear()
//        meals.addAll(meals)
//        notifyDataSetChanged()
//    }

    inner class MealViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mealImage = itemView.findViewById<ImageView>(R.id.meal_imageview)
        val numberAndName = itemView.findViewById<TextView>(R.id.number_name_label)
        val price = itemView.findViewById<TextView>(R.id.price_label)
        val context = itemView.context
        val iconEgg = itemView.findViewById<ImageView>(R.id.icon_egg)
        val iconLactose = itemView.findViewById<ImageView>(R.id.icon_lactose)
        val iconGluten = itemView.findViewById<ImageView>(R.id.icon_gluten)
        val iconSoy = itemView.findViewById<ImageView>(R.id.icon_soy)
        val iconShrimp = itemView.findViewById<ImageView>(R.id.icon_shrimp)

        fun bindMealItem(meal: Meal){
            mealImage?.setImageResource(meal.img)
            numberAndName?.text = meal.toString()
            price?.text = context.getString(R.string.currency_format,meal.price)
            setAlergenIcons(meal.alergens)
        }
        private fun setAlergenIcons(alergens: List<Alergen>){

            if (Alergen.EGG in alergens){
                iconEgg?.visibility = View.VISIBLE
            }else{
                iconEgg?.visibility = View.GONE
            }

            if (Alergen.LACTOSE in alergens){
                iconLactose?.visibility = View.VISIBLE
            }else{
                iconLactose?.visibility = View.GONE
            }

            if (Alergen.GLUTEN in alergens){
                iconGluten?.visibility = View.VISIBLE
            }else{
                iconGluten?.visibility = View.GONE
            }

            if (Alergen.SOY in alergens){
                iconSoy?.visibility = View.VISIBLE
            }else{
                iconSoy?.visibility = View.GONE
            }

            if (Alergen.SHRIMP in alergens){
                iconShrimp?.visibility = View.VISIBLE
            }else{
                iconShrimp?.visibility = View.GONE
            }
        }
    }
}