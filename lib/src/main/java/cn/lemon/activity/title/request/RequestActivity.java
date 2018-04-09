package cn.lemon.activity.title.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.lemon.activity.title.TitleActivity;
import cn.lemon.androidlib.R;

/**
 * 默认情况为不需要通过request初始化数据的带标题栏的Activity
 * 1.通过createAfterRequestSuccess设置需要初始化数据功能
 * 2.通过noResponseContentView设置网络失败的布局
 */
public abstract class RequestActivity extends TitleActivity {

    View.OnClickListener refreshListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int prepare = prepareRequestView();
            if (prepare != 0) {
                setContentView(prepare);
            }
            onRequest();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleView(titleLayoutId());
        if (!createAfterRequestSuccess()) {
            setContentView(contentLayoutId());
        } else {
            int prepare = prepareRequestView();
            if (prepare != 0) {
                setContentView(prepare);
            }
            onRequest();
        }
        onCreate();
    }
    /**
     * 网络请求成功后需调用该方法
     */
    protected void whenRequestSuccess() {
        setContentView(contentLayoutId());
    }
    /**
     * 网络请求失败后需调用该方法
     */
    protected void whenRequestFail() {
        int noResponse = noResponseView();
        if (noResponse != 0) {
            View view = LayoutInflater.from(thisActivity).inflate(noResponseView(), null);
            setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            int refreshBtnId = refreshBtnId();
            if (refreshBtnId != 0) {
                view.findViewById(refreshBtnId).setOnClickListener(refreshListener);
            } else {
                view.setOnClickListener(refreshListener);
            }
        }
    }

    protected abstract void onCreate();
    protected abstract int titleLayoutId();
    protected abstract int contentLayoutId();
    protected boolean createAfterRequestSuccess() {
        return false;
    }

    /**
     * 准备网络请求时的布局
     */
    protected int prepareRequestView() {
        return R.layout.layout_request_prepare;
    }
    /**
     * 当没有响应数据时加载的布局
     */
    protected int noResponseView() {
        return R.layout.layout_request_fail;
    }

    protected int refreshBtnId() {
        return 0;
    }
    /**
     * 开启请求
     */
    protected abstract void onRequest();
}