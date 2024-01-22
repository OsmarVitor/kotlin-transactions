package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.Transactions
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transactions, Long>