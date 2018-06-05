package com.haguado.restaurapp.repository

import com.haguado.restaurapp.model.Meal
import com.haguado.restaurapp.model.Table

object TablesRepo {
    private val tables: List<Table> = fillRestaurantTebles()

    val count
        get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun getTableIndex(table: Table) = tables.indexOf(table)

    fun getTableByNumber(number: Int): Table? {
        return tables.find {
            it.number == number
        }
    }
//        tables.forEach {
//            if (it.number == number)
//                return it
//        }
//        return null
//    }

    fun addMeal(tableNumber: Int, meal: Meal){
        val table = getTableByNumber(tableNumber)
        table?.let {
         table.meals.add(meal)
        }
    }

    fun toArray() = tables.toTypedArray()

    private fun fillRestaurantTebles(): List<Table>{
        val numberOfTables = 4
        val tables: List<Table> = (1..numberOfTables).map {
            intToTable(it)
        }.toList()
        return tables
    }

    private fun intToTable(int: Int): Table {
        return Table(int, mutableListOf(
//                Meal(int, "Mi plato se llama ${int}",
//                        "Descripción del plato ${int}",
//                        10f,
//                        listOf(Alergen.LACTOSE, Alergen.SHRIMP,Alergen.EGG),
//                        R.drawable.ponche),
//                Meal(int, "Mi plato se llama ${int}",
//                        "Descripción del plato ${int}",
//                        10.50f,
//                        listOf(Alergen.GLUTEN, Alergen.SOY,Alergen.EGG),
//                        R.drawable.picadillo)
                    )
                )
    }

}