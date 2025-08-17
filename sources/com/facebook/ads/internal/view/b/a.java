package com.facebook.ads.internal.view.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends com.facebook.ads.internal.q.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20888a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<b> f20889b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f20890c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f20891d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<d> f20892e;

    /* renamed from: f  reason: collision with root package name */
    private com.facebook.ads.internal.r.a f20893f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public u f20894g = new u();

    /* renamed from: h  reason: collision with root package name */
    private a.C0035a f20895h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f20896i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20897j;

    /* renamed from: com.facebook.ads.internal.view.b.a$a  reason: collision with other inner class name */
    static class C0039a {

        /* renamed from: a  reason: collision with root package name */
        private final String f20899a = C0039a.class.getSimpleName();

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<a> f20900b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<b> f20901c;

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<com.facebook.ads.internal.r.a> f20902d;

        /* renamed from: e  reason: collision with root package name */
        private final WeakReference<AtomicBoolean> f20903e;

        /* renamed from: f  reason: collision with root package name */
        private final WeakReference<AtomicBoolean> f20904f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f20905g;

        C0039a(a aVar, b bVar, com.facebook.ads.internal.r.a aVar2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, boolean z2) {
            this.f20900b = new WeakReference<>(aVar);
            this.f20901c = new WeakReference<>(bVar);
            this.f20902d = new WeakReference<>(aVar2);
            this.f20903e = new WeakReference<>(atomicBoolean);
            this.f20904f = new WeakReference<>(atomicBoolean2);
            this.f20905g = z2;
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f20899a, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return k.a(com.facebook.ads.internal.g.a.a());
        }

        @JavascriptInterface
        public void onMainAssetLoaded() {
            if (this.f20900b.get() != null && this.f20903e.get() != null && this.f20904f.get() != null && this.f20905g && this.f20904f.get().get()) {
                this.f20903e.get().set(true);
                if (this.f20900b.get().isShown()) {
                    new Handler(Looper.getMainLooper()).post(new e(this.f20902d));
                }
            }
        }

        @JavascriptInterface
        public void onPageInitialized() {
            a aVar = this.f20900b.get();
            if (aVar != null && !aVar.c()) {
                b bVar = this.f20901c.get();
                if (bVar != null) {
                    bVar.a();
                }
                if (!this.f20905g && this.f20900b.get().isShown()) {
                    new Handler(Looper.getMainLooper()).post(new e(this.f20902d));
                }
            }
        }
    }

    public interface b {
        void a();

        void a(int i2);

        void a(WebResourceError webResourceError);

        void a(String str, Map<String, String> map);

        void b();
    }

    public static class c implements b {
        public void a() {
        }

        public void a(int i2) {
        }

        public void a(WebResourceError webResourceError) {
        }

        public void a(String str, Map<String, String> map) {
        }

        public void b() {
        }
    }

    public interface d {
        void b();
    }

    static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<com.facebook.ads.internal.r.a> f20906a;

        e(com.facebook.ads.internal.r.a aVar) {
            this.f20906a = new WeakReference<>(aVar);
        }

        e(WeakReference<com.facebook.ads.internal.r.a> weakReference) {
            this.f20906a = weakReference;
        }

        public void run() {
            com.facebook.ads.internal.r.a aVar = this.f20906a.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    static class f extends WebChromeClient {
        f() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    static class g extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<b> f20907a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<com.facebook.ads.internal.r.a> f20908b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<u> f20909c;

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<AtomicBoolean> f20910d;

        /* renamed from: e  reason: collision with root package name */
        private final WeakReference<a> f20911e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f20912f = false;

        g(WeakReference<b> weakReference, WeakReference<com.facebook.ads.internal.r.a> weakReference2, WeakReference<u> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<a> weakReference5) {
            this.f20907a = weakReference;
            this.f20908b = weakReference2;
            this.f20909c = weakReference3;
            this.f20910d = weakReference4;
            this.f20911e = weakReference5;
        }

        /* access modifiers changed from: private */
        public void a(WebResourceError webResourceError) {
            if (this.f20907a.get() != null) {
                this.f20907a.get().a(webResourceError);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (!(this.f20911e.get() == null || this.f20910d.get() == null || this.f20910d.get().get())) {
                this.f20911e.get().e();
            }
            this.f20912f = true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (!g.this.f20912f) {
                        g.this.a((WebResourceError) null);
                    }
                }
            }, 2000);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.f20912f = true;
            a(webResourceError);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            HashMap hashMap = new HashMap();
            if (this.f20908b.get() != null) {
                this.f20908b.get().a((Map<String, String>) hashMap);
            }
            if (this.f20909c.get() != null) {
                hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(this.f20909c.get().e()));
            }
            if (this.f20907a.get() == null) {
                return true;
            }
            this.f20907a.get().a(str, hashMap);
            return true;
        }
    }

    public a(Context context, WeakReference<b> weakReference, int i2) {
        super(context);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.f20890c = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        this.f20891d = atomicBoolean2;
        this.f20897j = com.facebook.ads.internal.l.a.v(context);
        this.f20889b = weakReference;
        this.f20895h = new a.C0035a() {
            public void a() {
                if (a.this.f20896i || !a.this.f20894g.b()) {
                    a.this.f20894g.a();
                }
                if (a.this.f20889b.get() != null) {
                    ((b) a.this.f20889b.get()).b();
                }
            }
        };
        this.f20893f = new com.facebook.ads.internal.r.a(this, i2, this.f20895h);
        setWebChromeClient(a());
        setWebViewClient(b());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        addJavascriptInterface(new C0039a(this, weakReference.get(), this.f20893f, atomicBoolean, atomicBoolean2, this.f20897j), "AdControl");
    }

    private boolean d() {
        return !this.f20897j || this.f20890c.get();
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f20890c.set(true);
        new Handler(Looper.getMainLooper()).post(new e(this.f20893f));
        WeakReference<d> weakReference = this.f20892e;
        if (weakReference != null && weakReference.get() != null) {
            this.f20892e.get().b();
        }
    }

    /* access modifiers changed from: protected */
    public WebChromeClient a() {
        return new f();
    }

    public void a(int i2, int i3) {
        com.facebook.ads.internal.r.a aVar = this.f20893f;
        if (aVar != null) {
            aVar.a(i2);
            this.f20893f.b(i3);
        }
    }

    /* access modifiers changed from: protected */
    public WebViewClient b() {
        return new g(this.f20889b, new WeakReference(this.f20893f), new WeakReference(this.f20894g), new WeakReference(this.f20891d), new WeakReference(this));
    }

    public void destroy() {
        com.facebook.ads.internal.r.a aVar = this.f20893f;
        if (aVar != null) {
            aVar.c();
            this.f20893f = null;
        }
        x.b(this);
        this.f20895h = null;
        this.f20894g = null;
        com.facebook.ads.internal.q.c.b.a(this);
        super.destroy();
    }

    public Map<String, String> getTouchData() {
        return this.f20894g.e();
    }

    public u getTouchDataRecorder() {
        return this.f20894g;
    }

    public com.facebook.ads.internal.r.a getViewabilityChecker() {
        return this.f20893f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f20894g.a(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f20889b.get() != null) {
            this.f20889b.get().a(i2);
        }
        if (this.f20893f != null) {
            if (i2 == 0 && d()) {
                this.f20893f.a();
            } else if (i2 == 8) {
                this.f20893f.c();
            }
        }
    }

    public void setCheckAssetsByJavascriptBridge(boolean z2) {
        this.f20891d.set(z2);
    }

    public void setLogMultipleImpressions(boolean z2) {
        this.f20896i = z2;
    }

    public void setOnAssetsLoadedListener(d dVar) {
        this.f20892e = new WeakReference<>(dVar);
    }

    public void setWaitForAssetsToLoad(boolean z2) {
        this.f20897j = z2;
    }
}
