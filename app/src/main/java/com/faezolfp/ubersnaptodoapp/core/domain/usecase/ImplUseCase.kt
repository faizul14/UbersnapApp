package com.faezolfp.ubersnaptodoapp.core.domain.usecase

import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository

class ImplUseCase(private val repository: Repository): UseCase {
    override fun example(): ExampleModel {
        return repository.example()
    }
}