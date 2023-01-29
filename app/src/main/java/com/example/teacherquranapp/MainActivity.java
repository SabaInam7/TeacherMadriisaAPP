package com.example.teacherquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button _btnLogin;
    EditText _etName;
    EditText _etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnLogin = findViewById(R.id.btnLogin);
        _etName=findViewById(R.id.editTextName);
        _etPassword=findViewById(R.id.editTextPassword);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = _etName.getText().toString();
                String password = _etPassword.getText().toString();

                if(name.equals("admin") && password.equals("123")){
                    Intent intent = new Intent(MainActivity.this, LoggedIn.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}