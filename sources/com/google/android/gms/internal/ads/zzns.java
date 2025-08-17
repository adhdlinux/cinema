package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class zzns {
    private final zzct zza;
    /* access modifiers changed from: private */
    public zzfsc zzb = zzfsc.zzl();
    private zzfsf zzc = zzfsf.zzd();
    private zzto zzd;
    private zzto zze;
    private zzto zzf;

    public zzns(zzct zzct) {
        this.zza = zzct;
    }

    private static zzto zzj(zzcp zzcp, zzfsc zzfsc, zzto zzto, zzct zzct) {
        Object obj;
        int i2;
        zzcw zzn = zzcp.zzn();
        int zze2 = zzcp.zze();
        if (zzn.zzo()) {
            obj = null;
        } else {
            obj = zzn.zzf(zze2);
        }
        if (zzcp.zzx() || zzn.zzo()) {
            i2 = -1;
        } else {
            i2 = zzn.zzd(zze2, zzct, false).zzc(zzfj.zzo(zzcp.zzk()));
        }
        for (int i3 = 0; i3 < zzfsc.size(); i3++) {
            zzto zzto2 = (zzto) zzfsc.get(i3);
            if (zzm(zzto2, obj, zzcp.zzx(), zzcp.zzb(), zzcp.zzc(), i2)) {
                return zzto2;
            }
        }
        if (zzfsc.isEmpty() && zzto != null) {
            if (zzm(zzto, obj, zzcp.zzx(), zzcp.zzb(), zzcp.zzc(), i2)) {
                return zzto;
            }
        }
        return null;
    }

    private final void zzk(zzfse zzfse, zzto zzto, zzcw zzcw) {
        if (zzto != null) {
            if (zzcw.zza(zzto.zza) != -1) {
                zzfse.zza(zzto, zzcw);
                return;
            }
            zzcw zzcw2 = (zzcw) this.zzc.get(zzto);
            if (zzcw2 != null) {
                zzfse.zza(zzto, zzcw2);
            }
        }
    }

    private final void zzl(zzcw zzcw) {
        zzfse zzfse = new zzfse();
        if (this.zzb.isEmpty()) {
            zzk(zzfse, this.zze, zzcw);
            if (!zzfpc.zza(this.zzf, this.zze)) {
                zzk(zzfse, this.zzf, zzcw);
            }
            if (!zzfpc.zza(this.zzd, this.zze) && !zzfpc.zza(this.zzd, this.zzf)) {
                zzk(zzfse, this.zzd, zzcw);
            }
        } else {
            for (int i2 = 0; i2 < this.zzb.size(); i2++) {
                zzk(zzfse, (zzto) this.zzb.get(i2), zzcw);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfse, this.zzd, zzcw);
            }
        }
        this.zzc = zzfse.zzc();
    }

    private static boolean zzm(zzto zzto, Object obj, boolean z2, int i2, int i3, int i4) {
        if (!zzto.zza.equals(obj)) {
            return false;
        }
        if (z2) {
            if (!(zzto.zzb == i2 && zzto.zzc == i3)) {
                return false;
            }
        } else if (!(zzto.zzb == -1 && zzto.zze == i4)) {
            return false;
        }
        return true;
    }

    public final zzcw zza(zzto zzto) {
        return (zzcw) this.zzc.get(zzto);
    }

    public final zzto zzb() {
        return this.zzd;
    }

    public final zzto zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfsc zzfsc = this.zzb;
        if (!(zzfsc instanceof List)) {
            Iterator it2 = zzfsc.iterator();
            do {
                next = it2.next();
            } while (it2.hasNext());
            obj = next;
        } else if (!zzfsc.isEmpty()) {
            obj = zzfsc.get(zzfsc.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzto) obj;
    }

    public final zzto zzd() {
        return this.zze;
    }

    public final zzto zze() {
        return this.zzf;
    }

    public final void zzg(zzcp zzcp) {
        this.zzd = zzj(zzcp, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzto zzto, zzcp zzcp) {
        this.zzb = zzfsc.zzj(list);
        if (!list.isEmpty()) {
            this.zze = (zzto) list.get(0);
            zzto.getClass();
            this.zzf = zzto;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzcp, this.zzb, this.zze, this.zza);
        }
        zzl(zzcp.zzn());
    }

    public final void zzi(zzcp zzcp) {
        this.zzd = zzj(zzcp, this.zzb, this.zze, this.zza);
        zzl(zzcp.zzn());
    }
}
