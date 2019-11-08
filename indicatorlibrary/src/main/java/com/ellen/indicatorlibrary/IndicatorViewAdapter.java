package com.ellen.indicatorlibrary;

import android.view.View;

public interface IndicatorViewAdapter {

    /**
     * 指示器的方向
     * @return
     */
    boolean isHorizontal();

    /**
     * 返回指示器的View
     * @param position
     * @return
     */
    View getItemView(int position);

    /**
     * 指示器的个数
     * @return
     */
    int getItemCount();

    /**
     * 当指示器发生状态变化时回调
     * @param view
     */
    void change(View view,int position);

    /**
     * 上一个改变状态的
     * @param view
     */
    void agoChange(View view,int position);

}
