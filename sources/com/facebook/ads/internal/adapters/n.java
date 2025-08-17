package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.h.d;
import com.facebook.ads.internal.l.a;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class n extends ab {

    /* renamed from: c  reason: collision with root package name */
    private static final String f19930c = "n";

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f19931d = {-1, -6, -7, -8};

    /* renamed from: e  reason: collision with root package name */
    private final String f19932e = UUID.randomUUID().toString();

    /* renamed from: f  reason: collision with root package name */
    private Context f19933f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ac f19934g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f19935h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f19936i;

    /* renamed from: j  reason: collision with root package name */
    private String f19937j;

    /* renamed from: k  reason: collision with root package name */
    private long f19938k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public k f19939l;

    /* renamed from: m  reason: collision with root package name */
    private ad f19940m;

    private void a(Context context, final boolean z2) {
        if (a.f(context)) {
            Log.d(f19930c, "Playable Ads pre-caching is disabled.");
            this.f19935h = true;
            this.f19934g.a(this);
            return;
        }
        WebView webView = new WebView(context);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new WebViewClient() {

            /* renamed from: a  reason: collision with root package name */
            boolean f19941a = false;

            private void a() {
                boolean unused = n.this.f19935h = true;
                n.this.f19934g.a(n.this);
            }

            /* access modifiers changed from: private */
            public void a(WebResourceError webResourceError) {
                if (z2 || !n.this.a(webResourceError)) {
                    n.this.f19934g.a(n.this, AdError.CACHE_ERROR);
                } else {
                    a();
                }
            }

            public void onPageFinished(WebView webView, String str) {
                this.f19941a = true;
                a();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        if (!r02.f19941a) {
                            r02.a((WebResourceError) null);
                        }
                    }
                }, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                this.f19941a = true;
                a(webResourceError);
            }
        });
        webView.loadUrl(this.f19939l.e().j().a());
    }

    /* access modifiers changed from: private */
    public boolean a(WebResourceError webResourceError) {
        if (webResourceError == null || Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (int i2 : f19931d) {
            if (webResourceError.getErrorCode() == i2) {
                return true;
            }
        }
        return false;
    }

    private void b(Context context, final boolean z2) {
        final b bVar = new b(context);
        bVar.a(this.f19939l.e().a());
        bVar.a(this.f19939l.e().g(), this.f19939l.e().i(), this.f19939l.e().h());
        bVar.a(this.f19939l.a().b(), -1, -1);
        for (String a2 : this.f19939l.f().d()) {
            bVar.a(a2, -1, -1);
        }
        bVar.a((com.facebook.ads.internal.d.a) new com.facebook.ads.internal.d.a() {
            private void c() {
                boolean unused = n.this.f19935h = true;
                n.this.f19934g.a(n.this);
                n.this.f19939l.b(bVar.b(n.this.f19939l.e().a()));
            }

            public void a() {
                c();
            }

            public void b() {
                if (z2) {
                    n.this.f19934g.a(n.this, AdError.CACHE_ERROR);
                } else {
                    c();
                }
            }
        });
    }

    private boolean c() {
        return this.f19939l.e().j() != null;
    }

    private void d() {
        LocalBroadcastManager b2 = LocalBroadcastManager.b(this.f19933f);
        ad adVar = this.f19940m;
        b2.c(adVar, adVar.a());
    }

    private void e() {
        if (this.f19940m != null) {
            try {
                LocalBroadcastManager.b(this.f19933f).e(this.f19940m);
            } catch (Exception unused) {
            }
        }
    }

    private String f() {
        String str;
        if (this.f19752a == null) {
            return null;
        }
        String urlPrefix = AdSettings.getUrlPrefix();
        if (urlPrefix == null || urlPrefix.isEmpty()) {
            str = "https://www.facebook.com/audience_network/server_side_reward";
        } else {
            str = String.format("https://www.%s.facebook.com/audience_network/server_side_reward", new Object[]{urlPrefix});
        }
        Uri parse = Uri.parse(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        builder.appendQueryParameter("puid", this.f19752a.getUserID());
        builder.appendQueryParameter("pc", this.f19752a.getCurrency());
        builder.appendQueryParameter("ptid", this.f19932e);
        builder.appendQueryParameter("appid", this.f19936i);
        return builder.build().toString();
    }

    public int a() {
        k kVar = this.f19939l;
        if (kVar == null) {
            return -1;
        }
        return kVar.e().d();
    }

    public void a(Context context, ac acVar, Map<String, Object> map, boolean z2) {
        this.f19933f = context;
        this.f19934g = acVar;
        this.f19935h = false;
        this.f19937j = (String) map.get(AudienceNetworkActivity.PLACEMENT_ID);
        this.f19938k = ((Long) map.get(AudienceNetworkActivity.REQUEST_TIME)).longValue();
        int k2 = ((d) map.get("definition")).k();
        String str = this.f19937j;
        this.f19936i = str != null ? str.split("_")[0] : "";
        k a2 = k.a((JSONObject) map.get("data"));
        this.f19939l = a2;
        a2.a(k2);
        if (!TextUtils.isEmpty(this.f19939l.e().a()) || c()) {
            this.f19940m = new ad(this.f19932e, this, acVar);
            d();
            if (c()) {
                a(context, z2);
            } else {
                b(context, z2);
            }
        } else {
            this.f19934g.a(this, AdError.INTERNAL_ERROR);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r6 = this;
            boolean r0 = r6.f19935h
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = r6.f()
            com.facebook.ads.internal.adapters.a.k r2 = r6.f19939l
            r2.a((java.lang.String) r0)
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r6.f19933f
            java.lang.Class<com.facebook.ads.AudienceNetworkActivity> r4 = com.facebook.ads.AudienceNetworkActivity.class
            r2.<init>(r3, r4)
            java.lang.String r3 = "viewType"
            com.facebook.ads.internal.settings.a$a r4 = com.facebook.ads.internal.settings.a.C0036a.REWARDED_VIDEO
            r2.putExtra(r3, r4)
            java.lang.String r3 = "rewardedVideoAdDataBundle"
            com.facebook.ads.internal.adapters.a.k r4 = r6.f19939l
            r2.putExtra(r3, r4)
            java.lang.String r3 = "uniqueId"
            java.lang.String r4 = r6.f19932e
            r2.putExtra(r3, r4)
            java.lang.String r3 = "rewardServerURL"
            r2.putExtra(r3, r0)
            java.lang.String r0 = "placementId"
            java.lang.String r3 = r6.f19937j
            r2.putExtra(r0, r3)
            java.lang.String r0 = "requestTime"
            long r3 = r6.f19938k
            r2.putExtra(r0, r3)
            int r0 = r6.f19753b
            r3 = -1
            java.lang.String r4 = "predefinedOrientationKey"
            r5 = 1
            if (r0 == r3) goto L_0x0059
            android.content.Context r0 = r6.f19933f
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r3 = "accelerometer_rotation"
            int r0 = android.provider.Settings.System.getInt(r0, r3, r1)
            if (r0 == r5) goto L_0x0059
            int r0 = r6.f19753b
            goto L_0x0062
        L_0x0059:
            android.content.Context r0 = r6.f19933f
            boolean r0 = com.facebook.ads.internal.l.a.o(r0)
            if (r0 != 0) goto L_0x0065
            r0 = 6
        L_0x0062:
            r2.putExtra(r4, r0)
        L_0x0065:
            android.content.Context r0 = r6.f19933f
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 != 0) goto L_0x0075
            int r0 = r2.getFlags()
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 | r1
            r2.setFlags(r0)
        L_0x0075:
            android.content.Context r0 = r6.f19933f
            r0.startActivity(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.n.b():boolean");
    }

    public void onDestroy() {
        e();
    }
}
