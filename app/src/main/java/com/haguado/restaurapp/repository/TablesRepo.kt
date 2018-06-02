package com.haguado.restaurapp.repository

import com.haguado.restaurapp.R
import com.haguado.restaurapp.model.Table

object TablesRepo {
    private var tables: List<Table> = fillRestaurantTebles()

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    private fun fillRestaurantTebles(): List<Table>{
        val numberOfTables = 6
        val tables: List<Table> = (1..numberOfTables).map {
            intToTable(it)
        }.toList()
        return tables
    }

    private fun intToTable(int: Int): Table {
        return Table(int, listOf())
    }
}