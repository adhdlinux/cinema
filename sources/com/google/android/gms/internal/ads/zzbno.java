package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public final /* synthetic */ class zzbno implements Runnable {
    public final /* synthetic */ zzbnp zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbno(zzbnp zzbnp, Context context, String str) {
        this.zza = zzbnp;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        String str = this.zzc;
        zzbbm.zza(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzba.zzc().zzb(zzbbm.zzai)).booleanValue());
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzap)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzcgt) zzbzv.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzbnn.zza)).zze(ObjectWrapper.wrap(context), new zzbnm(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzbzu | NullPointerException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
