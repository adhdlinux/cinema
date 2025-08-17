package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

final class AutoValue_BackendRequest extends BackendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<EventInternal> f22535a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22536b;

    static final class Builder extends BackendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<EventInternal> f22537a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f22538b;

        Builder() {
        }

        public BackendRequest a() {
            String str = "";
            if (this.f22537a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f22537a, this.f22538b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public BackendRequest.Builder b(Iterable<EventInternal> iterable) {
            if (iterable != null) {
                this.f22537a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public BackendRequest.Builder c(byte[] bArr) {
            this.f22538b = bArr;
            return this;
        }
    }

    public Iterable<EventInternal> b() {
        return this.f22535a;
    }

    public byte[] c() {
        return this.f22536b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f22535a.equals(backendRequest.b())) {
            byte[] bArr2 = this.f22536b;
            if (backendRequest instanceof AutoValue_BackendRequest) {
                bArr = ((AutoValue_BackendRequest) backendRequest).f22536b;
            } else {
                bArr = backendRequest.c();
            }
            if (Arrays.equals(bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f22535a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22536b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f22535a + ", extras=" + Arrays.toString(this.f22536b) + "}";
    }

    private AutoValue_BackendRequest(Iterable<EventInternal> iterable, byte[] bArr) {
        this.f22535a = iterable;
        this.f22536b = bArr;
    }
}
