package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeDetailFragmentBinding
import com.alex.shoestore.models.Shoe
import com.alex.shoestore.models.ShoeViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: ShoeDetailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.save.observe(viewLifecycleOwner) { saveTheData ->
            Timber.i("save button was clicked in shoe detail")
            if (saveTheData) {
                findNavController().navigate(
                    ShoeDetailFragmentDirections.detailToList())
            }
        }

        binding.cancelButton.setOnClickListener {
            //Timber.i("JUMP cancel button was clicked in shoe detail")
            findNavController().navigate(ShoeDetailFragmentDirections.detailToList())
        }

        binding.saveButton.setOnClickListener {
            //Timber.i("JUMP save button was clicked in shoe detail")
            viewModel.addShoe(
                 binding.shoeNameInput.text.toString(),
                 binding.companyNameInput.text.toString(),
                 binding.shoeSizeInput.text.toString().toDouble(),
                 binding.shoeInfoInput.text.toString()
             )

            val action = ShoeDetailFragmentDirections.detailToList()
            findNavController().navigate(action)
        }

        return binding.root
    }
}