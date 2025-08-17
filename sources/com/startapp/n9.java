package com.startapp;

import java.util.Arrays;
import java.util.List;

public final class n9 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f34963a = Arrays.asList(new String[]{"portrait", "landscape", "none"});

    /* renamed from: b  reason: collision with root package name */
    public boolean f34964b;

    /* renamed from: c  reason: collision with root package name */
    public int f34965c;

    public n9() {
        this(true, 2);
    }

    public static int a(String str) {
        int indexOf = f34963a.indexOf(str);
        if (indexOf != -1) {
            return indexOf;
        }
        return 2;
    }

    public n9(boolean z2, int i2) {
        this.f34964b = z2;
        this.f34965c = i2;
    }
}
