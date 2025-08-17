package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

public final class zzn extends GoogleApi {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzi zzi = new zzi();
        zzb = zzi;
        zzc = new Api("CastApi.API", zzi, clientKey);
    }

    public zzn(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task zza(String[] strArr) {
        return doRead(TaskApiCall.builder().run(new zzg(this, strArr)).setFeatures(zzax.zzd).setAutoResolveMissingFeatures(false).setMethodKey(8425).build());
    }
}
