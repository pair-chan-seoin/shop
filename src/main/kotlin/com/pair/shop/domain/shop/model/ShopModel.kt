package com.pair.shop.domain.shop.model

import com.pair.shop.domain.common.DateAuditable
import com.pair.shop.domain.common.Editable
import com.pair.shop.domain.shop.infrastructure.ShopIdValue
import com.pair.shop.domain.shop.infrastructure.ShopProductsValue
import java.time.Instant

interface ShopModel : DateAuditable, Editable<ShopModel> {
    val id: ShopId
    val name: ShopName

    // shop 삭제가 될때 product 도 같이 삭제 되는 케이스라면 하나의 aggreate 본다?
    // 하나의 aggregate 에 포함이 되지 않는 개념이면 <------ !!
    // shop 에서는 ProductModel 보다는 ProductId 만 있으면 될 것 같음
    val products: ShopProducts

    val seller: ShopSeller

    val deletedAt: Instant?

    val isDeleted: Boolean
        get() = deletedAt != null

    interface Editor : ShopModel {
        override var name: ShopName
        override var products: ShopProducts
        override var seller: ShopSeller
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
            override val id: ShopId,
            override var name: ShopName,
            override var products: ShopProducts,
            override var seller: ShopSeller,
            override val createdAt: Instant,
            override var updatedAt: Instant,
            override var deletedAt: Instant?
        ) : Editor

        fun create(
            name: ShopName,
            seller: ShopSeller
        ) : ShopModel {
            val now = Instant.now()

            return Model(
                id = ShopIdValue(0),
                name = name,
                seller = seller,
                products = ShopProductsValue(),
                createdAt = now,
                updatedAt = now,
                deletedAt = now
            )
        }
    }
}