package com.kdh.pc.day08_2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    //shift+drag 부분선택
    Context context;
    String[] item_array={"피카츄","라이츄","파이리","꼬부기","버터플라이"};
    public MyAdapter(Context context){
        super();
        this.context=context;
    }
    @Override
    public int getCount() {//아이템의 갯수를 리턴
        return item_array.length;
    }

    @Override
    public Object getItem(int i) { // position번 째 아이템 객체를 return
        return item_array[i];
    }

    @Override
    public long getItemId(int i) {// position번 째 아이템의 id를 return
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Position번의 아이템을 사용해서 View를 생성한 후 return
        int r=(int)(Math.random()*256); //0-255
        int g=(int)(Math.random()*256); //0-255
        int b=(int)(Math.random()*256); //0-255
        TextView tv;
        if(view==null){
            tv=new TextView(context);// TextView 새로 생성(화면경로를 context로 지정)
            tv.setText(item_array[i]);
            tv.setBackgroundColor(Color.rgb(r,g,b));
        }else{
            tv=(TextView)view;
        }
        return tv;
    }
}
