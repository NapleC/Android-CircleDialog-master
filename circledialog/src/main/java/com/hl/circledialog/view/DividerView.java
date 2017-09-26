package com.hl.circledialog.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.hl.circledialog.res.values.CircleColor;

/**
 * DividerView
 * Created by hl on 2017/9/26.
 * 释义：分隔线，默认垂直
 */
class DividerView extends View {
    public DividerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setLayoutParams(new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT));
        setBackgroundColor(CircleColor.divider);
    }

    /**
     * 将分隔线设置为水平分隔
     */
    public void setVertical() {
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
    }
}
