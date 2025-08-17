package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbsk {
    private static zzbyi zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final zzdx zzd;

    public zzbsk(Context context, AdFormat adFormat, zzdx zzdx) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdx;
    }

    public static zzbyi zza(Context context) {
        zzbyi zzbyi;
        synchronized (zzbsk.class) {
            if (zza == null) {
                zza = zzay.zza().zzr(context, new zzbnt());
            }
            zzbyi = zza;
        }
        return zzbyi;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzl zzl;
        zzbyi zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzb);
        zzdx zzdx = this.zzd;
        if (zzdx == null) {
            zzl = new zzm().zza();
        } else {
            zzl = zzp.zza.zza(this.zzb, zzdx);
        }
        try {
            zza2.zze(wrap, new zzbym((String) null, this.zzc.name(), (zzq) null, zzl), new zzbsj(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
