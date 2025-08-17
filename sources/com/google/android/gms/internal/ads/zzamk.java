package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzamk extends zzaly {
    static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzalc : (List) entry.getValue()) {
                    arrayList.add(new zzalc((String) entry.getKey(), zzalc));
                }
            }
        }
        return arrayList;
    }
}
