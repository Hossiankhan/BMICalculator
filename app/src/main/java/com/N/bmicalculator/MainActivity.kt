package com.N.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.N.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val weight=binding.KGWeight.text.toString()
            val height=binding.FootHeight.text.toString().toDouble()
                val BMI=weight.toFloat() / (((height.toFloat()*30.48)/100) * ((height.toFloat()*30.48)/100))
                val bmi= String.format("%.2f",BMI)
                  displayResult(bmi)
        }

    }
    private fun displayResult(bmistr:String){

       binding.BMIIndex.text = bmistr.toString()
        binding.BMIInfo.text = "(Normal range is 18.5 - 24.9 )"

        var resultText = ""
        var color = 0
        val bmi =bmistr.toFloat()
        when{
            bmi<18.50 ->{
                resultText = "Underweight"
                color = R.color.under_weight
                Toast.makeText(this,"Try to Eat healthy food.", Toast.LENGTH_LONG).show()
            }
            bmi in 18.50..24.99->{
                resultText = "Healthy"
                color =R.color.normal
                Toast.makeText(this,"You are Healthy. Keep Eating healthy food.", Toast.LENGTH_LONG).show()
            }
            bmi in 25.00..29.99->{
                resultText = "Overweight"
                color = R.color.over_weight
                Toast.makeText(this,"Try to Eat healthy food and go to the gim.", Toast.LENGTH_LONG).show()
            }
            bmi > 29.99 -> {
                resultText ="Obesity"
                color = R.color.obese
                Toast.makeText(this,"Try to Eat healthy food and go to the gim.", Toast.LENGTH_LONG).show()
            }

        }
        binding.BMIResult.setTextColor(ContextCompat.getColor(this,color))
        binding.BMIResult.text = resultText

    }
}