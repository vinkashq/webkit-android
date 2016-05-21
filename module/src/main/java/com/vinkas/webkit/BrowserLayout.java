package com.vinkas.webkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * Created by Vinoth on 21-5-16.
 */
public class BrowserLayout extends RelativeLayout implements SwipeRefreshLayout.OnRefreshListener, OnPageLoadListener {

    public BrowserLayout(Context context) {
        super(context);
        initialize();
    }

    public BrowserLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public void initialize() {
        swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        swipeRefreshLayout.setLayoutParams(new BrowserLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setOnRefreshListener(this);
        addView(swipeRefreshLayout);

        webView = new WebView(getContext());
        webView.setLayoutParams(new SwipeRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        webView.setOnPageLoadListener(this);
        swipeRefreshLayout.addView(webView);
    }

    @Override
    public void onFinished(WebView view, String url) {

    }

    @Override
    public void onStarted(WebView view, String url, Bitmap favicon) {

    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        if(newProgress >= 100) {
            swipeRefreshLayout.setRefreshing(false);
        } else {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    private WebView webView;
    private SwipeRefreshLayout swipeRefreshLayout;

    public String getUrl() {
        return getWebView().getUrl();
    }

    public void loadUrl(String url) {
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