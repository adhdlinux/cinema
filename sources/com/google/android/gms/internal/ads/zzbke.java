package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzbke implements zzald {
    /* access modifiers changed from: private */
    public volatile zzbjr zza;
    private final Context zzb;

    public zzbke(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbke zzbke) {
        if (zzbke.zza != null) {
            zzbke.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzalg zza(zzalk zzalk) throws zzalt {
        Parcelable.Creator<zzbjs> creator = zzbjs.CREATOR;
        Map zzl = zzalk.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        int i3 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i3] = (String) entry.getKey();
            strArr2[i3] = (String) entry.getValue();
            i3++;
        }
        zzbjs zzbjs = new zzbjs(zzalk.zzk(), strArr, strArr2);
        long elapsedRealtime = zzt.zzB().elapsedRealtime();
        try {
            zzcaj zzcaj = new zzcaj();
            this.zza = new zzbjr(this.zzb, zzt.zzt().zzb(), new zzbkc(this, zzcaj), new zzbkd(this, zzcaj));
            this.zza.checkAvailabilityAndConnect();
            zzbka zzbka = new zzbka(this, zzbjs);
            zzfwn zzfwn = zzcae.zza;
            zzfwm zzn = zzfwc.zzn(zzfwc.zzm(zzcaj, zzbka, zzfwn), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzei)).intValue(), TimeUnit.MILLISECONDS, zzcae.zzd);
            zzn.zzc(new zzbkb(this), zzfwn);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzn.get();
            long elapsedRealtime2 = zzt.zzB().elapsedRealtime() - elapsedRealtime;
            zze.zza("Http assets remote cache took " + elapsedRealtime2 + "ms");
            zzbju zzbju = (zzbju) new zzbuc(parcelFileDescriptor).zza(zzbju.CREATOR);
            if (zzbju == null) {
                return null;
            }
            if (zzbju.zza) {
                throw new zzalt(zzbju.zzb);
            } else if (zzbju.zze.length != zzbju.zzf.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbju.zze;
                    if (i2 >= strArr3.length) {
                        return new zzalg(zzbju.zzc, zzbju.zzd, (Map) hashMap, zzbju.zzg, zzbju.zzh);
                    }
                    hashMap.put(strArr3[i2], zzbju.zzf[i2]);
                    i2++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            zze.zza("Http assets remote cache took " + (zzt.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            zze.zza("Http assets remote cache took " + (zzt.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
