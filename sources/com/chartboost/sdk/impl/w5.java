package com.chartboost.sdk.impl;

import java.io.File;

public class w5 {

    /* renamed from: a  reason: collision with root package name */
    public final File f18887a;

    /* renamed from: b  reason: collision with root package name */
    public final File f18888b;

    /* renamed from: c  reason: collision with root package name */
    public final File f18889c;

    /* renamed from: d  reason: collision with root package name */
    public final File f18890d;

    /* renamed from: e  reason: collision with root package name */
    public final File f18891e;

    /* renamed from: f  reason: collision with root package name */
    public final File f18892f;

    /* renamed from: g  reason: collision with root package name */
    public final File f18893g;

    /* renamed from: h  reason: collision with root package name */
    public final File f18894h;

    /* renamed from: i  reason: collision with root package name */
    public final File f18895i;

    public w5(File file) {
        File file2 = new File(file, ".chartboost");
        this.f18887a = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        this.f18888b = a(file2, "css");
        this.f18889c = a(file2, "html");
        this.f18890d = a(file2, "images");
        this.f18891e = a(file2, "js");
        this.f18892f = a(file2, "templates");
        this.f18893g = a(file2, "videos");
        this.f18894h = a(file2, "precache");
        this.f18895i = a(file2, "precache_queue");
    }

    public File a() {
        return this.f18887a;
    }

    public static File a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }
}
