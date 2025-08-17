package com.google.android.gms.internal.ads;

import com.startapp.y1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzgoi extends zzgom {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* synthetic */ zzgoi(Iterable iterable, int i2, boolean z2, zzgoh zzgoh) {
        super((zzgol) null);
        this.zzh = i2;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i2 == 0) {
            this.zzg = zzgpw.zze;
            this.zzm = 0;
            this.zzn = 0;
            this.zzo = 0;
            return;
        }
        zzN();
    }

    private final int zzJ() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzK() throws zzgpy {
        if (this.zzf.hasNext()) {
            zzN();
            return;
        }
        throw zzgpy.zzj();
    }

    private final void zzL(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 <= zzJ()) {
            int i4 = i3;
            while (i4 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzK();
                }
                int min = Math.min(i4, (int) (this.zzo - this.zzm));
                long j2 = (long) min;
                zzgsq.zzo(this.zzm, bArr, (long) (i3 - i4), j2);
                i4 -= min;
                this.zzm += j2;
            }
        } else if (i3 > 0) {
            throw zzgpy.zzj();
        }
    }

    private final void zzM() {
        int i2 = this.zzh + this.zzi;
        this.zzh = i2;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzi = i4;
            this.zzh = i2 - i4;
            return;
        }
        this.zzi = 0;
    }

    private final void zzN() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = (long) byteBuffer.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = (long) this.zzg.limit();
        long zze2 = zzgsq.zze(this.zzg);
        this.zzm += zze2;
        this.zzn += zze2;
        this.zzo += zze2;
    }

    public final void zzA(int i2) {
        this.zzj = i2;
        zzM();
    }

    public final void zzB(int i2) throws IOException {
        if (i2 >= 0) {
            if (((long) i2) <= (((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn) {
                while (i2 > 0) {
                    if (this.zzo - this.zzm == 0) {
                        zzK();
                    }
                    int min = Math.min(i2, (int) (this.zzo - this.zzm));
                    i2 -= min;
                    this.zzm += (long) min;
                }
                return;
            }
        }
        if (i2 < 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    public final boolean zzC() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i2) throws IOException {
        int zzm2;
        int i3 = i2 & 7;
        if (i3 == 0) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (zza() >= 0) {
                    return true;
                }
            }
            throw zzgpy.zze();
        } else if (i3 == 1) {
            zzB(8);
            return true;
        } else if (i3 == 2) {
            zzB(zzj());
            return true;
        } else if (i3 == 3) {
            do {
                zzm2 = zzm();
                if (zzm2 == 0 || !zzE(zzm2)) {
                    zzz(((i2 >>> 3) << 3) | 4);
                }
                zzm2 = zzm();
                break;
            } while (!zzE(zzm2));
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
        if (this.zzo - this.zzm == 0) {
            zzK();
        }
        long j2 = this.zzm;
        this.zzm = 1 + j2;
        return zzgsq.zza(j2);
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    public final int zze(int i2) throws zzgpy {
        if (i2 >= 0) {
            int zzd = i2 + zzd();
            int i3 = this.zzj;
            if (zzd <= i3) {
                this.zzj = zzd;
                zzM();
                return i3;
            }
            throw zzgpy.zzj();
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
        long j2 = this.zzo;
        long j3 = this.zzm;
        if (j2 - j3 >= 4) {
            this.zzm = 4 + j3;
            return (zzgsq.zza(j3) & 255) | ((zzgsq.zza(1 + j3) & 255) << 8) | ((zzgsq.zza(2 + j3) & 255) << 16) | ((zzgsq.zza(j3 + 3) & 255) << 24);
        }
        return (zza() & 255) | ((zza() & 255) << 8) | ((zza() & 255) << 16) | ((zza() & 255) << 24);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzgsq.zza(r4) >= 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x000a
            goto L_0x008c
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzgsq.zza(r0)
            if (r0 < 0) goto L_0x001a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L_0x001a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x008c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0033
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0089
        L_0x0033:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0042
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x0040:
            r6 = r4
            goto L_0x0089
        L_0x0042:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0052
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0089
        L_0x0052:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 < 0) goto L_0x008c
        L_0x0089:
            r10.zzm = r6
            return r0
        L_0x008c:
            long r0 = r10.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgoi.zzj():int");
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzgom.zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzk = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzk = zzj2;
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
        long j2 = this.zzo;
        long j3 = this.zzm;
        if (j2 - j3 >= 8) {
            this.zzm = 8 + j3;
            byte zza = zzgsq.zza(j3 + 4);
            long zza2 = (((long) zzgsq.zza(3 + j3)) & 255) << 24;
            byte zza3 = zzgsq.zza(j3 + 6);
            return (((long) zzgsq.zza(j3)) & 255) | ((((long) zzgsq.zza(1 + j3)) & 255) << 8) | ((((long) zzgsq.zza(j3 + 2)) & 255) << 16) | zza2 | ((((long) zza) & 255) << 32) | ((((long) zzgsq.zza(5 + j3)) & 255) << 40) | ((((long) zza3) & 255) << 48) | ((((long) zzgsq.zza(j3 + 7)) & 255) << 56);
        }
        long zza4 = (((long) zza()) & 255) << 32;
        long zza5 = (((long) zza()) & 255) << 40;
        return (((long) zza()) & 255) | ((((long) zza()) & 255) << 8) | ((((long) zza()) & 255) << 16) | ((((long) zza()) & 255) << 24) | zza4 | zza5 | ((((long) zza()) & 255) << 48) | ((((long) zza()) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long j2;
        long j3;
        long j4;
        byte b2;
        long j5 = this.zzm;
        if (this.zzo != j5) {
            long j6 = j5 + 1;
            byte zza = zzgsq.zza(j5);
            if (zza >= 0) {
                this.zzm++;
                return (long) zza;
            } else if (this.zzo - this.zzm >= 10) {
                long j7 = j6 + 1;
                byte zza2 = zza ^ (zzgsq.zza(j6) << 7);
                if (zza2 < 0) {
                    b2 = zza2 ^ y1.f36938c;
                } else {
                    long j8 = j7 + 1;
                    byte zza3 = zza2 ^ (zzgsq.zza(j7) << 14);
                    if (zza3 >= 0) {
                        j2 = (long) (zza3 ^ y1.f36938c);
                    } else {
                        j7 = j8 + 1;
                        byte zza4 = zza3 ^ (zzgsq.zza(j8) << 21);
                        if (zza4 < 0) {
                            b2 = zza4 ^ y1.f36938c;
                        } else {
                            j8 = j7 + 1;
                            long zza5 = ((long) zza4) ^ (((long) zzgsq.zza(j7)) << 28);
                            if (zza5 >= 0) {
                                j4 = 266354560;
                            } else {
                                long j9 = j8 + 1;
                                long zza6 = zza5 ^ (((long) zzgsq.zza(j8)) << 35);
                                if (zza6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    j8 = j9 + 1;
                                    zza5 = zza6 ^ (((long) zzgsq.zza(j9)) << 42);
                                    if (zza5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        j9 = j8 + 1;
                                        zza6 = zza5 ^ (((long) zzgsq.zza(j8)) << 49);
                                        if (zza6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j8 = j9 + 1;
                                            j2 = (zza6 ^ (((long) zzgsq.zza(j9)) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                long j10 = 1 + j8;
                                                if (((long) zzgsq.zza(j8)) >= 0) {
                                                    j7 = j10;
                                                    this.zzm = j7;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = zza6 ^ j3;
                                j7 = j9;
                                this.zzm = j7;
                                return j2;
                            }
                            j2 = zza5 ^ j4;
                        }
                    }
                    j7 = j8;
                    this.zzm = j7;
                    return j2;
                }
                j2 = (long) b2;
                this.zzm = j7;
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
            long j2 = this.zzo;
            long j3 = this.zzm;
            long j4 = (long) zzj2;
            if (j4 <= j2 - j3) {
                byte[] bArr = new byte[zzj2];
                zzgsq.zzo(j3, bArr, 0, j4);
                this.zzm += j4;
                return new zzgoa(bArr);
            }
        }
        if (zzj2 > 0 && zzj2 <= zzJ()) {
            byte[] bArr2 = new byte[zzj2];
            zzL(bArr2, 0, zzj2);
            return new zzgoa(bArr2);
        } else if (zzj2 == 0) {
            return zzgoe.zzb;
        } else {
            if (zzj2 < 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j2 = this.zzo;
            long j3 = this.zzm;
            long j4 = (long) zzj2;
            if (j4 <= j2 - j3) {
                byte[] bArr = new byte[zzj2];
                zzgsq.zzo(j3, bArr, 0, j4);
                String str = new String(bArr, zzgpw.zzb);
                this.zzm += j4;
                return str;
            }
        }
        if (zzj2 > 0 && zzj2 <= zzJ()) {
            byte[] bArr2 = new byte[zzj2];
            zzL(bArr2, 0, zzj2);
            return new String(bArr2, zzgpw.zzb);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 < 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j2 = this.zzo;
            long j3 = this.zzm;
            long j4 = (long) zzj2;
            if (j4 <= j2 - j3) {
                String zzg2 = zzgsv.zzg(this.zzg, (int) (j3 - this.zzn), zzj2);
                this.zzm += j4;
                return zzg2;
            }
        }
        if (zzj2 >= 0 && zzj2 <= zzJ()) {
            byte[] bArr = new byte[zzj2];
            zzL(bArr, 0, zzj2);
            return zzgsv.zzh(bArr, 0, zzj2);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    public final void zzz(int i2) throws zzgpy {
        if (this.zzk != i2) {
            throw zzgpy.zzb();
        }
    }
}
