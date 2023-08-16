package com.faezolfp.ubersnaptodoapp.core.utils

import com.faezolfp.ubersnaptodoapp.core.data.local.entity.TaskEntity
import com.faezolfp.ubersnaptodoapp.core.data.local.room.TaskDao
import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel

object DataMapper {
    fun mapperFromDataToDomain(input: String): ExampleModel {
        return ExampleModel(
            example = input
        )
    }

    fun mapperTaskFromDataToDomainList(input: List<TaskEntity>): List<TaskModel>{
        val dataResult = ArrayList<TaskModel>()
        input.map {
            val data = TaskModel(
                id = it.id,
                tittle = it.tittle,
                description = it.description,
                date = it.date
            )
            dataResult.add(data)
        }
        return dataResult
    }

    fun mapperTaskFromDomainToData(input: TaskModel): TaskEntity{
        return TaskEntity(
            id = input.id,
            tittle = input.tittle,
            description = input.description,
            date = input.date
        )
    }


}