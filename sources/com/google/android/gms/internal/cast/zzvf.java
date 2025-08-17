package com.google.android.gms.internal.cast;

final class zzvf {
    private static final zzvc zza = new zzvd();

    static {
        if (zzvb.zzx() && zzvb.zzy()) {
            int i2 = zzrb.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte b2 = bArr[i2 - 1];
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

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzb(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            int r0 = r7.length()
            r1 = 0
        L_0x0005:
            int r2 = r9 + r10
            r3 = 128(0x80, float:1.794E-43)
            if (r1 >= r0) goto L_0x001b
            int r4 = r1 + r9
            if (r4 >= r2) goto L_0x001b
            char r5 = r7.charAt(r1)
            if (r5 >= r3) goto L_0x001b
            byte r2 = (byte) r5
            r8[r4] = r2
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001b:
            if (r1 != r0) goto L_0x0020
            int r9 = r9 + r0
            goto L_0x00ff
        L_0x0020:
            int r9 = r9 + r1
        L_0x0021:
            if (r1 >= r0) goto L_0x00ff
            char r10 = r7.charAt(r1)
            if (r10 >= r3) goto L_0x0033
            if (r9 >= r2) goto L_0x0033
            int r4 = r9 + 1
            byte r10 = (byte) r10
            r8[r9] = r10
        L_0x0030:
            r9 = r4
            goto L_0x00b7
        L_0x0033:
            r4 = 2048(0x800, float:2.87E-42)
            if (r10 >= r4) goto L_0x004d
            int r4 = r2 + -2
            if (r9 > r4) goto L_0x004d
            int r4 = r9 + 1
            int r5 = r10 >>> 6
            r5 = r5 | 960(0x3c0, float:1.345E-42)
            byte r5 = (byte) r5
            r8[r9] = r5
            int r9 = r4 + 1
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r8[r4] = r10
            goto L_0x00b7
        L_0x004d:
            r4 = 57343(0xdfff, float:8.0355E-41)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r10 < r5) goto L_0x0057
            if (r10 <= r4) goto L_0x0077
        L_0x0057:
            int r6 = r2 + -3
            if (r9 > r6) goto L_0x0077
            int r4 = r9 + 1
            int r5 = r10 >>> 12
            r5 = r5 | 480(0x1e0, float:6.73E-43)
            byte r5 = (byte) r5
            r8[r9] = r5
            int r9 = r4 + 1
            int r5 = r10 >>> 6
            r5 = r5 & 63
            r5 = r5 | r3
            byte r5 = (byte) r5
            r8[r4] = r5
            int r4 = r9 + 1
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r8[r9] = r10
            goto L_0x0030
        L_0x0077:
            int r6 = r2 + -4
            if (r9 > r6) goto L_0x00c4
            int r4 = r1 + 1
            int r5 = r7.length()
            if (r4 == r5) goto L_0x00bc
            char r1 = r7.charAt(r4)
            boolean r5 = java.lang.Character.isSurrogatePair(r10, r1)
            if (r5 == 0) goto L_0x00bb
            int r10 = java.lang.Character.toCodePoint(r10, r1)
            int r1 = r9 + 1
            int r5 = r10 >>> 18
            r5 = r5 | 240(0xf0, float:3.36E-43)
            byte r5 = (byte) r5
            r8[r9] = r5
            int r9 = r1 + 1
            int r5 = r10 >>> 12
            r5 = r5 & 63
            r5 = r5 | r3
            byte r5 = (byte) r5
            r8[r1] = r5
            int r1 = r9 + 1
            int r5 = r10 >>> 6
            r5 = r5 & 63
            r5 = r5 | r3
            byte r5 = (byte) r5
            r8[r9] = r5
            int r9 = r1 + 1
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r8[r1] = r10
            r1 = r4
        L_0x00b7:
            int r1 = r1 + 1
            goto L_0x0021
        L_0x00bb:
            r1 = r4
        L_0x00bc:
            com.google.android.gms.internal.cast.zzve r7 = new com.google.android.gms.internal.cast.zzve
            int r1 = r1 + -1
            r7.<init>(r1, r0)
            throw r7
        L_0x00c4:
            if (r10 < r5) goto L_0x00e0
            if (r10 > r4) goto L_0x00e0
            int r8 = r1 + 1
            int r2 = r7.length()
            if (r8 == r2) goto L_0x00da
            char r7 = r7.charAt(r8)
            boolean r7 = java.lang.Character.isSurrogatePair(r10, r7)
            if (r7 != 0) goto L_0x00e0
        L_0x00da:
            com.google.android.gms.internal.cast.zzve r7 = new com.google.android.gms.internal.cast.zzve
            r7.<init>(r1, r0)
            throw r7
        L_0x00e0:
            java.lang.ArrayIndexOutOfBoundsException r7 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Failed writing "
            r8.append(r0)
            r8.append(r10)
            java.lang.String r10 = " at index "
            r8.append(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00ff:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzvf.zzb(java.lang.CharSequence, byte[], int, int):int");
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
                                throw new zzve(i3, length2);
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

    static boolean zzd(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zze(byte[] bArr, int i2, int i3) {
        return zza.zzb(bArr, 0, i3);
    }
}
