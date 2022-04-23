package com.example.a8_recycler_tiles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val employees = MutableLiveData(listOf(
        Employee.getRandomMockEmployee(),
        Employee.getRandomMockEmployee(),
        Employee.getRandomMockEmployee()
    ))

    fun addRandomEmployee() {
        employees.value = employees.value?.toMutableList()?.apply {
            val randomEmployee = Employee.getRandomMockEmployee()
            add(randomEmployee)
        }
    }

    fun likeEmployee(id: Int) {
        employees.value = employees.value?.toMutableList()?.apply {
            (filter { it.id == id }).forEach { it.isLiked = !it.isLiked }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteEmployee(id: Int) {
        employees.value = employees.value?.toMutableList()?.apply {
            removeIf { it.id == id }
        }
    }
}