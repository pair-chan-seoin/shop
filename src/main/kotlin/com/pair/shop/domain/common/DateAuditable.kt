package com.pair.shop.domain.common

import java.time.Instant

interface DateAuditable {
    val createdAt: Instant

    val updatedAt: Instant
}