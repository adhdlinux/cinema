package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17005a;

    public ManifestParser(Context context) {
        this.f17005a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bumptech.glide.module.GlideModule b(java.lang.String r3) {
        /*
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            r0 = 0
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.reflect.Constructor r1 = r3.getDeclaredConstructor(r1)     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.Object r3 = r1.newInstance(r0)     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            goto L_0x0026
        L_0x0012:
            r0 = move-exception
            c(r3, r0)
            goto L_0x0025
        L_0x0017:
            r0 = move-exception
            c(r3, r0)
            goto L_0x0025
        L_0x001c:
            r0 = move-exception
            c(r3, r0)
            goto L_0x0025
        L_0x0021:
            r0 = move-exception
            c(r3, r0)
        L_0x0025:
            r3 = 0
        L_0x0026:
            boolean r0 = r3 instanceof com.bumptech.glide.module.GlideModule
            if (r0 == 0) goto L_0x002d
            com.bumptech.glide.module.GlideModule r3 = (com.bumptech.glide.module.GlideModule) r3
            return r3
        L_0x002d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected instanceof GlideModule, but found: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0044:
            r3 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unable to find GlideModule implementation"
            r0.<init>(r1, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.module.ManifestParser.b(java.lang.String):com.bumptech.glide.module.GlideModule");
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<GlideModule> a() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f17005a.getPackageManager().getApplicationInfo(this.f17005a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String next : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(next))) {
                    arrayList.add(b(next));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + next);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
