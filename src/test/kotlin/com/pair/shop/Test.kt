package com.pair.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class Test : BehaviorSpec({ // 테스트 스타일 클래스

    Given("given") {
        val test = 1
        When("when") {
            val when22 = 1
            Then("then") {
                test shouldBe when22
            }
        }
    }

})