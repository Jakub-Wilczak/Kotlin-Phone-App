package com.example.przeterminarz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.przeterminarz.databinding.ItemProductBinding
import com.example.przeterminarz.model.Product
import java.text.ParseException
import java.text.SimpleDateFormat

class ProductItem(val itemViewBinding: ItemProductBinding) : RecyclerView.ViewHolder(itemViewBinding.root){
    fun onBind(productItem: Product) = with(itemViewBinding){
        productName.setText(productItem.name)
        productImage.setImageResource(productItem.productIcon)



        productDueDate.setText("${productItem.dueDate.date}/${productItem.dueDate.month+1}/${productItem.dueDate.year+1900}")
        productItemCount.setText(productItem.amount.toString())
        productCategoryImage.setImageResource(productItem.categoryIcon)
    }
}
class ProductListAdapter : RecyclerView.Adapter<ProductItem>() {

    var productList: List<Product> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(layoutInflater, parent, false)
        return ProductItem(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductItem, position: Int) {
        holder.onBind(productList[position])
    }
}