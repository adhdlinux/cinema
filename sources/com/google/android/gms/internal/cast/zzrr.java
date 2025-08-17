package com.google.android.gms.internal.cast;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

final class zzrr extends zzru {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzrr(byte[] bArr, int i2, int i3) {
        super((zzrt) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i3) | i3) >= 0) {
                this.zzc = bArr;
                this.zze = 0;
                this.zzd = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i3)}));
        }
        throw new NullPointerException("buffer");
    }

    public final int zza() {
        return this.zzd - this.zze;
    }

    public final void zzb(byte b2) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
            this.zze = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
        }
    }

    public final void zzc(byte[] bArr, int i2, int i3) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i3);
            this.zze += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i3)}), e2);
        }
    }

    public final void zzd(int i2, boolean z2) throws IOException {
        zzq(i2 << 3);
        zzb(z2 ? (byte) 1 : 0);
    }

    public final void zze(int i2, zzrm zzrm) throws IOException {
        zzq((i2 << 3) | 2);
        zzq(zzrm.zzd());
        zzrm.zzh(this);
    }

    public final void zzf(int i2, int i3) throws IOException {
        zzq((i2 << 3) | 5);
        zzg(i3);
    }

    public final void zzg(int i2) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            this.zze = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
        }
    }

    public final void zzh(int i2, long j2) throws IOException {
        zzq((i2 << 3) | 1);
        zzi(j2);
    }

    public final void zzi(long j2) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
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
            this.zze = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & JfifUtil.MARKER_FIRST_BYTE);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
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
        int i2 = this.zze;
        try {
            int zzx = zzru.zzx(str.length() * 3);
            int zzx2 = zzru.zzx(str.length());
            if (zzx2 == zzx) {
                int i3 = i2 + zzx2;
                this.zze = i3;
                int zzb = zzvf.zzb(str, this.zzc, i3, this.zzd - i3);
                this.zze = i2;
                zzq((zzb - i2) - zzx2);
                this.zze = zzb;
                return;
            }
            zzq(zzvf.zzc(str));
            byte[] bArr = this.zzc;
            int i4 = this.zze;
            this.zze = zzvf.zzb(str, bArr, i4, this.zzd - i4);
        } catch (zzve e2) {
            this.zze = i2;
            zzB(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzrs(e3);
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
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            this.zze = i3 + 1;
            bArr[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzc;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr2[i4] = (byte) i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
        }
    }

    public final void zzr(int i2, long j2) throws IOException {
        zzq(i2 << 3);
        zzs(j2);
    }

    public final void zzs(long j2) throws IOException {
        if (!zzru.zzd || this.zzd - this.zze < 10) {
            while ((j2 & -128) != 0) {
                byte[] bArr = this.zzc;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzc;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr2[i3] = (byte) ((int) j2);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzrs(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e2);
            }
        } else {
            while ((j2 & -128) != 0) {
                byte[] bArr3 = this.zzc;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzvb.zzn(bArr3, (long) i4, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr4 = this.zzc;
            int i5 = this.zze;
            this.zze = i5 + 1;
            zzvb.zzn(bArr4, (long) i5, (byte) ((int) j2));
        }
    }
}
