package com.vinkas.sample.webkit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vinkas.webkit.BrowserLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BrowserLayout browserLayout = (BrowserLayout) findViewById(R.id.browser);
        browserLayout.loadUrl("https://github.com/Vinkas-com");
    }

}
