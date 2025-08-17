package kotlin.text;

import java.util.Comparator;
import kotlin.collections.AbstractList;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;

class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static final String A(String str, String str2, String str3, boolean z2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "oldValue");
        Intrinsics.f(str3, "newValue");
        int i2 = 0;
        int S = StringsKt__StringsKt.S(str, str2, 0, z2);
        if (S < 0) {
            return str;
        }
        int length = str2.length();
        int b2 = RangesKt___RangesKt.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i2, S);
                sb.append(str3);
                i2 = S + length;
                if (S >= str.length() || (S = StringsKt__StringsKt.S(str, str2, S + b2, z2)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    Intrinsics.e(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i2, S);
                sb.append(str3);
                i2 = S + length;
                break;
            } while ((S = StringsKt__StringsKt.S(str, str2, S + b2, z2)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            Intrinsics.e(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String B(String str, char c2, char c3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return z(str, c2, c3, z2);
    }

    public static /* synthetic */ String C(String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return A(str, str2, str3, z2);
    }

    public static boolean D(String str, String str2, int i2, boolean z2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "prefix");
        if (!z2) {
            return str.startsWith(str2, i2);
        }
        return w(str, i2, str2, 0, str2.length(), z2);
    }

    public static boolean E(String str, String str2, boolean z2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "prefix");
        if (!z2) {
            return str.startsWith(str2);
        }
        return w(str, 0, str2, 0, str2.length(), z2);
    }

    public static /* synthetic */ boolean F(String str, String str2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return D(str, str2, i2, z2);
    }

    public static /* synthetic */ boolean G(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return E(str, str2, z2);
    }

    public static String o(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String p(char[] cArr, int i2, int i3) {
        Intrinsics.f(cArr, "<this>");
        AbstractList.f40302b.a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    public static String q(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return new String(bArr, Charsets.f40513b);
    }

    public static final boolean r(String str, String str2, boolean z2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "suffix");
        if (!z2) {
            return str.endsWith(str2);
        }
        return w(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean s(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return r(str, str2, z2);
    }

    public static boolean t(String str, String str2, boolean z2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z2) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static Comparator<String> u(StringCompanionObject stringCompanionObject) {
        Intrinsics.f(stringCompanionObject, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.e(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean v(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            int r0 = r4.length()
            r1 = 1
            if (r0 == 0) goto L_0x0040
            kotlin.ranges.IntRange r0 = kotlin.text.StringsKt__StringsKt.P(r4)
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0020
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0020
        L_0x001e:
            r4 = 1
            goto L_0x003c
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001e
            r2 = r0
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            char r2 = r4.charAt(r2)
            boolean r2 = kotlin.text.CharsKt__CharJVMKt.c(r2)
            if (r2 != 0) goto L_0x0024
            r4 = 0
        L_0x003c:
            if (r4 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsJVMKt.v(java.lang.CharSequence):boolean");
    }

    public static boolean w(String str, int i2, String str2, int i3, int i4, boolean z2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "other");
        if (!z2) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z2, i2, str2, i3, i4);
    }

    public static /* synthetic */ boolean x(String str, int i2, String str2, int i3, int i4, boolean z2, int i5, Object obj) {
        return w(str, i2, str2, i3, i4, (i5 & 16) != 0 ? false : z2);
    }

    public static String y(CharSequence charSequence, int i2) {
        boolean z2;
        Intrinsics.f(charSequence, "<this>");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        } else if (i2 == 0) {
            return "";
        } else {
            if (i2 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                IntIterator e2 = new IntRange(1, i2).iterator();
                while (e2.hasNext()) {
                    e2.nextInt();
                    sb.append(charSequence);
                }
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "{\n                    va…tring()\n                }");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String z(String str, char c2, char c3, boolean z2) {
        Intrinsics.f(str, "<this>");
        if (!z2) {
            String replace = str.replace(c2, c3);
            Intrinsics.e(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (CharsKt__CharKt.e(charAt, c2, z2)) {
                charAt = c3;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
