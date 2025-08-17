package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f2563g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f2564h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f2565i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f2566j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f2567k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f2568l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f2569m;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = y();
            constructor = z(cls);
            method5 = v(cls);
            method4 = w(cls);
            method3 = A(cls);
            method2 = u(cls);
            method = x(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            cls = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f2563g = cls;
        this.f2564h = constructor;
        this.f2565i = method5;
        this.f2566j = method4;
        this.f2567k = method3;
        this.f2568l = method2;
        this.f2569m = method;
    }

    private Object o() {
        try {
            return this.f2564h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f2568l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2565i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f2566j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f2567k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f2565i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.f2565i != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        if (!t()) {
            return super.b(context, fontFamilyFilesResourceEntry, resources, i2);
        }
        Object o2 = o();
        if (o2 == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            if (!q(context, o2, fontFileResourceEntry.a(), fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.d()))) {
                p(o2);
                return null;
            }
        }
        if (!s(o2)) {
            return null;
        }
        return l(o2);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Typeface l2;
        ParcelFileDescriptor openFileDescriptor;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!t()) {
            FontsContractCompat.FontInfo i3 = i(fontInfoArr, i2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(i3.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface a2 = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(i3.e()).setItalic(i3.f()).build();
                openFileDescriptor.close();
                return a2;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> h2 = TypefaceCompatUtil.h(context, fontInfoArr, cancellationSignal);
            Object o2 = o();
            if (o2 == null) {
                return null;
            }
            boolean z2 = false;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = h2.get(fontInfo.d());
                if (byteBuffer != null) {
                    if (!r(o2, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f() ? 1 : 0)) {
                        p(o2);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                p(o2);
                return null;
            } else if (s(o2) && (l2 = l(o2)) != null) {
                return Typeface.create(l2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        if (!t()) {
            return super.e(context, resources, i2, str, i3);
        }
        Object o2 = o();
        if (o2 == null) {
            return null;
        }
        if (!q(context, o2, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            p(o2);
            return null;
        } else if (!s(o2)) {
            return null;
        } else {
            return l(o2);
        }
    }

    /* access modifiers changed from: protected */
    public Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2563g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2569m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method v(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method w(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* access modifiers changed from: protected */
    public Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
