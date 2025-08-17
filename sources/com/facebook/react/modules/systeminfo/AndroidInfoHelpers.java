package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.react.R;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    public static String getInspectorProxyHost(Context context) {
        return getServerIpAddress(getInspectorProxyPort(context).intValue());
    }

    private static Integer getInspectorProxyPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063 A[SYNTHETIC, Splitter:B:34:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0072 A[SYNTHETIC, Splitter:B:44:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0079 A[SYNTHETIC, Splitter:B:48:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String getMetroHostPropValue() {
        /*
            java.lang.Class<com.facebook.react.modules.systeminfo.AndroidInfoHelpers> r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.class
            monitor-enter(r0)
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0052, all -> 0x004d }
            java.lang.String r3 = "/system/bin/getprop"
            java.lang.String r4 = "metro.host"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0052, all -> 0x004d }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0052, all -> 0x004d }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0048, all -> 0x0043 }
            java.lang.String r1 = ""
        L_0x0030:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x0041 }
            if (r4 == 0) goto L_0x0038
            r1 = r4
            goto L_0x0030
        L_0x0038:
            metroHostPropValue = r1     // Catch:{ Exception -> 0x0041 }
            r3.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            r2.destroy()     // Catch:{ all -> 0x007d }
            goto L_0x006b
        L_0x0041:
            r1 = move-exception
            goto L_0x0056
        L_0x0043:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0070
        L_0x0048:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0056
        L_0x004d:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x0070
        L_0x0052:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L_0x0056:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.w((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = ""
            metroHostPropValue = r1     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0068
            r3.close()     // Catch:{ Exception -> 0x0067 }
            goto L_0x0068
        L_0x0067:
        L_0x0068:
            if (r2 == 0) goto L_0x006b
            goto L_0x003d
        L_0x006b:
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007d }
            monitor-exit(r0)
            return r1
        L_0x006f:
            r1 = move-exception
        L_0x0070:
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0077
        L_0x0076:
        L_0x0077:
            if (r2 == 0) goto L_0x007c
            r2.destroy()     // Catch:{ all -> 0x007d }
        L_0x007c:
            throw r1     // Catch:{ all -> 0x007d }
        L_0x007d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoHelpers.getMetroHostPropValue():java.lang.String");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    private static String getServerIpAddress(int i2) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = GENYMOTION_LOCALHOST;
            } else if (isRunningOnStockEmulator()) {
                metroHostPropValue2 = EMULATOR_LOCALHOST;
            } else {
                metroHostPropValue2 = DEVICE_LOCALHOST;
            }
        }
        return String.format(Locale.US, "%s:%d", new Object[]{metroHostPropValue2, Integer.valueOf(i2)});
    }

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }
}
