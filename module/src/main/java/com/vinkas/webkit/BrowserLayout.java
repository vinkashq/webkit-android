package com.vinkas.webkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Vinoth on 21-5-16.
 */
public class BrowserLayout extends RelativeLayout implements SwipeRefreshLayout.OnRefreshListener, OnPageLoadListener, View.OnKeyListener {

    public BrowserLayout(Context context) {
        super(context);
        initialize();
    }

    public BrowserLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public BrowserLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public BrowserLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initialize() {
        swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        swipeRefreshLayout.setLayoutParams(new BrowserLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setOnRefreshListener(this);
        addView(swipeRefreshLayout);

        webView = new WebView(getContext());
        webView.setLayoutParams(new SwipeRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        webView.setOnPageLoadListener(this);
        webView.setOnKeyListener(this);
        swipeRefreshLayout.addView(webView);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return false;
    }

    @Override
    public void onFinished(WebView view, String url) {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onStarted(WebView view, String url, Bitmap favicon) {
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        if(newProgress >= 100)
            swipeRefreshLayout.setRefreshing(false);
        else {
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    private WebView webView;
    private SwipeRefreshLayout swipeRefreshLayout;

    public String getUrl() {
        return getWebView().getUrl();
    }

    public void loadUrl(String url) {
        swipeRefreshLayout.setRefreshing(true);
        getWebView().loadUrl(url);
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public void onRefresh() {
        webView.reload();
    }

    public WebView getWebView() {
        return webView;
    }
}