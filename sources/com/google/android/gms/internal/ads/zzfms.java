package com.google.android.gms.internal.ads;

import android.os.IBinder;

final class zzfms extends zzfnl {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* synthetic */ zzfms(IBinder iBinder, boolean z2, String str, int i2, float f2, int i3, String str2, int i4, String str3, zzfmr zzfmr) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i2;
        this.zzd = f2;
        this.zze = i4;
        this.zzf = str3;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfnl) {
            zzfnl zzfnl = (zzfnl) obj;
            if (this.zza.equals(zzfnl.zze())) {
                zzfnl.zzi();
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfnl.zzg()) : zzfnl.zzg() == null) {
                    if (this.zzc == zzfnl.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzfnl.zza())) {
                        zzfnl.zzb();
                        zzfnl.zzh();
                        if (this.zze != zzfnl.zzd() || ((str = this.zzf) != null ? !str.equals(zzfnl.zzf()) : zzfnl.zzf() != null)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int hashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int i3 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int floatToIntBits = ((((((((((hashCode * 1000003) ^ 1237) * 1000003) ^ i2) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd)) * 583896283) ^ this.zze) * 1000003;
        String str2 = this.zzf;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return floatToIntBits ^ i3;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        int i2 = this.zzc;
        float f2 = this.zzd;
        int i3 = this.zze;
        String str2 = this.zzf;
        return "OverlayDisplayShowRequest{windowToken=" + obj + ", stableSessionToken=false, appId=" + str + ", layoutGravity=" + i2 + ", layoutVerticalMargin=" + f2 + ", displayMode=0, sessionToken=null, windowWidthPx=" + i3 + ", adFieldEnifd=" + str2 + "}";
    }

    public final float zza() {
        return this.zzd;
    }

    public final int zzb() {
        return 0;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zze;
    }

    public final IBinder zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzb;
    }

    public final String zzh() {
        return null;
    }

    public final boolean zzi() {
        return false;
    }
}
