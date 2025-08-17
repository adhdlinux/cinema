package com.startapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.lb;
import com.startapp.sdk.adsbase.AdsConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class mb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34914a;

    /* renamed from: b  reason: collision with root package name */
    public final nb f34915b;

    /* renamed from: c  reason: collision with root package name */
    public final Queue<WeakReference<WebView>> f34916c = new LinkedList();

    public class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f34917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f34918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WebView f34919c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ lb.a f34920d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f34921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f34922f;

        /* renamed from: com.startapp.mb$a$a  reason: collision with other inner class name */
        public class C0054a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f34924a;

            public C0054a(long j2) {
                this.f34924a = j2;
            }

            public void run() {
                if (a.this.f34918b.compareAndSet(false, true)) {
                    a aVar = a.this;
                    mb.this.a(aVar.f34919c);
                    a aVar2 = a.this;
                    aVar2.f34920d.a(false, aVar2.f34921e.get(), this.f34924a, true);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f34926a;

            public b(String str) {
                this.f34926a = str;
            }

            public void run() {
                if (a.this.f34918b.compareAndSet(false, true)) {
                    a aVar = a.this;
                    mb.this.a(aVar.f34919c);
                    a.this.f34920d.a(3, String.valueOf(this.f34926a));
                }
            }
        }

        public a(Handler handler, AtomicBoolean atomicBoolean, WebView webView, lb.a aVar, AtomicLong atomicLong, int i2) {
            this.f34917a = handler;
            this.f34918b = atomicBoolean;
            this.f34919c = webView;
            this.f34920d = aVar;
            this.f34921e = atomicLong;
            this.f34922f = i2;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            long a2 = lb.a();
            this.f34917a.removeCallbacksAndMessages((Object) null);
            this.f34917a.postDelayed(new C0054a(a2), (long) this.f34922f);
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            this.f34917a.removeCallbacksAndMessages((Object) null);
            this.f34917a.post(new b(str));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null || lb.b(webView.getContext(), str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f34928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebView f34929b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ lb.a f34930c;

        public b(AtomicBoolean atomicBoolean, WebView webView, lb.a aVar) {
            this.f34928a = atomicBoolean;
            this.f34929b = webView;
            this.f34930c = aVar;
        }

        public void run() {
            if (this.f34928a.compareAndSet(false, true)) {
                mb.this.a(this.f34929b);
                this.f34930c.a(2, "Unknown error");
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f34932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebView f34933b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ lb.a f34934c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f34935d;

        public c(AtomicBoolean atomicBoolean, WebView webView, lb.a aVar, AtomicLong atomicLong) {
            this.f34932a = atomicBoolean;
            this.f34933b = webView;
            this.f34934c = aVar;
            this.f34935d = atomicLong;
        }

        public void run() {
            if (this.f34932a.compareAndSet(false, true)) {
                mb.this.a(this.f34933b);
                this.f34934c.a(false, this.f34935d.get(), lb.a(), false);
            }
        }
    }

    public mb(Context context, nb nbVar) {
        this.f34914a = context;
        this.f34915b = nbVar;
    }

    public void a(WebView webView) {
        webView.stopLoading();
        webView.loadUrl("about:blank");
        if (this.f34916c.size() < 3) {
            this.f34916c.add(new WeakReference(webView));
        } else {
            webView.destroy();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(String str, lb.a aVar) {
        int i2;
        String str2 = str;
        lb.a aVar2 = aVar;
        if ("true".equals(lb.a(str2, "@doNotRender@", "@doNotRender@"))) {
            aVar.a(true, 0, 0, false);
            return;
        }
        WebView webView = null;
        while (webView == null) {
            try {
                if (this.f34916c.size() <= 0) {
                    break;
                }
                WeakReference poll = this.f34916c.poll();
                if (poll != null) {
                    webView = (WebView) poll.get();
                }
            } catch (Throwable th) {
                y8.a(this.f34914a, th);
                aVar2.a(1, "WebView instantiation Error");
                return;
            }
        }
        if (webView == null) {
            webView = this.f34915b.b();
        }
        WebView webView2 = webView;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        Handler handler = new Handler(Looper.getMainLooper());
        AtomicLong atomicLong = new AtomicLong();
        if (AdsConstants.f36193g.booleanValue()) {
            webView2.getSettings().setBlockNetworkImage(false);
            webView2.getSettings().setLoadsImagesAutomatically(true);
            webView2.getSettings().setJavaScriptEnabled(true);
            i2 = 25000;
        } else {
            i2 = 0;
        }
        webView2.setWebChromeClient(new WebChromeClient());
        a aVar3 = r1;
        AtomicLong atomicLong2 = atomicLong;
        a aVar4 = new a(handler, atomicBoolean, webView2, aVar, atomicLong, i2);
        webView2.setWebViewClient(aVar3);
        atomicLong2.set(lb.a());
        if (!lb.a(this.f34914a, webView2, str2)) {
            handler.removeCallbacksAndMessages((Object) null);
            handler.post(new b(atomicBoolean, webView2, aVar2));
            return;
        }
        handler.postDelayed(new c(atomicBoolean, webView2, aVar, atomicLong2), 25000);
    }
}
