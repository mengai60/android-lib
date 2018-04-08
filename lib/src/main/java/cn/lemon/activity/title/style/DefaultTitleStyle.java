package cn.lemon.activity.title.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 线性布局
 * 内容在标题下方
 */
public class DefaultTitleStyle implements ITitleStyle {

    @Override
    public boolean hasTitle() {
        return true;
    }

    @Override
    public boolean bindSystemActionBar() {
        return true;
    }

    @Override
    public void onTitleLayoutSet(ViewGroup rootView, View titleView, View contentView) {
        rootView.removeAllViews();
        rootView.addView(titleView);
        if (contentView != null) {
            rootView.addView(contentView);
        }
    }

    @Override
    public void onContentLayoutSet(ViewGroup rootView, View titleView, View contentView, ViewGroup.LayoutParams params) {
        // content置空
        int childCount = rootView.getChildCount();
        if (childCount > 1) {
            rootView.removeViewAt(childCount - 1);
        }
        if (contentView != null) {// 添加新的content
            rootView.addView(contentView, params);
        }
    }

    @Override
    public ViewGroup onBuildRootViewByStyle(Context context) {
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        return ll;
    }

}
