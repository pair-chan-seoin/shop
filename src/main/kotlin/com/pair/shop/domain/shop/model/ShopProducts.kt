package com.pair.shop.domain.shop.model

import com.pair.shop.domain.product.model.ProductId

// 컬렉션 1개만 프로퍼티로 갖는 래퍼 클래스
interface ShopProducts {
    val products: List<ProductId>
}