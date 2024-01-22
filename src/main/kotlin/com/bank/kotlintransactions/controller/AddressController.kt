package com.bank.kotlintransactions.controller

import com.bank.kotlintransactions.domain.model.Address
import com.bank.kotlintransactions.service.AddressService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/addresses")
class AddressController(private val addressService: AddressService) {

    @GetMapping
    fun findAllAddress(): ResponseEntity<List<Address>> {
        return ResponseEntity.ok(addressService.findAll())
    }

    @GetMapping("/{id}")
    fun findAddressById(@PathVariable id: Long): ResponseEntity<Address> {
        return ResponseEntity.ok(addressService.findById(id))
    }

    @PostMapping
    fun createAddress(@RequestBody address: Address): ResponseEntity<Address> {
        val addressCreated: Address = addressService.create(address)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(addressCreated.id)
            .toUri()
        return ResponseEntity.created(location).body(addressCreated)
    }

    @PutMapping("/{id}")
    fun updateAddress(@RequestBody addressUpdated: Address, @PathVariable id: Long): ResponseEntity<Address> {
        return ResponseEntity.ok(addressService.update(id, addressUpdated))
    }

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long): ResponseEntity<Void> {
        addressService.delete(id)
        return ResponseEntity.noContent().build()
    }
}