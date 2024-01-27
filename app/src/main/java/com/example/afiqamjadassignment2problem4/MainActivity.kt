package com.example.afiqamjadassignment2problem4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val equalsButton = findViewById<Button>(R.id.equalsButton)
        val first  = findViewById<EditText>(R.id.firstOperand)
        val second = findViewById<EditText>(R.id.secondOperand)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val answer = findViewById<TextView>(R.id.finalResult)

        equalsButton.setOnClickListener{
            val selectedRadioButton = radioGroup.checkedRadioButtonId
            val radioButtonID = findViewById<RadioButton>(selectedRadioButton)
            val radioButtonText = radioButtonID.text.toString()
            val firstValue = first.text.toString().toDouble()
            val secondValue = second.text.toString().toDouble()
            var value = ""
            if (radioButtonText == "+") {
                value = (firstValue + secondValue).toString()
            }
            else if (radioButtonText == "-") {
                value = (firstValue - secondValue).toString()
            }
            else if (radioButtonText == "x") {
                value = (firstValue * secondValue).toString()
            }
            else if (radioButtonText == "/") {
                if (secondValue == 0.0 ) {
                    Toast.makeText(this, "Number cannot be divided by 0!", Toast.LENGTH_SHORT).show()
                }
                else {
                    value = (firstValue / secondValue).toString()
                }
            }
            else {
                value = (firstValue % secondValue).toString()
                if (value == "NaN") {
                    Toast.makeText(this, "You can't modulus 0!", Toast.LENGTH_SHORT).show()
                    value = ""
                }
            }
            answer.text = value
        }
    }
}