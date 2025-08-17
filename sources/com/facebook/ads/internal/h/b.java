package com.facebook.ads.internal.h;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f20175a;

    /* renamed from: b  reason: collision with root package name */
    public String f20176b;

    /* renamed from: c  reason: collision with root package name */
    public String f20177c;

    /* renamed from: d  reason: collision with root package name */
    public Date f20178d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20179e;

    public b(String str, String str2, String str3, Date date) {
        this.f20175a = str;
        this.f20176b = str2;
        this.f20177c = str3;
        this.f20178d = date;
        this.f20179e = (str2 == null || str3 == null) ? false : true;
    }

    public b(JSONObject jSONObject) {
        this(jSONObject.optString(ImagesContract.URL), jSONObject.optString("key"), jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE), new Date(jSONObject.optLong("expiration") * 1000));
    }

    public static List<b> a(String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                jSONObject = jSONArray.getJSONObject(i2);
            } catch (JSONException unused2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                arrayList.add(new b(jSONObject));
            }
        }
        return arrayList;
    }

    public String a() {
        Date date = this.f20178d;
        if (date == null) {
            date = new Date();
            date.setTime(date.getTime() + 3600000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    public boolean b() {
        return (this.f20176b == null || this.f20177c == null || this.f20175a == null) ? false : true;
    }
}
