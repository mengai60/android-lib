# BaseActivity自定义多样化标题布局
## 目的
    该库主要提供布局文件在Acitivity使用时，标题和内容的解耦方案
    并提供Activity进入需要请求网络的预加载处理
## 引用
```
    compile 'cn.lemon.androidlib:lib:1.0.4'
```
## TitleActivity用法
### 基本用法
**继承TitleActivity**
```
public class TestAcitivity extends TitleActivity {}
```
**设置标题布局**
```
        setTitleView(R.layout.layout_title);
```
**设置内容布局**
```
        setContentView(R.layout.activity_test);
```
### 自定义
**设置布局风格**
```
    @override
    protected ITitleStyle titleStyle() {
        return new DefaultTitleStyle();
    }
```
**设置是否开启资源id识别**
```
    @Override
    protected boolean libResIdsEnable() {
        return true;
    }
```
**设置标题**
```
        setCustomTitle("这是标题");
```
## RequestActivity用法
### 基本用法
**继承RequestActivity**
```
public class TestRequestActivity extends RequestActivity{}
```
**在onRequest方法中请求接口**
```
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
```
**成功调用whenRequestSuccess()**

**成功调用whenRequestFail()**

### 自定义
**复写布局方法**
```
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
```