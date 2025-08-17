package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {
    private final AssetManager mAssetManager;
    private final String mFeatureSettings;
    private final String mFontFamily;
    private final int mStyle;
    private final int mWeight;

    public CustomStyleSpan(int i2, int i3, String str, String str2, AssetManager assetManager) {
        this.mStyle = i2;
        this.mWeight = i3;
        this.mFeatureSettings = str;
        this.mFontFamily = str2;
        this.mAssetManager = assetManager;
    }

    private static void apply(Paint paint, int i2, int i3, String str, String str2, AssetManager assetManager) {
        Typeface applyStyles = ReactTypefaceUtils.applyStyles(paint.getTypeface(), i2, i3, str2, assetManager);
        paint.setFontFeatureSettings(str);
        paint.setTypeface(applyStyles);
        paint.setSubpixelText(true);
    }

    public String getFontFamily() {
        return this.mFontFamily;
    }

    public String getFontFeatureSettings() {
        return this.mFeatureSettings;
    }

    public int getStyle() {
        int i2 = this.mStyle;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public int getWeight() {
        int i2 = this.mWeight;
        if (i2 == -1) {
            return 400;
        }
        return i2;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFeatureSettings, this.mFontFamily, this.mAssetManager);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFeatureSettings, this.mFontFamily, this.mAssetManager);
    }
}
