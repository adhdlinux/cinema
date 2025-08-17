package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class zzfqq extends zzfql implements SortedSet {
    final /* synthetic */ zzfqv zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqq(zzfqv zzfqv, SortedMap sortedMap) {
        super(zzfqv, sortedMap);
        this.zzc = zzfqv;
    }

    public final Comparator comparator() {
        return zza().comparator();
    }

    public final Object first() {
        return zza().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new zzfqq(this.zzc, zza().headMap(obj));
    }

    public final Object last() {
        return zza().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new zzfqq(this.zzc, zza().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new zzfqq(this.zzc, zza().tailMap(obj));
    }

    /* access modifiers changed from: package-private */
    public SortedMap zza() {
        return (SortedMap) this.zzd;
    }
}
