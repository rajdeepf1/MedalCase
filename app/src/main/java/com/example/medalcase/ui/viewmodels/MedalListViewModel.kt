package com.example.medalcase.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medalcase.data.models.MedalModel
import com.example.medalcase.data.repositories.MedalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedalListViewModel : ViewModel() {
    var medalRepository = MedalRepository()
    var list = MutableLiveData<List<MedalModel>>()

    init {
        getData()
    }

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            list.value = medalRepository.getMedalData()
        }
    }

}