package com.google.android.gms.internal.ads;

import android.util.JsonWriter;

public final /* synthetic */ class zzbzm implements zzbzp {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbzm(String str) {
        this.zza = str;
    }

    public final void zza(JsonWriter jsonWriter) {
        String str = this.zza;
        int i2 = zzbzq.zza;
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }
}
