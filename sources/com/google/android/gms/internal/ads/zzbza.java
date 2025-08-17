package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.protobuf.CodedOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbza {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb;
    private final zzbze zzc;
    private boolean zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public zzbzx zzf;
    private String zzg;
    /* access modifiers changed from: private */
    public zzbbu zzh;
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final zzbyz zzk;
    private final Object zzl;
    private zzfwm zzm;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzn;

    public zzbza() {
        zzj zzj2 = new zzj();
        this.zzb = zzj2;
        this.zzc = new zzbze(zzay.zzd(), zzj2);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new zzbyz((zzbyy) null);
        this.zzl = new Object();
        this.zzn = new AtomicBoolean();
    }

    public final int zza() {
        return this.zzj.get();
    }

    public final Context zzc() {
        return this.zze;
    }

    public final Resources zzd() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzju)).booleanValue()) {
                return zzbzv.zza(this.zze).getResources();
            }
            zzbzv.zza(this.zze).getResources();
            return null;
        } catch (zzbzu e2) {
            zzbzr.zzk("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final zzbbu zzf() {
        zzbbu zzbbu;
        synchronized (this.zza) {
            zzbbu = this.zzh;
        }
        return zzbbu;
    }

    public final zzbze zzg() {
        return this.zzc;
    }

    public final zzg zzh() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final zzfwm zzj() {
        if (this.zze != null) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzct)).booleanValue()) {
                synchronized (this.zzl) {
                    zzfwm zzfwm = this.zzm;
                    if (zzfwm != null) {
                        return zzfwm;
                    }
                    zzfwm zzb2 = zzcae.zza.zzb(new zzbyv(this));
                    this.zzm = zzb2;
                    return zzb2;
                }
            }
        }
        return zzfwc.zzh(new ArrayList());
    }

    public final Boolean zzk() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzm() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzn() throws Exception {
        Context zza2 = zzbus.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i2 = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i2] & 2) != 0) {
                        arrayList.add(strArr[i2]);
                    }
                    i2++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzp() {
        this.zzk.zza();
    }

    public final void zzq() {
        this.zzj.decrementAndGet();
    }

    public final void zzr() {
        this.zzj.incrementAndGet();
    }

    @TargetApi(23)
    public final void zzs(Context context, zzbzx zzbzx) {
        zzbbu zzbbu;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = zzbzx;
                zzt.zzb().zzc(this.zzc);
                this.zzb.zzr(this.zze);
                zzbsw.zzb(this.zze, this.zzf);
                zzt.zze();
                if (!((Boolean) zzbcz.zzc.zze()).booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbbu = null;
                } else {
                    zzbbu = new zzbbu();
                }
                this.zzh = zzbbu;
                if (zzbbu != null) {
                    zzcah.zza(new zzbyw(this).zzb(), "AppState.registerCsiReporter");
                }
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzhW)).booleanValue()) {
                        ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzbyx(this));
                    }
                }
                this.zzd = true;
                zzj();
            }
        }
        zzt.zzp().zzc(context, zzbzx.zza);
    }

    public final void zzt(Throwable th, String str) {
        zzbsw.zzb(this.zze, this.zzf).zzg(th, str, ((Double) zzbdn.zzg.zze()).floatValue());
    }

    public final void zzu(Throwable th, String str) {
        zzbsw.zzb(this.zze, this.zzf).zzf(th, str);
    }

    public final void zzv(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzw(String str) {
        this.zzg = str;
    }

    public final boolean zzx(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhW)).booleanValue()) {
                return this.zzn.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
