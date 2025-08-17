package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfvy;
import java.util.List;

final class zzy implements zzfvy {
    final /* synthetic */ zzbsi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzy(zzaa zzaa, zzbsi zzbsi, boolean z2) {
        this.zzc = zzaa;
        this.zza = zzbsi;
        this.zzb = z2;
    }

    public final void zza(Throwable th) {
        try {
            zzbsi zzbsi = this.zza;
            String message = th.getMessage();
            zzbsi.zze("Internal error: " + message);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<Uri> list = (List) obj;
        try {
            zzaa.zzF(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzu || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzN(uri)) {
                        zzaa zzaa = this.zzc;
                        this.zzc.zzs.zzc(zzaa.zzW(uri, zzaa.zzC, "1").toString(), (zzffy) null);
                    } else {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhk)).booleanValue()) {
                            this.zzc.zzs.zzc(uri.toString(), (zzffy) null);
                        }
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }
}
