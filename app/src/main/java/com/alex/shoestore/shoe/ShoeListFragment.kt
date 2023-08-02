package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeListFragmentBinding
import com.alex.shoestore.models.Shoe
import com.alex.shoestore.models.ShoeViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment,
            container, false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this


        binding.container.removeAllViews()

        val lin: LinearLayout = binding.container
        val view: View? = View.inflate(this.activity, R.layout.shoe_item, null)
        //lin.addView(view)

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->

            //update the ui
            shoeList.forEach { shoeModel ->
                shoeModel.name = "he"
                shoeModel.company = "ni"
                shoeModel.size = 4.0
                shoeModel.description = "eef"

                //R.id.companyNameResult1 =
                lin.addView(view)

            }


            //binding.container.removeAllViews()
            Timber.i("JUMP shoe list observer observed")

            //val lin: LinearLayout = binding.container
            //val view: View? = View.inflate(this.activity, R.layout.shoe_item, null)
            //val shoeName: String = view?.resources?.getResourceTypeName(R.id.shoeNameInput).toString()

            //lin.addView(view)

           /* for (shoe in viewModel.shoeList.value!!) {
                //viewModel.addShoeVM(shoeName, 0.0, "", "")
                //addShoeSL(Shoe(shoeName, 0.0, "", ""))

                lin.addView(view)
            }*/
        }


        binding.fab.setOnClickListener {
            Timber.i("JUMP button clicked")
            lin.addView(view)
            findNavController().navigate(ShoeListFragmentDirections.listToDetail())

        }

        val ln: LinearLayout

        return binding.root
    }

    fun addShoeSL(shoe: Shoe) {
        val view = layoutInflater.inflate(R.layout.shoe_item, null)
        //view.

        //val shoe: Shoe = Shoe(viewModel.addShoeVM(view.compan))
        //view.
        //binding.listLinearLayoutId.addView(view)

    }
}