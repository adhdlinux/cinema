package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcoh implements zzaua {
    private zzcez zza;
    private final Executor zzb;
    private final zzcnt zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcnw zzg = new zzcnw();

    public zzcoh(Executor executor, zzcnt zzcnt, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcnt;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcog(this, zza2));
            }
        } catch (JSONException e2) {
            zze.zzb("Failed to call video active view js", e2);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    public final void zzc(zzatz zzatz) {
        boolean z2;
        zzcnw zzcnw = this.zzg;
        if (this.zzf) {
            z2 = false;
        } else {
            z2 = zzatz.zzj;
        }
        zzcnw.zza = z2;
        zzcnw.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzatz;
        if (this.zze) {
            zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zze(boolean z2) {
        this.zzf = z2;
    }

    public final void zzf(zzcez zzcez) {
        this.zza = zzcez;
    }
}
