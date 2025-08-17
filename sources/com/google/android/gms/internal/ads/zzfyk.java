package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzfyk implements Comparable {
    private final byte[] zza;

    /* synthetic */ zzfyk(byte[] bArr, zzfyj zzfyj) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfyk zzfyk = (zzfyk) obj;
        int length = this.zza.length;
        int length2 = zzfyk.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i2 >= bArr.length) {
                return 0;
            }
            byte b2 = bArr[i2];
            byte b3 = zzfyk.zza[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfyk)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfyk) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzgmz.zza(this.zza);
    }
}
