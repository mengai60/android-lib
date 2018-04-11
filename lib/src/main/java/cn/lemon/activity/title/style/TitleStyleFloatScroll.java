package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * contentView的最外层控件必须是TitleScrollView
 */
public class TitleStyleFloatScroll implements ITitleStyle {

    private TitleScrollView scrollView;

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
        if (scrollView != null) {
            scrollView.setTitle(titleView);
        }
    }

    @Override
    public void onContentLayoutSet(ViewGroup rootView, View titleView, View contentView, ViewGroup.LayoutParams params) {
        rootView.removeAllViews();
        if (contentView != null) {
            if (contentView instanceof TitleScrollView) {
                scrollView = (TitleScrollView) contentView;
            } else {
                scrollView = null;
            }
            rootView.addView(contentView, params);
        } else {
            scrollView = null;
        }
        if (titleView != null) {
            rootView.addView(titleView);
            if (scrollView != null) {
                scrollView.setTitle(titleView);
            }
        }
    }

}
