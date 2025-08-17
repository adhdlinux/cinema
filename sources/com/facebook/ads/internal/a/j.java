package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.m.e;
import java.util.Map;

class j extends b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f19660d = "j";

    /* renamed from: e  reason: collision with root package name */
    private final Uri f19661e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f19662f;

    j(Context context, c cVar, String str, Uri uri, Map<String, String> map) {
        super(context, cVar, str);
        this.f19661e = uri;
        this.f19662f = map;
    }

    public a.C0033a a() {
        return null;
    }

    public void b() {
        e eVar = e.IMMEDIATE;
        String queryParameter = this.f19661e.getQueryParameter("priority");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                eVar = e.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception unused) {
            }
        }
        this.f19640b.a(this.f19641c, this.f19662f, this.f19661e.getQueryParameter("type"), eVar);
    }
}
