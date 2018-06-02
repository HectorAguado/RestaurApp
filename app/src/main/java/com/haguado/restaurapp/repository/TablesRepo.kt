package com.haguado.restaurapp.repository

import com.haguado.restaurapp.R
import com.haguado.restaurapp.model.Meal
import com.haguado.restaurapp.model.Table

object TablesRepo {
    private val tables: List<Table> = fillRestaurantTebles()

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()

    private fun fillRestaurantTebles(): List<Table>{
        val numberOfTables = 6
        val tables: List<Table> = (1..numberOfTables).map {
            intToTable(it)
        }.toList()
        return tables
    }

    private fun intToTable(int: Int): Table {
        return Table(int, listOf(Meal(1,"", "", 0.00f, listOf(), R.drawable.picadillo)))
    }

}