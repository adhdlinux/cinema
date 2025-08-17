package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class zzdyr extends zzbtt {
    private final Context zza;
    private final zzesg zzb;
    private final zzese zzc;
    private final zzdyz zzd;
    private final zzfwn zze;
    private final zzdyw zzf;
    private final zzbuq zzg;

    zzdyr(Context context, zzesg zzesg, zzese zzese, zzdyw zzdyw, zzdyz zzdyz, zzfwn zzfwn, zzbuq zzbuq) {
        this.zza = context;
        this.zzb = zzesg;
        this.zzc = zzese;
        this.zzf = zzdyw;
        this.zzd = zzdyz;
        this.zze = zzfwn;
        this.zzg = zzbuq;
    }

    private final void zzc(zzfwm zzfwm, zzbtx zzbtx) {
        zzfwc.zzq(zzfwc.zzm(zzfvt.zzv(zzfwm), new zzdyj(this), zzcae.zza), new zzdyq(this, zzbtx), zzcae.zzf);
    }

    public final zzfwm zzb(zzbtm zzbtm, int i2) {
        zzfwm zzfwm;
        String str = zzbtm.zza;
        int i3 = zzbtm.zzb;
        Bundle bundle = zzbtm.zzc;
        HashMap hashMap = new HashMap();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                String string = bundle.getString(next);
                if (string != null) {
                    hashMap.put(next, string);
                }
            }
        }
        zzdyt zzdyt = new zzdyt(str, i3, hashMap, zzbtm.zzd, "", zzbtm.zze);
        zzese zzese = this.zzc;
        zzese.zza(new zzetl(zzbtm));
        zzesf zzb2 = zzese.zzb();
        if (zzdyt.zzf) {
            String str2 = zzbtm.zza;
            String str3 = (String) zzbdl.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                String host = Uri.parse(str2).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it2 = zzfpu.zzc(zzfos.zzc(';')).zzd(str3).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (host.endsWith((String) it2.next())) {
                                zzfwm = zzfwc.zzl(zzb2.zza().zza(new JSONObject()), new zzdyp(zzdyt), this.zze);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        zzfwm = zzfwc.zzh(zzdyt);
        zzfel zzb3 = zzb2.zzb();
        return zzfwc.zzm(zzb3.zzb(zzfef.HTTP, zzfwm).zze(new zzdyv(this.zza, "", this.zzg, i2)).zza(), zzdyl.zza, this.zze);
    }

    public final void zze(zzbtm zzbtm, zzbtx zzbtx) {
        zzc(zzb(zzbtm, Binder.getCallingUid()), zzbtx);
    }

    public final void zzf(zzbti zzbti, zzbtx zzbtx) {
        int callingUid = Binder.getCallingUid();
        zzesg zzesg = this.zzb;
        zzesg.zza(new zzerv(zzbti, callingUid));
        zzesh zzb2 = zzesg.zzb();
        zzfel zzb3 = zzb2.zzb();
        zzfdq zza2 = zzb3.zzb(zzfef.GMS_SIGNALS, zzfwc.zzi()).zzf(new zzdyo(zzb2)).zze(zzdyn.zza).zzf(zzdym.zza).zza();
        zzc(zza2, zzbtx);
        if (((Boolean) zzbdf.zzd.zze()).booleanValue()) {
            zzdyz zzdyz = this.zzd;
            zzdyz.getClass();
            zza2.zzc(new zzdyk(zzdyz), this.zze);
        }
    }
}
