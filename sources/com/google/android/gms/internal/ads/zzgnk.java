package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgnk {
    private final byte[] zza;

    private zzgnk(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
    }

    public static zzgnk zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzgnk(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnk)) {
            return false;
        }
        return Arrays.equals(((zzgnk) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza2 = zzgmz.zza(this.zza);
        return "Bytes(" + zza2 + ")";
    }

    public final int zza() {
        return this.zza.length;
    }
}
