package com.vinkas.webkit;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;

/**
 * Created by Vinoth on 21-5-16.
 */
public class BrowserView extends RelativeLayout implements SwipeRefreshLayout.OnRefreshListener {

    public BrowserView(Context context) {
        super(context);
        initialize();
    }

    public BrowserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public void initialize() {
        swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        swipeRefreshLayout.setLayoutParams(new BrowserView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.setOnRefreshListener(this);
        addView(swipeRefreshLayout);
        webView = new WebView(getContext());
        webView.setLayoutParams(new SwipeRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        swipeRefreshLayout.addView(webView);
    }

    private WebView webView;
    private SwipeRefreshLayout swipeRefreshLayout;

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