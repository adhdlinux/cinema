package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.util.UriUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
public class f extends com.facebook.ads.internal.q.c.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f20859a = "f";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f20860b;

    /* renamed from: c  reason: collision with root package name */
    private a f20861c;

    /* renamed from: d  reason: collision with root package name */
    private d f20862d;

    /* renamed from: e  reason: collision with root package name */
    private long f20863e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f20864f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f20865g = -1;

    /* renamed from: h  reason: collision with root package name */
    private long f20866h = -1;

    public interface a {
        void a(int i2);

        void a(String str);

        void b(String str);

        void c(String str);
    }

    static class b extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f20867a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<d> f20868b;

        b(WeakReference<a> weakReference, WeakReference<d> weakReference2) {
            this.f20867a = weakReference;
            this.f20868b = weakReference2;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG || this.f20868b.get() == null) {
                return true;
            }
            this.f20868b.get().a(message);
            return true;
        }

        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            if (this.f20868b.get() != null) {
                this.f20868b.get().a();
            }
            if (this.f20867a.get() != null) {
                this.f20867a.get().a(i2);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (this.f20867a.get() != null) {
                this.f20867a.get().b(str);
            }
        }
    }

    static class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f20869a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Context> f20870b;

        c(WeakReference<a> weakReference, WeakReference<Context> weakReference2) {
            this.f20869a = weakReference;
            this.f20870b = weakReference2;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f20869a.get() != null) {
                this.f20869a.get().c(str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f20869a.get() != null) {
                this.f20869a.get().a(str);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (f.f20860b.contains(parse.getScheme()) || this.f20870b.get() == null) {
                return false;
            }
            try {
                this.f20870b.get().startActivity(new Intent("android.intent.action.VIEW", parse));
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.w(f.f20859a, "Activity not found to handle URI.", e2);
                return false;
            } catch (Exception e3) {
                Log.e(f.f20859a, "Unknown exception occurred when trying to handle URI.", e3);
                return false;
            }
        }
    }

    static {
        HashSet hashSet = new HashSet(2);
        f20860b = hashSet;
        hashSet.add(UriUtil.HTTP_SCHEME);
        hashSet.add(UriUtil.HTTPS_SCHEME);
    }

    public f(Context context) {
        super(context);
        f();
    }

    private void f() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.f20862d = new d(this);
    }

    private void g() {
        if (this.f20864f > -1 && this.f20865g > -1 && this.f20866h > -1) {
            this.f20862d.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public WebChromeClient a() {
        return new b(new WeakReference(this.f20861c), new WeakReference(this.f20862d));
    }

    public void a(long j2) {
        if (this.f20863e < 0) {
            this.f20863e = j2;
        }
    }

    public void a(String str) {
        try {
            evaluateJavascript(str, (ValueCallback) null);
        } catch (IllegalStateException unused) {
            loadUrl("javascript:" + str);
        }
    }

    /* access modifiers changed from: protected */
    public WebViewClient b() {
        return new c(new WeakReference(this.f20861c), new WeakReference(getContext()));
    }

    public void b(long j2) {
        if (this.f20864f < 0) {
            this.f20864f = j2;
        }
        g();
    }

    public void c(long j2) {
        if (this.f20866h < 0) {
            this.f20866h = j2;
        }
        g();
    }

    public void destroy() {
        this.f20861c = null;
        com.facebook.ads.internal.q.c.b.a(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.f20864f;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return copyBackForwardList.getSize() > 0 ? copyBackForwardList.getItemAtIndex(0).getUrl() : getUrl();
    }

    public long getLoadFinishMs() {
        return this.f20866h;
    }

    public long getResponseEndMs() {
        return this.f20863e;
    }

    public long getScrollReadyMs() {
        return this.f20865g;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20865g < 0 && computeVerticalScrollRange() > getHeight()) {
            this.f20865g = System.currentTimeMillis();
            g();
        }
    }

    public void setListener(a aVar) {
        this.f20861c = aVar;
    }
}
