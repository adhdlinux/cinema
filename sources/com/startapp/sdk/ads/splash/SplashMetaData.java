package com.startapp.sdk.ads.splash;

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

public class SplashMetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SplashMetaData f36048a = new SplashMetaData();

    /* renamed from: b  reason: collision with root package name */
    public static Object f36049b = new Object();
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private SplashConfig SplashConfig = new SplashConfig();
    private String splashMetadataUpdateVersion = "4.10.0";

    public SplashConfig a() {
        return this.SplashConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SplashMetaData.class != obj.getClass()) {
            return false;
        }
        SplashMetaData splashMetaData = (SplashMetaData) obj;
        if (!lb.a(this.SplashConfig, splashMetaData.SplashConfig) || !lb.a(this.splashMetadataUpdateVersion, splashMetaData.splashMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.SplashConfig, this.splashMetadataUpdateVersion};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context, SplashMetaData splashMetaData) {
        synchronized (f36049b) {
            splashMetaData.splashMetadataUpdateVersion = "4.10.0";
            f36048a = splashMetaData;
            ra.a(context, "StartappSplashMetadata", (Serializable) splashMetaData);
        }
    }

    public static void a(Context context) {
        SplashMetaData splashMetaData = (SplashMetaData) ra.a(context, "StartappSplashMetadata", SplashMetaData.class);
        SplashMetaData splashMetaData2 = new SplashMetaData();
        if (splashMetaData != null) {
            boolean b2 = lb.b(splashMetaData, splashMetaData2);
            if (!(!"4.10.0".equals(splashMetaData.splashMetadataUpdateVersion)) && b2) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "metadata_null";
                y8Var.a(context);
            }
            f36048a = splashMetaData;
            return;
        }
        f36048a = splashMetaData2;
    }
}
