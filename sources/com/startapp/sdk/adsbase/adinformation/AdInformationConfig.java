package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.content.Context;
import com.startapp.i7;
import com.startapp.j0;
import com.startapp.la;
import com.startapp.lb;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdInformationConfig implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36258a = "https://funnel-assets.startappservice.com/consent/index.html";
    private static final long serialVersionUID = 8911501868319500986L;
    @j0(type = ArrayList.class, value = ImageResourceConfig.class)
    private List<ImageResourceConfig> ImageResources = new ArrayList();
    @j0(key = AdPreferences.Placement.class, type = HashMap.class, value = AdInformationPositions.Position.class)
    public HashMap<AdPreferences.Placement, AdInformationPositions.Position> Positions = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public transient EnumMap<ImageResourceType, ImageResourceConfig> f36259b = new EnumMap<>(ImageResourceType.class);
    private Integer consentTypeInfo;
    private String dialogUrlSecured = f36258a;
    private boolean enabled = true;
    private String eulaUrlSecured = "https://www.startapp.com/policy/privacy-policy/";
    private float fatFingersFactor = 200.0f;

    public enum ImageResourceType {
        INFO_S(17, 14),
        INFO_EX_S(88, 14),
        INFO_L(25, 21),
        INFO_EX_L(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 21);
        
        private final int height;
        private final int width;

        private ImageResourceType(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }

        public static ImageResourceType getByName(String str) {
            ImageResourceType imageResourceType = INFO_S;
            ImageResourceType[] values = values();
            for (int i2 = 0; i2 < 4; i2++) {
                ImageResourceType imageResourceType2 = values[i2];
                if (imageResourceType2.name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    imageResourceType = imageResourceType2;
                }
            }
            return imageResourceType;
        }

        public int getDefaultHeight() {
            return this.height;
        }

        public int getDefaultWidth() {
            return this.width;
        }
    }

    public static void a(AdInformationConfig adInformationConfig) {
        boolean z2;
        adInformationConfig.getClass();
        ImageResourceType[] values = ImageResourceType.values();
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            ImageResourceType imageResourceType = values[i3];
            ImageResourceConfig imageResourceConfig = adInformationConfig.f36259b.get(imageResourceType);
            if (imageResourceConfig == null) {
                imageResourceConfig = ImageResourceConfig.a(imageResourceType.name());
                Iterator<ImageResourceConfig> it2 = adInformationConfig.ImageResources.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (ImageResourceType.getByName(it2.next().c()).equals(imageResourceType)) {
                            z2 = false;
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
                adInformationConfig.f36259b.put(imageResourceType, imageResourceConfig);
                if (z2) {
                    adInformationConfig.ImageResources.add(imageResourceConfig);
                }
            }
            imageResourceConfig.b(imageResourceType.getDefaultWidth());
            imageResourceConfig.a(imageResourceType.getDefaultHeight());
            imageResourceConfig.b(imageResourceType.name().toLowerCase() + ".png");
        }
        ImageResourceType[] values2 = ImageResourceType.values();
        while (i2 < 4) {
            ImageResourceType imageResourceType2 = values2[i2];
            if (adInformationConfig.f36259b.get(imageResourceType2) != null) {
                i2++;
            } else {
                throw new IllegalArgumentException("AdInformation error in ImageResource [" + imageResourceType2 + "] cannot be found in MetaData");
            }
        }
    }

    public Integer b() {
        return this.consentTypeInfo;
    }

    public String c() {
        String str = this.dialogUrlSecured;
        return str != null ? str : f36258a;
    }

    public String d() {
        String str = this.eulaUrlSecured;
        if (str == null || str.equals("")) {
            return "https://www.startapp.com/policy/privacy-policy/";
        }
        return this.eulaUrlSecured;
    }

    public float e() {
        return this.fatFingersFactor / 100.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdInformationConfig.class != obj.getClass()) {
            return false;
        }
        AdInformationConfig adInformationConfig = (AdInformationConfig) obj;
        if (this.enabled != adInformationConfig.enabled || Float.compare(adInformationConfig.fatFingersFactor, this.fatFingersFactor) != 0 || !lb.a(this.consentTypeInfo, adInformationConfig.consentTypeInfo) || !lb.a(this.dialogUrlSecured, adInformationConfig.dialogUrlSecured) || !lb.a(this.eulaUrlSecured, adInformationConfig.eulaUrlSecured) || !lb.a(this.Positions, adInformationConfig.Positions) || !lb.a(this.ImageResources, adInformationConfig.ImageResources)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.enabled), this.consentTypeInfo, Float.valueOf(this.fatFingersFactor), this.dialogUrlSecured, this.eulaUrlSecured, this.Positions, this.ImageResources};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public boolean b(Context context) {
        if (ComponentLocator.a(context).d().getBoolean("userDisabledAdInformation", false) || !this.enabled) {
            return false;
        }
        return true;
    }

    public static AdInformationConfig a() {
        AdInformationConfig adInformationConfig = new AdInformationConfig();
        a(adInformationConfig);
        return adInformationConfig;
    }

    public void a(Context context) {
        for (ImageResourceConfig next : this.ImageResources) {
            this.f36259b.put(ImageResourceType.getByName(next.c()), next);
            next.f36279a = null;
            new la(context, next.b(), new i7(next), 0).a();
        }
    }
}
