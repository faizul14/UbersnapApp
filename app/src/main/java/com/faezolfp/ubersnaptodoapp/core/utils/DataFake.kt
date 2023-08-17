package com.faezolfp.ubersnaptodoapp.core.utils

import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel

object DataFake {

    fun dataFake(): List<TaskModel>{
        val dataResult = ArrayList<TaskModel>()

        for(i in 1..10){
            val data = TaskModel(
                tittle = "tittle $i",
                description = "lorem ispum dolor is amet, lispum, lipsum lipsum lipsum",
                date = "$i August 2023"
            )
            dataResult.add(data)
        }
        return dataResult
    }

}