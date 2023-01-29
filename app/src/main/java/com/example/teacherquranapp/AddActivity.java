package com.example.teacherquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    DBHandler db;
    Button btnInsert;
    EditText ETname, ETrollNo,ETsabq,ETsabqi,ETmanzil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        db = new DBHandler(this);
        btnInsert=findViewById(R.id.insertButton);
        ETmanzil=findViewById(R.id.ETManzil);
        ETname=findViewById(R.id.ETName);
        ETsabq=findViewById(R.id.ETSabq);
        ETsabqi=findViewById(R.id.ETSabqi);
        ETrollNo=findViewById(R.id.ETRollNo);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ETname.getText().toString();
                String rollno = ETrollNo.getText().toString();
                String sabq = ETsabq.getText().toString();
                String sabqi = ETsabqi.getText().toString();
                String manzil = ETmanzil.getText().toString();
                Student student = new Student(name, rollno, sabq, sabqi, manzil);
                if(db.insertStudent(student)==false)
                {
                    Toast.makeText(AddActivity.this, "Data is not Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddActivity.this, "Data is Inserted Successfully", Toast.LENGTH_SHORT).show();

                }
                db.ReadAllData();
            }
        });

    }
}