package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public final class zzbce {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbce(boolean z2, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzbcb zzf() {
        return new zzbcb(zzt.zzB().elapsedRealtime(), (String) null, (zzbcb) null);
    }

    public final zzbcd zza() {
        zzbcd zzbcd;
        boolean booleanValue = ((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbcb zzbcb : this.zza) {
                long zza2 = zzbcb.zza();
                String zzc2 = zzbcb.zzc();
                zzbcb zzb2 = zzbcb.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzt.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzt.zzB().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbcd = new zzbcd(sb.toString(), str);
        }
        return zzbcd;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzt.zzo().zzf();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbce zzbce) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbbu zzf;
        if (!TextUtils.isEmpty(str2) && (zzf = zzt.zzo().zzf()) != null) {
            synchronized (this.zzc) {
                zzbca zza2 = zzf.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbcb zzbcb, long j2, String... strArr) {
        synchronized (this.zzc) {
            for (int i2 = 0; i2 <= 0; i2++) {
                this.zza.add(new zzbcb(j2, strArr[i2], zzbcb));
            }
        }
        return true;
    }
}
