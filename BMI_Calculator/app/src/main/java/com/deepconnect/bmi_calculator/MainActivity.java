package com.deepconnect.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    EditText input_weight, input_height;
    Button btn_Calculate;
    TextView result;
    String ans;
    double bmi;


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


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }


    private void BindViews() {
        input_height = findViewById(R.id.ET_height);
        input_weight = findViewById(R.id.ET_weight);
        btn_Calculate = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.tv_result);
    }

    private void CalculateBMI() {
        String height, weight;
        height = input_height.getText().toString();
        weight = input_weight.getText().toString();
        if (Check(height, weight)) {
            input_weight.setError("Weight in numbers");
            input_height.setError("Weight in numbers");
        } else {

            double cms_height = Double.parseDouble(height) / 100;
            double weight_double = Double.parseDouble(weight);

            bmi = (weight_double) / (cms_height * cms_height);


            if (bmi >= 15 && bmi <= 16) {
                ans = "Very Severely Underweight";
            } else if (bmi >= 16 && bmi <= 18) {
                ans = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 25) {
                ans = "Normal";
            } else if (bmi >= 25 && bmi <= 30) {
                ans = "Overweight";
            } else if (bmi >= 30 && bmi <= 35) {
                ans = "Moderately Obese";
            } else if (bmi >= 35 && bmi <= 40) {
                ans = "Severely Obese";
            } else {
                ans = "very severely Obese";
            }

            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            int int_bmi = (int) Math.round(bmi);
            String str_bmi = Double.toString(int_bmi);
            intent.putExtra("bmi_value", str_bmi);
            Toast.makeText(MainActivity.this, " " + bmi, Toast.LENGTH_SHORT).show();
            intent.putExtra("Final_answer", ans);
            startActivity(intent);

        }


    }

    private boolean Check(String height, String weight) {


        return height.equals("") || weight.equals("") || height.matches("(^[a-zA-Z]*$)") || weight.matches("(^[a-zA-Z]*$)");
    }
}

