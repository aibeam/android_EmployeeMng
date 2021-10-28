package com.example.sampleemployeemng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);

        btnInsert.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
            startActivity(intent);
        });
        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intent);
    });
    }
}