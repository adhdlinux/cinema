package androidx.webkit.internal;

import java.util.HashSet;
import java.util.Set;

public abstract class StartupApiFeature {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<StartupApiFeature> f12072c = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private final String f12073a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12074b;

    public static class P extends StartupApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }
    }

    StartupApiFeature(String str, String str2) {
        this.f12073a = str;
        this.f12074b = str2;
        f12072c.add(this);
    }
}
