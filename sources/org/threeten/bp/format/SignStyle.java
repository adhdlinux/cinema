package org.threeten.bp.format;

public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* access modifiers changed from: package-private */
    public boolean parse(boolean z2, boolean z3, boolean z4) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return !z2 || !z3;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return !z3 && !z4;
    }
}
