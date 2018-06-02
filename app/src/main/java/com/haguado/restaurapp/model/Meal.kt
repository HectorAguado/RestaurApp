package com.haguado.restaurapp.model

data class Meal (var number: Int, var name: String, var description: String, var price: Float, var alergens: List<Alergen>, var img: Int) {
}