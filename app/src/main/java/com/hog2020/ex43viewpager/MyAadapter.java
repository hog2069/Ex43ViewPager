package com.hog2020.ex43viewpager;


import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAadapter extends PagerAdapter {
    Context context;
    ArrayList<Integer> imgId;

    //생성자를 이용해서 imgId 배열 전달받기
    public MyAadapter(Context context,ArrayList<Integer> imgId){
        //멤버변수에 매개변수를 전달(대입) 해주기
        this.imgId=imgId;
        this.context=context;
    }

    //이 아답터가 만들 페이지의 개수
    @Override
    public int getCount() {
        return imgId.size();
    }

    //ListView 의 Adapter 에서의 getView()메소드와
    //같은역할을 하는 메소드
    //현재 보여질 page 를 만들어서 추가하는 메소드


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //뷰페이지가 보여줄 뷰(page) 객체생성
        LayoutInflater inflater = LayoutInflater.from(context);
        View page= inflater.inflate(R.layout.page,null);

        ImageView iv = page.findViewById(R.id.iv);
        iv.setImageResource(imgId.get(position));

        //ListView 는 만든 Page 를 리턴해주었지만
        //만들어진 page 를 ViewPager 에 추가해야함
        container.addView(page);

        //만든 페이지를 뷰가 맞는지 검사를 위해 리턴
        //리턴 해준뒤 객체(page)를 isViewFromObject()메소드가 받음
        return page;
    }

    //ViewPager 에서 제거해야할 page 를 제거하는 메소드


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //3번째 파라미터가 지워야할 뷰 객체(page)
        container.removeView((View) object);
    }

    //화면에 보여질뷰가 위에서 만든 page 와 같은 객체인지 검증
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
