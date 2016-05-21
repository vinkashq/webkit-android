package com.vinkas.webkit;

import android.graphics.Bitmap;
import android.webkit.WebView;

/**
 * Created by Vinoth on 21-5-16.
 */
public class WebViewClient extends android.webkit.WebViewClient {

    private OnPageLoadListener onPageLoadListener;

    public void setOnPageLoadListener(OnPageLoadListener onPageLoadListener) {
        this.onPageLoadListener = onPageLoadListener;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        onPageLoadListener.onFinished((com.vinkas.webkit.WebView) view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        onPageLoadListener.onStarted((com.vinkas.webkit.WebView) view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
