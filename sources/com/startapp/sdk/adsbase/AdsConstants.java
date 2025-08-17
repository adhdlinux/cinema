package com.startapp.sdk.adsbase;

import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

public class AdsConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36187a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f36188b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f36189c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f36190d = "trackdownload";

    /* renamed from: e  reason: collision with root package name */
    public static final String f36191e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f36192f = "https://imp.startappservice.com/tracking/adImpression";

    /* renamed from: g  reason: collision with root package name */
    public static final Boolean f36193g;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f36194h;

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f36195i = {"back_", "back_dark", "browser_icon_dark", "forward_", "forward_dark", "x_dark"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f36196j = {"empty_star", "filled_star", "half_star"};

    public enum AdApiType {
        HTML,
        JSON
    }

    static {
        String str = "get";
        f36187a = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ads");
        f36188b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("htmlad");
        f36189c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("adsmetadata");
        f36191e = sb3.toString();
        Boolean bool = Boolean.FALSE;
        f36193g = bool;
        f36194h = bool;
    }

    public static String a(AdApiType adApiType, AdPreferences.Placement placement) {
        String str;
        String str2;
        String str3;
        String str4;
        int ordinal = adApiType.ordinal();
        if (ordinal == 0) {
            str4 = f36189c;
            str3 = MetaData.f36379h.a(placement);
        } else if (ordinal != 1) {
            str2 = null;
            str = null;
            return str2 + str;
        } else {
            str4 = f36188b;
            str3 = MetaData.f36379h.a(placement);
        }
        String str5 = str3;
        str = str4;
        str2 = str5;
        return str2 + str;
    }
}
