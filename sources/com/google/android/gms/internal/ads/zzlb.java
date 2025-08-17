package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzlb {
    private final zzoc zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzla zze;
    private final HashMap zzf;
    private final Set zzg;
    /* access modifiers changed from: private */
    public final zzls zzh;
    /* access modifiers changed from: private */
    public final zzei zzi;
    private boolean zzj;
    private zzhg zzk;
    private zzvi zzl = new zzvi(0);

    public zzlb(zzla zzla, zzls zzls, zzei zzei, zzoc zzoc) {
        this.zza = zzoc;
        this.zze = zzla;
        this.zzh = zzls;
        this.zzi = zzei;
        this.zzf = new HashMap();
        this.zzg = new HashSet();
    }

    private final void zzp(int i2, int i3) {
        while (i2 < this.zzb.size()) {
            ((zzkz) this.zzb.get(i2)).zzd += i3;
            i2++;
        }
    }

    private final void zzq(zzkz zzkz) {
        zzky zzky = (zzky) this.zzf.get(zzkz);
        if (zzky != null) {
            zzky.zza.zzi(zzky.zzb);
        }
    }

    private final void zzr() {
        Iterator it2 = this.zzg.iterator();
        while (it2.hasNext()) {
            zzkz zzkz = (zzkz) it2.next();
            if (zzkz.zzc.isEmpty()) {
                zzq(zzkz);
                it2.remove();
            }
        }
    }

    private final void zzs(zzkz zzkz) {
        if (zzkz.zze && zzkz.zzc.isEmpty()) {
            zzky zzky = (zzky) this.zzf.remove(zzkz);
            zzky.getClass();
            zzky.zza.zzp(zzky.zzb);
            zzky.zza.zzs(zzky.zzc);
            zzky.zza.zzr(zzky.zzc);
            this.zzg.remove(zzkz);
        }
    }

    private final void zzt(zzkz zzkz) {
        zztj zztj = zzkz.zza;
        zzkr zzkr = new zzkr(this);
        zzkx zzkx = new zzkx(this, zzkz);
        this.zzf.put(zzkz, new zzky(zztj, zzkr, zzkx));
        zztj.zzh(new Handler(zzfj.zzu(), (Handler.Callback) null), zzkx);
        zztj.zzg(new Handler(zzfj.zzu(), (Handler.Callback) null), zzkx);
        zztj.zzm(zzkr, this.zzk, this.zza);
    }

    private final void zzu(int i2, int i3) {
        while (true) {
            i3--;
            if (i3 >= i2) {
                zzkz zzkz = (zzkz) this.zzb.remove(i3);
                this.zzd.remove(zzkz.zzb);
                zzp(i3, -zzkz.zza.zzB().zzc());
                zzkz.zze = true;
                if (this.zzj) {
                    zzs(zzkz);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcw zzb() {
        if (this.zzb.isEmpty()) {
            return zzcw.zza;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb.size(); i3++) {
            zzkz zzkz = (zzkz) this.zzb.get(i3);
            zzkz.zzd = i2;
            i2 += zzkz.zza.zzB().zzc();
        }
        return new zzlg(this.zzb, this.zzl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zztq zztq, zzcw zzcw) {
        this.zze.zzh();
    }

    public final void zzf(zzhg zzhg) {
        zzdy.zzf(!this.zzj);
        this.zzk = zzhg;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzkz zzkz = (zzkz) this.zzb.get(i2);
            zzt(zzkz);
            this.zzg.add(zzkz);
        }
        this.zzj = true;
    }

    public final void zzg() {
        for (zzky zzky : this.zzf.values()) {
            try {
                zzky.zza.zzp(zzky.zzb);
            } catch (RuntimeException e2) {
                zzer.zzd("MediaSourceList", "Failed to release child source.", e2);
            }
            zzky.zza.zzs(zzky.zzc);
            zzky.zza.zzr(zzky.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzh(zztm zztm) {
        zzkz zzkz = (zzkz) this.zzc.remove(zztm);
        zzkz.getClass();
        zzkz.zza.zzF(zztm);
        zzkz.zzc.remove(((zztg) zztm).zza);
        if (!this.zzc.isEmpty()) {
            zzr();
        }
        zzs(zzkz);
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final zzcw zzj(int i2, List list, zzvi zzvi) {
        if (!list.isEmpty()) {
            this.zzl = zzvi;
            for (int i3 = i2; i3 < list.size() + i2; i3++) {
                zzkz zzkz = (zzkz) list.get(i3 - i2);
                if (i3 > 0) {
                    zzkz zzkz2 = (zzkz) this.zzb.get(i3 - 1);
                    zzkz.zzc(zzkz2.zzd + zzkz2.zza.zzB().zzc());
                } else {
                    zzkz.zzc(0);
                }
                zzp(i3, zzkz.zza.zzB().zzc());
                this.zzb.add(i3, zzkz);
                this.zzd.put(zzkz.zzb, zzkz);
                if (this.zzj) {
                    zzt(zzkz);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzkz);
                    } else {
                        zzq(zzkz);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcw zzk(int i2, int i3, int i4, zzvi zzvi) {
        boolean z2;
        if (zza() >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        this.zzl = null;
        return zzb();
    }

    public final zzcw zzl(int i2, int i3, zzvi zzvi) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= i3 && i3 <= zza()) {
            z2 = true;
        }
        zzdy.zzd(z2);
        this.zzl = zzvi;
        zzu(i2, i3);
        return zzb();
    }

    public final zzcw zzm(List list, zzvi zzvi) {
        zzu(0, this.zzb.size());
        return zzj(this.zzb.size(), list, zzvi);
    }

    public final zzcw zzn(zzvi zzvi) {
        int zza2 = zza();
        if (zzvi.zzc() != zza2) {
            zzvi = zzvi.zzf().zzg(0, zza2);
        }
        this.zzl = zzvi;
        return zzb();
    }

    public final zztm zzo(zzto zzto, zzxp zzxp, long j2) {
        Object obj = zzto.zza;
        int i2 = zzlg.zzc;
        Object obj2 = ((Pair) obj).first;
        zzto zzc2 = zzto.zzc(((Pair) obj).second);
        zzkz zzkz = (zzkz) this.zzd.get(obj2);
        zzkz.getClass();
        this.zzg.add(zzkz);
        zzky zzky = (zzky) this.zzf.get(zzkz);
        if (zzky != null) {
            zzky.zza.zzk(zzky.zzb);
        }
        zzkz.zzc.add(zzc2);
        zztg zzG = zzkz.zza.zzH(zzc2, zzxp, j2);
        this.zzc.put(zzG, zzkz);
        zzr();
        return zzG;
    }
}
