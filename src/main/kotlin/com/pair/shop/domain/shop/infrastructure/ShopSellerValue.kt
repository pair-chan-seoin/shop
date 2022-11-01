package com.pair.shop.domain.shop.infrastructure

import com.pair.shop.domain.shop.model.ShopSeller

class ShopSellerValue(
    override val name: String,
    override val phoneNumber: String,
) : ShopSeller