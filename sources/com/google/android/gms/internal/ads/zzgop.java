package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

final class zzgop extends zzgot {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzgop(byte[] bArr, int i2, int i3) {
        super((zzgos) null);
        int length = bArr.length;
        if (((length - i3) | i3) >= 0) {
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i3;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i3)}));
    }

    public final void zzI() {
    }

    public final void zzJ(byte b2) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e2);
        }
    }

    public final void zzK(int i2, boolean z2) throws IOException {
        zzs(i2 << 3);
        zzJ(z2 ? (byte) 1 : 0);
    }

    public final void zzL(int i2, zzgoe zzgoe) throws IOException {
        zzs((i2 << 3) | 2);
        zzs(zzgoe.zzd());
        zzgoe.zzo(this);
    }

    public final void zza(byte[] bArr, int i2, int i3) throws IOException {
        zze(bArr, i2, i3);
    }

    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i2, int i3) throws IOException {
        try {
            System.arraycopy(bArr, i2, this.zza, this.zzc, i3);
            this.zzc += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i3)}), e2);
        }
    }

    public final void zzh(int i2, int i3) throws IOException {
        zzs((i2 << 3) | 5);
        zzi(i3);
    }

    public final void zzi(int i2) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            this.zzc = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e2);
        }
    }

    public final void zzj(int i2, long j2) throws IOException {
        zzs((i2 << 3) | 1);
        zzk(j2);
    }

    public final void zzk(long j2) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((int) j2) & JfifUtil.MARKER_FIRST_BYTE);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & JfifUtil.MARKER_FIRST_BYTE);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & JfifUtil.MARKER_FIRST_BYTE);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & JfifUtil.MARKER_FIRST_BYTE);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & JfifUtil.MARKER_FIRST_BYTE);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & JfifUtil.MARKER_FIRST_BYTE);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & JfifUtil.MARKER_FIRST_BYTE);
            this.zzc = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e2);
        }
    }

    public final void zzl(int i2, int i3) throws IOException {
        zzs(i2 << 3);
        zzm(i3);
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
        zzp(str);
    }

    public final void zzp(String str) throws IOException {
        int i2 = this.zzc;
        try {
            int zzA = zzgot.zzA(str.length() * 3);
            int zzA2 = zzgot.zzA(str.length());
            if (zzA2 == zzA) {
                int i3 = i2 + zzA2;
                this.zzc = i3;
                int zzd = zzgsv.zzd(str, this.zza, i3, this.zzb - i3);
                this.zzc = i2;
                zzs((zzd - i2) - zzA2);
                this.zzc = zzd;
                return;
            }
            zzs(zzgsv.zze(str));
            byte[] bArr = this.zza;
            int i4 = this.zzc;
            this.zzc = zzgsv.zzd(str, bArr, i4, this.zzb - i4);
        } catch (zzgsu e2) {
            this.zzc = i2;
            zzE(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzgoq(e3);
        }
    }

    public final void zzq(int i2, int i3) throws IOException {
        zzs((i2 << 3) | i3);
    }

    public final void zzr(int i2, int i3) throws IOException {
        zzs(i2 << 3);
        zzs(i3);
    }

    public final void zzs(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            bArr[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr2[i4] = (byte) i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e2);
        }
    }

    public final void zzt(int i2, long j2) throws IOException {
        zzs(i2 << 3);
        zzu(j2);
    }

    public final void zzu(long j2) throws IOException {
        if (!zzgot.zzb || this.zzb - this.zzc < 10) {
            while ((j2 & -128) != 0) {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                bArr2[i3] = (byte) ((int) j2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzgoq(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e2);
            }
        } else {
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzgsq.zzq(bArr3, (long) i4, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            zzgsq.zzq(bArr4, (long) i5, (byte) ((int) j2));
        }
    }
}
