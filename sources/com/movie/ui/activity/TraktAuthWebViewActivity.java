package com.movie.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewDatabase;
import android.widget.TextView;
import com.androidadvance.topsnackbar.TSnackbar;
import com.movie.AppComponent;
import com.original.Constants;
import com.original.tase.I18N;
import com.original.tase.Logger;
import com.original.tase.RxBus;
import com.original.tase.event.trakt.TraktGetTokenFailedEvent;
import com.original.tase.event.trakt.TraktGetTokenSuccessEvent;
import com.original.tase.event.trakt.TraktUserCancelledAuthEvent;
import com.original.tase.utils.DeviceUtils;
import com.original.tase.utils.NetworkUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class TraktAuthWebViewActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TSnackbar f32177b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f32178c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f32179d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f32180e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f32181f = null;

    class C50911 extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final TraktAuthWebViewActivity f32182a;

        C50911(TraktAuthWebViewActivity traktAuthWebViewActivity) {
            this.f32182a = traktAuthWebViewActivity;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (webView.getTitle().equals("Trakt.tv") && str.endsWith("/authorize")) {
                Utils.i0(this.f32182a, I18N.a(R.string.plaese_wait));
                if (this.f32182a.f32177b != null) {
                    this.f32182a.f32177b.t();
                }
                this.f32182a.G(true);
            } else if (webView.getTitle().toLowerCase().contains("activate your device") || (TraktAuthWebViewActivity.this.f32181f != null && str.contains(TraktAuthWebViewActivity.this.f32181f))) {
                if (this.f32182a.f32177b != null) {
                    this.f32182a.f32177b.t();
                }
                this.f32182a.G(false);
            } else {
                if (this.f32182a.f32177b != null) {
                    this.f32182a.f32177b.j();
                }
                this.f32182a.G(false);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.f32182a.G(true);
            return false;
        }
    }

    class C51482 implements Consumer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final TraktAuthWebViewActivity f32184b;

        C51482(TraktAuthWebViewActivity traktAuthWebViewActivity) {
            this.f32184b = traktAuthWebViewActivity;
        }

        public void accept(Object obj) {
            boolean z2 = obj instanceof TraktGetTokenSuccessEvent;
            if (z2 || (obj instanceof TraktGetTokenFailedEvent)) {
                if (z2) {
                    boolean unused = this.f32184b.f32178c = true;
                }
                this.f32184b.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void F(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public void G(boolean z2) {
        int i2;
        int i3;
        View findViewById = findViewById(R.id.webView);
        int i4 = 8;
        if (z2) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        View findViewById2 = findViewById(R.id.tvPleaseWait);
        if (z2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        View findViewById3 = findViewById(R.id.pbPleaseWait);
        if (z2) {
            i4 = 0;
        }
        findViewById3.setVisibility(i4);
    }

    public void finish() {
        if (!this.f32178c) {
            RxBus.a().b(new TraktUserCancelledAuthEvent());
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        this.needToCancelHttpHelper = false;
        Bundle extras = getIntent().getExtras();
        String[] strArr = null;
        if (extras.getString("verificationUrl", (String) null) == null || extras.getString("verificationUrl", (String) null).isEmpty() || extras.getString("userCode", (String) null) == null || extras.getString("userCode", (String) null).isEmpty() || !NetworkUtils.a()) {
            if (NetworkUtils.a()) {
                Utils.i0(this, I18N.a(R.string.error));
            } else {
                Utils.i0(this, I18N.a(R.string.no_internet));
            }
            setResult(0);
            finish();
            return;
        }
        String string = extras.getString("verificationUrl");
        String string2 = extras.getString("userCode");
        if (string != null && string.contains("/")) {
            strArr = string.split("/");
        }
        if (strArr != null) {
            String str = strArr[strArr.length - 1];
        }
        setTitle("Trakt Auth");
        if (DeviceUtils.c()) {
            TextView textView = (TextView) findViewById(R.id.tvPleaseWait);
            textView.setTextSize(2, 24.0f);
            textView.setText(String.format("1) Visit \"%s\" in a browser of any of your devices\n2) Login to Trakt.tv\n3) Input the following code: %s\n\nThis window will be closed automatically after you have granted the Trakt.tv API access to Cinema TV", new Object[]{string, string2}));
            G(true);
        } else {
            View findViewById = findViewById(R.id.webViewActivityRoot);
            this.f32177b = TSnackbar.p(findViewById, Html.fromHtml("<font color=\"#ffffff\">Enter the code: " + string2 + "</font>"), -2);
            try {
                WebViewDatabase.getInstance(this).clearFormData();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            WebView webView = (WebView) findViewById(R.id.webView);
            this.f32180e = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f32180e.getSettings().setAllowFileAccess(false);
            this.f32180e.getSettings().setSaveFormData(false);
            this.f32180e.getSettings().setSavePassword(false);
            this.f32180e.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
            this.f32180e.getSettings().setCacheMode(2);
            this.f32180e.getSettings().setUserAgentString(Constants.C);
            try {
                this.f32180e.clearCache(true);
                this.f32180e.clearFormData();
            } catch (Throwable th2) {
                Logger.d(th2, new boolean[0]);
            }
            CookieManager.getInstance().setAcceptCookie(true);
            this.f32180e.setWebViewClient(new C50911(this));
            this.f32180e.loadUrl(string);
        }
        this.f32179d = RxBus.a().c().subscribe(new C51482(this), new o0());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = this.f32180e;
        if (webView != null) {
            if (webView.getParent() != null && (this.f32180e.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f32180e.getParent()).removeView(this.f32180e);
            }
            this.f32180e.removeAllViews();
            this.f32180e.destroy();
        }
        Disposable disposable = this.f32179d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f32179d.dispose();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        setResult(0);
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        WebView webView = this.f32180e;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f32180e;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
