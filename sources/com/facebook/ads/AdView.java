package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.a;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.e;
import com.facebook.ads.internal.protocol.g;
import com.facebook.ads.internal.view.b.c;

public class AdView extends RelativeLayout implements Ad {

    /* renamed from: a  reason: collision with root package name */
    private static final d f19423a = d.ADS;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DisplayMetrics f19424b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final e f19425c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19426d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DisplayAdController f19427e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AdListener f19428f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f19429g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public c f19430h;

    public AdView(Context context, final String str, AdSize adSize) {
        super(context);
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.f19424b = getContext().getResources().getDisplayMetrics();
        e internalAdSize = adSize.toInternalAdSize();
        this.f19425c = internalAdSize;
        this.f19426d = str;
        DisplayAdController displayAdController = new DisplayAdController(context, str, g.a(internalAdSize), AdPlacementType.BANNER, adSize.toInternalAdSize(), f19423a, 1, true);
        this.f19427e = displayAdController;
        displayAdController.a((a) new a() {
            public void a() {
                if (AdView.this.f19428f != null) {
                    AdView.this.f19428f.onAdClicked(AdView.this);
                }
            }

            public void a(View view) {
                if (view != null) {
                    View unused = AdView.this.f19429g = view;
                    AdView.this.removeAllViews();
                    AdView adView = AdView.this;
                    adView.addView(adView.f19429g);
                    if (AdView.this.f19429g instanceof com.facebook.ads.internal.view.b.a) {
                        g.a(AdView.this.f19424b, AdView.this.f19429g, AdView.this.f19425c);
                    }
                    if (AdView.this.f19428f != null) {
                        AdView.this.f19428f.onAdLoaded(AdView.this);
                    }
                    if (com.facebook.ads.internal.l.a.b(AdView.this.getContext())) {
                        c unused2 = AdView.this.f19430h = new c();
                        AdView.this.f19430h.a(str);
                        AdView.this.f19430h.b(AdView.this.getContext().getPackageName());
                        if (AdView.this.f19427e.a() != null) {
                            AdView.this.f19430h.a(AdView.this.f19427e.a().a());
                        }
                        if (AdView.this.f19429g instanceof com.facebook.ads.internal.view.b.a) {
                            AdView.this.f19430h.a(((com.facebook.ads.internal.view.b.a) AdView.this.f19429g).getViewabilityChecker());
                        }
                        AdView.this.f19429g.setOnLongClickListener(new View.OnLongClickListener() {
                            public boolean onLongClick(View view) {
                                AdView.this.f19430h.setBounds(0, 0, AdView.this.f19429g.getWidth(), AdView.this.f19429g.getHeight());
                                AdView.this.f19430h.a(!AdView.this.f19430h.a());
                                return true;
                            }
                        });
                        AdView.this.f19429g.getOverlay().add(AdView.this.f19430h);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Cannot present null view");
            }

            public void a(AdAdapter adAdapter) {
                if (AdView.this.f19427e != null) {
                    AdView.this.f19427e.b();
                }
            }

            public void a(com.facebook.ads.internal.protocol.a aVar) {
                if (AdView.this.f19428f != null) {
                    AdView.this.f19428f.onError(AdView.this, AdError.getAdErrorFromWrapper(aVar));
                }
            }

            public void b() {
                if (AdView.this.f19428f != null) {
                    AdView.this.f19428f.onLoggingImpression(AdView.this);
                }
            }
        });
    }

    private void a(String str) {
        this.f19427e.a(str);
    }

    public void destroy() {
        DisplayAdController displayAdController = this.f19427e;
        if (displayAdController != null) {
            displayAdController.b(true);
            this.f19427e = null;
        }
        if (this.f19430h != null && com.facebook.ads.internal.l.a.b(getContext())) {
            this.f19430h.b();
            this.f19429g.getOverlay().remove(this.f19430h);
        }
        removeAllViews();
        this.f19429g = null;
        this.f19428f = null;
    }

    @Deprecated
    public void disableAutoRefresh() {
    }

    public String getPlacementId() {
        return this.f19426d;
    }

    public boolean isAdInvalidated() {
        DisplayAdController displayAdController = this.f19427e;
        return displayAdController == null || displayAdController.d();
    }

    public void loadAd() {
        a((String) null);
    }

    public void loadAdFromBid(String str) {
        a(str);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        View view = this.f19429g;
        if (view != null) {
            g.a(this.f19424b, view, this.f19425c);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f19428f = adListener;
    }
}
