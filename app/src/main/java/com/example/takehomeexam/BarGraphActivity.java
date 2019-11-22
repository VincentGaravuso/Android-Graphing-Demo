package com.example.takehomeexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraphActivity extends AppCompatActivity {

    ArrayList<String> gradeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("GraphPreferences", MODE_PRIVATE);
        float aStudents = pref.getFloat("aStudents", 0);
        float bStudents = pref.getFloat("bStudents", 0);
        float cStudents = pref.getFloat("cStudents", 0);
        float dStudents = pref.getFloat("dStudents", 0);
        float fStudents = pref.getFloat("fStudents", 0);



        BarChart barChart = (BarChart) findViewById(R.id.myBarChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(aStudents, 0));
        entries.add(new BarEntry(bStudents, 1));
        entries.add(new BarEntry(cStudents, 2));
        entries.add(new BarEntry(dStudents, 3));
        entries.add(new BarEntry(fStudents, 4));

        BarDataSet barDataSet = new BarDataSet(entries, "Cells");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("A's");
        labels.add("B's");
        labels.add("C's");
        labels.add("D's");
        labels.add("F's");

        BarData data = new BarData(labels, barDataSet);
        barChart.setData(data);
        barChart.setDescription("");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextSize(15);
        barChart.animateY(3000);

    }
}
