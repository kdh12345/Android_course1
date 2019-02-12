package com.lsr.pc.day05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name_edittext;
    Spinner tel1_spinner;
    EditText tel2_edittext;
    EditText tel3_edittext;
    RadioGroup gender_radiogroup;
    CheckBox[] checkBoxes = new CheckBox[6];
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_edittext = findViewById(R.id.name_edittext);
        tel1_spinner = findViewById(R.id.tel1_spinner);
        tel2_edittext = findViewById(R.id.tel2_edittext);
        tel3_edittext = findViewById(R.id.tel3_edittext);
        gender_radiogroup = findViewById(R.id.gender_radiogroup);
        submit_button = findViewById(R.id.submit_button);
        checkBoxes[0] =  findViewById(R.id.subject_checkbox1);
        checkBoxes[1] =  findViewById(R.id.subject_checkbox2);
        checkBoxes[2] =  findViewById(R.id.subject_checkbox3);
        checkBoxes[3] =  findViewById(R.id.subject_checkbox4);
        checkBoxes[4] =  findViewById(R.id.subject_checkbox5);
        checkBoxes[5] =  findViewById(R.id.subject_checkbox6);

        submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = ""; // Toast로 출력할 메시지

        // 이름 얻어오기
        String name = name_edittext.getText() != null ? name_edittext.getText().toString() : "";
                    //   조건식 ? 참일 경우 : 거짓일 경우
                    // ==> 이름 입력창에 아무것도 없을 경우 null이 리턴될 수 있음
                    // ==> 그 상태에서 toString()진행하면 null.toString()이 되므로 NullPointerException이 발생 (어플이 죽음)
                    // NullPointerException을 방지해야 함
        name = name.trim();
        if(name.isEmpty()){
            message = "이름을 입력하세요.";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            name_edittext.requestFocus();
            return;
        } else {
            message += "\n이름 : " + name + "\n";
        }

        // 연락처 얻어오기
        String tel1 = (String)tel1_spinner.getSelectedItem();
        String tel2 =  tel2_edittext.getText() != null ? tel2_edittext.getText().toString() : "";
        String tel3 = tel3_edittext.getText() != null ? tel3_edittext.getText().toString() : "";
        if(tel1 == null || tel1.isEmpty() || tel2.isEmpty() || tel3.isEmpty()){
            message = "연락처를 입력하세요.";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            tel2_edittext.requestFocus();
            return;
        } else {
            message += "\n연락처 : " + tel1 + " - " + tel2 + " - " + tel3;
        }

        // 성별 얻어오기
        int id = gender_radiogroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.male_radio_button:
                message += "\n성별 : 남성 ";
                break;
            case R.id.female_radio_button:
                message += "\n성별 : 여성 ";
                break;
            default:
                message = "성별을 선택하세요.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                return;
        }

        // 이수과목 얻어오기
        String subject = "";
        for(CheckBox checkBox : checkBoxes){
            if(checkBox.isChecked()){
                subject += (String)checkBox.getText() + ", ";
            }
        }
        if(!subject.isEmpty()){
            // subject : "JAVA, PYTHON, C++, " <= 여기에서 마지막 ", " 없애기
            subject = subject.substring(0, subject.lastIndexOf(", "));
            message += "\n수강과목 : " + subject;
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
