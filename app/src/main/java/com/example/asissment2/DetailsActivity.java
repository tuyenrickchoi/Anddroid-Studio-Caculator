package com.example.asissment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView tvDetail;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvDetail = findViewById(R.id.tv_detail);
        Intent receivedIntent = getIntent();

        if (receivedIntent != null) {
            String data = receivedIntent.getStringExtra("operator");
            tvDetail.setText(data);
        }
    }
}