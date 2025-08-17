package com.startapp.sdk.ads.offerWall.offerWallJson;

import android.content.Context;
import android.content.Intent;
import com.facebook.react.uimanager.ViewProps;
import com.startapp.l4;
import com.startapp.lb;
import com.startapp.m4;
import com.startapp.o6;
import com.startapp.s4;
import com.startapp.sdk.ads.list3d.List3DActivity;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.v6;
import com.startapp.y8;
import com.vungle.ads.internal.Constants;
import java.util.UUID;

public class OfferWall3DAd extends JsonAd implements v6 {

    /* renamed from: c  reason: collision with root package name */
    public static String f36020c = null;
    private static final long serialVersionUID = 1;
    private final String uuid = UUID.randomUUID().toString();

    public OfferWall3DAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
        if (f36020c == null) {
            f36020c = lb.a(context);
        }
    }

    public boolean a(String str) {
        l4 a2 = m4.f34897a.a(this.uuid);
        a2.f34856c = "&position=" + o6.a();
        ActivityExtra activityExtra = this.activityExtra;
        boolean a3 = activityExtra != null ? activityExtra.a() : false;
        if (super.d()) {
            a(NotDisplayedReason.AD_EXPIRED);
            return false;
        }
        Intent intent = new Intent(this.f36173b, List3DActivity.class);
        intent.putExtra("adInfoOverride", getAdInfoOverride());
        intent.putExtra(Constants.TEMPLATE_TYPE_FULLSCREEN, a3);
        intent.putExtra("adTag", str);
        intent.putExtra("lastLoadTime", super.b());
        intent.putExtra("adCacheTtl", super.c());
        intent.putExtra(ViewProps.POSITION, o6.a());
        intent.putExtra("listModelUuid", this.uuid);
        intent.addFlags(343932928);
        try {
            this.f36173b.startActivity(intent);
            if (AdsConstants.f36193g.booleanValue()) {
                return true;
            }
            setState(Ad.AdState.UN_INITIALIZED);
            return true;
        } catch (Throwable th) {
            y8.a(this.f36173b, th);
            return false;
        }
    }

    public Long b() {
        return super.b();
    }

    public Long c() {
        return super.c();
    }

    public boolean d() {
        return super.d();
    }

    public String h() {
        return this.uuid;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new s4(this.f36173b, this, adPreferences, adEventListener).c();
    }

    public boolean a() {
        return super.a();
    }

    public void a(boolean z2) {
        super.a(z2);
    }
}
