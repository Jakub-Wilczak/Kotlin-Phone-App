package com.example.przeterminarz.data

import com.example.przeterminarz.R
import com.example.przeterminarz.model.Product

object ProductRepositoryInMemory : ProductRepository{

    private val productList = mutableListOf<Product>(
        Product(R.drawable.tomato, R.drawable.spozywczy,"Pomidor","30/11/2025","10"),
        Product(R.drawable.product_szminka,R.drawable.kosmetyki,"Szminka","20/12/2027"),
        Product(R.drawable.product_jablko, R.drawable.spozywczy,"Jabłko","31/11/2025","10"),
        Product(R.drawable.product_ibuprom_rapid, R.drawable.medyczny,"Ibuprom Rapid","20/06/2026"),
        Product(R.drawable.product_marchewka, R.drawable.spozywczy,"Marchewka","10/02/2025"),

        Product(R.drawable.kurczak, R.drawable.spozywczy,"Kurczak","15/01/2026","3"),
        Product(R.drawable.lakier_do_paznokci, R.drawable.kosmetyki,"Lakier Do Paznokci","20/03/2028"),
        Product(R.drawable.krem_do_twarzy, R.drawable.kosmetyki,"Krem Do Twarzy","20/06/2027"),
        Product(R.drawable.stoperan, R.drawable.medyczny,"Stoperan","30/05/2026"),
        Product(R.drawable.euthyrox, R.drawable.medyczny,"Euthyrox","30/02/2027"),
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