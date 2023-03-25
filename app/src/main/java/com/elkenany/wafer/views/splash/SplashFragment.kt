package com.elkenany.wafer.views.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.elkenany.wafer.R
import com.elkenany.wafer.databinding.FragmentSplashBinding
import com.elkenany.wafer.databinding.SmallRecyclerItemBinding
import com.elkenany.wafer.entities.LogosAndBannersData
import com.elkenany.wafer.utilities.GenericRecyclerAdapter
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
        binding.data.setOnClickListener {
            viewModel.onGettingFromBackEnd()
        }
        val adapter =
            GenericRecyclerAdapter.create<LogosAndBannersData, SmallRecyclerItemBinding>(R.layout.small_recycler_item)
            {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            }
        binding.sponsersRecyclerView.adapter = adapter
        viewModel = SplashViewModel()
        viewModel.onGettingFromBackEnd()
        viewModel.contactUs.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.i("data", "$it")
                adapter.submitList(it.logos)

            }
        }
        return binding.root
    }

}