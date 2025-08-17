package com.google.android.gms.internal.measurement;

final class zzmy extends zzmx {
    zzmy() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i2, byte[] bArr, int i3, int i4) {
        while (r9 < i4 && bArr[r9] >= 0) {
            i3 = r9 + 1;
        }
        if (r9 >= i4) {
            return 0;
        }
        while (r9 < i4) {
            int i5 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i4) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        r9 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                } else if (b2 < -16) {
                    if (i5 >= i4 - 1) {
                        return zzna.zza(bArr, i5, i4);
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        r9 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                } else if (i5 >= i4 - 2) {
                    return zzna.zza(bArr, i5, i4);
                } else {
                    int i7 = i5 + 1;
                    byte b4 = bArr[i5];
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i5 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            r9 = i5;
        }
        return 0;
    }
}
