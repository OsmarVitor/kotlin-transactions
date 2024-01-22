package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.State
import org.springframework.data.jpa.repository.JpaRepository


interface StateRepository: JpaRepository<State, Long>
