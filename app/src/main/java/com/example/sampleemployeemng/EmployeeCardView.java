package com.example.sampleemployeemng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeCardView extends AppCompatActivity {
    TextView textName, textAge, textMobile;
    public static final String KEY_SIMPLE_DATA = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_card_view);
        textName = findViewById(R.id.textName);
        textAge = findViewById(R.id.textAge);
        textMobile = findViewById(R.id.textMobile);
        Intent intent = getIntent();
        processIntent(intent);
    }

    public void goBack(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            Employee data = bundle.getParcelable(KEY_SIMPLE_DATA);
            if (data != null) {
                textName.setText(data.getName());
                textAge.setText(""+data.getAge());
                textMobile.setText(data.getMobile());
            }
        }
    }
}