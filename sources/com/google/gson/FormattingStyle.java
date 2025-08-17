package com.google.gson;

import java.util.Objects;

public class FormattingStyle {

    /* renamed from: d  reason: collision with root package name */
    public static final FormattingStyle f30833d = new FormattingStyle("", "", false);

    /* renamed from: e  reason: collision with root package name */
    public static final FormattingStyle f30834e = new FormattingStyle(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "  ", true);

    /* renamed from: a  reason: collision with root package name */
    private final String f30835a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30836b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30837c;

    private FormattingStyle(String str, String str2, boolean z2) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        } else if (str2.matches("[ \t]*")) {
            this.f30835a = str;
            this.f30836b = str2;
            this.f30837c = z2;
        } else {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
    }

    public String a() {
        return this.f30836b;
    }

    public String b() {
        return this.f30835a;
    }

    public boolean c() {
        return this.f30837c;
    }

    public FormattingStyle d(String str) {
        return new FormattingStyle(this.f30835a, str, this.f30837c);
    }
}
