package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload {

    /* renamed from: a  reason: collision with root package name */
    private final Encoding f22511a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22512b;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f22511a = encoding;
            this.f22512b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f22512b;
    }

    public Encoding b() {
        return this.f22511a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.f22511a.equals(encodedPayload.f22511a)) {
            return false;
        }
        return Arrays.equals(this.f22512b, encodedPayload.f22512b);
    }

    public int hashCode() {
        return ((this.f22511a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22512b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f22511a + ", bytes=[...]}";
    }
}
