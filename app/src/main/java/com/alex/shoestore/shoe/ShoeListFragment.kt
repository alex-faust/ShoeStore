package com.alex.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.alex.shoestore.R
import com.alex.shoestore.databinding.ShoeListFragmentBinding
import com.alex.shoestore.models.Shoe
import com.alex.shoestore.models.ShoeViewModel


class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment,
            container, false
        )

        binding.shoeViewModel = viewModel

        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.container.removeAllViews()

            for (shoe in viewModel.shoeList.value!!) {
                addShoe(shoe)
            }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.listToDetail())
        }

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(false)
        setHasOptionsMenu(false)
        return binding.root
    }
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun addShoe(shoe: Shoe) {
        val lin: LinearLayout = binding.container
        val view: View? = View.inflate(this.activity, R.layout.shoe_item, null)

        view?.findViewById<TextView>(R.id.shoeNameResult)?.text = shoe.name
        view?.findViewById<TextView>(R.id.shoeSizeResult)?.text = shoe.size.toString()
        view?.findViewById<TextView>(R.id.companyNameResult)?.text = shoe.company
        view?.findViewById<TextView>(R.id.shoeInfoResult)?.text = shoe.description

        lin.addView(view)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(ShoeListFragmentDirections.listToLogin())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}