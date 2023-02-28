package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity2 extends AppCompatActivity {
    TextView name, age, gender,phone,sport,music,level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.textView);
        phone=findViewById(R.id.textView3);
        gender=findViewById(R.id.textView4);
        level=findViewById(R.id.textView5);
        age=findViewById(R.id.textView6);
        sport=findViewById(R.id.textView7);
        music=findViewById(R.id.textView8);

        Intent intent=getIntent();
        String nameValue = intent.getStringExtra("name");
        name.setText(nameValue);
        String phoneValue = intent.getStringExtra("phone");
        phone.setText(phoneValue);
        boolean genderBln = intent.getBooleanExtra("gender",false);
        if(genderBln) {
            gender.setText("Nam");
        } else{
            gender.setText("Nữ");
        }
        String levelValue=intent.getStringExtra("level");
        level.setText(levelValue);
        String ageValue= intent.getStringExtra("age");
        age.setText(ageValue);
        boolean sportValue=intent.getBooleanExtra("sport",false);
        if (sportValue){
            sport.setText("có tham gia");
        }
        else{
            sport.setText("không tham gia");
        }
        String musicValue= intent.getStringExtra("music");
        music.setText(musicValue);
    }

}