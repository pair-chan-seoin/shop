package com.pair.shop

import com.pair.shop.domain.product.infrastructure.ProductCategoryValue
import com.pair.shop.domain.product.infrastructure.ProductCodeValue
import com.pair.shop.domain.product.infrastructure.ProductNameValue
import com.pair.shop.domain.product.infrastructure.ProductPriceValue
import com.pair.shop.domain.product.model.Category
import com.pair.shop.domain.product.model.ProductModel
import io.kotest.core.spec.style.BehaviorSpec

class ShopBasicTest : BehaviorSpec({

    Given("product") {
        // 셀러가 판매하고자 하는 맥북을

        val mac : ProductModel = ProductModel.create(
            name = ProductNameValue("맥북"),
            price = ProductPriceValue(1_000_000),
            category = ProductCategoryValue(Category.ELECTRONICS),
            code = ProductCodeValue("0001"),
        )

        When("create") {
            // 상점에 등록 하는 경우
            // Shop Domain

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