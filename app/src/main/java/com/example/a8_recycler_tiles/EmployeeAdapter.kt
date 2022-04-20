package com.example.a8_recycler_tiles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EmployeeAdapter(private val deleteAction: (Int) -> Unit): RecyclerView.Adapter<EmployeeAdapter.EmployeesViewHolder>() {
    class EmployeesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val photoImageView: ImageView = itemView.findViewById(R.id.photo)
        val departmentTextView: TextView = itemView.findViewById(R.id.department)
        val deleteButtonView: Button = itemView.findViewById(R.id.delete_button)
    }

    private val employeesList = mutableListOf<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.EmployeesViewHolder {
        val employeeElement = LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        return EmployeesViewHolder(employeeElement)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.EmployeesViewHolder, position: Int) {
        val employee = employeesList[position]
        with(holder) {
            nameTextView.text = employee.fullName
            departmentTextView.text = employee.department

            Glide.with(photoImageView.context)
                .load(employee.photoUrl)
                .centerCrop()
                .into(photoImageView)

            deleteButtonView.setOnClickListener {
                deleteAction(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return employeesList.size
    }

    fun reload(data: List<Employee>) {
        employeesList.clear()
        employeesList.addAll(data)
        notifyDataSetChanged()
    }

}