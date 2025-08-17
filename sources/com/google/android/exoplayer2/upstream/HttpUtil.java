package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28450a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f28451b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    private HttpUtil() {
    }

    public static String a(long j2, long j3) {
        if (j2 == 0 && j3 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j2);
        sb.append("-");
        if (j3 != -1) {
            sb.append((j2 + j3) - 1);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r1 = "]"
            java.lang.String r2 = "HttpUtil"
            if (r0 != 0) goto L_0x0026
            long r3 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x000f }
            goto L_0x0028
        L_0x000f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Unexpected Content-Length ["
            r0.append(r3)
            r0.append(r9)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.c(r2, r0)
        L_0x0026:
            r3 = -1
        L_0x0028:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x00a4
            java.util.regex.Pattern r0 = f28450a
            java.util.regex.Matcher r0 = r0.matcher(r10)
            boolean r5 = r0.matches()
            if (r5 == 0) goto L_0x00a4
            r5 = 2
            java.lang.String r5 = r0.group(r5)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.Object r5 = com.google.android.exoplayer2.util.Assertions.e(r5)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x008d }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x008d }
            r7 = 1
            java.lang.String r0 = r0.group(r7)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x008d }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x008d }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0064
            r3 = r5
            goto L_0x00a4
        L_0x0064:
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00a4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x008d }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r7 = "Inconsistent headers ["
            r0.append(r7)     // Catch:{ NumberFormatException -> 0x008d }
            r0.append(r9)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r9 = "] ["
            r0.append(r9)     // Catch:{ NumberFormatException -> 0x008d }
            r0.append(r10)     // Catch:{ NumberFormatException -> 0x008d }
            r0.append(r1)     // Catch:{ NumberFormatException -> 0x008d }
            java.lang.String r9 = r0.toString()     // Catch:{ NumberFormatException -> 0x008d }
            com.google.android.exoplayer2.util.Log.i(r2, r9)     // Catch:{ NumberFormatException -> 0x008d }
            long r9 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x008d }
            r3 = r9
            goto L_0x00a4
        L_0x008d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Unexpected Content-Range ["
            r9.append(r0)
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.google.android.exoplayer2.util.Log.c(r2, r9)
        L_0x00a4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpUtil.b(java.lang.String, java.lang.String):long");
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = f28451b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) Assertions.e(matcher.group(1)));
        }
        return -1;
    }
}
