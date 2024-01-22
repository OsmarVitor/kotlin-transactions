package com.bank.kotlintransactions.service.impl

import com.bank.kotlintransactions.domain.model.City
import com.bank.kotlintransactions.domain.repository.CityRepository
import com.bank.kotlintransactions.service.CityService
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CityServiceImpl(private val cityRepository: CityRepository): CityService {
    override fun findAll(): List<City> {
        return cityRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    override fun findById(id: Long): City {
        return cityRepository.findById(id).orElseThrow {NoSuchElementException("City with id $id not found.")}
    }

    override fun create(entity: City): City {
        return cityRepository.save(entity)
    }

    override fun update(id: Long, entity: City): City {
        var cityToUpdate: City = findById(id)
        cityToUpdate.copy(name = entity.name, state = entity.state)
        return cityRepository.save(cityToUpdate)
    }

    override fun delete(id: Long) {
        val cityToDelete: City = findById(id)
        cityRepository.delete(cityToDelete)
    }
}