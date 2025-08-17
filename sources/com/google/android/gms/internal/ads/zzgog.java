package com.google.android.gms.internal.ads;

import com.startapp.y1;
import java.io.IOException;
import java.util.Arrays;

final class zzgog extends zzgom {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk = Integer.MAX_VALUE;

    /* synthetic */ zzgog(byte[] bArr, int i2, int i3, boolean z2, zzgof zzgof) {
        super((zzgol) null);
        this.zze = bArr;
        this.zzf = i3 + i2;
        this.zzh = i2;
        this.zzi = i2;
    }

    private final void zzJ() {
        int i2 = this.zzf + this.zzg;
        this.zzf = i2;
        int i3 = i2 - this.zzi;
        int i4 = this.zzk;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzg = i5;
            this.zzf = i2 - i5;
            return;
        }
        this.zzg = 0;
    }

    public final void zzA(int i2) {
        this.zzk = i2;
        zzJ();
    }

    public final void zzB(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (i2 <= i3 - i4) {
                this.zzh = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i2) throws IOException {
        int zzm;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.zze;
                    int i5 = this.zzh;
                    this.zzh = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzgpy.zze();
            }
            while (i4 < 10) {
                if (zza() < 0) {
                    i4++;
                }
            }
            throw zzgpy.zze();
            return true;
        } else if (i3 == 1) {
            zzB(8);
            return true;
        } else if (i3 == 2) {
            zzB(zzj());
            return true;
        } else if (i3 == 3) {
            do {
                zzm = zzm();
                if (zzm == 0 || !zzE(zzm)) {
                    zzz(((i2 >>> 3) << 3) | 4);
                }
                zzm = zzm();
                break;
            } while (!zzE(zzm));
            zzz(((i2 >>> 3) << 3) | 4);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                zzB(4);
                return true;
            }
            throw zzgpy.zza();
        }
    }

    public final byte zza() throws IOException {
        int i2 = this.zzh;
        if (i2 != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i2 + 1;
            return bArr[i2];
        }
        throw zzgpy.zzj();
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzh - this.zzi;
    }

    public final int zze(int i2) throws zzgpy {
        if (i2 >= 0) {
            int i3 = i2 + (this.zzh - this.zzi);
            if (i3 >= 0) {
                int i4 = this.zzk;
                if (i3 <= i4) {
                    this.zzk = i3;
                    zzJ();
                    return i4;
                }
                throw zzgpy.zzj();
            }
            throw zzgpy.zzg();
        }
        throw zzgpy.zzf();
    }

    public final int zzf() throws IOException {
        return zzj();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i2 = this.zzh;
        if (this.zzf - i2 >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i2 + 4;
            int i3 = (bArr[i2 + 1] & 255) << 8;
            return ((bArr[i2 + 3] & 255) << 24) | i3 | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw zzgpy.zzj();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] < 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzh = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x006a
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r5.zzh = r1
            return r0
        L_0x006d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgog.zzj():int");
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzgom.zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzj = zzj2;
        if ((zzj2 >>> 3) != 0) {
            return zzj2;
        }
        throw zzgpy.zzc();
    }

    public final int zzn() throws IOException {
        return zzj();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i2 = this.zzh;
        if (this.zzf - i2 >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i2 + 8;
            long j2 = (long) bArr[i2 + 2];
            long j3 = (long) bArr[i2 + 3];
            long j4 = (long) bArr[i2 + 4];
            long j5 = (long) bArr[i2 + 5];
            long j6 = (long) bArr[i2 + 6];
            long j7 = (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((j2 & 255) << 16) | ((j3 & 255) << 24);
            return ((((long) bArr[i2 + 7]) & 255) << 56) | j7 | ((j4 & 255) << 32) | ((j5 & 255) << 40) | ((j6 & 255) << 48);
        }
        throw zzgpy.zzj();
    }

    public final long zzr() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        byte b2;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.zzh = i4;
                return (long) b3;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                byte b4 = b3 ^ (bArr[i4] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ y1.f36938c;
                } else {
                    int i6 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 14);
                    if (b5 >= 0) {
                        j3 = (long) (b5 ^ y1.f36938c);
                    } else {
                        i5 = i6 + 1;
                        byte b6 = b5 ^ (bArr[i6] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ y1.f36938c;
                        } else {
                            i6 = i5 + 1;
                            long j6 = ((long) b6) ^ (((long) bArr[i5]) << 28);
                            if (j6 >= 0) {
                                j5 = 266354560;
                            } else {
                                int i7 = i6 + 1;
                                long j7 = j6 ^ (((long) bArr[i6]) << 35);
                                if (j7 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    i6 = i7 + 1;
                                    j6 = j7 ^ (((long) bArr[i7]) << 42);
                                    if (j6 >= 0) {
                                        j5 = 4363953127296L;
                                    } else {
                                        i7 = i6 + 1;
                                        j7 = j6 ^ (((long) bArr[i6]) << 49);
                                        if (j7 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            i6 = i7 + 1;
                                            j3 = (j7 ^ (((long) bArr[i7]) << 56)) ^ 71499008037633920L;
                                            if (j3 < 0) {
                                                i7 = i6 + 1;
                                                if (((long) bArr[i6]) >= 0) {
                                                    j2 = j3;
                                                    i5 = i7;
                                                    this.zzh = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j4 ^ j7;
                                i5 = i7;
                                this.zzh = i5;
                                return j2;
                            }
                            j3 = j6 ^ j5;
                        }
                    }
                    i5 = i6;
                    j2 = j3;
                    this.zzh = i5;
                    return j2;
                }
                j2 = (long) b2;
                this.zzh = i5;
                return j2;
            }
        }
        return zzs();
    }

    /* access modifiers changed from: package-private */
    public final long zzs() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zza = zza();
            j2 |= ((long) (zza & Byte.MAX_VALUE)) << i2;
            if ((zza & y1.f36938c) == 0) {
                return j2;
            }
        }
        throw zzgpy.zze();
    }

    public final long zzt() throws IOException {
        return zzq();
    }

    public final long zzu() throws IOException {
        return zzgom.zzG(zzr());
    }

    public final long zzv() throws IOException {
        return zzr();
    }

    public final zzgoe zzw() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (zzj2 <= i2 - i3) {
                zzgoe zzv = zzgoe.zzv(this.zze, i3, zzj2);
                this.zzh += zzj2;
                return zzv;
            }
        }
        if (zzj2 == 0) {
            return zzgoe.zzb;
        }
        if (zzj2 > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (zzj2 <= i4 - i5) {
                int i6 = zzj2 + i5;
                this.zzh = i6;
                return new zzgoa(Arrays.copyOfRange(this.zze, i5, i6));
            }
        }
        if (zzj2 <= 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (zzj2 <= i2 - i3) {
                String str = new String(this.zze, i3, zzj2, zzgpw.zzb);
                this.zzh += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 < 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (zzj2 <= i2 - i3) {
                String zzh2 = zzgsv.zzh(this.zze, i3, zzj2);
                this.zzh += zzj2;
                return zzh2;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 <= 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    public final void zzz(int i2) throws zzgpy {
        if (this.zzj != i2) {
            throw zzgpy.zzb();
        }
    }
}
