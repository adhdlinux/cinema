package com.google.android.exoplayer2;

import java.io.IOException;

public class ParserException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f23363b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23364c;

    protected ParserException(String str, Throwable th, boolean z2, int i2) {
        super(str, th);
        this.f23363b = z2;
        this.f23364c = i2;
    }

    public static ParserException a(String str, Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    public static ParserException b(String str, Throwable th) {
        return new ParserException(str, th, true, 0);
    }

    public static ParserException c(String str, Throwable th) {
        return new ParserException(str, th, true, 4);
    }

    public static ParserException d(String str, Throwable th) {
        return new ParserException(str, th, false, 4);
    }

    public static ParserException e(String str) {
        return new ParserException(str, (Throwable) null, false, 1);
    }
}
