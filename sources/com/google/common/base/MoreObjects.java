package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public final class MoreObjects {

    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final String f30394a;

        /* renamed from: b  reason: collision with root package name */
        private final ValueHolder f30395b;

        /* renamed from: c  reason: collision with root package name */
        private ValueHolder f30396c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f30397d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f30398e;

        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
            }
        }

        static class ValueHolder {

            /* renamed from: a  reason: collision with root package name */
            String f30399a;

            /* renamed from: b  reason: collision with root package name */
            Object f30400b;

            /* renamed from: c  reason: collision with root package name */
            ValueHolder f30401c;

            ValueHolder() {
            }
        }

        private ValueHolder c() {
            ValueHolder valueHolder = new ValueHolder();
            this.f30396c.f30401c = valueHolder;
            this.f30396c = valueHolder;
            return valueHolder;
        }

        private ToStringHelper d(Object obj) {
            c().f30400b = obj;
            return this;
        }

        private ToStringHelper e(String str, Object obj) {
            ValueHolder c2 = c();
            c2.f30400b = obj;
            c2.f30399a = (String) Preconditions.l(str);
            return this;
        }

        private UnconditionalValueHolder f() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.f30396c.f30401c = unconditionalValueHolder;
            this.f30396c = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        private ToStringHelper g(String str, Object obj) {
            UnconditionalValueHolder f2 = f();
            f2.f30400b = obj;
            f2.f30399a = (String) Preconditions.l(str);
            return this;
        }

        private static boolean i(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() == 0) {
                    return true;
                }
                return false;
            } else if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            } else {
                if (obj instanceof Map) {
                    return ((Map) obj).isEmpty();
                }
                if (obj instanceof Optional) {
                    return !((Optional) obj).c();
                }
                if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                    return false;
                }
                return true;
            }
        }

        public ToStringHelper a(String str, int i2) {
            return g(str, String.valueOf(i2));
        }

        public ToStringHelper b(String str, Object obj) {
            return e(str, obj);
        }

        public ToStringHelper h(Object obj) {
            return d(obj);
        }

        public String toString() {
            boolean z2 = this.f30397d;
            boolean z3 = this.f30398e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f30394a);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.f30395b.f30401c; valueHolder != null; valueHolder = valueHolder.f30401c) {
                Object obj = valueHolder.f30400b;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z2) {
                        }
                    } else if (z3 && i(obj)) {
                    }
                }
                sb.append(str);
                String str2 = valueHolder.f30399a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append(deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f30395b = valueHolder;
            this.f30396c = valueHolder;
            this.f30397d = false;
            this.f30398e = false;
            this.f30394a = (String) Preconditions.l(str);
        }
    }

    private MoreObjects() {
    }

    public static <T> T a(T t2, T t3) {
        if (t2 != null) {
            return t2;
        }
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper b(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
