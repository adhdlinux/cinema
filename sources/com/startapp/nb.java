package com.startapp;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebView;

public class nb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34968a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f34969b;

    public class a implements MessageQueue.IdleHandler {
        public a() {
        }

        public boolean queueIdle() {
            nb nbVar = nb.this;
            if (nbVar.f34969b != null) {
                return false;
            }
            try {
                nbVar.f34969b = new WebView(nbVar.f34968a);
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public nb(Context context) {
        if (Build.VERSION.SDK_INT < 31 || context.isUiContext()) {
            this.f34968a = context;
        } else {
            this.f34968a = context.createWindowContext(((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0), 2, (Bundle) null);
        }
        a();
    }

    public final void a() {
        MessageQueue myQueue = Looper.myQueue();
        if (myQueue != null) {
            myQueue.addIdleHandler(new a());
        }
    }

    public WebView b() {
        WebView webView = this.f34969b;
        if (webView == null) {
            return new WebView(this.f34968a);
        }
        this.f34969b = null;
        MessageQueue myQueue = Looper.myQueue();
        if (myQueue == null) {
            return webView;
        }
        myQueue.addIdleHandler(new a());
        return webView;
    }
}
