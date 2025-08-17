package org.jsoup.parser;

import java.util.ArrayList;

public class ParseErrorList extends ArrayList<ParseError> {

    /* renamed from: b  reason: collision with root package name */
    private final int f41675b;

    ParseErrorList(int i2, int i3) {
        super(i2);
        this.f41675b = i3;
    }

    public static ParseErrorList b() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList c(int i2) {
        return new ParseErrorList(16, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return size() < this.f41675b;
    }
}
