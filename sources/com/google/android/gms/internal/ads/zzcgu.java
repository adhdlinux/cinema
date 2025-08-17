package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzaa;
import com.google.android.gms.ads.nonagon.signalgeneration.zzc;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzcgu implements zzcmg {
    private static zzcgu zza;

    private static synchronized zzcgu zzC(Context context, zzbnw zzbnw, int i2, boolean z2, int i3, zzchy zzchy) {
        synchronized (zzcgu.class) {
            zzcgu zzcgu = zza;
            if (zzcgu != null) {
                return zzcgu;
            }
            zzbbm.zza(context);
            zzfbb zzd = zzfbb.zzd(context);
            zzbzx zzc = zzd.zzc(ModuleDescriptor.MODULE_VERSION, false, i3);
            zzd.zzf(zzbnw);
            zzcjm zzcjm = new zzcjm((zzcjl) null);
            zzcgv zzcgv = new zzcgv();
            zzcgv.zzd(zzc);
            zzcgv.zzc(context);
            zzcjm.zzb(new zzcgx(zzcgv, (zzcgw) null));
            zzcjm.zzc(new zzckz(zzchy));
            zzcgu zza2 = zzcjm.zza();
            zzt.zzo().zzs(context, zzc);
            zzt.zzc().zzi(context);
            zzt.zzp().zzj(context);
            zzt.zzp().zzi(context);
            zzd.zza(context);
            zzt.zzb().zzd(context);
            zzt.zzv().zzb(context);
            zzbxx.zzd(context);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zzb(zzbbm.zzav)).booleanValue()) {
                    zzawz zzawz = new zzawz(new zzaxf(context));
                    zzdzt zzdzt = new zzdzt(new zzdzp(context), zza2.zzz());
                    zzt.zzp();
                    new zzeap(context, zzc, zzawz, zzdzt, UUID.randomUUID().toString(), zza2.zzx()).zzb(zzt.zzo().zzh().zzP());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcgu zza(Context context, zzbnw zzbnw, int i2) {
        return zzC(context, zzbnw, ModuleDescriptor.MODULE_VERSION, false, i2, new zzchy());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzclj zzb();

    public abstract zzcoo zzc();

    public abstract zzcpx zzd();

    public abstract zzcxv zze();

    public abstract zzden zzf();

    public abstract zzdfj zzg();

    public abstract zzdmq zzh();

    public abstract zzdri zzi();

    public abstract zzdsx zzj();

    public abstract zzdtr zzk();

    public abstract zzebl zzl();

    public abstract zzc zzm();

    public abstract zzg zzn();

    public abstract zzaa zzo();

    public final zzerq zzp(zzbue zzbue, int i2) {
        return zzq(new zzets(zzbue, i2));
    }

    /* access modifiers changed from: protected */
    public abstract zzerq zzq(zzets zzets);

    public abstract zzeun zzr();

    public abstract zzewb zzs();

    public abstract zzexs zzt();

    public abstract zzezg zzu();

    public abstract zzfau zzv();

    public abstract zzfbe zzw();

    public abstract zzfev zzx();

    public abstract zzfgb zzy();

    public abstract zzfwn zzz();
}
