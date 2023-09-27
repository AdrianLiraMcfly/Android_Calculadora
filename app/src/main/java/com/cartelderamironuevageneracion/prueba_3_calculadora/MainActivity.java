package com.cartelderamironuevageneracion.prueba_3_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals, btnClear;
    private double num1, num2;
    private String operator;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.text);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnplus);
        btnMinus = findViewById(R.id.btnmin);
        btnMultiply = findViewById(R.id.btnpor);
        btnDivide = findViewById(R.id.btndiv);
        btnEquals = findViewById(R.id.btneq);
        btnClear = findViewById(R.id.btnac);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        operator = "";
        decimalFormat = new DecimalFormat("#.##########");


    }
    @Override
    public void onClick(View v) {
        String buttonText = ((Button) v).getText().toString();
        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                editText.append(buttonText);
                break;
            case "+":
            case "-":
            case "X":
            case "/":
                num1 = Double.parseDouble(editText.getText().toString());
                operator = buttonText;
                editText.setText("");
                break;
            case "=":
                num2 = Double.parseDouble(editText.getText().toString());
                double result = performOperation(num1, num2, operator);
                editText.setText(decimalFormat.format(result));
                break;
            case "AC":
                editText.setText("");
                operator = "";
                num1 = 0;
                num2 = 0;
                break;
        }
    }

    private double performOperation(double num1, double num2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "X":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Error: Division by zero", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return result;
    }
}
