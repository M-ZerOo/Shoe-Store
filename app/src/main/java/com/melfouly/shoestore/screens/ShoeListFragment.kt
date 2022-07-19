package com.melfouly.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.melfouly.shoestore.R
import com.melfouly.shoestore.ShoeViewModel
import com.melfouly.shoestore.databinding.FragmentShoeListBinding
import com.melfouly.shoestore.databinding.NewShoeBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        setHasOptionsMenu(true)

        /**
         * Observe the shoeList from the viewModel and inflate the layout that already made for the
         * new shoe and add this view as child to the parent view of this fragment
         */
        viewModel.shoeList.observe(viewLifecycleOwner) { list ->
            for (item in list) {
                val shoeBinding: NewShoeBinding =
                    DataBindingUtil.inflate(inflater, R.layout.new_shoe, null, false)

                shoeBinding.shoeName.text = item.name
                shoeBinding.shoeSize.text =
                    resources.getString(R.string.size_style) + " " + item.size
                shoeBinding.shoeCompany.text =
                    resources.getString(R.string.company_style) + " " + item.company
                shoeBinding.shoeDesc.text =
                    resources.getString(R.string.desc_style) + " " + item.description

                binding.linearLayout.addView(shoeBinding.root)
            }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController()
            .navigate(R.id.action_shoeListFragment_to_loginFragment)
        // Reset the shoeList once you logout
        viewModel.resetTheList()
        return true
    }


}