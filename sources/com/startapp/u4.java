package com.startapp;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class u4 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36642a = false;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f36643b;

    public u4(Context context, Runnable runnable) {
        this.f36643b = runnable;
    }

    @JavascriptInterface
    public void closeSplash() {
        if (!this.f36642a) {
            this.f36642a = true;
            this.f36643b.run();
        }
    }
}
