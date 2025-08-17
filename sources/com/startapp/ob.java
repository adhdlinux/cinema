package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ob implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public NotDisplayedReason f35563a = NotDisplayedReason.AD_CLOSED_TOO_QUICKLY;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f35564b;

    /* renamed from: c  reason: collision with root package name */
    public a f35565c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35566d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final WeakReference<View> f35567e;

    /* renamed from: f  reason: collision with root package name */
    public final z6 f35568f;

    /* renamed from: g  reason: collision with root package name */
    public final BannerOptions f35569g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35570h = true;

    public interface a {
    }

    public ob(View view, z6 z6Var, BannerOptions bannerOptions) {
        this.f35567e = new WeakReference<>(view);
        this.f35568f = z6Var;
        this.f35569g = bannerOptions;
    }

    public void a() {
        NotDisplayedReason notDisplayedReason;
        try {
            z6 z6Var = this.f35568f;
            if (!(z6Var == null || (notDisplayedReason = this.f35563a) == null)) {
                z6Var.a(notDisplayedReason.toString(), this.f35564b);
            }
            this.f35566d.removeCallbacksAndMessages((Object) null);
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        z6 z6Var = this.f35568f;
        if (z6Var == null || z6Var.f36991k.get() || this.f35567e.get() == null) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0 = (com.startapp.sdk.ads.nativead.NativeAdDetails.e) r0;
        r1 = r0.f36014a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            boolean r0 = r5.b()     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x007b
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x007f }
            r0.<init>()     // Catch:{ all -> 0x007f }
            java.lang.ref.WeakReference<android.view.View> r1 = r5.f35567e     // Catch:{ all -> 0x007f }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x007f }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x007f }
            com.startapp.sdk.ads.banner.BannerOptions r2 = r5.f35569g     // Catch:{ all -> 0x007f }
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r1 = com.startapp.p.a((android.view.View) r1, (com.startapp.sdk.ads.banner.BannerOptions) r2, (java.util.concurrent.atomic.AtomicReference<org.json.JSONObject>) r0)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0033
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r2 = r5.f35563a     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x0029
            int r2 = r2.a()     // Catch:{ all -> 0x007f }
            int r3 = r1.a()     // Catch:{ all -> 0x007f }
            if (r2 > r3) goto L_0x0033
        L_0x0029:
            r5.f35563a = r1     // Catch:{ all -> 0x007f }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x007f }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x007f }
            r5.f35564b = r0     // Catch:{ all -> 0x007f }
        L_0x0033:
            r0 = 0
            r2 = 1
            if (r1 != 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            if (r1 == 0) goto L_0x004e
            boolean r3 = r5.f35570h     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x004e
            r5.f35570h = r0     // Catch:{ all -> 0x007f }
            com.startapp.z6 r0 = r5.f35568f     // Catch:{ all -> 0x007f }
            r0.b()     // Catch:{ all -> 0x007f }
            com.startapp.ob$a r0 = r5.f35565c     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x0073
            com.startapp.sdk.ads.nativead.NativeAdDetails$e r0 = (com.startapp.sdk.ads.nativead.NativeAdDetails.e) r0     // Catch:{ all -> 0x007f }
            goto L_0x0073
        L_0x004e:
            if (r1 != 0) goto L_0x0073
            boolean r0 = r5.f35570h     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0073
            r5.f35570h = r2     // Catch:{ all -> 0x007f }
            com.startapp.z6 r0 = r5.f35568f     // Catch:{ all -> 0x007f }
            r0.a()     // Catch:{ all -> 0x007f }
            com.startapp.ob$a r0 = r5.f35565c     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x0073
            com.startapp.sdk.ads.nativead.NativeAdDetails$e r0 = (com.startapp.sdk.ads.nativead.NativeAdDetails.e) r0     // Catch:{ all -> 0x007f }
            com.startapp.sdk.ads.nativead.NativeAdDetails r1 = com.startapp.sdk.ads.nativead.NativeAdDetails.this     // Catch:{ all -> 0x007f }
            com.startapp.sdk.ads.nativead.NativeAdDisplayListener r3 = r1.f36005j     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x0073
            boolean r4 = r1.f36000e     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x0073
            r3.adHidden(r1)     // Catch:{ all -> 0x007f }
            com.startapp.sdk.ads.nativead.NativeAdDetails r0 = com.startapp.sdk.ads.nativead.NativeAdDetails.this     // Catch:{ all -> 0x007f }
            boolean unused = r0.f36000e = r2     // Catch:{ all -> 0x007f }
        L_0x0073:
            android.os.Handler r0 = r5.f35566d     // Catch:{ all -> 0x007f }
            r1 = 100
            r0.postDelayed(r5, r1)     // Catch:{ all -> 0x007f }
            goto L_0x0086
        L_0x007b:
            r5.a()     // Catch:{ all -> 0x007f }
            goto L_0x0086
        L_0x007f:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.INTERNAL_ERROR
            r5.f35563a = r0
            r5.a()
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.ob.run():void");
    }

    public ob(WeakReference<View> weakReference, z6 z6Var, BannerOptions bannerOptions) {
        this.f35567e = weakReference;
        this.f35568f = z6Var;
        this.f35569g = bannerOptions;
    }
}
