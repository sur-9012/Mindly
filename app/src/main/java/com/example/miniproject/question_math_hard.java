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

public class question_math_hard extends AppCompatActivity {

    TextView tv;
    Button submitbutton, next;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    String questions[] = {
            "Total number of possible matrices of order 3 × 3 with each entry 2 or 0 is",
            "If A and B are two matrices of the order 3 × m and 3 × n, respectively, and m = n, then the order of matrix (5A – 2B) is",
            "The equation of the normal to the curve y = sin x at (0, 0) is",
            "The absolute maximum value of y = x3 – 3x + 2 in 0 ≤ x ≤ 2 is",
            "Let the f: R → R be defined by f(x) = 2x + cos x, then f"

    };
    String answers[] = {"512", "3×n", "x+y=0", "4", "is an increasing function"};
    String opt[] = {
            "9", "27", "81", "512",
            "m*3", "3*3", "3*n", "m*n",
            "x=0", "y=0", "x+y=0", "x-y=0",
            "0", "2", "4", "3",
            "has a maximum, at x = 0", "has a minimum at x = 3t", "is an increasing function", "is a decreasing function"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_math_hard);
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
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
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
                    /*else
                    {
                        marks=correct;
                        Intent in = new Intent(getApplicationContext(),analytics_page.class);
                        startActivity(in);
                    } */
                radio_g.clearCheck();

            }
        });

    }
}