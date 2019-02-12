package com.kdh.pc.day05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button b1;
    EditText editText1;
    EditText editText2;
    TextView textView;
    RadioGroup radioGroup;
    CheckBox checkBox[]=new CheckBox[6];
    Spinner spinner;
    String message;
    String tx;
    String text;
    String pre;
    Stack<String> s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        linearLayout=findViewById(R.id.l1);
        editText1=findViewById(R.id.et1);
        editText2=findViewById(R.id.et2);
        textView=findViewById(R.id.tv1);
        textView=findViewById(R.id.tv2);
        radioGroup=findViewById(R.id.rdg1);
        checkBox[0]=findViewById(R.id.ch1);
        checkBox[1]=findViewById(R.id.ch2);
        checkBox[2]=findViewById(R.id.ch3);
        checkBox[3]=findViewById(R.id.ch4);
        checkBox[4]=findViewById(R.id.ch5);
        checkBox[5]=findViewById(R.id.ch6);
        spinner=findViewById(R.id.sp);
        s=new Stack<>();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                message=(String)spinner.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//spinner리스너
        for(int i=0;i<checkBox.length;i++){
            checkBox[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j=0;j<checkBox.length;j++){
                        if(checkBox[j].isChecked()){
                            int id=checkBox[j].getId();
                            CheckBox ch=findViewById(id);
                            tx=ch.getText().toString();
                        }
                    }

                }
            });
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id1=editText1.getId();
                EditText e1=findViewById(id1);
                e1.setText(e1.getText());
                int id2=editText2.getId();
                EditText e2=findViewById(id2);
                editText2.setText(e2.getText());



                int id3=radioGroup.getCheckedRadioButtonId();
                RadioButton b=findViewById(id3);
                String text1=(String)b.getText();//거의 모든 뷰에 다 있다.


                text=e1.getText()+"\n"+message+e2.getText()+"\n"+text1+"\n";
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();


            }
        });//button 리스너

    }
}
