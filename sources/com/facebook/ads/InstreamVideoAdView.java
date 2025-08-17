package com.facebook.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.a.a;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.j;
import com.facebook.ads.internal.adapters.s;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.f;
import com.facebook.ads.internal.q.a.p;
import com.facebook.ads.internal.view.b.c;
import java.util.EnumSet;

public class InstreamVideoAdView extends RelativeLayout implements Ad {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19456a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f19457b;

    /* renamed from: c  reason: collision with root package name */
    private final AdSize f19458c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DisplayAdController f19459d;

    /* renamed from: e  reason: collision with root package name */
    private j f19460e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f19461f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public InstreamVideoAdListener f19462g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View f19463h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f19464i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public c f19465j;

    public InstreamVideoAdView(Context context, Bundle bundle) {
        this(context, bundle.getString("placementID"), (AdSize) bundle.get("adSize"));
        this.f19464i = bundle;
    }

    public InstreamVideoAdView(Context context, String str, AdSize adSize) {
        super(context);
        this.f19461f = false;
        this.f19456a = context;
        this.f19457b = str;
        this.f19458c = adSize;
        this.f19459d = getController();
    }

    private final void a() {
        DisplayAdController displayAdController = this.f19459d;
        if (displayAdController != null) {
            displayAdController.b(true);
            this.f19459d = null;
            this.f19459d = getController();
            this.f19460e = null;
            this.f19461f = false;
            removeAllViews();
        }
    }

    private void a(String str) {
        if (this.f19464i != null) {
            j jVar = new j();
            this.f19460e = jVar;
            jVar.a(getContext(), (a) new a() {
                public void a(s sVar) {
                    boolean unused = InstreamVideoAdView.this.f19461f = true;
                    if (InstreamVideoAdView.this.f19462g != null) {
                        InstreamVideoAdView.this.f19462g.onAdLoaded(InstreamVideoAdView.this);
                    }
                }

                public void a(s sVar, View view) {
                    if (view != null) {
                        View unused = InstreamVideoAdView.this.f19463h = view;
                        InstreamVideoAdView.this.removeAllViews();
                        InstreamVideoAdView.this.f19463h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        InstreamVideoAdView instreamVideoAdView = InstreamVideoAdView.this;
                        instreamVideoAdView.addView(instreamVideoAdView.f19463h);
                        return;
                    }
                    throw new IllegalStateException("Cannot present null view");
                }

                public void a(s sVar, AdError adError) {
                    if (InstreamVideoAdView.this.f19462g != null) {
                        InstreamVideoAdView.this.f19462g.onError(InstreamVideoAdView.this, adError);
                    }
                }

                public void b(s sVar) {
                    if (InstreamVideoAdView.this.f19462g != null) {
                        InstreamVideoAdView.this.f19462g.onAdClicked(InstreamVideoAdView.this);
                    }
                }

                public void c(s sVar) {
                }

                public void d(s sVar) {
                    if (InstreamVideoAdView.this.f19462g != null) {
                        InstreamVideoAdView.this.f19462g.onAdVideoComplete(InstreamVideoAdView.this);
                    }
                }
            }, this.f19459d.e(), this.f19464i.getBundle("adapter"), (EnumSet<CacheFlag>) EnumSet.of(CacheFlag.NONE));
            return;
        }
        this.f19459d.a(str);
    }

