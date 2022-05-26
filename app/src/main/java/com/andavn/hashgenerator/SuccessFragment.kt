package com.andavn.hashgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andavn.hashgenerator.databinding.FragmentSuccessBinding

class SuccessFragment : Fragment() {

    lateinit var mBinding: FragmentSuccessBinding

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
