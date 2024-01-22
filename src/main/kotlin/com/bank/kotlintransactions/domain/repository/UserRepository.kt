package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>