package com.google.android.datatransport.cct.internal;

final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: a  reason: collision with root package name */
    private final long f22383a;

    AutoValue_LogResponse(long j2) {
        this.f22383a = j2;
    }

    public long c() {
        return this.f22383a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse) || this.f22383a != ((LogResponse) obj).c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j2 = this.f22383a;
        return 1000003 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f22383a + "}";
    }
}
