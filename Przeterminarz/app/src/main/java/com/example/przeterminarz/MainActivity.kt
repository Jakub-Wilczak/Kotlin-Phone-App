package com.example.przeterminarz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.przeterminarz.adapters.ProductListAdapter
import com.example.przeterminarz.data.ProductRepository
import com.example.przeterminarz.data.ProductRepositoryInMemory
import com.example.przeterminarz.databinding.ActivityMainBinding
import com.example.przeterminarz.databinding.AddProductBinding
import com.example.przeterminarz.databinding.ItemProductBinding
import com.example.przeterminarz.databinding.SecondScreenBinding

class MainActivity : AppCompatActivity() {

    fun updateItemCount(){

    }


    lateinit var ProductRepository: ProductRepository
    lateinit var binding1: ActivityMainBinding
    lateinit var secondScreenBinding: SecondScreenBinding

    lateinit var addProductBinding: AddProductBinding
    lateinit var productListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding1=ActivityMainBinding.inflate(layoutInflater)
        secondScreenBinding= SecondScreenBinding.inflate(layoutInflater)
        addProductBinding = AddProductBinding.inflate(layoutInflater)



        var productRepository = ProductRepositoryInMemory



        productListAdapter= ProductListAdapter()
        binding1.ProductList.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=productListAdapter
        }

        productListAdapter.productList = productRepository.getProductList()

        setContentView(binding1.root)
        val textView: TextView = findViewById(R.id.pantryAmount)
        textView.text = productRepository.getProductAmount().toString()

        binding1.button2.setOnClickListener{
            setContentView(secondScreenBinding.root)


        }
        binding1.AddProduct.setOnClickListener {
            setContentView(addProductBinding.mainaddproductlayout)





            val kategorie_produkty = resources.getStringArray(R.array.kategorieProdukty)

            val spinner: Spinner = findViewById(R.id.add_product_editProductCategory)
            if (spinner != null) {
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kategorie_produkty)
                spinner.adapter = adapter

//                spinner.onItemSelectedListener = object :
//                    AdapterView.OnItemSelectedListener{
//                    override fun onItemSelected(parent: AdapterView<*>,
//                                                view: View, position: Int, id: Long) {
//                        Toast.makeText(this@MainActivity, getString(R.string.wybrany_produkt) + " " +
//                                "" + kategorie_produkty[position], Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onNothingSelected(parent: AdapterView<*>) {
//                    }
//                }
            }

            val amountNumberPicker: NumberPicker = findViewById(R.id.add_product_editProductAmount)
            amountNumberPicker.setMinValue(1)
            amountNumberPicker.setMaxValue(100)
            amountNumberPicker.setValue(1)
        }

        secondScreenBinding.secondScreenToMain.setOnClickListener {
            setContentView(binding1.root)
        }

        addProductBinding.AddProductBackToMain.setOnClickListener{
            setContentView(binding1.root)
        }

//        addProductBinding.AddProductAddProductButton{
//            setContentView(binding1.root)
//        }





        ViewCompat.setOnApplyWindowInsetsListener(binding1.mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }





    }
}