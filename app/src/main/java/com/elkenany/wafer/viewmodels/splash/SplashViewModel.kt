package com.elkenany.wafer.viewmodels.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elkenany.wafer.api.test.TestImp
import com.elkenany.wafer.api.test2.Test2Imp
import com.elkenany.wafer.entities.AboutUsData
import com.elkenany.wafer.entities.SponsersListData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private val _contactUs = MutableLiveData<SponsersListData?>()
    private val _loading = MutableLiveData(false)
    private val api = Test2Imp()


    val contactUs: LiveData<SponsersListData?> get() = _contactUs
    val loading: LiveData<Boolean> get() = _loading

    fun onGettingFromBackEnd() {
        _loading.value = true
        uiScope.launch {
            _contactUs.value = api.getAllSponsersData().data
            _loading.value = false
        }

    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}