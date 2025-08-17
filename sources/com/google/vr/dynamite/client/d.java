package com.google.vr.dynamite.client;

public final class d extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private final int f31145b = 1;

    public final String getMessage() {
        String str = this.f31145b != 1 ? "Unknown error" : "Package not available";
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
