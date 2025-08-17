package com.adcolony.sdk;

import android.util.Log;
import android.webkit.WebView;
import com.adcolony.sdk.e0;
import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.CreativeType;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.adsession.ImpressionType;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.media.MediaEvents;
import com.iab.omid.library.adcolony.adsession.media.Position;
import com.iab.omid.library.adcolony.adsession.media.VastProperties;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class p0 {

    /* renamed from: a  reason: collision with root package name */
    private AdSession f13304a;

    /* renamed from: b  reason: collision with root package name */
    private AdEvents f13305b;

    /* renamed from: c  reason: collision with root package name */
    private MediaEvents f13306c;

    /* renamed from: d  reason: collision with root package name */
    private List<VerificationScriptResource> f13307d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f13308e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f13309f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f13310g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13311h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13312i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13313j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f13314k;

    /* renamed from: l  reason: collision with root package name */
    private int f13315l;

    /* renamed from: m  reason: collision with root package name */
    private int f13316m;

    /* renamed from: n  reason: collision with root package name */
    private String f13317n = "";
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public String f13318o = "";

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13319b;

        a(String str) {
            this.f13319b = str;
        }

        public void run() {
            f1 q2 = c0.q();
            f1 q3 = c0.q();
            c0.u(q3, "session_type", p0.this.f13308e);
            c0.n(q3, "session_id", p0.this.f13309f);
            c0.n(q3, "event", this.f13319b);
            c0.n(q2, "type", "iab_hook");
            c0.n(q2, "message", q3.toString());
            new h0("CustomMessage.controller_send", 0, q2).e();
        }
    }

    class b implements AdColonyCustomMessageListener {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f13322b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f13323c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ float f13324d;

            a(String str, String str2, float f2) {
                this.f13322b = str;
                this.f13323c = str2;
                this.f13324d = f2;
            }

            public void run() {
                p0 p0Var;
                if (this.f13322b.equals(p0.this.f13318o)) {
                    p0.this.g(this.f13323c, this.f13324d);
                    return;
                }
                AdColonyAdView adColonyAdView = a.f().T().s().get(this.f13322b);
                if (adColonyAdView != null) {
                    p0Var = adColonyAdView.getOmidManager();
                } else {
                    p0Var = null;
                }
                if (p0Var != null) {
                    p0Var.g(this.f13323c, this.f13324d);
                }
            }
        }

        b() {
        }

        public void a(AdColonyCustomMessage adColonyCustomMessage) {
            f1 r2 = c0.r(adColonyCustomMessage.a());
            String E = c0.E(r2, "event_type");
            float floatValue = BigDecimal.valueOf(c0.y(r2, "duration")).floatValue();
            boolean t2 = c0.t(r2, "replay");
            boolean equals = c0.E(r2, "skip_type").equals("dec");
            String E2 = c0.E(r2, "asi");
            if (E.equals("skip") && equals) {
                boolean unused = p0.this.f13314k = true;
            } else if (!t2 || (!E.equals(ViewProps.START) && !E.equals("first_quartile") && !E.equals("midpoint") && !E.equals("third_quartile") && !E.equals("complete"))) {
                z0.A(new a(E2, E, floatValue));
            }
        }
    }

    p0(f1 f1Var, String str) {
        VerificationScriptResource verificationScriptResource;
        this.f13308e = a(f1Var);
        this.f13313j = c0.t(f1Var, "skippable");
        this.f13315l = c0.A(f1Var, "skip_offset");
        this.f13316m = c0.A(f1Var, "video_duration");
        e1 d2 = c0.d(f1Var, "js_resources");
        e1 d3 = c0.d(f1Var, "verification_params");
        e1 d4 = c0.d(f1Var, "vendor_keys");
        this.f13318o = str;
        for (int i2 = 0; i2 < d2.e(); i2++) {
            try {
                String s2 = c0.s(d3, i2);
                String s3 = c0.s(d4, i2);
                URL url = new URL(c0.s(d2, i2));
                if (s2.equals("") || s3.equals("")) {
                    verificationScriptResource = VerificationScriptResource.b(url);
                } else {
                    verificationScriptResource = VerificationScriptResource.a(s3, url, s2);
                }
                this.f13307d.add(verificationScriptResource);
            } catch (MalformedURLException unused) {
                new e0.a().c("Invalid js resource url passed to Omid").d(e0.f13114i);
            }
        }
        try {
            this.f13317n = a.f().B0().a(c0.E(f1Var, "filepath"), true).toString();
        } catch (IOException unused2) {
            new e0.a().c("Error loading IAB JS Client").d(e0.f13114i);
        }
    }

    private int a(f1 f1Var) {
        if (this.f13308e == -1) {
            int A = c0.A(f1Var, "ad_unit_type");
            String E = c0.E(f1Var, "ad_type");
            if (A == 0) {
                return 0;
            }
            if (A == 1) {
                if (E.equals(MimeTypes.BASE_TYPE_VIDEO)) {
                    return 0;
                }
                if (E.equals(ViewProps.DISPLAY)) {
                    return 1;
                }
                if (E.equals("banner_display") || E.equals("interstitial_display")) {
                    return 2;
                }
            }
        }
        return this.f13308e;
    }

    private void k(c cVar) {
        l("register_ad_view");
        b1 b1Var = a.f().b().get(Integer.valueOf(cVar.I()));
        if (b1Var == null && !cVar.L().isEmpty()) {
            b1Var = (b1) cVar.L().entrySet().iterator().next().getValue();
        }
        AdSession adSession = this.f13304a;
        if (adSession != null && b1Var != null) {
            adSession.f(b1Var);
            if (b1Var instanceof l0) {
                ((l0) b1Var).X();
            }
        } else if (adSession != null) {
            adSession.f(cVar);
            cVar.h(this.f13304a);
            l("register_obstructions");
        }
    }

    private void l(String str) {
        if (!z0.m(new a(str))) {
            new e0.a().c("Executing ADCOmidManager.sendIabCustomMessage failed").d(e0.f13114i);
        }
    }

    private void p() {
        AdColony.d(new b(), "viewability_ad_event");
    }

    /* access modifiers changed from: package-private */
    public void c() throws IllegalArgumentException {
        d((WebView) null);
    }

    /* access modifiers changed from: package-private */
    public void d(WebView webView) throws IllegalArgumentException {
        String str;
        List<VerificationScriptResource> list;
        if (this.f13308e >= 0 && (str = this.f13317n) != null && !str.equals("") && (list = this.f13307d) != null) {
            if (!list.isEmpty() || o() == 2) {
                k f2 = a.f();
                Owner owner = Owner.NATIVE;
                ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
                int o2 = o();
                if (o2 == 0) {
                    CreativeType creativeType = CreativeType.VIDEO;
                    AdSession b2 = AdSession.b(AdSessionConfiguration.a(creativeType, impressionType, owner, owner, false), AdSessionContext.b(f2.J0(), this.f13317n, this.f13307d, (String) null, (String) null));
                    this.f13304a = b2;
                    this.f13309f = b2.e();
                    l("inject_javascript");
                } else if (o2 == 1) {
                    CreativeType creativeType2 = CreativeType.NATIVE_DISPLAY;
                    AdSession b3 = AdSession.b(AdSessionConfiguration.a(creativeType2, impressionType, owner, (Owner) null, false), AdSessionContext.b(f2.J0(), this.f13317n, this.f13307d, (String) null, (String) null));
                    this.f13304a = b3;
                    this.f13309f = b3.e();
                    l("inject_javascript");
                } else if (o2 == 2) {
                    CreativeType creativeType3 = CreativeType.HTML_DISPLAY;
                    AdSession b4 = AdSession.b(AdSessionConfiguration.a(creativeType3, impressionType, owner, (Owner) null, false), AdSessionContext.a(f2.J0(), webView, "", (String) null));
                    this.f13304a = b4;
                    this.f13309f = b4.e();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(c cVar) {
        MediaEvents mediaEvents;
        VastProperties vastProperties;
        if (!this.f13312i && this.f13308e >= 0 && this.f13304a != null) {
            k(cVar);
            p();
            if (this.f13308e != 0) {
                mediaEvents = null;
            } else {
                mediaEvents = MediaEvents.g(this.f13304a);
            }
            this.f13306c = mediaEvents;
            try {
                this.f13304a.g();
                this.f13305b = AdEvents.a(this.f13304a);
                l("start_session");
                if (this.f13306c != null) {
                    Position position = Position.PREROLL;
                    if (this.f13313j) {
                        vastProperties = VastProperties.c((float) this.f13315l, true, position);
                    } else {
                        vastProperties = VastProperties.b(true, position);
                    }
                    this.f13305b.d(vastProperties);
                } else {
                    this.f13305b.c();
                }
                this.f13312i = true;
            } catch (NullPointerException e2) {
                AdSession adSession = this.f13304a;
                ErrorType errorType = ErrorType.GENERIC;
                adSession.c(errorType, "Exception occurred on AdSession.start: " + Log.getStackTraceString(e2));
                j();
                e0.a c2 = new e0.a().c("Exception in ADCOmidManager on AdSession.start: ").c(Log.getStackTraceString(e2));
                c2.c(" Ad with adSessionId: " + this.f13318o + ".").d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(String str) {
        g(str, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r9, float r10) {
        /*
            r8 = this;
            boolean r0 = com.adcolony.sdk.a.h()
            if (r0 == 0) goto L_0x01ea
            com.iab.omid.library.adcolony.adsession.AdSession r0 = r8.f13304a
            if (r0 != 0) goto L_0x000c
            goto L_0x01ea
        L_0x000c:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r0 = r8.f13306c
            java.lang.String r1 = "cancel"
            java.lang.String r2 = "continue"
            java.lang.String r3 = "skip"
            java.lang.String r4 = "start"
            if (r0 != 0) goto L_0x0031
            boolean r0 = r9.equals(r4)
            if (r0 != 0) goto L_0x0031
            boolean r0 = r9.equals(r3)
            if (r0 != 0) goto L_0x0031
            boolean r0 = r9.equals(r2)
            if (r0 != 0) goto L_0x0031
            boolean r0 = r9.equals(r1)
            if (r0 != 0) goto L_0x0031
            return
        L_0x0031:
            int r0 = r9.hashCode()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            java.lang.String r5 = "pause"
            r6 = 0
            r7 = 1
            switch(r0) {
                case -1941887438: goto L_0x00d8;
                case -1710060637: goto L_0x00cd;
                case -1638835128: goto L_0x00c3;
                case -1367724422: goto L_0x00bb;
                case -934426579: goto L_0x00b0;
                case -651914917: goto L_0x00a6;
                case -599445191: goto L_0x009c;
                case -567202649: goto L_0x0094;
                case -342650039: goto L_0x0089;
                case 3532159: goto L_0x0081;
                case 106440182: goto L_0x0077;
                case 109757538: goto L_0x006e;
                case 583742045: goto L_0x0062;
                case 823102269: goto L_0x0056;
                case 1648173410: goto L_0x004a;
                case 1906584668: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x00e2
        L_0x003e:
            java.lang.String r0 = "buffer_end"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 13
            goto L_0x00e3
        L_0x004a:
            java.lang.String r0 = "sound_unmute"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 9
            goto L_0x00e3
        L_0x0056:
            java.lang.String r0 = "html5_interaction"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 15
            goto L_0x00e3
        L_0x0062:
            java.lang.String r0 = "in_video_engagement"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 14
            goto L_0x00e3
        L_0x006e:
            boolean r0 = r9.equals(r4)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 0
            goto L_0x00e3
        L_0x0077:
            boolean r0 = r9.equals(r5)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 10
            goto L_0x00e3
        L_0x0081:
            boolean r0 = r9.equals(r3)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 6
            goto L_0x00e3
        L_0x0089:
            java.lang.String r0 = "sound_mute"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 8
            goto L_0x00e3
        L_0x0094:
            boolean r0 = r9.equals(r2)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 5
            goto L_0x00e3
        L_0x009c:
            java.lang.String r0 = "complete"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 4
            goto L_0x00e3
        L_0x00a6:
            java.lang.String r0 = "third_quartile"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 3
            goto L_0x00e3
        L_0x00b0:
            java.lang.String r0 = "resume"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 11
            goto L_0x00e3
        L_0x00bb:
            boolean r0 = r9.equals(r1)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 7
            goto L_0x00e3
        L_0x00c3:
            java.lang.String r0 = "midpoint"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 2
            goto L_0x00e3
        L_0x00cd:
            java.lang.String r0 = "buffer_start"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 12
            goto L_0x00e3
        L_0x00d8:
            java.lang.String r0 = "first_quartile"
            boolean r0 = r9.equals(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x00e2
            r0 = 1
            goto L_0x00e3
        L_0x00e2:
            r0 = -1
        L_0x00e3:
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            switch(r0) {
                case 0: goto L_0x01a2;
                case 1: goto L_0x0199;
                case 2: goto L_0x0190;
                case 3: goto L_0x0187;
                case 4: goto L_0x017c;
                case 5: goto L_0x0174;
                case 6: goto L_0x0165;
                case 7: goto L_0x0165;
                case 8: goto L_0x015b;
                case 9: goto L_0x0151;
                case 10: goto L_0x0137;
                case 11: goto L_0x0123;
                case 12: goto L_0x0119;
                case 13: goto L_0x010f;
                case 14: goto L_0x00eb;
                case 15: goto L_0x00eb;
                default: goto L_0x00e9;
            }     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
        L_0x00e9:
            goto L_0x01ea
        L_0x00eb:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            com.iab.omid.library.adcolony.adsession.media.InteractionType r0 = com.iab.omid.library.adcolony.adsession.media.InteractionType.CLICK     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.a(r0)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            boolean r10 = r8.f13311h     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 == 0) goto L_0x01ea
            boolean r10 = r8.f13310g     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            boolean r10 = r8.f13314k     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.j()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r5)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.f13310g = r7     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.f13311h = r6     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x010f:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.b()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0119:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.c()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0123:
            boolean r10 = r8.f13310g     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 == 0) goto L_0x01ea
            boolean r10 = r8.f13314k     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.k()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.f13310g = r6     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0137:
            boolean r10 = r8.f13310g     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            boolean r10 = r8.f13311h     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            boolean r10 = r8.f13314k     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 != 0) goto L_0x01ea
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.j()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.f13310g = r7     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.f13311h = r6     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0151:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.o(r1)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x015b:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.o(r2)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0165:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r10 == 0) goto L_0x016c
            r10.l()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
        L_0x016c:
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.j()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0174:
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.j()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x017c:
            r8.f13314k = r7     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.d()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0187:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.n()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0190:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.i()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x0199:
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r10 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r10.h()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x01a2:
            com.iab.omid.library.adcolony.adsession.AdEvents r0 = r8.f13305b     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            r0.b()     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            com.iab.omid.library.adcolony.adsession.media.MediaEvents r0 = r8.f13306c     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            if (r0 == 0) goto L_0x01b6
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01b0
            goto L_0x01b3
        L_0x01b0:
            int r10 = r8.f13316m     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            float r10 = (float) r10     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
        L_0x01b3:
            r0.m(r10, r1)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
        L_0x01b6:
            r8.l(r9)     // Catch:{ IllegalStateException -> 0x01bc, IllegalArgumentException -> 0x01ba }
            goto L_0x01ea
        L_0x01ba:
            r10 = move-exception
            goto L_0x01bd
        L_0x01bc:
            r10 = move-exception
        L_0x01bd:
            com.adcolony.sdk.e0$a r0 = new com.adcolony.sdk.e0$a
            r0.<init>()
            java.lang.String r1 = "Recording IAB event for "
            com.adcolony.sdk.e0$a r0 = r0.c(r1)
            com.adcolony.sdk.e0$a r9 = r0.c(r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " caused "
            r0.append(r1)
            java.lang.Class r10 = r10.getClass()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.adcolony.sdk.e0$a r9 = r9.c(r10)
            com.adcolony.sdk.e0 r10 = com.adcolony.sdk.e0.f13112g
            r9.d(r10)
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.p0.g(java.lang.String, float):void");
    }

    /* access modifiers changed from: package-private */
    public void j() {
        AdColony.h("viewability_ad_event");
        this.f13304a.d();
        l("end_session");
        this.f13304a = null;
    }

    /* access modifiers changed from: package-private */
    public AdSession m() {
        return this.f13304a;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f13308e;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f13311h = true;
    }
}
