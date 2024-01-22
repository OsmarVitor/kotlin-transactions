package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository: JpaRepository<City, Long>