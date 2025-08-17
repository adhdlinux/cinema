package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class zzvz implements Comparator {
    public static final /* synthetic */ zzvz zza = new zzvz();

    private /* synthetic */ zzvz() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((zzwg) Collections.max((List) obj)).compareTo((zzwg) Collections.max((List) obj2));
    }
}
