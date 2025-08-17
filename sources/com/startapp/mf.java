package com.startapp;

import java.util.regex.Pattern;

public class mf {

    /* renamed from: a  reason: collision with root package name */
    public final Pattern f34944a = Pattern.compile("\\+");

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f34945b = Pattern.compile("/");

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f34946c = Pattern.compile("=");

    public mf() {
        Pattern.compile("_");
        Pattern.compile("\\*");
        Pattern.compile("#");
    }

    public String a(String str) {
        return this.f34946c.matcher(this.f34945b.matcher(this.f34944a.matcher(str).replaceAll("_")).replaceAll("*")).replaceAll("#");
    }
}
