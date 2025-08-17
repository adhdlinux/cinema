package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.r.a;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.Map;

public class aa extends b {

    /* renamed from: c  reason: collision with root package name */
    private final c f19749c;

    /* renamed from: d  reason: collision with root package name */
    private final u f19750d;

    /* renamed from: e  reason: collision with root package name */
    private k f19751e;

    public aa(Context context, c cVar, a aVar, u uVar, c cVar2) {
        super(context, cVar2, aVar);
        this.f19749c = cVar;
        this.f19750d = uVar;
    }

    public void a(k kVar) {
        this.f19751e = kVar;
    }

    /* access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        k kVar = this.f19751e;
        if (kVar != null && !TextUtils.isEmpty(kVar.g())) {
            map.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(this.f19750d.e()));
            this.f19749c.a(this.f19751e.g(), map);
        }
    }
}
