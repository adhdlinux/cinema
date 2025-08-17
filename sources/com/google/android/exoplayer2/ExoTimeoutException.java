package com.google.android.exoplayer2;

public final class ExoTimeoutException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    public final int f23042b;

    public ExoTimeoutException(int i2) {
        super(a(i2));
        this.f23042b = i2;
    }

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
