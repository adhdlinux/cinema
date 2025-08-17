package com.google.android.gms.internal.ads;

final class zzfjf extends zzfjc {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    zzfjf() {
    }

    public final zzfjc zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfjc zzb(boolean z2) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzfjc zzc(boolean z2) {
        this.zzb = z2;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    public final zzfjd zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzfjh(str, this.zzb, this.zzc, (zzfjg) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
