package com.example.debtcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DebtorList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, name, money, location, dateR;
    DatabaseHelper DB;
    MyAdapter adapter;

    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debtor_list);

        btnAdd =(Button)findViewById(R.id.btnAdd);
        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        money = new ArrayList<>();
        location = new ArrayList<>();
        dateR = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,name,money,location,dateR);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openReservation(); }
        });
    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(DebtorList.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                money.add(cursor.getString(2));
                location.add(cursor.getString(3));
                dateR.add(cursor.getString(4));
            }
        }
    }

    public void openReservation (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}