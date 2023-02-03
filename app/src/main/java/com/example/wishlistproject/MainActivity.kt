package com.example.wishlistproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var wishlistItems: MutableList<WishlistItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistItemsRv)
        val nameInput = findViewById<EditText>(R.id.wishlistItemName)
        val descInput = findViewById<EditText>(R.id.wishlistItemDesc)
        val amtInput = findViewById<EditText>(R.id.wishlistItemAmt)
        val submitButton = findViewById<Button>(R.id.wishlistItemSubmit)
        val listAdapter = WishlistAdapter(wishlistItems)
        wishlistRv.adapter = listAdapter
        wishlistRv.layoutManager = LinearLayoutManager(this)
        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val desc = descInput.text.toString()
            val amt = amtInput.text.toString()
            if(name.isNotEmpty()){
                val wishlistItem = WishlistItem(name, amt, desc)
                wishlistItems.add(wishlistItem)
                listAdapter.notifyDataSetChanged()
            }
        }
    }
}