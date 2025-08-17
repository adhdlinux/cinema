package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class zzdyu {
    public int zza = 0;
    public Map zzb = new HashMap();
    public String zzc = "";
    public long zzd = -1;

    public static zzdyu zza(Reader reader) throws zzezr {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            HashMap hashMap = new HashMap();
            String str = "";
            jsonReader.beginObject();
            long j2 = -1;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("response".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("body".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("latency".equals(nextName)) {
                    j2 = jsonReader.nextLong();
                } else if ("headers".equals(nextName)) {
                    hashMap = new HashMap();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        hashMap.put(jsonReader.nextName(), zzbu.zzd(jsonReader));
                    }
                    jsonReader.endObject();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            zzdyu zzdyu = new zzdyu();
            zzdyu.zza = i2;
            if (str != null) {
                zzdyu.zzc = str;
            }
            zzdyu.zzd = j2;
            zzdyu.zzb = hashMap;
            IOUtils.closeQuietly((Closeable) reader);
            return zzdyu;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException e2) {
            throw new zzezr("Unable to parse Response", e2);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
