package com.example.przeterminarz.model

import androidx.annotation.DrawableRes
import java.util.Date

data class Product(
    @DrawableRes
    val productIcon: Int,
    @DrawableRes
    val categoryIcon: Int,
    val name: String,
    val dueDate: String,
    val amount: String? = "1",
    )
