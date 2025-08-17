package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

public final class zzcbp {
    private final Context zza;
    private final zzcca zzb;
    private final ViewGroup zzc;
    private zzcbo zzd;

    public zzcbp(Context context, ViewGroup viewGroup, zzcez zzcez) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcez;
        this.zzd = null;
    }

    public final zzcbo zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcbo zzcbo = this.zzd;
        if (zzcbo != null) {
            return zzcbo.zzl();
        }
        return null;
    }

    public final void zzc(int i2, int i3, int i4, int i5) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcbo zzcbo = this.zzd;
        if (zzcbo != null) {
            zzcbo.zzF(i2, i3, i4, i5);
        }
    }

    public final void zzd(int i2, int i3, int i4, int i5, int i6, boolean z2, zzcbz zzcbz) {
        if (this.zzd == null) {
            zzbbw.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
            Context context = this.zza;
            zzcca zzcca = this.zzb;
            zzcbo zzcbo = new zzcbo(context, zzcca, i6, z2, zzcca.zzm().zza(), zzcbz);
            this.zzd = zzcbo;
            this.zzc.addView(zzcbo, 0, new ViewGroup.LayoutParams(-1, -1));
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            this.zzd.zzF(i2, i3, i4, i5);
            this.zzb.zzz(false);
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcbo zzcbo = this.zzd;
        if (zzcbo != null) {
            zzcbo.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcbo zzcbo = this.zzd;
        if (zzcbo != null) {
            zzcbo.zzu();
        }
    }

    public final void zzg(int i2) {
        zzcbo zzcbo = this.zzd;
        if (zzcbo != null) {
            zzcbo.zzC(i2);
        }
    }
}
