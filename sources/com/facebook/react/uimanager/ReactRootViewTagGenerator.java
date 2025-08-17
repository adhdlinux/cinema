package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator {
    private static final int ROOT_VIEW_TAG_INCREMENT = 10;
    private static int sNextRootViewTag = 1;

    public static synchronized int getNextRootViewTag() {
        int i2;
        synchronized (ReactRootViewTagGenerator.class) {
            i2 = sNextRootViewTag;
            sNextRootViewTag = i2 + 10;
        }
        return i2;
    }
}
