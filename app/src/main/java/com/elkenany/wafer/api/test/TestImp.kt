package com.elkenany.wafer.api.test

import com.elkenany.wafer.api.configurations.retrofitInterfaceHandler
import com.elkenany.wafer.api.configurations.onHandlingResponseStates
import com.elkenany.wafer.entities.AboutUsData
import com.elkenany.wafer.entities.GenericEntity

class TestImp {
    suspend fun testingCallFromBackendServer(): GenericEntity<AboutUsData> {
        return onHandlingResponseStates("testingCallFromBackendServer") {
            retrofitInterfaceHandler(ITest::class.java).testingCallFromBackendServer()
        }
    }
}