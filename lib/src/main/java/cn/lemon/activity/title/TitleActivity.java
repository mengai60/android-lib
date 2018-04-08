package cn.lemon.activity.title;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import cn.lemon.activity.title.style.DefaultTitleStyle;
import cn.lemon.activity.title.style.ITitleStyle;


/**
 * 自定义标题的BaseActivity
 * 使用时需配置style Theme.AppCompat.NoActionBar
 * setTitleView 设置标题
 * setContentView 设置内容
 * 复写titleStyle 设置标题风格
 */
public class TitleActivity extends AppCompatActivity {
    // 获取自身实力的引用，防止代码里出现类似BaseActivity.this这种调用方式(个人习惯，查找类在哪里被引用的时候不乱)
    protected TitleActivity thisActivity;
    private LayoutHandler layoutHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        layoutHandler = new LayoutHandler.Builder()
                .setActivity(thisActivity)
                .setTitleStyle(titleStyle())
                .setLibResIdsEnable(libResIdsEnable())
                .build();
        if (layoutHandler.onCreate()) {
            super.setContentView(layoutHandler.getRootView(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    @Override
    protected void onDestroy() {
        layoutHandler.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setContentView(int layoutResID) {
        if (!layoutHandler.setContentView(layoutResID)) {
            super.setContentView(layoutResID);
        }
    }

    @Override
    public void setContentView(View view) {
        if (!layoutHandler.setContentView(view)) {
            super.setContentView(view);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (!layoutHandler.setContentView(view, params)) {
            super.setContentView(view, params);
        }
    }

    /**
     * 标题风格
     */
    protected ITitleStyle titleStyle() {
        return new DefaultTitleStyle();
    }

    /**
     * @return true 自动检索相关ids并做响应操作 false 不做固定id检索
     */
    protected boolean libResIdsEnable() {
        return false;
    }

    /**
     * 设置标题布局
     */
    protected void setTitleView(int layoutResID) {
        layoutHandler.setTitleView(layoutResID);
    }

    protected Toolbar getToolbar() {
        return layoutHandler.getToolbar();
    }

    /**
     * 设置标题
     */
    protected void setCustomTitle(CharSequence title) {
        layoutHandler.setCustomTitle(title);
    }
    /**
     * 设置标题
     */
    protected void setCustomTitle(int title) {
        layoutHandler.setCustomTitle(title);
    }

    /**
     * id为TitleActivity_id_back的view被点击的回调
     */
    protected void setOnBackClickListener(View.OnClickListener listener) {
        layoutHandler.setOnBackClickListener(listener);
    }

}
