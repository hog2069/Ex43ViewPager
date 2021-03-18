package com.hog2020.ex43viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> imgId= new ArrayList<Integer>();
    ViewPager pager;

    //뷰페이저가 보여줄 페이지(뷰)를 만들어내는 아답터 참조변수
    MyAadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터(페이지 별 데이터들)
        imgId.add(R.drawable.moana01);
        imgId.add(R.drawable.moana02);
        imgId.add(R.drawable.moana03);
        imgId.add(R.drawable.moana04);
        imgId.add(R.drawable.moana05);

        pager=findViewById(R.id.pager);
        adapter=new MyAadapter(this,imgId);
        pager.setAdapter(adapter);
    }

    public void clickprev(View view) {
        //현재 Page 의 idex 번호의 이전 번호
        int index= pager.getCurrentItem()-1;
        pager.setCurrentItem(index,true);
    }

    public void clicknext(View view) {
        int index= pager.getCurrentItem()+1;
        pager.setCurrentItem(index,true);
    }
}