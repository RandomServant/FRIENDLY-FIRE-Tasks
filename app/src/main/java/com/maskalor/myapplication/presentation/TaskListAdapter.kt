package com.maskalor.myapplication.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.maskalor.myapplication.R
import com.maskalor.myapplication.domain.models.Task

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.MyViewHolder>(MyDiffUtil()) {

    var onClick: ((Task) -> Unit)? = null
    var onLongClick: ((Task, Int) -> Boolean)? = null

    class MyViewHolder(view: View) : ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = when(viewType) {
            DEFAULT_TYPE -> {
                R.layout.task_layout
            }
            FAVORITE_TYPE -> {
                R.layout.favourite_task_layout
            }
            else -> {
                R.layout.task_layout
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when(currentList[position].isFavorite) {
            false -> {
                DEFAULT_TYPE
            }
            else -> {
                FAVORITE_TYPE
            }
        }

    }

    fun update(pos: Int) {
        notifyItemChanged(pos)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = currentList[position].name

        holder.itemView.setOnClickListener {
            onClick?.invoke(currentList[position])
        }

        holder.itemView.setOnLongClickListener{
            onLongClick?.invoke(currentList[position], position)
            true
        }
    }

    companion object {
        private const val FAVORITE_TYPE = 101
        private const val DEFAULT_TYPE = 102
    }
}