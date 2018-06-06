package com.haguado.restaurapp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import com.haguado.restaurapp.R
import com.haguado.restaurapp.adapter.TableListAdapter
import com.haguado.restaurapp.repository.TablesRepo
import kotlinx.android.synthetic.main.activity_table_list.*

class TableListActivity : AppCompatActivity() {

    private lateinit var adapter: TableListAdapter
    private val REQUEST_TABLE_DETAIL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_list)

        title = getString(R.string.tittle_label_table_list_activity)

        loadTables()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        loadTables()
        adapter.notifyDataSetChanged()
    }
    private fun loadTables(){
        adapter = TableListAdapter(this)
        table_list.adapter = adapter
        table_list.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, index, id ->
            val table = TablesRepo.getTable(index)
            val tableDetailActivity = TableDetailActivity.intent(this, table.number)
            startActivityForResult(tableDetailActivity, REQUEST_TABLE_DETAIL)
        }
    }

}

