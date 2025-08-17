package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {

    /* renamed from: a  reason: collision with root package name */
    private static Field f503a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f504b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f505c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f506d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f507e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f508f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f509g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f510h;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    private ResourcesFlusher() {
    }

    static void a(Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 >= 24) {
                d(resources);
            } else if (i2 >= 23) {
                c(resources);
            } else {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f504b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f503a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f504b = true;
        }
        Field field = f503a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.content.res.Resources r4) {
        /*
            boolean r0 = f504b
            java.lang.String r1 = "ResourcesFlusher"
            if (r0 != 0) goto L_0x001d
            r0 = 1
            java.lang.Class<android.content.res.Resources> r2 = android.content.res.Resources.class
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0015 }
            f503a = r2     // Catch:{ NoSuchFieldException -> 0x0015 }
            r2.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            r2 = move-exception
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r1, r3, r2)
        L_0x001b:
            f504b = r0
        L_0x001d:
            java.lang.reflect.Field r0 = f503a
            if (r0 == 0) goto L_0x002c
            java.lang.Object r4 = r0.get(r4)     // Catch:{ IllegalAccessException -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
            java.lang.String r0 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r0, r4)
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 != 0) goto L_0x0030
            return
        L_0x0030:
            e(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.c(android.content.res.Resources):void");
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f510h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f509g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f510h = true;
        }
        Field field = f509g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f504b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f503a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f504b = true;
                }
                Field field2 = f503a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    e(obj2);
                }
            }
        }
    }

    private static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f506d) {
            try {
                f505c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f506d = true;
        }
        Class<?> cls = f505c;
        if (cls != null) {
            if (!f508f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f507e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f508f = true;
            }
            Field field = f507e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    Api16Impl.a(longSparseArray);
                }
            }
        }
    }
}
