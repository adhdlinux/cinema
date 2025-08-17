package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdgj extends zzben {
    private final zzdha zza;
    private IObjectWrapper zzb;

    public zzdgj(zzdha zzdha) {
        this.zza = zzdha;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float zze() throws RemoteException {
        float f2;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzfZ)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e2) {
                zzbzr.zzh("Remote exception getting video controller aspect ratio.", e2);
                return 0.0f;
            }
        } else {
            IObjectWrapper iObjectWrapper = this.zzb;
            if (iObjectWrapper != null) {
                return zzb(iObjectWrapper);
            }
            zzber zzm = this.zza.zzm();
            if (zzm == null) {
                return 0.0f;
            }
            if (zzm.zzd() == -1 || zzm.zzc() == -1) {
                f2 = 0.0f;
            } else {
                f2 = ((float) zzm.zzd()) / ((float) zzm.zzc());
            }
            if (f2 == 0.0f) {
                return zzb(zzm.zzf());
            }
            return f2;
        }
    }

    public final float zzf() throws RemoteException {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    public final zzdq zzh() throws RemoteException {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue()) {
            return null;
        }
        return this.zza.zzj();
    }

    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzber zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        return zzm.zzf();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final boolean zzk() throws RemoteException {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue()) {
            return false;
        }
        return this.zza.zzad();
    }

    public final boolean zzl() throws RemoteException {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue() && this.zza.zzj() != null) {
            return true;
        }
        return false;
    }

    public final void zzm(zzbfz zzbfz) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzga)).booleanValue() && (this.zza.zzj() instanceof zzcfv)) {
            ((zzcfv) this.zza.zzj()).zzv(zzbfz);
        }
    }
}
