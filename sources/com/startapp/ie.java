package com.startapp;

import android.content.Context;
import android.content.Intent;
import com.startapp.ic;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.model.GetAdResponse;
import com.startapp.sdk.components.ComponentLocator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ie extends r6 {

    /* renamed from: g  reason: collision with root package name */
    public int f34706g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Set<String> f34707h = new HashSet();

    public class a implements sa<String, Void> {
        public a() {
        }

        public Object a(Object obj) {
            ie.this.f35758f = (String) obj;
            return null;
        }
    }

    public ie(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, adEventListener, placement);
    }

    public abstract void a(Ad ad);

    public boolean a(Object obj) {
        int i2;
        GetAdResponse getAdResponse = (GetAdResponse) obj;
        boolean z2 = false;
        if (obj == null) {
            this.f35758f = "Empty Response";
            return false;
        } else if (!getAdResponse.b()) {
            this.f35758f = getAdResponse.a();
            return false;
        } else {
            JsonAd jsonAd = (JsonAd) this.f35754b;
            List<AdDetails> a2 = p.a(this.f35753a, getAdResponse.d(), this.f34706g, this.f34707h, true);
            jsonAd.a(a2);
            jsonAd.setAdInfoOverride(getAdResponse.c());
            if (getAdResponse.d() != null && getAdResponse.d().size() > 0) {
                z2 = true;
            }
            if (!z2) {
                this.f35758f = "Empty Response";
            } else if (((ArrayList) a2).size() == 0 && (i2 = this.f34706g) == 0) {
                this.f34706g = i2 + 1;
                return b();
            }
            return z2;
        }
    }

    public Object e() {
        ic.a aVar;
        GetAdRequest d2 = d();
        if (d2 == null) {
            return null;
        }
        if (this.f34707h.size() == 0) {
            this.f34707h.add(this.f35753a.getPackageName());
        }
        int i2 = this.f34706g;
        boolean z2 = false;
        if (i2 > 0) {
            d2.F0 = false;
        }
        d2.B0 = this.f34707h;
        if (i2 == 0) {
            z2 = true;
        }
        d2.F0 = z2;
        w8 j2 = ComponentLocator.a(this.f35753a).j();
        String a2 = AdsConstants.a(AdsConstants.AdApiType.JSON, this.f35757e);
        j2.getClass();
        Class cls = GetAdResponse.class;
        try {
            aVar = j2.a(a2, d2, new a());
        } catch (Throwable th) {
            y8.a(j2.f36819a, th);
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        try {
            return lb.a(aVar.f34700a, cls);
        } catch (Throwable th2) {
            y8.a(j2.f36819a, th2);
            return null;
        }
    }

    public void a(boolean z2) {
        super.a(z2);
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.f35754b.hashCode());
        intent.putExtra("adResult", z2);
        wb.a(this.f35753a).a(intent);
        if (z2) {
            a((Ad) (JsonAd) this.f35754b);
            p.b(this.f35753a, a(), this.f35754b);
        }
    }
}
