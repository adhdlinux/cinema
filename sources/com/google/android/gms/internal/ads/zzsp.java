package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class zzsp implements zztq {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zztx zzc = new zztx();
    private final zzqo zzd = new zzqo();
    private Looper zze;
    private zzcw zzf;
    private zzoc zzg;

    public /* synthetic */ zzcw zzL() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzoc zzb() {
        zzoc zzoc = this.zzg;
        zzdy.zzb(zzoc);
        return zzoc;
    }

    /* access modifiers changed from: protected */
    public final zzqo zzc(zzto zzto) {
        return this.zzd.zza(0, zzto);
    }

    /* access modifiers changed from: protected */
    public final zzqo zzd(int i2, zzto zzto) {
        return this.zzd.zza(0, zzto);
    }

    /* access modifiers changed from: protected */
    public final zztx zze(zzto zzto) {
        return this.zzc.zza(0, zzto);
    }

    /* access modifiers changed from: protected */
    public final zztx zzf(int i2, zzto zzto) {
        return this.zzc.zza(0, zzto);
    }

    public final void zzg(Handler handler, zzqp zzqp) {
        this.zzd.zzb(handler, zzqp);
    }

    public final void zzh(Handler handler, zzty zzty) {
        this.zzc.zzb(handler, zzty);
    }

    public final void zzi(zztp zztp) {
        boolean z2 = !this.zzb.isEmpty();
        this.zzb.remove(zztp);
        if (z2 && this.zzb.isEmpty()) {
            zzj();
        }
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    public final void zzk(zztp zztp) {
        this.zze.getClass();
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.add(zztp);
        if (isEmpty) {
            zzl();
        }
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    public final void zzm(zztp zztp, zzhg zzhg, zzoc zzoc) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z2 = true;
        if (!(looper == null || looper == myLooper)) {
            z2 = false;
        }
        zzdy.zzd(z2);
        this.zzg = zzoc;
        zzcw zzcw = this.zzf;
        this.zza.add(zztp);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zztp);
            zzn(zzhg);
        } else if (zzcw != null) {
            zzk(zztp);
            zztp.zza(this, zzcw);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzn(zzhg zzhg);

    /* access modifiers changed from: protected */
    public final void zzo(zzcw zzcw) {
        this.zzf = zzcw;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zztp) arrayList.get(i2)).zza(this, zzcw);
        }
    }

    public final void zzp(zztp zztp) {
        this.zza.remove(zztp);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zztp);
    }

    /* access modifiers changed from: protected */
    public abstract void zzq();

    public final void zzr(zzqp zzqp) {
        this.zzd.zzc(zzqp);
    }

    public final void zzs(zzty zzty) {
        this.zzc.zzh(zzty);
    }

    /* access modifiers changed from: protected */
    public final boolean zzt() {
        return !this.zzb.isEmpty();
    }

    public /* synthetic */ boolean zzu() {
        return true;
    }
}
