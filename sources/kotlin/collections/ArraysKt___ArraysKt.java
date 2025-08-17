package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final int A(byte[] bArr, byte b2) {
        Intrinsics.f(bArr, "<this>");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b2 == bArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int B(char[] cArr, char c2) {
        Intrinsics.f(cArr, "<this>");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int C(int[] iArr, int i2) {
        Intrinsics.f(iArr, "<this>");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int D(long[] jArr, long j2) {
        Intrinsics.f(jArr, "<this>");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (j2 == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static <T> int E(T[] tArr, T t2) {
        Intrinsics.f(tArr, "<this>");
        int i2 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (Intrinsics.a(t2, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final int F(short[] sArr, short s2) {
        Intrinsics.f(sArr, "<this>");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (s2 == sArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A G(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(a2, "buffer");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (byte b2 : bArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a2.append((CharSequence) function1.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf(b2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <A extends Appendable> A H(char[] cArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.f(cArr, "<this>");
        Intrinsics.f(a2, "buffer");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (char c2 : cArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a2.append((CharSequence) function1.invoke(Character.valueOf(c2)));
            } else {
                a2.append(c2);
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final String I(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        String sb = ((StringBuilder) G(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final String J(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.f(cArr, "<this>");
        Intrinsics.f(charSequence, "separator");
        Intrinsics.f(charSequence2, "prefix");
        Intrinsics.f(charSequence3, "postfix");
        Intrinsics.f(charSequence4, "truncated");
        String sb = ((StringBuilder) H(cArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String K(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return I(bArr, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static /* synthetic */ String L(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return J(cArr, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static void M(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length >= 0) {
            int w2 = w(bArr);
            IntIterator e2 = new IntRange(0, length).iterator();
            while (e2.hasNext()) {
                int nextInt = e2.nextInt();
                byte b2 = bArr[nextInt];
                bArr[nextInt] = bArr[w2];
                bArr[w2] = b2;
                w2--;
            }
        }
    }

    public static char N(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T O(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T, C extends Collection<? super T>> C P(T[] tArr, C c2) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(c2, "destination");
        for (T add : tArr) {
            c2.add(add);
        }
        return c2;
    }

    public static <T> List<T> Q(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.f();
        }
        if (length != 1) {
            return R(tArr);
        }
        return CollectionsKt__CollectionsJVMKt.b(tArr[0]);
    }

    public static <T> List<T> R(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.c(tArr));
    }

    public static final <T> Set<T> S(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.b();
        }
        if (length != 1) {
            return (Set) P(tArr, new LinkedHashSet(MapsKt__MapsJVMKt.d(tArr.length)));
        }
        return SetsKt__SetsJVMKt.a(tArr[0]);
    }

    public static <T> Iterable<IndexedValue<T>> T(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$1(tArr));
    }

    public static boolean o(byte[] bArr, byte b2) {
        Intrinsics.f(bArr, "<this>");
        if (A(bArr, b2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean p(char[] cArr, char c2) {
        Intrinsics.f(cArr, "<this>");
        if (B(cArr, c2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean q(int[] iArr, int i2) {
        Intrinsics.f(iArr, "<this>");
        if (C(iArr, i2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean r(long[] jArr, long j2) {
        Intrinsics.f(jArr, "<this>");
        if (D(jArr, j2) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean s(T[] tArr, T t2) {
        Intrinsics.f(tArr, "<this>");
        if (E(tArr, t2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean t(short[] sArr, short s2) {
        Intrinsics.f(sArr, "<this>");
        if (F(sArr, s2) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> List<T> u(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return (List) v(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C v(T[] tArr, C c2) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(c2, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                c2.add(t2);
            }
        }
        return c2;
    }

    public static final int w(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return bArr.length - 1;
    }

    public static int x(long[] jArr) {
        Intrinsics.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static <T> int y(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T z(T[] tArr, int i2) {
        Intrinsics.f(tArr, "<this>");
        if (i2 < 0 || i2 > y(tArr)) {
            return null;
        }
        return tArr[i2];
    }
}
