package com.bank.kotlintransactions.service.impl

import com.bank.kotlintransactions.domain.model.State
import com.bank.kotlintransactions.domain.repository.StateRepository
import com.bank.kotlintransactions.service.StateService
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class StateServiceImpl(private val stateRepository: StateRepository): StateService{

    override fun findAll(): List<State> {
       return  stateRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    override fun findById(id: Long): State {
       return stateRepository.findById(id).orElseThrow {NoSuchElementException("State with id $id not found.")}
    }

    override fun create(entity: State): State {
        return stateRepository.save(entity);
    }

    override fun update(id: Long, entity: State): State {
        var stateToUpdate: State = findById(id)
        return stateRepository.save(stateToUpdate.copy(name = entity.name))
    }

    override fun delete(id: Long) {
       val stateToDelete: State = findById(id)
        stateRepository.delete(stateToDelete)
    }

}