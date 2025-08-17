package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.infer.annotation.Nullsafe;
import java.util.HashMap;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ReactFontManager {
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "fonts/";
    private static ReactFontManager sReactFontManagerInstance;
    private final Map<String, Typeface> mCustomTypefaceCache = new HashMap();
    private final Map<String, AssetFontFamily> mFontCache = new HashMap();

    private static class AssetFontFamily {
        private SparseArray<Typeface> mTypefaceSparseArray;

        public Typeface getTypefaceForStyle(int i2) {
            return this.mTypefaceSparseArray.get(i2);
        }

        public void setTypefaceForStyle(int i2, Typeface typeface) {
            this.mTypefaceSparseArray.put(i2, typeface);
        }

        private AssetFontFamily() {
            this.mTypefaceSparseArray = new SparseArray<>(4);
        }
    }

    private ReactFontManager() {
    }

    private static Typeface createAssetTypeface(String str, int i2, AssetManager assetManager) {
        String str2 = EXTENSIONS[i2];
        String[] strArr = FILE_EXTENSIONS;
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            String str3 = strArr[i3];
            try {
                return Typeface.createFromAsset(assetManager, FONTS_ASSET_PATH + str + str2 + str3);
            } catch (RuntimeException unused) {
                i3++;
            }
        }
        return Typeface.create(str, i2);
    }

    public static ReactFontManager getInstance() {
        if (sReactFontManagerInstance == null) {
            sReactFontManagerInstance = new ReactFontManager();
        }
        return sReactFontManagerInstance;
    }

    public void addCustomFont(Context context, String str, int i2) {
        Typeface g2 = ResourcesCompat.g(context, i2);
        if (g2 != null) {
            this.mCustomTypefaceCache.put(str, g2);
        }
    }

    public Typeface getTypeface(String str, int i2, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i2), assetManager);
    }

    public void setTypeface(String str, int i2, Typeface typeface) {
        if (typeface != null) {
            AssetFontFamily assetFontFamily = this.mFontCache.get(str);
            if (assetFontFamily == null) {
                assetFontFamily = new AssetFontFamily();
                this.mFontCache.put(str, assetFontFamily);
            }
            assetFontFamily.setTypefaceForStyle(i2, typeface);
        }
    }

    public Typeface getTypeface(String str, int i2, boolean z2, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i2, z2), assetManager);
    }

    public Typeface getTypeface(String str, int i2, int i3, AssetManager assetManager) {
        return getTypeface(str, new TypefaceStyle(i2, i3), assetManager);
    }

    public Typeface getTypeface(String str, TypefaceStyle typefaceStyle, AssetManager assetManager) {
        if (this.mCustomTypefaceCache.containsKey(str)) {
            return typefaceStyle.apply(this.mCustomTypefaceCache.get(str));
        }
        AssetFontFamily assetFontFamily = this.mFontCache.get(str);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            this.mFontCache.put(str, assetFontFamily);
        }
        int nearestStyle = typefaceStyle.getNearestStyle();
        Typeface typefaceForStyle = assetFontFamily.getTypefaceForStyle(nearestStyle);
        if (typefaceForStyle != null) {
            return typefaceForStyle;
        }
        Typeface createAssetTypeface = createAssetTypeface(str, nearestStyle, assetManager);
        assetFontFamily.setTypefaceForStyle(nearestStyle, createAssetTypeface);
        return createAssetTypeface;
    }
}
