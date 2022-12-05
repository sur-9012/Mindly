


package com.example.miniproject;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;

        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;


public class question_eng_easy extends AppCompatActivity {

    TextView tv;
    Button submitbutton,next;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    String questions[] = {
            "Which of these indicates the right part of speech for 'beautiful'?",
            "What do you call the father of your father?",
            "Choose the right spelling",
            "Which of these is a noun?",
            "Ram ____ to listen to music"

    };
    String answers[] = {"Adjective","Grandfather","Tomorrow","India","likes"};
    String opt[] = {
            "Pronoun","Noun","Adjective","Preposition",
            "Grandfather","Uncle","Cousin","Brother",
            "Tomorow","Tommoro","Tomorrow","Tommorrow",
            "India","Small","Under","Running",
            "listens","like","likes","listening"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eng_easy);
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
                } /*else {
                    next.setText("Submit");
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), analytics_page.class);
                    in.putExtra("correct",correct);
                    in.putExtra("incorrect",wrong);
                    startActivity(in);
                }*/
                else {
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
                /*submitbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        marks=correct;
                        SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
                        SharedPreferences.Editor myedit=sharedPreferences.edit();
                        myedit.putInt("correct",correct);
                        myedit.putInt("incorrect",wrong);
                        myedit.apply();
                        Intent in = new Intent(getApplicationContext(),analytics_page.class);
                        startActivity(in);
                    }
                });*/
            }
        });
    }
}



