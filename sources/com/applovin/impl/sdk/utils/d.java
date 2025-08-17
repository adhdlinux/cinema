package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.os.Bundle;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f15788a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15789b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f15790c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15791d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15792e;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094 A[Catch:{ all -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private d(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "AndroidManifest"
            r9.<init>()
            r1 = 0
            android.content.pm.PackageManager r2 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001a }
            java.lang.String r3 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x001a }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x001a }
            android.os.Bundle r1 = r2.metaData     // Catch:{ NameNotFoundException -> 0x001a }
            goto L_0x0026
        L_0x0017:
            r10 = move-exception
            goto L_0x00a4
        L_0x001a:
            r2 = move-exception
            boolean r3 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = "Failed to get meta data."
            com.applovin.impl.sdk.v.c(r0, r3, r2)     // Catch:{ all -> 0x0017 }
        L_0x0026:
            r9.f15790c = r1
            r1 = 0
            android.content.res.AssetManager r10 = r10.getAssets()     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "AndroidManifest.xml"
            android.content.res.XmlResourceParser r10 = r10.openXmlResourceParser(r2)     // Catch:{ all -> 0x008c }
            int r2 = r10.getEventType()     // Catch:{ all -> 0x008c }
            r3 = 0
            r4 = 0
        L_0x0039:
            r5 = 2
            r6 = 1
            if (r5 != r2) goto L_0x0080
            java.lang.String r2 = r10.getName()     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = "application"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0080
            r2 = 0
        L_0x004a:
            int r5 = r10.getAttributeCount()     // Catch:{ all -> 0x0089 }
            if (r2 >= r5) goto L_0x0080
            java.lang.String r5 = r10.getAttributeName(r2)     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = r10.getAttributeValue(r2)     // Catch:{ all -> 0x0089 }
            java.lang.String r8 = "networkSecurityConfig"
            boolean r8 = r5.equals(r8)     // Catch:{ all -> 0x0089 }
            if (r8 == 0) goto L_0x006d
            java.lang.String r5 = r7.substring(r6)     // Catch:{ all -> 0x0089 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0089 }
            int r3 = r5.intValue()     // Catch:{ all -> 0x0089 }
            goto L_0x007d
        L_0x006d:
            java.lang.String r8 = "usesCleartextTraffic"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x007d
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0089 }
            boolean r4 = r5.booleanValue()     // Catch:{ all -> 0x0089 }
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x004a
        L_0x0080:
            int r2 = r10.next()     // Catch:{ all -> 0x0089 }
            if (r2 != r6) goto L_0x0039
            r9.f15791d = r3
            goto L_0x009b
        L_0x0089:
            r10 = move-exception
            r1 = r3
            goto L_0x008e
        L_0x008c:
            r10 = move-exception
            r4 = 0
        L_0x008e:
            boolean r2 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "Failed to parse AndroidManifest.xml."
            com.applovin.impl.sdk.v.c(r0, r2, r10)     // Catch:{ all -> 0x009e }
        L_0x0099:
            r9.f15791d = r1
        L_0x009b:
            r9.f15792e = r4
            return
        L_0x009e:
            r10 = move-exception
            r9.f15791d = r1
            r9.f15792e = r4
            throw r10
        L_0x00a4:
            r9.f15790c = r1
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.d.<init>(android.content.Context):void");
    }

    public static d a(Context context) {
        d dVar;
        synchronized (f15789b) {
            if (f15788a == null) {
                f15788a = new d(context);
            }
            dVar = f15788a;
        }
        return dVar;
    }

    public String a(String str, String str2) {
        Bundle bundle = this.f15790c;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean a() {
        return this.f15791d != 0;
    }

    public boolean a(String str) {
        Bundle bundle = this.f15790c;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public boolean a(String str, boolean z2) {
        Bundle bundle = this.f15790c;
        return bundle != null ? bundle.getBoolean(str, z2) : z2;
    }
}
