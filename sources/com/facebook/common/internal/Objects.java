package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe(Nullsafe.Mode.STRICT)
public final class Objects {

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private static final class ValueHolder {
            String name;
            ValueHolder next;
            Object value;

            private ValueHolder() {
            }
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        public ToStringHelper add(String str, Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper addValue(Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z2 = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z2 || obj != null) {
                    sb.append(str);
                    String str2 = valueHolder.name;
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
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper add(String str, boolean z2) {
            return addHolder(str, String.valueOf(z2));
        }

        public ToStringHelper addValue(boolean z2) {
            return addHolder(String.valueOf(z2));
        }

        private ToStringHelper addHolder(Object obj) {
            addHolder().value = obj;
            return this;
        }

        public ToStringHelper add(String str, char c2) {
            return addHolder(str, String.valueOf(c2));
        }

        public ToStringHelper addValue(char c2) {
            return addHolder(String.valueOf(c2));
        }

        public ToStringHelper add(String str, double d2) {
            return addHolder(str, String.valueOf(d2));
        }

        public ToStringHelper addValue(double d2) {
            return addHolder(String.valueOf(d2));
        }

        private ToStringHelper addHolder(String str, Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public ToStringHelper add(String str, float f2) {
            return addHolder(str, String.valueOf(f2));
        }

        public ToStringHelper addValue(float f2) {
            return addHolder(String.valueOf(f2));
        }

        public ToStringHelper add(String str, int i2) {
            return addHolder(str, String.valueOf(i2));
        }

        public ToStringHelper addValue(int i2) {
            return addHolder(String.valueOf(i2));
        }

        public ToStringHelper add(String str, long j2) {
            return addHolder(str, String.valueOf(j2));
        }

        public ToStringHelper addValue(long j2) {
            return addHolder(String.valueOf(j2));
        }
    }

    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T firstNonNull(T t2, T t3) {
        return t2 != null ? t2 : Preconditions.checkNotNull(t3);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
