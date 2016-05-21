package com.vinkas.webkit;

import android.webkit.WebView;

/**
 * Created by Vinoth on 21-5-16.
 */
public class WebViewClient extends android.webkit.WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
