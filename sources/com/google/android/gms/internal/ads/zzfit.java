package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

public final class zzfit extends zzfio {
    public zzfit(zzfih zzfih, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(zzfih, hashSet, jSONObject, j2);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfib.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzfhl zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfhl.zza()) != null) {
            for (zzfha zzfha : zza.zzc()) {
                if (this.zza.contains(zzfha.zzh())) {
                    zzfha.zzg().zze(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
