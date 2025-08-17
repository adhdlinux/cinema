package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> d(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        List<T> a2 = ArraysUtilJVM.a(tArr);
        Intrinsics.e(a2, "asList(this)");
        return a2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    public static final <T> T[] f(T[] tArr, T[] tArr2, int i2, int i3, int i4) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ byte[] g(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return e(bArr, bArr2, i2, i3, i4);
    }

    public static /* synthetic */ Object[] h(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return f(objArr, objArr2, i2, i3, i4);
    }

    public static byte[] i(byte[] bArr, int i2, int i3) {
        Intrinsics.f(bArr, "<this>");
        ArraysKt__ArraysJVMKt.b(i3, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        Intrinsics.e(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static void j(int[] iArr, int i2, int i3, int i4) {
        Intrinsics.f(iArr, "<this>");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static <T> void k(T[] tArr, T t2, int i2, int i3) {
        Intrinsics.f(tArr, "<this>");
        Arrays.fill(tArr, i2, i3, t2);
    }

    public static /* synthetic */ void l(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        j(iArr, i2, i3, i4);
    }

    public static /* synthetic */ void m(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        k(objArr, obj, i2, i3);
    }

    public static final <T> void n(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.f(tArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
