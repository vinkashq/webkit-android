package com.vinkas.webkit;

import android.webkit.WebView;

/**
 * Created by Vinoth on 21-5-16.
 */
public class WebChromeClient extends android.webkit.WebChromeClient {

    private OnPageLoadListener onPageLoadListener;

    public void setOnPageLoadListener(OnPageLoadListener onPageLoadListener) {
        this.onPageLoadListener = onPageLoadListener;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        onPageLoadListener.onProgressChanged((com.vinkas.webkit.WebView) view, newProgress);
    }
}
