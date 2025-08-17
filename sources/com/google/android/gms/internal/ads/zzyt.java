package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class zzyt {
    private final zzzf zza;
    private final zzyu zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private final ArrayDeque zzd = new ArrayDeque();
    private final zzdj zze;
    private Handler zzf;
    private zzdl zzg;
    private CopyOnWriteArrayList zzh;
    private Pair zzi;
    private boolean zzj = true;
    private final zzdn zzk = zzdn.zza;

    public zzyt(zzdj zzdj, zzzf zzzf, zzyu zzyu) {
        this.zze = zzdj;
        this.zza = zzzf;
        this.zzb = zzyu;
    }

    public final void zza(String str) {
        Context zzae = this.zzb.zze;
        if (zzfj.zza >= 29) {
            int i2 = zzae.getApplicationContext().getApplicationInfo().targetSdkVersion;
        }
    }

    public final void zzb(Surface surface, zzfb zzfb) {
        Pair pair = this.zzi;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((zzfb) this.zzi.second).equals(zzfb)) {
            this.zzi = Pair.create(surface, zzfb);
        }
    }

    public final void zzc(List list) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzh;
        if (copyOnWriteArrayList == null) {
            this.zzh = new CopyOnWriteArrayList(list);
            return;
        }
        copyOnWriteArrayList.clear();
        this.zzh.addAll(list);
    }

    public final boolean zzd(zzam zzam, long j2) throws zzih {
        Pair pair;
        int i2;
        if (!this.zzj) {
            return false;
        }
        if (this.zzh == null) {
            this.zzj = false;
            return false;
        }
        this.zzf = zzfj.zzt((Handler.Callback) null);
        zzs zzs = zzam.zzy;
        zzs zzs2 = zzs.zza;
        if (zzs != null) {
            int i3 = zzs.zzf;
            if (i3 == 7) {
                zzr zzc2 = zzs.zzc();
                zzc2.zzc(6);
                pair = Pair.create(zzs, zzc2.zzd());
            } else if (i3 == 6) {
                pair = Pair.create(zzs, zzs);
            }
            if (!zzyu.zzaP() && (i2 = zzam.zzu) != 0) {
                this.zzh.add(0, zzys.zza((float) i2));
            }
            zzdj zzdj = this.zze;
            Context zzae = this.zzb.zze;
            CopyOnWriteArrayList copyOnWriteArrayList = this.zzh;
            copyOnWriteArrayList.getClass();
            Handler handler = this.zzf;
            handler.getClass();
            this.zzg = zzdj.zza(zzae, copyOnWriteArrayList, zzv.zzb, (zzs) pair.first, (zzs) pair.second, false, new zzyq(handler), new zzyr(this, zzam));
            throw null;
        }
        zzs zzs3 = zzs.zza;
        pair = Pair.create(zzs3, zzs3);
        try {
            this.zzh.add(0, zzys.zza((float) i2));
            zzdj zzdj2 = this.zze;
            Context zzae2 = this.zzb.zze;
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.zzh;
            copyOnWriteArrayList2.getClass();
            Handler handler2 = this.zzf;
            handler2.getClass();
            this.zzg = zzdj2.zza(zzae2, copyOnWriteArrayList2, zzv.zzb, (zzs) pair.first, (zzs) pair.second, false, new zzyq(handler2), new zzyr(this, zzam));
            throw null;
        } catch (Exception e2) {
            throw this.zzb.zzbe(e2, zzam, false, 7000);
        }
    }
}
