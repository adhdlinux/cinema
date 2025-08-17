package com.facebook.yoga;

public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public YogaNodeJNIFinalizer() {
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        long j2 = this.mNativePointer;
        if (j2 != 0) {
            this.mNativePointer = 0;
            YogaNative.jni_YGNodeFreeJNI(j2);
        }
    }

    public YogaNodeJNIFinalizer(YogaConfig yogaConfig) {
        super(yogaConfig);
    }
}
