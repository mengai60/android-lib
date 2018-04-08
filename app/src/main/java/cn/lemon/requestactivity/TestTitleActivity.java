package cn.lemon.requestactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import cn.lemon.activity.title.request.RequestActivity;
import cn.lemon.activity.title.style.ITitleStyle;
import cn.lemon.activity.title.style.TitleStyleFloatScroll;

public class TestTitleActivity extends RequestActivity {

    private boolean requestFail = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTitle("HaHaHa");// 设置title
    }

    @Override
    protected void onInit() {

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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (requestFail) {
                    whenRequestFail();
                } else {
                    whenRequestSuccess();
                }
                requestFail = false;
            }
        }, 3000);
    }

}
