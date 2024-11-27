package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.textView1);
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonClr = findViewById(R.id.button_clr);
        Button buttonPoint = findViewById(R.id.button_point);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonMul = findViewById(R.id.button_mul);
        Button buttonSub = findViewById(R.id.button_minus);
        Button buttonMod = findViewById(R.id.button_modulo);
        Button buttonDevide = findViewById(R.id.button_devide);
        Button buttonEquals = findViewById(R.id.button_result);
        Button buttonSqrt = findViewById(R.id.button_sqrt);
        Button buttonPW = findViewById(R.id.button_power);
        button0.setOnClickListener(view -> appendToInput("0"));
        button1.setOnClickListener(view -> appendToInput("1"));
        button2.setOnClickListener(view -> appendToInput("2"));
        button3.setOnClickListener(view -> appendToInput("3"));
        button4.setOnClickListener(view -> appendToInput("4"));
        button5.setOnClickListener(view -> appendToInput("5"));
        button6.setOnClickListener(view -> appendToInput("6"));
        button7.setOnClickListener(view -> appendToInput("7"));
        button8.setOnClickListener(view -> appendToInput("8"));
        button9.setOnClickListener(view -> appendToInput("9"));
        buttonClr.setOnClickListener(view -> appendToInput(""));
        buttonPoint.setOnClickListener(view -> appendToInput("."));
        buttonAdd.setOnClickListener(view -> setOperator("+"));
        buttonMul.setOnClickListener(view -> setOperator("x"));
        buttonMod.setOnClickListener(view -> setOperator("%"));
        buttonSub.setOnClickListener(view -> setOperator("-"));
        buttonDevide.setOnClickListener(view -> setOperator("÷"));
        buttonSqrt.setOnClickListener(view->setOperator("S"));
        buttonPW.setOnClickListener(view->setOperator("^"));
        buttonEquals.setOnClickListener(view -> calculateResult());


    }

    private void appendToInput(String digit) {
        if (!digit.isEmpty()) {
            currentInput += digit;
            resultTextView.setText(currentInput);
        } else {
            resultTextView.setText("");
            currentInput="";
        }
    }


    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateResult();
            }
            firstNumber = Double.parseDouble(resultTextView.getText().toString());
            operator = op;
            currentInput = "";
        }
    }



    private void calculateResult() {
        if (!currentInput.isEmpty() || !operator.isEmpty()) {
            double secondNumber = currentInput.isEmpty() ? 0 : Double.parseDouble(currentInput);
            double result = firstNumber;

            switch (operator) {
                case "+":
                    result += secondNumber;
                    break;
                case "x":
                    result *= secondNumber;
                    break;
                case "-":
                    result -= secondNumber;
                    break;
                case "÷":
                    result /= secondNumber;
                    break;
                case "%":
                    result = (firstNumber * secondNumber) / 100;
                    break;
                case "S":
                    result = Math.sqrt(firstNumber);
                    break;
                case "^":
                    result = Math.pow(firstNumber, 2);
                    break;
            }

            firstNumber = result;
            resultTextView.setText(String.valueOf(result));
            currentInput = resultTextView.toString();
            operator = "";
        }
    }

}
