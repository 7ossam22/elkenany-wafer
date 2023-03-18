package com.elkenany.wafer.views.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.elkenany.wafer.R
import com.elkenany.wafer.databinding.FragmentSplashBinding
import com.elkenany.wafer.viewmodels.splash.SplashViewModel


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: SplashViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_splash, container, false
        )
        viewModel = SplashViewModel()
        viewModel.onGettingFromBackEnd()
        viewModel.contactUs.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.i("data", "$it")
                binding.data.text = it.toString()
            }
        }
        return binding.root
    }

}