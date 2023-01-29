package com.example.teacherquranapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LoggedIn extends AppCompatActivity {
    FloatingActionButton addButton;
    RecyclerView recyclerView;
    ArrayList<String> name , id, rollno, sabq, sabqi, manzil;
    DBHandler db;
    MyRVAdapter RvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        addButton = findViewById(R.id.floatingAddButton);
        recyclerView = findViewById(R.id.recyclerView);
        db = new DBHandler(this);
        name = new ArrayList<>();
        id= new ArrayList<>();
        rollno = new ArrayList<>();
        sabq = new ArrayList<>();
        sabqi = new ArrayList<>();
        manzil = new ArrayList<>();

        storeInArray();
        RvAdapter= new MyRVAdapter(LoggedIn.this,this,name,id,rollno,sabq,sabqi,manzil);
        recyclerView.setAdapter(RvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LoggedIn.this));
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedIn.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storeInArray(){
        Cursor cursor = db.ReadAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(LoggedIn.this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                //Log.d();
                id.add(cursor.getString(0));
                rollno.add(cursor.getString(1));
                name.add(cursor.getString(2));
                sabq.add(cursor.getString(3));
                sabqi.add(cursor.getString(4));
                manzil.add(cursor.getString(5));
            }

        }
    }
}


