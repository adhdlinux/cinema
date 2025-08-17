package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    /* renamed from: a */
    public int compareTo(Pair<L, R> pair) {
        return new CompareToBuilder().g(b(), pair.b()).g(c(), pair.c()).u();
    }

    public abstract L b();

    public abstract R c();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equals(getKey(), entry.getKey()) || !Objects.equals(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public final L getKey() {
        return b();
    }

    public R getValue() {
        return c();
    }

    public int hashCode() {
        int i2;
        int i3 = 0;
        if (getKey() == null) {
            i2 = 0;
        } else {
            i2 = getKey().hashCode();
        }
        if (getValue() != null) {
            i3 = getValue().hashCode();
        }
        return i2 ^ i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(b());
        sb.append(',');
        sb.append(c());
        sb.append(')');
        return sb.toString();
    }
}
