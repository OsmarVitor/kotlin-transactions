package com.bank.kotlintransactions.controller

import com.bank.kotlintransactions.domain.model.State
import com.bank.kotlintransactions.service.StateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/states")
class StateController(private val stateService: StateService) {

    @GetMapping
    fun findAllStates(): ResponseEntity<List<State>>{
        return ResponseEntity.ok(stateService.findAll())
    }

    @GetMapping("/{id}")
    fun findStateById(@PathVariable id: Long): ResponseEntity<State>{
        return ResponseEntity.ok(stateService.findById(id))
    }

    @PostMapping
    fun createState(@RequestBody state: State): ResponseEntity<State>{
        val stateCreated: State = stateService.create(state)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(stateCreated.id)
            .toUri()
        return ResponseEntity.created(location).body(stateCreated)
    }

    @PutMapping("/{id}")
    fun updateState(@RequestBody stateUpdated: State, @PathVariable id: Long): ResponseEntity<State>{
        return ResponseEntity.ok(stateService.update(id, stateUpdated))
    }

    @DeleteMapping("/{id}")
    fun deleteState(@PathVariable id: Long): ResponseEntity<Void>{
        stateService.delete(id)
        return ResponseEntity.noContent().build()
    }

}