package com.applovin.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebView;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.activity.b.e;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Http2Connection;

public class AppLovinFullscreenActivity extends Activity implements k {
    @SuppressLint({"StaticFieldLeak"})
    public static o parentInterstitialWrapper;

    /* renamed from: a  reason: collision with root package name */
    private m f13702a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f13703b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f13704c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    private com.applovin.impl.adview.activity.a f13705d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13706e;

    private void a() {
        WindowInsetsController a2;
        if (!this.f13706e || !g.j() || (a2 = getWindow().getInsetsController()) == null) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
            return;
        }
        a2.setSystemBarsBehavior(2);
        a2.hide(WindowInsets.Type.systemBars());
    }

    public void dismiss() {
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.h();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.l();
        }
        if (Utils.isAppLovinTestEnvironment(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            if (bundle.getBoolean("com.applovin.dismiss_on_restore", false)) {
                if (v.a()) {
                    v.h("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
                }
                dismiss();
                return;
            } else if (v.a()) {
                v.f("AppLovinFullscreenActivity", "Activity was destroyed while in background.");
            }
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
        getWindow().addFlags(128);
        View findViewById = findViewById(16908290);
        findViewById.setBackgroundColor(-16777216);
        m mVar = AppLovinSdk.getInstance(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"), new AppLovinSdkSettings(this), this).coreSdk;
        this.f13702a = mVar;
        this.f13706e = ((Boolean) mVar.a(b.cF)).booleanValue();
        if (((Boolean) this.f13702a.a(b.cG)).booleanValue()) {
            findViewById.setFitsSystemWindows(true);
        }
        a();
        o oVar = parentInterstitialWrapper;
        if (oVar != null) {
            a.a(oVar.a(), parentInterstitialWrapper.d(), parentInterstitialWrapper.c(), parentInterstitialWrapper.b(), this.f13702a, this, new a.C0008a() {
                public void a(a aVar) {
                    a unused = AppLovinFullscreenActivity.this.f13703b = aVar;
                    aVar.d();
                }

                public void a(String str, Throwable th) {
                    o.a(AppLovinFullscreenActivity.parentInterstitialWrapper.a(), AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
                }
            });
            return;
        }
        Intent intent = new Intent(this, FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f13702a);
        this.f13705d = aVar;
        bindService(intent, aVar, 1);
        if (g.h()) {
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        parentInterstitialWrapper = null;
        com.applovin.impl.adview.activity.a aVar = this.f13705d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        a aVar2 = this.f13703b;
        if (aVar2 != null) {
            if (!aVar2.i()) {
                this.f13703b.h();
            }
            this.f13703b.k();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.a(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        a aVar;
        try {
            super.onResume();
            if (!this.f13704c.get() && (aVar = this.f13703b) != null) {
                aVar.f();
            }
        } catch (IllegalArgumentException e2) {
            if (v.a()) {
                this.f13702a.A().b("AppLovinFullscreenActivity", "Error was encountered in onResume().", e2);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m mVar = this.f13702a;
        if (mVar != null) {
            bundle.putBoolean("com.applovin.dismiss_on_restore", ((Boolean) mVar.a(b.eN)).booleanValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a aVar = this.f13703b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        if (this.f13703b != null) {
            if (!this.f13704c.getAndSet(false) || (this.f13703b instanceof e)) {
                this.f13703b.c(z2);
            }
            if (z2) {
                a();
            }
        }
        super.onWindowFocusChanged(z2);
    }

    public void setPresenter(a aVar) {
        this.f13703b = aVar;
    }
}
