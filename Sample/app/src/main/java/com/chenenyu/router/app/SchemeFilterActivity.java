package com.chenenyu.router.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.chenenyu.router.Router;

/**
 * How to handle route from browser.
 * Created by chen on 17-5-9.
 */
public class SchemeFilterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        if (uri != null) {
            Log.d("SchemeFilterActivity", "uri: " + uri.toString());
//            if (!"router://filter".equals(uri.toString())) {
//                Router.build(uri).go(this);
//            }
            // 调用skipImplicitMatcher() 防止隐式启动死循环
            Router.build(uri).skipImplicitMatcher().go(this);
            finish();
        }
    }
}
