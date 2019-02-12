package com.kdh.pc.day08;

import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
*                   메인액티비티  다른액티비티
*   앱을 실행하면     onCreate()    onCreate()
*                     onStart()     onStart()
*
         *            onResume()    onResume()
         *
*   홈버튼            onPause()     onPause()<---액티비티 프로세스 종료
*                     onStop()      onStop()<--- 화면 사라짐
*
*
*   액티비티 복귀
*                     onRestart()   onRestart()
*                     onStart()     onStart()
*                     onResume()    onResume()
*
*   뒤로가기          onPause()     onPause()
*                     onStop()      onStop()
*                     onDestroy()   onDestroy()
*                     (앱 종료)     (이전 화면으로 돌아감. 이전 액티비티의 restart())
*
*
*
* */
//onStart()사전 준비작업 onResume()화면에 보여줄 작업
//실습: 두 액티비티 모두 적용 -> 화면 복귀 시 'ex01 (ex02) 액티비티로 복귀했습니다.'를 Toast로 출력

public class Ex02Activity extends AppCompatActivity {
    /*
    * android.util.Log 클래스
    * :로그캣에 로그 기록을 출력
    * Log.d(String tag, String message):debug용
    * Log.w(String tag, String message):warning
    * Log.e(String tag, String message):error
    * Log.v(String tag, String message):verbose 배포용 어플에서는 실행x
    *
    * */

    Button button;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my","Ex02의 onStart() 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my","Ex02의 onStop() 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my","Ex02의 onDestroy() 실행");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my","Ex02의 onPause() 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my","Ex02의 onResume() 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(Ex02Activity.this,"ex02액티비티로복귀했습니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);

        button=findViewById(R.id.ex02_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Ex02Activity.this,"어플을 종료합니다.",Toast.LENGTH_SHORT).show();
                finishAffinity();//어플종료
            }
        });


    }
    @Override
    public void onBackPressed(){//뒤로가기 버튼 눌렀을때
        //super.onBackPressed();
        //Toast.makeText(this,"서브액티비티는 이전화면으로 돌아갑니다.", Toast.LENGTH_LONG).show();
        //'어플을 종료합니다.'를 Toast롤 출력하고 어플 종료
        Toast.makeText(this,"어플을 종료합니다.",Toast.LENGTH_SHORT).show();
        finishAffinity();


    }

}
