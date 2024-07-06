package com.example.medalcase.data.datasource

import com.example.medalcase.R
import com.example.medalcase.data.models.MedalListModel
import com.example.medalcase.data.models.MedalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MedalDataSet {
    val medalList = ArrayList<MedalModel>()

    suspend fun getMedalData(): List<MedalModel> = withContext(Dispatchers.IO) {

        val medalListModelForPersonalRecords = ArrayList<MedalListModel>()
        medalListModelForPersonalRecords.add(
            MedalListModel(
                1,
                "Longest Run",
                "00:00",
                R.drawable.longest_run,
                true
            )
        )
        medalListModelForPersonalRecords.add(
            MedalListModel(
                2,
                "Highest Elevation",
                "2095 ft",
                R.drawable.highest_elevation,
                true
            )
        )
        medalListModelForPersonalRecords.add(
            MedalListModel(
                3,
                "Fastest 5K",
                "00:00",
                R.drawable.fastest_5k,
                true
            )
        )
        medalListModelForPersonalRecords.add(
            MedalListModel(
                4,
                "10K",
                "00:00:00",
                R.drawable.fastest_10k,
                true
            )
        )
        medalListModelForPersonalRecords.add(
            MedalListModel(
                5,
                "Half Marathon",
                "00:00",
                R.drawable.virtual_half_marathon_race,
                true
            )
        )
        medalListModelForPersonalRecords.add(
            MedalListModel(
                6,
                "Marathon",
                "Not Yet",
                R.drawable.fastest_marathon,
                false
            )
        )
        medalList.add(MedalModel(1, "Personal Records", medalListModelForPersonalRecords))

        val medalListModelForVirtualRaces = ArrayList<MedalListModel>()
        medalListModelForVirtualRaces.add(
            MedalListModel(
                1,
                "Virtual Half Marathon",
                "00:00",
                R.drawable.virtual_half_marathon_race,
                true
            )
        )
        medalListModelForVirtualRaces.add(
            MedalListModel(
                2,
                "Tokyo-Hakone Ekiden",
                "00:00:00",
                R.drawable.tokyo_kakone_ekiden,
                true
            )
        )
        medalListModelForVirtualRaces.add(
            MedalListModel(
                3,
                "Virtual 10K Race",
                "00:00:00",
                R.drawable.virtual_10k_race,
                true
            )
        )
        medalListModelForVirtualRaces.add(
            MedalListModel(
                4,
                "Hakone Ekiden",
                "00:00:00",
                R.drawable.hakone_ekiden,
                true
            )
        )
        medalListModelForVirtualRaces.add(
            MedalListModel(
                5, "Mizuno Singapore\n" +
                        "Ekiden 2015", "00:00:00", R.drawable.mizuno_singapore_ekiden, true
            )
        )
        medalListModelForVirtualRaces.add(
            MedalListModel(
                6,
                "Virtual 5K Race",
                "23:07",
                R.drawable.virtual_5k_race,
                true
            )
        )
        medalList.add(MedalModel(2, "Virtual Races", medalListModelForVirtualRaces))


        return@withContext medalList
    }
}