package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

final class AutoValue_CreationContext extends CreationContext {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22541a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f22542b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f22543c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22544d;

    AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f22541a = context;
            if (clock != null) {
                this.f22542b = clock;
                if (clock2 != null) {
                    this.f22543c = clock2;
                    if (str != null) {
                        this.f22544d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context b() {
        return this.f22541a;
    }

    public String c() {
        return this.f22544d;
    }

    public Clock d() {
        return this.f22543c;
    }

    public Clock e() {
        return this.f22542b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (!this.f22541a.equals(creationContext.b()) || !this.f22542b.equals(creationContext.e()) || !this.f22543c.equals(creationContext.d()) || !this.f22544d.equals(creationContext.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f22541a.hashCode() ^ 1000003) * 1000003) ^ this.f22542b.hashCode()) * 1000003) ^ this.f22543c.hashCode()) * 1000003) ^ this.f22544d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f22541a + ", wallClock=" + this.f22542b + ", monotonicClock=" + this.f22543c + ", backendName=" + this.f22544d + "}";
    }
}
