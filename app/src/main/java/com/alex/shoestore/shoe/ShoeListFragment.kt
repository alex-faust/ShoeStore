package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeItemBinding
import com.alex.shoestore.databinding.ShoeListFragmentBinding
import com.alex.shoestore.models.Shoe
import com.alex.shoestore.models.ShoeViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment,
            container, false)

        binding.shoeViewModel = viewModel
        //binding.lifecycleOwner = this




        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            binding.container.removeAllViews()
            //update the ui

            for (shoe in viewModel.shoeList.value!!) {
                addShoe(shoe)
            }

            /*setFragmentResultListener("requestKey") { requestKey, bundle ->
                val result = bundle.getString("bundleKey")
                Timber.i("HERE IS fragment result and result is $result")
            }

            var shoeName = view?.findViewById<TextView>(R.id.shoeNameResult)?.text
            var company = view?.findViewById<TextView>(R.id.companyNameResult)?.text
            //var shoeSize = view?.findViewById<TextView>(R.id.shoeSizeResult)?.text.toString().toDouble()
            var shoeInfo = view?.findViewById<TextView>(R.id.shoeInfoResult)?.text

            Timber.i("HERE IS views text $shoeName, $company, $shoeInfo")

            shoeList.forEach { shoeModel ->
                shoeName = shoeModel.name
                company = shoeModel.company
                //shoeSize = 4.0
                shoeInfo = shoeModel.description

                Timber.i("HERE IS shoeModel text $shoeName, $company, $shoeInfo")

                //addShoe(Shoe(shoeName, 4.0, company, shoeInfo))

            } */


            //binding.container.removeAllViews()
            Timber.i("HERE IS shoe list observer observed")


        }

        binding.fab.setOnClickListener {
            Timber.i("HERE IS button clicked")
            findNavController().navigate(ShoeListFragmentDirections.listToDetail())
        }

        return binding.root
    }

    fun addShoe(shoe: Shoe) {
        val lin: LinearLayout = binding.container
        val view: View? = View.inflate(this.activity, R.layout.shoe_item, null)

        //val secondBinding = ShoeItemBinding.inflate(layoutInflater)



        view?.findViewById<TextView>(R.id.shoeNameResult)?.text = shoe.name
        view?.findViewById<TextView>(R.id.shoeSizeResult)?.text = shoe.size.toString()
        view?.findViewById<TextView>(R.id.companyNameResult)?.text = shoe.company
        view?.findViewById<TextView>(R.id.shoeInfoResult)?.text = shoe.description

        lin.addView(view)

    }
}