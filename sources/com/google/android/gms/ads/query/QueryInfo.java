package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzem;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbzg;

public class QueryInfo {
    private final zzem zza;

    public QueryInfo(zzem zzem) {
        this.zza = zzem;
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzdx zzdx;
        zzbbm.zza(context);
        if (((Boolean) zzbdd.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new zza(context, adFormat, adRequest, queryInfoGenerationCallback));
                return;
            }
        }
        if (adRequest == null) {
            zzdx = null;
        } else {
            zzdx = adRequest.zza();
        }
        new zzbsk(context, adFormat, zzdx).zzb(queryInfoGenerationCallback);
    }

    public String getQuery() {
        return this.zza.zzb();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zza.zza();
    }

    @KeepForSdk
    public String getRequestId() {
        return this.zza.zzc();
    }
}
