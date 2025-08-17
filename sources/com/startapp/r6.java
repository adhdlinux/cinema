package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.components.ComponentLocator;

public abstract class r6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35753a;

    /* renamed from: b  reason: collision with root package name */
    public final Ad f35754b;

    /* renamed from: c  reason: collision with root package name */
    public final AdPreferences f35755c;

    /* renamed from: d  reason: collision with root package name */
    public AdEventListener f35756d;

    /* renamed from: e  reason: collision with root package name */
    public AdPreferences.Placement f35757e;

    /* renamed from: f  reason: collision with root package name */
    public String f35758f = null;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            r6 r6Var = r6.this;
            try {
                new Handler(Looper.getMainLooper()).post(new s6(r6Var, r6Var.b()));
            } catch (Throwable th) {
                y8.a(r6Var.f35753a, th);
            }
        }
    }

    public r6(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        this.f35753a = context;
        this.f35754b = ad;
        this.f35755c = adPreferences;
        this.f35756d = adEventListener;
        this.f35757e = placement;
    }

    public AdEventListener a() {
        AdEventListener adEventListener = this.f35756d;
        this.f35756d = null;
        return adEventListener;
    }

    public abstract boolean a(Object obj);

    public boolean b() {
        try {
            return a(e());
        } catch (Throwable th) {
            y8.a(this.f35753a, th);
            return false;
        }
    }

    public void c() {
        try {
            ComponentLocator.a(this.f35753a).o().execute(new a());
            return;
        } catch (Throwable th) {
            y8.a(this.f35753a, th);
        }
        y8.a(this.f35753a, th);
    }

    public GetAdRequest d() {
        GetAdRequest a2 = a(new GetAdRequest());
        if (a2 != null) {
            a2.f(this.f35753a);
        }
        return a2;
    }

    public abstract Object e();

    public void a(boolean z2) {
        b(z2);
        if (!z2) {
            this.f35754b.setErrorMessage(this.f35758f);
            p.a(this.f35753a, a(), this.f35754b);
        }
    }

    public void b(boolean z2) {
        this.f35754b.setState(z2 ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r1.equals(r6.second) == false) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[Catch:{ all -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.sdk.adsbase.model.GetAdRequest a(com.startapp.sdk.adsbase.model.GetAdRequest r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f35753a
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            com.startapp.sdk.adsbase.remoteconfig.SimpleTokenConfig r1 = r1.E()
            boolean r1 = r1.a(r0)
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            boolean r2 = r2.M()
            com.startapp.sdk.adsbase.remoteconfig.MetaData r3 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            boolean r3 = r3.U()
            java.lang.Class<com.startapp.sdk.adsbase.SimpleTokenUtils> r4 = com.startapp.sdk.adsbase.SimpleTokenUtils.class
            monitor-enter(r4)
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x0139 }
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r6 = com.startapp.sdk.adsbase.SimpleTokenUtils.TokenType.T1     // Catch:{ all -> 0x0139 }
            java.lang.String r7 = ""
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0139 }
            r7 = 0
            r8 = 1
            if (r1 == 0) goto L_0x007e
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r1 = com.startapp.sdk.adsbase.SimpleTokenUtils.f36208h     // Catch:{ all -> 0x007a }
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r9 = com.startapp.sdk.adsbase.SimpleTokenUtils.TokenType.UNDEFINED     // Catch:{ all -> 0x007a }
            if (r1 != r9) goto L_0x006b
            boolean r1 = com.startapp.sdk.adsbase.SimpleTokenUtils.f36206f     // Catch:{ all -> 0x007a }
            boolean r6 = com.startapp.sdk.adsbase.SimpleTokenUtils.f36207g     // Catch:{ all -> 0x007a }
            if (r6 == 0) goto L_0x003c
            if (r1 == 0) goto L_0x0037
            goto L_0x003c
        L_0x0037:
            android.util.Pair r6 = com.startapp.sdk.adsbase.SimpleTokenUtils.b((android.content.Context) r0)     // Catch:{ all -> 0x007a }
            goto L_0x0040
        L_0x003c:
            android.util.Pair r6 = com.startapp.sdk.adsbase.SimpleTokenUtils.a((android.content.Context) r0)     // Catch:{ all -> 0x007a }
        L_0x0040:
            if (r3 == 0) goto L_0x0043
            goto L_0x004a
        L_0x0043:
            boolean r1 = com.startapp.sdk.adsbase.SimpleTokenUtils.f36207g     // Catch:{ all -> 0x007a }
            if (r1 != 0) goto L_0x0049
            r1 = 1
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            com.startapp.sdk.adsbase.SimpleTokenUtils.f36207g = r1     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x004f
            goto L_0x0069
        L_0x004f:
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)     // Catch:{ all -> 0x007a }
            com.startapp.x6 r1 = r1.d()     // Catch:{ all -> 0x007a }
            java.lang.String r2 = "shared_prefs_simple_token"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x007e
            java.lang.Object r2 = r6.second     // Catch:{ all -> 0x007a }
            boolean r0 = r1.equals(r2)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x007e
        L_0x0069:
            r5 = r6
            goto L_0x007e
        L_0x006b:
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r1 = com.startapp.sdk.adsbase.SimpleTokenUtils.f36208h     // Catch:{ all -> 0x007a }
            if (r1 != r6) goto L_0x0075
            android.util.Pair r0 = com.startapp.sdk.adsbase.SimpleTokenUtils.a((android.content.Context) r0)     // Catch:{ all -> 0x007a }
        L_0x0073:
            r5 = r0
            goto L_0x007e
        L_0x0075:
            android.util.Pair r0 = com.startapp.sdk.adsbase.SimpleTokenUtils.b((android.content.Context) r0)     // Catch:{ all -> 0x007a }
            goto L_0x0073
        L_0x007a:
            r1 = move-exception
            com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0139 }
        L_0x007e:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0139 }
            java.lang.Object r1 = r5.first     // Catch:{ all -> 0x0139 }
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r1 = (com.startapp.sdk.adsbase.SimpleTokenUtils.TokenType) r1     // Catch:{ all -> 0x0139 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0139 }
            java.lang.Object r2 = r5.second     // Catch:{ all -> 0x0139 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0139 }
            monitor-exit(r4)
            r1 = 0
            android.content.Context r2 = r10.f35753a     // Catch:{ all -> 0x0128 }
            com.startapp.sdk.adsbase.model.AdPreferences r3 = r10.f35755c     // Catch:{ all -> 0x0128 }
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r4 = r10.f35757e     // Catch:{ all -> 0x0128 }
            r11.a(r2, r3, r4, r0)     // Catch:{ all -> 0x0128 }
            android.content.Context r2 = r10.f35753a     // Catch:{ all -> 0x0128 }
            com.startapp.sdk.components.ComponentLocator r2 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)     // Catch:{ all -> 0x0128 }
            com.startapp.s8 r2 = r2.f()     // Catch:{ all -> 0x0128 }
            java.lang.Integer r3 = r2.b()     // Catch:{ all -> 0x0128 }
            r11.f36336j0 = r3     // Catch:{ all -> 0x0128 }
            boolean r3 = r2.d()     // Catch:{ all -> 0x0128 }
            if (r3 == 0) goto L_0x00c7
            com.startapp.x6 r3 = r2.f35852b     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = "consentTimestamp"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0128 }
            if (r3 == 0) goto L_0x00c7
            com.startapp.x6 r3 = r2.f35852b     // Catch:{ all -> 0x0128 }
            java.lang.String r4 = "consentTimestamp"
            r5 = 0
            long r3 = r3.getLong(r4, r5)     // Catch:{ all -> 0x0128 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0128 }
            goto L_0x00c8
        L_0x00c7:
            r3 = r1
        L_0x00c8:
            r11.f36337k0 = r3     // Catch:{ all -> 0x0128 }
            java.lang.Boolean r2 = r2.a()     // Catch:{ all -> 0x0128 }
            r11.f36338l0 = r2     // Catch:{ all -> 0x0128 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r2 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x0128 }
            boolean r2 = r2.M()     // Catch:{ all -> 0x0128 }
            if (r2 != 0) goto L_0x00e4
            android.content.Context r2 = r10.f35753a     // Catch:{ all -> 0x0128 }
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r3 = r10.f35757e     // Catch:{ all -> 0x0128 }
            boolean r2 = com.startapp.o6.a((android.content.Context) r2, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r3)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x00e4
            r11.f36345s0 = r8     // Catch:{ all -> 0x0128 }
        L_0x00e4:
            android.content.Context r0 = r10.f35753a     // Catch:{ all -> 0x00ec }
            com.startapp.sdk.adsbase.model.AdPreferences r1 = r10.f35755c     // Catch:{ all -> 0x00ec }
            r11.a(r0, r1)     // Catch:{ all -> 0x00ec }
            goto L_0x00f2
        L_0x00ec:
            r0 = move-exception
            android.content.Context r1 = r10.f35753a
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
        L_0x00f2:
            android.content.Context r0 = r10.f35753a     // Catch:{ all -> 0x0121 }
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)     // Catch:{ all -> 0x0121 }
            com.startapp.je r0 = r0.n()     // Catch:{ all -> 0x0121 }
            double r0 = r0.b()     // Catch:{ all -> 0x0121 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x0127
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0121 }
            java.lang.String r3 = "%d"
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x0121 }
            r5 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r0 = r0 * r5
            long r0 = java.lang.Math.round(r0)     // Catch:{ all -> 0x0121 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0121 }
            r4[r7] = r0     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = java.lang.String.format(r2, r3, r4)     // Catch:{ all -> 0x0121 }
            r11.O0 = r0     // Catch:{ all -> 0x0121 }
            goto L_0x0127
        L_0x0121:
            r0 = move-exception
            android.content.Context r1 = r10.f35753a
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
        L_0x0127:
            return r11
        L_0x0128:
            r11 = move-exception
            android.content.Context r2 = r10.f35753a
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r11)
            java.lang.Object r11 = r0.first
            java.lang.String r11 = (java.lang.String) r11
            com.startapp.sdk.adsbase.SimpleTokenUtils$TokenType r11 = com.startapp.sdk.adsbase.SimpleTokenUtils.TokenType.a(r11)
            com.startapp.sdk.adsbase.SimpleTokenUtils.f36208h = r11
            return r1
        L_0x0139:
            r11 = move-exception
            monitor-exit(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.r6.a(com.startapp.sdk.adsbase.model.GetAdRequest):com.startapp.sdk.adsbase.model.GetAdRequest");
    }
}
