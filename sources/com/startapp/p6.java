package com.startapp;

import android.content.SharedPreferences;

public class p6 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f35607a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f35608b;

    /* renamed from: c  reason: collision with root package name */
    public volatile String f35609c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f35610d;

    public p6(SharedPreferences sharedPreferences) {
        this.f35608b = sharedPreferences;
    }

    public boolean a() {
        boolean contains;
        synchronized (this.f35607a) {
            contains = this.f35608b.contains("2696a7f502faed4b");
        }
        return contains;
    }
}
