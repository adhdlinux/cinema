package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

abstract class zzgoo extends zzgot {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzgoo(int i2) {
        super((zzgos) null);
        if (i2 >= 0) {
            byte[] bArr = new byte[Math.max(i2, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(byte b2) {
        byte[] bArr = this.zza;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        bArr[i2] = b2;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i2) {
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
        this.zzd += 4;
    }

    /* access modifiers changed from: package-private */
    public final void zze(long j2) {
        byte[] bArr = this.zza;
        int i2 = this.zzc;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j2 & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j2 >> 8) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j2 >> 16) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (255 & (j2 >> 24)));
        int i7 = i6 + 1;
        bArr[i6] = (byte) (((int) (j2 >> 32)) & JfifUtil.MARKER_FIRST_BYTE);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (((int) (j2 >> 40)) & JfifUtil.MARKER_FIRST_BYTE);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (((int) (j2 >> 48)) & JfifUtil.MARKER_FIRST_BYTE);
        this.zzc = i9 + 1;
        bArr[i9] = (byte) (((int) (j2 >> 56)) & JfifUtil.MARKER_FIRST_BYTE);
        this.zzd += 8;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i2) {
        if (zzgot.zzb) {
            long j2 = (long) this.zzc;
            while ((i2 & -128) != 0) {
                byte[] bArr = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzgsq.zzq(bArr, (long) i3, (byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            zzgsq.zzq(bArr2, (long) i4, (byte) i2);
            this.zzd += (int) (((long) this.zzc) - j2);
            return;
        }
        while ((i2 & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i5 = this.zzc;
            this.zzc = i5 + 1;
            bArr3[i5] = (byte) ((i2 & 127) | 128);
            this.zzd++;
            i2 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        bArr4[i6] = (byte) i2;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(long j2) {
        if (zzgot.zzb) {
            long j3 = (long) this.zzc;
            while ((j2 & -128) != 0) {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                zzgsq.zzq(bArr, (long) i2, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            zzgsq.zzq(bArr2, (long) i3, (byte) ((int) j2));
            this.zzd += (int) (((long) this.zzc) - j3);
            return;
        }
        while ((j2 & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
            this.zzd++;
            j2 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        bArr4[i5] = (byte) ((int) j2);
        this.zzd++;
    }
}
