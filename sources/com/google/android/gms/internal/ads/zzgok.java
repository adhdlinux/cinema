package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;
import com.startapp.y1;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzgok extends zzgom {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzgok(InputStream inputStream, int i2, zzgoj zzgoj) {
        super((zzgol) null);
        byte[] bArr = zzgpw.zzd;
        this.zze = inputStream;
        this.zzf = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzJ(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int min = Math.min(i2, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.zze.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.zzk += read;
                    i3 += read;
                } else {
                    throw zzgpy.zzj();
                }
            }
            i2 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzK() {
        int i2 = this.zzg + this.zzh;
        this.zzg = i2;
        int i3 = this.zzk + i2;
        int i4 = this.zzl;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.zzh = i5;
            this.zzg = i2 - i5;
            return;
        }
        this.zzh = 0;
    }

    private final void zzL(int i2) throws IOException {
        if (zzM(i2)) {
            return;
        }
        if (i2 > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzgpy.zzi();
        }
        throw zzgpy.zzj();
    }

    private final boolean zzM(int i2) throws IOException {
        int i3 = this.zzi;
        int i4 = i3 + i2;
        int i5 = this.zzg;
        if (i4 > i5) {
            int i6 = this.zzk;
            if (i2 > (Integer.MAX_VALUE - i6) - i3 || i6 + i3 + i2 > this.zzl) {
                return false;
            }
            if (i3 > 0) {
                if (i5 > i3) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                }
                i6 = this.zzk + i3;
                this.zzk = i6;
                i5 = this.zzg - i3;
                this.zzg = i5;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i5, Math.min(4096 - i5, (Integer.MAX_VALUE - i6) - i5));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzK();
                    if (this.zzg >= i2) {
                        return true;
                    }
                    return zzM(i2);
                }
            } catch (zzgpy e2) {
                e2.zzk();
                throw e2;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        }
    }

    private final byte[] zzN(int i2, boolean z2) throws IOException {
        byte[] zzO = zzO(i2);
        if (zzO != null) {
            return zzO;
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzJ = zzJ(i2 - i5);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : zzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return bArr;
    }

    private final byte[] zzO(int i2) throws IOException {
        if (i2 == 0) {
            return zzgpw.zzd;
        }
        if (i2 >= 0) {
            int i3 = this.zzk;
            int i4 = this.zzi;
            int i5 = i3 + i4 + i2;
            if (-2147483647 + i5 <= 0) {
                int i6 = this.zzl;
                if (i5 <= i6) {
                    int i7 = this.zzg - i4;
                    int i8 = i2 - i7;
                    if (i8 >= 4096) {
                        try {
                            if (i8 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzgpy e2) {
                            e2.zzk();
                            throw e2;
                        }
                    }
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i7);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i7 < i2) {
                        try {
                            int read = this.zze.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.zzk += read;
                                i7 += read;
                            } else {
                                throw zzgpy.zzj();
                            }
                        } catch (zzgpy e3) {
                            e3.zzk();
                            throw e3;
                        }
                    }
                    return bArr;
                }
                zzB((i6 - i3) - i4);
                throw zzgpy.zzj();
            }
            throw zzgpy.zzi();
        }
        throw zzgpy.zzf();
    }

    public final void zzA(int i2) {
        this.zzl = i2;
        zzK();
    }

    public final void zzB(int i2) throws IOException {
        int i3 = this.zzg;
        int i4 = this.zzi;
        int i5 = i3 - i4;
        if (i2 <= i5 && i2 >= 0) {
            this.zzi = i4 + i2;
        } else if (i2 >= 0) {
            int i6 = this.zzk;
            int i7 = i6 + i4;
            int i8 = this.zzl;
            if (i7 + i2 <= i8) {
                this.zzk = i7;
                this.zzg = 0;
                this.zzi = 0;
                while (i5 < i2) {
                    try {
                        long j2 = (long) (i2 - i5);
                        long skip = this.zze.skip(j2);
                        int i9 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i9 < 0 || skip > j2) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i9 == 0) {
                            break;
                        } else {
                            i5 += (int) skip;
                        }
                    } catch (zzgpy e2) {
                        e2.zzk();
                        throw e2;
                    } catch (Throwable th) {
                        this.zzk += i5;
                        zzK();
                        throw th;
                    }
                }
                this.zzk += i5;
                zzK();
                if (i5 < i2) {
                    int i10 = this.zzg;
                    int i11 = i10 - this.zzi;
                    this.zzi = i10;
                    zzL(1);
                    while (true) {
                        int i12 = i2 - i11;
                        int i13 = this.zzg;
                        if (i12 > i13) {
                            i11 += i13;
                            this.zzi = i13;
                            zzL(1);
                        } else {
                            this.zzi = i12;
                            return;
                        }
                    }
                }
            } else {
                zzB((i8 - i6) - i4);
                throw zzgpy.zzj();
            }
        } else {
            throw zzgpy.zzf();
        }
    }

    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzM(1);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i2) throws IOException {
        int zzm;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.zzf;
                    int i5 = this.zzi;
                    this.zzi = i5 + 1;
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
        if (this.zzi == this.zzg) {
            zzL(1);
        }
        byte[] bArr = this.zzf;
        int i2 = this.zzi;
        this.zzi = i2 + 1;
        return bArr[i2];
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzk + this.zzi;
    }

    public final int zze(int i2) throws zzgpy {
        if (i2 >= 0) {
            int i3 = this.zzk + this.zzi;
            int i4 = this.zzl;
            int i5 = i2 + i3;
            if (i5 <= i4) {
                this.zzl = i5;
                zzK();
                return i4;
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
        int i2 = this.zzi;
        if (this.zzg - i2 < 4) {
            zzL(4);
            i2 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i2 + 4;
        int i3 = (bArr[i2 + 1] & 255) << 8;
        return ((bArr[i2 + 3] & 255) << 24) | i3 | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] < 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
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
            r5.zzi = r1
            return r0
        L_0x006d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgok.zzj():int");
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
        int i2 = this.zzi;
        if (this.zzg - i2 < 8) {
            zzL(8);
            i2 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i2 + 8;
        long j2 = (long) bArr[i2 + 2];
        long j3 = (long) bArr[i2 + 3];
        long j4 = (long) bArr[i2 + 4];
        long j5 = (long) bArr[i2 + 5];
        long j6 = (long) bArr[i2 + 6];
        long j7 = (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((j2 & 255) << 16) | ((j3 & 255) << 24);
        return ((((long) bArr[i2 + 7]) & 255) << 56) | j7 | ((j4 & 255) << 32) | ((j5 & 255) << 40) | ((j6 & 255) << 48);
    }

    public final long zzr() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        byte b2;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.zzi = i4;
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
                                                    this.zzi = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j4 ^ j7;
                                i5 = i7;
                                this.zzi = i5;
                                return j2;
                            }
                            j3 = j6 ^ j5;
                        }
                    }
                    i5 = i6;
                    j2 = j3;
                    this.zzi = i5;
                    return j2;
                }
                j2 = (long) b2;
                this.zzi = i5;
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
        int i2 = this.zzg;
        int i3 = this.zzi;
        if (zzj2 <= i2 - i3 && zzj2 > 0) {
            zzgoe zzv = zzgoe.zzv(this.zzf, i3, zzj2);
            this.zzi += zzj2;
            return zzv;
        } else if (zzj2 == 0) {
            return zzgoe.zzb;
        } else {
            byte[] zzO = zzO(zzj2);
            if (zzO != null) {
                return zzgoe.zzv(zzO, 0, zzO.length);
            }
            int i4 = this.zzi;
            int i5 = this.zzg;
            int i6 = i5 - i4;
            this.zzk += i5;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzJ = zzJ(zzj2 - i6);
            byte[] bArr = new byte[zzj2];
            System.arraycopy(this.zzf, i4, bArr, 0, i6);
            for (byte[] bArr2 : zzJ) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i6, length);
                i6 += length;
            }
            return new zzgoa(bArr);
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i2 = this.zzg;
            int i3 = this.zzi;
            if (zzj2 <= i2 - i3) {
                String str = new String(this.zzf, i3, zzj2, zzgpw.zzb);
                this.zzi += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 > this.zzg) {
            return new String(zzN(zzj2, false), zzgpw.zzb);
        }
        zzL(zzj2);
        String str2 = new String(this.zzf, this.zzi, zzj2, zzgpw.zzb);
        this.zzi += zzj2;
        return str2;
    }

    public final String zzy() throws IOException {
        byte[] bArr;
        int zzj2 = zzj();
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (zzj2 <= i3 - i2 && zzj2 > 0) {
            bArr = this.zzf;
            this.zzi = i2 + zzj2;
        } else if (zzj2 == 0) {
            return "";
        } else {
            i2 = 0;
            if (zzj2 <= i3) {
                zzL(zzj2);
                bArr = this.zzf;
                this.zzi = zzj2;
            } else {
                bArr = zzN(zzj2, false);
            }
        }
        return zzgsv.zzh(bArr, i2, zzj2);
    }

    public final void zzz(int i2) throws zzgpy {
        if (this.zzj != i2) {
            throw zzgpy.zzb();
        }
    }
}
