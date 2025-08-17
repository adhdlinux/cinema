package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

public class TypefaceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final TypefaceCompatBaseImpl f2551a;

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, Typeface> f2552b = new LruCache<>(16);

    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        private ResourcesCompat.FontCallback f2553a;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.f2553a = fontCallback;
        }

        public void a(int i2) {
            ResourcesCompat.FontCallback fontCallback = this.f2553a;
            if (fontCallback != null) {
                fontCallback.f(i2);
            }
        }

        public void b(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f2553a;
            if (fontCallback != null) {
                fontCallback.g(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f2551a = new TypefaceCompatApi29Impl();
        } else if (i2 >= 28) {
            f2551a = new TypefaceCompatApi28Impl();
        } else if (i2 >= 26) {
            f2551a = new TypefaceCompatApi26Impl();
        } else if (i2 < 24 || !TypefaceCompatApi24Impl.m()) {
            f2551a = new TypefaceCompatApi21Impl();
        } else {
            f2551a = new TypefaceCompatApi24Impl();
        }
    }

    private TypefaceCompat() {
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return f2551a.c(context, cancellationSignal, fontInfoArr, i2);
    }

    public static Typeface c(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i2, String str, int i3, int i4, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z2) {
        Typeface typeface;
        boolean z3;
        int i5;
        FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry2 = familyResourceEntry;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (familyResourceEntry2 instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry2;
            Typeface g2 = g(providerResourceEntry.c());
            if (g2 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.d(g2, handler2);
                }
                return g2;
            }
            if (!z2 ? fontCallback2 != null : providerResourceEntry.a() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2) {
                i5 = providerResourceEntry.d();
            } else {
                i5 = -1;
            }
            Context context2 = context;
            typeface = FontsContractCompat.c(context2, providerResourceEntry.b(), i4, z3, i5, ResourcesCompat.FontCallback.e(handler), new ResourcesCallbackAdapter(fontCallback2));
            Resources resources2 = resources;
            int i6 = i4;
        } else {
            Context context3 = context;
            Resources resources3 = resources;
            typeface = f2551a.b(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry2, resources, i4);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.d(typeface, handler2);
                } else {
                    fontCallback2.c(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f2552b.put(e(resources, i2, str, i3, i4), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3, int i4) {
        Typeface e2 = f2551a.e(context, resources, i2, str, i4);
        if (e2 != null) {
            f2552b.put(e(resources, i2, str, i3, i4), e2);
        }
        return e2;
    }

    private static String e(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }

    public static Typeface f(Resources resources, int i2, String str, int i3, int i4) {
        return f2552b.get(e(resources, i2, str, i3, i4));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
