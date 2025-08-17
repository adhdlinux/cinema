package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f2554b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f2555c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2556d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2557e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2558f = false;

    TypefaceCompatApi21Impl() {
    }

    private static boolean k(Object obj, String str, int i2, boolean z2) {
        n();
        try {
            return ((Boolean) f2556d.invoke(obj, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z2)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface l(Object obj) {
        n();
        try {
            Object newInstance = Array.newInstance(f2554b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2557e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2;
        if (!f2558f) {
            f2558f = true;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
                cls = null;
                method2 = null;
                constructor = null;
                method = null;
            }
            f2555c = constructor;
            f2554b = cls;
            f2556d = method;
            f2557e = method2;
        }
    }

    private static Object o() {
        n();
        try {
            return f2555c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        Object o2 = o();
        FontResourcesParserCompat.FontFileResourceEntry[] a2 = fontFamilyFilesResourceEntry.a();
        int length = a2.length;
        int i3 = 0;
        while (i3 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = a2[i3];
            File e2 = TypefaceCompatUtil.e(context);
            if (e2 == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.c(e2, resources, fontFileResourceEntry.b())) {
                    e2.delete();
                    return null;
                } else if (!k(o2, e2.getPath(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                    return null;
                } else {
                    e2.delete();
                    i3++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e2.delete();
            }
        }
        return l(o2);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        FileInputStream fileInputStream;
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo i3 = i(fontInfoArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(i3.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File m2 = m(openFileDescriptor);
                if (m2 != null) {
                    if (m2.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(m2);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface d2 = super.d(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return d2;
            } catch (Throwable th) {
                openFileDescriptor.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
