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

        // TODO :: Test case
        fun delete(instant: Instant = Instant.now()): Editor
    }

    // domain logic
    companion object {

        // TODO :: 도메인 로직 정의 리스트 업?? -> event storming ?

        // model

        // controller DTO -> domain
        // DTO createDTO, updateDTO ...
        // Factory Class <- parameter list ?
        // UserFactoryClass.create(dto) = User()

        // 응용 서비스
        //  -> 단순히 도메인 로직 실행
        //  -> user.isValid()

        // 도메인 서비스 (business logic)
        //  -> 쿠폰 + 상품 에 비즈니스 로직


        // user.create(groupService, dto)
        // companion object

        // adapter DTO -> domain
        // port(domain) -> service -> infra(repository DB)
        //               domain ->   JPA Entity(@Entity)
    }
}