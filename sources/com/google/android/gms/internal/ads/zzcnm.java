package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcnm implements zzcvg, zzcwu, zzcwa, zza, zzcvw {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzezz zze;
    /* access modifiers changed from: private */
    public final zzezn zzf;
    /* access modifiers changed from: private */
    public final zzfgn zzg;
    /* access modifiers changed from: private */
    public final zzfar zzh;
    private final zzaqs zzi;
    private final zzbco zzj;
    private final zzffy zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private final zzcui zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbcq zzq;

    zzcnm(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzezz zzezz, zzezn zzezn, zzfgn zzfgn, zzfar zzfar, View view, zzcez zzcez, zzaqs zzaqs, zzbco zzbco, zzbcq zzbcq, zzffy zzffy, zzcui zzcui) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzezz;
        this.zzf = zzezn;
        this.zzg = zzfgn;
        this.zzh = zzfar;
        this.zzi = zzaqs;
        View view2 = view;
        this.zzl = new WeakReference(view);
        zzcez zzcez2 = zzcez;
        this.zzm = new WeakReference(zzcez);
        this.zzj = zzbco;
        this.zzq = zzbcq;
        this.zzk = zzffy;
        this.zzn = zzcui;
    }

    /* access modifiers changed from: private */
    public final void zzs() {
        String str;
        int i2;
        List list;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjY)).booleanValue() || ((list = this.zzf.zzd) != null && !list.isEmpty())) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdg)).booleanValue()) {
                str = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), (Activity) null);
            } else {
                str = null;
            }
            if ((!((Boolean) zzba.zzc().zzb(zzbbm.zzao)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbde.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbde.zzg.zze()).booleanValue() && ((i2 = this.zzf.zzb) == 1 || i2 == 2 || i2 == 5)) {
                    zzcez zzcez = (zzcez) this.zzm.get();
                }
                zzfwc.zzq((zzfvt) zzfwc.zzn(zzfvt.zzv(zzfwc.zzh((Object) null)), ((Long) zzba.zzc().zzb(zzbbm.zzaS)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcnl(this, str), this.zzb);
                return;
            }
            zzfar zzfar = this.zzh;
            zzfgn zzfgn = this.zzg;
            zzezz zzezz = this.zze;
            zzezn zzezn = this.zzf;
            zzfar.zza(zzfgn.zzd(zzezz, zzezn, false, str, (String) null, zzezn.zzd));
        }
    }

    private final void zzt(int i2, int i3) {
        View view;
        if (i2 <= 0 || !((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzs();
        } else {
            this.zzd.schedule(new zzcnf(this, i2, i3), (long) i3, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzba.zzc().zzb(zzbbm.zzao)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbde.zzd.zze()).booleanValue()) {
            zzfwc.zzq(zzfwc.zze(zzfvt.zzv(this.zzj.zza()), Throwable.class, zzcng.zza, zzcae.zzf), new zzcnk(this), this.zzb);
            return;
        }
        zzfar zzfar = this.zzh;
        zzfgn zzfgn = this.zzg;
        zzezz zzezz = this.zze;
        zzezn zzezn = this.zzf;
        List zzc2 = zzfgn.zzc(zzezz, zzezn, zzezn.zzc);
        int i2 = 1;
        if (true == zzt.zzo().zzx(this.zza)) {
            i2 = 2;
        }
        zzfar.zzc(zzc2, i2);
    }

    public final void zzbr() {
        zzfar zzfar = this.zzh;
        zzfgn zzfgn = this.zzg;
        zzezz zzezz = this.zze;
        zzezn zzezn = this.zzf;
        zzfar.zza(zzfgn.zzc(zzezz, zzezn, zzezn.zzh));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzb.execute(new zzcnj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(int i2, int i3) {
        zzt(i2 - 1, i3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(int i2, int i3) {
        this.zzb.execute(new zzcnh(this, i2, i3));
    }

    public final void zzj() {
    }

    public final void zzk(zze zze2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbr)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfgn.zzf(2, zze2.zza, this.zzf.zzp)));
        }
    }

    public final void zzl() {
        if (this.zzp.compareAndSet(false, true)) {
            int intValue = ((Integer) zzba.zzc().zzb(zzbbm.zzdp)).intValue();
            if (intValue > 0) {
                zzt(intValue, ((Integer) zzba.zzc().zzb(zzbbm.zzdq)).intValue());
                return;
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdo)).booleanValue()) {
                this.zzc.execute(new zzcni(this));
            } else {
                zzs();
            }
        }
    }

    public final void zzm() {
    }

    public final synchronized void zzn() {
        zzcui zzcui;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfar zzfar = this.zzh;
            zzfgn zzfgn = this.zzg;
            zzezz zzezz = this.zze;
            zzezn zzezn = this.zzf;
            zzfar.zza(zzfgn.zzc(zzezz, zzezn, zzezn.zzn));
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdl)).booleanValue() && (zzcui = this.zzn) != null) {
                this.zzh.zza(this.zzg.zzc(this.zzn.zzc(), this.zzn.zzb(), zzfgn.zzg(zzcui.zzb().zzn, zzcui.zza().zzf())));
            }
            zzfar zzfar2 = this.zzh;
            zzfgn zzfgn2 = this.zzg;
            zzezz zzezz2 = this.zze;
            zzezn zzezn2 = this.zzf;
            zzfar2.zza(zzfgn2.zzc(zzezz2, zzezn2, zzezn2.zzg));
        }
        this.zzo = true;
    }

    public final void zzo() {
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
        zzfar zzfar = this.zzh;
        zzfgn zzfgn = this.zzg;
        zzezn zzezn = this.zzf;
        zzfar.zza(zzfgn.zze(zzezn, zzezn.zzi, zzbuu));
    }

    public final void zzq() {
        zzfar zzfar = this.zzh;
        zzfgn zzfgn = this.zzg;
        zzezz zzezz = this.zze;
        zzezn zzezn = this.zzf;
        zzfar.zza(zzfgn.zzc(zzezz, zzezn, zzezn.zzj));
    }
}
