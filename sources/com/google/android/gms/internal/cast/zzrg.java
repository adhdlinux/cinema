package com.google.android.gms.internal.cast;

final class zzrg extends zzrj {
    private final int zzc;

    zzrg(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzrm.zzj(0, i3, bArr.length);
        this.zzc = i3;
    }

    public final byte zza(int i2) {
        int i3 = this.zzc;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.zza[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i2) {
        return this.zza[i2];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
