package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Joiner {

    /* renamed from: a  reason: collision with root package name */
    private final String f30390a;

    private Joiner(String str) {
        this.f30390a = (String) Preconditions.l(str);
    }

    private static Iterable<Object> d(final Object obj, final Object obj2, final Object[] objArr) {
        Preconditions.l(objArr);
        return new AbstractList<Object>() {
            public Object get(int i2) {
                if (i2 == 0) {
                    return obj;
                }
                if (i2 != 1) {
                    return objArr[i2 - 2];
                }
                return obj2;
            }

            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner e(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A a(A a2, Iterator<? extends Object> it2) throws IOException {
        Preconditions.l(a2);
        if (it2.hasNext()) {
            a2.append(f(it2.next()));
            while (it2.hasNext()) {
                a2.append(this.f30390a);
                a2.append(f(it2.next()));
            }
        }
        return a2;
    }

    public final StringBuilder b(StringBuilder sb, Iterable<? extends Object> iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator<? extends Object> it2) {
        try {
            a(sb, it2);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence f(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final String join(Iterable<? extends Object> iterable) {
        return join(iterable.iterator());
    }

    public final String join(Iterator<? extends Object> it2) {
        return c(new StringBuilder(), it2).toString();
    }

    public final String join(Object[] objArr) {
        return join((Iterable<? extends Object>) Arrays.asList(objArr));
    }

    public final String join(Object obj, Object obj2, Object... objArr) {
        return join((Iterable<? extends Object>) d(obj, obj2, objArr));
    }
}
