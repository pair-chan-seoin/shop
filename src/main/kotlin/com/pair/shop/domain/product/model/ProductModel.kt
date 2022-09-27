package com.pair.shop.domain.product.model

import com.pair.shop.domain.common.DateAuditable
import com.pair.shop.domain.common.Editable
import java.time.Instant

interface ProductModel : DateAuditable, Editable<ProductModel> { // 상품

    // 아이디
    val id: ProductId

    // 상품코드 = date + product type
    val code: ProductCode<String>

    // 상품 이름
    val name: ProductName

    // 가격
    val price: ProductPrice

    val category: ProductCategory

    val deletedAt: Instant?

    val isDeleted: Boolean
        get() = deletedAt != null

    interface Editor : ProductModel {

        override var name: ProductName

        override var price: ProductPrice

        override var category: ProductCategory

        override var updatedAt: Instant

        override var deletedAt: Instant?

        override fun edit(): Editor = this

        fun update(
            name: ProductName,
            price: ProductPrice,
            category: ProductCategory,
            updatedAt: Instant = Instant.now(),
        ) : ProductModel

        fun delete(instant: Instant = Instant.now()): ProductModel

        fun create(
            name: ProductName,
            price: ProductPrice,
            category: ProductCategory,
            code: ProductCode<String>,
        ) : ProductModel
    }
}