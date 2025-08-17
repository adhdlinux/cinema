package com.startapp;

import android.webkit.WebView;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final v f36592a;

    /* renamed from: b  reason: collision with root package name */
    public final WebView f36593b;

    /* renamed from: c  reason: collision with root package name */
    public final List<w> f36594c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, w> f36595d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final String f36596e;

    /* renamed from: f  reason: collision with root package name */
    public final String f36597f;

    /* renamed from: g  reason: collision with root package name */
    public final String f36598g;

    /* renamed from: h  reason: collision with root package name */
    public final AdSessionContextType f36599h;

    public u(v vVar, WebView webView, String str, List<w> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.f36594c = arrayList;
        this.f36592a = vVar;
        this.f36593b = webView;
        this.f36596e = str;
        this.f36599h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (w put : list) {
                String uuid = UUID.randomUUID().toString();
                this.f36595d.put(uuid, put);
            }
        }
        this.f36598g = str2;
        this.f36597f = str3;
    }

    public AdSessionContextType a() {
        return this.f36599h;
    }

    public Map<String, w> b() {
        return Collections.unmodifiableMap(this.f36595d);
    }

    public String c() {
        return this.f36596e;
    }

    public WebView d() {
        return this.f36593b;
    }
}
