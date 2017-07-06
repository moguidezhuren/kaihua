package com.example.liudan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.liudan.R;
import com.example.liudan.fragment.HomeFragment;
import com.example.liudan.fragment.MyFragment;
import com.example.liudan.fragment.NewsFragment;
import com.example.liudan.view.MyFragmentTabHost;

/**
 *
 */
public class MyTabActivity  extends FragmentActivity {

    private MyFragmentTabHost MyTabHost;
    private Class mTabFragment[] = {HomeFragment.class, NewsFragment.class, MyFragment.class};
    private String tagName[] = {"首页", "新闻", "我"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        MyTabHost = (MyFragmentTabHost) findViewById(R.id.tabHost);


        MyTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent1);
        for (int i = 0; i < mTabFragment.length; i++) {
            TabWidget tabWidget = MyTabHost.getTabWidget();
            tabWidget.setDividerDrawable(null);
            MyTabHost.addTab(MyTabHost.newTabSpec(tagName[i]).setIndicator(getTabItemView(i)), mTabFragment[i], null);
        }

    }

    protected View getTabItemView(int index) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.item_tag, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewTag);
        //imageView.setImageResource(picture[index]);
        TextView textView = (TextView) view.findViewById(R.id.textViewTag);
        textView.setText(tagName[index]);
        return view;
    }
}

