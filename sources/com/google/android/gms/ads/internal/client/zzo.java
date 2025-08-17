package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class zzo implements Comparator {
    public static final /* synthetic */ zzo zza = new zzo();

    private /* synthetic */ zzo() {
    }

    public final int compare(Object obj, Object obj2) {
        List list = RequestConfiguration.zza;
        return list.indexOf((String) obj) - list.indexOf((String) obj2);
    }
}
