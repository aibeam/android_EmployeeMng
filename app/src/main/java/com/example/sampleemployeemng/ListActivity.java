package com.example.sampleemployeemng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EmployeeAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    MySQLiteHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        ArrayList<Employee> list = new ArrayList<>();
        handler = MySQLiteHandler.open(this);
        handler.select(list);
        adapter = new EmployeeAdapter(list);

        adapter.setOnEmployeeItemClickListener(new OnEmployeeItemClickListener() {
            @Override
            public void onItemClick(EmployeeAdapter.ViewHolder holder, View v, int position) {
                Employee item = adapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), EmployeeCardView.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Employee> list = new ArrayList<>();
        handler = MySQLiteHandler.open(this);
        handler.select(list);
        adapter.updateData(list);
    }
}