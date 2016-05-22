package com.vinkas.webkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;

/**
 * Created by Vinoth on 21-5-16.
 */
public class WebView extends android.webkit.WebView {

    public void setOnPageLoadListener(OnPageLoadListener onPageLoadListener) {
        webViewClient.setOnPageLoadListener(onPageLoadListener);
        webChromeClient.setOnPageLoadListener(onPageLoadListener);
    }

    public WebView(Context context) {
        super(context);
        initialize();
    }

    public WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public WebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(21)
    public WebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    public WebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        initialize();
    }

    public void initialize() {
        webViewClient = new WebViewClient();
        setWebViewClient(webViewClient);
        webChromeClient = new WebChromeClient();
        setWebChromeClient(webChromeClient);
        if(Build.VERSION.SDK_INT < 18)
            getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 19) {
            // chromium, enable hardware acceleration
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    }

    private WebViewClient webViewClient;
    private WebChromeClient webChromeClient;

    public WebChromeClient getWebChromeClient() {
        return webChromeClient;
    }

    public WebViewClient getWebViewClient() {
        return webViewClient;
    }
}
