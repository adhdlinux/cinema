package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.Display;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzak;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

@TargetApi(19)
@Deprecated
public class CastRemoteDisplayClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.AbstractClientBuilder zza;
    private static final Api zzb;
    /* access modifiers changed from: private */
    public final Logger zzc = new Logger("CastRemoteDisplay");
    /* access modifiers changed from: private */
    public VirtualDisplay zzd;

    static {
        zzab zzab = new zzab();
        zza = zzab;
        zzb = new Api("CastRemoteDisplay.API", zzab, zzak.zzd);
    }

    CastRemoteDisplayClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    static /* bridge */ /* synthetic */ void zzd(CastRemoteDisplayClient castRemoteDisplayClient) {
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.zzd;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = castRemoteDisplayClient.zzc;
                int displayId = castRemoteDisplayClient.zzd.getDisplay().getDisplayId();
                logger.d("releasing virtual display: " + displayId, new Object[0]);
            }
            VirtualDisplay virtualDisplay2 = castRemoteDisplayClient.zzd;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
                castRemoteDisplayClient.zzd = null;
            }
        }
    }

    public Task<Display> startRemoteDisplay(CastDevice castDevice, String str, @CastRemoteDisplay.Configuration int i2, PendingIntent pendingIntent) {
        return zze(castDevice, str, i2, pendingIntent, (zzal) null);
    }

    public Task<Void> stopRemoteDisplay() {
        return doWrite(TaskApiCall.builder().setMethodKey(8402).run(new zzz(this)).build());
    }

    public final Task zze(CastDevice castDevice, String str, @CastRemoteDisplay.Configuration int i2, PendingIntent pendingIntent, zzal zzal) {
        return doWrite(TaskApiCall.builder().setMethodKey(8401).run(new zzaa(this, i2, zzal, pendingIntent, castDevice, str)).build());
    }
}
