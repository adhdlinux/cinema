package com.facebook.ads.internal.q.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;
import org.json.JSONArray;

public class q {
    public static final String a(String str) {
        StringBuilder sb;
        String str2;
        if (str == null) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ", true);
        if (str.length() <= 90) {
            return str;
        }
        if (str.length() <= 93 && str.endsWith("...")) {
            return str;
        }
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int length = stringTokenizer.nextToken().length() + i2;
            if (length < 90) {
                i2 = length;
            }
        }
        if (i2 == 0) {
            str2 = str.substring(0, 90);
        } else {
            sb = new StringBuilder();
            str2 = str.substring(0, i2);
        }
        sb.append(str2);
        sb.append("...");
        return sb.toString();
    }

    public static final String a(Throwable th) {
        if (th == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static final String a(StackTraceElement[] stackTraceElementArr) {
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
