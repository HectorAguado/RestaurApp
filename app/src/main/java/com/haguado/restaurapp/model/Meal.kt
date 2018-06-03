package com.haguado.restaurapp.model

import java.io.Serializable

data class Meal (
        var number: Int,
        var name: String,
        var description: String,
        var price: Float,
        var alergens: List<Alergen>,
        var img: Int
): Serializable {


    override fun toString(): String {
        return "Nº: ${number} - ${name}"
    }
}