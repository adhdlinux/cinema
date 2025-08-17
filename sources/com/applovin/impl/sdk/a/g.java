package com.applovin.impl.sdk.a;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.a.a;
import com.applovin.impl.a.b;
import com.applovin.impl.a.f;
import com.applovin.impl.a.j;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends b {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f15029h = true;

    /* renamed from: i  reason: collision with root package name */
    private final a f15030i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f15031j = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public MediaEvents f15032k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final VastProperties f15033l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicBoolean f15034m = new AtomicBoolean();

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f15035n = new AtomicBoolean();

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f15036o = new AtomicBoolean();

    /* renamed from: p  reason: collision with root package name */
    private final AtomicBoolean f15037p = new AtomicBoolean();

    public g(a aVar) {
        super(aVar);
        this.f15030i = aVar;
        this.f15033l = aVar.e() == -1 ? VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE) : VastProperties.createVastPropertiesForSkippableMedia((float) aVar.e(), true, Position.STANDALONE);
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration a() {
        try {
            CreativeType creativeType = CreativeType.VIDEO;
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.NATIVE;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th) {
            if (v.a()) {
                this.f15004c.b(this.f15005d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionContext a(WebView webView) {
        Set<j> d2;
        f fVar;
        if (f15029h || this.f15030i.aS() != null) {
            ArrayList arrayList = new ArrayList();
            for (b next : this.f15030i.aS().a()) {
                List<com.applovin.impl.a.g> b2 = next.b();
                if (!b2.isEmpty()) {
                    ArrayList<com.applovin.impl.a.g> arrayList2 = new ArrayList<>();
                    for (com.applovin.impl.a.g next2 : b2) {
                        if ("omid".equalsIgnoreCase(next2.a())) {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        d2 = next.d();
                        fVar = f.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED;
                        l.a(d2, fVar, this.f15003b);
                    } else {
                        ArrayList<URL> arrayList3 = new ArrayList<>();
                        for (com.applovin.impl.a.g b3 : arrayList2) {
                            try {
                                arrayList3.add(new URL(b3.b()));
                            } catch (Throwable th) {
                                if (v.a()) {
                                    this.f15004c.b(this.f15005d, "Failed to parse JavaScript resource url", th);
                                }
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            String c2 = next.c();
                            String a2 = next.a();
                            if (!StringUtils.isValidString(c2) || StringUtils.isValidString(a2)) {
                                for (URL url : arrayList3) {
                                    arrayList.add(StringUtils.isValidString(c2) ? VerificationScriptResource.createVerificationScriptResourceWithParameters(a2, url, c2) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                                }
                            }
                        }
                    }
                }
                d2 = next.d();
                fVar = f.FAILED_TO_LOAD_RESOURCE;
                l.a(d2, fVar, this.f15003b);
            }
            String e2 = this.f15003b.al().e();
            if (TextUtils.isEmpty(e2)) {
                if (v.a()) {
                    this.f15004c.e(this.f15005d, "JavaScript SDK content not loaded successfully");
                }
                return null;
            }
            try {
                return AdSessionContext.createNativeAdSessionContext(this.f15003b.al().d(), e2, arrayList, this.f15030i.getOpenMeasurementContentUrl(), this.f15030i.getOpenMeasurementCustomReferenceData());
            } catch (Throwable th2) {
                if (!v.a()) {
                    return null;
                }
                this.f15004c.b(this.f15005d, "Failed to create ad session context", th2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    public void a(final float f2, final boolean z2) {
        if (this.f15034m.compareAndSet(false, true)) {
            a("track started", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.start(f2, z2 ? 0.0f : 1.0f);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
        try {
            this.f15032k = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            if (v.a()) {
                this.f15004c.b(this.f15005d, "Failed to create media events", th);
            }
        }
    }

    public void a(final boolean z2) {
        a("track volume changed", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.volumeChange(z2 ? 0.0f : 1.0f);
            }
        });
    }

    public void c() {
        a("track loaded", (Runnable) new Runnable() {
            public void run() {
                g gVar = g.this;
                gVar.f15008g.loaded(gVar.f15033l);
            }
        });
    }

    public void f() {
        if (this.f15035n.compareAndSet(false, true)) {
            a("track first quartile", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.firstQuartile();
                }
            });
        }
    }

    public void g() {
        if (this.f15036o.compareAndSet(false, true)) {
            a("track midpoint", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.midpoint();
                }
            });
        }
    }

    public void h() {
        if (this.f15037p.compareAndSet(false, true)) {
            a("track third quartile", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.thirdQuartile();
                }
            });
        }
    }

    public void i() {
        a("track completed", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.complete();
            }
        });
    }

    public void j() {
        a("track paused", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.pause();
            }
        });
    }

    public void k() {
        a("track resumed", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.resume();
            }
        });
    }

    public void l() {
        if (this.f15031j.compareAndSet(false, true)) {
            a("buffer started", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.bufferStart();
                }
            });
        }
    }

    public void m() {
        if (this.f15031j.compareAndSet(true, false)) {
            a("buffer finished", (Runnable) new Runnable() {
                public void run() {
                    g.this.f15032k.bufferFinish();
                }
            });
        }
    }

    public void n() {
        a("track skipped", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.skipped();
            }
        });
    }

    public void o() {
        a("track clicked", (Runnable) new Runnable() {
            public void run() {
                g.this.f15032k.adUserInteraction(InteractionType.CLICK);
            }
        });
    }
}
