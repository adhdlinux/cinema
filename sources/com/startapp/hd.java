package com.startapp;

import java.util.Collection;
import java.util.Locale;

public class hd {

    /* renamed from: a  reason: collision with root package name */
    public static final hd f34644a = new hd();

    /* renamed from: b  reason: collision with root package name */
    public final String f34645b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34646c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34647d;

    public hd(Locale locale, Collection<Locale> collection) {
        this.f34645b = locale.toString();
        this.f34646c = a((Locale) null, collection, ';');
        this.f34647d = a(locale, collection, ',');
    }

    public static String a(Locale locale, Iterable<Locale> iterable, char c2) {
        boolean z2;
        StringBuilder sb;
        if (locale != null) {
            sb = new StringBuilder();
            sb.append(locale);
            z2 = true;
        } else {
            z2 = false;
            sb = null;
        }
        if (iterable != null) {
            for (Locale next : iterable) {
                if (next != null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (z2) {
                        sb.append(c2);
                    }
                    sb.append(next);
                    z2 = true;
                }
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public hd() {
        this.f34645b = null;
        this.f34646c = null;
        this.f34647d = null;
    }
}
