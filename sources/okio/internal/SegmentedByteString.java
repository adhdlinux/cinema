package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.C0062SegmentedByteString;

/* renamed from: okio.internal.-SegmentedByteString  reason: invalid class name */
public final class SegmentedByteString {
    public static final int a(int[] iArr, int i2, int i3, int i4) {
        Intrinsics.f(iArr, "<this>");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else if (i7 <= i2) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final int b(C0062SegmentedByteString segmentedByteString, int i2) {
        Intrinsics.f(segmentedByteString, "<this>");
        int a2 = a(segmentedByteString.A(), i2 + 1, 0, segmentedByteString.B().length);
        if (a2 >= 0) {
            return a2;
        }
        return ~a2;
    }
}
