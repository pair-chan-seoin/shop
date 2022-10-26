package com.pair.shop.domain.product.model

import com.pair.shop.domain.common.DateAuditable
import com.pair.shop.domain.common.Editable
import com.pair.shop.domain.product.infrastructure.ProductIdValue
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

    override fun edit(): Editor

    interface Editor : ProductModel {

        override var name: ProductName

        override var price: ProductPrice

        override var category: ProductCategory

        override var updatedAt: Instant

        override var deletedAt: Instant?

        override fun edit(): Editor = this

        fun delete(instant: Instant = Instant.now()): Editor {
            this.deletedAt = instant
            this.updatedAt = instant
            return this
        }
    }

    companion object {
        internal data class Model(
            override val id: ProductId,
            override var name: ProductName,
            override var price: ProductPrice,
            override var category: ProductCategory,
            override val code: ProductCode<String>,
            override val createdAt: Instant,
            override var updatedAt: Instant,
            override var deletedAt: Instant?
        ): Editor

        fun create(
            name: ProductName,
            price: ProductPrice,
            category: ProductCategory,
            code: ProductCode<String>,
        ) : ProductModel {
            val now = Instant.now()

            return Model(
                id = ProductIdValue(0),
                name = name,
                price = price,
                code = code,
                category = category,
                createdAt = now,
                updatedAt = now,
                deletedAt = now
            )
        }
    }
}