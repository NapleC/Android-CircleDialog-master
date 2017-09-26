package com.hl.circledialog;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.hl.circledialog.view.BuildViewImpl;
import com.hl.circledialog.params.CircleParams;

/**
 * Controller
 * Created by hl on 2017/9/26.
 * 释义：
 */
public class Controller {
    private Context mContext;
    private CircleParams mParams;
    private BuildView mCreateView;

    public Controller(Context context, CircleParams params) {
        this.mContext = context;
        this.mParams = params;
        mCreateView = new BuildViewImpl(mContext, mParams);
    }

    public View createView() {
        applyRoot();
        applyHeader();
        applyBody();
        return getView();
    }

    public void refreshView() {
        mCreateView.refreshText();
        mCreateView.refreshItems();
        mCreateView.refreshProgress();
        //刷新时带动画
        if (mParams.dialogParams.refreshAnimation != 0 && getView() != null)
            getView().post(new Runnable() {
                @Override
                public void run() {
                    Animation animation = AnimationUtils.loadAnimation(mContext, mParams
                            .dialogParams
                            .refreshAnimation);
                    if (animation != null) getView().startAnimation(animation);
                }
            });
    }

    private void applyRoot() {
        mCreateView.buildRoot();
    }

    private void applyHeader() {
        if (mParams.titleParams != null)
            mCreateView.buildTitle();
    }

    private void applyBody() {
        //文本
        if (mParams.textParams != null) {
            mCreateView.buildText();
            applyButton();
        }
        //列表
        else if (mParams.itemsParams != null) {
            mCreateView.buildItems();
            //有确定或者有取消按钮
            if (mParams.positiveParams != null || mParams.negativeParams != null)
                mCreateView.buildItemsButton();
        }
        //进度条
        else if (mParams.progressParams != null) {
            mCreateView.buildProgress();
            applyButton();
        }
        //输入框
        else if (mParams.inputParams != null) {
            mCreateView.buildInput();
            applyButton();
            mCreateView.regInputListener();
        }
    }

    private void applyButton() {
        //有确定并且有取消按钮
        if (mParams.positiveParams != null && mParams.negativeParams != null)
            mCreateView.buildMultipleButton();
            //有确定或者有取消按钮
        else if (mParams.positiveParams != null || mParams.negativeParams != null)
            mCreateView.buildSingleButton();
    }

    private View getView() {
        return mCreateView.getView();
    }
}
