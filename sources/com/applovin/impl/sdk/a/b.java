package com.applovin.impl.sdk.a;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.List;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected final AppLovinAdBase f15002a;

    /* renamed from: b  reason: collision with root package name */
    protected final m f15003b;

    /* renamed from: c  reason: collision with root package name */
    protected final v f15004c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f15005d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f15006e;

    /* renamed from: f  reason: collision with root package name */
    protected AdSession f15007f;

    /* renamed from: g  reason: collision with root package name */
    protected AdEvents f15008g;

    public b(AppLovinAdBase appLovinAdBase) {
        this.f15002a = appLovinAdBase;
        this.f15003b = appLovinAdBase.getSdk();
        this.f15004c = appLovinAdBase.getSdk().A();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + ":" + appLovinAdBase.getDspName();
        }
        this.f15005d = str;
    }

    /* access modifiers changed from: protected */
    public abstract AdSessionConfiguration a();

    /* access modifiers changed from: protected */
    public abstract AdSessionContext a(WebView webView);

    public void a(View view) {
        a(view, (List<d>) Collections.emptyList());
    }

    public void a(final View view, final List<d> list) {
        a("update main view: " + view, (Runnable) new Runnable() {
            public void run() {
                b.this.f15007f.registerAdView(view);
                b.this.f15007f.removeAllFriendlyObstructions();
                for (d dVar : list) {
                    if (dVar.a() != null) {
                        try {
                            b.this.f15007f.addFriendlyObstruction(dVar.a(), dVar.b(), dVar.c());
                        } catch (Throwable th) {
                            if (v.a()) {
                                b bVar = b.this;
                                v vVar = bVar.f15004c;
                                String str = bVar.f15005d;
                                vVar.b(str, "Failed to add friendly obstruction (" + dVar + ")", th);
                            }
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
    }

    public void a(final String str) {
        a("track error", (Runnable) new Runnable() {
            public void run() {
                b.this.f15007f.error(ErrorType.VIDEO, str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (b.this.f15006e) {
                        if (v.a()) {
                            b bVar = b.this;
                            v vVar = bVar.f15004c;
                            String str = bVar.f15005d;
                            vVar.b(str, "Running operation: " + str);
                        }
                        runnable.run();
                    } else if (v.a()) {
                        b bVar2 = b.this;
                        v vVar2 = bVar2.f15004c;
                        String str2 = bVar2.f15005d;
                        vVar2.e(str2, "Failed to run operation: " + str);
                    }
                } catch (Throwable th) {
                    if (v.a()) {
                        b bVar3 = b.this;
                        v vVar3 = bVar3.f15004c;
                        String str3 = bVar3.f15005d;
                        vVar3.b(str3, "Failed to run operation: " + str, th);
                    }
                }
            }
        });
    }

    public void b() {
        b((WebView) null);
    }

    public void b(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AdSessionContext a2;
                if (!b.this.f15002a.isOpenMeasurementEnabled()) {
                    if (v.a()) {
                        b bVar = b.this;
                        bVar.f15004c.c(bVar.f15005d, "Skip starting session - Open Measurement disabled");
                    }
                } else if (b.this.f15007f == null) {
                    if (v.a()) {
                        b bVar2 = b.this;
                        bVar2.f15004c.b(bVar2.f15005d, "Starting session");
                    }
                    AdSessionConfiguration a3 = b.this.a();
                    if (a3 != null && (a2 = b.this.a(webView)) != null) {
                        try {
                            b.this.f15007f = AdSession.createAdSession(a3, a2);
                            try {
                                b bVar3 = b.this;
                                bVar3.f15008g = AdEvents.createAdEvents(bVar3.f15007f);
                                b bVar4 = b.this;
                                bVar4.a(bVar4.f15007f);
                                b.this.f15007f.start();
                                b.this.f15006e = true;
                                if (v.a()) {
                                    b bVar5 = b.this;
                                    bVar5.f15004c.b(bVar5.f15005d, "Session started");
                                }
                            } catch (Throwable th) {
                                if (v.a()) {
                                    b bVar6 = b.this;
                                    bVar6.f15004c.b(bVar6.f15005d, "Failed to create ad events", th);
                                }
                            }
                        } catch (Throwable th2) {
                            if (v.a()) {
                                b bVar7 = b.this;
                                bVar7.f15004c.b(bVar7.f15005d, "Failed to create session", th2);
                            }
                        }
                    }
                } else if (v.a()) {
                    b bVar8 = b.this;
                    v vVar = bVar8.f15004c;
                    String str = bVar8.f15005d;
                    vVar.d(str, "Attempting to start session again for ad: " + b.this.f15002a);
                }
            }
        });
    }

    public void c() {
        a("track loaded", (Runnable) new Runnable() {
            public void run() {
                b.this.f15008g.loaded();
            }
        });
    }

    public void d() {
        a("track impression event", (Runnable) new Runnable() {
            public void run() {
                b.this.f15008g.impressionOccurred();
            }
        });
    }

    public void e() {
        a("stop session", (Runnable) new Runnable() {
            public void run() {
                b bVar = b.this;
                bVar.f15006e = false;
                bVar.f15007f.finish();
                b.this.f15007f = null;
            }
        });
    }
}
