package cn.lemon.requestactivity.lib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import cn.lemon.activity.title.TitleActivity;

/**
 * 默认情况为不需要通过request初始化数据的带标题栏的Activity
 * 1.通过createAfterRequestSuccessed设置需要初始化数据功能
 * 2.通过getNoResponseContentView设置网络失败的布局
 */
public abstract class RequestActivity extends TitleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleView(titleLayoutId());
        if (!createAfterRequestSuccess()) {
            setContentView(contentLayoutId());
            onInit();
        } else {
            setContentView(prepareRequestView());
            onRequest();
        }
    }
    /**
     * 网络请求成功后需调用该方法
     */
    protected void whenRequestSuccess() {
        setContentView(contentLayoutId());
        onInit();
    }
    /**
     * 网络请求失败后需调用该方法
     */
    protected void whenRequestFail() {
        View view = LayoutInflater.from(thisActivity).inflate(noResponseView(), null);
        setContentView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRequest();
            }
        });
    }

    protected abstract void onInit();
    protected abstract int titleLayoutId();
    protected abstract int contentLayoutId();
    protected boolean createAfterRequestSuccess() {
        return false;
    }

    /**
     * 准备网络请求时的布局
     * @return
     */
    protected abstract int prepareRequestView();
    /**
     * 当没有响应数据时加载的布局
     */
    protected abstract int noResponseView();
    /**
     * 开启请求
     */
    protected abstract void onRequest();
}
