package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test_page_math extends AppCompatActivity {
    Button easy,medium,hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page_math);
        easy=findViewById(R.id.easy);
        medium=findViewById(R.id.medium);
        hard=findViewById(R.id.hard);


        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(test_page_math.this,question_math_easy.class);
                startActivity(sec);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(test_page_math.this,question_math_medium.class);
                startActivity(sec);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(test_page_math.this,question_math_hard.class);
                startActivity(sec);
            }
        });
    }
}