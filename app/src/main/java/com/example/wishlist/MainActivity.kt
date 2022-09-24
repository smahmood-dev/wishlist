package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var allItems: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameEv)
        val priceInput = findViewById<EditText>(R.id.priceEv)
        val urlInput = findViewById<EditText>(R.id.urlEv)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        var items: MutableList<Item> = ArrayList()

        // Lookup the RecyclerView in activity layout
        val itemRv = findViewById<RecyclerView>(R.id.wishlistRv)
        // Fetch the list of wishes
        allItems = items
        // Create adapter passing in the list of wishes
        val adapter = ItemAdapter(allItems)
        // Attach the adapter to the RecyclerView to populate wishes
        itemRv.adapter = adapter
        // Set layout manager to position the wishes
        itemRv.layoutManager = LinearLayoutManager(this)

        submitBtn.setOnClickListener {
            var name = nameInput.text.toString()
            var price = priceInput.text.toString()
            var url = urlInput.text.toString()
            var itemTemp = Item(name, price, url)
            items.add(itemTemp)
            adapter.notifyDataSetChanged()
        }
    }
}