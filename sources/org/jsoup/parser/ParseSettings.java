package org.jsoup.parser;

import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;

public class ParseSettings {

    /* renamed from: c  reason: collision with root package name */
    public static final ParseSettings f41676c = new ParseSettings(false, false);

    /* renamed from: d  reason: collision with root package name */
    public static final ParseSettings f41677d = new ParseSettings(true, true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41678a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f41679b;

    public ParseSettings(boolean z2, boolean z3) {
        this.f41678a = z2;
        this.f41679b = z3;
    }

    /* access modifiers changed from: package-private */
    public Attributes a(Attributes attributes) {
        if (!this.f41679b) {
            attributes.s();
        }
        return attributes;
    }

    /* access modifiers changed from: package-private */
    public String b(String str) {
        String trim = str.trim();
        if (!this.f41678a) {
            return Normalizer.a(trim);
        }
        return trim;
    }
}
