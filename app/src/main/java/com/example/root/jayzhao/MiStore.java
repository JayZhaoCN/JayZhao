package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by hm on 16-1-18.
 */
public class MiStore extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setContentView(R.layout.mi_store);
        super.onCreate(savedInstanceState);

        //WebView webView = (WebView) findViewById(R.id.webView);
        //实例化WebView对象webView = new WebView(this);
        //设置WebView属性，能够执行Javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webView.loadUrl("http://baidu.com");
        //设置Web视图
        setContentView(webView);

    }
}
