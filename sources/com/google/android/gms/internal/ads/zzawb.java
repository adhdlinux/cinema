package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;

public final class zzawb {
    private zzbu zza;
    private final Context zzb;
    private final String zzc;
    private final zzdx zzd;
    @AppOpenAd.AppOpenAdOrientation
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzbnt zzg = new zzbnt();
    private final zzp zzh;

    public zzawb(Context context, String str, zzdx zzdx, @AppOpenAd.AppOpenAdOrientation int i2, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzdx;
        this.zze = i2;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzp.zza;
    }

    public final void zza() {
        try {
            zzbu zzd2 = zzay.zza().zzd(this.zzb, zzq.zzb(), this.zzc, this.zzg);
            this.zza = zzd2;
            if (zzd2 != null) {
                if (this.zze != 3) {
                    this.zza.zzI(new zzw(this.zze));
                }
                this.zza.zzH(new zzavo(this.zzf, this.zzc));
                this.zza.zzaa(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
