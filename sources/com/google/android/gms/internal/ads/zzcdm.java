package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcdm implements zzbij {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzbzr.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdl zzcdl;
        zzcdd zzcdd;
        Map map2 = map;
        zzcca zzcca = (zzcca) obj;
        if (zzbzr.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map2);
            jSONObject.remove("google.afma.Notify_dt");
            zzbzr.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcde zzy = zzt.zzy();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get("src");
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzcbz zzcbz = new zzcbz((String) map2.get("flags"));
            boolean z2 = zzcbz.zzl;
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map2.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzbzr.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (z2) {
                    Iterator it2 = zzy.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            zzcdd = null;
                            break;
                        }
                        zzcdd zzcdd2 = (zzcdd) it2.next();
                        if (zzcdd2.zza == zzcca && str.equals(zzcdd2.zze())) {
                            zzcdd = zzcdd2;
                            break;
                        }
                    }
                } else {
                    zzcdd = zzy.zza(zzcca);
                }
                if (zzcdd != null) {
                    zzbzr.zzj("Precache task is already running.");
                    return;
                } else if (zzcca.zzj() == null) {
                    zzbzr.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzcca.zzA(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzcca.zzy(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzcca.zzx(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzccx zzccx = zzcca.zzj().zzb;
                    if (intValue > 0) {
                        int zzu = zzcbr.zzu();
                        if (zzu < zzcbz.zzh) {
                            zzcdl = new zzcdu(zzcca, zzcbz);
                        } else if (zzu < zzcbz.zzb) {
                            zzcdl = new zzcdr(zzcca, zzcbz);
                        } else {
                            zzcdl = new zzcdp(zzcca);
                        }
                    } else {
                        zzcdl = new zzcdo(zzcca);
                    }
                    new zzcdd(zzcca, zzcdl, str, strArr).zzb();
                }
            } else {
                zzcdd zza = zzy.zza(zzcca);
                if (zza != null) {
                    zzcdl = zza.zzb;
                } else {
                    zzbzr.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzcdl.zzs(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzcdl.zzr(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzcdl.zzp(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzcdl.zzq(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzcca)) {
            zzbzr.zzj("Precache abort but no precache task running.");
        }
    }
}
