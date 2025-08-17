package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.b.a.a;
import com.applovin.impl.mediation.b.a.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;

public class MaxAdPlacer implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private AppLovinSdkUtils.Size f16015a;

    /* renamed from: b  reason: collision with root package name */
    private MaxNativeAdViewBinder f16016b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f16017c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f16018d;

    /* renamed from: e  reason: collision with root package name */
    private Listener f16019e;
    protected final v logger;
    protected final m sdk;

    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i2);

        void onAdRemoved(int i2);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.f16015a = AppLovinSdkUtils.Size.ZERO;
        m mVar = appLovinSdk.coreSdk;
        this.sdk = mVar;
        v A = mVar.A();
        this.logger = A;
        this.f16017c = new a(maxAdPlacerSettings);
        this.f16018d = new b(maxAdPlacerSettings.getAdUnitId(), maxAdPlacerSettings.getMaxPreloadedAdCount(), context, this);
        A.b("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
    }

    private void a() {
        int a2;
        while (this.f16018d.b() && (a2 = this.f16017c.a()) != -1) {
            v vVar = this.logger;
            vVar.b("MaxAdPlacer", "Placing ad at position: " + a2);
            this.f16017c.a(this.f16018d.d(), a2);
            Listener listener = this.f16019e;
            if (listener != null) {
                listener.onAdLoaded(a2);
            }
        }
    }

    private void a(Collection<Integer> collection, Runnable runnable) {
        for (Integer intValue : collection) {
            this.f16018d.a(this.f16017c.c(intValue.intValue()));
        }
        runnable.run();
        if (!collection.isEmpty()) {
            v vVar = this.logger;
            vVar.b("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
            if (this.f16019e != null) {
                for (Integer intValue2 : collection) {
                    this.f16019e.onAdRemoved(intValue2.intValue());
                }
            }
        }
    }

    public void clearAds() {
        a(this.f16017c.b(), new Runnable() {
            public void run() {
                MaxAdPlacer.this.logger.b("MaxAdPlacer", "Clearing all cached ads");
                MaxAdPlacer.this.f16017c.c();
                MaxAdPlacer.this.f16018d.e();
            }
        });
    }

    public Collection<Integer> clearTrailingAds(final int i2) {
        final Collection<Integer> d2 = this.f16017c.d(i2);
        if (!d2.isEmpty()) {
            a(d2, new Runnable() {
                public void run() {
                    v vVar = MaxAdPlacer.this.logger;
                    vVar.b("MaxAdPlacer", "Clearing trailing ads after position " + i2);
                    MaxAdPlacer.this.f16017c.a((Collection<Integer>) d2);
                }
            });
        }
        return d2;
    }

    public void destroy() {
        this.logger.b("MaxAdPlacer", "Destroying ad placer");
        clearAds();
        this.f16018d.a();
    }

    public long getAdItemId(int i2) {
        if (isFilledPosition(i2)) {
            return (long) (-System.identityHashCode(this.f16017c.c(i2)));
        }
        return 0;
    }

    public AppLovinSdkUtils.Size getAdSize(int i2, int i3) {
        if (isFilledPosition(i2)) {
            AppLovinSdkUtils.Size size = this.f16015a;
            boolean z2 = size != AppLovinSdkUtils.Size.ZERO;
            int min = Math.min(z2 ? size.getWidth() : 360, i3);
            d dVar = (d) this.f16017c.c(i2);
            if ("small_template_1".equalsIgnoreCase(dVar.v())) {
                return new AppLovinSdkUtils.Size(min, z2 ? this.f16015a.getHeight() : 120);
            } else if ("medium_template_1".equalsIgnoreCase(dVar.v())) {
                return new AppLovinSdkUtils.Size(min, (int) (((double) min) / (z2 ? ((double) this.f16015a.getWidth()) / ((double) this.f16015a.getHeight()) : 1.2d)));
            } else if (z2) {
                return this.f16015a;
            } else {
                if (dVar.u() != null) {
                    View mainView = dVar.u().getMainView();
                    return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
                }
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public int getAdjustedCount(int i2) {
        return this.f16017c.e(i2);
    }

    public int getAdjustedPosition(int i2) {
        return this.f16017c.f(i2);
    }

    public int getOriginalPosition(int i2) {
        return this.f16017c.g(i2);
    }

    public void insertItem(int i2) {
        v vVar = this.logger;
        vVar.b("MaxAdPlacer", "Inserting item at position: " + i2);
        this.f16017c.h(i2);
    }

    public boolean isAdPosition(int i2) {
        return this.f16017c.a(i2);
    }

    public boolean isFilledPosition(int i2) {
        return this.f16017c.b(i2);
    }

    public void loadAds() {
        this.logger.b("MaxAdPlacer", "Loading ads");
        this.f16018d.c();
    }

    public void moveItem(int i2, int i3) {
        this.f16017c.b(i2, i3);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.f16019e;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.f16019e;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        v vVar = this.logger;
        vVar.e("MaxAdPlacer", "Native ad failed to load: " + maxError);
    }

    public void onNativeAdLoaded() {
        this.logger.b("MaxAdPlacer", "Native ad enqueued");
        a();
    }

    public void removeItem(final int i2) {
        a(isFilledPosition(i2) ? Collections.singletonList(Integer.valueOf(i2)) : Collections.emptyList(), new Runnable() {
            public void run() {
                v vVar = MaxAdPlacer.this.logger;
                vVar.b("MaxAdPlacer", "Removing item at position: " + i2);
                MaxAdPlacer.this.f16017c.i(i2);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderAd(int r7, android.view.ViewGroup r8) {
        /*
            r6 = this;
            com.applovin.impl.mediation.b.a.a r0 = r6.f16017c
            com.applovin.mediation.MaxAd r0 = r0.c(r7)
            java.lang.String r1 = "MaxAdPlacer"
            if (r0 != 0) goto L_0x0021
            com.applovin.impl.sdk.v r8 = r6.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "An ad is not available for position: "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.b(r1, r7)
            return
        L_0x0021:
            r2 = r0
            com.applovin.impl.mediation.a.d r2 = (com.applovin.impl.mediation.a.d) r2
            com.applovin.mediation.nativeAds.MaxNativeAdView r2 = r2.u()
            if (r2 == 0) goto L_0x0041
            com.applovin.impl.sdk.v r0 = r6.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Using pre-rendered ad at position: "
        L_0x0033:
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.b(r1, r7)
            goto L_0x0078
        L_0x0041:
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder r2 = r6.f16016b
            java.lang.String r3 = "Unable to render ad at position: "
            if (r2 == 0) goto L_0x00a0
            com.applovin.mediation.nativeAds.MaxNativeAdView r2 = new com.applovin.mediation.nativeAds.MaxNativeAdView
            com.applovin.mediation.nativeAds.MaxNativeAdViewBinder r4 = r6.f16016b
            android.content.Context r5 = r8.getContext()
            r2.<init>((com.applovin.mediation.nativeAds.MaxNativeAdViewBinder) r4, (android.content.Context) r5)
            com.applovin.impl.mediation.b.a.b r4 = r6.f16018d
            boolean r0 = r4.a(r2, r0)
            if (r0 == 0) goto L_0x0064
            com.applovin.impl.sdk.v r0 = r6.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Rendered ad at position: "
            goto L_0x0033
        L_0x0064:
            com.applovin.impl.sdk.v r0 = r6.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r0.e(r1, r7)
        L_0x0078:
            int r7 = r8.getChildCount()
        L_0x007c:
            if (r7 < 0) goto L_0x008c
            android.view.View r0 = r8.getChildAt(r7)
            boolean r0 = r0 instanceof com.applovin.mediation.nativeAds.MaxNativeAdView
            if (r0 == 0) goto L_0x0089
            r8.removeViewAt(r7)
        L_0x0089:
            int r7 = r7 + -1
            goto L_0x007c
        L_0x008c:
            android.view.ViewParent r7 = r2.getParent()
            if (r7 == 0) goto L_0x009b
            android.view.ViewParent r7 = r2.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r2)
        L_0x009b:
            r7 = -1
            r8.addView(r2, r7, r7)
            return
        L_0x00a0:
            com.applovin.impl.sdk.v r8 = r6.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r7)
            java.lang.String r7 = ". If you're using a custom ad template, check that nativeAdViewBinder is set."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.e(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.renderAd(int, android.view.ViewGroup):void");
    }

    public void setAdSize(int i2, int i3) {
        this.f16015a = new AppLovinSdkUtils.Size(i2, i3);
    }

    public void setListener(Listener listener) {
        this.f16019e = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.f16016b = maxNativeAdViewBinder;
    }

    public void updateFillablePositions(int i2, int i3) {
        this.f16017c.a(i2, i3);
        if (i2 != -1 && i3 != -1) {
            a();
        }
    }
}
