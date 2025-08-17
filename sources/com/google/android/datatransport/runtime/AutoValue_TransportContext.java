package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

final class AutoValue_TransportContext extends TransportContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f22491a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22492b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f22493c;

    static final class Builder extends TransportContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f22494a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f22495b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f22496c;

        Builder() {
        }

        public TransportContext a() {
            String str = "";
            if (this.f22494a == null) {
                str = str + " backendName";
            }
            if (this.f22496c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.f22494a, this.f22495b, this.f22496c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TransportContext.Builder b(String str) {
            if (str != null) {
                this.f22494a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public TransportContext.Builder c(byte[] bArr) {
            this.f22495b = bArr;
            return this;
        }

        public TransportContext.Builder d(Priority priority) {
            if (priority != null) {
                this.f22496c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public String b() {
        return this.f22491a;
    }

    public byte[] c() {
        return this.f22492b;
    }

    public Priority d() {
        return this.f22493c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f22491a.equals(transportContext.b())) {
            byte[] bArr2 = this.f22492b;
            if (transportContext instanceof AutoValue_TransportContext) {
                bArr = ((AutoValue_TransportContext) transportContext).f22492b;
            } else {
                bArr = transportContext.c();
            }
            if (!Arrays.equals(bArr2, bArr) || !this.f22493c.equals(transportContext.d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f22491a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22492b)) * 1000003) ^ this.f22493c.hashCode();
    }

    private AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.f22491a = str;
        this.f22492b = bArr;
        this.f22493c = priority;
    }
}
