package com.deepconnect.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {
    String bmi_value,final_answer;
    TextView Bmi_tv , FinalAnswer_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        BindViews();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
           bmi_value = extras.getString("bmi_value");
          final_answer = extras.getString("Final_answer");
        }
        else{
            Toast.makeText(ResultsActivity.this,"problem with intent bundle",Toast.LENGTH_SHORT).show();

        }

        Bmi_tv.setText(bmi_value);
        FinalAnswer_tv.setText(final_answer);
        Toast.makeText(this, " " + bmi_value, Toast.LENGTH_SHORT).show();

    }

    private void BindViews(){
        Bmi_tv = findViewById(R.id.tv_bmi);
        FinalAnswer_tv = findViewById(R.id.tv_finalAnswer);
    }

}
