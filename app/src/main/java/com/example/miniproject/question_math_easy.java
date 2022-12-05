package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question_math_easy extends AppCompatActivity {


    TextView tv;
    Button submitbutton, next;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    String questions[] = {
            "Using the digits 1, 2, 3, 4 without repetition, the greatest 4-digit number that can be made is",
            "The successor of 99 is",
            "Perimeter of a square =",
            "Area of a rectangle of length l and breadth b is",
            "On a number line, when we subtract a negative integer, we"

    };
    String answers[] = {"4321", "100", "4*SIDE", "l*b", "move to the right"};
    String opt[] = {
            "4321", "4312", "3214", "4123",
            "99", "98", "100", "97",
            "SIDE*SIDE", "a+b", "4*SIDE", "2*SIDE",
            "l*b", "l+b", "2*l*b", "2(l+b)",
            "move to the right", "move to the left", "do not move at all", "none of these"
    };
    int flag = 0;
    int marks = 0;
    int correct = 0;
    int wrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_math_easy);
        next = findViewById(R.id.next);
        //submitbutton = findViewById(R.id.submit);
        tv = (TextView) findViewById(R.id.ques);
        radio_g = (RadioGroup) findViewById(R.id.rd);
        rb1 = (RadioButton) findViewById(R.id.o1);
        rb2 = (RadioButton) findViewById(R.id.o2);
        rb3 = (RadioButton) findViewById(R.id.o3);
        rb4 = (RadioButton) findViewById(R.id.o4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if (ansText.equals(answers[flag])) {
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    wrong++;
                }
                flag++;


                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    next.setText("Submit");
                    marks = correct;
                    SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putInt("correct",correct);
                    myedit.putInt("incorrect",wrong);
                    myedit.apply();
                    Intent in = new Intent(getApplicationContext(), analytics_page.class);
                    startActivity(in);
                }
                radio_g.clearCheck();

            }
        });
    }
}