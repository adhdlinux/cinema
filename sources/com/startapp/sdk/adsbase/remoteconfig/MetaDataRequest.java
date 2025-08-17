package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.startapp.eb;
import com.startapp.fc;
import com.startapp.hc;
import com.startapp.lb;
import com.startapp.q6;
import com.startapp.s8;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import com.startapp.y8;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.Map;

public class MetaDataRequest extends q6 {

    /* renamed from: h0  reason: collision with root package name */
    public final x6 f36386h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f36387i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f36388j0 = b();

    /* renamed from: k0  reason: collision with root package name */
    public boolean f36389k0;

    /* renamed from: l0  reason: collision with root package name */
    public float f36390l0;

    /* renamed from: m0  reason: collision with root package name */
    public RequestReason f36391m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f36392n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f36393o0;

    /* renamed from: p0  reason: collision with root package name */
    public Integer f36394p0;

    /* renamed from: q0  reason: collision with root package name */
    public Pair<String, String> f36395q0;

    /* renamed from: r0  reason: collision with root package name */
    public Integer f36396r0;

    /* renamed from: s0  reason: collision with root package name */
    public Boolean f36397s0;

    /* renamed from: t0  reason: collision with root package name */
    public long f36398t0;

    public enum RequestReason {
        LAUNCH(1),
        APP_IDLE(2),
        IN_APP_PURCHASE(3),
        CUSTOM(4),
        PERIODIC(5),
        PAS(6),
        CONSENT(7),
        IMPLICIT_LAUNCH(8),
        EXTRAS(9);
        
        private int index;

        /* access modifiers changed from: public */
        RequestReason(int i2) {
            this.index = i2;
        }
    }

    public MetaDataRequest(Context context, x6 x6Var, RequestReason requestReason) {
        super(2);
        this.f36386h0 = x6Var;
        this.f36387i0 = x6Var.getInt("totalSessions", 0);
        this.f36390l0 = x6Var.getFloat("inAppPurchaseAmount", 0.0f);
        this.f36389k0 = x6Var.getBoolean("payingUser", false);
        this.f36392n0 = MetaData.r().z();
        this.f36391m0 = requestReason;
        this.f36393o0 = a(context, x6Var, StartAppSDKInternal.a().b());
        f(context);
        this.f36395q0 = SimpleTokenUtils.a();
        this.f36398t0 = SimpleTokenUtils.b();
        s8 f2 = ComponentLocator.a(context).f();
        this.f36396r0 = f2.b();
        this.f36397s0 = f2.a();
        a(ComponentLocator.a(context).b().a());
    }

    public void a(eb ebVar) throws SDKException {
        super.a(ebVar);
        ebVar.a(fc.f34530b, (Object) fc.a(), true, true);
        ebVar.a("totalSessions", (Object) Integer.valueOf(this.f36387i0), true, true);
        ebVar.a("daysSinceFirstSession", (Object) Integer.valueOf(this.f36388j0), true, true);
        ebVar.a("payingUser", (Object) Boolean.valueOf(this.f36389k0), true, true);
        ebVar.a("profileId", (Object) this.f36392n0, false, true);
        ebVar.a("paidAmount", (Object) Float.valueOf(this.f36390l0), true, true);
        ebVar.a("reason", (Object) this.f36391m0, true, true);
        ebVar.a("ct", (Object) this.f36396r0, false, true);
        ebVar.a("apc", (Object) this.f36397s0, false, true);
        String str = StartAppSDKInternal.f36218a;
        ebVar.a("testAdsEnabled", (Object) StartAppSDKInternal.c.f36252a.F ? Boolean.TRUE : null, false, true);
        ebVar.a("apkHash", (Object) this.f36393o0, false, true);
        ebVar.a("ian", (Object) this.f36394p0, false, true);
        Pair<String, String> pair = this.f36395q0;
        ebVar.a((String) pair.first, pair.second, false, true);
        long j2 = this.f36398t0;
        if (j2 != 0) {
            ebVar.a("firstInstalledAppTS", (Object) Long.valueOf(j2), false, true);
        }
    }

    public final int b() {
        return (int) ((System.currentTimeMillis() - this.f36386h0.getLong("firstSessionTime", System.currentTimeMillis())) / SignalManager.TWENTY_FOUR_HOURS_MILLIS);
    }

    public void f(Context context) {
        SimpleTokenConfig E = MetaData.f36379h.E();
        if (E != null && E.a(context)) {
            int i2 = hc.f34643a;
            int i3 = 0;
            try {
                for (PackageInfo next : hc.a(context.getPackageManager())) {
                    if (!hc.a(next) || next.packageName.equals(Constants.f36416a)) {
                        i3++;
                    }
                }
            } catch (Throwable unused) {
            }
            if (i3 > 0) {
                this.f36394p0 = Integer.valueOf(i3);
            }
        }
    }

    public static String a(Context context, x6 x6Var, boolean z2) {
        String str = null;
        String string = x6Var.getString("shared_prefs_app_apk_hash", (String) null);
        if (!TextUtils.isEmpty(string) && !z2) {
            return string;
        }
        Map<Activity, Integer> map = lb.f34876a;
        try {
            str = hc.a("SHA-256", context);
        } catch (Throwable th) {
            y8.a(context, th);
        }
        x6.a a2 = x6Var.edit();
        a2.a("shared_prefs_app_apk_hash", str);
        a2.f36915a.putString("shared_prefs_app_apk_hash", str);
        a2.apply();
        return str;
    }
}
