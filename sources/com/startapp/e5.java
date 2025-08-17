package com.startapp;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import com.startapp.b6;
import com.startapp.h5;
import com.startapp.ic;
import com.startapp.k6;
import com.startapp.sdk.ads.video.VideoAdDetails;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.ads.video.VideoUtil$VideoEligibility;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class e5 extends sd {

    /* renamed from: m  reason: collision with root package name */
    public final long f34437m = System.currentTimeMillis();

    /* renamed from: n  reason: collision with root package name */
    public volatile CacheKey f34438n;

    /* renamed from: o  reason: collision with root package name */
    public int f34439o = 0;

    public class a implements k6.a {
        public a() {
        }
    }

    public class b implements b6.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f34441a;

        public b(boolean z2) {
            this.f34441a = z2;
        }

        public void a(String str) {
            Ad.AdState adState;
            if (str != null) {
                if (!str.equals("downloadInterrupted")) {
                    e5 e5Var = e5.this;
                    boolean z2 = this.f34441a;
                    Ad ad = e5Var.f35754b;
                    if (z2) {
                        adState = Ad.AdState.READY;
                    } else {
                        adState = Ad.AdState.UN_INITIALIZED;
                    }
                    ad.setState(adState);
                    e5.this.g().a(str);
                }
                e5.this.c(this.f34441a);
                return;
            }
            e5.this.c(false);
            e5 e5Var2 = e5.this;
            p.a(e5Var2.f35753a, e5Var2.a(), e5.this.f35754b);
            e5.a(e5.this, VASTErrorCodes.FileNotFound, (List) null);
        }
    }

    public class c implements h5.a {
        public c() {
        }

        public void a(String str) {
            e5.this.g().a(str);
        }
    }

    public e5(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, adEventListener, placement, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048 A[Catch:{ all -> 0x001e, all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.startapp.e5 r5, com.startapp.sdk.ads.video.vast.VASTErrorCodes r6, java.util.List<java.lang.String> r7) {
        /*
            r5.getClass()
            if (r7 == 0) goto L_0x0025
            int r0 = r7.size()     // Catch:{ all -> 0x0079 }
            if (r0 <= 0) goto L_0x0025
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r0 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.SAProcessSuccess     // Catch:{ all -> 0x001e }
            if (r6 != r0) goto L_0x0013
            java.util.List r7 = com.startapp.lb.a((java.util.List<java.lang.String>) r7)     // Catch:{ all -> 0x001e }
        L_0x0013:
            int r0 = r7.size()     // Catch:{ all -> 0x001e }
            if (r0 <= 0) goto L_0x0042
            com.startapp.sdk.ads.video.tracking.ActionTrackingLink[] r7 = com.startapp.sdk.ads.video.tracking.VideoTrackingDetails.b(r7)     // Catch:{ all -> 0x001e }
            goto L_0x0043
        L_0x001e:
            r7 = move-exception
            android.content.Context r0 = r5.f35753a     // Catch:{ all -> 0x0079 }
            com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0079 }
            goto L_0x0042
        L_0x0025:
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x0042
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0079 }
            com.startapp.sdk.ads.video.tracking.VideoTrackingDetails r7 = r7.h()     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x0042
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0079 }
            com.startapp.sdk.ads.video.tracking.VideoTrackingDetails r7 = r7.h()     // Catch:{ all -> 0x0079 }
            com.startapp.sdk.ads.video.tracking.ActionTrackingLink[] r7 = r7.e()     // Catch:{ all -> 0x0079 }
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            if (r7 == 0) goto L_0x007f
            int r0 = r7.length     // Catch:{ all -> 0x0079 }
            if (r0 <= 0) goto L_0x007f
            com.startapp.sdk.ads.video.VideoAdDetails r0 = r5.g()     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x005b
            java.lang.String r2 = r0.i()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x005b
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0079 }
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            com.startapp.sdk.ads.video.tracking.VideoTrackingParams r2 = new com.startapp.sdk.ads.video.tracking.VideoTrackingParams     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "1"
            r4 = 0
            r2.<init>(r1, r4, r4, r3)     // Catch:{ all -> 0x0079 }
            com.startapp.d6 r1 = new com.startapp.d6     // Catch:{ all -> 0x0079 }
            r1.<init>(r7, r2, r0, r4)     // Catch:{ all -> 0x0079 }
            java.lang.String r7 = "error"
            r1.f34346e = r7     // Catch:{ all -> 0x0079 }
            r1.f34347f = r6     // Catch:{ all -> 0x0079 }
            com.startapp.c6 r6 = r1.a()     // Catch:{ all -> 0x0079 }
            android.content.Context r7 = r5.f35753a     // Catch:{ all -> 0x0079 }
            com.startapp.p.a((android.content.Context) r7, (com.startapp.c6) r6)     // Catch:{ all -> 0x0079 }
            goto L_0x007f
        L_0x0079:
            r6 = move-exception
            android.content.Context r5 = r5.f35753a
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.e5.a(com.startapp.e5, com.startapp.sdk.ads.video.vast.VASTErrorCodes, java.util.List):void");
    }

    public boolean b(GetAdRequest getAdRequest) {
        VideoUtil$VideoEligibility b2;
        if (!(getAdRequest != null)) {
            return false;
        }
        if (!getAdRequest.b() || (b2 = p.b(this.f35753a)) == VideoUtil$VideoEligibility.ELIGIBLE) {
            return true;
        }
        this.f35758f = b2.a();
        return false;
    }

    public GetAdRequest d() {
        GetAdRequest a2 = a((GetAdRequest) new d5());
        if (a2 != null) {
            a2.f(this.f35753a);
        }
        return a2;
    }

    public VideoAdDetails g() {
        return ((VideoEnabledAd) this.f35754b).w();
    }

    public final void d(boolean z2) {
        AdPreferences adPreferences;
        Ad.AdType type = this.f35754b.getType();
        Ad.AdType adType = Ad.AdType.REWARDED_VIDEO;
        if ((type != adType && this.f35754b.getType() != Ad.AdType.VIDEO) || z2) {
            AdPreferences adPreferences2 = this.f35755c;
            if (adPreferences2 == null) {
                adPreferences = new AdPreferences();
            } else {
                adPreferences = new AdPreferences(adPreferences2);
            }
            adPreferences.setType((this.f35754b.getType() == adType || this.f35754b.getType() == Ad.AdType.VIDEO) ? Ad.AdType.VIDEO_NO_VAST : Ad.AdType.NON_VIDEO);
            CacheKey a2 = d8.f34354a.a(this.f35753a, (StartAppAd) null, this.f35757e, adPreferences, (AdEventListener) null);
            if (z2) {
                this.f34438n = a2;
            }
        }
    }

    public void b(boolean z2) {
        if (!(g() != null)) {
            this.f35754b.setState(z2 ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
        }
    }

    public boolean a(Object obj) {
        VASTErrorCodes vASTErrorCodes;
        ic.a aVar = (ic.a) obj;
        String str = null;
        String str2 = aVar != null ? aVar.f34701b : null;
        boolean z2 = false;
        boolean z3 = true;
        if (str2 == null || !str2.toLowerCase().contains("json")) {
            if (aVar != null) {
                str = aVar.f34700a;
            }
            if (AdsCommonMetaData.f36186h.G().q()) {
                if (lb.a(str, "@videoJson@", "@videoJson@") == null) {
                    z3 = false;
                }
                if (z3) {
                    d(false);
                }
            }
            return super.a(obj);
        }
        VideoConfig G = AdsCommonMetaData.f36186h.G();
        if (G.q()) {
            Set<String> set = this.f35863i.D0;
            if (!(set != null && set.size() > 0)) {
                d(true);
            }
        }
        try {
            i5 i5Var = (i5) h0.a(aVar.f34700a, i5.class);
            if (i5Var == null || i5Var.getVastTag() == null) {
                return a("no VAST wrapper in json", (Throwable) null, true);
            }
            String L = MetaData.f36379h.L();
            h6 h6Var = (!i5Var.isRecordHops() || TextUtils.isEmpty(L)) ? null : new h6(this.f35753a, L, i5Var.getPartnerResponse(), i5Var.getPartnerName(), i5Var.isSkipFailed());
            k6 k6Var = new k6(this.f35753a);
            k6Var.f34830g = G.e();
            k6Var.f34827d = new a();
            String vastTag = i5Var.getVastTag();
            k6Var.f34831h.clear();
            g6 a2 = k6Var.a(vastTag, new ArrayList(), h6Var);
            if (a2 != null) {
                int i2 = (int) (((float) k6Var.f34825b) / k6Var.f34826c);
                f6 f6Var = null;
                for (f6 next : k6Var.f34831h) {
                    if (f6Var == null || next.a(k6Var.f34825b, i2) > f6Var.a(k6Var.f34825b, i2)) {
                        f6Var = next;
                    }
                }
                a2.f34573o = f6Var;
                ArrayList arrayList = new ArrayList(a2.f34559a);
                VASTErrorCodes vASTErrorCodes2 = VASTErrorCodes.SAProcessSuccess;
                k6Var.a((List<String>) arrayList, vASTErrorCodes2);
                if (h6Var != null) {
                    h6Var.a(vASTErrorCodes2);
                }
            } else if (!(h6Var == null || (vASTErrorCodes = k6Var.f34828e) == null)) {
                h6Var.a(vASTErrorCodes);
            }
            if (a2 != null) {
                Ad ad = this.f35754b;
                VideoEnabledAd videoEnabledAd = (VideoEnabledAd) ad;
                if (ad.getType() != Ad.AdType.REWARDED_VIDEO) {
                    z2 = true;
                }
                videoEnabledAd.a(a2, G, z2);
                if (i5Var.getTtlSec() != null) {
                    ((VideoEnabledAd) this.f35754b).b(i5Var.getTtlSec());
                }
                aVar.f34700a = i5Var.getAdmTag();
                aVar.f34701b = AudienceNetworkActivity.WEBVIEW_MIME_TYPE;
                return super.a(aVar);
            }
            if (i5Var.getCampaignId() != null) {
                this.f35862h.add(i5Var.getCampaignId());
            }
            this.f34439o++;
            ((VideoEnabledAd) this.f35754b).v();
            if (System.currentTimeMillis() - this.f34437m >= ((long) G.n())) {
                return a("VAST retry timeout", (Throwable) null, false);
            }
            if (this.f34439o > G.d()) {
                return a("VAST too many excludes", (Throwable) null, false);
            }
            return b();
        } catch (Exception e2) {
            return a("VAST json parsing", (Throwable) e2, true);
        }
    }

    public void a(boolean z2) {
        super.a(z2);
        if (z2) {
            if (g() != null) {
                if (AdsCommonMetaData.f36186h.G().p()) {
                    this.f35754b.setState(z2 ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
                }
                g().a(this.f35755c.isVideoMuted());
                b bVar = new b(z2);
                c cVar = new c();
                Context b2 = ia.b(this.f35753a);
                m5 m5Var = m5.f34899a;
                String i2 = g().i();
                m5Var.getClass();
                ComponentLocator.a(b2).B.b().execute(new j5(m5Var, b2, i2, bVar, cVar));
                return;
            }
        }
        c(z2);
    }

    public final boolean a(String str, Throwable th, boolean z2) {
        if (th != null) {
            y8.a(this.f35753a, th);
        } else if (z2) {
            y8 y8Var = new y8(z8.f36996c);
            y8Var.f36954d = str;
            y8Var.a(this.f35753a);
        }
        v6 c2 = d8.f34354a.c(this.f34438n);
        if (c2 instanceof HtmlAd) {
            ic.a aVar = new ic.a();
            aVar.f34701b = AudienceNetworkActivity.WEBVIEW_MIME_TYPE;
            aVar.f34700a = ((HtmlAd) c2).j();
            return super.a(aVar);
        }
        this.f35754b.setErrorMessage(this.f35758f);
        return false;
    }
}
