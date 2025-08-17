package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.c.g;
import java.util.Map;

class i extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final String f19657e = "i";

    /* renamed from: f  reason: collision with root package name */
    private final Uri f19658f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f19659g;

    i(Context context, c cVar, String str, Uri uri, Map<String, String> map, l lVar) {
        super(context, cVar, str, lVar);
        this.f19658f = uri;
        this.f19659g = map;
    }

    public a.C0033a a() {
        return a.C0033a.OPEN_LINK;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a aVar;
        try {
            g.a(new g(), this.f19639a, Uri.parse(this.f19658f.getQueryParameter("link")), this.f19641c);
            aVar = null;
        } catch (Exception e2) {
            String str = f19657e;
            Log.d(str, "Failed to open link url: " + this.f19658f.toString(), e2);
            aVar = a.CANNOT_OPEN;
        }
        a(this.f19659g, aVar);
    }
}