    private DisplayAdController getController() {
        DisplayAdController displayAdController = new DisplayAdController(getContext(), this.f19457b, f.INSTREAM_VIDEO, AdPlacementType.INSTREAM, this.f19458c.toInternalAdSize(), d.ADS, 1, true);
        this.f19459d = displayAdController;
        displayAdController.a((com.facebook.ads.internal.adapters.a) new com.facebook.ads.internal.adapters.a() {
            public void a() {
                if (InstreamVideoAdView.this.f19462g != null) {
                    InstreamVideoAdView.this.f19462g.onAdClicked(InstreamVideoAdView.this);
                }
            }

            public void a(View view) {
                if (view != null) {
                    View unused = InstreamVideoAdView.this.f19463h = view;
                    InstreamVideoAdView.this.removeAllViews();
                    InstreamVideoAdView.this.f19463h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    InstreamVideoAdView instreamVideoAdView = InstreamVideoAdView.this;
                    instreamVideoAdView.addView(instreamVideoAdView.f19463h);
                    if (com.facebook.ads.internal.l.a.b(InstreamVideoAdView.this.f19456a)) {
                        c unused2 = InstreamVideoAdView.this.f19465j = new c();
                        InstreamVideoAdView.this.f19465j.a(InstreamVideoAdView.this.f19457b);
                        InstreamVideoAdView.this.f19465j.b(InstreamVideoAdView.this.f19456a.getPackageName());
                        if (InstreamVideoAdView.this.f19459d.a() != null) {
                            InstreamVideoAdView.this.f19465j.a(InstreamVideoAdView.this.f19459d.a().a());
                        }
                        InstreamVideoAdView.this.f19463h.getOverlay().add(InstreamVideoAdView.this.f19465j);
                        InstreamVideoAdView.this.f19463h.setOnLongClickListener(new View.OnLongClickListener() {
                            public boolean onLongClick(View view) {
                                if (InstreamVideoAdView.this.f19463h == null || InstreamVideoAdView.this.f19465j == null) {
                                    return false;
                                }
                                InstreamVideoAdView.this.f19465j.setBounds(0, 0, InstreamVideoAdView.this.f19463h.getWidth(), InstreamVideoAdView.this.f19463h.getHeight());
                                InstreamVideoAdView.this.f19465j.a(!InstreamVideoAdView.this.f19465j.a());
                                return true;
                            }
                        });
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Cannot present null view");
            }

            public void a(AdAdapter adAdapter) {
                if (InstreamVideoAdView.this.f19459d != null) {
                    boolean unused = InstreamVideoAdView.this.f19461f = true;
                    if (InstreamVideoAdView.this.f19462g != null) {
                        InstreamVideoAdView.this.f19462g.onAdLoaded(InstreamVideoAdView.this);
                    }
                }
            }

            public void a(com.facebook.ads.internal.protocol.a aVar) {
                if (InstreamVideoAdView.this.f19462g != null) {
                    InstreamVideoAdView.this.f19462g.onError(InstreamVideoAdView.this, AdError.getAdErrorFromWrapper(aVar));
                }
            }

            public void b() {
                if (InstreamVideoAdView.this.f19462g != null) {
                    InstreamVideoAdView.this.f19462g.onLoggingImpression(InstreamVideoAdView.this);
                }
            }

            public void c() {
                if (InstreamVideoAdView.this.f19462g != null) {
                    InstreamVideoAdView.this.f19462g.onAdVideoComplete(InstreamVideoAdView.this);
                }
            }
        });
        return this.f19459d;
    }

    public void destroy() {
        if (this.f19465j != null && com.facebook.ads.internal.l.a.b(this.f19456a)) {
            this.f19465j.b();
            View view = this.f19463h;
            if (view != null) {
                view.getOverlay().remove(this.f19465j);
            }
        }
        a();
    }

    public String getPlacementId() {
        return this.f19457b;
    }

    public Bundle getSaveInstanceState() {
        Bundle g2;
        p pVar = this.f19460e;
        if (pVar == null) {
            pVar = (s) this.f19459d.f();
        }
        if (pVar == null || (g2 = pVar.g()) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("adapter", g2);
        bundle.putString("placementID", this.f19457b);
        bundle.putSerializable("adSize", this.f19458c);
        return bundle;
    }

    public boolean isAdInvalidated() {
        DisplayAdController displayAdController = this.f19459d;
        return displayAdController == null || displayAdController.d();
    }

    public boolean isAdLoaded() {
        return this.f19461f;
    }

    public void loadAd() {
        a((String) null);
    }

    public void loadAdFromBid(String str) {
        a(str);
    }

    public void setAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.f19462g = instreamVideoAdListener;
    }

    public boolean show() {
        DisplayAdController displayAdController;
        if (!this.f19461f || ((displayAdController = this.f19459d) == null && this.f19460e == null)) {
            InstreamVideoAdListener instreamVideoAdListener = this.f19462g;
            if (instreamVideoAdListener != null) {
                instreamVideoAdListener.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        j jVar = this.f19460e;
        if (jVar != null) {
            jVar.e();
        } else {
            displayAdController.b();
        }
        this.f19461f = false;
        return true;
    }
}
