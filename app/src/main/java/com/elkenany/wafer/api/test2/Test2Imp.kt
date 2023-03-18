package com.elkenany.wafer.api.test2

import com.elkenany.wafer.api.configurations.retrofitInterfaceHandler
import com.elkenany.wafer.api.configurations.onHandlingResponseStates
import com.elkenany.wafer.entities.GenericEntity
import com.elkenany.wafer.entities.SponsersListData

class Test2Imp {
    suspend fun getAllSponsersData(): GenericEntity<SponsersListData> {
        return onHandlingResponseStates("getAllSponsersData") {
            retrofitInterfaceHandler(ITest2::class.java).getAllSponsersData()
        }
    }
}