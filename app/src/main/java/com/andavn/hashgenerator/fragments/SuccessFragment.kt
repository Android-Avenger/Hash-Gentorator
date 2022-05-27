package com.andavn.hashgenerator.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
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
import com.google.android.material.snackbar.Snackbar
import kotlin.time.measureTimedValue

class SuccessFragment : Fragment() {

    lateinit var mBinding: FragmentSuccessBinding
    private val args:SuccessFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentSuccessBinding.inflate(layoutInflater, container, false)

        mBinding.HashText.text = args.hash

        mBinding.coptText.setOnClickListener {
            showSnackBar("Copied")
            copyToClipBoard(args.hash)
        }
        mBinding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_homeFragment)
        }

        return mBinding.root
    }

    private fun copyToClipBoard(hash:String) {

        val clipBoardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val copyText = ClipData.newPlainText("Encrypted Text",hash)
        clipBoardManager.setPrimaryClip(copyText)

    }
    private fun showSnackBar(message: String) {

        val snackbar = Snackbar.make(
            mBinding.root,
            message,
            Snackbar.LENGTH_LONG
        )
            .setBackgroundTint(resources.getColor(R.color.yellow))
            .setTextColor(resources.getColor(R.color.dark_Blue_Grey))
            .show()
    }

}
