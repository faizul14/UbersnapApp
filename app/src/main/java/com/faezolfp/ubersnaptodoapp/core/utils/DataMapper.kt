package com.faezolfp.ubersnaptodoapp.core.utils

import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel

object DataMapper {
    fun mapperFromDataToDomain(input: String): ExampleModel {
        return ExampleModel(
            example = input
        )
    }
}