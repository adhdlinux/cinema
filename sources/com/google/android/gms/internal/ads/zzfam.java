package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzfam {
    public static zzq zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzezo zzezo = (zzezo) it2.next();
            if (zzezo.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzezo.zza, zzezo.zzb));
            }
        }
        return new zzq(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzezo zzb(zzq zzq) {
        return zzq.zzi ? new zzezo(-3, 0, true) : new zzezo(zzq.zze, zzq.zzb, false);
    }
}
