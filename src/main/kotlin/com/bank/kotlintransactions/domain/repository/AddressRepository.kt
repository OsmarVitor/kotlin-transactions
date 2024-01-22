package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<Address, Long>