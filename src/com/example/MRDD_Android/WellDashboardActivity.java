package com.example.MRDD_Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kevin on 1/31/2015.
 */
public class WellDashboardActivity extends Activity {

    private Button addCurveButton;
    private String title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.well_dashboard);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        title = getIntent().getStringExtra("title") + " Dashboard";
        setTitle(title);

        addCurveButton = (Button) findViewById(R.id.add_curve_btn);
        addCurveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WellDashboardActivity.this, AddCurveActivity.class);
                startActivity(intent);

            }
        });
    }
}
