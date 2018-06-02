package com.haguado.restaurapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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


//        city_list.setOnItemClickListener {
//            _, _, index, _ ->  // adapterView, view, index, l ->  // los atributos que no interesan los sustituimos por _
//            // Avisamos al listener que una ciudad ha sido seleccionada
//            onCitySelectedListener?.onCitySelected(Cities[index], index)
//        }

    }


}

