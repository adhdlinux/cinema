package com.facebook.react.common;

import com.facebook.infer.annotation.Assertions;

public class SingleThreadAsserter {
    private Thread mThread = null;

    public void assertNow() {
        boolean z2;
        Thread currentThread = Thread.currentThread();
        if (this.mThread == null) {
            this.mThread = currentThread;
        }
        if (this.mThread == currentThread) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2);
    }
}
