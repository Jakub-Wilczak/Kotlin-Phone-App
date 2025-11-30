package com.example.przeterminarz.data

import com.example.przeterminarz.model.Product
import java.util.Date

interface ProductRepository {
    fun getProductList(): List<Product>

    fun getProductAmount(): Int

    fun getProductList(category: Int): List<Product>

    fun addProduct(name: String, dueDate: Date, amount: Int?, productIcon: Int, categoryIcon: Int) :String
}