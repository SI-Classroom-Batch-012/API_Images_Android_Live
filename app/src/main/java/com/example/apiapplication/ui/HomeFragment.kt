package com.example.apiapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apiapplication.adapter.ItemAdapter
import com.example.apiapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel: DogViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ItemAdapter()
        binding.homeRecylcer.adapter = adapter
        viewModel.images.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.btSearch.setOnClickListener {
            val breed = binding.etBreed.text
            viewModel.searchImages(breed.toString())
            binding.etBreed.setText("")
        }

    }
}