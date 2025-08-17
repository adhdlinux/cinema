package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzfa {
    private static final zzfsh zza = zzfsh.zzo(zzfot.zza, zzfot.zzc, zzfot.zzf, zzfot.zzd, zzfot.zze);
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfa() {
        this.zzb = zzfj.zzf;
    }

    public zzfa(byte[] bArr, int i2) {
        this.zzb = bArr;
        this.zzd = i2;
    }

    public final void zzA(zzez zzez, int i2) {
        zzB(zzez.zza, 0, i2);
        zzez.zzj(0);
    }

    public final void zzB(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc, bArr, i2, i3);
        this.zzc += i3;
    }

    public final void zzC(int i2) {
        byte[] bArr = this.zzb;
        if (bArr.length < i2) {
            bArr = new byte[i2];
        }
        zzD(bArr, i2);
    }

    public final void zzD(byte[] bArr, int i2) {
        this.zzb = bArr;
        this.zzd = i2;
        this.zzc = 0;
    }

    public final void zzE(int i2) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= this.zzb.length) {
            z2 = true;
        }
        zzdy.zzd(z2);
        this.zzd = i2;
    }

    public final void zzF(int i2) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= this.zzd) {
            z2 = true;
        }
        zzdy.zzd(z2);
        this.zzc = i2;
    }

    public final void zzG(int i2) {
        zzF(this.zzc + i2);
    }

    public final byte[] zzH() {
        return this.zzb;
    }

    public final int zza() {
        return this.zzd - this.zzc;
    }

    public final int zzb() {
        return this.zzb.length;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        this.zzc = i5 + 1;
        return (bArr[i5] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
    }

    public final int zzf() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        this.zzc = i4 + 1;
        return (bArr[i4] & 255) | (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
    }

    public final int zzg() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        this.zzc = i5 + 1;
        return ((bArr[i5] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16);
    }

    public final int zzh() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException("Top bit not zero: " + zzg);
    }

    public final int zzi() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public final int zzj() {
        return (zzk() << 21) | (zzk() << 14) | (zzk() << 7) | zzk();
    }

    public final int zzk() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int zzl() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3 + 1 + 2;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public final int zzm() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        this.zzc = i4 + 1;
        return (bArr[i4] & 255) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public final int zzn() {
        int zze = zze();
        if (zze >= 0) {
            return zze;
        }
        throw new IllegalStateException("Top bit not zero: " + zze);
    }

    public final int zzo() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3 + 1;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public final long zzp() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        int i6 = i5 + 1;
        long j5 = (long) bArr[i5];
        int i7 = i6 + 1;
        long j6 = (long) bArr[i6];
        int i8 = i7 + 1;
        long j7 = (long) bArr[i7];
        int i9 = i8 + 1;
        long j8 = j2;
        long j9 = (long) bArr[i8];
        this.zzc = i9 + 1;
        long j10 = (j9 & 255) << 48;
        return ((((long) bArr[i9]) & 255) << 56) | j10 | (j8 & 255) | ((j3 & 255) << 8) | ((j4 & 255) << 16) | ((j5 & 255) << 24) | ((j6 & 255) << 32) | ((j7 & 255) << 40);
    }

    public final long zzq() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        this.zzc = i5 + 1;
        return ((((long) bArr[i5]) & 255) << 24) | (j2 & 255) | ((j3 & 255) << 8) | ((j4 & 255) << 16);
    }

    public final long zzr() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        int i6 = i5 + 1;
        long j5 = (long) bArr[i5];
        int i7 = i6 + 1;
        long j6 = (long) bArr[i6];
        int i8 = i7 + 1;
        long j7 = (long) bArr[i7];
        int i9 = i8 + 1;
        long j8 = j7;
        long j9 = (long) bArr[i8];
        this.zzc = i9 + 1;
        return (((long) bArr[i9]) & 255) | ((j2 & 255) << 56) | ((j3 & 255) << 48) | ((j4 & 255) << 40) | ((j5 & 255) << 32) | ((j6 & 255) << 24) | ((j8 & 255) << 16) | ((j9 & 255) << 8);
    }

    public final long zzs() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        int i4 = i3 + 1;
        long j3 = (long) bArr[i3];
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        this.zzc = i5 + 1;
        return (((long) bArr[i5]) & 255) | ((j2 & 255) << 24) | ((j3 & 255) << 16) | ((j4 & 255) << 8);
    }

    public final long zzt() {
        long zzr = zzr();
        if (zzr >= 0) {
            return zzr;
        }
        throw new IllegalStateException("Top bit not zero: " + zzr);
    }

    public final long zzu() {
        int i2;
        int i3;
        long j2 = (long) this.zzb[this.zzc];
        int i4 = 7;
        while (true) {
            i2 = 0;
            i3 = 1;
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i2 = 7 - i4;
            } else if (i4 == 7) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            while (i3 < i2) {
                byte b2 = this.zzb[this.zzc + i3];
                if ((b2 & 192) == 128) {
                    j2 = (j2 << 6) | ((long) (b2 & 63));
                    i3++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.zzc += i2;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    public final String zzv(char c2) {
        int i2 = this.zzd;
        int i3 = this.zzc;
        if (i2 - i3 == 0) {
            return null;
        }
        while (i3 < this.zzd && this.zzb[i3] != 0) {
            i3++;
        }
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        String zzw = zzfj.zzw(bArr, i4, i3 - i4);
        this.zzc = i3;
        if (i3 < this.zzd) {
            this.zzc = i3 + 1;
        }
        return zzw;
    }

    public final String zzw(int i2) {
        int i3;
        if (i2 == 0) {
            return "";
        }
        int i4 = this.zzc;
        int i5 = (i4 + i2) - 1;
        if (i5 >= this.zzd || this.zzb[i5] != 0) {
            i3 = i2;
        } else {
            i3 = i2 - 1;
        }
        String zzw = zzfj.zzw(this.zzb, i4, i3);
        this.zzc += i2;
        return zzw;
    }

    public final String zzx(int i2, Charset charset) {
        byte[] bArr = this.zzb;
        int i3 = this.zzc;
        String str = new String(bArr, i3, i2, charset);
        this.zzc = i3 + i2;
        return str;
    }

    public final short zzy() {
        byte[] bArr = this.zzb;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3 + 1;
        return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
    }

    public final void zzz(int i2) {
        byte[] bArr = this.zzb;
        if (i2 > bArr.length) {
            this.zzb = Arrays.copyOf(bArr, i2);
        }
    }

    public zzfa(int i2) {
        this.zzb = new byte[i2];
        this.zzd = i2;
    }

    public zzfa(byte[] bArr) {
        this.zzb = bArr;
        this.zzd = bArr.length;
    }
}
