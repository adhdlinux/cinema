package com.facebook.ads.internal.q.a;

import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20697a = "z";

    public static boolean a(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            Log.v(f20697a, "Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = map.get("wfdkg");
        String str2 = map.get("wfswl");
        String str3 = map.get("kgr");
        return str != null && str.equals("1") && str2 != null && str2.equals("1") && str3 != null && str3.equals("true");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r4 = r4.get("kgr");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0041
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x0041
        L_0x000a:
            java.lang.String r1 = "wfdkg"
            java.lang.Object r1 = r4.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "wfswl"
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "1"
            if (r1 == 0) goto L_0x0024
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x002c
        L_0x0024:
            if (r2 == 0) goto L_0x002d
            boolean r1 = r2.equals(r3)
            if (r1 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            java.lang.String r1 = "kgr"
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0040
            java.lang.String r1 = "true"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0040
            r0 = 1
        L_0x0040:
            return r0
        L_0x0041:
            java.lang.String r4 = f20697a
            java.lang.String r1 = "Invalid Window info in window interactive check, assuming not obstructed by Keyguard."
            android.util.Log.v(r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.z.b(java.util.Map):boolean");
    }
}
