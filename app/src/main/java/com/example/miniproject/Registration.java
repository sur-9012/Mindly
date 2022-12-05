package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText username, password, email, phone;
    Button Register;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username=findViewById(R.id.username);
        password=findViewById(R.id.Password);
        email=findViewById(R.id.Email);
        phone=findViewById(R.id.Phone);
        Register=findViewById(R.id.register);
        DB=new DBHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass=email.getText().toString();


                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(Registration.this, "All field must be filled", Toast.LENGTH_SHORT).show();
                else {
                    if(pass!=repass) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Registration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registration.this, "Registration not successful", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Registration.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Registration.this,"Password not matching",Toast.LENGTH_SHORT).show();

                    }
                }
                Intent intent= new Intent(Registration.this,MainActivity.class);
                startActivity(intent);
            }

        });

    }
}