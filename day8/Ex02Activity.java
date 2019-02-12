package com.kdh.pc.day10;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
/*
*   <다이얼로그 창>
*    - 상태 알림용 뷰
*    - 구현 순서
*    1.res->layout->다이얼로그용 레이아웃 xml 추가
*    2. 다이얼로그를 띄울 부분에 위 레이아웃을 setContentView() 실행
*    3. show() 실행(화면 닫기: dismiss() )
*
* */

public class Ex02Activity extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);
        //버튼 클릭시 다이얼로그 창
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 dialog=new Dialog(Ex02Activity.this,R.style.Mydialog);
                //위처럼 하거나 final로 선언하여 사용

                dialog.setContentView(R.layout.dialog_layout);//우선순위 크다!!!
                Button yes_button=dialog.findViewById(R.id.yes_button);
                Button no_button=dialog.findViewById(R.id.no_button);
                no_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();//창닫힘
                    }
                });
                //    다이얼로그창 배경을 투명하게
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(100,0,100)));
                //    배경색 투명하게
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ///   다이얼로그가 뜰 때 뒤 액티비티 반투명화 제거
                //dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                /// 다이얼로그 타이틀바 on
                ///res-> values -> styles.xml에 Theme 추가
                dialog.setTitle("Exit?");
                dialog.setCancelable(false);//뒤로가기 눌렀을 때 알림창 안닫히게(false)
                dialog.show();
            }
        });


    }
}
