package org.joda.time.tz;

public class ZoneInfoLogger {
    static ThreadLocal<Boolean> cVerbose = new ThreadLocal<Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static void set(boolean z2) {
        cVerbose.set(Boolean.valueOf(z2));
    }

    public static boolean verbose() {
        return cVerbose.get().booleanValue();
    }
}
