package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.util.Map;

public final class zzcmt implements zzcmj {
    private final Context zza;
    private final zzg zzb = zzt.zzo().zzh();

    public zzcmt(Context context) {
        this.zza = context;
    }

    public final void zza(Map map) {
        if (!map.isEmpty()) {
            String str = (String) map.get("gad_idless");
            if (str != null) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                map.remove("gad_idless");
                if (parseBoolean) {
                    try {
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcC)).booleanValue()) {
                            zzfmh.zzj(this.zza).zzk();
                        }
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcL)).booleanValue()) {
                            zzfmh.zzj(this.zza).zzl();
                        }
                        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcD)).booleanValue()) {
                            zzfmi.zzi(this.zza).zzj();
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzcH)).booleanValue()) {
                                zzfmi.zzi(this.zza).zzk();
                            }
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzcI)).booleanValue()) {
                                zzfmi.zzi(this.zza).zzl();
                            }
                        }
                    } catch (IOException e2) {
                        zzt.zzo().zzu(e2, "SetAppMeasurementConsentConfig.run");
                    }
                }
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzau)).booleanValue()) {
                    this.zzb.zzH(parseBoolean);
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && parseBoolean) {
                        this.zza.deleteDatabase("OfflineUpload.db");
                    }
                }
            }
            Bundle bundle = new Bundle();
            for (Map.Entry entry : map.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzap)).booleanValue()) {
                zzt.zzn().zzr(bundle);
            }
        }
    }
}
