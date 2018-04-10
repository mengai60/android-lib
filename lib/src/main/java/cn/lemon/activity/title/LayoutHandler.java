package cn.lemon.activity.title;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.lemon.activity.title.style.ITitleStyle;
import cn.lemon.androidlib.R;

public class LayoutHandler {

    protected AppCompatActivity thisActivity;
    private LayoutInflater inflater;

    private ITitleStyle titleStyle;
//    protected static final int TITLE_BELOW_CONTENT = 2;// 标题在底部，内容在上方
//    protected static final int TITLE_FLOAT_TOP = 3;// 内容铺满全局，标题悬浮在内容上方
//    protected static final int TITLE_FLOAT_BOTTOM = 3;// 内容铺满全局，标题悬浮在内容下方
//    protected static final int TITLE_CONTENT_SCROLL = 4;// 标题随内容滚动
    private boolean libResIdsEnable;

    private ViewGroup rootView;
    private View titleView;
    private Toolbar toolbar;
    private View contentView;
    private TextView tv_title;
    private View.OnClickListener backListener;

    private CharSequence titleCharSequence;
    private int titleResId = -1;

    private View btn_back;


    private LayoutHandler() {
    }

    public View getTitleView() {
        return titleView;
    }

    public static class Builder {

        LayoutHandler handler;

        public Builder() {
            handler = new LayoutHandler();
        }

        public Builder setActivity(AppCompatActivity act) {
            handler.thisActivity = act;
            handler.inflater = LayoutInflater.from(act);
            return this;
        }

        public Builder setTitleStyle(ITitleStyle titleStyle) {
            handler.titleStyle = titleStyle;
            return this;
        }

        public Builder setLibResIdsEnable(boolean libTitleIdsEnable) {
            handler.libResIdsEnable = libTitleIdsEnable;
            return this;
        }

        public LayoutHandler build() {
            return handler;
        }

    }


    public boolean onCreate() {
        if (titleStyle.hasTitle()) {
            rootView = titleStyle.onBuildRootViewByStyle(thisActivity);
            return true;
        }
        return false;
    }

    public ViewGroup getRootView() {
        return rootView;
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    public void setTitleView(int layoutResID) {
        if (!titleStyle.hasTitle()) {
            if (layoutResID != 0) {
                titleView = inflater.inflate(layoutResID, null);
            }
        } else {
            titleView = inflater.inflate(layoutResID, rootView, false);
            titleStyle.onTitleLayoutSet(rootView, titleView, contentView);
        }
        // init toolbar
        if (titleView != null && titleView instanceof Toolbar) {
            toolbar = (Toolbar) titleView;
            if (titleStyle.bindSystemActionBar()) {
                thisActivity.setSupportActionBar(toolbar);
            }
        } else if (libResIdsEnable) {
            toolbar = thisActivity.findViewById(R.id.TitleActivity_id_Toolbar);
            if (toolbar != null && titleStyle.bindSystemActionBar()) {
                thisActivity.setSupportActionBar(toolbar);
            }
        }
        // init title and back button
        if (libResIdsEnable) {
            try {
                tv_title = thisActivity.findViewById(R.id.TitleActivity_id_title);
                setCustomTitle();
            } catch (ClassCastException e) {
                throw new RuntimeException("title must instanceof TextView");
            }
            btn_back = thisActivity.findViewById(R.id.TitleActivity_id_back);
            if (btn_back != null) {
                if (backListener != null) {
                    btn_back.setOnClickListener(backListener);
                } else {
                    btn_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            thisActivity.onBackPressed();
                        }
                    });
                }
            }
        }
    }

    public boolean setContentView(View view, ViewGroup.LayoutParams params) {
        if (titleStyle.hasTitle()) {
            contentView = view;
            titleStyle.onContentLayoutSet(rootView, titleView, contentView, params);
            return true;
        }
        return false;
    }

    public boolean setContentView(View view) {
        if (titleStyle.hasTitle()) {
            contentView = view;
            titleStyle.onContentLayoutSet(rootView, titleView, contentView, contentView.getLayoutParams());
            return true;
        }
        return false;
    }

    public boolean setContentView(int layoutResID) {
        if (titleStyle.hasTitle()) {
            contentView = inflater.inflate(layoutResID, rootView, false);
            titleStyle.onContentLayoutSet(rootView, titleView, contentView, contentView.getLayoutParams());
            return true;
        }
        return false;
    }

    protected void setCustomTitle(CharSequence title) {
        this.titleCharSequence = title;
        this.titleResId = -1;
        setCustomTitle();
    }

    protected void setCustomTitle(int title) {
        this.titleResId = title;
        this.titleCharSequence = null;
        setCustomTitle();
    }

    private void setCustomTitle() {
        if (tv_title != null) {
            if (titleCharSequence != null) {
                tv_title.setText(titleCharSequence);
            } else if (titleResId != -1) {
                tv_title.setText(titleResId);
            }
        }
    }

    public void setOnBackClickListener(View.OnClickListener listener) {
        this.backListener = listener;
        if (btn_back != null) {
            btn_back.setOnClickListener(listener);
        }
    }

}
