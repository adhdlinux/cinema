package com.google.android.gms.internal.ads;

final class zzgnx extends zzgoa {
    private final int zzc;
    private final int zzd;

    zzgnx(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzgoe.zzq(i2, i2 + i3, bArr.length);
        this.zzc = i2;
        this.zzd = i3;
    }

    public final byte zza(int i2) {
        zzgoe.zzy(i2, this.zzd);
        return this.zza[this.zzc + i2];
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i2) {
        return this.zza[this.zzc + i2];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zza, this.zzc + i2, bArr, i3, i4);
    }
}
