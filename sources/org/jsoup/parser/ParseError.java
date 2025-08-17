package org.jsoup.parser;

public class ParseError {

    /* renamed from: a  reason: collision with root package name */
    private int f41673a;

    /* renamed from: b  reason: collision with root package name */
    private String f41674b;

    ParseError(int i2, String str) {
        this.f41673a = i2;
        this.f41674b = str;
    }

    public String toString() {
        return this.f41673a + ": " + this.f41674b;
    }

    ParseError(int i2, String str, Object... objArr) {
        this.f41674b = String.format(str, objArr);
        this.f41673a = i2;
    }
}
