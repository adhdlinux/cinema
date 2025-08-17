package com.facebook.yoga;

public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
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
            YogaNative.jni_YGConfigFreeJNI(j2);
        }
    }
}
