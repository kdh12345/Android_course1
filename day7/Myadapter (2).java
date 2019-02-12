package com.kdh.pc.day09;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

public class Myadapter extends BaseAdapter {
    Context context;
    Button[] btn=new Button[9];
    int count=0;
    public Myadapter(Context context) {
        super();
        this.context=context;
        setBtn();
    }
    private void setBtn(){
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=view.getId();
                if(num==5){
                    Toast.makeText(context,"당첨!!!!"+count+"번 만에 성공",Toast.LENGTH_SHORT).show();
                    count=0;
                }

                else {
                    Toast.makeText(context,"꽝",Toast.LENGTH_SHORT).show();
                    count++;
                }
            }
        };
        for(int i=0;i<10;++i){
            btn[i]=new Button(context);
            btn[i].setText(i+1);
            btn[i].setId(i+1);
            btn[i].setOnClickListener(listener);
        }
    }

    @Override
    public int getCount() {
        return btn.length;
    }

    @Override
    public Object getItem(int i) {
        return btn[i];
    }

    @Override
    public long getItemId(int i) {
        return btn[i].getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view!=null){
            return view;
        }else {
            return btn[i];
        }
    }
}
