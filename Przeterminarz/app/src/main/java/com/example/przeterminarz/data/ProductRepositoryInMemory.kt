package com.example.przeterminarz.data

import com.example.przeterminarz.R
import com.example.przeterminarz.model.Product

object ProductRepositoryInMemory : ProductRepository{

    private val productList = mutableListOf<Product>(
        Product(R.drawable.tomato, R.drawable.spozywczy,"Pomidor","spożywczy"),
        Product(R.drawable.product_szminka,R.drawable.kosmetyki,"Szminka","spożywczy"),
        Product(R.drawable.product_jablko, R.drawable.spozywczy,"Jabłko","spożywczy"),
        Product(R.drawable.product_ibuprom_rapid, R.drawable.medyczny,"Ibuprom Rapid","spożywczy"),
        Product(R.drawable.product_marchewka, R.drawable.spozywczy,"Marchewka","spożywczy"),
    )
    override fun getProductList(): List<Product> {
        return productList
    }

    override fun getProductList(category: Int): List<Product> {
        var tempList = ArrayList<Product>()
        for (i in 0..productList.size-1){
            if(productList[i].categoryIcon==category)
                tempList.add(productList[i])
        }
        return tempList
    }
}