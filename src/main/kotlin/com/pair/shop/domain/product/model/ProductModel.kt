package com.pair.shop.domain.product.model

import java.time.LocalDateTime

interface ProductModel { // 상품

    // TODO :: property type wrapping & test code
    // 아이디
    val id: Long
    // 상품코드 = date + product type
    val code: String
    // 상품이름
    val name: String
    // 가격
    val price: Long

    // category -> enum ?
    val category: String

    val deletedAt: LocalDateTime
}