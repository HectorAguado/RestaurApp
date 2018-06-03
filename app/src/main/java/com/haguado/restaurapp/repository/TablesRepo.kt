package com.haguado.restaurapp.repository

import com.haguado.restaurapp.R
import com.haguado.restaurapp.model.Alergen
import com.haguado.restaurapp.model.Meal
import com.haguado.restaurapp.model.Table

object TablesRepo {
    private val tables: List<Table> = fillRestaurantTebles()

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()

    private fun fillRestaurantTebles(): List<Table>{
        val numberOfTables = 12
        val tables: List<Table> = (1..numberOfTables).map {
            intToTable(it)
        }.toList()
        return tables
    }

    private fun intToTable(int: Int): Table {
        return Table(int, mutableListOf(
                Meal(int, "Mi plato se llama ${int}",
                        "Descripción del plato ${int}",
                        10f,
                        listOf(Alergen.LACTOSE, Alergen.SHRIMP,Alergen.EGG),
                        R.drawable.ponche),
                Meal(int, "Mi plato se llama ${int}",
                        "Descripción del plato ${int}",
                        10.50f,
                        listOf(Alergen.GLUTEN, Alergen.SOY,Alergen.EGG),
                        R.drawable.picadillo))
                )
    }

}