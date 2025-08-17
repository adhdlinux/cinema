package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleUtils {
    public static boolean containsAtLeastOneKey(Set<String> set, Bundle bundle) {
        if (set != null && !set.isEmpty()) {
            for (String containsKey : set) {
                if (bundle.containsKey(containsKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getBoolean(String str, Bundle bundle) {
        return getBoolean(str, false, bundle);
    }

    public static boolean getBoolean(String str, boolean z2, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() != 0;
            }
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (str2.equalsIgnoreCase("true") || str2.equalsIgnoreCase("1")) {
                    return true;
                }
                if (str2.equalsIgnoreCase(Constants.CASEFIRST_FALSE) || str2.equalsIgnoreCase("0")) {
                    return false;
                }
                return z2;
            }
        }
        return z2;
    }

    public static Bundle getBundle(String str, Bundle bundle) {
        return getBundle(str, (Bundle) null, bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = r3.getBundle(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle getBundle(java.lang.String r1, android.os.Bundle r2, android.os.Bundle r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0010
            if (r3 != 0) goto L_0x0009
            goto L_0x0010
        L_0x0009:
            android.os.Bundle r1 = r3.getBundle(r1)
            if (r1 == 0) goto L_0x0010
            r2 = r1
        L_0x0010:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.BundleUtils.getBundle(java.lang.String, android.os.Bundle, android.os.Bundle):android.os.Bundle");
    }

    public static int getInt(String str, int i2, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return i2;
    }

    public static int getInt(String str, Bundle bundle) {
        return getInt(str, 0, bundle);
    }

    public static long getLong(String str, long j2, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof String) {
                try {
                    return Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return j2;
    }

    public static long getLong(String str, Bundle bundle) {
        return getLong(str, 0, bundle);
    }

    public static String getString(String str, Bundle bundle) {
        return getString(str, (String) null, bundle);
    }

    public static String getString(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null || !bundle.containsKey(str)) {
            return str2;
        }
        Object obj = bundle.get(str);
        return obj instanceof String ? (String) obj : String.valueOf(obj);
    }

    public static void put(String str, Object obj, Bundle bundle) {
        String str2;
        if (obj != null) {
            if (obj instanceof String) {
                putString(str, (String) obj, bundle);
                return;
            } else if (obj instanceof Boolean) {
                putBoolean(str, (Boolean) obj, bundle);
                return;
            } else if (obj instanceof Integer) {
                putInt(str, (Integer) obj, bundle);
                return;
            } else if (obj instanceof Long) {
                putLong(str, (Long) obj, bundle);
                return;
            } else if (obj instanceof Double) {
                putDouble(str, (Double) obj, bundle);
                return;
            } else if (obj instanceof Byte) {
                putByte(str, (Byte) obj, bundle);
                return;
            } else if (obj instanceof Character) {
                putChar(str, (Character) obj, bundle);
                return;
            } else if (obj instanceof Float) {
                putFloat(str, (Float) obj, bundle);
                return;
            } else if (obj instanceof Short) {
                putShort(str, (Short) obj, bundle);
                return;
            } else if (obj instanceof CharSequence) {
                putCharSequence(str, (CharSequence) obj, bundle);
                return;
            } else if (obj instanceof String[]) {
                putStringArray(str, (String[]) obj, bundle);
                return;
            } else if (obj instanceof boolean[]) {
                putBooleanArray(str, (boolean[]) obj, bundle);
                return;
            } else if (obj instanceof int[]) {
                putIntArray(str, (int[]) obj, bundle);
                return;
            } else if (obj instanceof long[]) {
                putLongArray(str, (long[]) obj, bundle);
                return;
            } else if (obj instanceof double[]) {
                putDoubleArray(str, (double[]) obj, bundle);
                return;
            } else if (obj instanceof byte[]) {
                putByteArray(str, (byte[]) obj, bundle);
                return;
            } else if (obj instanceof char[]) {
                putCharArray(str, (char[]) obj, bundle);
                return;
            } else if (obj instanceof float[]) {
                putFloatArray(str, (float[]) obj, bundle);
                return;
            } else if (obj instanceof short[]) {
                putShortArray(str, (short[]) obj, bundle);
                return;
            } else if (obj instanceof CharSequence[]) {
                putCharSequenceArray(str, (CharSequence[]) obj, bundle);
                return;
            } else {
                if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 0) {
                        if (arrayList.get(0) instanceof String) {
                            putStringArrayList(str, arrayList, bundle);
                            return;
                        } else if (arrayList.get(0) instanceof Integer) {
                            putIntegerArrayList(str, arrayList, bundle);
                            return;
                        } else if (arrayList.get(0) instanceof CharSequence) {
                            putCharSequenceArrayList(str, arrayList, bundle);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (v.a()) {
                    str2 = "Skipped insertion of " + obj + " into Bundle";
                } else {
                    return;
                }
            }
        } else if (v.a()) {
            str2 = "Skipped insertion into Bundle because value is null.";
        } else {
            return;
        }
        v.i("AppLovinSdk", str2);
    }

    public static void putBoolean(String str, Boolean bool, Bundle bundle) {
        if (bool != null) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public static void putBooleanArray(String str, boolean[] zArr, Bundle bundle) {
        if (zArr != null) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static void putByte(String str, Byte b2, Bundle bundle) {
        if (b2 != null) {
            bundle.putByte(str, b2.byteValue());
        }
    }

    public static void putByteArray(String str, byte[] bArr, Bundle bundle) {
        if (bArr != null) {
            bundle.putByteArray(str, bArr);
        }
    }

    public static void putChar(String str, Character ch, Bundle bundle) {
        if (ch != null) {
            bundle.putChar(str, ch.charValue());
        }
    }

    public static void putCharArray(String str, char[] cArr, Bundle bundle) {
        if (cArr != null) {
            bundle.putCharArray(str, cArr);
        }
    }

    public static void putCharSequence(String str, CharSequence charSequence, Bundle bundle) {
        if (charSequence != null) {
            bundle.putCharSequence(str, charSequence);
        }
    }

    public static void putCharSequenceArray(String str, CharSequence[] charSequenceArr, Bundle bundle) {
        if (charSequenceArr != null) {
            bundle.putCharSequenceArray(str, charSequenceArr);
        }
    }

    public static void putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putCharSequenceArrayList(str, arrayList);
        }
    }

    public static void putDouble(String str, Double d2, Bundle bundle) {
        if (d2 != null) {
            bundle.putDouble(str, d2.doubleValue());
        }
    }

    public static void putDoubleArray(String str, double[] dArr, Bundle bundle) {
        if (dArr != null) {
            bundle.putDoubleArray(str, dArr);
        }
    }

    public static void putFloat(String str, Float f2, Bundle bundle) {
        if (f2 != null) {
            bundle.putFloat(str, f2.floatValue());
        }
    }

    public static void putFloatArray(String str, float[] fArr, Bundle bundle) {
        if (fArr != null) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public static void putInt(String str, Integer num, Bundle bundle) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    public static void putIntArray(String str, int[] iArr, Bundle bundle) {
        if (iArr != null) {
            bundle.putIntArray(str, iArr);
        }
    }

    public static void putIntegerArrayList(String str, ArrayList<Integer> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putIntegerArrayList(str, arrayList);
        }
    }

    public static void putLong(String str, Long l2, Bundle bundle) {
        if (l2 != null) {
            bundle.putLong(str, l2.longValue());
        }
    }

    public static void putLongArray(String str, long[] jArr, Bundle bundle) {
        if (jArr != null) {
            bundle.putLongArray(str, jArr);
        }
    }

    public static void putShort(String str, Short sh, Bundle bundle) {
        if (sh != null) {
            bundle.putShort(str, sh.shortValue());
        }
    }

    public static void putShortArray(String str, short[] sArr, Bundle bundle) {
        if (sArr != null) {
            bundle.putShortArray(str, sArr);
        }
    }

    public static void putString(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    public static void putStringArray(String str, String[] strArr, Bundle bundle) {
        if (strArr != null) {
            bundle.putStringArray(str, strArr);
        }
    }

    public static void putStringArrayList(String str, ArrayList<String> arrayList, Bundle bundle) {
        if (arrayList != null) {
            bundle.putStringArrayList(str, arrayList);
        }
    }

    public static void putStringIfValid(String str, String str2, Bundle bundle) {
        if (AppLovinSdkUtils.isValidString(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static JSONObject toJSONObject(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null) {
                    if (obj instanceof Bundle) {
                        obj = toJSONObject((Bundle) obj);
                    } else if ((obj instanceof Collection) || (obj instanceof Parcelable[])) {
                        Collection asList = obj instanceof Collection ? (Collection) obj : Arrays.asList((Parcelable[]) obj);
                        JSONArray jSONArray = new JSONArray();
                        for (Object next2 : asList) {
                            if (next2 instanceof Bundle) {
                                next2 = toJSONObject((Bundle) next2);
                            }
                            jSONArray.put(next2);
                        }
                        jSONObject.put(next, jSONArray);
                    }
                    jSONObject.put(next, obj);
                }
            }
        } catch (JSONException e2) {
            if (v.a()) {
                v.c("AppLovinSdk", "Failed to convert Bundle to JSONObject", e2);
            }
        }
        return jSONObject;
    }

    public static Map<String, Object> toMap(Bundle bundle) {
        if (bundle == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    obj = toMap((Bundle) obj);
                } else {
                    boolean z2 = obj instanceof Collection;
                    if (z2 || (obj instanceof Parcelable[])) {
                        Collection asList = z2 ? (Collection) obj : Arrays.asList((Parcelable[]) obj);
                        ArrayList arrayList = new ArrayList();
                        for (Object next2 : asList) {
                            if (next2 instanceof Bundle) {
                                next2 = toMap((Bundle) next2);
                            }
                            arrayList.add(next2);
                        }
                        hashMap.put(next, arrayList);
                    }
                }
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public static Map<String, String> toStringMap(Bundle bundle) {
        if (bundle == null) {
            return new HashMap(0);
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            hashMap.put(next, String.valueOf(bundle.get(next)));
        }
        return hashMap;
    }
}
