package com.pair.shop.domain.shop.infrastructure

import com.pair.shop.domain.product.model.ProductId
import com.pair.shop.domain.shop.model.ShopProducts

class ShopProductsValue(
    override val products: List<ProductId> = listOf()
) : ShopProducts