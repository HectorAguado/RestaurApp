package com.haguado.restaurapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.Toast
import com.haguado.restaurapp.R
import com.haguado.restaurapp.adapter.TableListAdapter
import com.haguado.restaurapp.model.Table
import com.haguado.restaurapp.repository.TablesRepo
import kotlinx.android.synthetic.main.activity_table_list.*

class TableListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_list)


        table_list.adapter = TableListAdapter(this)
        table_list.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, index, id ->
            val table = TablesRepo.getTable(index)
            val tableDetailActivity = TableDetailActivity.intent(this, table)
            startActivity(tableDetailActivity)
        }


    }


}

