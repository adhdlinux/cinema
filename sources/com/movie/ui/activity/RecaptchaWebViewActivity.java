package com.movie.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewDatabase;
import com.google.android.gms.common.internal.ImagesContract;
import com.movie.AppComponent;
import com.movie.data.model.ItemHelpCaptcha;
import com.original.Constants;
import com.original.tase.I18N;
import com.original.tase.Logger;
import com.original.tase.RxBus;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.utils.NetworkUtils;
import com.original.tase.utils.Regex;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import okhttp3.HttpUrl;

public class RecaptchaWebViewActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Disposable f32158b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f32159c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ItemHelpCaptcha f32160d;

    /* renamed from: e  reason: collision with root package name */
    public RecaptchaWebViewActivity f32161e = null;

    class C50931 implements Consumer<String> {

        /* renamed from: b  reason: collision with root package name */
        final RecaptchaWebViewActivity f32167b;

        C50931(RecaptchaWebViewActivity recaptchaWebViewActivity) {
            this.f32167b = recaptchaWebViewActivity;
        }

        /* renamed from: a */
        public void accept(String str) throws Exception {
            if (!this.f32167b.isFinishing()) {
                this.f32167b.setResult(-1);
                this.f32167b.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void H(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void I(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public void J() {
        Disposable disposable = this.f32158b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f32158b.dispose();
        }
        this.f32158b = null;
    }

    @SuppressLint({"WrongConstant"})
    public void F(String str) {
        this.f32161e.findViewById(R.id.webView).setVisibility(8);
        this.f32161e.findViewById(R.id.tvPleaseWait).setVisibility(0);
        this.f32161e.findViewById(R.id.pbPleaseWait).setVisibility(0);
        this.f32161e.J();
        for (String str2 : CookieManager.getInstance().getCookie(str).split(";")) {
            if (str2.contains("cf_clearance")) {
                HttpHelper.i().D(str, str2);
            }
        }
        this.f32161e.f32158b = Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("finish");
                RxBus.a().b(RecaptchaWebViewActivity.this.f32160d);
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new C50931(this.f32161e), new i0());
    }

    @SuppressLint({"WrongConstant"})
    public void G(final String str) {
        this.f32161e.findViewById(R.id.webView).setVisibility(8);
        this.f32161e.findViewById(R.id.tvPleaseWait).setVisibility(0);
        this.f32161e.findViewById(R.id.pbPleaseWait).setVisibility(0);
        this.f32161e.J();
        this.f32161e.f32158b = Observable.create(new ObservableOnSubscribe<String>() {
            private String a(String str) {
                try {
                    HttpUrl parse = HttpUrl.parse(str);
                    return parse.scheme() + "://" + parse.host();
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                    return "";
                }
            }

            public void b(ObservableEmitter<? super String> observableEmitter) {
                HashMap hashMap = new HashMap();
                String replace = a(RecaptchaWebViewActivity.this.f32160d.getLink()).replace("https://", "").replace("http://", "");
                hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
                hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.9,en;q=0.8");
                hashMap.put("Host", replace.replace("https://", "").replace("http://", "").replace("/", ""));
                hashMap.put("Upgrade-Insecure-Requests", "1");
                hashMap.put("User-Agent", Constants.C);
                HttpHelper.i().p(str, Constants.C, RecaptchaWebViewActivity.this.f32160d.getLink(), hashMap);
                observableEmitter.onNext("finish");
                RxBus.a().b(RecaptchaWebViewActivity.this.f32160d);
            }

            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                b(observableEmitter);
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new C50931(this.f32161e), new h0());
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled", "RestrictedApi", "WrongConstant"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        this.f32161e = this;
        this.needToCancelHttpHelper = false;
        Bundle extras = getIntent().getExtras();
        if (extras.getString(ImagesContract.URL) == null || extras.getString(ImagesContract.URL).isEmpty() || !NetworkUtils.a()) {
            setResult(0);
            finish();
            return;
        }
        setTitle(I18N.a(R.string.verify));
        String string = extras.getString(ImagesContract.URL);
        String string2 = extras.getString("providername");
        if (string == null) {
            setResult(0);
            finish();
            return;
        }
        this.f32160d = new ItemHelpCaptcha(string2, string);
        try {
            WebViewDatabase.getInstance(this).clearFormData();
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        WebView webView = (WebView) findViewById(R.id.webView);
        this.f32159c = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f32159c.getSettings().setAllowFileAccess(false);
        this.f32159c.getSettings().setSaveFormData(false);
        this.f32159c.getSettings().setSavePassword(false);
        this.f32159c.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.f32159c.getSettings().setCacheMode(2);
        this.f32159c.getSettings().setUserAgentString(Constants.C);
        try {
            this.f32159c.clearCache(true);
            this.f32159c.clearFormData();
        } catch (Throwable th2) {
            Logger.d(th2, new boolean[0]);
        }
        CookieManager.getInstance().setAcceptCookie(true);
        this.f32159c.setWebViewClient(new WebViewClient() {
            /* access modifiers changed from: private */
            public static /* synthetic */ void b(Throwable th) throws Exception {
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                String title = webView.getTitle();
                if (title == null || title.isEmpty() || title.toLowerCase().contains("attention required") || title.equalsIgnoreCase("Watch Free MOvies Tv Shows Online 1080p HD Stream Free without registration at Mehlizmovieshd.com")) {
                    RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.webView).setVisibility(0);
                    RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.tvPleaseWait).setVisibility(8);
                    RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.pbPleaseWait).setVisibility(8);
                } else if (RecaptchaWebViewActivity.this.f32161e.isFinishing()) {
                } else {
                    if (str.contains("__cf_chl_captcha_tk__")) {
                        RecaptchaWebViewActivity.this.F(str);
                        return;
                    }
                    RecaptchaWebViewActivity.this.f32161e.setResult(-1);
                    RecaptchaWebViewActivity.this.f32161e.finish();
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (str.contains("__cf_chl_captcha_tk__")) {
                    RecaptchaWebViewActivity.this.F(str);
                } else if (str.contains("/cdn-cgi/l/chk_captcha")) {
                    RecaptchaWebViewActivity.this.G(str);
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                String cookie = CookieManager.getInstance().getCookie(RecaptchaWebViewActivity.this.f32160d.getLink());
                if (cookie == null || cookie.isEmpty()) {
                    return true;
                }
                for (String str : cookie.split(";")) {
                    if (str.contains("cf_clearance")) {
                        RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.webView).setVisibility(8);
                        RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.tvPleaseWait).setVisibility(0);
                        RecaptchaWebViewActivity.this.f32161e.findViewById(R.id.pbPleaseWait).setVisibility(0);
                        RecaptchaWebViewActivity.this.f32161e.J();
                        HttpHelper.i().D(RecaptchaWebViewActivity.this.f32160d.getLink(), str);
                        RecaptchaWebViewActivity recaptchaWebViewActivity = RecaptchaWebViewActivity.this.f32161e;
                        Observable observeOn = Observable.create(new ObservableOnSubscribe<String>() {
                            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                                observableEmitter.onNext("finish");
                                RxBus.a().b(RecaptchaWebViewActivity.this.f32160d);
                            }
                        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a());
                        RecaptchaWebViewActivity recaptchaWebViewActivity2 = RecaptchaWebViewActivity.this;
                        Disposable unused = recaptchaWebViewActivity.f32158b = observeOn.subscribe(new C50931(recaptchaWebViewActivity2.f32161e), new j0());
                    }
                }
                return true;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String a2 = Regex.a(str, "(?:\\/\\/www\\.|\\/\\/)(\\w+\\.\\w+)", 1);
                if (RecaptchaWebViewActivity.this.f32160d.getLink().equals(str) || (!a2.isEmpty() && str.contains(a2))) {
                    RecaptchaWebViewActivity.this.F(str);
                    return true;
                }
                if (str.contains("/cdn-cgi/l/chk_captcha")) {
                    RecaptchaWebViewActivity.this.G(str);
                } else {
                    webView.loadUrl(str);
                }
                return true;
            }
        });
        this.f32159c.loadUrl(string);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        J();
        WebView webView = this.f32159c;
        if (webView != null) {
            if (webView.getParent() != null && (this.f32159c.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f32159c.getParent()).removeView(this.f32159c);
            }
            this.f32159c.removeAllViews();
            this.f32159c.destroy();
        }
        CookieManager.getInstance().removeAllCookie();
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
        this.f32159c.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f32159c.onResume();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
