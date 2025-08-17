package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.e;
import com.facebook.ads.internal.protocol.g;
import com.facebook.ads.internal.q.d.a;
import com.facebook.ads.internal.q.d.b;
import java.util.EnumSet;

public class InterstitialAd implements Ad {

    /* renamed from: a  reason: collision with root package name */
    private static final d f19469a = d.ADS;

    /* renamed from: b  reason: collision with root package name */
    private final Context f19470b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19471c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DisplayAdController f19472d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19473e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f19474f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public InterstitialAdListener f19475g;

    public InterstitialAd(Context context, String str) {
        this.f19470b = context;
        this.f19471c = str;
    }

    private void a(EnumSet<CacheFlag> enumSet, String str) {
        this.f19473e = false;
        if (this.f19474f) {
            a.a(this.f19470b, "api", b.f20746f, (Exception) new com.facebook.ads.internal.protocol.b(AdErrorType.NO_ADAPTER_ON_LOAD, "Interstitial load called while showing interstitial."));
            InterstitialAdListener interstitialAdListener = this.f19475g;
            if (interstitialAdListener != null) {
                AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
                interstitialAdListener.onError(this, new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
                return;
            }
            return;
        }
        DisplayAdController displayAdController = this.f19472d;
        if (displayAdController != null) {
            displayAdController.c();
            this.f19472d = null;
        }
        DisplayAdController displayAdController2 = new DisplayAdController(this.f19470b, this.f19471c, g.a(this.f19470b.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, e.INTERSTITIAL, f19469a, 1, true, enumSet);
        this.f19472d = displayAdController2;
        displayAdController2.a((com.facebook.ads.internal.adapters.a) new com.facebook.ads.internal.adapters.a() {
            public void a() {
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onAdClicked(InterstitialAd.this);
                }
            }

            public void a(View view) {
            }

            public void a(AdAdapter adAdapter) {
                boolean unused = InterstitialAd.this.f19473e = true;
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onAdLoaded(InterstitialAd.this);
                }
            }

            public void a(com.facebook.ads.internal.protocol.a aVar) {
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onError(InterstitialAd.this, AdError.getAdErrorFromWrapper(aVar));
                }
            }

            public void b() {
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onLoggingImpression(InterstitialAd.this);
                }
            }

            public void d() {
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onInterstitialDisplayed(InterstitialAd.this);
                }
            }

            public void e() {
                boolean unused = InterstitialAd.this.f19474f = false;
                if (InterstitialAd.this.f19472d != null) {
                    InterstitialAd.this.f19472d.c();
                    DisplayAdController unused2 = InterstitialAd.this.f19472d = null;
                }
                if (InterstitialAd.this.f19475g != null) {
                    InterstitialAd.this.f19475g.onInterstitialDismissed(InterstitialAd.this);
                }
            }

            public void f() {
                if (InterstitialAd.this.f19475g instanceof InterstitialAdExtendedListener) {
                    ((InterstitialAdExtendedListener) InterstitialAd.this.f19475g).onInterstitialActivityDestroyed();
                }
            }
        });
        this.f19472d.a(str);
    }

    public void destroy() {
        DisplayAdController displayAdController = this.f19472d;
        if (displayAdController != null) {
            displayAdController.b(true);
            this.f19472d = null;
        }
    }

    public String getPlacementId() {
        return this.f19471c;
    }

    public boolean isAdInvalidated() {
        DisplayAdController displayAdController = this.f19472d;
        return displayAdController == null || displayAdController.d();
    }

    public boolean isAdLoaded() {
        return this.f19473e;
    }

    public void loadAd() {
        loadAd(EnumSet.of(CacheFlag.NONE));
    }

    public void loadAd(EnumSet<CacheFlag> enumSet) {
        a(enumSet, (String) null);
    }

    public void loadAdFromBid(String str) {
        a((EnumSet<CacheFlag>) EnumSet.of(CacheFlag.NONE), str);
    }

    public void loadAdFromBid(EnumSet<CacheFlag> enumSet, String str) {
        a(enumSet, str);
    }

    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.f19475g = interstitialAdListener;
    }

    public boolean show() {
        if (!this.f19473e) {
            InterstitialAdListener interstitialAdListener = this.f19475g;
            if (interstitialAdListener != null) {
                interstitialAdListener.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        DisplayAdController displayAdController = this.f19472d;
        if (displayAdController == null) {
            Context context = this.f19470b;
            int i2 = b.f20747g;
            AdErrorType adErrorType = AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL;
            a.a(context, "api", i2, (Exception) new com.facebook.ads.internal.protocol.b(adErrorType, adErrorType.getDefaultErrorMessage()));
            InterstitialAdListener interstitialAdListener2 = this.f19475g;
            if (interstitialAdListener2 != null) {
                interstitialAdListener2.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        displayAdController.b();
        this.f19474f = true;
        this.f19473e = false;
        return true;
    }
}
