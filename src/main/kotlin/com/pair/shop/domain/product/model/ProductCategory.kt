package com.pair.shop.domain.product.model

interface ProductCategory {
    val value: Category
}

enum class Category(
    val value: String
) {

    ELECTRONICS("전자"),
    CLOTHES("의류"),
    FOOD("식품"),
    BEAUTY("화장품"),
    LIVING("생활")

}