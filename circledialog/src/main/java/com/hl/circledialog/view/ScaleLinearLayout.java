package com.hl.circledialog.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.hl.circledialog.scale.ScaleLayoutConfig;


/**
 * ScaleLinearLayout
 * Created by hl on 2017/9/26.
 * 释义：
 */
class ScaleLinearLayout extends LinearLayout {

    public ScaleLinearLayout(Context context) {
        super(context);
        ScaleLayoutConfig.init(context.getApplicationContext());
    }
}
