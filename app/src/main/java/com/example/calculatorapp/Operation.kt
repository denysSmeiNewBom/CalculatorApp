package com.example.calculatorapp

enum class Operation(val sign: String) {
    PLUS("+") {
        override fun performOperation(first: Int, second: Int): Int {
            return first + second
        }
    },
    MINUS("-") {
        override fun performOperation(first: Int, second: Int): Int {
            return first - second
        }
    },
    DIVIDE("/") {
        override fun performOperation(first: Int, second: Int): Int {
            return first / second
        }
    },
    MULTIPLY("*") {
        override fun performOperation(first: Int, second: Int): Int {
            return first * second
        }
    };

    abstract fun performOperation(first: Int, second: Int): Int

    companion object{
        fun value(sign: String): Operation? {
            return values().firstOrNull { operation ->
                operation.sign == sign
            }
        }
    }
}