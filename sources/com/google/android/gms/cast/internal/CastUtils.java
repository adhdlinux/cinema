package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
public final class CastUtils {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");
    private static final Random zzc = new Random(SystemClock.elapsedRealtime());

    private CastUtils() {
    }

    @KeepForSdk
    public static JSONObject jsonStringToJsonObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static double millisecToSec(long j2) {
        return ((double) j2) / 1000.0d;
    }

    @KeepForSdk
    public static String optStringOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    @KeepForSdk
    public static long secToMillisec(double d2) {
        return (long) (d2 * 1000.0d);
    }

    @KeepForSdk
    public static long secToMillisec(long j2) {
        return j2 * 1000;
    }

    @KeepForSdk
    public static void throwIfInvalidNamespace(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    @KeepForSdk
    public static long[] toLongArray(Collection<Long> collection) {
        long[] jArr = new long[collection.size()];
        int i2 = 0;
        for (Long longValue : collection) {
            jArr[i2] = longValue.longValue();
            i2++;
        }
        return jArr;
    }

    @KeepForSdk
    public static long[] toLongArraySafely(JSONArray jSONArray) {
        try {
            return zzg(jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static long zza() {
        return zzc.nextLong();
    }

    public static String zzb(Locale locale) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-');
            sb.append(variant);
        }
        return sb.toString();
    }

    public static String zzc(String str) {
        if (zzb.matcher(str).matches()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-' || charAt == '.' || charAt == ':'))) {
                sb.append(String.format("%%%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static List zzd(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean zze(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
    }

    public static int[] zzf(Collection collection) {
        int[] iArr = new int[collection.size()];
        Iterator it2 = collection.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr[i2] = ((Integer) it2.next()).intValue();
            i2++;
        }
        return iArr;
    }

    public static long[] zzg(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        long[] jArr = new long[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            jArr[i2] = jSONArray.getLong(i2);
        }
        return jArr;
    }
}
