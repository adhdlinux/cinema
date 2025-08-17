package com.original.tase.utils;

import android.content.Context;
import android.util.Base64;
import com.original.tase.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f34061a = Pattern.compile("[-+]?\\d+");

    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            try {
                return new String(Base64.decode(str, 0));
            } catch (Exception e3) {
                Logger.d(e3, new boolean[0]);
                return "";
            }
        }
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String d(int i2) {
        StringBuilder sb = new StringBuilder(i2);
        SecureRandom secureRandom = new SecureRandom();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(secureRandom.nextInt(62)));
        }
        return sb.toString();
    }

    public static String e(String str) {
        return Regex.a(str, "[/|\\?|=| ](\\{.*\\})", 1);
    }

    public static HashMap<String, String> f(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str.toLowerCase());
            if (jSONObject.has("referer")) {
                hashMap.put("referer", jSONObject.getString("referer"));
            }
            if (jSONObject.has("origin")) {
                hashMap.put("origin", jSONObject.getString("origin"));
            }
            if (jSONObject.has("cookie")) {
                hashMap.put("cookie", jSONObject.getString("cookie"));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static String g(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(k((String) next.getValue(), new boolean[0]));
            sb.append("&");
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            return sb2;
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public static Map<String, String> h(String str) {
        String str2;
        String str3;
        String str4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str5 = "";
        if (str.contains("&")) {
            for (String str6 : str.split("&")) {
                int indexOf = str6.indexOf("=");
                if (indexOf != -1) {
                    try {
                        String decode = URLDecoder.decode(str6.substring(0, indexOf), "UTF-8");
                        int i2 = indexOf + 1;
                        if (str6.length() >= i2) {
                            str4 = URLDecoder.decode(str6.substring(i2), "UTF-8");
                        } else {
                            str4 = str5;
                        }
                        linkedHashMap.put(decode, str4);
                    } catch (UnsupportedEncodingException unused) {
                        String substring = str6.substring(0, indexOf);
                        int i3 = indexOf + 1;
                        if (str6.length() >= i3) {
                            str3 = str6.substring(i3);
                        } else {
                            str3 = str5;
                        }
                        linkedHashMap.put(substring, str3);
                    }
                }
            }
            return linkedHashMap;
        }
        int indexOf2 = str.indexOf("=");
        if (indexOf2 != -1) {
            try {
                str2 = URLDecoder.decode(str.substring(0, indexOf2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                str2 = null;
            }
            int i4 = indexOf2 + 1;
            if (str.length() >= i4) {
                try {
                    str5 = URLDecoder.decode(str.substring(i4), "UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
            linkedHashMap.put(str2, str5);
        }
        return linkedHashMap;
    }

    public static String i(int i2) {
        String valueOf = String.valueOf(i2);
        if (valueOf.length() != 1) {
            return valueOf;
        }
        return "0" + valueOf;
    }

    public static String j(String str, int i2) {
        return new DecimalFormat(str).format((long) i2);
    }

    public static String k(String str, boolean... zArr) {
        boolean z2;
        if (zArr == null || zArr.length <= 0 || !zArr[0]) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && (str.trim().toLowerCase().startsWith("http://") || str.trim().toLowerCase().startsWith("https://"))) {
            try {
                URL url = new URL(str);
                return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL().toString();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th2) {
            Logger.d(th2, new boolean[0]);
            return str.replace(":", "%3A").replace("/", "%2F").replace("#", "%23").replace("?", "%3F").replace("&", "%24").replace("@", "%40").replace("%", "%25").replace("+", "%2B").replace(" ", "+").replace(";", "%3B").replace("=", "%3D").replace("$", "%26").replace(",", "%2C").replace("<", "%3C").replace(">", "%3E").replace("~", "%25").replace("^", "%5E").replace("`", "%60").replace("\\", "%5C").replace("[", "%5B").replace("]", "%5D").replace("{", "%7B").replace("|", "%7C").replace("\"", "%22");
        }
    }

    public static <T> ArrayList<T> l(List<T> list) {
        return new ArrayList<>(new LinkedHashSet(list));
    }

    public static Map<String, String> m(URL url) {
        if (url.getQuery() == null) {
            return new HashMap();
        }
        return h(url.getQuery());
    }

    public static boolean n(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(String str) {
        return f34061a.matcher(str).matches();
    }

    public static String[] p(String[] strArr, String[] strArr2) {
        try {
            int length = strArr.length;
            int length2 = strArr2.length;
            String[] strArr3 = new String[(length + length2)];
            System.arraycopy(strArr, 0, strArr3, 0, length);
            System.arraycopy(strArr2, 0, strArr3, length, length2);
            return strArr3;
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return strArr;
        }
    }

    public static String q(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
