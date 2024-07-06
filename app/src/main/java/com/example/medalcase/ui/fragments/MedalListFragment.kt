package com.example.medalcase.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.medalcase.R
import com.example.medalcase.databinding.FragmentMedalListBinding
import com.example.medalcase.ui.adapters.GridAdapter
import com.example.medalcase.ui.viewmodels.MedalListViewModel


class MedalListFragment : Fragment() {

    private var _binding: FragmentMedalListBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMedalListBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewModel = ViewModelProvider(this).get(
            MedalListViewModel::class.java
        )
        binding.medalListViewModel = viewModel
        binding.lifecycleOwner = this

        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when ((binding.recyclerview.adapter as GridAdapter).getItemViewType(position)) {
                    GridAdapter.VIEW_TYPE_HEADER -> 2
                    GridAdapter.VIEW_TYPE_ITEM -> 1
                    else -> -1
                }
            }
        }

        viewModel.list.observe(viewLifecycleOwner){
            val adapter = GridAdapter(it)
            binding.recyclerview.layoutManager = layoutManager
            binding.recyclerview.adapter = adapter

        }

    return view
    }


}