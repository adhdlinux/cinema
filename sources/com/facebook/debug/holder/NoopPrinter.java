package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public class NoopPrinter implements Printer {
    public static final NoopPrinter INSTANCE = new NoopPrinter();

    private NoopPrinter() {
    }

    public void logMessage(DebugOverlayTag debugOverlayTag, String str) {
    }

    public void logMessage(DebugOverlayTag debugOverlayTag, String str, Object... objArr) {
    }

    public boolean shouldDisplayLogMessage(DebugOverlayTag debugOverlayTag) {
        return false;
    }
}
