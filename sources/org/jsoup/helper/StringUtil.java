package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f41534a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f41535b = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder(8192);
        }
    };

    public static void a(StringBuilder sb, String str, boolean z2) {
        int length = str.length();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (!d(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z3 = true;
                z4 = false;
            } else if ((!z2 || z3) && !z4) {
                sb.append(' ');
                z4 = true;
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean b(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean d(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 160;
    }

    public static boolean e(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!g(str.codePointAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean f(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.codePointAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13;
    }

    public static String h(Collection collection, String str) {
        return i(collection.iterator(), str);
    }

    public static String i(Iterator it2, String str) {
        if (!it2.hasNext()) {
            return "";
        }
        String obj = it2.next().toString();
        if (!it2.hasNext()) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(obj);
        while (it2.hasNext()) {
            sb.append(str);
            sb.append(it2.next());
        }
        return sb.toString();
    }

    public static String j(int i2) {
        if (i2 >= 0) {
            String[] strArr = f41534a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = ' ';
            }
            return String.valueOf(cArr);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String k(String str, String str2) {
        try {
            try {
                return l(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            return new URL(str2).toExternalForm();
        }
    }

    public static URL l(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + url.getFile());
        }
        return new URL(url, str);
    }

    public static StringBuilder m() {
        ThreadLocal<StringBuilder> threadLocal = f41535b;
        StringBuilder sb = threadLocal.get();
        if (sb.length() > 8192) {
            StringBuilder sb2 = new StringBuilder(8192);
            threadLocal.set(sb2);
            return sb2;
        }
        sb.delete(0, sb.length());
        return sb;
    }
}
