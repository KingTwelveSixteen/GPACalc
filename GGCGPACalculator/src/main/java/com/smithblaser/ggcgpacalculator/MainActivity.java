package com.smithblaser.ggcgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText gpaEditText;
    private EditText creditHoursEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpaEditText = (EditText) findViewById(R.id.input_gpa);
        creditHoursEditText = (EditText) findViewById(R.id.input_credit_hours);
        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getBaseContext(),SemesterActivity.class);
                intent.putExtra("gpa", Float.parseFloat(gpaEditText.getText().toString()));
                intent.putExtra("hours",Integer.parseInt(creditHoursEditText.getText().toString()));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
