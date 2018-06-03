package com.haguado.restaurapp.model

import java.io.Serializable

data class Table (var number: Int, var meals: MutableList<Meal>): Serializable{
    override fun toString() = "Mesa ${number}"
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