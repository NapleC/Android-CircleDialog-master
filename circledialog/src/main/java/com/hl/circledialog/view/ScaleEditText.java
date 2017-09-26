package com.hl.circledialog.view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.TypedValue;
import android.view.Gravity;

import com.hl.circledialog.scale.ScaleUtils;

/**
 * ScaleEditText
 * Created by hl on 2017/9/26.
 * 释义：编辑框
 */
class ScaleEditText extends AppCompatEditText {
    public ScaleEditText(Context context) {
        super(context);
        config();
    }

    private void config() {
        requestFocus();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setGravity(Gravity.TOP | Gravity.LEFT);
    }

    @Override
    public void setHeight(int pixels) {
        int dimenHeight = ScaleUtils.scaleValue(pixels);
        super.setHeight(dimenHeight);
    }

    @Override
    public void setTextSize(float size) {
        int dimenTextSize = ScaleUtils.scaleValue((int) size);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, dimenTextSize);
    }
}
