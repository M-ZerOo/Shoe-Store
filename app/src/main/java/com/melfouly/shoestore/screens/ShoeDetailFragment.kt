package com.melfouly.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.melfouly.shoestore.R
import com.melfouly.shoestore.ShoeViewModel
import com.melfouly.shoestore.databinding.FragmentShoeDetailBinding
import com.melfouly.shoestore.model.Shoe

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private var shoe = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoe = shoe

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        /**
         * Check for the edit texts if they are empty it will make a toast to help the user,
         * if not it will add the new shoe to the viewModel and navigate back to the ShoeListFragment
         */

        binding.saveBtn.setOnClickListener {
            if (checkDetails()) {
                viewModel.addNewShoe(shoe)
                findNavController().navigateUp()
            } else Toast.makeText(activity, "Check shoe details.", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun checkDetails(): Boolean {
        return !(shoe.name?.isBlank() == true || shoe.company?.isBlank() == true || shoe.description?.isBlank() == true)
    }
}