package com.elkenany.wafer.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elkenany.wafer.viewmodels.splash.SplashViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <V : ViewModel> create(modelClass: Class<V>): V {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel() as V
            else -> throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}