package com.example.a8_recycler_tiles

import androidx.recyclerview.widget.DiffUtil

class EmployeesDiffUtilCallback(
    val newList: List<Employee>,
    val oldList: List<Employee>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].fullName == newList[newItemPosition].fullName
                && oldList[oldItemPosition].department == newList[newItemPosition].department
                && oldList[oldItemPosition].photoUrl == newList[newItemPosition].photoUrl
                && oldList[oldItemPosition].isLiked == newList[newItemPosition].isLiked
    }
}