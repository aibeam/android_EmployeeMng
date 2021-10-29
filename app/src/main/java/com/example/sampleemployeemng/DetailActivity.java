package com.example.sampleemployeemng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView detName, detAge, detMobile;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detName = findViewById(R.id.detName);
        detAge = findViewById(R.id.detAge);
        detMobile = findViewById(R.id.detMobile);

        Intent intent = getIntent();
        employee = intent.getParcelableExtra("employee");
        detName.setText(employee.getName()+"");
        detAge.setText(employee.getAge()+"");
        detMobile.setText(employee.getMobile()+"");
    }

    public void delete(View view) {
        MySQLiteHandler handler = MySQLiteHandler.open(this);
        handler.delete(employee.getId());
        Toast.makeText(this,"삭제되었습니다.",Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    public void modify(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }
}
