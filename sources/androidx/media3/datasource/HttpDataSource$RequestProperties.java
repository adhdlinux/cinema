package androidx.media3.datasource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HttpDataSource$RequestProperties {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f4896a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f4897b;

    public synchronized void a(Map<String, String> map) {
        this.f4897b = null;
        this.f4896a.clear();
        this.f4896a.putAll(map);
    }

    public synchronized Map<String, String> b() {
        if (this.f4897b == null) {
            this.f4897b = Collections.unmodifiableMap(new HashMap(this.f4896a));
        }
        return this.f4897b;
    }
}
