package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzos {
    private final Handler zza;
    private final zzot zzb;

    public zzos(Handler handler, zzot zzot) {
        this.zza = zzot == null ? null : handler;
        this.zzb = zzot;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoi(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoo(this, exc));
        }
    }

    public final void zzc(String str, long j2, long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzon(this, str, j2, j3));
        }
    }

    public final void zzd(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzop(this, str));
        }
    }

    public final void zze(zzhz zzhz) {
        zzhz.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoj(this, zzhz));
        }
    }

    public final void zzf(zzhz zzhz) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzok(this, zzhz));
        }
    }

    public final void zzg(zzam zzam, zzia zzia) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoq(this, zzam, zzia));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Exception exc) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzb(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Exception exc) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzi(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(String str, long j2, long j3) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzc(str, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(String str) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzd(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzhz zzhz) {
        zzhz.zza();
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zze(zzhz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzhz zzhz) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzf(zzhz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzam zzam, zzia zzia) {
        int i2 = zzfj.zza;
        this.zzb.zzg(zzam, zzia);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(long j2) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzh(j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(boolean z2) {
        zzot zzot = this.zzb;
        int i2 = zzfj.zza;
        zzot.zzm(z2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i2, long j2, long j3) {
        zzot zzot = this.zzb;
        int i3 = zzfj.zza;
        zzot.zzj(i2, j2, j3);
    }

    public final void zzr(long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzol(this, j2));
        }
    }

    public final void zzs(boolean z2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzom(this, z2));
        }
    }

    public final void zzt(int i2, long j2, long j3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzor(this, i2, j2, j3));
        }
    }
}
