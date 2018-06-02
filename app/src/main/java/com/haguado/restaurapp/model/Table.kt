package com.haguado.restaurapp.model

data class Table (var number: Int, var meals: List<Meal>){
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