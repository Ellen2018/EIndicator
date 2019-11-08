package com.ellen.indicatorlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class IndicatorView extends RelativeLayout {

    private LinearLayout linearLayout;
    private IndicatorViewAdapter indicatorViewAdapter;
    private HashMap<Integer,View> viewHashMap;
    private View currentActiveView;
    private int position;

    public IndicatorView(Context context) {
        super(context);
        initView(null);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    public void setCurrentActivePosition(int position){
        if(position < this.indicatorViewAdapter.getItemCount()) {
            View view = viewHashMap.get(position);
            if(currentActiveView != null){
                this.indicatorViewAdapter.agoChange(currentActiveView,this.position);
            }
            currentActiveView = view;
            this.indicatorViewAdapter.change(currentActiveView,position);
            this.position = position;
        }else {
            //抛出异常:更新的指示器位置不符合现有的，例如:5(总共才3个)
        }
    }

    public int getPosition(){
        return position;
    }

    public void setIndicatorViewAdapter(IndicatorViewAdapter indicatorViewAdapter){
        if(viewHashMap != null){
            viewHashMap.clear();
        }
        this.indicatorViewAdapter = indicatorViewAdapter;
        if (indicatorViewAdapter.isHorizontal()) {
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        }
        for (int i = 0; i < indicatorViewAdapter.getItemCount(); i++) {
            if(viewHashMap == null){
                viewHashMap = new HashMap<>();
            }
            View view;
            linearLayout.addView(view = indicatorViewAdapter.getItemView(i));
            indicatorViewAdapter.agoChange(view,i);
            viewHashMap.put(i,view);
        }
    }

    private void initView(AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_indicator_layout, this);
        linearLayout = view.findViewById(R.id.ll_view);
    }


}
