package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class TitleStyleFloat implements ITitleStyle {

    @Override
    public boolean hasTitle() {
        return true;
    }

    @Override
    public boolean bindSystemActionBar() {
        return false;
    }

    @Override
    public ViewGroup onBuildRootViewByStyle(Context context) {
        return new FrameLayout(context);
    }

    @Override
    public void onTitleLayoutSet(ViewGroup rootView, View titleView, View contentView) {
        int childCount = rootView.getChildCount();
        if (childCount > 2) {
            rootView.removeViewAt(childCount - 1);
        }
        rootView.addView(titleView);
    }

    @Override
    public void onContentLayoutSet(ViewGroup rootView, View titleView, View contentView, ViewGroup.LayoutParams params) {
        rootView.removeAllViews();
        if (contentView != null) {
            rootView.addView(contentView, params);
        }
        if (titleView != null) {
            rootView.addView(titleView);
        }
    }
}
