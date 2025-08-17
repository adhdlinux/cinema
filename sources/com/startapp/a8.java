package com.startapp;

import android.app.Activity;
import android.content.Context;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x6;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a8 implements da {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34191a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x6 f34192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d8 f34193c;

    public a8(d8 d8Var, Context context, x6 x6Var) {
        this.f34193c = d8Var;
        this.f34191a = context;
        this.f34192b = x6Var;
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
        Set<StartAppAd.AdMode> b2;
        if (z2 && (b2 = CacheMetaData.f36308a.a().b()) != null) {
            d8 d8Var = this.f34193c;
            x6 d2 = ComponentLocator.a(d8Var.f34361h).d();
            Iterator<StartAppAd.AdMode> it2 = b2.iterator();
            while (true) {
                boolean z3 = true;
                if (!it2.hasNext()) {
                    break;
                }
                if (d2.getInt(d8Var.a(it2.next()), 0) < MetaData.f36379h.H()) {
                    z3 = false;
                }
                if (z3) {
                    it2.remove();
                }
            }
            Map<Activity, Integer> map = lb.f34876a;
            for (StartAppAd.AdMode next : b2) {
                int i2 = AdsCommonMetaData.f36186h.i();
                StartAppAd.AdMode adMode = StartAppAd.AdMode.FULLPAGE;
                if (next != adMode) {
                    StartAppAd.AdMode adMode2 = StartAppAd.AdMode.OFFERWALL;
                    if (next != adMode2) {
                        this.f34193c.a(this.f34191a, (StartAppAd) null, next, new AdPreferences(), (AdEventListener) null);
                    } else if (i2 < 100) {
                        this.f34193c.a(this.f34191a, (StartAppAd) null, adMode2, new AdPreferences(), (AdEventListener) null);
                    }
                } else if (i2 > 0) {
                    this.f34193c.a(this.f34191a, (StartAppAd) null, adMode, new AdPreferences(), (AdEventListener) null);
                }
                String a2 = this.f34193c.a(next);
                if (a2 != null) {
                    int i3 = this.f34192b.getInt(a2, 0);
                    x6.a a3 = this.f34192b.edit();
                    int i4 = i3 + 1;
                    a3.a(a2, Integer.valueOf(i4));
                    a3.f36915a.putInt(a2, i4);
                    a3.apply();
                }
            }
        }
    }
}
