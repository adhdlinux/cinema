package com.vungle.ads.internal.omsdk;

import android.webkit.WebView;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class OMTracker implements WebViewObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long DESTROY_DELAY_MS = TimeUnit.SECONDS.toMillis(1);
    private AdSession adSession;
    private final boolean enabled;
    private boolean started;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDESTROY_DELAY_MS$annotations() {
        }

        public final long getDESTROY_DELAY_MS() {
            return OMTracker.DESTROY_DELAY_MS;
        }
    }

    public static final class Factory {
        public final OMTracker make(boolean z2) {
            return new OMTracker(z2, (DefaultConstructorMarker) null);
        }
    }

    private OMTracker(boolean z2) {
        this.enabled = z2;
    }

    public /* synthetic */ OMTracker(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2);
    }

    public void onPageFinished(WebView webView) {
        Intrinsics.f(webView, "webView");
        if (this.started && this.adSession == null) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            AdSession a2 = AdSession.a(AdSessionConfiguration.a(creativeType, impressionType, owner, owner, false), AdSessionContext.a(Partner.a("Vungle", "7.4.3"), webView, (String) null, (String) null));
            this.adSession = a2;
            if (a2 != null) {
                a2.c(webView);
            }
            AdSession adSession2 = this.adSession;
            if (adSession2 != null) {
                adSession2.d();
            }
        }
    }

    public final void start() {
        if (this.enabled && Omid.b()) {
            this.started = true;
        }
    }

    public final long stop() {
        long j2;
        AdSession adSession2;
        if (!this.started || (adSession2 = this.adSession) == null) {
            j2 = 0;
        } else {
            if (adSession2 != null) {
                adSession2.b();
            }
            j2 = DESTROY_DELAY_MS;
        }
        this.started = false;
        this.adSession = null;
        return j2;
    }
}
