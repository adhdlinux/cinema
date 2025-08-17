package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class zzbzq {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static boolean zzc = false;
    private static boolean zzd = false;
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set zzf = new HashSet(Arrays.asList(new String[0]));
    private final List zzg;

    public zzbzq() {
        this((String) null);
    }

    static /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    static /* synthetic */ void zzb(int i2, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i2);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static void zzi() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzbzr.zzj("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzj(boolean z2) {
        synchronized (zzb) {
            zzc = true;
            zzd = z2;
        }
    }

    public static boolean zzk() {
        boolean z2;
        synchronized (zzb) {
            z2 = false;
            if (zzc && zzd) {
                z2 = true;
            }
        }
        return z2;
    }

    public static boolean zzl() {
        boolean z2;
        synchronized (zzb) {
            z2 = zzc;
        }
        return z2;
    }

    private static synchronized void zzm(String str) {
        synchronized (zzbzq.class) {
            zzbzr.zzi("GMA Debug BEGIN");
            int i2 = 0;
            while (i2 < str.length()) {
                int i3 = i2 + 4000;
                zzbzr.zzi("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i2, Math.min(i3, str.length())))));
                i2 = i3;
            }
            zzbzr.zzi("GMA Debug FINISH");
        }
    }

    private final void zzn(String str, zzbzp zzbzp) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.zzg) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            zzbzp.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzbzr.zzh("unable to log", e2);
        }
        zzm(stringWriter.toString());
    }

    private final void zzo(String str) {
        zzn("onNetworkRequestError", new zzbzm(str));
    }

    private final void zzp(String str, String str2, Map map, byte[] bArr) {
        zzn("onNetworkRequest", new zzbzn(str, str2, map, bArr));
    }

    private final void zzq(Map map, int i2) {
        zzn("onNetworkResponse", new zzbzl(i2, map));
    }

    private static void zzr(JsonWriter jsonWriter, Map map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                String str = (String) entry.getKey();
                if (!zzf.contains(str)) {
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            zzbzr.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    public final void zzc(HttpURLConnection httpURLConnection, byte[] bArr) {
        HashMap hashMap;
        if (zzk()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzp(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzd(String str, String str2, Map map, byte[] bArr) {
        if (zzk()) {
            zzp(str, "GET", map, bArr);
        }
    }

    public final void zze(HttpURLConnection httpURLConnection, int i2) {
        HashMap hashMap;
        if (zzk()) {
            String str = null;
            if (httpURLConnection.getHeaderFields() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getHeaderFields());
            }
            zzq(hashMap, i2);
            if (i2 < 200 || i2 >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    zzbzr.zzj("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e2.getMessage())));
                }
                zzo(str);
            }
        }
    }

    public final void zzf(Map map, int i2) {
        if (zzk()) {
            zzq(map, i2);
            if (i2 < 200 || i2 >= 300) {
                zzo((String) null);
            }
        }
    }

    public final void zzg(String str) {
        if (zzk() && str != null) {
            zzh(str.getBytes());
        }
    }

    public final void zzh(byte[] bArr) {
        zzn("onNetworkResponseBody", new zzbzo(bArr));
    }

    public zzbzq(String str) {
        List list;
        if (!zzk()) {
            list = new ArrayList();
        } else {
            list = Arrays.asList(new String[]{"network_request_".concat(String.valueOf(UUID.randomUUID().toString()))});
        }
        this.zzg = list;
    }
}
