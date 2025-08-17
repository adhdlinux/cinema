package com.google.android.gms.internal.ads;

import android.os.IBinder;

final class zzfmq extends zzfnk {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    zzfmq() {
    }

    public final zzfnk zza(String str) {
        this.zzf = str;
        return this;
    }

    public final zzfnk zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfnk zzc(int i2) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    public final zzfnk zzd(int i2) {
        this.zzc = i2;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    public final zzfnk zze(float f2) {
        this.zzd = f2;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    public final zzfnk zzf(boolean z2) {
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    public final zzfnk zzg(IBinder iBinder) {
        if (iBinder != null) {
            this.zza = iBinder;
            return this;
        }
        throw new NullPointerException("Null windowToken");
    }

    public final zzfnk zzh(int i2) {
        this.zze = i2;
        this.zzg = (byte) (this.zzg | 16);
        return this;
    }

    public final zzfnl zzi() {
        IBinder iBinder;
        if (this.zzg == 31 && (iBinder = this.zza) != null) {
            return new zzfms(iBinder, false, this.zzb, this.zzc, this.zzd, 0, (String) null, this.zze, this.zzf, (zzfmr) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" windowToken");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" stableSessionToken");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" layoutGravity");
        }
        if ((this.zzg & 4) == 0) {
            sb.append(" layoutVerticalMargin");
        }
        if ((this.zzg & 8) == 0) {
            sb.append(" displayMode");
        }
        if ((this.zzg & 16) == 0) {
            sb.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
