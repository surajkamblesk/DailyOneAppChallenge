package com.deepconnect.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ResultsActivity extends AppCompatActivity {
    String bmi_value,final_answer;
    TextView Bmi_tv , FinalAnswer_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        BindViews();
        Bundle extras = getIntent().getExtras();

//        GraphView graph =  findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);


        if (extras != null) {
           bmi_value = extras.getString("bmi_value");
          final_answer = extras.getString("Final_answer");
        }
        else{
            Toast.makeText(ResultsActivity.this,"problem with intent bundle",Toast.LENGTH_SHORT).show();

        }

        Bmi_tv.setText(bmi_value);
        FinalAnswer_tv.setText(final_answer);


    }

    private void BindViews(){
        Bmi_tv = findViewById(R.id.tv_bmi);
        FinalAnswer_tv = findViewById(R.id.tv_finalAnswer);
    }

}
