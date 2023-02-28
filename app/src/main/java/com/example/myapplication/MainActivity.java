package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.SeekBar;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> itemLevel=new ArrayList<String>();
    EditText name,phone;
    Switch gender;
    Spinner level;
    SeekBar age;
    CheckBox sport;
    TextView valueSeekbar;
    Button save;
    String ageValue,levelValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText);
        phone= findViewById(R.id.editText2);
        gender= (Switch) findViewById(R.id.switch1);
        level=(Spinner) findViewById(R.id.spinner);
        age=(SeekBar) findViewById(R.id.seekBar);
        sport=(CheckBox) findViewById(R.id.checkBox);
        save= findViewById(R.id.button);
        valueSeekbar=findViewById(R.id.textView2);


        itemLevel.add("CĐ");
        itemLevel.add("ĐH");
        itemLevel.add("CH");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,itemLevel);
        level.setAdapter(adapter);
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueSeekbar.setText(String.valueOf(progress));
                ageValue=String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("phone",phone.getText().toString());
                intent.putExtra("gender",gender.isChecked());
                levelValue= level.getSelectedItem().toString();
                intent.putExtra("level",levelValue);
                intent.putExtra("age",ageValue);
                intent.putExtra("sport",sport.isChecked());
                RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
                String radioValue=((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                intent.putExtra("music",radioValue);
                startActivity(intent);


            }
        });


    }

}