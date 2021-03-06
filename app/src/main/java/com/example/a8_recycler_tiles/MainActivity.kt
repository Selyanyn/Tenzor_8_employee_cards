package com.example.a8_recycler_tiles

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    //если ломается 37 минута
    private lateinit var employeesAdapter : EmployeeAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_employee_list)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        employeesAdapter = EmployeeAdapter(viewModel::deleteEmployee,
                                            viewModel::likeEmployee)
        recyclerView.adapter = employeesAdapter

        val colorDrawable = ColorDrawable(0xFFFF00FF.toInt())
        val deco = DividerItemDecoration(recyclerView.context,
            DividerItemDecoration.HORIZONTAL)
        deco.setDrawable(colorDrawable)
        recyclerView.addItemDecoration(deco)

        val decoVertical = DividerItemDecoration(recyclerView.context,
            DividerItemDecoration.VERTICAL)
        decoVertical.setDrawable(colorDrawable)
        recyclerView.addItemDecoration(decoVertical)

        viewModel.employees.observe(this) {
            employeesAdapter.reload(it)
        }

        val addButton = findViewById<FloatingActionButton>(R.id.add_button)
        addButton.setOnClickListener {
            viewModel.addRandomEmployee()
        }
    }
}