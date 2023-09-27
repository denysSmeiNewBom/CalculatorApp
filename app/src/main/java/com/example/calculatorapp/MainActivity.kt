package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var firstOperand: Float? = null
    var tvInput: TextView? = null
    var operation: Operation? = null
    var requireVannish = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        if (requireVannish) {
            tvInput?.text = ""
            requireVannish = false
        }
        tvInput?.append((view as Button).text)
    }

    fun onOperation(view: View) {
        val sign = (view as Button).text.toString()
        operation = Operation.value(sign)
        firstOperand = tvInput?.text.toString().toFloat()
        tvInput?.text = "0"
        requireVannish = true
    }

    fun onClr(view: View) {
        tvInput?.text = "0"

        operation = null
        requireVannish = true
    }

    fun onCalc(view: View) {
        val secondOperand = tvInput?.text.toString().toFloat()

        val calculationResult =
            firstOperand?.let { operation?.performOperation(it, secondOperand).toString() }
        val formattedResult = formatResult(calculationResult)
        tvInput?.text = formattedResult

        requireVannish = true
        operation = null
        requireVannish = true
    }

    private fun formatResult(calculationResult: String?): String? {
        if (calculationResult == "Infinity") return "Error"
        return calculationResult?.replace(".0$".toRegex(), "") ?: calculationResult
    }
}