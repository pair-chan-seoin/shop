package com.pair.shop.domain.common

interface Editable<T> {
    fun edit(): T
}