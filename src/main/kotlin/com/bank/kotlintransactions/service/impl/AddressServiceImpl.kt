package com.bank.kotlintransactions.service.impl

import com.bank.kotlintransactions.domain.model.Address
import com.bank.kotlintransactions.domain.repository.AddressRepository
import com.bank.kotlintransactions.service.AddressService
import com.bank.kotlintransactions.service.CityService
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
    private val addressRepository: AddressRepository,
    private val cityService: CityService): AddressService {
    override fun findAll(): List<Address> {
        return addressRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    override fun findById(id: Long): Address {
        return addressRepository.findById(id).orElseThrow {NoSuchElementException("City with id $id not found.")}
    }

    override fun create(entity: Address): Address {
        val city = cityService.findById(entity.city.id)
        entity.city = city
        return addressRepository.save(entity)
    }

    override fun update(id: Long, entity: Address): Address {
        var addressToUpdate: Address = findById(id)
        addressToUpdate.copy(zipCode = entity.zipCode,
            number = entity.number,
            complement = entity.complement,
            neighborhood = entity.neighborhood,
            street = entity.street)
        return addressRepository.save(addressToUpdate)
    }

    override fun delete(id: Long) {
        val addressToDelete: Address = findById(id)
        addressRepository.delete(addressToDelete)
    }
}