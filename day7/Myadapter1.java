package com.kdh.pc.day09;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Myadapter1 extends BaseAdapter {
    Button[] buttons=new Button[10];
    Context context;

    public Myadapter1(Context context) {
        super();
        this.context = context;
        setButtons();
    }
    private void setButtons(){
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,view.getId()+"번 버튼 클릭됨!",Toast.LENGTH_SHORT).show();
            }
        };
        for(int i=0;i<10;++i){
            buttons[i]=new Button(context);
            buttons[i].setText(i+1+"번");
            int r=(int)(Math.random()*256);
            int g=(int)(Math.random()*256);
            int b=(int)(Math.random()*256);
            buttons[i].setBackgroundColor(Color.rgb(r,g,b));
            buttons[i].setId(i+1);
            buttons[i].setOnClickListener(listener);

        }
    }

    @Override
    public int getCount() {
        return buttons.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return buttons[i].getId();//i
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view!=null){
            return view; ///상태보존을위해서
        }else {
            return buttons[i];
        }
    }
}
