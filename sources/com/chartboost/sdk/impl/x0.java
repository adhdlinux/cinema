package com.chartboost.sdk.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.Analytics;
import com.chartboost.sdk.impl.t2;
import com.google.android.gms.cast.MediaTrack;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public final qa f18922a;

    /* renamed from: b  reason: collision with root package name */
    public final q2 f18923b;

    /* renamed from: c  reason: collision with root package name */
    public final ca f18924c;

    /* renamed from: d  reason: collision with root package name */
    public final z4 f18925d;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18926a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.chartboost.sdk.Analytics$IAPType[] r0 = com.chartboost.sdk.Analytics.IAPType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.Analytics$IAPType r1 = com.chartboost.sdk.Analytics.IAPType.GOOGLE_PLAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.Analytics$IAPType r1 = com.chartboost.sdk.Analytics.IAPType.AMAZON     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f18926a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.x0.a.<clinit>():void");
        }
    }

    public x0(qa qaVar, q2 q2Var, ca caVar, z4 z4Var) {
        Intrinsics.f(qaVar, "sdkInitializer");
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(z4Var, "eventTracker");
        this.f18922a = qaVar;
        this.f18923b = q2Var;
        this.f18924c = caVar;
        this.f18925d = z4Var;
    }

    public final void a(String str, Analytics.LevelType levelType, int i2, int i3, String str2, long j2) {
        Intrinsics.f(str, "eventLabel");
        Intrinsics.f(levelType, "type");
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        try {
            if (!a()) {
                w7.b("AnalyticsApi", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            } else if (str.length() == 0) {
                w7.b("AnalyticsApi", "Invalid value: event label cannot be empty or null");
            } else {
                if (i2 >= 0) {
                    if (i3 >= 0) {
                        if (str2.length() == 0) {
                            w7.b("AnalyticsApi", "Invalid value: description cannot be empty or null");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event_label", str);
                        jSONObject.put("event_field", levelType.getLevelType());
                        jSONObject.put("main_level", i2);
                        jSONObject.put("sub_level", i3);
                        jSONObject.put(MediaTrack.ROLE_DESCRIPTION, str2);
                        jSONObject.put("timestamp", j2);
                        jSONObject.put("data_type", "level_info");
                        jSONArray.put(jSONObject);
                        a(jSONArray);
                        return;
                    }
                }
                w7.b("AnalyticsApi", "Invalid value: Level number should be > 0");
            }
        } catch (Exception e2) {
            w7.b("AnalyticsApi", e2.toString());
        }
    }

    public final JSONObject b(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            w7.b("AnalyticsApi", "Null object is passed for for purchase data or purchase signature");
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("purchaseData", str);
        jSONObject.put("purchaseSignature", str2);
        jSONObject.put("type", Analytics.IAPType.GOOGLE_PLAY.ordinal());
        return jSONObject;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Analytics.IAPType iAPType) {
        JSONObject jSONObject;
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str4;
        String str14 = str5;
        Intrinsics.f(str, "productID");
        Intrinsics.f(str2, "title");
        Intrinsics.f(str12, MediaTrack.ROLE_DESCRIPTION);
        Intrinsics.f(str13, InAppPurchaseMetaData.KEY_PRICE);
        Intrinsics.f(str14, "currency");
        Intrinsics.f(iAPType, "iapType");
        try {
            if (!a()) {
                w7.b("AnalyticsApi", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
                return;
            }
            float a2 = a(str13);
            if (a2 != -1.0f) {
                int i2 = a.f18926a[iAPType.ordinal()];
                if (i2 == 1) {
                    jSONObject = b(str6, str7);
                } else if (i2 == 2) {
                    jSONObject = a(str8, str9);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (jSONObject.length() == 0) {
                    w7.b("AnalyticsApi", "Error while parsing the receipt to a JSON Object, ");
                    return;
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.e(jSONObject2, "receipt.toString()");
                byte[] bytes = jSONObject2.getBytes(Charsets.f40513b);
                Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("localized-title", str2);
                jSONObject3.put("localized-description", str12);
                jSONObject3.put(InAppPurchaseMetaData.KEY_PRICE, Float.valueOf(a2));
                jSONObject3.put("currency", str14);
                jSONObject3.put("productID", str);
                jSONObject3.put("receipt", encodeToString);
                a(jSONObject3);
            }
        } catch (Exception e2) {
            w7.b("AnalyticsApi", e2.toString());
        }
    }

    public final boolean a() {
        return this.f18922a.e();
    }

    public final JSONObject a(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            w7.b("AnalyticsApi", "Null object is passed for for amazon user id or amazon purchase token");
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userID", str);
        jSONObject.put("purchaseToken", str2);
        jSONObject.put("type", Analytics.IAPType.AMAZON.ordinal());
        return jSONObject;
    }

    public final float a(String str) {
        try {
            Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(str);
            matcher.find();
            String group = matcher.group();
            if (TextUtils.isEmpty(group)) {
                w7.b("AnalyticsApi", "Invalid price object");
                return -1.0f;
            }
            Intrinsics.e(group, "result");
            return Float.parseFloat(group);
        } catch (IllegalStateException unused) {
            w7.b("AnalyticsApi", "Invalid price object");
            return -1.0f;
        }
    }

    public final void a(JSONObject jSONObject) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format(Locale.US, "%s%s", Arrays.copyOf(new Object[]{"/post-install-event/", "iap"}, 2));
        Intrinsics.e(format, "format(locale, format, *args)");
        t2 t2Var = new t2("https://live.chartboost.com", format, this.f18924c.a(), i9.NORMAL, "iap", (t2.a) null, this.f18925d);
        t2Var.a("iap", (Object) jSONObject);
        t2Var.f18627r = true;
        this.f18923b.a(t2Var);
    }

    public final void a(JSONArray jSONArray) {
        t2 t2Var = new t2("https://live.chartboost.com", "/post-install-event/tracking", this.f18924c.a(), i9.NORMAL, "tracking", (t2.a) null, this.f18925d);
        t2Var.a("track_info", (Object) jSONArray);
        t2Var.f18627r = true;
        this.f18923b.a(t2Var);
    }
}
