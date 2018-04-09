package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class TitleStyleNoTitle implements ITitleStyle {

    @Override
    public boolean hasTitle() {
        return false;
    }

    @Override
    public boolean bindSystemActionBar() {
        return false;
    }

    @Override
    public ViewGroup onBuildRootViewByStyle(Context context) {
        return null;
    }

    @Override
    public void onTitleLayoutSet(ViewGroup rootView, View titleView, View contentView) {

    }

    @Override
    public void onContentLayoutSet(ViewGroup rootView, View titleView, View contentView, ViewGroup.LayoutParams params) {

    }
}
