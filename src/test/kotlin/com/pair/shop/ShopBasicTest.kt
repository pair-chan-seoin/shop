package com.pair.shop

import com.pair.shop.domain.product.model.Category
import com.pair.shop.domain.product.model.ProductCategory
import com.pair.shop.domain.product.model.ProductCode
import com.pair.shop.domain.product.model.ProductId
import com.pair.shop.domain.product.model.ProductModel
import com.pair.shop.domain.product.model.ProductName
import com.pair.shop.domain.product.model.ProductPrice
import io.kotest.core.spec.style.BehaviorSpec
import java.time.Instant

class ShopBasicTest : BehaviorSpec({

    Given("product") {
        // 셀러가 판매하고자 하는 맥북을

        val mac : ProductModel = (object: ProductModel {
            val now = Instant.now()

            override val id: ProductId = object: ProductId {
                override val value: Long = 1L
            }
            override val code: ProductCode<String> = object: ProductCode<String> {
                override val value: String = ""
            }
            override val name: ProductName = object: ProductName {
                override val value: String = "mac m1"
            }
            override val price: ProductPrice = object: ProductPrice {
                override val value: Long = 4_000_000L
            }
            override val category: ProductCategory = object: ProductCategory {
                override val value: Category = Category.ELECTRONICS
            }
            override val deletedAt: Instant? = null
            override val createdAt: Instant = now
            override val updatedAt: Instant = now

            // TODO :: 방법을 생각해 보기
            override fun edit(): ProductModel.Editor = this.edit()
        })

        When("create") {
            // 상점에 등록 하는 경우


            Then("") {

            }
        }

        When("update") {

            Then("") {

            }
        }

        When("delete") {
            Then("isDeleted return true") {

            }
        }
    }
    // BehaviorSpec
    // FeatureSpec
    // AnnotationSpec -> Junit 유사


})



