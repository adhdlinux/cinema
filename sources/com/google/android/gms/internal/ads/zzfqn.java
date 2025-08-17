package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

final class zzfqn extends zzfqq implements NavigableSet {
    final /* synthetic */ zzfqv zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqn(zzfqv zzfqv, NavigableMap navigableMap) {
        super(zzfqv, navigableMap);
        this.zzb = zzfqv;
    }

    public final Object ceiling(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).ceilingKey(obj);
    }

    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    public final NavigableSet descendingSet() {
        return new zzfqn(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).descendingMap());
    }

    public final Object floor(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).floorKey(obj);
    }

    public final /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    public final Object higher(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).higherKey(obj);
    }

    public final Object lower(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).lowerKey(obj);
    }

    public final Object pollFirst() {
        return zzfsm.zza(iterator());
    }

    public final Object pollLast() {
        return zzfsm.zza(descendingIterator());
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ SortedMap zza() {
        return (NavigableMap) ((SortedMap) this.zzd);
    }

    public final NavigableSet headSet(Object obj, boolean z2) {
        return new zzfqn(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).headMap(obj, z2));
    }

    public final NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
        return new zzfqn(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).subMap(obj, z2, obj2, z3));
    }

    public final NavigableSet tailSet(Object obj, boolean z2) {
        return new zzfqn(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).tailMap(obj, z2));
    }
}
