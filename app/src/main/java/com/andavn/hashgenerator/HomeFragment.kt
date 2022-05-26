package com.andavn.hashgenerator

import android.app.Activity
import android.app.StatusBarManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.andavn.hashgenerator.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        mBinding = FragmentHomeBinding.inflate(inflater,container,false)


        val hashAlgorithm = resources.getStringArray(R.array.hash_algoriyhm)
        val adapter = ArrayAdapter(requireContext(),R.layout.hash_menu_textview,hashAlgorithm)
        mBinding.autoCompleteTextView.setAdapter(adapter)

        mBinding.Generate.setOnClickListener {
            
            lifecycleScope.launch {
                setAnimation()
                navigateToSuccessFragment()
            }
        }


        return (mBinding.root)


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

        delay(1500)


    }

    private fun navigateToSuccessFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_successFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

}