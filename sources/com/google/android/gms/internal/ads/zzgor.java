package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

final class zzgor extends zzgoo {
    private final OutputStream zzg;

    zzgor(OutputStream outputStream, int i2) {
        super(i2);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i2) throws IOException {
        if (this.zzb - this.zzc < i2) {
            zzG();
        }
    }

    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    public final void zzJ(byte b2) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b2);
    }

    public final void zzK(int i2, boolean z2) throws IOException {
        zzH(11);
        zzf(i2 << 3);
        zzc(z2 ? (byte) 1 : 0);
    }

    public final void zzL(int i2, zzgoe zzgoe) throws IOException {
        zzs((i2 << 3) | 2);
        zzs(zzgoe.zzd());
        zzgoe.zzo(this);
    }

    public final void zza(byte[] bArr, int i2, int i3) throws IOException {
        zzp(bArr, i2, i3);
    }

    public final void zzh(int i2, int i3) throws IOException {
        zzH(14);
        zzf((i2 << 3) | 5);
        zzd(i3);
    }

    public final void zzi(int i2) throws IOException {
        zzH(4);
        zzd(i2);
    }

    public final void zzj(int i2, long j2) throws IOException {
        zzH(18);
        zzf((i2 << 3) | 1);
        zze(j2);
    }

    public final void zzk(long j2) throws IOException {
        zzH(8);
        zze(j2);
    }

    public final void zzl(int i2, int i3) throws IOException {
        zzH(20);
        zzf(i2 << 3);
        if (i3 >= 0) {
            zzf(i3);
        } else {
            zzg((long) i3);
        }
    }

    public final void zzm(int i2) throws IOException {
        if (i2 >= 0) {
            zzs(i2);
        } else {
            zzu((long) i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i2, zzgqw zzgqw, zzgrp zzgrp) throws IOException {
        zzs((i2 << 3) | 2);
        zzs(((zzgnn) zzgqw).zzat(zzgrp));
        zzgrp.zzm(zzgqw, this.zze);
    }

    public final void zzo(int i2, String str) throws IOException {
        zzs((i2 << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.zzb;
        int i5 = this.zzc;
        int i6 = i4 - i5;
        if (i6 >= i3) {
            System.arraycopy(bArr, i2, this.zza, i5, i3);
            this.zzc += i3;
            this.zzd += i3;
            return;
        }
        System.arraycopy(bArr, i2, this.zza, i5, i6);
        int i7 = i2 + i6;
        this.zzc = this.zzb;
        this.zzd += i6;
        zzG();
        int i8 = i3 - i6;
        if (i8 <= this.zzb) {
            System.arraycopy(bArr, i7, this.zza, 0, i8);
            this.zzc = i8;
        } else {
            this.zzg.write(bArr, i7, i8);
        }
        this.zzd += i8;
    }

    public final void zzq(int i2, int i3) throws IOException {
        zzs((i2 << 3) | i3);
    }

    public final void zzr(int i2, int i3) throws IOException {
        zzH(20);
        zzf(i2 << 3);
        zzf(i3);
    }

    public final void zzs(int i2) throws IOException {
        zzH(5);
        zzf(i2);
    }

    public final void zzt(int i2, long j2) throws IOException {
        zzH(20);
        zzf(i2 << 3);
        zzg(j2);
    }

    public final void zzu(long j2) throws IOException {
        zzH(10);
        zzg(j2);
    }

    public final void zzv(String str) throws IOException {
        int i2;
        int i3;
        try {
            int length = str.length() * 3;
            int zzA = zzgot.zzA(length);
            int i4 = zzA + length;
            int i5 = this.zzb;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int zzd = zzgsv.zzd(str, bArr, 0, length);
                zzs(zzd);
                zzp(bArr, 0, zzd);
                return;
            }
            if (i4 > i5 - this.zzc) {
                zzG();
            }
            int zzA2 = zzgot.zzA(str.length());
            i2 = this.zzc;
            if (zzA2 == zzA) {
                int i6 = i2 + zzA2;
                this.zzc = i6;
                int zzd2 = zzgsv.zzd(str, this.zza, i6, this.zzb - i6);
                this.zzc = i2;
                i3 = (zzd2 - i2) - zzA2;
                zzf(i3);
                this.zzc = zzd2;
            } else {
                i3 = zzgsv.zze(str);
                zzf(i3);
                this.zzc = zzgsv.zzd(str, this.zza, this.zzc, i3);
            }
            this.zzd += i3;
        } catch (zzgsu e2) {
            this.zzd -= this.zzc - i2;
            this.zzc = i2;
            throw e2;
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw new zzgoq(e3);
        } catch (zzgsu e4) {
            zzE(str, e4);
        }
    }
}
