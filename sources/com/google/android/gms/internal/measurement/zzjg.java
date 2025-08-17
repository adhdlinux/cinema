package com.google.android.gms.internal.measurement;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

final class zzjg extends zzjj {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzjg(byte[] bArr, int i2, int i3) {
        super((zzji) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i3) | i3) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i3)}));
        }
        throw new NullPointerException("buffer");
    }

    public final int zza() {
        return this.zzc - this.zzd;
    }

    public final void zzb(byte b2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e2);
        }
    }

    public final void zzc(byte[] bArr, int i2, int i3) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i3);
            this.zzd += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i3)}), e2);
        }
    }

    public final void zzd(int i2, boolean z2) throws IOException {
        zzq(i2 << 3);
        zzb(z2 ? (byte) 1 : 0);
    }

    public final void zze(int i2, zzjb zzjb) throws IOException {
        zzq((i2 << 3) | 2);
        zzq(zzjb.zzd());
        zzjb.zzh(this);
    }

    public final void zzf(int i2, int i3) throws IOException {
        zzq((i2 << 3) | 5);
        zzg(i3);
    }

    public final void zzg(int i2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            this.zzd = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e2);
        }
    }

    public final void zzh(int i2, long j2) throws IOException {
        zzq((i2 << 3) | 1);
        zzi(j2);
    }

    public final void zzi(long j2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
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
            this.zzd = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e2);
        }
    }

    public final void zzj(int i2, int i3) throws IOException {
        zzq(i2 << 3);
        zzk(i3);
    }

    public final void zzk(int i2) throws IOException {
        if (i2 >= 0) {
            zzq(i2);
        } else {
            zzs((long) i2);
        }
    }

    public final void zzl(byte[] bArr, int i2, int i3) throws IOException {
        zzc(bArr, 0, i3);
    }

    public final void zzm(int i2, String str) throws IOException {
        zzq((i2 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i2 = this.zzd;
        try {
            int zzA = zzjj.zzA(str.length() * 3);
            int zzA2 = zzjj.zzA(str.length());
            if (zzA2 == zzA) {
                int i3 = i2 + zzA2;
                this.zzd = i3;
                int zzb2 = zzna.zzb(str, this.zzb, i3, this.zzc - i3);
                this.zzd = i2;
                zzq((zzb2 - i2) - zzA2);
                this.zzd = zzb2;
                return;
            }
            zzq(zzna.zzc(str));
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
            this.zzd = zzna.zzb(str, bArr, i4, this.zzc - i4);
        } catch (zzmz e2) {
            this.zzd = i2;
            zzE(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzjh(e3);
        }
    }

    public final void zzo(int i2, int i3) throws IOException {
        zzq((i2 << 3) | i3);
    }

    public final void zzp(int i2, int i3) throws IOException {
        zzq(i2 << 3);
        zzq(i3);
    }

    public final void zzq(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr2[i4] = (byte) i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e2);
        }
    }

    public final void zzr(int i2, long j2) throws IOException {
        zzq(i2 << 3);
        zzs(j2);
    }

    public final void zzs(long j2) throws IOException {
        if (!zzjj.zzc || this.zzc - this.zzd < 10) {
            while ((j2 & -128) != 0) {
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr2[i3] = (byte) ((int) j2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e2);
            }
        } else {
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                zzmv.zzn(bArr3, (long) i4, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            zzmv.zzn(bArr4, (long) i5, (byte) ((int) j2));
        }
    }
}
