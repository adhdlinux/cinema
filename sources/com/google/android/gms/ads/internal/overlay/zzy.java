package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzdcu;

public final class zzy extends zzbrs {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;
    private boolean zze = false;

    public zzy(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzo zzo = this.zza.zzc;
            if (zzo != null) {
                zzo.zzf(4);
            }
            this.zzd = true;
        }
    }

    public final boolean zzG() throws RemoteException {
        return false;
    }

    public final void zzh(int i2, int i3, Intent intent) throws RemoteException {
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzl(Bundle bundle) {
        zzo zzo;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzis)).booleanValue() && !this.zze) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z2 = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z2 = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z2) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zza zza2 = adOverlayInfoParcel.zzb;
                if (zza2 != null) {
                    zza2.onAdClicked();
                }
                zzdcu zzdcu = this.zza.zzv;
                if (zzdcu != null) {
                    zzdcu.zzr();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zza.zzc) == null)) {
                    zzo.zzb();
                }
            }
            zzt.zzh();
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzm() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzo() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbo();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzp(int i2, String[] strArr, int[] iArr) {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzr() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbF();
        }
    }

    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzt() throws RemoteException {
    }

    public final void zzu() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzv() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final void zzx() throws RemoteException {
        this.zze = true;
    }
}
