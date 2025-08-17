package com.google.android.gms.ads;

import java.util.Locale;

public class VersionInfo {
    protected final int zza;
    protected final int zzb;
    protected final int zzc;

    public VersionInfo(int i2, int i3, int i4) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
    }

    public int getMajorVersion() {
        return this.zza;
    }

    public int getMicroVersion() {
        return this.zzc;
    }

    public int getMinorVersion() {
        return this.zzb;
    }

    public String toString() {
        return String.format(Locale.US, "%d.%d.%d", new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }
}
