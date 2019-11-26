package com.deepconnect.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input_weight, input_height;
    Button btn_Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViews();
        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculateBMI();
            }
        });

    }

    private void BindViews() {
        input_height = findViewById(R.id.ET_height);
        input_weight = findViewById(R.id.ET_weight);
        btn_Calculate = findViewById(R.id.btn_calculate);
    }

    private void CalculateBMI()
    {
        Toast.makeText(MainActivity.this, "Button caught", Toast.LENGTH_SHORT).show();
    }
}

