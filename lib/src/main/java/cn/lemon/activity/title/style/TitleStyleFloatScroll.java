package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import cn.lemon.androidlib.R;

/**
 * contentView的最外层控件必须是TitleScrollView
 */
public class TitleStyleFloatScroll implements ITitleStyle {

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

        setScrollListener(contentView, titleView);
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

        setScrollListener(contentView, titleView);
    }

    private void setScrollListener(View contentView, View titleView) {
        if (contentView != null && titleView != null) {
            TitleScrollView scrollView = (TitleScrollView) contentView;
            scrollView.setTitle(titleView);
            scrollView.setTitleHeight(scrollView.getResources().getDimensionPixelSize(R.dimen.banner_height));
        }
    }

}
