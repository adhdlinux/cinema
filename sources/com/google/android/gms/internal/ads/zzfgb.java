package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTimeConstants;

public final class zzfgb implements Runnable {
    public static final Object zza = new Object();
    public static Boolean zzb;
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final Context zze;
    private final zzbzx zzf;
    private final zzfgg zzg = zzfgj.zzc();
    private String zzh = "";
    private int zzi;
    private final zzdns zzj;
    private final List zzk;
    private boolean zzl = false;
    private final zzdyw zzm;
    private final zzbuq zzn;

    public zzfgb(Context context, zzbzx zzbzx, zzdns zzdns, zzdyw zzdyw, zzbuq zzbuq) {
        this.zze = context;
        this.zzf = zzbzx;
        this.zzj = zzdns;
        this.zzm = zzdyw;
        this.zzn = zzbuq;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziq)).booleanValue()) {
            this.zzk = zzs.zzd();
        } else {
            this.zzk = zzfsc.zzl();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        boolean z2;
        synchronized (zza) {
            if (zzb == null) {
                if (!((Boolean) zzbcy.zzb.zze()).booleanValue()) {
                    zzb = Boolean.FALSE;
                } else {
                    if (Math.random() < ((Double) zzbcy.zza.zze()).doubleValue()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzb = Boolean.valueOf(z2);
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    public final void run() {
        byte[] zzax;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() != 0) {
                    try {
                        synchronized (obj) {
                            zzax = ((zzfgj) this.zzg.zzal()).zzax();
                            this.zzg.zzc();
                        }
                        new zzdyv(this.zze, this.zzf.zza, this.zzn, Binder.getCallingUid()).zza(new zzdyt((String) zzba.zzc().zzb(zzbbm.zzik), DateTimeConstants.MILLIS_PER_MINUTE, new HashMap(), zzax, "application/x-protobuf", false));
                    } catch (Exception e2) {
                        if (!(e2 instanceof zzdtx) || ((zzdtx) e2).zza() != 3) {
                            zzt.zzo().zzt(e2, "CuiMonitor.sendCuiPing");
                        }
                    }
                }
            }
        }
    }

    public final void zzb(zzffr zzffr) {
        zzcae.zza.zza(new zzfga(this, zzffr));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzffr zzffr) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    zzt.zzp();
                    this.zzh = zzs.zzn(this.zze);
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    long intValue = (long) ((Integer) zzba.zzc().zzb(zzbbm.zzil)).intValue();
                    zzcae.zzd.scheduleAtFixedRate(this, intValue, intValue, TimeUnit.MILLISECONDS);
                }
            }
        }
        if (zza() && zzffr != null) {
            synchronized (zzc) {
                if (this.zzg.zza() < ((Integer) zzba.zzc().zzb(zzbbm.zzim)).intValue()) {
                    zzfgd zza2 = zzfge.zza();
                    zza2.zzt(zzffr.zzl());
                    zza2.zzp(zzffr.zzk());
                    zza2.zzg(zzffr.zzb());
                    zza2.zzv(3);
                    zza2.zzm(this.zzf.zza);
                    zza2.zzb(this.zzh);
                    zza2.zzk(Build.VERSION.RELEASE);
                    zza2.zzq(Build.VERSION.SDK_INT);
                    zza2.zzu(zzffr.zzn());
                    zza2.zzj(zzffr.zza());
                    zza2.zze((long) this.zzi);
                    zza2.zzs(zzffr.zzm());
                    zza2.zzc(zzffr.zzd());
                    zza2.zzf(zzffr.zzf());
                    zza2.zzh(zzffr.zzg());
                    zza2.zzi(this.zzj.zzc(zzffr.zzg()));
                    zza2.zzl(zzffr.zzh());
                    zza2.zzd(zzffr.zze());
                    zza2.zzr(zzffr.zzj());
                    zza2.zzn(zzffr.zzi());
                    zza2.zzo(zzffr.zzc());
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zziq)).booleanValue()) {
                        zza2.zza(this.zzk);
                    }
                    zzfgg zzfgg = this.zzg;
                    zzfgh zza3 = zzfgi.zza();
                    zza3.zza(zza2);
                    zzfgg.zzb(zza3);
                }
            }
        }
    }
}
