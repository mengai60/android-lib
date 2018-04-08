package cn.lemon.activity.title.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class TitleScrollView extends ScrollView {

    private View title;
    private int titleHeight;
    private Drawable background;
    private ViewConfiguration configuration;

    public TitleScrollView(Context context) {
        super(context);
    }

    public TitleScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int left, int top, int oldLeft, int oldTop) {
        super.onScrollChanged(left, top, oldLeft, oldTop);
        int alpha = 0;
        if (top <= titleHeight && top > 0) {
            alpha = top * 255 / titleHeight;
            title.setVisibility(VISIBLE);
        } else {
            title.setVisibility(oldTop > top ? VISIBLE : GONE);
        }
        background.setAlpha(255 - alpha);
    }

    public void setTitle(View title) {
        setOverScrollMode(OVER_SCROLL_NEVER);
        configuration = ViewConfiguration.get(getContext());
        this.title = title;
        background = this.title.getBackground();
        titleHeight = title.getLayoutParams().height;
    }

    public void setTitleHeight(int titleHeight) {
        this.titleHeight = titleHeight;
    }
}
