package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzerb {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzffy zzd;
    private final zzdqa zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzerb(Context context, Executor executor, Set set, zzffy zzffy, zzdqa zzdqa) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzffy;
        this.zze = zzdqa;
    }

    public final zzfwm zza(Object obj) {
        zzffn zza2 = zzffm.zza(this.zza, 8);
        zza2.zzh();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        zzbbe zzbbe = zzbbm.zzkf;
        if (!((String) zzba.zzc().zzb(zzbbe)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) zzba.zzc().zzb(zzbbe)).split(","));
        }
        this.zzf = zzt.zzB().elapsedRealtime();
        for (zzeqy zzeqy : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzeqy.zza()))) {
                long elapsedRealtime = zzt.zzB().elapsedRealtime();
                zzfwm zzb2 = zzeqy.zzb();
                zzb2.zzc(new zzeqz(this, elapsedRealtime, zzeqy), zzcae.zzf);
                arrayList.add(zzb2);
            }
        }
        zzfwm zza3 = zzfwc.zzb(arrayList).zza(new zzera(arrayList, obj), this.zzc);
        if (zzfgb.zza()) {
            zzffx.zza(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    public final void zzb(long j2, zzeqy zzeqy) {
        long elapsedRealtime = zzt.zzB().elapsedRealtime() - j2;
        if (((Boolean) zzbdi.zza.zze()).booleanValue()) {
            zze.zza("Signal runtime (ms) : " + zzfpw.zzc(zzeqy.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbT)).booleanValue()) {
            zzdpz zza2 = this.zze.zza();
            zza2.zzb("action", "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzeqy.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbU)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza2.zzb("seq_num", zzt.zzo().zzg().zzc());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(zzt.zzB().elapsedRealtime() - this.zzf);
                        if (zzeqy.zza() <= 39 || zzeqy.zza() >= 52) {
                            zza2.zzb("lat_clsg", valueOf);
                        } else {
                            zza2.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza2.zzh();
        }
    }
}
