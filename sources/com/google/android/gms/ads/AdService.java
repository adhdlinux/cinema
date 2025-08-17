package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbzr;

@KeepForSdk
public class AdService extends IntentService {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdService";

    public AdService() {
        super("AdService");
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        try {
            zzay.zza().zzm(this, new zzbnt()).zze(intent);
        } catch (RemoteException e2) {
            zzbzr.zzg("RemoteException calling handleNotificationIntent: ".concat(e2.toString()));
        }
    }
}
