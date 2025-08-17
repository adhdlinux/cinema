package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.adapters.y;
import com.facebook.ads.internal.h.d;
import com.facebook.ads.internal.n.e;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.n.i;
import com.facebook.ads.internal.protocol.a;
import com.facebook.ads.internal.q.a.j;
import com.facebook.ads.internal.view.hscroll.b;
import org.json.JSONObject;

public abstract class NativeAdBase implements Ad {

    /* renamed from: a  reason: collision with root package name */
    private final f f19513a;

    public static class Image {

        /* renamed from: a  reason: collision with root package name */
        private final h f19516a;

        Image(h hVar) {
            this.f19516a = hVar;
        }

        public Image(String str, int i2, int i3) {
            this.f19516a = new h(str, i2, i3);
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            h a2 = h.a(jSONObject);
            if (a2 == null) {
                return null;
            }
            return new Image(a2);
        }

        public int getHeight() {
            return this.f19516a.c();
        }

        public int getWidth() {
            return this.f19516a.b();
        }
    }

    public enum MediaCacheFlag {
        NONE(e.NONE),
        ALL(e.ALL);
        

        /* renamed from: a  reason: collision with root package name */
        private final e f19518a;

        private MediaCacheFlag(e eVar) {
            this.f19518a = eVar;
        }

        /* access modifiers changed from: package-private */
        public e a() {
            return this.f19518a;
        }

        public long getCacheFlagValue() {
            return this.f19518a.a();
        }
    }

    public enum NativeComponentTag {
        AD_ICON(j.INTERNAL_AD_ICON),
        AD_TITLE(j.INTERNAL_AD_TITLE),
        AD_COVER_IMAGE(j.INTERNAL_AD_COVER_IMAGE),
        AD_SUBTITLE(j.INTERNAL_AD_SUBTITLE),
        AD_BODY(j.INTERNAL_AD_BODY),
        AD_CALL_TO_ACTION(j.INTERNAL_AD_CALL_TO_ACTION),
        AD_SOCIAL_CONTEXT(j.INTERNAL_AD_SOCIAL_CONTEXT),
        AD_CHOICES_ICON(j.INTERNAL_AD_CHOICES_ICON),
        AD_MEDIA(j.INTERNAL_AD_MEDIA);
        

        /* renamed from: a  reason: collision with root package name */
        private final j f19520a;

        private NativeComponentTag(j jVar) {
            this.f19520a = jVar;
        }

        public static void tagView(View view, NativeComponentTag nativeComponentTag) {
            if (view != null && nativeComponentTag != null) {
                j.a(view, nativeComponentTag.f19520a);
            }
        }
    }

    public static class Rating {

        /* renamed from: a  reason: collision with root package name */
        private final com.facebook.ads.internal.n.j f19521a;

        public Rating(double d2, double d3) {
            this.f19521a = new com.facebook.ads.internal.n.j(d2, d3);
        }

        Rating(com.facebook.ads.internal.n.j jVar) {
            this.f19521a = jVar;
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            com.facebook.ads.internal.n.j a2 = com.facebook.ads.internal.n.j.a(jSONObject);
            if (a2 == null) {
                return null;
            }
            return new Rating(a2);
        }

        public double getScale() {
            return this.f19521a.b();
        }

        public double getValue() {
            return this.f19521a.a();
        }
    }

    public NativeAdBase(Context context, y yVar, d dVar) {
        this.f19513a = new f(context, yVar, dVar, getViewTraversalPredicate());
    }

    public NativeAdBase(Context context, String str) {
        this.f19513a = new f(context, str, getViewTraversalPredicate());
    }

    NativeAdBase(NativeAdBase nativeAdBase) {
        this.f19513a = new f(nativeAdBase.f19513a);
    }

    NativeAdBase(f fVar) {
        this.f19513a = fVar;
    }

