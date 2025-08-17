package com.facebook.yoga;

public abstract class YogaConfigJNIBase extends YogaConfig {
    private YogaLogger mLogger;
    long mNativePointer;

    private YogaConfigJNIBase(long j2) {
        if (j2 != 0) {
            this.mNativePointer = j2;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    public YogaLogger getLogger() {
        return this.mLogger;
    }

    /* access modifiers changed from: package-private */
    public long getNativePointer() {
        return this.mNativePointer;
    }

    public void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z2) {
        YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.mNativePointer, yogaExperimentalFeature.intValue(), z2);
    }

    public void setLogger(YogaLogger yogaLogger) {
        this.mLogger = yogaLogger;
        YogaNative.jni_YGConfigSetLoggerJNI(this.mNativePointer, yogaLogger);
    }

    public void setPointScaleFactor(float f2) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, f2);
    }

    public void setPrintTreeFlag(boolean z2) {
        YogaNative.jni_YGConfigSetPrintTreeFlagJNI(this.mNativePointer, z2);
    }

    public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z2) {
        YogaNative.jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviourJNI(this.mNativePointer, z2);
    }

    public void setUseLegacyStretchBehaviour(boolean z2) {
        YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(this.mNativePointer, z2);
    }

    public void setUseWebDefaults(boolean z2) {
        YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.mNativePointer, z2);
    }

    YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    YogaConfigJNIBase(boolean z2) {
        this(YogaNative.jni_YGConfigNewJNI());
    }
}
