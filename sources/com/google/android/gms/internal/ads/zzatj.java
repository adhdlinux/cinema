package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

public final /* synthetic */ class zzatj implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzfwv zza;

    public /* synthetic */ zzatj(zzfwv zzfwv) {
        this.zza = zzfwv;
    }

    public final void onChecksumsReady(List list) {
        zzfwv zzfwv = this.zza;
        if (list == null) {
            zzfwv.zzd((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i2);
                if (apkChecksum.getType() == 8) {
                    zzfwv.zzd(zzarw.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzfwv.zzd((Object) null);
        } catch (Throwable unused) {
            zzfwv.zzd((Object) null);
        }
    }
}
