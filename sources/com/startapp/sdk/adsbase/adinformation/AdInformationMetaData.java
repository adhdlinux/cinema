package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.content.Context;
import com.startapp.j0;
import com.startapp.lb;
import com.startapp.ra;
import com.startapp.sdk.adsbase.adinformation.AdInformationConfig;
import com.startapp.y8;
import com.startapp.z8;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class AdInformationMetaData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile AdInformationMetaData f36260a = new AdInformationMetaData();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f36261b = new Object();
    private static final long serialVersionUID = 1;
    @j0(complex = true)
    private AdInformationConfig AdInformation = AdInformationConfig.a();
    private String adInformationMetadataUpdateVersion = "4.10.0";

    public AdInformationConfig a() {
        return this.AdInformation;
    }

    public String b() {
        return this.AdInformation.d();
    }

    public String c() {
        AdInformationConfig adInformationConfig = this.AdInformation;
        EnumMap<AdInformationConfig.ImageResourceType, ImageResourceConfig> enumMap = adInformationConfig.f36259b;
        AdInformationConfig.ImageResourceType imageResourceType = AdInformationConfig.ImageResourceType.INFO_L;
        if (!enumMap.containsKey(imageResourceType) || adInformationConfig.f36259b.get(imageResourceType).b().equals("")) {
            return "https://info.startappservice.com/InApp/resources/info_l.png";
        }
        return adInformationConfig.f36259b.get(imageResourceType).b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdInformationMetaData.class != obj.getClass()) {
            return false;
        }
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) obj;
        if (!lb.a(this.AdInformation, adInformationMetaData.AdInformation) || !lb.a(this.adInformationMetadataUpdateVersion, adInformationMetaData.adInformationMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.AdInformation, this.adInformationMetadataUpdateVersion};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context) {
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) ra.a(context, "StartappAdInfoMetadata", AdInformationMetaData.class);
        AdInformationMetaData adInformationMetaData2 = new AdInformationMetaData();
        if (adInformationMetaData != null) {
            boolean b2 = lb.b(adInformationMetaData, adInformationMetaData2);
            if (!(!"4.10.0".equals(adInformationMetaData.adInformationMetadataUpdateVersion)) && b2) {
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "metadata_null";
                y8Var.a(context);
            }
            AdInformationConfig adInformationConfig = adInformationMetaData.AdInformation;
            adInformationConfig.getClass();
            adInformationConfig.f36259b = new EnumMap<>(AdInformationConfig.ImageResourceType.class);
            f36260a = adInformationMetaData;
        } else {
            f36260a = adInformationMetaData2;
        }
        f36260a.AdInformation.a(context);
    }

    public static void a(Context context, AdInformationMetaData adInformationMetaData) {
        synchronized (f36261b) {
            adInformationMetaData.adInformationMetadataUpdateVersion = "4.10.0";
            f36260a = adInformationMetaData;
            AdInformationConfig.a(f36260a.AdInformation);
            f36260a.AdInformation.a(context);
            ra.a(context, "StartappAdInfoMetadata", (Serializable) adInformationMetaData);
        }
    }
}
