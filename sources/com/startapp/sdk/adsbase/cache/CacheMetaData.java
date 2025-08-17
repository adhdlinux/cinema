package com.startapp.sdk.adsbase.cache;

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

public class CacheMetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile CacheMetaData f36308a = new CacheMetaData();
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private ACMConfig ACM = new ACMConfig();
    private String cacheMetaDataUpdateVersion = "4.10.0";
    private float sendCacheSizeProb = 20.0f;

    public static CacheMetaData b() {
        return f36308a;
    }

    public ACMConfig a() {
        return this.ACM;
    }

    public float c() {
        return this.sendCacheSizeProb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CacheMetaData.class != obj.getClass()) {
            return false;
        }
        CacheMetaData cacheMetaData = (CacheMetaData) obj;
        if (Float.compare(cacheMetaData.sendCacheSizeProb, this.sendCacheSizeProb) != 0 || !lb.a(this.ACM, cacheMetaData.ACM) || !lb.a(this.cacheMetaDataUpdateVersion, cacheMetaData.cacheMetaDataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.ACM, Float.valueOf(this.sendCacheSizeProb), this.cacheMetaDataUpdateVersion};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context, CacheMetaData cacheMetaData) {
        cacheMetaData.cacheMetaDataUpdateVersion = "4.10.0";
        f36308a = cacheMetaData;
        ra.a(context, "StartappCacheMetadata", (Serializable) cacheMetaData);
    }

    public static void a(Context context) {
        CacheMetaData cacheMetaData = (CacheMetaData) ra.a(context, "StartappCacheMetadata", CacheMetaData.class);
        CacheMetaData cacheMetaData2 = new CacheMetaData();
        if (cacheMetaData != null) {
            boolean b2 = lb.b(cacheMetaData, cacheMetaData2);
            if (!(!"4.10.0".equals(cacheMetaData.cacheMetaDataUpdateVersion)) && b2) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "metadata_null";
                y8Var.a(context);
            }
            f36308a = cacheMetaData;
            return;
        }
        f36308a = cacheMetaData2;
    }
}
