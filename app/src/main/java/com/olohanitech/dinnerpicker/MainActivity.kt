package com.olohanitech.dinnerpicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("MoMo","Jeri Swari","Thakali Bhojan", "Newari Khaja Set", "Nepali Khana Set")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decideFood()
        decideButton.setOnClickListener{
            decideFood()
        }

        addFoodButton.setOnClickListener{
            addFood()
        }
    }

    private fun addFood() {
        val food = addFoodText.text.toString()
        if(food != ""){
            foodList.add(food)
            Toast.makeText(this,food + " Added",Toast.LENGTH_SHORT).show()
            addFoodText.text.clear()
        }else{
            Toast.makeText(this, "Empty! Failed to add.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun decideFood() {
        val random = Random()
        val randomFood = random.nextInt(foodList.count())
        selectedFoodText.text = foodList[randomFood]
    }
}
