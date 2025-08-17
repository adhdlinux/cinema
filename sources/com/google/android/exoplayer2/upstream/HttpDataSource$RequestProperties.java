package com.google.android.exoplayer2.upstream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HttpDataSource$RequestProperties {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f28448a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f28449b;

    public synchronized Map<String, String> a() {
        if (this.f28449b == null) {
            this.f28449b = Collections.unmodifiableMap(new HashMap(this.f28448a));
        }
        return this.f28449b;
    }
}
