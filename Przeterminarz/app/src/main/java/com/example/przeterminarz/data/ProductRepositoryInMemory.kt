package com.example.przeterminarz.data

import com.example.przeterminarz.R
import com.example.przeterminarz.model.Product
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

object ProductRepositoryInMemory : ProductRepository{



    private val productList = mutableListOf<Product>(
        Product(R.drawable.tomato, R.drawable.spozywczy,"Pomidor", Calendar.getInstance().apply {set(2025, 10, 30)}.time,10),
        Product(R.drawable.product_szminka,R.drawable.kosmetyki,"Szminka",Calendar.getInstance().apply {set(2027, 12, 20)}.time),
        Product(R.drawable.product_jablko, R.drawable.spozywczy,"Jabłko",Calendar.getInstance().apply {set(2025, 11, 31)}.time,10),
        Product(R.drawable.product_ibuprom_rapid, R.drawable.medyczny,"Ibuprom Rapid",Calendar.getInstance().apply {set(2026, 6, 20)}.time),
        Product(R.drawable.product_marchewka, R.drawable.spozywczy,"Marchewka",Calendar.getInstance().apply {set(2025, 2, 10)}.time),

        Product(R.drawable.kurczak, R.drawable.spozywczy,"Kurczak",Calendar.getInstance().apply {set(2026, 1, 15)}.time,3),
        Product(R.drawable.lakier_do_paznokci, R.drawable.kosmetyki,"Lakier Do Paznokci",Calendar.getInstance().apply {set(2028, 3, 20)}.time),
        Product(R.drawable.krem_do_twarzy, R.drawable.kosmetyki,"Krem Do Twarzy",Calendar.getInstance().apply {set(2027, 6, 20)}.time),
        Product(R.drawable.stoperan, R.drawable.medyczny,"Stoperan",Calendar.getInstance().apply {set(2026, 5, 30)}.time),
        Product(R.drawable.euthyrox, R.drawable.medyczny,"Euthyrox",Calendar.getInstance().apply {set(2027, 2, 30)}.time),
        )
    override fun getProductList(): List<Product> {
        return productList.sortedBy {it.dueDate}
    }

    override fun getProductList(category: Int): List<Product> {
        var tempList = ArrayList<Product>()
        for (i in 0..productList.size-1){
            if(productList[i].categoryIcon==category)
                tempList.add(productList[i])
        }
        return tempList.sortedBy { it.dueDate }
    }


    override fun addProduct(name: String, dueDate: Date, amount: Int?, productIcon: Int, categoryIcon: Int) : String {
        if (dueDate<Date()){
            return "Wybierz datę dzisiejszą lub przyszłą"
        }

        if (amount !is Int){
            return "Liczba produktów musi być wartością liczbową"
        }

        val tempProduct: Product = Product(
            name = name,
            dueDate = dueDate,
            amount = amount,
            productIcon = productIcon,
            categoryIcon = categoryIcon
        )

        productList.add(tempProduct)
        return "Produkt został dodany"
    }

    override fun getProductAmount(): Int {
        var tempAmount=0
        for (i in 0..productList.size-1){
            try {
                tempAmount += productList[i].amount?.toInt() ?: 1
            }catch (ex: NumberFormatException){
                ex.printStackTrace()
            }
        }
        return tempAmount
    }
}