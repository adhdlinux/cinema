package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

public final class zzbqy extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbqy(zzbej zzbej) {
        zzber zzber;
        try {
            this.zzb = zzbej.zzg();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            this.zzb = "";
        }
        try {
            for (Object next : zzbej.zzh()) {
                if (next instanceof IBinder) {
                    zzber = zzbeq.zzg((IBinder) next);
                } else {
                    zzber = null;
                }
                if (zzber != null) {
                    this.zza.add(new zzbra(zzber));
                }
            }
        } catch (RemoteException e3) {
            zzbzr.zzh("", e3);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
