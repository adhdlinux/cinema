package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.util.List;

public class ReflectionAccessFilterHelper {

    private static abstract class AccessChecker {

        /* renamed from: a  reason: collision with root package name */
        public static final AccessChecker f30981a;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.internal.JavaVersion.c()
                if (r0 == 0) goto L_0x001c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 0
                r2[r4] = r3     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1     // Catch:{ NoSuchMethodException -> 0x001c }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x001c }
                goto L_0x001d
            L_0x001c:
                r1 = 0
            L_0x001d:
                if (r1 != 0) goto L_0x0024
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2
                r1.<init>()
            L_0x0024:
                f30981a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.<clinit>():void");
        }

        private AccessChecker() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    private ReflectionAccessFilterHelper() {
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return AccessChecker.f30981a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult b(List<ReflectionAccessFilter> list, Class<?> cls) {
        for (ReflectionAccessFilter a2 : list) {
            ReflectionAccessFilter.FilterResult a3 = a2.a(cls);
            if (a3 != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return a3;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
