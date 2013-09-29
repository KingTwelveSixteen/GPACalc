package com.smithblaser.ggcgpacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SemesterActivity extends Activity
{
    private EditText classOneHoursEditText;
    private EditText classOneGradeEditText;
    private EditText classTwoHoursEditText;
    private EditText classTwoGradeEditText;
    private EditText classThreeHoursEditText;
    private EditText classThreeGradeEditText;
    private EditText classFourHoursEditText;
    private EditText classFourGradeEditText;
    private TextView newGPATextView;
    private Button submitButton;

    private int hours;
    private float gpa;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        processIntent();

        classOneHoursEditText = (EditText) findViewById(R.id.input_class_one_hours);
        classOneGradeEditText = (EditText) findViewById(R.id.input_class_one_grade);
        classTwoHoursEditText = (EditText) findViewById(R.id.input_class_two_hours);
        classTwoGradeEditText = (EditText) findViewById(R.id.input_class_two_grade);
        classThreeHoursEditText = (EditText) findViewById(R.id.input_class_three_hours);
        classThreeGradeEditText = (EditText) findViewById(R.id.input_class_three_grade);
        classFourHoursEditText = (EditText) findViewById(R.id.input_class_four_hours);
        classFourGradeEditText = (EditText) findViewById(R.id.input_class_four_grade);
        newGPATextView = (TextView) findViewById(R.id.text_new_gpa);

        submitButton = (Button) findViewById(R.id.button_submit);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                newGPATextView.setText(Float.toString(calculateGPA()));
            }
        });
    }

    private void processIntent() {
        Intent receivedIntent = getIntent();
        gpa = receivedIntent.getFloatExtra("gpa", 0);
        hours = receivedIntent.getIntExtra("hours", 0);
    }

    private float calculateGPA()
    {
        float hours1 = Float.parseFloat(classOneHoursEditText.getText().toString());
        float hours2 = Float.parseFloat(classTwoHoursEditText.getText().toString());
        float hours3 = Float.parseFloat(classThreeHoursEditText.getText().toString());
        float hours4 = Float.parseFloat(classFourHoursEditText.getText().toString());

        float oldPoints = gpa * hours;
        float class1 = hours1 * Float.parseFloat(classOneGradeEditText.getText().toString());
        float class2 = hours2 * Float.parseFloat(classTwoGradeEditText.getText().toString());
        float class3 = hours3 * Float.parseFloat(classThreeGradeEditText.getText().toString());
        float class4 = hours4 * Float.parseFloat(classFourGradeEditText.getText().toString());

        float totalPoints = oldPoints + class1 + class2 + class3 + class4;
        float totalHours = hours + hours1 + hours2 + hours3 + hours4;

        return totalPoints / totalHours;

    }
}