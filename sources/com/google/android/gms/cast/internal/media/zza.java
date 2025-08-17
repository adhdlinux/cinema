package com.google.android.gms.cast.internal.media;

import android.text.TextUtils;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class zza {
    private static final Logger zza = new Logger("MetadataUtils");
    private static final String[] zzb;
    private static final String zzc;

    static {
        String[] strArr = {"Z", "+hh", "+hhmm", "+hh:mm"};
        zzb = strArr;
        zzc = "yyyyMMdd'T'HHmmss".concat(String.valueOf(strArr[0]));
    }

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zza.d("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzc;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        if (format.endsWith("+0000")) {
            return format.replace("+0000", zzb[0]);
        }
        return format;
    }

    public static Calendar zzb(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            zza.d("Input string is empty or null", new Object[0]);
            return null;
        }
        String zze = zze(str);
        if (TextUtils.isEmpty(zze)) {
            zza.d("Invalid date format", new Object[0]);
            return null;
        }
        String zzf = zzf(str);
        if (!TextUtils.isEmpty(zzf)) {
            zze = zze + RequestConfiguration.MAX_AD_CONTENT_RATING_T + zzf;
            if (zzf.length() == 6) {
                str2 = "yyyyMMdd'T'HHmmss";
            } else {
                str2 = zzc;
            }
        } else {
            str2 = "yyyyMMdd";
        }
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(zze));
            return instance;
        } catch (ParseException e2) {
            zza.e(e2, "Error parsing string", new Object[0]);
            return null;
        }
    }

    public static JSONArray zzc(List list) {
        list.getClass();
        JSONArray jSONArray = new JSONArray();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((WebImage) it2.next()).toJson());
        }
        return jSONArray;
    }

    public static void zzd(List list, JSONArray jSONArray) {
        try {
            list.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i2)));
                } catch (IllegalArgumentException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
    }

    private static String zze(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.substring(0, 8);
            } catch (IndexOutOfBoundsException e2) {
                zza.e(e2, "Error extracting the date", new Object[0]);
                return null;
            }
        } else {
            zza.d("Input string is empty or null", new Object[0]);
            return null;
        }
    }

    private static String zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            zza.d("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i2 = indexOf + 1;
        if (indexOf != 8) {
            zza.d("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i2);
            if (substring.length() == 6) {
                return substring;
            }
            char charAt = substring.charAt(6);
            if (charAt == '+' || charAt == '-') {
                int length = substring.length();
                String[] strArr = zzb;
                if (length == strArr[1].length() + 6 || length == strArr[2].length() + 6 || length == strArr[3].length() + 6) {
                    return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                }
            } else if (charAt == 'Z' && substring.length() == zzb[0].length() + 6) {
                return String.valueOf(substring.substring(0, substring.length() - 1)).concat("+0000");
            } else {
                return null;
            }
            return null;
        } catch (IndexOutOfBoundsException e2) {
            zza.e(e2, "Error extracting the time substring: %s", new Object[0]);
            return null;
        }
    }
}
