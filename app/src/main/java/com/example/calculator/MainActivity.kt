package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var input: TextView
    private lateinit var output: TextView
    private lateinit var btnZero: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button

    private lateinit var btnClear: Button
    private lateinit var btnBackspace: Button
    private lateinit var btnPercent: Button
    private lateinit var btnDivision: Button
    private lateinit var btnMultiplication: Button
    private lateinit var btnMinus: Button
    private lateinit var btnPlus: Button
    private lateinit var btnEquals: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        btnBackspace.setOnClickListener {
            val remove = input.text.dropLast(1)
            input.text = remove
        }

        btnZero.setOnClickListener {
            addToInputText("0")
        }
        btnOne.setOnClickListener {
            addToInputText("1")
        }
        btnTwo.setOnClickListener {
            addToInputText("2")
        }
        btnThree.setOnClickListener {
            addToInputText("3")
        }
        btnFour.setOnClickListener {
            addToInputText("4")
        }
        btnFive.setOnClickListener {
            addToInputText("5")
        }
        btnSix.setOnClickListener {
            addToInputText("6")
        }
        btnSeven.setOnClickListener {
            addToInputText("7")
        }
        btnEight.setOnClickListener {
            addToInputText("8")
        }
        btnNine.setOnClickListener {
            addToInputText("9")
        }

        btnDivision.setOnClickListener {
            addToInputText("/")
        }

        btnMultiplication.setOnClickListener {
            addToInputText("*")
        }
        btnMinus.setOnClickListener {
            addToInputText("-")
        }
        btnPlus.setOnClickListener {
            addToInputText("+")
        }

        btnEquals.setOnClickListener {
            var operation = ""

            input.text.forEach {
                if (!it.isDigit()) operation += it
            }

            val text = input.text.toString()
            var numbers = text.split("/", "*", "-", "+").toMutableList()

            var result = 0L

            for (i in operation.indices) {
                if (i == 0) {
                    result = calculate(numbers[i].toInt(), numbers[1].toInt(), operation[i])
                }else{
                    result = calculate(result.toInt(), numbers[i + 1].toInt(), operation[i])
                }
            }
            output.text = result.toString()
        }
    }

    private fun calculate(number: Int, number2: Int, operation: Char): Long {
        when (operation) {
            '/' -> {
                return (number.toDouble() / number2).toLong()
            }
            '*' -> {
                return (number.toDouble() * number2).toLong()
            }
            '-' -> {
                return (number.toDouble() - number2).toLong()
            }
            '+' -> {
                return (number.toDouble() + number2).toLong()
            }
        }
        return 0L
    }

    private fun initView() {
        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        btnZero = findViewById(R.id.btn_zero)
        btnOne = findViewById(R.id.btn_1)
        btnTwo = findViewById(R.id.btn_2)
        btnThree = findViewById(R.id.btn_3)
        btnFour = findViewById(R.id.btn_4)
        btnFive = findViewById(R.id.btn_5)
        btnSix = findViewById(R.id.btn_6)
        btnSeven = findViewById(R.id.btn_7)
        btnEight = findViewById(R.id.btn_8)
        btnNine = findViewById(R.id.btn_9)

        btnClear = findViewById(R.id.btn_ac)
        btnBackspace = findViewById(R.id.btn_backspace)
        btnPercent = findViewById(R.id.btn_percent)
        btnDivision = findViewById(R.id.btn_division)
        btnMultiplication = findViewById(R.id.btn_multiplication)
        btnMinus = findViewById(R.id.btn_minus)
        btnPlus = findViewById(R.id.btn_plus)
        btnEquals = findViewById(R.id.btn_equals)
    }

    @SuppressLint("SetTextI18n")
    private fun addToInputText(value: String) {
        input.text = input.text.toString() + value
    }
}