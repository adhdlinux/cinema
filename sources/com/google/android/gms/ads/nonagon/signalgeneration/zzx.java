package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfvy;
import java.util.ArrayList;
import java.util.Iterator;

final class zzx implements zzfvy {
    final /* synthetic */ zzbsi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzx(zzaa zzaa, zzbsi zzbsi, boolean z2) {
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
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzt || this.zzb) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Uri uri = (Uri) it2.next();
                    if (this.zzc.zzO(uri)) {
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
