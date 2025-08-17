package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f15893a = new StringBuilder();

    public k a() {
        this.f15893a.append("\n========================================");
        return this;
    }

    public k a(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String next : bundle.keySet()) {
            a(next, bundle.get(next));
        }
        return this;
    }

    public k a(AppLovinAdView appLovinAdView) {
        return a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).a("Visibility", q.b(appLovinAdView.getVisibility()));
    }

    public k a(a aVar) {
        String str = "None";
        k a2 = a("Network", aVar.M()).a("Format", aVar.getFormat().getLabel()).a("Ad Unit ID", aVar.getAdUnitId()).a("Placement", aVar.getPlacement()).a("Network Placement", aVar.l()).a("Serve ID", aVar.f()).a("Creative ID", StringUtils.isValidString(aVar.getCreativeId()) ? aVar.getCreativeId() : str).a("DSP Name", StringUtils.isValidString(aVar.getDspName()) ? aVar.getDspName() : str);
        if (StringUtils.isValidString(aVar.getDspId())) {
            str = aVar.getDspId();
        }
        return a2.a("DSP ID", str).a("Server Parameters", aVar.U());
    }

    public k a(e eVar) {
        boolean z2 = eVar instanceof com.applovin.impl.a.a;
        a("Format", eVar.getAdZone().b() != null ? eVar.getAdZone().b().getLabel() : null).a("Ad ID", Long.valueOf(eVar.getAdIdNumber())).a("Zone ID", eVar.getAdZone().a()).a("Source", eVar.getSource()).a("Ad Class", z2 ? "VastAd" : "AdServerAd");
        String dspName = eVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            a("DSP Name", dspName);
        }
        if (z2) {
            a("VAST DSP", ((com.applovin.impl.a.a) eVar).l());
        }
        return this;
    }

    public k a(m mVar) {
        return a("Muted", Boolean.valueOf(mVar.p().isMuted())).a("ExoPlayer eligible", Boolean.valueOf(Utils.checkExoPlayerEligibility(mVar)));
    }

    public k a(String str) {
        StringBuilder sb = this.f15893a;
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append(str);
        return this;
    }

    public k a(String str, Object obj) {
        return a(str, obj, "");
    }

    public k a(String str, Object obj, String str2) {
        StringBuilder sb = this.f15893a;
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    public k b(e eVar) {
        a("Target", eVar.p()).a("close_style", eVar.u()).a("close_delay_graphic", Long.valueOf(eVar.s()), "s");
        if (eVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
            a("HTML", aVar.b().substring(0, Math.min(aVar.b().length(), 64)));
        }
        if (eVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(eVar.q()), "s").a("skip_style", eVar.w()).a("Streaming", Boolean.valueOf(eVar.f())).a("Video Location", eVar.d()).a("video_button_properties", eVar.C());
        }
        return this;
    }

    public k b(String str) {
        this.f15893a.append(str);
        return this;
    }

    public String toString() {
        return this.f15893a.toString();
    }
}
