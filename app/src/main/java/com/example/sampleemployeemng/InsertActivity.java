package com.example.sampleemployeemng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    EditText name, age, mobile;
    Button save, goBack;

    MySQLiteHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        handler = MySQLiteHandler.open(this);
        name = (EditText) findViewById(R.id.editName);
        age = (EditText) findViewById(R.id.editAge);
        mobile = (EditText) findViewById(R.id.editMobile);

        save = (Button) findViewById(R.id.btnInsert);
        save.setOnClickListener(v -> {
            if(name==null || name.equals("")) {
                Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                name.requestFocus();
                return;
            }
            if(age==null || age.equals("")) {
                Toast.makeText(this, "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                age.requestFocus();
                return;
            }
            if(mobile==null || mobile.equals("")) {
                Toast.makeText(this, "연락처를 입력하세요.", Toast.LENGTH_SHORT).show();
                mobile.requestFocus();
                return;
            }
            insertRecord();
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
    private void insertRecord(){
        if(database==null){
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }
        if(tablename == null){
            println("테이블을 먼저 생성하세요.");
            return;
        }
        database.execSQL("insert into " + tablename + "(name, writer, contents) " + " values " + "('" + book.getName() + "' , '"+ book.getWriter() + "' , '" + book.getContents() + "')" );
        println("레코드 추가됨");

    }
}