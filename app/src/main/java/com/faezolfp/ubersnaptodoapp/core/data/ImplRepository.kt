package com.faezolfp.ubersnaptodoapp.core.data

import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository
import com.faezolfp.ubersnaptodoapp.core.utils.DataMapper

class ImplRepository(): Repository {
    override fun example(): ExampleModel {
        return DataMapper.mapperFromDataToDomain("example")
    }
}