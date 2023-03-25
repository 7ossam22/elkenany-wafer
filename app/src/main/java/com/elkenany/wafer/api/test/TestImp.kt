package com.elkenany.wafer.api.test

import com.elkenany.wafer.api.configurations.RetrofitInterfaceHandler
import com.elkenany.wafer.api.configurations.onHandlingResponseStates
import com.elkenany.wafer.entities.AboutUsData
import com.elkenany.wafer.entities.GenericEntity

class TestImp {
    suspend fun testingCallFromBackendServer(): GenericEntity<AboutUsData> {
        return onHandlingResponseStates("testingCallFromBackendServer") {
            RetrofitInterfaceHandler(ITest::class.java).createHandler()
                .testingCallFromBackendServer()
        }
    }
}