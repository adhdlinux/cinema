package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public final class zzdql {
    private final Clock zza;

    public zzdql(Clock clock) {
        this.zza = clock;
    }

    public final void zza(List list, String str, String str2, Object... objArr) {
        String str3;
        if (((Boolean) zzbdi.zza.zze()).booleanValue()) {
            long currentTimeMillis = this.zza.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(currentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                for (Object obj : list) {
                    jsonWriter.value(obj.toString());
                }
                jsonWriter.endArray();
                jsonWriter.name("params").beginArray();
                for (Object obj2 : objArr) {
                    if (obj2 != null) {
                        str3 = obj2.toString();
                    } else {
                        str3 = null;
                    }
                    jsonWriter.value(str3);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e2) {
                zzbzr.zzh("unable to log", e2);
            }
            zzbzr.zzi("AD-DBG ".concat(String.valueOf(stringWriter.toString())));
        }
    }
}
