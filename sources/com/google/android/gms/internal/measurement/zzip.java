package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzip {
    static int zza(byte[] bArr, int i2, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i2, zzio);
        int i3 = zzio.zza;
        if (i3 < 0) {
            throw zzkm.zzd();
        } else if (i3 > bArr.length - zzj) {
            throw zzkm.zzf();
        } else if (i3 == 0) {
            zzio.zzc = zzjb.zzb;
            return zzj;
        } else {
            zzio.zzc = zzjb.zzl(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzb(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static int zzc(zzlu zzlu, byte[] bArr, int i2, int i3, int i4, zzio zzio) throws IOException {
        zzlm zzlm = (zzlm) zzlu;
        Object zze = zzlm.zze();
        int zzc = zzlm.zzc(zze, bArr, i2, i3, i4, zzio);
        zzlm.zzf(zze);
        zzio.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.measurement.zzlu r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zzio r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zze()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzh(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzkm r6 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzip.zzd(com.google.android.gms.internal.measurement.zzlu, byte[], int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    static int zze(zzlu zzlu, int i2, byte[] bArr, int i3, int i4, zzkj zzkj, zzio zzio) throws IOException {
        int zzd = zzd(zzlu, bArr, i3, i4, zzio);
        zzkj.add(zzio.zzc);
        while (zzd < i4) {
            int zzj = zzj(bArr, zzd, zzio);
            if (i2 != zzio.zza) {
                break;
            }
            zzd = zzd(zzlu, bArr, zzj, i4, zzio);
            zzkj.add(zzio.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i2, zzkj zzkj, zzio zzio) throws IOException {
        zzkd zzkd = (zzkd) zzkj;
        int zzj = zzj(bArr, i2, zzio);
        int i3 = zzio.zza + zzj;
        while (zzj < i3) {
            zzj = zzj(bArr, zzj, zzio);
            zzkd.zzh(zzio.zza);
        }
        if (zzj == i3) {
            return zzj;
        }
        throw zzkm.zzf();
    }

    static int zzg(byte[] bArr, int i2, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i2, zzio);
        int i3 = zzio.zza;
        if (i3 < 0) {
            throw zzkm.zzd();
        } else if (i3 == 0) {
            zzio.zzc = "";
            return zzj;
        } else {
            zzio.zzc = new String(bArr, zzj, i3, zzkk.zzb);
            return zzj + i3;
        }
    }

    static int zzh(byte[] bArr, int i2, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i2, zzio);
        int i3 = zzio.zza;
        if (i3 < 0) {
            throw zzkm.zzd();
        } else if (i3 == 0) {
            zzio.zzc = "";
            return zzj;
        } else {
            zzio.zzc = zzna.zzd(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzi(int i2, byte[] bArr, int i3, int i4, zzmm zzmm, zzio zzio) throws zzkm {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzm = zzm(bArr, i3, zzio);
                zzmm.zzh(i2, Long.valueOf(zzio.zzb));
                return zzm;
            } else if (i5 == 1) {
                zzmm.zzh(i2, Long.valueOf(zzn(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zzj = zzj(bArr, i3, zzio);
                int i6 = zzio.zza;
                if (i6 < 0) {
                    throw zzkm.zzd();
                } else if (i6 <= bArr.length - zzj) {
                    if (i6 == 0) {
                        zzmm.zzh(i2, zzjb.zzb);
                    } else {
                        zzmm.zzh(i2, zzjb.zzl(bArr, zzj, i6));
                    }
                    return zzj + i6;
                } else {
                    throw zzkm.zzf();
                }
            } else if (i5 == 3) {
                int i7 = (i2 & -8) | 4;
                zzmm zze = zzmm.zze();
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i3, zzio);
                    int i9 = zzio.zza;
                    if (i9 == i7) {
                        i8 = i9;
                        i3 = zzj2;
                        break;
                    }
                    i8 = i9;
                    i3 = zzi(i9, bArr, zzj2, i4, zze, zzio);
                }
                if (i3 > i4 || i8 != i7) {
                    throw zzkm.zze();
                }
                zzmm.zzh(i2, zze);
                return i3;
            } else if (i5 == 5) {
                zzmm.zzh(i2, Integer.valueOf(zzb(bArr, i3)));
                return i3 + 4;
            } else {
                throw zzkm.zzb();
            }
        } else {
            throw zzkm.zzb();
        }
    }

    static int zzj(byte[] bArr, int i2, zzio zzio) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return zzk(b2, bArr, i3, zzio);
        }
        zzio.zza = b2;
        return i3;
    }

    static int zzk(int i2, byte[] bArr, int i3, zzio zzio) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzio.zza = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            zzio.zza = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzio.zza = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzio.zza = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                zzio.zza = i12;
                return i13;
            }
        }
    }

    static int zzl(int i2, byte[] bArr, int i3, int i4, zzkj zzkj, zzio zzio) {
        zzkd zzkd = (zzkd) zzkj;
        int zzj = zzj(bArr, i3, zzio);
        zzkd.zzh(zzio.zza);
        while (zzj < i4) {
            int zzj2 = zzj(bArr, zzj, zzio);
            if (i2 != zzio.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzio);
            zzkd.zzh(zzio.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i2, zzio zzio) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 >= 0) {
            zzio.zzb = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j3 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            int i7 = i6;
            b2 = b3;
            i4 = i7;
        }
        zzio.zzb = j3;
        return i4;
    }

    static long zzn(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }
}
