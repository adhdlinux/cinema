package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

abstract class zzgss {
    zzgss() {
    }

    static final String zzd(ByteBuffer byteBuffer, int i2, int i3) throws zzgpy {
        if ((((byteBuffer.limit() - i2) - i3) | i2 | i3) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r11 < i4) {
                byte b2 = byteBuffer.get(r11);
                if (!zzgsr.zzd(b2)) {
                    break;
                }
                i2 = r11 + 1;
                cArr[i5] = (char) b2;
                i5++;
            }
            int i6 = i5;
            while (r11 < i4) {
                int i7 = r11 + 1;
                byte b3 = byteBuffer.get(r11);
                if (zzgsr.zzd(b3)) {
                    int i8 = i6 + 1;
                    cArr[i6] = (char) b3;
                    r11 = i7;
                    while (true) {
                        i6 = i8;
                        if (r11 >= i4) {
                            break;
                        }
                        byte b4 = byteBuffer.get(r11);
                        if (!zzgsr.zzd(b4)) {
                            break;
                        }
                        r11++;
                        i8 = i6 + 1;
                        cArr[i6] = (char) b4;
                    }
                } else if (zzgsr.zzf(b3)) {
                    if (i7 < i4) {
                        zzgsr.zzc(b3, byteBuffer.get(i7), cArr, i6);
                        r11 = i7 + 1;
                        i6++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (zzgsr.zze(b3)) {
                    if (i7 < i4 - 1) {
                        int i9 = i7 + 1;
                        zzgsr.zzb(b3, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                        r11 = i9 + 1;
                        i6++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (i7 < i4 - 2) {
                    int i10 = i7 + 1;
                    byte b5 = byteBuffer.get(i7);
                    int i11 = i10 + 1;
                    zzgsr.zza(b3, b5, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i6);
                    i6 += 2;
                    r11 = i11 + 1;
                } else {
                    throw zzgpy.zzd();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i2, byte[] bArr, int i3, int i4);

    /* access modifiers changed from: package-private */
    public abstract String zzb(byte[] bArr, int i2, int i3) throws zzgpy;

    /* access modifiers changed from: package-private */
    public final boolean zzc(byte[] bArr, int i2, int i3) {
        return zza(0, bArr, i2, i3) == 0;
    }
}
