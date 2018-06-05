package com.haguado.restaurapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.haguado.restaurapp.R
import com.haguado.restaurapp.repository.TablesRepo
import com.haguado.restaurapp.model.Table

class TableListAdapter(context: Context): BaseAdapter() {

    private var innerContext = context
    // PROPERTIES
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // BASE ADAPTER METHODS
    override fun getItem(position: Int): Any {
        return TablesRepo.getTable(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return TablesRepo.count
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ListRowHolder
        val table = TablesRepo.getTable(position)
        if (convertView == null) {
            view = this.mInflater.inflate(R.layout.view_table_list_item, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.numberLabel?.text = String.format(innerContext.getString(R.string.table_format), table.number)
        if (table.meals.isEmpty()) {
            vh.tableImage?.setImageResource(R.drawable.table_off)
            vh.isEmptyLabel?.text = "está libre"
        }else{
            vh.tableImage?.setImageResource(R.drawable.table_on)
            vh.isEmptyLabel?.text = "contiene ${table.meals.size} comandas"
        }
        return view
    }

    private class ListRowHolder(row: View?) {
        val tableImage = row?.findViewById<ImageView>(R.id.table_imageview)
        val numberLabel = row?.findViewById<TextView>(R.id.table_number_textview)
        val isEmptyLabel = row?.findViewById<TextView>(R.id.table_is_empty_textView)
    }

}