package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a  reason: collision with root package name */
    private String f16063a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f16064b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EventListener f16065c;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f16065c = eventListener;
        WebView webView = this.f16064b;
        if (webView == null) {
            this.f16063a = str;
        } else {
            webView.loadUrl(str);
        }
    }

    public void onBackPressed() {
        EventListener eventListener = this.f16065c;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            if (v.a()) {
                v.i("AppLovinWebViewActivity", "No SDK key specified");
            }
            finish();
            return;
        }
        final m mVar = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).coreSdk;
        WebView tryToCreateWebView = Utils.tryToCreateWebView(this, "WebView Activity");
        this.f16064b = tryToCreateWebView;
        if (tryToCreateWebView == null) {
            finish();
            return;
        }
        setContentView(tryToCreateWebView);
        WebSettings settings = this.f16064b.getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        this.f16064b.setVerticalScrollBarEnabled(true);
        this.f16064b.setHorizontalScrollBarEnabled(true);
        this.f16064b.setScrollBarStyle(33554432);
        this.f16064b.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                if (v.a()) {
                    v A = mVar.A();
                    A.b("AppLovinWebViewActivity", "Handling url load: " + str);
                }
                if (!"applovin".equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f16065c == null) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                if (!path.endsWith("webview_event")) {
                    return true;
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                if (StringUtils.isValidString(str2)) {
                    String queryParameter = parse.getQueryParameter(str2);
                    if (v.a()) {
                        v A2 = mVar.A();
                        A2.b("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                    }
                    AppLovinWebViewActivity.this.f16065c.onReceivedEvent(queryParameter);
                    return true;
                } else if (!v.a()) {
                    return true;
                } else {
                    mVar.A().e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                    return true;
                }
            }
        });
        if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        if (StringUtils.isValidString(this.f16063a)) {
            this.f16064b.loadUrl(this.f16063a);
        }
    }
}
