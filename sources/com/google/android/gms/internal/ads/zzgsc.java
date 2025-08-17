package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzgsc extends AbstractMap {
    private final int zza;
    /* access modifiers changed from: private */
    public List zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzgsa zze;
    private Map zzf = Collections.emptyMap();

    /* synthetic */ zzgsc(int i2, zzgsb zzgsb) {
        this.zza = i2;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size() - 1;
        int i2 = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzgrw) this.zzb.get(size)).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = comparable.compareTo(((zzgrw) this.zzb.get(i3)).zza());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* access modifiers changed from: private */
    public final Object zzl(int i2) {
        zzn();
        Object value = ((zzgrw) this.zzb.remove(i2)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it2 = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it2.next();
            list.add(new zzgrw(this, (Comparable) entry.getKey(), entry.getValue()));
            it2.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzk(comparable) >= 0 || this.zzc.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzgsa(this, (zzgrz) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgsc)) {
            return super.equals(obj);
        }
        zzgsc zzgsc = (zzgsc) obj;
        int size = size();
        if (size != zzgsc.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzgsc.zzb()) {
            return entrySet().equals(zzgsc.entrySet());
        }
        for (int i2 = 0; i2 < zzb2; i2++) {
            if (!zzg(i2).equals(zzgsc.zzg(i2))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzgsc.zzc);
        }
        return true;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzgrw) this.zzb.get(zzk)).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i2 = 0;
        for (int i3 = 0; i3 < zzb2; i3++) {
            i2 += ((zzgrw) this.zzb.get(i3)).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i2 + this.zzc.hashCode();
        }
        return i2;
    }

    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map map;
        Map map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        if (this.zzc.isEmpty()) {
            return zzgrv.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzgrw) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i2 = -(zzk + 1);
        if (i2 >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i3 = this.zza;
        if (size == i3) {
            zzgrw zzgrw = (zzgrw) this.zzb.remove(i3 - 1);
            zzm().put(zzgrw.zza(), zzgrw.getValue());
        }
        this.zzb.add(i2, new zzgrw(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i2) {
        return (Map.Entry) this.zzb.get(i2);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
