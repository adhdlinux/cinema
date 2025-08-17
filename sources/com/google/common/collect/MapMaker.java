package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class MapMaker {

    /* renamed from: a  reason: collision with root package name */
    boolean f30565a;

    /* renamed from: b  reason: collision with root package name */
    int f30566b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f30567c = -1;

    /* renamed from: d  reason: collision with root package name */
    MapMakerInternalMap.Strength f30568d;

    /* renamed from: e  reason: collision with root package name */
    MapMakerInternalMap.Strength f30569e;

    /* renamed from: f  reason: collision with root package name */
    Equivalence<Object> f30570f;

    /* access modifiers changed from: package-private */
    public int a() {
        int i2 = this.f30567c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        int i2 = this.f30566b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) MoreObjects.a(this.f30570f, d().b());
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength d() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f30568d, MapMakerInternalMap.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f30569e, MapMakerInternalMap.Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> f() {
        if (!this.f30565a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return MapMakerInternalMap.b(this);
    }

    /* access modifiers changed from: package-private */
    public MapMaker g(MapMakerInternalMap.Strength strength) {
        boolean z2;
        MapMakerInternalMap.Strength strength2 = this.f30568d;
        if (strength2 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.s(z2, "Key strength was already set to %s", strength2);
        this.f30568d = (MapMakerInternalMap.Strength) Preconditions.l(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f30565a = true;
        }
        return this;
    }

    public MapMaker h() {
        return g(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        MoreObjects.ToStringHelper b2 = MoreObjects.b(this);
        int i2 = this.f30566b;
        if (i2 != -1) {
            b2.a("initialCapacity", i2);
        }
        int i3 = this.f30567c;
        if (i3 != -1) {
            b2.a("concurrencyLevel", i3);
        }
        MapMakerInternalMap.Strength strength = this.f30568d;
        if (strength != null) {
            b2.b("keyStrength", Ascii.e(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f30569e;
        if (strength2 != null) {
            b2.b("valueStrength", Ascii.e(strength2.toString()));
        }
        if (this.f30570f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
