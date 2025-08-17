package com.unity3d.services.core.misc;

import android.os.Handler;
import android.os.Looper;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import org.json.JSONException;
import org.json.JSONObject;

public class Utilities {
    public static String Sha256(String str) {
        return Sha256(str.getBytes());
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject, String str) {
        HashMap hashMap = new HashMap(map);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(str + next, jSONObject.opt(next));
        }
        return hashMap;
    }

    public static Map<String, Object> convertJsonToMap(JSONObject jSONObject) {
        return combineJsonIntoMap(new HashMap(), jSONObject);
    }

    public static <T> T getService(String str, Class cls) {
        return ServiceProvider.INSTANCE.getRegistry().getService(str, JvmClassMappingKt.c(cls));
    }

    public static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject3.put(next, jSONObject2.get(next));
        }
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!jSONObject3.has(next2) || !(jSONObject3.get(next2) instanceof JSONObject) || !(jSONObject.get(next2) instanceof JSONObject)) {
                jSONObject3.put(next2, jSONObject.get(next2));
            } else {
                jSONObject3.put(next2, mergeJsonObjects(jSONObject.getJSONObject(next2), jSONObject3.getJSONObject(next2)));
            }
        }
        return jSONObject3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileBytes(java.io.File r4) throws java.io.IOException {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0054
            boolean r1 = r4.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x0054
        L_0x000a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0019
            java.nio.file.Path r4 = r4.toPath()
            byte[] r4 = java.nio.file.Files.readAllBytes(r4)
            return r4
        L_0x0019:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x004d }
            r1.<init>(r4)     // Catch:{ all -> 0x004d }
            long r2 = r4.length()     // Catch:{ all -> 0x004a }
            int r0 = (int) r2     // Catch:{ all -> 0x004a }
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x004a }
            int r3 = r1.read(r2)     // Catch:{ all -> 0x004a }
            if (r3 != r0) goto L_0x002f
            r1.close()
            return r2
        L_0x002f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x004a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r2.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "Failed to read all bytes from input file path: "
            r2.append(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r4.getPath()     // Catch:{ all -> 0x004a }
            r2.append(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x004a }
            r0.<init>(r4)     // Catch:{ all -> 0x004a }
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r4 = move-exception
            r0 = r1
            goto L_0x004e
        L_0x004d:
            r4 = move-exception
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.close()
        L_0x0053:
            throw r4
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.Utilities.readFileBytes(java.io.File):byte[]");
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 <= 15) {
                str = str + "0";
            }
            str = str + Integer.toHexString(b3);
        }
        return str;
    }

    public static void wrapCustomerListener(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e2) {
            DeviceLog.error("An uncaught exception has occurred in the client application.  Exception: %s", e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[SYNTHETIC, Splitter:B:23:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055 A[SYNTHETIC, Splitter:B:31:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeFile(java.io.File r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "Error closing FileOutputStream"
            r1 = 0
            if (r4 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0028 }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r3.write(r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r3.flush()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r3.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L_0x001e:
            r1 = 1
            goto L_0x0038
        L_0x0020:
            r4 = move-exception
            r2 = r3
            goto L_0x0053
        L_0x0023:
            r5 = move-exception
            r2 = r3
            goto L_0x0029
        L_0x0026:
            r4 = move-exception
            goto L_0x0053
        L_0x0028:
            r5 = move-exception
        L_0x0029:
            java.lang.String r3 = "Could not write file"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r5)     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0038
            r2.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L_0x0038:
            if (r1 == 0) goto L_0x0052
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Wrote file: "
            r5.append(r0)
            java.lang.String r4 = r4.getAbsolutePath()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r4)
        L_0x0052:
            return r1
        L_0x0053:
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L_0x005d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.Utilities.writeFile(java.io.File, java.lang.String):boolean");
    }

    public static String Sha256(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr, 0, bArr.length);
            return toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            DeviceLog.exception("SHA-256 algorithm not found", e2);
            return null;
        }
    }

    public static <T> T getService(Class cls) {
        return getService("", cls);
    }

    public static void runOnUiThread(Runnable runnable, long j2) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j2 > 0) {
            handler.postDelayed(runnable, j2);
        } else {
            handler.post(runnable);
        }
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject) {
        return combineJsonIntoMap(map, jSONObject, "");
    }

    public static String Sha256(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return toHexString(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e2) {
            DeviceLog.exception("SHA-256 algorithm not found", e2);
            return null;
        }
    }
}
