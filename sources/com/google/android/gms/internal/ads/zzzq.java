package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

public final class zzzq {
    private final Handler zza;
    private final zzzr zzb;

    public zzzq(Handler handler, zzzr zzzr) {
        this.zza = zzzr == null ? null : handler;
        this.zzb = zzzr;
    }

    public final void zza(String str, long j2, long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzm(this, str, j2, j3));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzp(this, str));
        }
    }

    public final void zzc(zzhz zzhz) {
        zzhz.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzl(this, zzhz));
        }
    }

    public final void zzd(int i2, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzg(this, i2, j2));
        }
    }

    public final void zze(zzhz zzhz) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzk(this, zzhz));
        }
    }

    public final void zzf(zzam zzam, zzia zzia) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzn(this, zzam, zzia));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j2, long j3) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzo(str, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzp(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzhz zzhz) {
        zzhz.zza();
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzq(zzhz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i2, long j2) {
        zzzr zzzr = this.zzb;
        int i3 = zzfj.zza;
        zzzr.zzk(i2, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzhz zzhz) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzr(zzhz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzam zzam, zzia zzia) {
        int i2 = zzfj.zza;
        this.zzb.zzt(zzam, zzia);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j2) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzl(obj, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j2, int i2) {
        zzzr zzzr = this.zzb;
        int i3 = zzfj.zza;
        zzzr.zzs(j2, i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzn(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzdn zzdn) {
        zzzr zzzr = this.zzb;
        int i2 = zzfj.zza;
        zzzr.zzu(zzdn);
    }

    public final void zzq(Object obj) {
        if (this.zza != null) {
            this.zza.post(new zzzh(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j2, int i2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzj(this, j2, i2));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzi(this, exc));
        }
    }

    public final void zzt(zzdn zzdn) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzzo(this, zzdn));
        }
    }
}
