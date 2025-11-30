package com.example.przeterminarz.model

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.util.Date

data class Product(
    @DrawableRes
    val productIcon: Int,
    @DrawableRes
    val categoryIcon: Int,
    val name: String,
    val dueDate: Date,
    val amount: Int? = 1,
    )
