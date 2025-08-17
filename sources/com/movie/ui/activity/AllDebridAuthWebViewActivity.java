package com.movie.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.movie.AppComponent;
import com.original.tase.Logger;
import com.original.tase.RxBus;
import com.original.tase.event.ApiDebridGetTokenFailedEvent;
import com.original.tase.event.ApiDebridGetTokenSuccessEvent;
import com.original.tase.event.ApiDebridUserCancelledAuthEvent;
import com.original.tase.utils.NetworkUtils;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AllDebridAuthWebViewActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public boolean f31990b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f31991c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f31992d;

    public class subsCustom implements Consumer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final AllDebridAuthWebViewActivity f31993b;

        public subsCustom(AllDebridAuthWebViewActivity allDebridAuthWebViewActivity) {
            this.f31993b = allDebridAuthWebViewActivity;
        }

        public void accept(Object obj) throws Exception {
            boolean z2 = obj instanceof ApiDebridGetTokenSuccessEvent;
            if (z2 || (obj instanceof ApiDebridGetTokenFailedEvent)) {
                if (z2) {
                    this.f31993b.f31990b = true;
                }
                this.f31993b.finish();
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
        if (!this.f31990b) {
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
        Bundle extras = getIntent().getExtras();
        if (extras.getString("verificationUrl", (String) null) == null || extras.getString("verificationUrl", (String) null).isEmpty() || extras.getString("pin", (String) null) == null || extras.getString("pin", (String) null).isEmpty() || !NetworkUtils.a()) {
            if (NetworkUtils.a()) {
                Utils.i0(this, "Error");
            } else {
                Utils.i0(this, "No internet");
            }
            setResult(0);
            finish();
            return;
        }
        String string = extras.getString("verificationUrl");
        String string2 = extras.getString("pin");
        setTitle("All-Debrid Auth");
        TextView textView = (TextView) findViewById(R.id.tvPleaseWait);
        textView.setTextSize(2, 24.0f);
        textView.setText(String.format("1) Visit \"%s\" in a browser of any of your devices\n2) Login to All-Debrid\n3) Input the following code: %s\n\nThis window will be closed automatically after you have granted the All-Debrid API access to CINEMA ", new Object[]{string, string2}));
        B(true);
        this.f31992d = RxBus.a().c().subscribe(new subsCustom(this), new a());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = this.f31991c;
        if (webView != null) {
            if (webView.getParent() != null && (this.f31991c.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f31991c.getParent()).removeView(this.f31991c);
            }
            this.f31991c.removeAllViews();
            this.f31991c.destroy();
        }
        Disposable disposable = this.f31992d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f31992d.dispose();
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
        WebView webView = this.f31991c;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f31991c;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
