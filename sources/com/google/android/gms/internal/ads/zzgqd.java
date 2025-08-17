package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgqd extends zzgno implements RandomAccess, zzgqe {
    @Deprecated
    public static final zzgqe zza;
    private static final zzgqd zzb;
    private final List zzc;

    static {
        zzgqd zzgqd = new zzgqd(false);
        zzb = zzgqd;
        zza = zzgqd;
    }

    public zzgqd() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgoe) {
            return ((zzgoe) obj).zzx(zzgpw.zzb);
        }
        return zzgpw.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        zzbH();
        this.zzc.add(i2, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i2, Collection collection) {
        zzbH();
        if (collection instanceof zzgqe) {
            collection = ((zzgqe) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbH();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbH();
        Object remove = this.zzc.remove(i2);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        zzbH();
        return zzj(this.zzc.set(i2, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzgpv zzd(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.zzc);
            return new zzgqd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzgqe zze() {
        return zzc() ? new zzgsl(this) : this;
    }

    public final Object zzf(int i2) {
        return this.zzc.get(i2);
    }

    /* renamed from: zzg */
    public final String get(int i2) {
        Object obj = this.zzc.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgoe) {
            zzgoe zzgoe = (zzgoe) obj;
            String zzx = zzgoe.zzx(zzgpw.zzb);
            if (zzgoe.zzp()) {
                this.zzc.set(i2, zzx);
            }
            return zzx;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgpw.zzd(bArr);
        if (zzgsv.zzi(bArr)) {
            this.zzc.set(i2, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzgoe zzgoe) {
        zzbH();
        this.zzc.add(zzgoe);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgqd(int i2) {
        super(true);
        ArrayList arrayList = new ArrayList(i2);
        this.zzc = arrayList;
    }

    private zzgqd(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzgqd(boolean z2) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
