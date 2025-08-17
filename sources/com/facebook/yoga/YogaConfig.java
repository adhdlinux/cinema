package com.facebook.yoga;

public abstract class YogaConfig {
    public static int SPACING_TYPE = 1;

    public abstract YogaLogger getLogger();

    /* access modifiers changed from: package-private */
    public abstract long getNativePointer();

    public abstract void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z2);

    public abstract void setLogger(YogaLogger yogaLogger);

    public abstract void setPointScaleFactor(float f2);

    public abstract void setPrintTreeFlag(boolean z2);

    public abstract void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z2);

    public abstract void setUseLegacyStretchBehaviour(boolean z2);

    public abstract void setUseWebDefaults(boolean z2);
}
