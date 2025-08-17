package com.google.android.gms.internal.ads;

import java.util.Locale;

public final class zzch {
    public static final zzch zza = new zzch(1.0f, 1.0f);
    public static final zzn zzb = zzcg.zza;
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public final float zzc;
    public final float zzd;
    private final int zzg;

    public zzch(float f2, float f3) {
        boolean z2;
        boolean z3 = true;
        if (f2 > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        zzdy.zzd(f3 <= 0.0f ? false : z3);
        this.zzc = f2;
        this.zzd = f3;
        this.zzg = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzch.class == obj.getClass()) {
            zzch zzch = (zzch) obj;
            return this.zzc == zzch.zzc && this.zzd == zzch.zzd;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + 527) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", new Object[]{Float.valueOf(this.zzc), Float.valueOf(this.zzd)});
    }

    public final long zza(long j2) {
        return j2 * ((long) this.zzg);
    }
}
