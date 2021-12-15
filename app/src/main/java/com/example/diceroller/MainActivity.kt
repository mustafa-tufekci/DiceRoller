package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDice: Button = findViewById(R.id.dice_button)

        btnDice.setOnClickListener{
            rolldice()
        }
        rolldice()
    }

    fun rolldice(){
        val image: ImageView = findViewById(R.id.imageView)
        val text: TextView = findViewById(R.id.dice_text)
        val dice = Dice(6)
        val rolledDice = dice.roll()

        val turnedImage = when(rolledDice){
            1 -> { R.drawable.dice_1 }
            2 -> { R.drawable.dice_2 }
            3 -> { R.drawable.dice_3 }
            4 -> { R.drawable.dice_4 }
            5 -> { R.drawable.dice_5 }
            6 -> { R.drawable.dice_6 }
            else -> R.drawable.dice_6
        }

        val turnedText = when(rolledDice){
            1 -> "Gimli"
            2 -> "Legolas"
            3 -> "Aragorn"
            4 -> "Gandalf"
            5 -> "Arven"
            6 -> "Frodo"
            else -> ""
        }
        image.setImageResource(turnedImage)
        text.setText(turnedText)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F);

    }
}

class Dice(val numSide: Int) {

    fun roll(): Int{
        return (1..numSide).random()
    }
}