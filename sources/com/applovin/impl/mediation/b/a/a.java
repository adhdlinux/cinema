package com.applovin.impl.mediation.b.a;

import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final l<Integer> f14347a = new l<>();

    /* renamed from: b  reason: collision with root package name */
    private final TreeSet<Integer> f14348b = new TreeSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, MaxAd> f14349c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private int f14350d;

    /* renamed from: e  reason: collision with root package name */
    private int f14351e;

    public a(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    private int a(int i2, boolean z2) {
        int d2 = this.f14347a.d(Integer.valueOf(i2));
        if (!z2) {
            int i3 = i2 + d2;
            while (d2 < this.f14347a.size() && i3 >= this.f14347a.a(d2).intValue()) {
                i3++;
                d2++;
            }
        }
        return d2;
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            v.i("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.f14347a.addAll(maxAdPlacerSettings.getFixedPositions());
        if (maxAdPlacerSettings.isRepeatingEnabled()) {
            int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
            if (this.f14347a.isEmpty()) {
                this.f14347a.add(Integer.valueOf(repeatingInterval - 1));
            }
            int intValue = this.f14347a.a().intValue();
            while (true) {
                intValue += repeatingInterval;
                if (this.f14347a.size() < maxAdPlacerSettings.getMaxAdCount()) {
                    this.f14347a.add(Integer.valueOf(intValue));
                } else {
                    return;
                }
            }
        }
    }

    private void c(int i2, int i3) {
        if (this.f14349c.containsKey(Integer.valueOf(i2))) {
            this.f14349c.put(Integer.valueOf(i3), this.f14349c.get(Integer.valueOf(i2)));
            this.f14348b.add(Integer.valueOf(i3));
            this.f14349c.remove(Integer.valueOf(i2));
            this.f14348b.remove(Integer.valueOf(i2));
        }
    }

    public int a() {
        int i2 = this.f14350d;
        if (!(i2 == -1 || this.f14351e == -1)) {
            while (i2 <= this.f14351e) {
                if (a(i2) && !b(i2)) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public void a(int i2, int i3) {
        this.f14350d = i2;
        this.f14351e = i3;
    }

    public void a(MaxAd maxAd, int i2) {
        this.f14349c.put(Integer.valueOf(i2), maxAd);
        this.f14348b.add(Integer.valueOf(i2));
    }

    public void a(Collection<Integer> collection) {
        for (Integer next : collection) {
            this.f14349c.remove(next);
            this.f14348b.remove(next);
        }
    }

    public boolean a(int i2) {
        return this.f14347a.contains(Integer.valueOf(i2));
    }

    public Collection<Integer> b() {
        return new TreeSet(this.f14348b);
    }

    public void b(int i2, int i3) {
        i(i2);
        h(i3);
    }

    public boolean b(int i2) {
        return this.f14348b.contains(Integer.valueOf(i2));
    }

    public MaxAd c(int i2) {
        return this.f14349c.get(Integer.valueOf(i2));
    }

    public void c() {
        this.f14349c.clear();
        this.f14348b.clear();
    }

    public Collection<Integer> d(int i2) {
        return new TreeSet(this.f14348b.tailSet(Integer.valueOf(i2), false));
    }

    public int e(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return i2 + a(i2 - 1, false);
    }

    public int f(int i2) {
        return i2 + a(i2, false);
    }

    public int g(int i2) {
        if (a(i2)) {
            return -1;
        }
        return i2 - a(i2, true);
    }

    public void h(int i2) {
        int c2 = this.f14347a.c(Integer.valueOf(i2));
        for (int size = this.f14347a.size() - 1; size >= c2; size--) {
            Integer a2 = this.f14347a.a(size);
            int intValue = a2.intValue() + 1;
            c(a2.intValue(), intValue);
            this.f14347a.a(size, Integer.valueOf(intValue));
        }
    }

    public void i(int i2) {
        int c2 = this.f14347a.c(Integer.valueOf(i2));
        if (a(i2)) {
            this.f14349c.remove(Integer.valueOf(i2));
            this.f14348b.remove(Integer.valueOf(i2));
            this.f14347a.b(c2);
        }
        while (c2 < this.f14347a.size()) {
            Integer a2 = this.f14347a.a(c2);
            int intValue = a2.intValue() - 1;
            c(a2.intValue(), intValue);
            this.f14347a.a(c2, Integer.valueOf(intValue));
            c2++;
        }
    }
}
