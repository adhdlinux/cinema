package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdp {
    public static final zzdp zza = new zzdp(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzdp(int i2, int i3, int i4) {
        int i5;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        if (zzfj.zzD(i4)) {
            i5 = zzfj.zzk(i4, i3);
        } else {
            i5 = -1;
        }
        this.zze = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return false;
        }
        zzdp zzdp = (zzdp) obj;
        if (this.zzb == zzdp.zzb && this.zzc == zzdp.zzc && this.zzd == zzdp.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        int i2 = this.zzb;
        int i3 = this.zzc;
        int i4 = this.zzd;
        return "AudioFormat[sampleRate=" + i2 + ", channelCount=" + i3 + ", encoding=" + i4 + "]";
    }
}
