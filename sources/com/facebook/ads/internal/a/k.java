package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.c.g;

public class k extends b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f19663d = "k";

    /* renamed from: e  reason: collision with root package name */
    private final Uri f19664e;

    public k(Context context, c cVar, String str, Uri uri) {
        super(context, cVar, str);
        this.f19664e = uri;
    }

    public a.C0033a a() {
        return a.C0033a.OPEN_LINK;
    }

    public void b() {
        try {
            Log.w("REDIRECTACTION: ", this.f19664e.toString());
            g.a(new g(), this.f19639a, this.f19664e, this.f19641c);
        } catch (Exception e2) {
            String str = f19663d;
            Log.d(str, "Failed to open link url: " + this.f19664e.toString(), e2);
        }
    }
}
