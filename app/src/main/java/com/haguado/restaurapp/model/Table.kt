package com.haguado.restaurapp.model

import java.io.Serializable

data class Table (var number: Int, var meals: MutableList<Meal>): Serializable{

    fun tableTotalCost(): Float{
        var total = 0.00
        meals.forEach {
            total += it.price
        }
        return total.toFloat()
    }
    fun clearTable(){
        meals = mutableListOf()
    }
    fun removeMeal(meal: Meal){
        var lista = meals
        meals.remove(meal)
        lista = meals
    }

//    override fun toString(): String {
//        var string = ""
//        if (meals.isEmpty()) {
//          string = "Esta Libre"
//        }else {
//          string = "Esta ocupada"
//        }
//
//        return "Mesa ${number} - ${string}"
//    }
}