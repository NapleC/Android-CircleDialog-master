package com.hl.circledialog.res.drawable;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;

import com.hl.circledialog.res.values.CircleColor;

/**
 * SelectorBtn
 * Created by hl on 2017/9/26.
 * 释义：按钮的背景，有点击效果
 */
public class SelectorBtn extends StateListDrawable {

    public SelectorBtn(int backgroundColor, int leftTopRadius, int rightTopRadius, int rightBottomRadius, int
            leftBottomRadius) {
        //按下
        ShapeDrawable drawablePress = new ShapeDrawable(DrawableHelper.getRoundRectShape(leftTopRadius, rightTopRadius,
                rightBottomRadius, leftBottomRadius));
        drawablePress.getPaint().setColor(CircleColor.buttonPress);
        //默认
        ShapeDrawable defaultDrawable = new ShapeDrawable(DrawableHelper.getRoundRectShape(leftTopRadius,
                rightTopRadius,
                rightBottomRadius, leftBottomRadius));
        defaultDrawable.getPaint().setColor(backgroundColor);

        addState(new int[]{android.R.attr.state_pressed}, drawablePress);
        addState(new int[]{-android.R.attr.state_pressed}, defaultDrawable);
    }
}
