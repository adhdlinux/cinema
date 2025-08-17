package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

public final /* synthetic */ class zzbzl implements zzbzp {
    public final /* synthetic */ int zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzbzl(int i2, Map map) {
        this.zza = i2;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzbzq.zzb(this.zza, this.zzb, jsonWriter);
    }
}
