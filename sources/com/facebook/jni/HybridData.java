package com.facebook.jni;

import com.facebook.jni.DestructorThread;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.soloader.nativeloader.NativeLoader;

@DoNotStrip
public class HybridData {
    @DoNotStrip
    private Destructor mDestructor = new Destructor(this);

    public static class Destructor extends DestructorThread.Destructor {
        /* access modifiers changed from: private */
        @DoNotStrip
        public volatile long mNativePointer;

        Destructor(Object obj) {
            super(obj);
        }

        static native void deleteNative(long j2);

        /* access modifiers changed from: protected */
        public final void destruct() {
            deleteNative(this.mNativePointer);
            this.mNativePointer = 0;
        }
    }

    static {
        NativeLoader.loadLibrary("fbjni");
    }

    public boolean isValid() {
        return this.mDestructor.mNativePointer != 0;
    }

    public synchronized void resetNative() {
        this.mDestructor.destruct();
    }
}
