package com.startapp.sdk.ads.banner;

import android.app.Activity;
import android.content.Context;
import com.startapp.j0;
import com.startapp.lb;
import com.startapp.ra;
import com.startapp.y8;
import com.startapp.z8;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class BannerMetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static Object f35888a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile BannerMetaData f35889b = new BannerMetaData();
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private BannerOptions BannerOptions = new BannerOptions();
    private String bannerMetadataUpdateVersion = "4.10.0";

    public BannerOptions a() {
        return this.BannerOptions;
    }

    public BannerOptions b() {
        return new BannerOptions(this.BannerOptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BannerMetaData.class != obj.getClass()) {
            return false;
        }
        BannerMetaData bannerMetaData = (BannerMetaData) obj;
        if (!lb.a(this.BannerOptions, bannerMetaData.BannerOptions) || !lb.a(this.bannerMetadataUpdateVersion, bannerMetaData.bannerMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.BannerOptions, this.bannerMetadataUpdateVersion};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context, BannerMetaData bannerMetaData) {
        synchronized (f35888a) {
            bannerMetaData.bannerMetadataUpdateVersion = "4.10.0";
            f35889b = bannerMetaData;
            ra.a(context, "StartappBannerMetadata", (Serializable) bannerMetaData);
        }
    }

    public static void a(Context context) {
        BannerMetaData bannerMetaData = (BannerMetaData) ra.a(context, "StartappBannerMetadata", BannerMetaData.class);
        BannerMetaData bannerMetaData2 = new BannerMetaData();
        if (bannerMetaData != null) {
            boolean b2 = lb.b(bannerMetaData, bannerMetaData2);
            if (!(!"4.10.0".equals(bannerMetaData.bannerMetadataUpdateVersion)) && b2) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "metadata_null";
                y8Var.a(context);
            }
            f35889b = bannerMetaData;
            return;
        }
        f35889b = bannerMetaData2;
    }
}
