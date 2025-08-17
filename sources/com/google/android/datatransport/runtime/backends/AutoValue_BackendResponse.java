package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class AutoValue_BackendResponse extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f22539a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22540b;

    AutoValue_BackendResponse(BackendResponse.Status status, long j2) {
        if (status != null) {
            this.f22539a = status;
            this.f22540b = j2;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public long b() {
        return this.f22540b;
    }

    public BackendResponse.Status c() {
        return this.f22539a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.f22539a.equals(backendResponse.c()) || this.f22540b != backendResponse.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j2 = this.f22540b;
        return ((this.f22539a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f22539a + ", nextRequestWaitMillis=" + this.f22540b + "}";
    }
}
