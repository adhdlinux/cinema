package com.applovin.impl.sdk.utils;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f15780a = "0123456789abcdef".toCharArray();

    private static String a(String str, Integer num) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            String hexString = toHexString(instance.digest());
            return num.intValue() > 0 ? hexString.substring(0, Math.min(num.intValue(), hexString.length())) : hexString;
        } catch (Throwable th) {
            throw new RuntimeException("SHA-1 for \"" + str + "\" failed.", th);
        }
    }

    public static String appendQueryParameter(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(str2, str3);
        return buildUpon.build().toString();
    }

    public static String appendQueryParameters(String str, Map<String, String> map, boolean z2) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        if (z2) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() {
                /* renamed from: a */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }

    public static boolean containsIgnoreCase(String str, String str2) {
        return isValidString(str) && isValidString(str2) && str.toLowerCase().contains(str2.toLowerCase());
    }

    public static SpannedString createListItemDetailSpannedString(String str, int i2) {
        return createSpannedString(str, i2, 16);
    }

    public static SpannedString createListItemDetailSubSpannedString(String str, int i2) {
        return createSpannedString(str, i2, 12, 1);
    }

    public static SpannedString createSpannedString(String str, int i2, int i3) {
        return createSpannedString(str, i2, i3, 0);
    }

    public static SpannedString createSpannedString(String str, int i2, int i3, int i4) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i3, true), 0, spannableString.length(), 33);
        spannableString.setSpan(new StyleSpan(i4), 0, spannableString.length(), 33);
        return new SpannedString(spannableString);
    }

    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String encodeUriString(String str, m mVar) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (((Boolean) mVar.a(b.eO)).booleanValue()) {
            return Uri.encode(str);
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public static Boolean endsWith(String str, List<String> list) {
        for (String endsWith : list) {
            if (str.endsWith(endsWith)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static String getHostAndPath(String str) {
        Uri parse = Uri.parse(str);
        return parse.getHost() + parse.getPath();
    }

    public static boolean isAlphaNumeric(String str) {
        if (isValidString(str)) {
            return str.matches("^[a-zA-Z0-9]*$");
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i2 = (charAt == '-' || charAt == '+') ? 1 : 0;
        int length = str.length();
        if (i2 == 1 && length == 1) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    public static int parseInt(String str, int i2) {
        return isNumeric(str) ? Integer.parseInt(str) : i2;
    }

    public static String prefixToIndex(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        return str.substring(0, i2);
    }

    public static String replace(String str, String str2, String str3) {
        if (str3 == null) {
            throw new IllegalArgumentException("No replacement target specified");
        } else if (str == null || str.length() < 1 || str2 == null || str2.length() < 1) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder(str);
            int indexOf = sb.indexOf(str2);
            while (indexOf != -1) {
                sb.replace(indexOf, str2.length() + indexOf, str3);
                indexOf = sb.indexOf(str2, indexOf + str3.length());
            }
            return sb.toString();
        }
    }

    public static String replace(String str, Map<String, String> map) {
        if (!(str == null || map == null)) {
            for (Map.Entry next : map.entrySet()) {
                str = str.replace((CharSequence) next.getKey(), (CharSequence) next.getValue());
            }
        }
        return str;
    }

    public static String toDigitsOnlyVersionString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\.");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (isValidString(str2)) {
                String[] split2 = str2.split("[^0-9]+");
                if (split2.length > 0) {
                    arrayList.add(split2[0]);
                }
            }
        }
        return TextUtils.join(".", arrayList);
    }

    public static String toFullSHA1Hash(String str) {
        return a(str, -1);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr != null) {
            char[] cArr = new char[(bArr.length * 2)];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i2 * 2;
                char[] cArr2 = f15780a;
                byte b2 = bArr[i2];
                cArr[i3] = cArr2[(b2 & 240) >>> 4];
                cArr[i3 + 1] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        throw new IllegalArgumentException("No data specified");
    }

    public static String toHumanReadableString(String str) {
        String str2;
        if (!isValidString(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (String str3 : str.split("_")) {
            if (isValidString(str3)) {
                if (str3.equals("id")) {
                    str2 = str3.toUpperCase(Locale.ENGLISH);
                } else {
                    String substring = str3.substring(0, 1);
                    Locale locale = Locale.ENGLISH;
                    sb.append(substring.toUpperCase(locale));
                    str2 = str3.substring(1).toLowerCase(locale);
                }
                sb.append(str2);
                sb.append(" ");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String toShortSHA1Hash(String str) {
        return a(str, 16);
    }
}
