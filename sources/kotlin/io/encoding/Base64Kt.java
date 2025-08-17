package kotlin.io.encoding;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public final class Base64Kt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f40400a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f40401b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f40402c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f40403d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f40400a = bArr;
        int[] iArr = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        int i2 = 0;
        ArraysKt___ArraysJvmKt.l(iArr, -1, 0, 0, 6, (Object) null);
        iArr[61] = -2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            iArr[bArr[i3]] = i4;
            i3++;
            i4++;
        }
        f40401b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f40402c = bArr2;
        int[] iArr2 = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        ArraysKt___ArraysJvmKt.l(iArr2, -1, 0, 0, 6, (Object) null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i5 = 0;
        while (i2 < length2) {
            iArr2[bArr2[i2]] = i5;
            i2++;
            i5++;
        }
        f40403d = iArr2;
    }
}
