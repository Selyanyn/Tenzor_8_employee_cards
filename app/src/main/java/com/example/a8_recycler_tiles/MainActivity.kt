package com.example.a8_recycler_tiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel = MainActivityViewModel()

    private val employeesAdapter = EmployeeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_employee_list)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = employeesAdapter

        viewModel.employees.observe(this) {
            employeesAdapter.reload(it)
        }

        val addButton = findViewById<FloatingActionButton>(R.id.add_button)
        addButton.setOnClickListener {
            viewModel.addRandomEmployee()
        }
    }
}