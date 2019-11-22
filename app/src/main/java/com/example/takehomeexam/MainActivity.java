package com.example.takehomeexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText totalNumStudents;
    EditText aStudents;
    EditText bStudents;
    EditText cStudents;
    EditText dStudents;
    EditText fStudents;
    //Button computeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalNumStudents = findViewById(R.id.numStudentsEditText);
        aStudents = findViewById(R.id.aStudentsEditText);
        bStudents = findViewById(R.id.bStudentsEditText);
        cStudents = findViewById(R.id.cStudentsEditText);
        dStudents = findViewById(R.id.dStudentsEditText);
        fStudents = findViewById(R.id.fStudentsEditText);
    }

    private boolean isValid()
    {
        if(aStudents.getText().toString().isEmpty() ||
                bStudents.getText().toString().isEmpty() ||
                cStudents.getText().toString().isEmpty() ||
                dStudents.getText().toString().isEmpty() ||
                fStudents.getText().toString().isEmpty())
        {
            return false;
        }
        return true;
    }
    public void ComputeButtonClicked(View view)
    {
        if(isValid())
        {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("GraphPreferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putFloat("aStudents", Float.parseFloat(aStudents.getText().toString()));
            editor.putFloat("bStudents", Float.parseFloat(bStudents.getText().toString()));
            editor.putFloat("cStudents", Float.parseFloat(cStudents.getText().toString()));
            editor.putFloat("dStudents", Float.parseFloat(dStudents.getText().toString()));
            editor.putFloat("fStudents", Float.parseFloat(fStudents.getText().toString()));
            editor.commit();

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setMessage("The percentages of grade distribution are:" +
                    "\nA's: " + aStudents.getText().toString() +
                    "\nB's: " + bStudents.getText().toString() +
                    "\nC's: " + cStudents.getText().toString() +
                    "\nD's: " + dStudents.getText().toString() +
                    "\nF's: " + fStudents.getText().toString());
            alertBuilder.setPositiveButton("Show Graph", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    displayGraphActivity();
                }
            });
            alertBuilder.show();
        }
        else
        {
            Snackbar.make(view, "All fields must be filled out!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
    private void displayGraphActivity()
    {
        Intent intent = new Intent(this, BarGraphActivity.class);
        startActivity(intent);
    }
}
