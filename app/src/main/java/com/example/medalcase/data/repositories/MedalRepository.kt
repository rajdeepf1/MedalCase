package com.example.medalcase.data.repositories

import com.example.medalcase.data.datasource.MedalDataSet
import com.example.medalcase.data.models.MedalModel

class MedalRepository {
    var medalDataSet = MedalDataSet()
    suspend fun getMedalData() : List<MedalModel> = medalDataSet.getMedalData()
}