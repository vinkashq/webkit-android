package com.vinkas.webkit;

import android.graphics.Bitmap;

/**
 * Created by Vinoth on 22-5-16.
 */
public interface OnPageLoadListener {
    void onStarted(WebView view, String url, Bitmap favicon);
    void onFinished(WebView view, String url);
    void onProgressChanged(WebView view, int newProgress);
}
