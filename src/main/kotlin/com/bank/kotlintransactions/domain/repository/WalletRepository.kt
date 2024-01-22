package com.bank.kotlintransactions.domain.repository

import com.bank.kotlintransactions.domain.model.Wallet
import org.springframework.data.jpa.repository.JpaRepository

interface WalletRepository: JpaRepository<Wallet, Long>