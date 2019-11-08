package com.ellen.eindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.ellen.indicatorlibrary.IndicatorView;
import com.ellen.indicatorlibrary.IndicatorViewAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private IndicatorView indicatorView;
    private Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorView = findViewById(R.id.indicatorView);
        indicatorView.setIndicatorViewAdapter(new IndicatorViewAdapter() {
            @Override
            public boolean isHorizontal() {
                return false;
            }

            @Override
            public View getItemView(int position) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_indicator,null);
                return view;
            }

            @Override
            public int getItemCount() {
                return 8;
            }

            @Override
            public void change(View view,int position) {
                CircleImageView circleImageView = view.findViewById(R.id.circle_image_view);
                circleImageView.setImageBitmap(BitmapUtils.getColorBitmap(1,1,"#FF0DAD"));
            }

            @Override
            public void agoChange(View view,int position) {
                CircleImageView circleImageView = view.findViewById(R.id.circle_image_view);
                circleImageView.setImageBitmap(BitmapUtils.getColorBitmap(1,1,"#D81B60"));
            }
        });
        indicatorView.setCurrentActivePosition(1);
        btNext = findViewById(R.id.bt_next);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indicatorView.setCurrentActivePosition(indicatorView.getPosition()+1);
            }
        });
    }
}
