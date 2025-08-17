package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

public abstract class zzsx extends zzsp {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhg zzc;

    protected zzsx() {
    }

    /* access modifiers changed from: protected */
    public final void zzA(Object obj, zztq zztq) {
        zzdy.zzd(!this.zza.containsKey(obj));
        zzsu zzsu = new zzsu(this, obj);
        zzsv zzsv = new zzsv(this, obj);
        this.zza.put(obj, new zzsw(zztq, zzsu, zzsv));
        Handler handler = this.zzb;
        handler.getClass();
        zztq.zzh(handler, zzsv);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zztq.zzg(handler2, zzsv);
        zztq.zzm(zzsu, this.zzc, zzb());
        if (!zzt()) {
            zztq.zzi(zzsu);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        for (zzsw zzsw : this.zza.values()) {
            zzsw.zza.zzi(zzsw.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl() {
        for (zzsw zzsw : this.zza.values()) {
            zzsw.zza.zzk(zzsw.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public void zzn(zzhg zzhg) {
        this.zzc = zzhg;
        this.zzb = zzfj.zzt((Handler.Callback) null);
    }

    /* access modifiers changed from: protected */
    public void zzq() {
        for (zzsw zzsw : this.zza.values()) {
            zzsw.zza.zzp(zzsw.zzb);
            zzsw.zza.zzs(zzsw.zzc);
            zzsw.zza.zzr(zzsw.zzc);
        }
        this.zza.clear();
    }

    /* access modifiers changed from: protected */
    public int zzv(Object obj, int i2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public long zzw(Object obj, long j2) {
        return j2;
    }

    /* access modifiers changed from: protected */
    public zzto zzx(Object obj, zzto zzto) {
        throw null;
    }

    public void zzy() throws IOException {
        for (zzsw zzsw : this.zza.values()) {
            zzsw.zza.zzy();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzz(Object obj, zztq zztq, zzcw zzcw);
}
