package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzsw extends zzra implements RandomAccess, zzsx {
    @Deprecated
    public static final zzsx zza;
    private static final zzsw zzb;
    private final List zzc;

    static {
        zzsw zzsw = new zzsw(false);
        zzb = zzsw;
        zza = zzsw;
    }

    public zzsw() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzrm) {
            return ((zzrm) obj).zzl(zzsq.zzb);
        }
        return zzsq.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        zza();
        this.zzc.add(i2, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i2, Collection collection) {
        zza();
        if (collection instanceof zzsx) {
            collection = ((zzsx) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        Object remove = this.zzc.remove(i2);
        this.modCount++;
        return zzi(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        zza();
        return zzi(this.zzc.set(i2, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final zzsx zzd() {
        return zzc() ? new zzuw(this) : this;
    }

    public final Object zze(int i2) {
        return this.zzc.get(i2);
    }

    /* renamed from: zzf */
    public final String get(int i2) {
        Object obj = this.zzc.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzrm) {
            zzrm zzrm = (zzrm) obj;
            String zzl = zzrm.zzl(zzsq.zzb);
            if (zzrm.zzi()) {
                this.zzc.set(i2, zzl);
            }
            return zzl;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzsq.zzd(bArr);
        if (zzvf.zzd(bArr)) {
            this.zzc.set(i2, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ zzsp zzg(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.zzc);
            return new zzsw(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzsw(int i2) {
        super(true);
        ArrayList arrayList = new ArrayList(i2);
        this.zzc = arrayList;
    }

    private zzsw(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzsw(boolean z2) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
