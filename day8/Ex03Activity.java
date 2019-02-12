package com.kdh.pc.day10;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

/*
* AlertDialog 클래스
* : 확인, 취소 버튼이 있는 알림창
*
* */
public class Ex03Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03);
        Button b=findViewById(R.id.button);
        AlertDialog.Builder builder
                =new AlertDialog.Builder(this,android.R.style.Theme_DeviceDefault_Light_Dialog);
        builder.setMessage("앱을 종료하시겠습니까?")
                .setTitle("EXIT")
                .setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Ex03Activity.this,"취소합니다.",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Ex03Activity.this,"종료합니다.",Toast.LENGTH_SHORT).show();
                        Ex03Activity.this.finish();//앱종료
                    }
                })
                .setCancelable(false).show();
        /// Builder는 Dialog창을 생성하고,
        // setXXX() 들은 메소드 의 결과값(리턴값)으로 해당 객체를 다시 반환한다.

    }
}
