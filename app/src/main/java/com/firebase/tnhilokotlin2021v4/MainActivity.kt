package com.firebase.tnhilokotlin2021v4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import java.util.*

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var randomNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListenerForButton()
    }
    fun generateRandomNumber():Int{
        var random = Random()
        var min=1
        var max=10
        randomNum = random.nextInt(max+1-min) + min
        return randomNum
    }
    fun assignRandomNumber(){
        randomNum = generateRandomNumber()
    }
    fun guessNumber(){
        var numberToGuess = randomNum
       // val numGuess = findViewById(R.id.numGuess)
        var userGuess:Int = Integer.parseInt(numGuess.getText().toString())
        checkUserGuess(userGuess, numberToGuess)
    }
    fun checkUserGuess(userGuess:Int,numberToGuess:Int){
        if(userGuess > numberToGuess){
            lblFeedback.setText("Lower")
        } else if(userGuess < numberToGuess) {
            lblFeedback.setText("Higher")
        } else {
            lblFeedback.setText("Correct!")
            openCorrectGuessScreen()
        }
    }
    fun createListenerForButton(){
        btnGuess.setOnClickListener{
            guessNumber()
        }
    }
    fun openCorrectGuessScreen(){
        val intent = Intent("com.firebase.tnhilokotlin2021v4.CorrectGuessActivity")
        startActivity(intent)
    }
}