package com.bank.kotlintransactions.controller

import com.bank.kotlintransactions.domain.model.City
import com.bank.kotlintransactions.service.CityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/cities")
class CityController(private val cityService: CityService){

    @GetMapping
    fun findAllCities(): ResponseEntity<List<City>> {
        return ResponseEntity.ok(cityService.findAll())
    }

    @GetMapping("/{id}")
    fun findCityById(@PathVariable id: Long): ResponseEntity<City> {
        return ResponseEntity.ok(cityService.findById(id))
    }

    @PostMapping
    fun createCity(@RequestBody city: City): ResponseEntity<City> {
        val cityCreated: City = cityService.create(city)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(cityCreated.id)
            .toUri()
        return ResponseEntity.created(location).body(cityCreated)
    }

    @PutMapping("/{id}")
    fun updateCity(@RequestBody cityUpdated: City, @PathVariable id: Long): ResponseEntity<City> {
        return ResponseEntity.ok(cityService.update(id, cityUpdated))
    }

    @DeleteMapping("/{id}")
    fun deleteCity(@PathVariable id: Long): ResponseEntity<Void> {
        cityService.delete(id)
        return ResponseEntity.noContent().build()
    }
}