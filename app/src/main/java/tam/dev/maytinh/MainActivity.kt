package tam.dev.maytinh

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var lastValue: Double = 0.0
    private var currentOperator: String = ""
    private var isNewOp: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                val btn = it as Button
                numberClick(btn.text.toString())
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener { operatorClick("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { operatorClick("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { operatorClick("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { operatorClick("/") }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            tvDisplay.text = "0"
            lastValue = 0.0
            currentOperator = ""
            isNewOp = true
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            calculateResult()
        }
    }

    private fun numberClick(number: String) {
        if (isNewOp) {
            tvDisplay.text = ""
        }
        isNewOp = false
        val currentText = tvDisplay.text.toString()
        if (currentText == "0") {
            tvDisplay.text = number
        } else {
            tvDisplay.append(number)
        }
    }

    private fun operatorClick(op: String) {
        lastValue = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        currentOperator = op
        isNewOp = true
    }

    private fun calculateResult() {
        val currentValue = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        var result = 0.0
        when (currentOperator) {
            "+" -> result = lastValue + currentValue
            "-" -> result = lastValue - currentValue
            "*" -> result = lastValue * currentValue
            "/" -> {
                if (currentValue != 0.0) {
                    result = lastValue / currentValue
                } else {
                    tvDisplay.text = "Error"
                    isNewOp = true
                    return
                }
            }
            else -> result = currentValue
        }
        
        // Định dạng hiển thị: bỏ đuôi .0 nếu là số nguyên
        tvDisplay.text = if (result % 1 == 0.0) result.toLong().toString() else result.toString()
        isNewOp = true
        currentOperator = ""
    }
}