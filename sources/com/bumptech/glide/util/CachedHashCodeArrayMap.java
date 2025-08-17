package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: l  reason: collision with root package name */
    private int f17136l;

    public void clear() {
        this.f17136l = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f17136l == 0) {
            this.f17136l = super.hashCode();
        }
        return this.f17136l;
    }

    public void k(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f17136l = 0;
        super.k(simpleArrayMap);
    }

    public V l(int i2) {
        this.f17136l = 0;
        return super.l(i2);
    }

    public V m(int i2, V v2) {
        this.f17136l = 0;
        return super.m(i2, v2);
    }

    public V put(K k2, V v2) {
        this.f17136l = 0;
        return super.put(k2, v2);
    }
}
