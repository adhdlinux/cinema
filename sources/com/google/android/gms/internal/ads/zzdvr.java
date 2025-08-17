package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;

public final class zzdvr extends zzdvl {
    private String zzg;
    private int zzh = 1;

    zzdvr(Context context) {
        this.zzf = new zzbte(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i2 = this.zzh;
                    if (i2 == 2) {
                        this.zzf.zzp().zze(this.zze, new zzdvk(this));
                    } else if (i2 == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzdvk(this));
                    } else {
                        this.zza.zze(new zzdwa(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzdwa(1));
                } catch (Throwable th) {
                    zzt.zzo().zzu(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zze(new zzdwa(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbzr.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzdwa(1));
    }

    public final zzfwm zzb(zzbue zzbue) {
        synchronized (this.zzb) {
            int i2 = this.zzh;
            if (i2 != 1 && i2 != 2) {
                zzfwm zzg2 = zzfwc.zzg(new zzdwa(2));
                return zzg2;
            } else if (this.zzc) {
                zzcaj zzcaj = this.zza;
                return zzcaj;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbue;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzdvq(this), zzcae.zzf);
                zzcaj zzcaj2 = this.zza;
                return zzcaj2;
            }
        }
    }

    public final zzfwm zzc(String str) {
        synchronized (this.zzb) {
            int i2 = this.zzh;
            if (i2 != 1 && i2 != 3) {
                zzfwm zzg2 = zzfwc.zzg(new zzdwa(2));
                return zzg2;
            } else if (this.zzc) {
                zzcaj zzcaj = this.zza;
                return zzcaj;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzdvp(this), zzcae.zzf);
                zzcaj zzcaj2 = this.zza;
                return zzcaj2;
            }
        }
    }
}
