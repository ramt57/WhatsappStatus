package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModel
import com.ramt57.whatsappstatus.repository.CloudRepository

class MainViewModel : ViewModel(){
    fun getCloudFirstData(instancr: CloudRepository) {
        instancr.getMultiDocument()
    }
}
