package com.startapp;

import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class m5 {

    /* renamed from: a  reason: collision with root package name */
    public static m5 f34899a = new m5();

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<CachedVideoAd> f34900b = new LinkedList<>();

    public boolean a(int i2) {
        ArrayList arrayList;
        boolean z2;
        Iterator<CachedVideoAd> it2 = this.f34900b.iterator();
        boolean z3 = false;
        while (it2.hasNext() && this.f34900b.size() > i2) {
            CachedVideoAd next = it2.next();
            String a2 = next.a();
            d8 d8Var = d8.f34354a;
            synchronized (d8Var) {
                arrayList = new ArrayList(d8Var.f34355b.values());
            }
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z2 = false;
                    break;
                }
                v6 v6Var = ((j8) it3.next()).f34747e;
                if (v6Var instanceof VideoEnabledAd) {
                    VideoEnabledAd videoEnabledAd = (VideoEnabledAd) v6Var;
                    if (!(videoEnabledAd.w() == null || videoEnabledAd.w().c() == null || !videoEnabledAd.w().c().equals(a2))) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                it2.remove();
                if (next.a() != null) {
                    new File(next.a()).delete();
                }
                z3 = true;
            }
        }
        return z3;
    }
}
