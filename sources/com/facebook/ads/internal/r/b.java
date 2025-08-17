package com.facebook.ads.internal.r;

import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f20779a;

    /* renamed from: b  reason: collision with root package name */
    private float f20780b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f20781c;

    public b(c cVar) {
        this(cVar, 0.0f);
    }

    public b(c cVar, float f2) {
        this(cVar, f2, (Map<String, String>) null);
    }

    public b(c cVar, float f2, Map<String, String> map) {
        this.f20779a = cVar;
        this.f20780b = f2;
        if (map != null) {
            this.f20781c = map;
        } else {
            this.f20781c = new HashMap();
        }
    }

    public boolean a() {
        return this.f20779a == c.IS_VIEWABLE;
    }

    public int b() {
        return this.f20779a.a();
    }

    public float c() {
        return this.f20780b;
    }

    public Map<String, String> d() {
        return this.f20781c;
    }
}
