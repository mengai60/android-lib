package cn.lemon.requestactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;

import cn.lemon.activity.title.request.RequestActivity;
import cn.lemon.activity.title.style.ITitleStyle;
import cn.lemon.activity.title.style.TitleStyleFloatScroll;

public class TestTitleActivity extends RequestActivity {

    private boolean requestFail = true;

    private TextView tv_test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTitle("HaHaHa");// 设置title
    }

    @Override
    protected void onCreate() {
    }

    @Override
    protected ITitleStyle titleStyle() {
        return new TitleStyleFloatScroll();
    }

    @Override
    protected int titleLayoutId() {
        return R.layout.layout_title;
    }

    @Override
    protected int contentLayoutId() {
        return R.layout.activity_title_test;
    }

    @Override
    protected boolean createAfterRequestSuccess() {
        return true;
    }

    @Override
    protected void onRequest() {
        // 这里可以初始化状态,比如,对Title中需要网络加载成功后才需要显示的button进行隐藏
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (requestFail) {
                    whenRequestFail();
                } else {
                    whenRequestSuccess();
                    // 这里表示已经网络加载成功
                    // 进行contentView的初始化
                    initContentView();
                }
                requestFail = false;
            }
        }, 3000);
    }

    private void initContentView() {
        tv_test = findViewById(R.id.tv_test);
        tv_test.setText("test");
    }

}
