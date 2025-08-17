package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzgnr {
    static int zza(byte[] bArr, int i2, zzgnq zzgnq) throws zzgpy {
        int zzj = zzj(bArr, i2, zzgnq);
        int i3 = zzgnq.zza;
        if (i3 < 0) {
            throw zzgpy.zzf();
        } else if (i3 > bArr.length - zzj) {
            throw zzgpy.zzj();
        } else if (i3 == 0) {
            zzgnq.zzc = zzgoe.zzb;
            return zzj;
        } else {
            zzgnq.zzc = zzgoe.zzv(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzb(byte[] bArr, int i2) {
        int i3 = (bArr[i2 + 1] & 255) << 8;
        return ((bArr[i2 + 3] & 255) << 24) | i3 | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16);
    }

    static int zzc(zzgrp zzgrp, byte[] bArr, int i2, int i3, int i4, zzgnq zzgnq) throws IOException {
        Object zze = zzgrp.zze();
        int zzn = zzn(zze, zzgrp, bArr, i2, i3, i4, zzgnq);
        zzgrp.zzf(zze);
        zzgnq.zzc = zze;
        return zzn;
    }

    static int zzd(zzgrp zzgrp, byte[] bArr, int i2, int i3, zzgnq zzgnq) throws IOException {
        Object zze = zzgrp.zze();
        int zzo = zzo(zze, zzgrp, bArr, i2, i3, zzgnq);
        zzgrp.zzf(zze);
        zzgnq.zzc = zze;
        return zzo;
    }

    static int zze(zzgrp zzgrp, int i2, byte[] bArr, int i3, int i4, zzgpv zzgpv, zzgnq zzgnq) throws IOException {
        int zzd = zzd(zzgrp, bArr, i3, i4, zzgnq);
        zzgpv.add(zzgnq.zzc);
        while (zzd < i4) {
            int zzj = zzj(bArr, zzd, zzgnq);
            if (i2 != zzgnq.zza) {
                break;
            }
            zzd = zzd(zzgrp, bArr, zzj, i4, zzgnq);
            zzgpv.add(zzgnq.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i2, zzgpv zzgpv, zzgnq zzgnq) throws IOException {
        zzgpn zzgpn = (zzgpn) zzgpv;
        int zzj = zzj(bArr, i2, zzgnq);
        int i3 = zzgnq.zza + zzj;
        while (zzj < i3) {
            zzj = zzj(bArr, zzj, zzgnq);
            zzgpn.zzh(zzgnq.zza);
        }
        if (zzj == i3) {
            return zzj;
        }
        throw zzgpy.zzj();
    }

    static int zzg(byte[] bArr, int i2, zzgnq zzgnq) throws zzgpy {
        int zzj = zzj(bArr, i2, zzgnq);
        int i3 = zzgnq.zza;
        if (i3 < 0) {
            throw zzgpy.zzf();
        } else if (i3 == 0) {
            zzgnq.zzc = "";
            return zzj;
        } else {
            zzgnq.zzc = new String(bArr, zzj, i3, zzgpw.zzb);
            return zzj + i3;
        }
    }

    static int zzh(byte[] bArr, int i2, zzgnq zzgnq) throws zzgpy {
        int zzj = zzj(bArr, i2, zzgnq);
        int i3 = zzgnq.zza;
        if (i3 < 0) {
            throw zzgpy.zzf();
        } else if (i3 == 0) {
            zzgnq.zzc = "";
            return zzj;
        } else {
            zzgnq.zzc = zzgsv.zzh(bArr, zzj, i3);
            return zzj + i3;
        }
    }

    static int zzi(int i2, byte[] bArr, int i3, int i4, zzgsh zzgsh, zzgnq zzgnq) throws zzgpy {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int zzm = zzm(bArr, i3, zzgnq);
                zzgsh.zzj(i2, Long.valueOf(zzgnq.zzb));
                return zzm;
            } else if (i5 == 1) {
                zzgsh.zzj(i2, Long.valueOf(zzp(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int zzj = zzj(bArr, i3, zzgnq);
                int i6 = zzgnq.zza;
                if (i6 < 0) {
                    throw zzgpy.zzf();
                } else if (i6 <= bArr.length - zzj) {
                    if (i6 == 0) {
                        zzgsh.zzj(i2, zzgoe.zzb);
                    } else {
                        zzgsh.zzj(i2, zzgoe.zzv(bArr, zzj, i6));
                    }
                    return zzj + i6;
                } else {
                    throw zzgpy.zzj();
                }
            } else if (i5 == 3) {
                int i7 = (i2 & -8) | 4;
                zzgsh zzf = zzgsh.zzf();
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i3, zzgnq);
                    int i9 = zzgnq.zza;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = zzj2;
                        break;
                    }
                    int zzi = zzi(i8, bArr, zzj2, i4, zzf, zzgnq);
                    i8 = i9;
                    i3 = zzi;
                }
                if (i3 > i4 || i8 != i7) {
                    throw zzgpy.zzg();
                }
                zzgsh.zzj(i2, zzf);
                return i3;
            } else if (i5 == 5) {
                zzgsh.zzj(i2, Integer.valueOf(zzb(bArr, i3)));
                return i3 + 4;
            } else {
                throw zzgpy.zzc();
            }
        } else {
            throw zzgpy.zzc();
        }
    }

    static int zzj(byte[] bArr, int i2, zzgnq zzgnq) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return zzk(b2, bArr, i3, zzgnq);
        }
        zzgnq.zza = b2;
        return i3;
    }

    static int zzk(int i2, byte[] bArr, int i3, zzgnq zzgnq) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & 127;
        if (b2 >= 0) {
            zzgnq.zza = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzgnq.zza = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            zzgnq.zza = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            zzgnq.zza = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                zzgnq.zza = i12;
                return i13;
            }
        }
    }

    static int zzl(int i2, byte[] bArr, int i3, int i4, zzgpv zzgpv, zzgnq zzgnq) {
        zzgpn zzgpn = (zzgpn) zzgpv;
        int zzj = zzj(bArr, i3, zzgnq);
        zzgpn.zzh(zzgnq.zza);
        while (zzj < i4) {
            int zzj2 = zzj(bArr, zzj, zzgnq);
            if (i2 != zzgnq.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzgnq);
            zzgpn.zzh(zzgnq.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i2, zzgnq zzgnq) {
        long j2 = (long) bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            zzgnq.zzb = j2;
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
            byte b4 = b3;
            i4 = i6;
            b2 = b4;
        }
        zzgnq.zzb = j3;
        return i4;
    }

    static int zzn(Object obj, zzgrp zzgrp, byte[] bArr, int i2, int i3, int i4, zzgnq zzgnq) throws IOException {
        int zzc = ((zzgqz) zzgrp).zzc(obj, bArr, i2, i3, i4, zzgnq);
        zzgnq.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.android.gms.internal.ads.zzgrp r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzgnq r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.ads.zzgpy r6 = com.google.android.gms.internal.ads.zzgpy.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgnr.zzo(java.lang.Object, com.google.android.gms.internal.ads.zzgrp, byte[], int, int, com.google.android.gms.internal.ads.zzgnq):int");
    }

    static long zzp(byte[] bArr, int i2) {
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | ((((long) bArr[i2 + 7]) & 255) << 56);
    }
}
