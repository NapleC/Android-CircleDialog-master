package com.hl.circledialog.res.drawable;

import android.graphics.drawable.GradientDrawable;

/**
 * InputDrawable
 * Created by hl on 2017/9/26.
 * 释义：输入框背景
 */
public class InputDrawable extends GradientDrawable {
    public InputDrawable(int strokeWidth, int strokeColor, int backgroundColor) {
        setColor(backgroundColor);//内部填充颜色
        setStroke(strokeWidth, strokeColor);//边框宽度,边框颜色
    }
}
