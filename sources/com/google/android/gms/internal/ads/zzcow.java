package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcow extends zzavs {
    private final zzcov zza;
    private final zzbu zzb;
    private final zzevl zzc;
    private boolean zzd = false;
    private final zzdqa zze;

    public zzcow(zzcov zzcov, zzbu zzbu, zzevl zzevl, zzdqa zzdqa) {
        this.zza = zzcov;
        this.zzb = zzbu;
        this.zzc = zzevl;
        this.zze = zzdqa;
    }

    public final zzbu zze() {
        return this.zzb;
    }

    public final zzdn zzf() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue()) {
            return null;
        }
        return this.zza.zzl();
    }

    public final void zzg(boolean z2) {
        this.zzd = z2;
    }

    public final void zzh(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdg.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e2) {
                zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
            }
            this.zzc.zzo(zzdg);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzawa zzawa) {
        try {
            this.zzc.zzq(zzawa);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzawa, this.zzd);
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
