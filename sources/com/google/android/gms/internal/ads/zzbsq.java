package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class zzbsq {
    private final View zza;
    private final Map zzb;
    private final zzbyi zzc;

    public zzbsq(zzbsp zzbsp) {
        View zza2 = zzbsp.zza;
        this.zza = zza2;
        Map zzd = zzbsp.zzb;
        this.zzb = zzd;
        zzbyi zza3 = zzbsk.zza(zzbsp.zza.getContext());
        this.zzc = zza3;
        if (zza3 != null && !zzd.isEmpty()) {
            try {
                zza3.zzf(new zzbsr(ObjectWrapper.wrap(zza2).asBinder(), ObjectWrapper.wrap(zzd).asBinder()));
            } catch (RemoteException unused) {
                zzbzr.zzg("Failed to call remote method.");
            }
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            zzbzr.zzj("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            zzbzr.zzj("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzg(list, ObjectWrapper.wrap(this.zza), new zzbso(this, list));
        } catch (RemoteException e2) {
            zzbzr.zzg("RemoteException recording click: ".concat(e2.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            zzbzr.zzj("No impression urls were passed to recordImpression");
            return;
        }
        zzbyi zzbyi = this.zzc;
        if (zzbyi != null) {
            try {
                zzbyi.zzh(list, ObjectWrapper.wrap(this.zza), new zzbsn(this, list));
            } catch (RemoteException e2) {
                zzbzr.zzg("RemoteException recording impression urls: ".concat(e2.toString()));
            }
        } else {
            zzbzr.zzj("Failed to get internal reporting info generator from recordImpression.");
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzbyi zzbyi = this.zzc;
        if (zzbyi != null) {
            try {
                zzbyi.zzj(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException unused) {
                zzbzr.zzg("Failed to call remote method.");
            }
        } else {
            zzbzr.zze("Failed to get internal reporting info generator.");
        }
    }

    public final void zzd(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzk(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zza), new zzbsm(this, updateClickUrlCallback));
        } catch (RemoteException e2) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e2.toString()));
        }
    }

    public final void zze(List list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzl(list, ObjectWrapper.wrap(this.zza), new zzbsl(this, updateImpressionUrlsCallback));
        } catch (RemoteException e2) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e2.toString()));
        }
    }
}
