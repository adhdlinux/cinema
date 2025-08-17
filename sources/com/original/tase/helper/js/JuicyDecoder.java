package com.original.tase.helper.js;

import android.util.Base64;
import com.original.tase.Logger;
import com.original.tase.utils.Regex;

public class JuicyDecoder {
    public static String m30921(String str) {
        String replaceAll = Regex.b(str, "JuicyCodes\\.Run\\(([^\\)]+)", 1, 34).replaceAll("\"\\s*\\+\\s*\"", "").replaceAll("[^A-Za-z0-9+\\\\/=]", "");
        if (replaceAll.isEmpty()) {
            return "";
        }
        try {
            return new String(Base64.decode(replaceAll, 0), "UTF-8");
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m30922(java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            com.squareup.duktape.Duktape r1 = com.squareup.duktape.Duktape.create()     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "var JuicyCodes = {\n    \"Juice\": 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',\n    \"Run\": function(e) {\n        var t = '',\n            n,\n            r,\n            i,\n            s,\n            o,\n            u,\n            a,\n            f = 0;\n        for (e = e['replace'](new RegExp('[^A-Za-z0-9+\\\\/=]', 'g'), ''); f < e['length'];) s = this['Juice']['indexOf'](e['charAt'](f++)),\n            o = this['Juice']['indexOf'](e['charAt'](f++)),\n            u = this['Juice']['indexOf'](e['charAt'](f++)),\n            a = this['Juice']['indexOf'](e['charAt'](f++)),\n            n = s << 2 | o >> 4,\n            r = (15 & o) << 4 | u >> 2,\n            i = (3 & u) << 6 | a,\n            t += String['fromCharCode'](n),\n            64 != u && (t += String['fromCharCode'](r)),\n            64 != a && (t += String['fromCharCode'](i));\n        return t = JuicyCodes['utf8'](t); //,\n        //eval(t)\n    },\n    \"utf8\": function(a) {\n        for (var b = '', c = 0, d = c1 = c2 = 0; c < a['length'];) d = a['charCodeAt'](c),\n            d < 128 ? (b += String['fromCharCode'](d), c++) : d > 191 && d < 224 ? (c2 = a['charCodeAt'](c + 1), b += String['fromCharCode']((31 & d) << 6 | 63 & c2), c += 2) : (c2 = a['charCodeAt'](c + 1), c3 = a['charCodeAt'](c + 2), b += String['fromCharCode']((15 & d) << 12 | (63 & c2) << 6 | 63 & c3), c += 3);\n        return b\n    }\n};\n\nvar x = {jsCode};\n\nDuktape.enc(\"base64\", x);"
            java.lang.String r3 = "{jsCode}"
            java.lang.String r5 = r2.replace(r3, r5)     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = r1.evaluate(r5)     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x0019
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0020 }
            goto L_0x001a
        L_0x0019:
            r5 = r0
        L_0x001a:
            r1.close()     // Catch:{ all -> 0x001e }
            goto L_0x0029
        L_0x001e:
            goto L_0x0024
        L_0x0020:
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            r5 = r0
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            r1 = 0
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0036 }
            byte[] r3 = android.util.Base64.decode(r5, r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0036 }
            return r2
        L_0x0036:
            r2 = move-exception
            boolean[] r3 = new boolean[r1]
            com.original.tase.Logger.d(r2, r3)
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0046 }
            byte[] r5 = android.util.Base64.decode(r5, r1)     // Catch:{ all -> 0x0046 }
            r2.<init>(r5)     // Catch:{ all -> 0x0046 }
            return r2
        L_0x0046:
            r5 = move-exception
            boolean[] r1 = new boolean[r1]
            com.original.tase.Logger.d(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.js.JuicyDecoder.m30922(java.lang.String):java.lang.String");
    }

    public static String m30923(String str) {
        String replaceAll = Regex.b(str, "JuicyCodes\\.Run\\(([^\\)]+)", 1, 34).replaceAll("\"\\s*\\+\\s*\"", "").replaceAll("[^A-Za-z0-9+\\\\/=]", "");
        if (replaceAll.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < replaceAll.length()) {
            try {
                int indexOf = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(replaceAll.charAt(i2));
                int i3 = i2 + 1;
                int indexOf2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(replaceAll.charAt(i3));
                int i4 = i3 + 1;
                int indexOf3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(replaceAll.charAt(i4));
                int i5 = i4 + 1;
                int indexOf4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(replaceAll.charAt(i5));
                i2 = i5 + 1;
                int i6 = (indexOf << 2) | (indexOf2 >> 4);
                int i7 = ((indexOf2 & 15) << 4) | (indexOf3 >> 2);
                int i8 = ((indexOf3 & 3) << 6) | indexOf4;
                sb.append(Character.toString((char) i6));
                if (64 != indexOf3) {
                    sb.append(Character.toString((char) i7));
                }
                if (64 != indexOf4) {
                    sb.append(Character.toString((char) i8));
                }
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
        }
        return sb.toString();
    }

    public static String m30924(String str) {
        if (!str.trim().toLowerCase().contains("juicycodes")) {
            return "";
        }
        String m30921 = m30921(str);
        if (m30921.isEmpty()) {
            m30921 = m30923(str);
        }
        if (m30921.isEmpty()) {
            return m30922(str);
        }
        return m30921;
    }
}
