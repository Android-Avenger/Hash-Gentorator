package com.andavn.hashgenerator.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andavn.hashgenerator.R
import com.andavn.hashgenerator.databinding.FragmentHomeBinding
import com.andavn.hashgenerator.viewmodel.HomeFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()
    lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        mBinding = FragmentHomeBinding.inflate(inflater, container, false)


        val hashAlgorithm = resources.getStringArray(R.array.hash_algoriyhm)
        val adapter = ArrayAdapter(requireContext(), R.layout.hash_menu_textview, hashAlgorithm)
        mBinding.autoCompleteTextView.setAdapter(adapter)

        mBinding.Generate.setOnClickListener {
            onGenerateClick()
        }

        return (mBinding.root)

    }


    private fun onGenerateClick() {

        if(mBinding.textHere.text.isEmpty()){

            showSnackBar("Field is Empty")

        }else
        {
            lifecycleScope.launch {
                setAnimation()
                navigateToSuccessFragment(getHashCodeData())

            }


        }
    }

    private fun getHashCodeData() : String {

        val plainText = mBinding.textHere.text.toString()
        val algorithm = mBinding.autoCompleteTextView.text.toString()

        return homeFragmentViewModel.getHashCode(plainText,algorithm)

    }
    private suspend fun setAnimation() {

        mBinding.Generate.isClickable = false
        mBinding.hashGenrator.animate().alpha(0f).duration = 400L
        mBinding.Generate.animate().alpha(0f).duration = 400L

        mBinding.textHere.animate()
            .alpha(0f)
            .translationXBy(1200f)
            .duration = 400L
        mBinding.textField.animate()
            .alpha(0f)
            .translationXBy(-1200f)
            .duration = 400L
        mBinding.view.animate()
            .alpha(0f)
            .translationXBy(-1200f)
            .duration = 400L

        delay(300)

        mBinding.successBackground.animate().alpha(1f).duration = 600L
        mBinding.successBackground.animate().rotationBy(720f).duration = 600L
        mBinding.successBackground.animate().scaleXBy(900f).duration = 900L
        mBinding.successBackground.animate().scaleYBy(900f).duration = 900L

        delay(500)

        mBinding.check.animate().alpha(1f).duration = 1000L

        delay(1000)


    }

    private fun showSnackBar(message: String) {

        val snackbar = Snackbar.make(
            mBinding.root,
            message,
            Snackbar.LENGTH_LONG
        )
            .setBackgroundTint(resources.getColor(R.color.light_blue))
            .setActionTextColor(resources.getColor(R.color.Grey))
            .show()
    }

    private fun navigateToSuccessFragment(hash : String) {

        val hashCode = HomeFragmentDirections.actionHomeFragmentToSuccessFragment(hash)
        findNavController().navigate(hashCode)

    }


    override fun onDestroyView() {
        super.onDestroyView()

    }

}