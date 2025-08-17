package com.utils.subtitle.converter;

public class FatalParsingException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private String f37721b;

    public FatalParsingException(String str) {
        super(str);
        this.f37721b = str;
    }

    public String getLocalizedMessage() {
        return this.f37721b;
    }
}
