package com.google.android.gms.internal.ads;

import java.util.Map;

abstract class zzfqw implements Map.Entry {
    zzfqw() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (!zzfpc.zza(getKey(), entry.getKey()) || !zzfpc.zza(getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract Object getKey();

    public abstract Object getValue();

    public final int hashCode() {
        int i2;
        Object key = getKey();
        Object value = getValue();
        int i3 = 0;
        if (key == null) {
            i2 = 0;
        } else {
            i2 = key.hashCode();
        }
        if (value != null) {
            i3 = value.hashCode();
        }
        return i2 ^ i3;
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        return valueOf + "=" + valueOf2;
    }
}
