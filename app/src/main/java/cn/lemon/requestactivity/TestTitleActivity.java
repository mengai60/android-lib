package cn.lemon.requestactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.lemon.activity.title.TitleActivity;
import cn.lemon.activity.title.style.ITitleStyle;
import cn.lemon.activity.title.style.TitleStyleFloatScroll;

public class TestTitleActivity extends TitleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleView(R.layout.layout_title);
        setContentView(R.layout.activity_title_test);
        // TODO: do other
        setCustomTitle("HaHaHa");// 设置title

    }

    @Override
    protected boolean libResIdsEnable() {
        return true;
    }

    @Override
    protected ITitleStyle titleStyle() {
        return new TitleStyleFloatScroll();
    }
}
