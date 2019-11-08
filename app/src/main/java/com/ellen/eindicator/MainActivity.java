package com.ellen.eindicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ellen.eindicator.viewpager.BaseViewPagerAdapter;
import com.ellen.indicatorlibrary.IndicatorView;
import com.ellen.indicatorlibrary.IndicatorViewAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private IndicatorView indicatorView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorView = findViewById(R.id.indicatorView);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new BaseViewPagerAdapter() {
            @Override
            protected View getView(int position) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(""+position);
                textView.setTextSize(100);
                return textView;
            }

            @Override
            protected String getPagetTitle(int position) {
                return "dsad";
            }

            @Override
            protected int getPagerItemSize() {
                return 5;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicatorView.setCurrentActivePosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indicatorView.setIndicatorViewAdapter(new IndicatorViewAdapter() {
            @Override
            public boolean isHorizontal() {
                return true;
            }

            @Override
            public View getItemView(int position) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_indicator,null);
                return view;
            }

            @Override
            public int getItemCount() {
                return 5;
            }

            @Override
            public void change(View view,int position) {
                CircleImageView circleImageView = view.findViewById(R.id.circle_image_view);
                circleImageView.setImageResource(R.mipmap.ic_launcher);
            }

            @Override
            public void agoChange(View view,int position) {
                CircleImageView circleImageView = view.findViewById(R.id.circle_image_view);
                circleImageView.setImageBitmap(BitmapUtils.getColorBitmap(1,1,"#cccccc"));
            }
        });
        indicatorView.setCurrentActivePosition(0);
    }
}
