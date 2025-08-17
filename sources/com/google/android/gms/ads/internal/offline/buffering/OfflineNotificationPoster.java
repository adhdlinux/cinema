package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbrm;

@KeepForSdk
public class OfflineNotificationPoster extends Worker {
    private final zzbrm zza;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzay.zza().zzm(context, new zzbnt());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzi(ObjectWrapper.wrap(getApplicationContext()), getInputData().k("uri"), getInputData().k("gws_query_id"));
            return ListenableWorker.Result.c();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.a();
        }
    }
}
