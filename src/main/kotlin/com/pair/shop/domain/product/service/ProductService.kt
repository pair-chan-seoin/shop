package com.pair.shop.domain.product.service

import com.pair.shop.domain.product.model.ProductModel

class ProductService {
    fun example(productModel: ProductModel) {
        productModel.edit().apply {
            /**
             * 이 필드에 직접 assign 하지 마시고, delete 메소드를 활용하세요.
             * 이 필드에 직접 assign 할 경우 문제가 생길 수 있습니다.
             */
        }
    }
}