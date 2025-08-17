package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

public final class zzfis extends zzfio {
    public zzfis(zzfih zzfih, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(zzfih, hashSet, jSONObject, j2);
    }

    private final void zzc(String str) {
        zzfhl zza = zzfhl.zza();
        if (zza != null) {
            for (zzfha zzfha : zza.zzc()) {
                if (this.zza.contains(zzfha.zzh())) {
                    zzfha.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
