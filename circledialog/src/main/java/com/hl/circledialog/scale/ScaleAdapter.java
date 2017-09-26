package com.hl.circledialog.scale;

import android.content.Context;

/**
 * ScaleAdapter
 * Created by hl on 2017/9/26.
 * 释义：
 */
class ScaleAdapter {

    private Context mContext;

    public ScaleAdapter(Context context) {
        mContext = context;
    }

    public float adapt(float scale, int screenWidth, int screenHeight) {
        if (screenWidth < 720 || screenHeight < 720) {//针对小屏（小分辨率）设备做调整
            if (screenWidth <= 480 || screenHeight <= 480) {//普通480设备
                scale *= 1.2f;
            } else {
                if (ScaleUtils.getDevicePhysicalSize(mContext) < 4.0) {//小屏手机，较高分辨率（如 mx）
                    scale *= 1.3f;
                } else {//华为U9200
                    scale *= 1.05f;
                }
            }
        }
        return scale;
    }
}
