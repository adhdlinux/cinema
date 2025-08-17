package com.startapp;

import com.startapp.networkTest.enums.AnonymizationLevel;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class f3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34505a = "f3";

    public static String a(InetAddress inetAddress) {
        String hostAddress = inetAddress.getHostAddress();
        if (inetAddress instanceof Inet4Address) {
            return hostAddress.substring(0, hostAddress.lastIndexOf(46)) + ".xxx";
        }
        String str = "";
        if (!(inetAddress instanceof Inet6Address)) {
            return str;
        }
        String[] split = hostAddress.split(":");
        int length = split.length - 4;
        if (length < 0) {
            length = 0;
        }
        for (int i2 = 0; i2 < length; i2++) {
            str = str + split[i2] + ":";
        }
        return str + "x:x:x:x";
    }

    public static String b(String str) {
        if (str.length() != 32) {
            return str;
        }
        return str.substring(0, 7) + "-" + str.substring(7, 11) + "-" + str.substring(11, 15) + "-" + str.substring(15, 19) + "-" + str.substring(19, 31);
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static String d(String str) {
        if (str.length() <= 1 || !str.startsWith("\"") || !str.endsWith("\"")) {
            return str;
        }
        return str.substring(1, str.length() - 1);
    }

    public static String a(String str, AnonymizationLevel anonymizationLevel) {
        if (str == null) {
            str = "";
        }
        int ordinal = anonymizationLevel.ordinal();
        if (ordinal == 0) {
            return str;
        }
        if (ordinal != 1) {
            return "";
        }
        if (str.length() <= 3) {
            return "***";
        }
        return str.substring(0, str.length() - 3) + "***";
    }

    public static String a(String str) {
        return str == null ? "" : str.replaceAll("[\u0000-\u001f]", "").trim();
    }

    public static String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        int i2 = 0;
        for (String length : list) {
            i2 += length.length();
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (String append : list) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public static String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null && str.length() > 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String a(InputStream inputStream, String str) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            l2.a(th);
            return null;
        }
    }
}
