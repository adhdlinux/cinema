package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> f2570a = new ConcurrentHashMap<>();

    private interface StyleExtractor<T> {
        boolean a(T t2);

        int b(T t2);
    }

    TypefaceCompatBaseImpl() {
    }

    private void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long j2 = j(typeface);
        if (j2 != 0) {
            this.f2570a.put(Long.valueOf(j2), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry f(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i2) {
        return (FontResourcesParserCompat.FontFileResourceEntry) g(fontFamilyFilesResourceEntry.a(), i2, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            /* renamed from: c */
            public int b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            /* renamed from: d */
            public boolean a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    private static <T> T g(T[] tArr, int i2, StyleExtractor<T> styleExtractor) {
        return h(tArr, (i2 & 1) == 0 ? 400 : TypefaceStyle.BOLD, (i2 & 2) != 0, styleExtractor);
    }

    private static <T> T h(T[] tArr, int i2, boolean z2, StyleExtractor<T> styleExtractor) {
        int i3;
        T t2 = null;
        int i4 = Integer.MAX_VALUE;
        for (T t3 : tArr) {
            int abs = Math.abs(styleExtractor.b(t3) - i2) * 2;
            if (styleExtractor.a(t3) == z2) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i5 = abs + i3;
            if (t2 == null || i4 > i5) {
                t2 = t3;
                i4 = i5;
            }
        }
        return t2;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0;
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        FontResourcesParserCompat.FontFileResourceEntry f2 = f(fontFamilyFilesResourceEntry, i2);
        if (f2 == null) {
            return null;
        }
        Typeface d2 = TypefaceCompat.d(context, resources, f2.b(), f2.a(), 0, i2);
        a(d2, fontFamilyFilesResourceEntry);
        return d2;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(i(fontInfoArr, i2).d());
            try {
                Typeface d2 = d(context, inputStream);
                TypefaceCompatUtil.a(inputStream);
                return d2;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            TypefaceCompatUtil.a(inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e2 = TypefaceCompatUtil.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.d(e2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File e2 = TypefaceCompatUtil.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.c(e2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo i(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return (FontsContractCompat.FontInfo) g(fontInfoArr, i2, new StyleExtractor<FontsContractCompat.FontInfo>() {
            /* renamed from: c */
            public int b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.e();
            }

            /* renamed from: d */
            public boolean a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.f();
            }
        });
    }
}
