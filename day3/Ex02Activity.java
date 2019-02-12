package com.kdh.pc.day03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ex02Activity extends AppCompatActivity {
    boolean isChecked=false;
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex04);
        //btn1, btn2를 객체 생성
        //객체 생성안하면 화면으로는 보이지만 클릭, 입력 등의 이벤트를 실행할 수 는 있음
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {//익명클래스 이므로 멤버변수로만 동작
            @Override
            public void onClick(View view) {
                //isChecked가 false면 ==버튼1이 off인 상태
                if(!isChecked) {
                    isChecked = true;//on으로 바꾸기
                    b2.setVisibility(View.GONE);//b2를 화면에서 숨기기
                }
                else{//버튼이 on이라면
                    isChecked=false;
                    b2.setVisibility(View.VISIBLE);//b2를 화면에서 보이게하기
                }
            }
        });//b1리스너
    }
}
