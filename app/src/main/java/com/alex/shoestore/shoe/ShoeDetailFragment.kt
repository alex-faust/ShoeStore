package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeDetailFragmentBinding
import com.alex.shoestore.models.ShoeViewModel


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
        binding.shoeDetailConstraint.background.alpha = 75
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.detailToList())
        }


        viewModel.saveInfo.observe(viewLifecycleOwner) { saveTheInfo ->
            if (!saveTheInfo) {
                findNavController().navigate(ShoeDetailFragmentDirections.detailToList())
            } else {
                val name = binding.shoeNameInput.text.toString().trim()
                val size = binding.shoeSizeInput.text.toString().trim().toDouble()
                val company = binding.companyNameInput.text.toString().trim()
                val info = binding.shoeInfoInput.text.toString().trim()

                if (name == "" || company == "" || info == "") {
                    Toast.makeText(
                        this.activity, "Please enter all info",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    //viewModel.saveTheInfo()

                    val action = ShoeDetailFragmentDirections.detailToList()
                    findNavController().navigate(action)

                    viewModel.saveTheInfo()
                }
            }
        }

        /*binding.saveButton.setOnClickListener {
            val name = binding.shoeNameInput.text.toString().trim()
            val size = binding.shoeSizeInput.text.toString().trim().toDouble()
            val company = binding.companyNameInput.text.toString().trim()
            val info = binding.shoeInfoInput.text.toString().trim()

            if(name == "" || company == "" || info == ""){
                Toast.makeText(
                    this.activity, "Please enter all info",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.addShoe(name, size, company, info)

                val action = ShoeDetailFragmentDirections.detailToList()
                findNavController().navigate(action)
            }
        }*/

        return binding.root
    }
}