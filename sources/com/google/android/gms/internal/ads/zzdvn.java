package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;

public final class zzdvn extends zzdvl {
    zzdvn(Context context) {
        this.zzf = new zzbte(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzdvk(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzdwa(1));
                } catch (Throwable th) {
                    zzt.zzo().zzu(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zze(new zzdwa(1));
                }
            }
        }
    }

    public final zzfwm zzb(zzbue zzbue) {
        synchronized (this.zzb) {
            if (this.zzc) {
                zzcaj zzcaj = this.zza;
                return zzcaj;
            }
            this.zzc = true;
            this.zze = zzbue;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.zzc(new zzdvm(this), zzcae.zzf);
            zzcaj zzcaj2 = this.zza;
            return zzcaj2;
        }
    }
}
