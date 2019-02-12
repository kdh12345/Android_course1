package com.lsr.pc.day09;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MyAdapter2 extends BaseAdapter implements View.OnClickListener {
    private final int SIZE = 10;
    Context context;

    // 정답 (랜덤)
    int correct = (int)(Math.random() * SIZE) + 1;

    // 버튼 배열
    Button[] buttons = new Button[SIZE];

    // 횟수
    int count;

    public MyAdapter2(Context context){
        this.context = context;
        setButtons();
    }

    @Override
    public int getCount() {
        return SIZE;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return buttons[position].getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView != null) {
            return convertView;
        }
        return buttons[position];
    }

    // //////////////////////////////
    // View.onClick() 오버라이드
    @Override
    public void onClick(View v) {
        ++count;
        if(v.getId() == correct){
            Toast.makeText(context, "정답!!(총 " + count +"회)", Toast.LENGTH_SHORT).show();
            // game win 화면으로
            Intent intent = new Intent(context, Ex02WinActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "땡..(남은 횟수 : " + (SIZE-count) +"회)", Toast.LENGTH_SHORT).show();
            v.setVisibility(View.INVISIBLE);
            if(count < 5){
                // game over 화면으로
                Intent intent = new Intent(context, Ex02LoseActivity.class);
                context.startActivity(intent);
            }
        }
    }

    private void setButtons(){
        for(int i = 0; i < SIZE; ++i){
            buttons[i] = new Button(context);
            buttons[i].setText( (i+1) + "번 버튼");
            buttons[i].setId(i+1);
            buttons[i].setOnClickListener(this);
        }
    }
}
