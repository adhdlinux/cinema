package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class td {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36582a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36583b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f36584c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f36585d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f36586e;

    /* renamed from: f  reason: collision with root package name */
    public Context f36587f;

    /* renamed from: g  reason: collision with root package name */
    public TrackingParams f36588g;

    public td(Context context, Runnable runnable, TrackingParams trackingParams, boolean z2) {
        this(context, runnable, trackingParams);
        this.f36583b = z2;
    }

    @JavascriptInterface
    public void closeAd() {
        if (!this.f36582a) {
            this.f36582a = true;
            this.f36584c.run();
        }
    }

    @JavascriptInterface
    public void enableScroll(String str) {
        Runnable runnable = this.f36586e;
        if (runnable != null) {
            runnable.run();
        }
    }

    @JavascriptInterface
    public void externalLinks(String str) {
        if (this.f36583b) {
            Map<Activity, Integer> map = lb.f34876a;
            o6.a(this.f36587f, str, (String) null);
            return;
        }
        o6.b(this.f36587f, str, (String) null);
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str)) {
            o6.a(this.f36587f, str, this.f36588g);
        }
        Intent a2 = lb.a(this.f36587f, str2);
        if (!(a2 == null || str3 == null)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    a2.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
            }
        }
        if (a2 != null) {
            try {
                this.f36587f.startActivity(a2);
            } catch (Throwable th) {
                y8.a(this.f36587f, th);
            }
        }
        Runnable runnable = this.f36585d;
        if (runnable != null) {
            runnable.run();
        }
    }

    public td(Context context, Runnable runnable, TrackingParams trackingParams) {
        this.f36582a = false;
        this.f36583b = true;
        this.f36585d = null;
        this.f36586e = null;
        this.f36584c = runnable;
        this.f36587f = context;
        this.f36588g = trackingParams;
    }

    public td(Context context, Runnable runnable, Runnable runnable2, TrackingParams trackingParams) {
        this(context, runnable, trackingParams);
        this.f36585d = runnable2;
    }
}
