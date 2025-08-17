package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbjn {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbjj zzc;

    public zzbjn(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbbm.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjb)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzba.zzc().zzb(zzbbm.zzjd)).intValue()) {
            zzbzr.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzay.zza().zzl(this.zza, new zzbnt(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjb)).booleanValue()) {
            zzd();
            zzbjj zzbjj = this.zzc;
            if (zzbjj != null) {
                try {
                    zzbjj.zze();
                } catch (RemoteException e2) {
                    zzbzr.zzl("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbjj zzbjj = this.zzc;
        if (zzbjj == null) {
            return false;
        }
        try {
            zzbjj.zzf(str);
            return true;
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            return true;
        }
    }
}
