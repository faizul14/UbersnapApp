package com.faezolfp.ubersnaptodoapp.core.domain.repository

import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel

interface Repository {
    fun example(): ExampleModel
}