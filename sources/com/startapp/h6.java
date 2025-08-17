package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.startapp.k6;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class h6 implements k6.b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34618a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34619b;

    /* renamed from: c  reason: collision with root package name */
    public final JSONArray f34620c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    public final String f34621d;

    /* renamed from: e  reason: collision with root package name */
    public final String f34622e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34623f;

    public h6(Context context, String str, String str2, String str3, boolean z2) {
        this.f34618a = context;
        this.f34619b = str;
        this.f34621d = str2;
        this.f34622e = str3;
        this.f34623f = z2;
    }

    public void a(VASTErrorCodes vASTErrorCodes) {
        w8 j2;
        if (this.f34620c.length() != 0) {
            if (!this.f34623f || vASTErrorCodes == VASTErrorCodes.ErrorNone) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("vastDocs", this.f34620c);
                    String str = this.f34621d;
                    String str2 = "";
                    if (str == null) {
                        str = str2;
                    }
                    jSONObject.put("partnerResponse", str);
                    String str3 = this.f34622e;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    jSONObject.put("partnerName", str2);
                    jSONObject.put(MRAIDPresenter.ERROR, vASTErrorCodes.a());
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        j2 = ComponentLocator.a(this.f34618a).j();
                        String str4 = this.f34619b;
                        j2.getClass();
                        byte[] bytes = jSONObject2.getBytes();
                        Map<Activity, Integer> map = lb.f34876a;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        j2.a(str4, (q6) null, byteArrayOutputStream.toByteArray(), true, (sa<String, Void>) null);
                    }
                } catch (Throwable th) {
                    y8.a(this.f34618a, th);
                }
            }
        }
    }
}
