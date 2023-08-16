package com.faezolfp.ubersnaptodoapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.faezolfp.ubersnaptodoapp.core.data.local.LocalDataSource
import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository
import com.faezolfp.ubersnaptodoapp.core.utils.DataMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImplRepository @Inject constructor(private val localDataSource: LocalDataSource) :
    Repository {
    override fun example(): ExampleModel {
        return DataMapper.mapperFromDataToDomain("example")
    }

    override fun getListTask(): LiveData<List<TaskModel>> {
        return localDataSource.getListTast().map { data ->
            DataMapper.mapperTaskFromDataToDomainList(data)
        }
    }

    override fun addTask(task: TaskModel) {
        localDataSource.addTad(DataMapper.mapperTaskFromDomainToData(task))
    }

    override fun updateTask(task: TaskModel) {
        localDataSource.updateTas(DataMapper.mapperTaskFromDomainToData(task))
    }

    override fun deleteTask(task: TaskModel) {
        localDataSource.deleteTas(DataMapper.mapperTaskFromDomainToData(task))
    }
}