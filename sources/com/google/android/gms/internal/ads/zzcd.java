package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzcd extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzcd(String str, Throwable th, boolean z2, int i2) {
        super(str, th);
        this.zza = z2;
        this.zzb = i2;
    }

    public static zzcd zza(String str, Throwable th) {
        return new zzcd(str, th, true, 1);
    }

    public static zzcd zzb(String str, Throwable th) {
        return new zzcd(str, th, true, 0);
    }

    public static zzcd zzc(String str) {
        return new zzcd(str, (Throwable) null, false, 1);
    }

    public final String getMessage() {
        String message = super.getMessage();
        boolean z2 = this.zza;
        int i2 = this.zzb;
        return message + "{contentIsMalformed=" + z2 + ", dataType=" + i2 + "}";
    }
}
