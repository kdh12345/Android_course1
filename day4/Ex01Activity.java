package com.kdh.pc.day04;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Ex01Activity extends AppCompatActivity {
    // View(위젯)들 변수 선언
    CheckBox checkBox;
    EditText editText;
    Spinner spinner;
    RadioGroup radioGroup;
    ProgressBar progressBar;
    Button button1;
    Button button2;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);
        checkBox=findViewById(R.id.checkbox);
        editText=findViewById(R.id.edit_text);
        spinner=findViewById(R.id.spinner);
        radioGroup=findViewById(R.id.radio_group);
        progressBar=findViewById(R.id.progress_circular);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        linearLayout=findViewById(R.id.linear_layout);
        /*
        * R: 어플리케이션의 모든 xml, 뷰의 ID 등의 정보를 담고 있는 클래스
        *   위젯을 xml에 추가하고 id를 부여하면 해당 id의 이름으로 정수형 상수가 만들어짐
        *   findViewById(int 고유번호):고유번호를 통해 View를 찾을 때 사용
        *   View 클래스: 모든 위젯 클래스(Button,Spinner,LinearLayout 등)의 루트 클래스
        */
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(checkBox.isChecked()) { //체크되었으면 true,빈 칸이면 false
                   Toast.makeText(Ex01Activity.this,"체크박스 체크됨",Toast.LENGTH_SHORT).show();
                   // Toast.makeText(이 토스트창의 소속 액티비티, 보여줄 텍스트, 보여줄 시간).show();
                   // Toast.LENGTH_SHORT: 짧게 보여줌
                   // Toast.LENGTH_LONG : 길게 보여줌
               }else{
                   Toast.makeText(Ex01Activity.this,"체크박스 체크해재됨",Toast.LENGTH_SHORT).show();
               }
            }
        });//체크박스리스너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //몇 번째 아이템이 선택되었는지
                String message=spinner.getItemAtPosition(position)+"항목 선택됨.("+position+")";
                Toast.makeText(Ex01Activity.this,message,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//spinner
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroup.getCheckedRadioButtonId();
                RadioButton b=findViewById(id);
                String text=(String)b.getText();//거의 모든 뷰에 다 있다.
                // 리턴자료형이 String이 아니라서 형변환해야 함
                // 리턴자료형:(String의 조상격인 CharSequence)
                //group(여기에서는 radioGroup 멤버)에서 체크된 하위 라디오버튼의 아이디를 얻어옴
                Toast.makeText(Ex01Activity.this,text,Toast.LENGTH_LONG).show();
                switch (id){
                    case R.id.radio_button1:
                        linearLayout.setBackgroundColor(Color.rgb(00,88,55));
                        break;
                    case  R.id.radio_button2:
                        linearLayout.setBackgroundColor(Color.rgb(0,255,0));
                        break;
                    case  R.id.radio_button3:
                        linearLayout.setBackgroundColor(Color.rgb(0,0,255));
                        break;
                }
            }
        });//radioGroup
        progressBar.setVisibility(View.GONE);//GONE은 공간도 없고 레이아웃 공간 도 없다.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.INVISIBLE);//단순히 안보이는것
                // INVISIBLE : 화면에서 사라짐(공간은 그대로 남아있음)
                // GONE : 화면에서 사라짐(차지했던 공간이 없어짐)
            }
        });

    }
}
