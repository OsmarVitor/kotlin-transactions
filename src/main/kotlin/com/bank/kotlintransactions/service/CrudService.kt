package com.bank.kotlintransactions.service

interface CrudService<T, ID> {
    fun findAll(): List<T>
    fun findById(id: ID): T
    fun create(entity: T): T
    fun update(id: ID, entity: T): T
    fun delete(id: ID)

}