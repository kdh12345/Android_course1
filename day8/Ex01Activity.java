package com.kdh.pc.day10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Ex01Activity extends AppCompatActivity implements View.OnClickListener {
    ////////////////////////////////////////
    ///View.OnClickListener
    @Override
    public void onClick(View view){
        Toast.makeText(this,view.getId()+"번 버튼!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//필수!!!
        //setContentView(R.layout.activity_main);
        //res->layout->activity_ex01.xml 로 화면구성하라
        ///xml 없이 화면 구성하기

        //루트레이아웃 생성
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //Button 7개 생성
        for(int i=0;i<7;++i){
            Button button=new Button(this);
            button.setText(i+"번 버튼");//String 타입
            button.setId(i);
            button.setOnClickListener(this);
            button.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25); //글자 크기:25dp
            button.setWidth(LinearLayout.LayoutParams.MATCH_PARENT); //너비 ///양수는 픽셀단위// match_parent==>-1
            button.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT); //높이///wrap_content===>-2
            linearLayout.addView(button); //레이아웃에 버튼 추가 중요!!!!!!!
        }//for문 종료
        setContentView(linearLayout);
    }//onCreate() 종료
}
