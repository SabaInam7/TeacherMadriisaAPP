package com.example.teacherquranapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_update extends AppCompatActivity {

    EditText ETname, ETrollNo,ETsabq,ETsabqi,ETmanzil;
    Button updateBtn, deleteBtn;
    String id, rollNo, name, sabq,sabqi,manzil;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        deleteBtn=findViewById(R.id.DeleteButton);
        updateBtn=findViewById(R.id.UpdateButton);
        ETmanzil=findViewById(R.id.ETManzil2);
        ETname=findViewById(R.id.ETName2);
        ETsabq=findViewById(R.id.ETSabq2);
        ETsabqi=findViewById(R.id.ETSabqi2);
        ETrollNo=findViewById(R.id.ETRollNo2);
        getAndSetIntentData();
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHandler(activity_update.this);
                name = ETname.getText().toString().trim();
                rollNo = ETrollNo.getText().toString().trim();
                sabq = ETsabq.getText().toString().trim();
                sabqi = ETsabqi.getText().toString().trim();
                manzil = ETmanzil.getText().toString().trim();
                Student student = new Student(name, rollNo, sabq, sabqi, manzil);
                if(db.updateData(student)==false)
                {

                    Toast.makeText(activity_update.this, "Data is not Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity_update.this, student.getRollNo(), Toast.LENGTH_SHORT).show();

                }

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                db = new DBHandler(activity_update.this);

                rollNo = ETrollNo.getText().toString().trim();

                if( db.deleteData(rollNo)==false)
                {

                    Toast.makeText(activity_update.this, "Not deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity_update.this,"deleted successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("rollNo") &&
                getIntent().hasExtra("name") && getIntent().hasExtra("sabq") && getIntent().hasExtra("sabqi")
                && getIntent().hasExtra("manzil")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            rollNo = getIntent().getStringExtra("rollNo");
            name = getIntent().getStringExtra("name");
            sabq = getIntent().getStringExtra("sabq");
            sabqi=getIntent().getStringExtra("sabqi");
            manzil=getIntent().getStringExtra("manzil");

            //Setting Intent Data
            ETrollNo.setText(rollNo);
            ETname.setText(name);
            ETsabq.setText(sabq);
            ETsabqi.setText(sabqi);
            ETmanzil.setText(manzil);
            //Log.d("stev", title+" "+author+" "+pages);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }
}