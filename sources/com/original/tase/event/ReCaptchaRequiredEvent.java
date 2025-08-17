package com.original.tase.event;

public class ReCaptchaRequiredEvent {

    /* renamed from: a  reason: collision with root package name */
    private String f33804a;

    /* renamed from: b  reason: collision with root package name */
    private String f33805b;

    /* renamed from: c  reason: collision with root package name */
    private String f33806c;

    public ReCaptchaRequiredEvent(String str, String str2) {
        this(str, str2, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
    }

    public ReCaptchaRequiredEvent(String str, String str2, String str3) {
        this.f33804a = str;
        this.f33805b = str2;
        this.f33806c = str3 == null ? "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36" : str3;
    }
}
