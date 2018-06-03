package com.haguado.restaurapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.haguado.restaurapp.R
import com.haguado.restaurapp.adapter.MealListAdapter
import com.haguado.restaurapp.model.Table
import kotlinx.android.synthetic.main.activity_table_detail.*


class TableDetailActivity : AppCompatActivity(){

    companion object {
        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context, table: Table): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(EXTRA_TABLE, table)
            return  intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        val table = intent.getSerializableExtra(EXTRA_TABLE) as Table


        val adapter = MealListAdapter(table.meals)
//        adapter.setTableMeals(table.meals)
        meal_list.adapter = adapter
        meal_list.layoutManager = LinearLayoutManager(this)


    }

    // INTERFACE IMPLEMENTATION
//    override fun onTableSelected(table: Table, position: Int) {
//        val intent =
//    }

}
