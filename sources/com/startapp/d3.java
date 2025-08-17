package com.startapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class d3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34335a = "d3";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34336b = false;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[SYNTHETIC, Splitter:B:19:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] a(java.lang.String r5) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 10240(0x2800, float:1.4349E-41)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0036 }
            r3.<init>(r5)     // Catch:{ all -> 0x0036 }
        L_0x000f:
            int r5 = r3.read(r1)     // Catch:{ all -> 0x0034 }
            r4 = -1
            if (r5 == r4) goto L_0x001a
            r0.write(r1, r2, r5)     // Catch:{ all -> 0x0034 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0034 }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "UTF-8"
            r5.<init>(r0, r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = "\n"
            java.lang.String[] r5 = r5.split(r0)     // Catch:{ all -> 0x0034 }
            r3.close()     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            com.startapp.l2.b(r0)
        L_0x0033:
            return r5
        L_0x0034:
            r5 = move-exception
            goto L_0x0038
        L_0x0036:
            r5 = move-exception
            r3 = 0
        L_0x0038:
            com.startapp.l2.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0045
            r3.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r5 = move-exception
            com.startapp.l2.b(r5)
        L_0x0045:
            java.lang.String[] r5 = new java.lang.String[r2]
            return r5
        L_0x0048:
            r5 = move-exception
            if (r3 == 0) goto L_0x0053
            r3.close()     // Catch:{ all -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            com.startapp.l2.b(r0)
        L_0x0053:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.d3.a(java.lang.String):java.lang.String[]");
    }

    public static String[] b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Process exec = Runtime.getRuntime().exec(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            boolean z2 = true;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!z2) {
                    stringBuffer.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                }
                stringBuffer.append(readLine);
                z2 = false;
            }
            bufferedReader.close();
            exec.waitFor();
        } catch (Throwable th) {
            l2.a(th);
        }
        return stringBuffer.toString().split("\\n");
    }
}
