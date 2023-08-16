package com.faezolfp.ubersnaptodoapp.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class TaskModel(
    var id: Int = 0,
    var tittle: String? = null,
    var description: String? = null,
    var date: String? = null
)
