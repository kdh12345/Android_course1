package com.kdh.pc.day09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Ex01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);

        GridView gridView=findViewById(R.id.GridView);
        gridView.setAdapter(new Myadapter1(this));
    }
}
