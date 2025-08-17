package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzezo {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzezo(int i2, int i3, boolean z2) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = z2;
    }

    static List zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            boolean z2 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z2 = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzezo(i2, i3, z2));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
