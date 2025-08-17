package com.google.android.gms.internal.measurement;

final class zzna {
    private static final zzmx zza = new zzmy();

    static {
        if (zzmv.zzx() && zzmv.zzy()) {
            int i2 = zzin.zza;
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

    static int zzb(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        char charAt;
        int length = charSequence.length();
        int i7 = i3 + i2;
        int i8 = 0;
        while (i8 < length && (i6 = i8 + i2) < i7 && (charAt = charSequence.charAt(i8)) < 128) {
            bArr[i6] = (byte) charAt;
            i8++;
        }
        if (i8 == length) {
            return i2 + length;
        }
        int i9 = i2 + i8;
        while (i8 < length) {
            char charAt2 = charSequence.charAt(i8);
            if (charAt2 < 128 && i9 < i7) {
                i5 = i9 + 1;
                bArr[i9] = (byte) charAt2;
            } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                int i10 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                i9 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
                i8++;
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i9 <= i7 - 3) {
                int i11 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> 12) | 480);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i12 + 1;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            } else if (i9 <= i7 - 4) {
                int i13 = i8 + 1;
                if (i13 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i13);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i14 = i9 + 1;
                        bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i9 = i16 + 1;
                        bArr[i16] = (byte) ((codePoint & 63) | 128);
                        i8 = i13;
                        i8++;
                    } else {
                        i8 = i13;
                    }
                }
                throw new zzmz(i8 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i4 = i8 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i9);
            } else {
                throw new zzmz(i8, length);
            }
            i9 = i5;
            i8++;
        }
        return i9;
    }

    static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new zzmz(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i4) + 4294967296L));
    }

    static String zzd(byte[] bArr, int i2, int i3) throws zzkm {
        int i4;
        int length = bArr.length;
        if ((i2 | i3 | ((length - i2) - i3)) >= 0) {
            int i5 = i2 + i3;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (r11 < i5) {
                byte b2 = bArr[r11];
                if (!zzmw.zzd(b2)) {
                    break;
                }
                i2 = r11 + 1;
                cArr[i4] = (char) b2;
                i6 = i4 + 1;
            }
            while (r11 < i5) {
                int i7 = r11 + 1;
                byte b3 = bArr[r11];
                if (zzmw.zzd(b3)) {
                    int i8 = i4 + 1;
                    cArr[i4] = (char) b3;
                    r11 = i7;
                    while (true) {
                        i4 = i8;
                        if (r11 >= i5) {
                            break;
                        }
                        byte b4 = bArr[r11];
                        if (!zzmw.zzd(b4)) {
                            break;
                        }
                        r11++;
                        i8 = i4 + 1;
                        cArr[i4] = (char) b4;
                    }
                } else if (b3 < -32) {
                    if (i7 < i5) {
                        zzmw.zzc(b3, bArr[i7], cArr, i4);
                        r11 = i7 + 1;
                        i4++;
                    } else {
                        throw zzkm.zzc();
                    }
                } else if (b3 < -16) {
                    if (i7 < i5 - 1) {
                        int i9 = i7 + 1;
                        zzmw.zzb(b3, bArr[i7], bArr[i9], cArr, i4);
                        r11 = i9 + 1;
                        i4++;
                    } else {
                        throw zzkm.zzc();
                    }
                } else if (i7 < i5 - 2) {
                    int i10 = i7 + 1;
                    int i11 = i10 + 1;
                    zzmw.zza(b3, bArr[i7], bArr[i10], bArr[i11], cArr, i4);
                    i4 += 2;
                    r11 = i11 + 1;
                } else {
                    throw zzkm.zzc();
                }
            }
            return new String(cArr, 0, i4);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzf(byte[] bArr, int i2, int i3) {
        return zza.zzb(bArr, i2, i3);
    }
}
