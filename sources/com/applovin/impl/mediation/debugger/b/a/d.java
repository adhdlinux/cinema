package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.b.b;

public class d implements Comparable<d> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14502a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14503b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14504c;

    /* renamed from: d  reason: collision with root package name */
    private final b f14505d;

    d(String str, String str2, boolean z2, b bVar) {
        this.f14502a = str;
        this.f14503b = str2;
        this.f14504c = z2;
        this.f14505d = bVar;
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        return this.f14503b.compareToIgnoreCase(dVar.f14503b);
    }

    public String a() {
        return this.f14502a;
    }

    public String b() {
        return this.f14503b;
    }

    public b c() {
        return this.f14505d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f14502a;
        if (str == null ? dVar.f14502a != null : !str.equals(dVar.f14502a)) {
            return false;
        }
        String str2 = this.f14503b;
        if (str2 == null ? dVar.f14503b == null : str2.equals(dVar.f14503b)) {
            return this.f14504c == dVar.f14504c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f14502a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f14503b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + (this.f14504c ? 1 : 0);
    }
}
