package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzalk implements Comparable {
    /* access modifiers changed from: private */
    public final zzalv zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzalo zzf;
    private Integer zzg;
    private zzaln zzh;
    private boolean zzi;
    private zzakt zzj;
    private zzalj zzk;
    private final zzaky zzl;

    public zzalk(int i2, String str, zzalo zzalo) {
        zzalv zzalv;
        Uri parse;
        String host;
        if (zzalv.zza) {
            zzalv = new zzalv();
        } else {
            zzalv = null;
        }
        this.zza = zzalv;
        this.zze = new Object();
        int i3 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i2;
        this.zzc = str;
        this.zzf = zzalo;
        this.zzl = new zzaky();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i3 = host.hashCode();
        }
        this.zzd = i3;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzalk) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        String str = this.zzc;
        Integer num = this.zzg;
        return "[ ] " + str + " " + "0x".concat(valueOf) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzakt zzd() {
        return this.zzj;
    }

    public final zzalk zze(zzakt zzakt) {
        this.zzj = zzakt;
        return this;
    }

    public final zzalk zzf(zzaln zzaln) {
        this.zzh = zzaln;
        return this;
    }

    public final zzalk zzg(int i2) {
        this.zzg = Integer.valueOf(i2);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzalq zzh(zzalg zzalg);

    public final String zzj() {
        String str = this.zzc;
        if (this.zzb == 0) {
            return str;
        }
        String num = Integer.toString(1);
        return num + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaks {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzalv.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzalt zzalt) {
        zzalo zzalo;
        synchronized (this.zze) {
            zzalo = this.zzf;
        }
        zzalo.zza(zzalt);
    }

    /* access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzaln zzaln = this.zzh;
        if (zzaln != null) {
            zzaln.zzb(this);
        }
        if (zzalv.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzali(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzalj zzalj;
        synchronized (this.zze) {
            zzalj = this.zzk;
        }
        if (zzalj != null) {
            zzalj.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs(zzalq zzalq) {
        zzalj zzalj;
        synchronized (this.zze) {
            zzalj = this.zzk;
        }
        if (zzalj != null) {
            zzalj.zzb(this, zzalq);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt(int i2) {
        zzaln zzaln = this.zzh;
        if (zzaln != null) {
            zzaln.zzc(this, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu(zzalj zzalj) {
        synchronized (this.zze) {
            this.zzk = zzalj;
        }
    }

    public final boolean zzv() {
        boolean z2;
        synchronized (this.zze) {
            z2 = this.zzi;
        }
        return z2;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaks {
        return null;
    }

    public final zzaky zzy() {
        return this.zzl;
    }
}
