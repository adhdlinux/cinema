package com.startapp.sdk.ads.interstitials;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.startapp.ha;
import com.startapp.hc;
import com.startapp.lb;
import com.startapp.o6;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.v3;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.vungle.ads.internal.Constants;
import java.io.Serializable;
import java.util.Map;

public class OverlayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public v3 f35950a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35951b;

    /* renamed from: c  reason: collision with root package name */
    public int f35952c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35953d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f35954e;

    /* renamed from: f  reason: collision with root package name */
    public int f35955f = -1;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r8 = this;
            android.content.Intent r0 = r8.getIntent()
            java.lang.String r1 = "placement"
            r2 = 0
            int r0 = r0.getIntExtra(r1, r2)
            android.content.Intent r1 = r8.getIntent()
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r0 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.a(r0)
            int r3 = r0.ordinal()
            if (r3 == 0) goto L_0x0063
            r4 = 2
            if (r3 == r4) goto L_0x005b
            r4 = 3
            if (r3 == r4) goto L_0x0053
            r4 = 4
            if (r3 == r4) goto L_0x002f
            r4 = 7
            if (r3 == r4) goto L_0x002f
            r4 = 8
            if (r3 == r4) goto L_0x0063
            com.startapp.w3 r3 = new com.startapp.w3
            r3.<init>()
            goto L_0x0078
        L_0x002f:
            java.util.Map<android.app.Activity, java.lang.Integer> r3 = com.startapp.lb.f34876a
            java.lang.String r3 = "videoAd"
            boolean r3 = r1.getBooleanExtra(r3, r2)
            if (r3 == 0) goto L_0x003f
            com.startapp.sdk.ads.video.VideoMode r3 = new com.startapp.sdk.ads.video.VideoMode
            r3.<init>()
            goto L_0x0078
        L_0x003f:
            java.lang.String r3 = "mraidAd"
            boolean r3 = r1.getBooleanExtra(r3, r2)
            if (r3 == 0) goto L_0x004d
            com.startapp.x3 r3 = new com.startapp.x3
            r3.<init>()
            goto L_0x0078
        L_0x004d:
            com.startapp.a4 r3 = new com.startapp.a4
            r3.<init>()
            goto L_0x0078
        L_0x0053:
            java.util.Map<android.app.Activity, java.lang.Integer> r3 = com.startapp.lb.f34876a
            com.startapp.y4 r3 = new com.startapp.y4
            r3.<init>()
            goto L_0x0078
        L_0x005b:
            java.util.Map<android.app.Activity, java.lang.Integer> r3 = com.startapp.lb.f34876a
            com.startapp.z3 r3 = new com.startapp.z3
            r3.<init>()
            goto L_0x0078
        L_0x0063:
            java.util.Map<android.app.Activity, java.lang.Integer> r3 = com.startapp.lb.f34876a
            android.net.Uri r3 = r1.getData()
            if (r3 != 0) goto L_0x006e
            r0 = 0
            goto L_0x014a
        L_0x006e:
            java.lang.String r3 = r3.toString()
            com.startapp.ud r4 = new com.startapp.ud
            r4.<init>(r3)
            r3 = r4
        L_0x0078:
            r3.f36703a = r1
            r3.f36704b = r8
            java.lang.String r4 = "position"
            java.lang.String r4 = r1.getStringExtra(r4)
            r3.f36710h = r4
            java.lang.String r4 = "tracking"
            java.lang.String[] r4 = r1.getStringArrayExtra(r4)
            r3.f36711i = r4
            java.lang.String r4 = "trackingClickUrl"
            java.lang.String[] r4 = r1.getStringArrayExtra(r4)
            r3.f36712j = r4
            java.lang.String r4 = "packageNames"
            java.lang.String[] r4 = r1.getStringArrayExtra(r4)
            r3.f36713k = r4
            java.lang.String r4 = "closingUrl"
            java.lang.String[] r5 = r1.getStringArrayExtra(r4)
            r3.f36707e = r5
            java.lang.String r5 = "smartRedirect"
            boolean[] r5 = r1.getBooleanArrayExtra(r5)
            r3.f36708f = r5
            java.lang.String r5 = "browserEnabled"
            boolean[] r5 = r1.getBooleanArrayExtra(r5)
            r3.f36709g = r5
            java.lang.String r5 = "adTag"
            java.lang.String r5 = r1.getStringExtra(r5)
            r3.f36718p = r5
            java.lang.String r5 = "htmlUuid"
            java.lang.String r5 = r1.getStringExtra(r5)
            if (r5 == 0) goto L_0x00e7
            java.lang.Boolean r6 = com.startapp.sdk.adsbase.AdsConstants.f36193g
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00da
            com.startapp.d8 r6 = com.startapp.d8.f34354a
            java.util.Map<java.lang.String, java.lang.String> r6 = r6.f34356c
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r3.a((java.lang.String) r5)
            goto L_0x00e7
        L_0x00da:
            com.startapp.d8 r6 = com.startapp.d8.f34354a
            java.util.Map<java.lang.String, java.lang.String> r6 = r6.f34356c
            java.lang.Object r5 = r6.remove(r5)
            java.lang.String r5 = (java.lang.String) r5
            r3.a((java.lang.String) r5)
        L_0x00e7:
            java.lang.String r5 = "isSplash"
            r1.getBooleanExtra(r5, r2)
            java.lang.String r5 = "adInfoOverride"
            java.io.Serializable r5 = r1.getSerializableExtra(r5)
            com.startapp.sdk.adsbase.adinformation.AdInformationOverrides r5 = (com.startapp.sdk.adsbase.adinformation.AdInformationOverrides) r5
            r3.f36717o = r5
            r3.f36716n = r0
            java.lang.String[] r0 = r1.getStringArrayExtra(r4)
            r3.f36707e = r0
            java.lang.String r0 = "rewardDuration"
            int r0 = r1.getIntExtra(r0, r2)
            r3.f36721s = r0
            java.lang.String r0 = "rewardedHideTimer"
            boolean r0 = r1.getBooleanExtra(r0, r2)
            r3.f36722t = r0
            boolean[] r0 = r3.f36708f
            r4 = 1
            if (r0 != 0) goto L_0x0119
            boolean[] r0 = new boolean[r4]
            r0[r2] = r4
            r3.f36708f = r0
        L_0x0119:
            boolean[] r0 = r3.f36709g
            if (r0 != 0) goto L_0x0123
            boolean[] r0 = new boolean[r4]
            r0[r2] = r4
            r3.f36709g = r0
        L_0x0123:
            java.lang.String r0 = "ad"
            java.io.Serializable r0 = r1.getSerializableExtra(r0)
            com.startapp.sdk.adsbase.Ad r0 = (com.startapp.sdk.adsbase.Ad) r0
            r3.f36714l = r0
            java.lang.String r0 = "delayImpressionSeconds"
            r4 = -1
            long r6 = r1.getLongExtra(r0, r4)
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x013f
            java.lang.Long r0 = java.lang.Long.valueOf(r6)
            r3.f36719q = r0
        L_0x013f:
            java.lang.String r0 = "sendRedirectHops"
            java.io.Serializable r0 = r1.getSerializableExtra(r0)
            java.lang.Boolean[] r0 = (java.lang.Boolean[]) r0
            r3.f36720r = r0
            r0 = r3
        L_0x014a:
            r8.f35950a = r0
            if (r0 != 0) goto L_0x0151
            r8.finish()
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.interstitials.OverlayActivity.a():void");
    }

    public final boolean b() {
        return this.f35951b && Build.VERSION.SDK_INT != 26;
    }

    public void finish() {
        v3 v3Var = this.f35950a;
        if (v3Var != null) {
            v3Var.h();
        }
        super.finish();
    }

    public void onBackPressed() {
        v3 v3Var = this.f35950a;
        if (v3Var == null || !v3Var.c()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (b()) {
            a();
            v3 v3Var = this.f35950a;
            if (v3Var != null) {
                v3Var.a(this.f35954e);
                this.f35950a.f();
            }
            this.f35951b = false;
        }
        v3 v3Var2 = this.f35950a;
        if (v3Var2 != null) {
            v3Var2.a(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z2 = false;
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("placement", -1);
        Serializable serializableExtra = getIntent().getSerializableExtra("ad");
        if (intExtra >= 0 && (serializableExtra instanceof Ad)) {
            ha r2 = ComponentLocator.a(getApplicationContext()).r();
            AdPreferences.Placement a2 = AdPreferences.Placement.a(intExtra);
            String adId = ((Ad) serializableExtra).getAdId();
            r2.getClass();
            if (adId != null) {
                r2.f34636a.put(new ha.a(a2, -1), adId);
            }
        }
        boolean booleanExtra = getIntent().getBooleanExtra("videoAd", false);
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra(Constants.TEMPLATE_TYPE_FULLSCREEN, false) || booleanExtra) {
            getWindow().setFlags(1024, 1024);
        }
        this.f35953d = getIntent().getBooleanExtra("activityShouldLockOrientation", true);
        if (bundle != null) {
            this.f35955f = bundle.getInt("activityLockedOrientation", -1);
            this.f35953d = bundle.getBoolean("activityShouldLockOrientation", true);
        }
        this.f35952c = getIntent().getIntExtra(AdUnitActivity.EXTRA_ORIENTATION, getResources().getConfiguration().orientation);
        if (getResources().getConfiguration().orientation != this.f35952c) {
            z2 = true;
        }
        this.f35951b = z2;
        if (b()) {
            this.f35954e = bundle;
            return;
        }
        a();
        v3 v3Var = this.f35950a;
        if (v3Var != null) {
            v3Var.a(bundle);
        }
    }

    public void onDestroy() {
        if (!b()) {
            v3 v3Var = this.f35950a;
            if (v3Var != null) {
                v3Var.d();
                this.f35950a = null;
            }
            Map<Activity, Integer> map = lb.f34876a;
            lb.a((Activity) this, getResources().getConfiguration().orientation, false);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        v3 v3Var = this.f35950a;
        if (v3Var == null || v3Var.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        if (!b()) {
            v3 v3Var = this.f35950a;
            if (v3Var != null) {
                v3Var.e();
            }
            o6.b((Context) this);
        }
        overridePendingTransition(0, 0);
    }

    public void onResume() {
        v3 v3Var;
        super.onResume();
        int i2 = this.f35955f;
        if (i2 == -1) {
            this.f35955f = lb.a((Activity) this, this.f35952c, this.f35953d);
        } else {
            int i3 = hc.f34643a;
            try {
                setRequestedOrientation(i2);
            } catch (Throwable unused) {
            }
        }
        if (!b() && (v3Var = this.f35950a) != null) {
            v3Var.f();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!b()) {
            v3 v3Var = this.f35950a;
            if (v3Var != null) {
                v3Var.b(bundle);
            }
            bundle.putInt("activityLockedOrientation", this.f35955f);
            bundle.putBoolean("activityShouldLockOrientation", this.f35953d);
        }
    }

    public void onStop() {
        v3 v3Var;
        super.onStop();
        if (!b() && (v3Var = this.f35950a) != null) {
            v3Var.g();
        }
    }
}
