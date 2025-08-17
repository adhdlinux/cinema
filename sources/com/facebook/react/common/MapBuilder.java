package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

    public static final class Builder<K, V> {
        private Map mMap;
        private boolean mUnderConstruction;

        public Map<K, V> build() {
            if (this.mUnderConstruction) {
                this.mUnderConstruction = false;
                return this.mMap;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        public Builder<K, V> put(K k2, V v2) {
            if (this.mUnderConstruction) {
                this.mMap.put(k2, v2);
                return this;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        private Builder() {
            this.mMap = MapBuilder.newHashMap();
            this.mUnderConstruction = true;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> Map<K, V> of() {
        return newHashMap();
    }

    public static <K, V> Map<K, V> of(K k2, V v2) {
        Map<K, V> of = of();
        of.put(k2, v2);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        of.put(k4, v4);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        of.put(k4, v4);
        of.put(k5, v5);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        of.put(k4, v4);
        of.put(k5, v5);
        of.put(k6, v6);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        of.put(k4, v4);
        of.put(k5, v5);
        of.put(k6, v6);
        of.put(k7, v7);
        return of;
    }

    public static <K, V> Map<K, V> of(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        Map<K, V> of = of();
        of.put(k2, v2);
        of.put(k3, v3);
        of.put(k4, v4);
        of.put(k5, v5);
        of.put(k6, v6);
        of.put(k7, v7);
        of.put(k8, v8);
        return of;
    }
}
