package androidx.media3.common;

import java.io.IOException;

public class ParserException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4292b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4293c;

    protected ParserException(String str, Throwable th, boolean z2, int i2) {
        super(str, th);
        this.f4292b = z2;
        this.f4293c = i2;
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

    public static ParserException d(String str) {
        return new ParserException(str, (Throwable) null, false, 1);
    }

    public String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.f4292b + ", dataType=" + this.f4293c + "}";
    }
}
