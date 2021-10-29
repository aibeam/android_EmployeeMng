package com.example.sampleemployeemng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText edName, edAge, edMobile;
    Button save, goBack;
    MySQLiteHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        handler = MySQLiteHandler.open(this);
        edName = (EditText) findViewById(R.id.editName);
        edAge = (EditText) findViewById(R.id.editAge);
        edMobile = (EditText) findViewById(R.id.editMobile);

        save = (Button) findViewById(R.id.btnInsert);
        save.setOnClickListener(v -> {
            String name = edName.getText().toString();
            String age = edAge.getText().toString();
            String mobile = edMobile.getText().toString();

            if(name==null || name.equals("")) {
                Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                edName.requestFocus();
                return;
            }
            if(age==null || age.equals("")) {
                Toast.makeText(getApplicationContext(), "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                edAge.requestFocus();
                return;
            }
            if(mobile==null || mobile.equals("")) {
                Toast.makeText(getApplicationContext(), "연락처를 입력하세요.", Toast.LENGTH_SHORT).show();
                edMobile.requestFocus();
                return;
            }
            try {
                handler.insert(name,Integer.parseInt(age), mobile);
            } catch (NumberFormatException e) {
                handler.insert(name,10, mobile);
            }
            Toast.makeText(getApplicationContext(), "저장", Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intent);
        });

        goBack = (Button) findViewById(R.id.btnCancle);
        goBack.setOnClickListener(v -> {
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}