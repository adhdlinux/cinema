package com.google.android.datatransport.cct.internal;

import java.util.List;

final class AutoValue_BatchedLogRequest extends BatchedLogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<LogRequest> f22350a;

    AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list != null) {
            this.f22350a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public List<LogRequest> c() {
        return this.f22350a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f22350a.equals(((BatchedLogRequest) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f22350a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f22350a + "}";
    }
}
