package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import java.util.regex.Pattern;

public final class zzdpj implements zzczy, zza, zzcwa, zzcvk {
    private final Context zza;
    private final zzfax zzb;
    private final zzdqa zzc;
    private final zzezz zzd;
    private final zzezn zze;
    private final zzeba zzf;
    private Boolean zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zzb(zzbbm.zzgE)).booleanValue();

    public zzdpj(Context context, zzfax zzfax, zzdqa zzdqa, zzezz zzezz, zzezn zzezn, zzeba zzeba) {
        this.zza = context;
        this.zzb = zzfax;
        this.zzc = zzdqa;
        this.zzd = zzezz;
        this.zze = zzezn;
        this.zzf = zzeba;
    }

    private final zzdpz zzf(String str) {
        String str2;
        zzdpz zza2 = this.zzc.zza();
        zza2.zze(this.zzd.zzb.zzb);
        zza2.zzd(this.zze);
        zza2.zzb("action", str);
        boolean z2 = false;
        if (!this.zze.zzu.isEmpty()) {
            zza2.zzb("ancn", (String) this.zze.zzu.get(0));
        }
        if (this.zze.zzaj) {
            if (true != zzt.zzo().zzx(this.zza)) {
                str2 = "offline";
            } else {
                str2 = "online";
            }
            zza2.zzb("device_connectivity", str2);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            zza2.zzb("offline_ad", "1");
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            if (zzf.zze(this.zzd.zza.zza) != 1) {
                z2 = true;
            }
            zza2.zzb("scar", String.valueOf(z2));
            if (z2) {
                zzl zzl = this.zzd.zza.zza.zzd;
                zza2.zzc("ragent", zzl.zzp);
                zza2.zzc("rtype", zzf.zza(zzf.zzb(zzl)));
            }
        }
        return zza2;
    }

    private final void zzg(zzdpz zzdpz) {
        if (this.zze.zzaj) {
            this.zzf.zzd(new zzebc(zzt.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdpz.zzf(), 2));
            return;
        }
        zzdpz.zzg();
    }

    private final boolean zzh() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) zzba.zzc().zzb(zzbbm.zzbp);
                    zzt.zzp();
                    String zzn = zzs.zzn(this.zza);
                    boolean z2 = false;
                    if (!(str == null || zzn == null)) {
                        try {
                            z2 = Pattern.matches(str, zzn);
                        } catch (RuntimeException e2) {
                            zzt.zzo().zzu(e2, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(z2);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzaj) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzh) {
            zzdpz zzf2 = zzf("ifts");
            zzf2.zzb("reason", "adapter");
            int i2 = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i2 = zze4.zza;
                str = zze4.zzb;
            }
            if (i2 >= 0) {
                zzf2.zzb("arec", String.valueOf(i2));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzf2.zzb("areec", zza2);
            }
            zzf2.zzg();
        }
    }

    public final void zzb() {
        if (this.zzh) {
            zzdpz zzf2 = zzf("ifts");
            zzf2.zzb("reason", "blocked");
            zzf2.zzg();
        }
    }

    public final void zzc(zzdev zzdev) {
        if (this.zzh) {
            zzdpz zzf2 = zzf("ifts");
            zzf2.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdev.getMessage())) {
                zzf2.zzb("msg", zzdev.getMessage());
            }
            zzf2.zzg();
        }
    }

    public final void zzd() {
        if (zzh()) {
            zzf("adapter_shown").zzg();
        }
    }

    public final void zze() {
        if (zzh()) {
            zzf("adapter_impression").zzg();
        }
    }

    public final void zzl() {
        if (zzh() || this.zze.zzaj) {
            zzg(zzf("impression"));
        }
    }
}
