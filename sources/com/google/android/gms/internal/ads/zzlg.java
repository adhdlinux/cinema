package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class zzlg extends zzhq {
    public static final /* synthetic */ int zzc = 0;
    private final int zzd;
    private final int zze;
    private final int[] zzf;
    private final int[] zzg;
    private final zzcw[] zzh;
    private final Object[] zzi;
    private final HashMap zzj = new HashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzlg(Collection collection, zzvi zzvi) {
        super(false, zzvi);
        int i2 = 0;
        int size = collection.size();
        this.zzf = new int[size];
        this.zzg = new int[size];
        this.zzh = new zzcw[size];
        this.zzi = new Object[size];
        Iterator it2 = collection.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            zzkq zzkq = (zzkq) it2.next();
            this.zzh[i4] = zzkq.zza();
            this.zzg[i4] = i2;
            this.zzf[i4] = i3;
            i2 += this.zzh[i4].zzc();
            i3 += this.zzh[i4].zzb();
            this.zzi[i4] = zzkq.zzb();
            this.zzj.put(this.zzi[i4], Integer.valueOf(i4));
            i4++;
        }
        this.zzd = i2;
        this.zze = i3;
    }

    public final int zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzj.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final int zzq(int i2) {
        return zzfj.zzb(this.zzf, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzr(int i2) {
        return zzfj.zzb(this.zzg, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzs(int i2) {
        return this.zzf[i2];
    }

    /* access modifiers changed from: protected */
    public final int zzt(int i2) {
        return this.zzg[i2];
    }

    /* access modifiers changed from: protected */
    public final zzcw zzu(int i2) {
        return this.zzh[i2];
    }

    /* access modifiers changed from: protected */
    public final Object zzv(int i2) {
        return this.zzi[i2];
    }

    /* access modifiers changed from: package-private */
    public final List zzw() {
        return Arrays.asList(this.zzh);
    }
}
