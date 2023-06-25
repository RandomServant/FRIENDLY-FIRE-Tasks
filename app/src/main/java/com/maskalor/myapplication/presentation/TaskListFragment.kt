package com.maskalor.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maskalor.myapplication.databinding.FragmentTaskListBinding
import com.maskalor.myapplication.domain.models.Task


class TaskListFragment(private val taskListId: Int) : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var viewModel: TaskListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TaskListViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TaskListAdapter()

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.list.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        adapter.onClick = {
            startActivity(context?.let { it1 ->
                TaskActivity.getIntent(it1, it.taskListId, "false", it.id) })
        }

        adapter.onLongClick = { task: Task, pos: Int ->
            viewModel.changeFavoriteState(task)
            adapter.update(pos)
            update()
            true
        }

        update()
    }

    override fun onResume() {
        super.onResume()

        update()
    }

    private fun update() {
        if (taskListId == 1)
            viewModel.getFavoriteTasksFromTaskList()
        else
            viewModel.getTasksFromTaskList(taskListId)
    }
}