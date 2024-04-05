package com.example.project5_2;

// 2021041023 김문기

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Button[] numButtons = new Button[10];
    int[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        textResult = findViewById(R.id.TextResult);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        int result = 0;
        if (num1 == null || num2 == null) {
            Toast.makeText(getApplicationContext(), "입력", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.BtnAdd) {
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
        } else if (view.getId() == R.id.BtnSub) {
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
        } else if (view.getId() == R.id.BtnMul) {
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
        } else if (view.getId() == R.id.BtnDiv) {
            result = Integer.parseInt(num1) / Integer.parseInt(num2);
        }

        textResult.setText("계산 결과 : " + result);
    }
}