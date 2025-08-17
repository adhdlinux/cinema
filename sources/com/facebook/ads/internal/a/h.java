package com.facebook.ads.internal.a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.d;
import java.util.HashMap;
import java.util.Map;

public abstract class h extends b {

    /* renamed from: d  reason: collision with root package name */
    protected final l f19656d;

    public h(Context context, c cVar, String str, l lVar) {
        super(context, cVar, str);
        this.f19656d = lVar;
    }

    /* access modifiers changed from: protected */
    public final void a(Map<String, String> map, a aVar) {
        if (!TextUtils.isEmpty(this.f19641c)) {
            if (this instanceof f) {
                this.f19640b.h(this.f19641c, map);
            } else {
                this.f19640b.c(this.f19641c, map);
            }
            boolean a2 = a.a(aVar);
            l lVar = this.f19656d;
            if (lVar != null) {
                lVar.a(aVar);
                if (a2) {
                    this.f19656d.a();
                }
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("leave_time", Long.toString(-1));
                hashMap.put("back_time", Long.toString(-1));
                hashMap.put("outcome", a.CANNOT_TRACK.name());
                this.f19640b.j(this.f19641c, hashMap);
            }
        }
        d.a(this.f19639a, "Click logged");
    }

    public final void b() {
        l lVar = this.f19656d;
        if (lVar != null) {
            lVar.a(this.f19641c);
        }
        e();
    }

    /* access modifiers changed from: package-private */
    public abstract void e();
}
