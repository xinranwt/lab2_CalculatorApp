package com.cs407.lab2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNum = findViewById(R.id.editNumber1);
        secondNum = findViewById(R.id.editNumber2);
    }

    private boolean checkInput() {
        try {
            Integer.parseInt(firstNum.getText().toString());
            Integer.parseInt(secondNum.getText().toString());
            return true;
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Error: Numbers should be valid integers", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void addition(View view) {
        if(checkInput()) {
            int num1 = Integer.parseInt(firstNum.getText().toString());
            int num2 = Integer.parseInt(secondNum.getText().toString());
            goToActivity(String.valueOf((double) num1 + num2));
        }
    }

    public void subtraction(View view) {
        if(checkInput()) {
            int num1 = Integer.parseInt(firstNum.getText().toString());
            int num2 = Integer.parseInt(secondNum.getText().toString());
            goToActivity(String.valueOf((double) num1 - num2));
        }
    }

    public void multiplication(View view) {
        if(checkInput()) {
            int num1 = Integer.parseInt(firstNum.getText().toString());
            int num2 = Integer.parseInt(secondNum.getText().toString());
            goToActivity(String.valueOf((double) num1 * num2));
        }
    }

    public void division(View view) {
        if(checkInput()) {
            double num1 = Double.parseDouble(firstNum.getText().toString());
            double num2 = Double.parseDouble(secondNum.getText().toString());
            if (Double.compare(num2, 0) == 0) {
                Toast.makeText(MainActivity.this,"ERROR: Should not devide by zero",Toast.LENGTH_LONG).show();
            } else {
                goToActivity(String.format( "%.1f",num1 / num2));
            }
        }
    }

    public void goToActivity(String s) {
        Log.i("INFO", s);
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("answer", s);
        startActivity(intent);
    }

}