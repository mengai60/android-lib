package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public interface ITitleStyle {

    boolean hasTitle();// 是否包括标题
    boolean bindSystemActionBar();// Toolbar是否绑定系统ActionBar
    ViewGroup onBuildRootViewByStyle(Context context);// 创建rootView
    void onTitleLayoutSet(ViewGroup rootView, View titleView, View contentView);// 放置标题布局
    void onContentLayoutSet(ViewGroup rootView, View titleView, View contentView, ViewGroup.LayoutParams params);// 放置内容布局位置

}