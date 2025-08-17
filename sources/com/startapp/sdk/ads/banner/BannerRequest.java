package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandard;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class BannerRequest {
    private BannerFormat adFormat = BannerFormat.BANNER;
    private AdPreferences adPreferences;
    private Point adSizeDp;
    private final Context context;

    public interface Callback {
        void onFinished(BannerCreator bannerCreator, String str);
    }

    public class a implements AdEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callback f35890a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BannerFormat f35891b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdPreferences f35892c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BannerStandardAd f35893d;

        /* renamed from: com.startapp.sdk.ads.banner.BannerRequest$a$a  reason: collision with other inner class name */
        public class C0058a implements BannerCreator {

            /* renamed from: a  reason: collision with root package name */
            public boolean f35894a;

            public C0058a() {
            }

            public View create(Context context, BannerListener bannerListener) {
                BannerStandard bannerStandard;
                if (!this.f35894a) {
                    int ordinal = a.this.f35891b.ordinal();
                    if (ordinal == 1) {
                        a aVar = a.this;
                        bannerStandard = new Mrec(context, false, aVar.f35892c, aVar.f35893d);
                    } else if (ordinal != 2) {
                        a aVar2 = a.this;
                        bannerStandard = new Banner(context, false, aVar2.f35892c, aVar2.f35893d);
                    } else {
                        a aVar3 = a.this;
                        bannerStandard = new Cover(context, false, aVar3.f35892c, aVar3.f35893d);
                    }
                    bannerStandard.setBannerListener(bannerListener);
                    bannerStandard.onReceiveAd(a.this.f35893d);
                    this.f35894a = true;
                    return bannerStandard;
                }
                throw new IllegalStateException();
            }
        }

        public a(BannerRequest bannerRequest, Callback callback, BannerFormat bannerFormat, AdPreferences adPreferences, BannerStandardAd bannerStandardAd) {
            this.f35890a = callback;
            this.f35891b = bannerFormat;
            this.f35892c = adPreferences;
            this.f35893d = bannerStandardAd;
        }

        public void onFailedToReceiveAd(Ad ad) {
            this.f35890a.onFinished((BannerCreator) null, String.valueOf(this.f35893d.getErrorMessage()));
        }

        public void onReceiveAd(Ad ad) {
            this.f35890a.onFinished(new C0058a(), (String) null);
        }
    }

    public BannerRequest(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public void load(Callback callback) {
        int i2;
        int i3;
        AdPreferences adPreferences2 = this.adPreferences;
        if (adPreferences2 == null) {
            adPreferences2 = new AdPreferences();
        }
        BannerStandardAd bannerStandardAd = new BannerStandardAd(this.context, 0);
        BannerFormat bannerFormat = this.adFormat;
        Point point = this.adSizeDp;
        if (point != null) {
            i2 = point.x;
            i3 = point.y;
        } else {
            i2 = bannerFormat.widthDp;
            i3 = bannerFormat.heightDp;
        }
        bannerStandardAd.c(bannerFormat.type);
        bannerStandardAd.a(i2, i3);
        bannerStandardAd.load(adPreferences2, new a(this, callback, bannerFormat, adPreferences2, bannerStandardAd), true);
    }

    public BannerRequest setAdFormat(BannerFormat bannerFormat) {
        this.adFormat = bannerFormat;
        return this;
    }

    public BannerRequest setAdPreferences(AdPreferences adPreferences2) {
        this.adPreferences = adPreferences2;
        return this;
    }

    public BannerRequest setAdSize(int i2, int i3) {
        this.adSizeDp = new Point(i2, i3);
        return this;
    }
}