    public static f.c getViewTraversalPredicate() {
        return new f.c() {
            public boolean a(View view) {
                return (view instanceof MediaViewVideoRenderer) || (view instanceof AdChoicesView) || (view instanceof b);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void a(AdIconView adIconView) {
        if (adIconView != null) {
            this.f19513a.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MediaView mediaView) {
        if (mediaView != null) {
            this.f19513a.c(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.facebook.ads.internal.protocol.f fVar) {
        this.f19513a.a(fVar);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f19513a.a(z2);
    }

    public void destroy() {
        this.f19513a.e();
    }

    public void downloadMedia() {
        this.f19513a.d();
    }

    /* access modifiers changed from: package-private */
    public f g() {
        return this.f19513a;
    }

    public String getAdBodyText() {
        return this.f19513a.o();
    }

    public String getAdCallToAction() {
        return this.f19513a.q();
    }

    public Image getAdChoicesIcon() {
        if (this.f19513a.y() == null) {
            return null;
        }
        return new Image(this.f19513a.y());
    }

    public String getAdChoicesImageUrl() {
        if (this.f19513a.y() == null) {
            return null;
        }
        return this.f19513a.y().a();
    }

    public String getAdChoicesLinkUrl() {
        return this.f19513a.z();
    }

    public String getAdChoicesText() {
        return this.f19513a.A();
    }

    public Image getAdCoverImage() {
        if (this.f19513a.k() == null) {
            return null;
        }
        return new Image(this.f19513a.k());
    }

    public String getAdHeadline() {
        return this.f19513a.n();
    }

    public Image getAdIcon() {
        if (this.f19513a.j() == null) {
            return null;
        }
        return new Image(this.f19513a.j());
    }

    public String getAdLinkDescription() {
        return this.f19513a.s();
    }

    public AdNetwork getAdNetwork() {
        return AdNetwork.fromInternalAdNetwork(this.f19513a.b());
    }

    public String getAdSocialContext() {
        return this.f19513a.r();
    }

    @Deprecated
    public Rating getAdStarRating() {
        if (this.f19513a.w() == null) {
            return null;
        }
        return new Rating(this.f19513a.w());
    }

    public String getAdTranslation() {
        return this.f19513a.u();
    }

    public String getAdUntrimmedBodyText() {
        return this.f19513a.p();
    }

    public NativeAdViewAttributes getAdViewAttributes() {
        if (this.f19513a.l() == null) {
            return null;
        }
        return new NativeAdViewAttributes(this.f19513a.l());
    }

    public String getAdvertiserName() {
        return this.f19513a.m();
    }

    public String getId() {
        return this.f19513a.x();
    }

    public String getPlacementId() {
        return this.f19513a.f();
    }

    public String getPromotedTranslation() {
        return this.f19513a.v();
    }

    public String getSponsoredTranslation() {
        return this.f19513a.t();
    }

    /* access modifiers changed from: package-private */
    public y h() {
        return this.f19513a.a();
    }

    public boolean hasCallToAction() {
        return this.f19513a.i();
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return this.f19513a.G();
    }

    public boolean isAdInvalidated() {
        return this.f19513a.c();
    }

    public boolean isAdLoaded() {
        return this.f19513a.g();
    }

    public boolean isNativeConfigEnabled() {
        return this.f19513a.h();
    }

    public void loadAd() {
        loadAd(MediaCacheFlag.ALL);
    }

    public void loadAd(MediaCacheFlag mediaCacheFlag) {
        this.f19513a.a(mediaCacheFlag.a(), (String) null);
    }

    public void loadAdFromBid(String str) {
        loadAdFromBid(str, MediaCacheFlag.ALL);
    }

    public void loadAdFromBid(String str, MediaCacheFlag mediaCacheFlag) {
        this.f19513a.a(mediaCacheFlag.a(), str);
    }

    public void onCtaBroadcast() {
        this.f19513a.H();
    }

    public void setAdListener(final NativeAdListener nativeAdListener) {
        if (nativeAdListener != null) {
            this.f19513a.a((i) new i() {
                public void a() {
                    nativeAdListener.onMediaDownloaded(NativeAdBase.this);
                }

                public void a(a aVar) {
                    nativeAdListener.onError(NativeAdBase.this, AdError.getAdErrorFromWrapper(aVar));
                }

                public void b() {
                    nativeAdListener.onAdLoaded(NativeAdBase.this);
                }

                public void c() {
                    nativeAdListener.onAdClicked(NativeAdBase.this);
                }

                public void d() {
                    nativeAdListener.onLoggingImpression(NativeAdBase.this);
                }
            });
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f19513a.a(onTouchListener);
    }

    public void unregisterView() {
        this.f19513a.J();
    }
}
