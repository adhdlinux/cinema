package com.google.android.gms.internal.auth;

final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i2 = zzdr.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 != 0) {
            if (i4 == 1) {
                byte b3 = bArr[i2];
                if (b2 <= -12 && b3 <= -65) {
                    return b2 ^ (b3 << 8);
                }
            } else if (i4 == 2) {
                byte b4 = bArr[i2];
                byte b5 = bArr[i2 + 1];
                if (b2 <= -12 && b4 <= -65 && b5 <= -65) {
                    return ((b4 << 8) ^ b2) ^ (b5 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b2 > -12) {
            return -1;
        } else {
            return b2;
        }
        return -1;
    }

    static String zzb(byte[] bArr, int i2, int i3) throws zzfa {
        int i4;
        int length = bArr.length;
        if ((i2 | i3 | ((length - i2) - i3)) >= 0) {
            int i5 = i2 + i3;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (r11 < i5) {
                byte b2 = bArr[r11];
                if (!zzhj.zzd(b2)) {
                    break;
                }
                i2 = r11 + 1;
                cArr[i4] = (char) b2;
                i6 = i4 + 1;
            }
            while (r11 < i5) {
                int i7 = r11 + 1;
                byte b3 = bArr[r11];
                if (zzhj.zzd(b3)) {
                    int i8 = i4 + 1;
                    cArr[i4] = (char) b3;
                    r11 = i7;
                    while (true) {
                        i4 = i8;
                        if (r11 >= i5) {
                            break;
                        }
                        byte b4 = bArr[r11];
                        if (!zzhj.zzd(b4)) {
                            break;
                        }
                        r11++;
                        i8 = i4 + 1;
                        cArr[i4] = (char) b4;
                    }
                } else if (b3 < -32) {
                    if (i7 < i5) {
                        zzhj.zzc(b3, bArr[i7], cArr, i4);
                        r11 = i7 + 1;
                        i4++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b3 < -16) {
                    if (i7 < i5 - 1) {
                        int i9 = i7 + 1;
                        zzhj.zzb(b3, bArr[i7], bArr[i9], cArr, i4);
                        r11 = i9 + 1;
                        i4++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i7 < i5 - 2) {
                    int i10 = i7 + 1;
                    int i11 = i10 + 1;
                    zzhj.zza(b3, bArr[i7], bArr[i10], bArr[i11], cArr, i4);
                    i4 += 2;
                    r11 = i11 + 1;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i4);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzd(byte[] bArr, int i2, int i3) {
        return zza.zzb(bArr, i2, i3);
    }
}
