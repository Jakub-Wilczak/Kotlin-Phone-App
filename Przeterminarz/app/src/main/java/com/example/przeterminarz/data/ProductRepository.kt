package com.example.przeterminarz.data

import com.example.przeterminarz.model.Product

interface ProductRepository {
    fun getProductList(): List<Product>

    fun getProductAmount(): Int

    fun getProductList(category: Int): List<Product>

    fun addProduct(product: Product)
}