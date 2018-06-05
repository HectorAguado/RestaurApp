package com.haguado.restaurapp.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.haguado.restaurapp.R
import com.haguado.restaurapp.adapter.MealListAdapter
import com.haguado.restaurapp.dialog.MealDialog
import com.haguado.restaurapp.model.Table
import com.haguado.restaurapp.repository.TablesRepo
import kotlinx.android.synthetic.main.activity_table_detail.*
import kotlinx.android.synthetic.main.view_table_header.*


class TableDetailActivity : AppCompatActivity(){

    private val REQUEST_ADD_MEAL = 1
    private val EXTRA_SENDER = 1
    private lateinit var table: Table
    companion object {
        val EXTRA_TABLE_NUMBER = "EXTRA_TABLE_NUMBER"

        fun intent(context: Context, tableNumber: Int): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(EXTRA_TABLE_NUMBER, tableNumber)
            return  intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        // Back Button
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val tableNumber = intent.getIntExtra(EXTRA_TABLE_NUMBER, 1)
        table = TablesRepo.getTableByNumber(tableNumber)!!

        table?.let {
            title = String.format(getString(R.string.table_format), tableNumber)
            loadTable()

            // Add Button
            add_meal_button.setOnClickListener {
                val addMealActivity = AddMealActivity.intent(this, table.number)
                startActivityForResult(addMealActivity, REQUEST_ADD_MEAL)
            }
         }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loadTable()
    }

    private fun loadTable(){
        // Adaptador
        val adapter = MealListAdapter(table.meals)
        // Al pulsar un elemento, mostramos en un AlertDialog el detalle del plato
        adapter.onClickListener = View.OnClickListener {
            val mealIndex = meal_list.getChildAdapterPosition(it)
            val meal = table.meals[mealIndex]
            val dialog = MealDialog.newInstance(meal.number, EXTRA_SENDER, table.number)
            dialog.show(this.supportFragmentManager, "meal_dialog")
        }
        meal_list.adapter = adapter
        meal_list.layoutManager = LinearLayoutManager(this)
        setupHeader()
    }

    private fun setupHeader(){

        total_meal_label.text = table.meals.size.toString()
        val totalCost = table.tableTotalCost()
        total_cost_label.text = resources.getString(R.string.currency_format, totalCost)
        if (table.meals.isEmpty()) {
            table_imageview.setImageResource(R.drawable.table_off)

        }else{
            table_imageview.setImageResource(R.drawable.table_on)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.table_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                this.onBackPressed()
                return true
            }
            R.id.menu_calculate -> {

                val total = table.tableTotalCost()
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Total:")
                    .setMessage(String.format(getString(R.string.currency_format), total))
                        .setIcon(R.drawable.ic_payment)
                    .setPositiveButton("Ok"){_, _ -> /** Do nothing */ }.create()
                dialog.show()
                return true
            }
            R.id.menu_delete -> {
                table.clearTable()

                loadTable()
                val contentLayout = findViewById<View>(android.R.id.content)
                Snackbar.make(contentLayout, "Se han borrado todos los platos", Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
