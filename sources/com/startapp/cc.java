package com.startapp;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class cc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34303a;

    public cc(Context context) {
        this.f34303a = context;
    }

    public boolean a(String str) {
        boolean z2 = false;
        for (String file : dc.f34371c) {
            if (new File(file, str).exists()) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean b() {
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("mount").getInputStream()).useDelimiter("\\A").next().split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        } catch (IOException | NoSuchElementException e2) {
            e2.printStackTrace();
        }
        boolean z2 = false;
        for (String split : strArr) {
            String[] split2 = split.split(" ");
            if (split2.length >= 4) {
                String str = split2[1];
                String str2 = split2[3];
                for (String equalsIgnoreCase : dc.f34372d) {
                    if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                        String[] split3 = str2.split(",");
                        int length = split3.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (split3[i2].equalsIgnoreCase("rw")) {
                                z2 = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "which"
            java.lang.String r3 = "su"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x002c }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x002c }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002a }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x002a }
            r3.<init>(r4)     // Catch:{ all -> 0x002a }
            r2.<init>(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0026
            r0 = 1
        L_0x0026:
            r1.destroy()
            return r0
        L_0x002a:
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.destroy()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.cc.c():boolean");
    }

    public final boolean a(List<String> list) {
        PackageManager packageManager = this.f34303a.getPackageManager();
        boolean z2 = false;
        for (String packageInfo : list) {
            try {
                packageManager.getPackageInfo(packageInfo, 0);
                z2 = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z2;
    }

    public boolean a() {
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("getprop").getInputStream()).useDelimiter("\\A").next().split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        } catch (IOException | NoSuchElementException e2) {
            e2.printStackTrace();
        }
        boolean z2 = false;
        for (String str : strArr) {
            for (String str2 : hashMap.keySet()) {
                if (str.contains(str2)) {
                    if (str.contains("[" + ((String) hashMap.get(str2)) + "]")) {
                        z2 = true;
                    }
                }
            }
        }
        return z2;
    }
}
