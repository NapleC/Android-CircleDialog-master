package com.hl.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.AdapterView;

import com.hl.circledialog.res.values.CircleColor;
import com.hl.circledialog.res.values.CircleDimen;

/**
 * ItemsParams
 * Created by hl on 2017/9/26.
 * 释义：items 内容参数
 */
public class ItemsParams implements Parcelable {
    public void dismiss() {
    }

    /**
     * item点击事件
     */
    public AdapterView.OnItemClickListener listener;
    /**
     * item高度
     */
    public int itemHeight = CircleDimen.ITEM_HEIGHT;
    /**
     * item内间距
     */
    public int[] padding;
    /**
     * 数据源：array or list
     */
    public Object items;
    /**
     * item背景色
     */
    public int backgroundColor;
    /**
     * item字体色
     */
    public int textColor = CircleColor.content;
    /**
     * item字体大小
     */
    public int textSize = CircleDimen.CONTENT_TEXT_SIZE;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.itemHeight);
        dest.writeIntArray(this.padding);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.textColor);
        dest.writeInt(this.textSize);
    }

    public ItemsParams() {
    }

    protected ItemsParams(Parcel in) {
        this.itemHeight = in.readInt();
        this.padding = in.createIntArray();
        this.backgroundColor = in.readInt();
        this.textColor = in.readInt();
        this.textSize = in.readInt();
    }

    public static final Parcelable.Creator<ItemsParams> CREATOR = new Parcelable.Creator<ItemsParams>() {
        @Override
        public ItemsParams createFromParcel(Parcel source) {
            return new ItemsParams(source);
        }

        @Override
        public ItemsParams[] newArray(int size) {
            return new ItemsParams[size];
        }
    };
}
