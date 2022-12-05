package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class home_page extends AppCompatActivity {
   ImageView eng,math,logical,gk;
   Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        eng=findViewById(R.id.eng);
        math=findViewById(R.id.math);
        logical=findViewById(R.id.logic);
        gk=findViewById(R.id.GK);
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent sec=new Intent(home_page.this,test_page.class);
                        startActivity(sec);

            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(home_page.this,test_page_math.class);
                startActivity(sec);

            }
        });
        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(home_page.this,test_page_logical.class);
                startActivity(sec);

            }
        });
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sec=new Intent(home_page.this,test_page_gk.class);
                startActivity(sec);

            }
        });


    }
}