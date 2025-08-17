package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.a.a;
import com.applovin.impl.a.d;
import com.applovin.impl.a.h;
import com.applovin.impl.a.n;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.List;

class e extends c {

    /* renamed from: c  reason: collision with root package name */
    private final a f15355c;

    public e(a aVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, mVar, appLovinAdLoadListener);
        this.f15355c = aVar;
    }

    private void j() {
        String str;
        String str2;
        String str3;
        if (!b()) {
            if (this.f15355c.aQ()) {
                d aM = this.f15355c.aM();
                if (aM != null) {
                    h b2 = aM.b();
                    if (b2 != null) {
                        Uri b3 = b2.b();
                        String uri = b3 != null ? b3.toString() : "";
                        String c2 = b2.c();
                        if (URLUtil.isValidUrl(uri) || StringUtils.isValidString(c2)) {
                            if (b2.a() == h.a.STATIC) {
                                if (v.a()) {
                                    a("Caching static companion ad at " + uri + "...");
                                }
                                Uri c3 = c(uri, Collections.emptyList(), false);
                                if (c3 != null) {
                                    b2.a(c3);
                                } else if (v.a()) {
                                    str2 = "Failed to cache static companion ad";
                                } else {
                                    return;
                                }
                            } else if (b2.a() == h.a.HTML) {
                                if (StringUtils.isValidString(uri)) {
                                    if (v.a()) {
                                        a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                                    }
                                    c2 = f(uri);
                                    if (StringUtils.isValidString(c2)) {
                                        if (v.a()) {
                                            str3 = "HTML fetched. Caching HTML now...";
                                        }
                                        b2.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.f15355c));
                                    } else if (v.a()) {
                                        str2 = "Unable to load companion ad resources from " + uri;
                                    } else {
                                        return;
                                    }
                                } else {
                                    if (v.a()) {
                                        str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + c2;
                                    }
                                    b2.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.f15355c));
                                }
                                a(str3);
                                b2.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.f15355c));
                            } else if (b2.a() == h.a.IFRAME && v.a()) {
                                str = "Skip caching of iFrame resource...";
                            } else {
                                return;
                            }
                            this.f15355c.a(true);
                            return;
                        } else if (v.a()) {
                            c("Companion ad does not have any resources attached. Skipping...");
                            return;
                        } else {
                            return;
                        }
                    } else if (v.a()) {
                        str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    } else {
                        return;
                    }
                    d(str2);
                    return;
                } else if (v.a()) {
                    str = "No companion ad provided. Skipping...";
                } else {
                    return;
                }
            } else if (v.a()) {
                str = "Companion ad caching disabled. Skipping...";
            } else {
                return;
            }
            a(str);
        }
    }

    private void k() {
        n n2;
        Uri b2;
        if (!b()) {
            if (this.f15355c.aR()) {
                if (this.f15355c.m() != null && (n2 = this.f15355c.n()) != null && (b2 = n2.b()) != null) {
                    Uri a2 = a(b2.toString(), (List<String>) Collections.emptyList(), false);
                    if (a2 != null) {
                        if (v.a()) {
                            a("Video file successfully cached into: " + a2);
                        }
                        n2.a(a2);
                    } else if (v.a()) {
                        d("Failed to cache video file: " + n2);
                    }
                }
            } else if (v.a()) {
                a("Video caching disabled. Skipping...");
            }
        }
    }

    private void l() {
        String str;
        String str2;
        if (!b()) {
            if (this.f15355c.aP() != null) {
                if (v.a()) {
                    a("Begin caching HTML template. Fetching from " + this.f15355c.aP() + "...");
                }
                str = a(this.f15355c.aP().toString(), this.f15355c.H());
            } else {
                str = this.f15355c.aO();
            }
            if (StringUtils.isValidString(str)) {
                a aVar = this.f15355c;
                aVar.a(a(str, aVar.H(), (com.applovin.impl.sdk.ad.e) this.f15355c));
                if (v.a()) {
                    str2 = "Finish caching HTML template " + this.f15355c.aO() + " for ad #" + this.f15355c.getAdIdNumber();
                } else {
                    return;
                }
            } else if (v.a()) {
                str2 = "Unable to load HTML template";
            } else {
                return;
            }
            a(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f15355c.o().e();
        super.h();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f15355c.o().c();
        super.i();
    }

    public void run() {
        super.run();
        if (this.f15355c.f()) {
            if (v.a()) {
                a("Begin caching for VAST streaming ad #" + this.f15341a.getAdIdNumber() + "...");
            }
            c();
            if (this.f15355c.i()) {
                i();
            }
            a.b g2 = this.f15355c.g();
            a.b bVar = a.b.COMPANION_AD;
            if (g2 == bVar) {
                j();
                l();
            } else {
                k();
            }
            if (!this.f15355c.i()) {
                i();
            }
            if (this.f15355c.g() == bVar) {
                k();
            } else {
                j();
                l();
            }
        } else {
            if (v.a()) {
                a("Begin caching for VAST ad #" + this.f15341a.getAdIdNumber() + "...");
            }
            c();
            j();
            k();
            l();
            i();
        }
        if (v.a()) {
            a("Finished caching VAST ad #" + this.f15355c.getAdIdNumber());
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f15355c.getCreatedAtMillis();
        com.applovin.impl.sdk.d.d.a(this.f15355c, this.f15333b);
        com.applovin.impl.sdk.d.d.a(currentTimeMillis, (AppLovinAdBase) this.f15355c, this.f15333b);
        a((AppLovinAdBase) this.f15355c);
        this.f15355c.b();
        a();
    }
}
