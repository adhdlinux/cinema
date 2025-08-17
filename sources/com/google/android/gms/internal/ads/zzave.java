package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public final class zzave {
    private final int zza;
    private final zzavb zzb = new zzavg();

    public zzave(int i2) {
        this.zza = i2;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(((String) arrayList.get(i2)).toLowerCase(Locale.US));
            sb.append(10);
        }
        String[] split = sb.toString().split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        if (split.length == 0) {
            return "";
        }
        zzavd zzavd = new zzavd();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzavc(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzavf.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzavj.zzc(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it2 = priorityQueue.iterator();
        while (it2.hasNext()) {
            try {
                zzavd.zzb.write(this.zzb.zzb(((zzavi) it2.next()).zzb));
            } catch (IOException e2) {
                zzbzr.zzh("Error while writing hash to byteStream", e2);
            }
        }
        return zzavd.toString();
    }
}
