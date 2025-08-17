package com.applovin.impl.mediation.b.a;

import android.content.Context;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.LinkedList;
import java.util.Queue;

public class b extends MaxNativeAdListener implements MaxAdRevenueListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f14352a;

    /* renamed from: b  reason: collision with root package name */
    private final MaxNativeAdLoader f14353b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<MaxAd> f14354c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f14355d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Object f14356e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a f14357f;

    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public b(String str, int i2, Context context, a aVar) {
        this.f14352a = i2;
        this.f14357f = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(str, context);
        this.f14353b = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
    }

    public void a() {
        this.f14357f = null;
        e();
        this.f14353b.destroy();
    }

    public void a(MaxAd maxAd) {
        this.f14353b.destroy(maxAd);
    }

    public boolean a(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.f14353b.render(maxNativeAdView, maxAd);
    }

    public boolean b() {
        boolean z2;
        synchronized (this.f14356e) {
            z2 = !this.f14354c.isEmpty();
        }
        return z2;
    }

    public void c() {
        synchronized (this.f14356e) {
            if (!this.f14355d && this.f14354c.size() < this.f14352a) {
                this.f14355d = true;
                this.f14353b.loadAd();
            }
        }
    }

    public MaxAd d() {
        MaxAd remove;
        synchronized (this.f14356e) {
            remove = this.f14354c.remove();
            c();
        }
        return remove;
    }

    public void e() {
        synchronized (this.f14356e) {
            for (MaxAd a2 : this.f14354c) {
                a(a2);
            }
            this.f14354c.clear();
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.f14357f;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.f14357f;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.f14357f;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.f14356e) {
            this.f14354c.add(maxAd);
            this.f14355d = false;
            c();
        }
        a aVar = this.f14357f;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }
}
