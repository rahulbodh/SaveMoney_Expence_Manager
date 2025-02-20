package com.example.expencemanagerapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
 class Category(
    @PrimaryKey(autoGenerate = true)
     val id : Int = 0,
     val name : String ,
     val time : String,
     val budget : Float,
     val usedAmount : Float
 )
