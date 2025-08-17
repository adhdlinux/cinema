package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class l implements k.a, AppLovinWebViewActivity.EventListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f15497a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<AppLovinWebViewActivity> f15498b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m f15499c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final v f15500d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public AppLovinUserService.OnConsentDialogDismissListener f15501e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public k f15502f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Activity> f15503g = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f15504h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f15505i = new AtomicBoolean();

    l(m mVar) {
        this.f15499c = mVar;
        this.f15500d = mVar.A();
        if (mVar.N() != null) {
            this.f15503g = new WeakReference<>(mVar.N());
        }
        m.a(m.M()).a(new a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = l.this.f15503g = new WeakReference(activity);
            }
        });
        this.f15502f = new k(this, mVar);
    }

    private void a(boolean z2, long j2) {
        g();
        if (z2) {
            a(j2);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(m mVar) {
        if (d()) {
            if (v.a()) {
                v.i("AppLovinSdk", "Consent dialog already showing");
            }
            return false;
        } else if (!h.a(mVar.L())) {
            if (v.a()) {
                v.i("AppLovinSdk", "No internet available, skip showing of consent dialog");
            }
            return false;
        } else if (!((Boolean) mVar.a(b.as)).booleanValue()) {
            if (v.a()) {
                this.f15500d.e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            }
            return false;
        } else if (StringUtils.isValidString((String) mVar.a(b.at))) {
            return true;
        } else {
            if (v.a()) {
                this.f15500d.e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            }
            return false;
        }
    }

    private void g() {
        this.f15499c.af().b(this.f15504h);
        if (d()) {
            AppLovinWebViewActivity appLovinWebViewActivity = f15498b.get();
            f15498b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f15501e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f15501e = null;
                }
            }
        }
    }

    public void a() {
        final Activity activity = this.f15503g.get();
        if (activity != null) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    l.this.a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f15499c.a(b.av)).longValue());
        }
    }

    public void a(final long j2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (v.a()) {
                    l.this.f15500d.b("ConsentDialogManager", "Scheduling repeating consent alert");
                }
                l.this.f15502f.a(j2, l.this.f15499c, l.this);
            }
        });
    }

    public void a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                l lVar = l.this;
                if (!lVar.a(lVar.f15499c) || l.f15497a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                        return;
                    }
                    return;
                }
                WeakReference unused = l.this.f15503g = new WeakReference(activity);
                AppLovinUserService.OnConsentDialogDismissListener unused2 = l.this.f15501e = onConsentDialogDismissListener;
                a unused3 = l.this.f15504h = new a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!l.this.d() || l.f15498b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                WeakReference unused = l.f15498b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) l.this.f15499c.a(b.at), l.this);
                            }
                            l.f15497a.set(false);
                        }
                    }
                };
                l.this.f15499c.af().a(l.this.f15504h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, l.this.f15499c.z());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) l.this.f15499c.a(b.au));
                activity.startActivity(intent);
            }
        });
    }

    public void b() {
    }

    public void c() {
        if (!this.f15505i.getAndSet(true)) {
            final String str = (String) this.f15499c.a(b.at);
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    WebView tryToCreateWebView = Utils.tryToCreateWebView(l.this.f15499c.L(), "preloading consent dialog");
                    if (tryToCreateWebView != null) {
                        tryToCreateWebView.loadUrl(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        WeakReference<AppLovinWebViewActivity> weakReference = f15498b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        m mVar;
        b bVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f15499c.L());
            g();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f15499c.L());
            booleanValue = ((Boolean) this.f15499c.a(b.aw)).booleanValue();
            mVar = this.f15499c;
            bVar = b.aB;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f15499c.a(b.ax)).booleanValue();
            mVar = this.f15499c;
            bVar = b.aC;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f15499c.a(b.ay)).booleanValue();
            mVar = this.f15499c;
            bVar = b.aD;
        } else {
            return;
        }
        a(booleanValue, ((Long) mVar.a(bVar)).longValue());
    }
}
