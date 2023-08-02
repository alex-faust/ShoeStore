package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeDetailFragmentBinding
import com.alex.shoestore.models.Shoe
import com.alex.shoestore.models.ShoeViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener{
            findNavController().navigate(ShoeDetailFragmentDirections.detailToList())
        }

        binding.saveButton.setOnClickListener {
            viewModel.addShoe(
                binding.shoeNameInput.text.toString(),
                binding.shoeSizeInput.text.toString().toDouble(),
                binding.companyNameInput.text.toString(),
                binding.shoeInfoInput.text.toString()
            )
            val action = ShoeDetailFragmentDirections.detailToList()
            findNavController().navigate(action)
        }

        return binding.root
    }
}