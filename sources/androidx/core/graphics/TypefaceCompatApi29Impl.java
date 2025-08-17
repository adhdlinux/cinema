package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private Font k(FontFamily fontFamily, int i2) {
        int i3;
        int i4;
        if ((i2 & 1) != 0) {
            i3 = TypefaceStyle.BOLD;
        } else {
            i3 = 400;
        }
        if ((i2 & 2) != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        FontStyle fontStyle = new FontStyle(i3, i4);
        Font a2 = fontFamily.getFont(0);
        int l2 = l(fontStyle, a2.getStyle());
        for (int i5 = 1; i5 < fontFamily.getSize(); i5++) {
            Font a3 = fontFamily.getFont(i5);
            int l3 = l(fontStyle, a3.getStyle());
            if (l3 < l2) {
                a2 = a3;
                l2 = l3;
            }
        }
        return a2;
    }

    private static int l(FontStyle fontStyle, FontStyle fontStyle2) {
        int i2;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        return abs + i2;
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        int i3;
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
                try {
                    Font.Builder a2 = new Font.Builder(resources, fontFileResourceEntry.b()).setWeight(fontFileResourceEntry.e());
                    if (fontFileResourceEntry.f()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    Font a3 = a2.setSlant(i3).setTtcIndex(fontFileResourceEntry.c()).setFontVariationSettings(fontFileResourceEntry.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(a3);
                    } else {
                        FontFamily.Builder unused = builder.addFont(a3);
                    }
                } catch (IOException unused2) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily a4 = builder.build();
            return new Typeface.CustomFallbackBuilder(a4).setStyle(k(a4, i2).getStyle()).build();
        } catch (Exception unused3) {
            return null;
        }
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        int i3;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.d(), "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        Font.Builder a2 = new Font.Builder(openFileDescriptor).setWeight(fontInfo.e());
                        if (fontInfo.f()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        Font a3 = a2.setSlant(i3).setTtcIndex(fontInfo.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(a3);
                        } else {
                            FontFamily.Builder unused = builder.addFont(a3);
                        }
                    } else if (openFileDescriptor == null) {
                    }
                    openFileDescriptor.close();
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily a4 = builder.build();
            return new Typeface.CustomFallbackBuilder(a4).setStyle(k(a4, i2).getStyle()).build();
            throw th;
        } catch (Exception unused3) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font a2 = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(a2).build()).setStyle(a2.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo i(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
