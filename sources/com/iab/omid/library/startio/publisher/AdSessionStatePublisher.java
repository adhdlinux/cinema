package com.iab.omid.library.startio.publisher;

import android.os.Build;
import android.webkit.WebView;
import com.startapp.fg;
import com.startapp.j;
import com.startapp.l;
import com.startapp.og;
import com.startapp.r;
import com.startapp.t;
import com.startapp.u;
import com.startapp.x;
import com.startapp.y;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a  reason: collision with root package name */
    public og f31609a = new og((WebView) null);

    /* renamed from: b  reason: collision with root package name */
    public r f31610b;

    /* renamed from: c  reason: collision with root package name */
    public y f31611c;

    /* renamed from: d  reason: collision with root package name */
    public a f31612d;

    /* renamed from: e  reason: collision with root package name */
    public long f31613e;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        a();
    }

    public void a() {
        this.f31613e = System.nanoTime();
        this.f31612d = a.AD_STATE_IDLE;
    }

    public void a(WebView webView) {
        this.f31609a = new og(webView);
    }

    public void a(x xVar, u uVar) {
        a(xVar, uVar, (JSONObject) null);
    }

    public void b() {
        this.f31609a.clear();
    }

    public WebView c() {
        return (WebView) this.f31609a.get();
    }

    public void d() {
    }

    public void a(t tVar) {
        l lVar = l.f34848a;
        WebView c2 = c();
        tVar.getClass();
        JSONObject jSONObject = new JSONObject();
        fg.a(jSONObject, "impressionOwner", tVar.f36536a);
        fg.a(jSONObject, "mediaEventsOwner", tVar.f36537b);
        fg.a(jSONObject, "creativeType", tVar.f36539d);
        fg.a(jSONObject, "impressionType", tVar.f36540e);
        fg.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(tVar.f36538c));
        lVar.a(c2, "init", jSONObject);
    }

    public void a(x xVar, u uVar, JSONObject jSONObject) {
        String str = xVar.f36853i;
        JSONObject jSONObject2 = new JSONObject();
        fg.a(jSONObject2, "environment", "app");
        fg.a(jSONObject2, "adSessionType", uVar.f36599h);
        JSONObject jSONObject3 = new JSONObject();
        fg.a(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        fg.a(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        fg.a(jSONObject3, "os", "Android");
        fg.a(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        fg.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        fg.a(jSONObject4, "partnerName", uVar.f36592a.f36687a);
        fg.a(jSONObject4, "partnerVersion", uVar.f36592a.f36688b);
        fg.a(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        fg.a(jSONObject5, "libraryVersion", "1.3.31-Startio");
        fg.a(jSONObject5, "appId", j.f34712a.f34713b.getApplicationContext().getPackageName());
        fg.a(jSONObject2, "app", jSONObject5);
        String str2 = uVar.f36598g;
        if (str2 != null) {
            fg.a(jSONObject2, "contentUrl", str2);
        }
        String str3 = uVar.f36597f;
        if (str3 != null) {
            fg.a(jSONObject2, "customReferenceData", str3);
        }
        JSONObject jSONObject6 = new JSONObject();
        for (T t2 : Collections.unmodifiableList(uVar.f36594c)) {
            fg.a(jSONObject6, t2.f36754a, t2.f36756c);
        }
        l.f34848a.a(c(), "startSession", str, jSONObject2, jSONObject6, jSONObject);
    }
}
