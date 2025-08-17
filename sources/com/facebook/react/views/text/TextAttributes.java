package com.facebook.react.views.text;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;

public class TextAttributes {
    public static final float DEFAULT_MAX_FONT_SIZE_MULTIPLIER = 0.0f;
    private boolean mAllowFontScaling = true;
    private float mFontSize = Float.NaN;
    private float mHeightOfTallestInlineViewOrImage = Float.NaN;
    private float mLetterSpacing = Float.NaN;
    private float mLineHeight = Float.NaN;
    private float mMaxFontSizeMultiplier = Float.NaN;
    private TextTransform mTextTransform = TextTransform.UNSET;

    public TextAttributes applyChild(TextAttributes textAttributes) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        TextAttributes textAttributes2 = new TextAttributes();
        textAttributes2.mAllowFontScaling = this.mAllowFontScaling;
        if (!Float.isNaN(textAttributes.mFontSize)) {
            f2 = textAttributes.mFontSize;
        } else {
            f2 = this.mFontSize;
        }
        textAttributes2.mFontSize = f2;
        if (!Float.isNaN(textAttributes.mLineHeight)) {
            f3 = textAttributes.mLineHeight;
        } else {
            f3 = this.mLineHeight;
        }
        textAttributes2.mLineHeight = f3;
        if (!Float.isNaN(textAttributes.mLetterSpacing)) {
            f4 = textAttributes.mLetterSpacing;
        } else {
            f4 = this.mLetterSpacing;
        }
        textAttributes2.mLetterSpacing = f4;
        if (!Float.isNaN(textAttributes.mMaxFontSizeMultiplier)) {
            f5 = textAttributes.mMaxFontSizeMultiplier;
        } else {
            f5 = this.mMaxFontSizeMultiplier;
        }
        textAttributes2.mMaxFontSizeMultiplier = f5;
        if (!Float.isNaN(textAttributes.mHeightOfTallestInlineViewOrImage)) {
            f6 = textAttributes.mHeightOfTallestInlineViewOrImage;
        } else {
            f6 = this.mHeightOfTallestInlineViewOrImage;
        }
        textAttributes2.mHeightOfTallestInlineViewOrImage = f6;
        TextTransform textTransform = textAttributes.mTextTransform;
        if (textTransform == TextTransform.UNSET) {
            textTransform = this.mTextTransform;
        }
        textAttributes2.mTextTransform = textTransform;
        return textAttributes2;
    }

    public boolean getAllowFontScaling() {
        return this.mAllowFontScaling;
    }

    public int getEffectiveFontSize() {
        float f2;
        double d2;
        if (!Float.isNaN(this.mFontSize)) {
            f2 = this.mFontSize;
        } else {
            f2 = 14.0f;
        }
        if (this.mAllowFontScaling) {
            d2 = Math.ceil((double) PixelUtil.toPixelFromSP(f2, getEffectiveMaxFontSizeMultiplier()));
        } else {
            d2 = Math.ceil((double) PixelUtil.toPixelFromDIP(f2));
        }
        return (int) d2;
    }

    public float getEffectiveLetterSpacing() {
        float f2;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLetterSpacing);
        }
        return f2 / ((float) getEffectiveFontSize());
    }

    public float getEffectiveLineHeight() {
        float f2;
        boolean z2;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLineHeight);
        }
        if (Float.isNaN(this.mHeightOfTallestInlineViewOrImage) || this.mHeightOfTallestInlineViewOrImage <= f2) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return this.mHeightOfTallestInlineViewOrImage;
        }
        return f2;
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        if (!Float.isNaN(this.mMaxFontSizeMultiplier)) {
            return this.mMaxFontSizeMultiplier;
        }
        return 0.0f;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public float getHeightOfTallestInlineViewOrImage() {
        return this.mHeightOfTallestInlineViewOrImage;
    }

    public float getLetterSpacing() {
        return this.mLetterSpacing;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public float getMaxFontSizeMultiplier() {
        return this.mMaxFontSizeMultiplier;
    }

    public TextTransform getTextTransform() {
        return this.mTextTransform;
    }

    public void setAllowFontScaling(boolean z2) {
        this.mAllowFontScaling = z2;
    }

    public void setFontSize(float f2) {
        this.mFontSize = f2;
    }

    public void setHeightOfTallestInlineViewOrImage(float f2) {
        this.mHeightOfTallestInlineViewOrImage = f2;
    }

    public void setLetterSpacing(float f2) {
        this.mLetterSpacing = f2;
    }

    public void setLineHeight(float f2) {
        this.mLineHeight = f2;
    }

    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 == 0.0f || f2 >= 1.0f) {
            this.mMaxFontSizeMultiplier = f2;
            return;
        }
        throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    }

    public void setTextTransform(TextTransform textTransform) {
        this.mTextTransform = textTransform;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + getAllowFontScaling() + "\n  getFontSize(): " + getFontSize() + "\n  getEffectiveFontSize(): " + getEffectiveFontSize() + "\n  getHeightOfTallestInlineViewOrImage(): " + getHeightOfTallestInlineViewOrImage() + "\n  getLetterSpacing(): " + getLetterSpacing() + "\n  getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n  getLineHeight(): " + getLineHeight() + "\n  getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n  getTextTransform(): " + getTextTransform() + "\n  getMaxFontSizeMultiplier(): " + getMaxFontSizeMultiplier() + "\n  getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n}";
    }
}
