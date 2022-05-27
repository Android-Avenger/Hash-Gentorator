package com.andavn.hashgenerator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.andavn.hashgenerator.R
import com.andavn.hashgenerator.databinding.FragmentSuccessBinding
import com.andavn.hashgenerator.viewmodel.HomeFragmentViewModel

class SuccessFragment : Fragment() {

    lateinit var mBinding: FragmentSuccessBinding
    private val args:SuccessFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentSuccessBinding.inflate(layoutInflater, container, false)

        mBinding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_homeFragment)
        }


        return mBinding.root
    }

}
