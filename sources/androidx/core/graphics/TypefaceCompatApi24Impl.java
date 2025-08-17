package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f2559b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f2560c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f2561d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f2562e;

    static {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method2 = null;
            constructor = null;
            method = null;
        }
        f2560c = constructor;
        f2559b = cls;
        f2561d = method;
        f2562e = method2;
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z2) {
        try {
            return ((Boolean) f2561d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z2)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2559b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2562e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f2561d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    private static Object n() {
        try {
            return f2560c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        Object n2 = n();
        if (n2 == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            ByteBuffer b2 = TypefaceCompatUtil.b(context, resources, fontFileResourceEntry.b());
            if (b2 == null || !k(n2, b2, fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                return null;
            }
        }
        return l(n2);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Object n2 = n();
        if (n2 == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri d2 = fontInfo.d();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(d2);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.f(context, cancellationSignal, d2);
                simpleArrayMap.put(d2, byteBuffer);
            }
            if (byteBuffer == null || !k(n2, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f())) {
                return null;
            }
        }
        Typeface l2 = l(n2);
        if (l2 == null) {
            return null;
        }
        return Typeface.create(l2, i2);
    }
}
