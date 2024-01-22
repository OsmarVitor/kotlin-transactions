package com.bank.kotlintransactions.domain.model.enums

enum class TransactionStatus(val status: String) {
    SUCCESS("SUCCESS"),
    IN_PROGRESS("IN_PROGRESS"),
    FAIL("FAIL")

}