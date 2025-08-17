package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzdss {
    private final zzdsc zza;
    private final zzdns zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    zzdss(zzdsc zzdsc, zzdns zzdns) {
        this.zza = zzdsc;
        this.zzb = zzdns;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List list) {
        String str;
        boolean z2;
        synchronized (this.zzc) {
            if (!this.zze) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzbkf zzbkf = (zzbkf) it2.next();
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zziO)).booleanValue()) {
                        zzdnr zza2 = this.zzb.zza(zzbkf.zza);
                        if (zza2 != null) {
                            zzbqh zzbqh = zza2.zzc;
                            if (zzbqh != null) {
                                str = zzbqh.toString();
                            }
                        }
                        str = "";
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zziP)).booleanValue()) {
                        zzdnr zza3 = this.zzb.zza(zzbkf.zza);
                        if (zza3 != null) {
                            if (zza3.zzd) {
                                z2 = true;
                                List list2 = this.zzd;
                                String str3 = zzbkf.zza;
                                String zzc2 = this.zzb.zzc(str3);
                                boolean z3 = zzbkf.zzb;
                                list2.add(new zzdsr(str3, str2, zzc2, z3 ? 1 : 0, zzbkf.zzd, zzbkf.zzc, z2));
                            }
                        }
                    }
                    z2 = false;
                    List list22 = this.zzd;
                    String str32 = zzbkf.zza;
                    String zzc22 = this.zzb.zzc(str32);
                    boolean z32 = zzbkf.zzb;
                    list22.add(new zzdsr(str32, str2, zzc22, z32 ? 1 : 0, zzbkf.zzd, zzbkf.zzc, z2));
                }
                this.zze = true;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                    return jSONArray;
                }
            }
            for (zzdsr zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
            return jSONArray;
        }
    }

    public final void zzc() {
        this.zza.zzs(new zzdsq(this));
    }
}
