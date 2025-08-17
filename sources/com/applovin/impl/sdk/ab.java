package com.applovin.impl.sdk;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;

public class ab {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WebView f15071a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f15072b;

    public static String a() {
        return f15072b;
    }

    public static void a(m mVar) {
    }

    public static void b(final m mVar) {
        if (f15072b == null) {
            f15072b = "";
            if (g.b()) {
                mVar.S().a((a) new z(mVar, true, new Runnable() {
                    public void run() {
                        try {
                            String unused = ab.f15072b = WebSettings.getDefaultUserAgent(m.this.L());
                        } catch (Throwable th) {
                            if (v.a()) {
                                m.this.A().b("WebViewDataCollector", "Failed to collect user agent", th);
                            }
                        }
                    }
                }), o.a.BACKGROUND);
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            ab.a(m.this);
                            String unused = ab.f15072b = ab.f15071a.getSettings().getUserAgentString();
                        } catch (Throwable th) {
                            if (v.a()) {
                                m.this.A().b("WebViewDataCollector", "Failed to collect user agent", th);
                            }
                        }
                    }
                });
            }
        }
    }
}
