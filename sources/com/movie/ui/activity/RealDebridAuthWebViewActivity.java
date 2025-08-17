package com.movie.ui.activity;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
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
import com.original.tase.event.ApiDebridGetTokenFailedEvent;
import com.original.tase.event.ApiDebridGetTokenSuccessEvent;
import com.original.tase.event.ApiDebridUserCancelledAuthEvent;
import com.original.tase.utils.DeviceUtils;
import com.original.tase.utils.NetworkUtils;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.yoku.marumovie.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

public class RealDebridAuthWebViewActivity extends BaseActivity {

    /* renamed from: f  reason: collision with root package name */
    public static RealDebridAuthWebViewActivity f32143f;

    /* renamed from: b  reason: collision with root package name */
    private WebView f32144b;

    /* renamed from: c  reason: collision with root package name */
    public TSnackbar f32145c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f32146d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32147e;

    public class HtmlViewerJavaScriptInterface {

        /* renamed from: a  reason: collision with root package name */
        final RealDebridAuthWebViewActivity f32148a;

        public HtmlViewerJavaScriptInterface(RealDebridAuthWebViewActivity realDebridAuthWebViewActivity) {
            this.f32148a = realDebridAuthWebViewActivity;
        }

        @JavascriptInterface
        public void showHTML(String str) {
            if (str != null && !str.isEmpty()) {
                if (str.toLowerCase().contains("application allowed")) {
                    Utils.i0(this.f32148a, I18N.b(R.string.plaese_wait, new Object[0]));
                    this.f32148a.runOnUiThread(new Runnable() {
                        public void run() {
                            TSnackbar tSnackbar = HtmlViewerJavaScriptInterface.this.f32148a.f32145c;
                            if (tSnackbar != null) {
                                tSnackbar.j();
                            }
                            HtmlViewerJavaScriptInterface.this.f32148a.B(true);
                        }
                    });
                } else if (str.toLowerCase().contains("the code")) {
                    this.f32148a.runOnUiThread(new Runnable() {
                        public void run() {
                            TSnackbar tSnackbar = HtmlViewerJavaScriptInterface.this.f32148a.f32145c;
                            if (tSnackbar != null) {
                                tSnackbar.t();
                            }
                            HtmlViewerJavaScriptInterface.this.f32148a.B(false);
                        }
                    });
                } else {
                    this.f32148a.runOnUiThread(new Runnable() {
                        public void run() {
                            TSnackbar tSnackbar = HtmlViewerJavaScriptInterface.this.f32148a.f32145c;
                            if (tSnackbar != null) {
                                tSnackbar.t();
                            }
                            HtmlViewerJavaScriptInterface.this.f32148a.B(false);
                        }
                    });
                }
            }
        }
    }

    public class cusWebViewClient extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private String f32153a;

        public cusWebViewClient(String str) {
            this.f32153a = str;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.loadUrl("javascript:HtmlViewer.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
            webView.evaluateJavascript("javascript:document.getElementById('usercode').value='" + this.f32153a + "';document.getElementsByClassName('btn.btn-primary').click()", new ValueCallback<String>() {
                /* renamed from: a */
                public void onReceiveValue(String str) {
                }
            });
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, (SslErrorHandler) null, sslError);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RealDebridAuthWebViewActivity.this.B(true);
            return false;
        }
    }

    public class subsCustom implements Consumer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final RealDebridAuthWebViewActivity f32156b;

        public subsCustom(RealDebridAuthWebViewActivity realDebridAuthWebViewActivity) {
            this.f32156b = realDebridAuthWebViewActivity;
        }

        public void accept(Object obj) throws Exception {
            boolean z2 = obj instanceof ApiDebridGetTokenSuccessEvent;
            if (z2 || (obj instanceof ApiDebridGetTokenFailedEvent)) {
                if (z2) {
                    this.f32156b.f32147e = true;
                }
                this.f32156b.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void A(Throwable th) throws Exception {
    }

    @SuppressLint({"WrongConstant"})
    public void B(boolean z2) {
        int i2;
        int i3;
        try {
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
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
    }

    public void finish() {
        if (!this.f32147e) {
            RxBus.a().b(new ApiDebridUserCancelledAuthEvent());
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needToCancelHttpHelper = false;
        setContentView(R.layout.activity_web_view);
        f32143f = this;
        Bundle extras = getIntent().getExtras();
        if (extras.getString("verificationUrl", (String) null) == null || extras.getString("verificationUrl", (String) null).isEmpty() || extras.getString("userCode", (String) null) == null || extras.getString("userCode", (String) null).isEmpty() || !NetworkUtils.a()) {
            if (NetworkUtils.a()) {
                Utils.i0(this, "Error");
            }
            Utils.i0(this, "No internet");
            setResult(0);
            finish();
            return;
        }
        String string = extras.getString("verificationUrl");
        String string2 = extras.getString("userCode");
        setTitle("Real-Debrid Auth");
        if (DeviceUtils.c()) {
            TextView textView = (TextView) findViewById(R.id.tvPleaseWait);
            textView.setTextSize(2, 24.0f);
            textView.setText(String.format("1) Visit \"%s\" in a browser of any of your devices\n2) Login to Real-Debrid\n3) Input the following code: %s\n\nThis window will be closed automatically after you have granted the Real-Debrid API access to CINEMA ", new Object[]{string, string2}));
            B(true);
        } else {
            View findViewById = findViewById(R.id.webViewActivityRoot);
            this.f32145c = TSnackbar.p(findViewById, Html.fromHtml("<font color=\"#ffffff\">Enter the code: " + string2 + "</font>"), -1);
            try {
                WebViewDatabase.getInstance(this).clearFormData();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            WebView webView = (WebView) findViewById(R.id.webView);
            this.f32144b = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f32144b.getSettings().setAllowFileAccess(false);
            this.f32144b.getSettings().setSaveFormData(false);
            this.f32144b.getSettings().setSavePassword(false);
            this.f32144b.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
            this.f32144b.getSettings().setCacheMode(2);
            this.f32144b.getSettings().setUserAgentString(Constants.C);
            try {
                this.f32144b.clearCache(true);
                this.f32144b.clearFormData();
            } catch (Throwable th2) {
                Logger.d(th2, new boolean[0]);
            }
            CookieManager.getInstance().setAcceptCookie(true);
            this.f32144b.setWebViewClient(new cusWebViewClient(string2));
            this.f32144b.addJavascriptInterface(new HtmlViewerJavaScriptInterface(this), "HtmlViewer");
            HashMap hashMap = new HashMap();
            hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US,en;q=0.5");
            this.f32144b.loadUrl(string, hashMap);
        }
        this.f32146d = RxBus.a().c().subscribe(new subsCustom(this), new g0());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = this.f32144b;
        if (webView != null) {
            if (webView.getParent() != null && (this.f32144b.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f32144b.getParent()).removeView(this.f32144b);
            }
            this.f32144b.removeAllViews();
            this.f32144b.destroy();
        }
        Disposable disposable = this.f32146d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f32146d.dispose();
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
        WebView webView = this.f32144b;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f32144b;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
