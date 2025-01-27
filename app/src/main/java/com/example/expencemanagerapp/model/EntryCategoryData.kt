package com.example.expencemanagerapp.model

import android.text.format.Time
import java.util.Date

data class EntryCategoryData(
    val date : String,
    val time : String,
    val LeftMoney: Int,
    val usedMoney : Int
)
