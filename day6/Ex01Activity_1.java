package com.kdh.pc.day08;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ex01Activity extends AppCompatActivity {
    ///Activity 클래스의 메소드:onStart(),onResume,onDestroy(),onStop(),onPause()
    //한꺼번에 오버라이드:alt+insert



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my","Ex01의 onStart() 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my","Ex01의 onStop() 실행");
        //Toast.makeText(Ex01Activity.this,"ex02액티비티로복귀했습니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my","Ex01의 onDestroy() 실행");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my","Ex01의 onPause() 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my","Ex01의 onResume() 실행");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(Ex01Activity.this,"ex01액티비티로복귀했습니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);
        Log.d("my","Ex01의 onCreate() 실행");
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼을 클릭하면 Ex02 액티비티로 이동(실행)
                Intent intent=new Intent(getApplicationContext(),Ex02Activity.class);
                                // (시작 액티비티의 경로, 실행할 액티비티의 클래스)
                                // (Context객체==>activity고유주소,class )
                //getApplicationContext()==Ex01Activity.this를 써도 됨
                startActivity(intent);

            }
        });
    }
    long backTime=0;
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        //한번더 누르시면 종료합니다.를 Toast하고
        //2초안에 뒤로 버튼을 눌러야 종료되도록
        //-->처음 onBackPressed() 됐을 때의 시간을 변수에 저장
        if(System.currentTimeMillis()>backTime+2*1000){
            Toast.makeText(this,"한번더 누르면 종료합니다.",Toast.LENGTH_SHORT).show();
            backTime=System.currentTimeMillis();
        }
        else if(System.currentTimeMillis()<=backTime+2*1000){
            Toast.makeText(this,"어플을 종료합니다.",Toast.LENGTH_SHORT).show();
            finishAffinity();
        }

    }

}
