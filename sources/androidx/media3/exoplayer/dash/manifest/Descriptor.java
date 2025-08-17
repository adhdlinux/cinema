package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.Util;

public final class Descriptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f6076a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6077b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6078c;

    public Descriptor(String str, String str2, String str3) {
        this.f6076a = str;
        this.f6077b = str2;
        this.f6078c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Descriptor.class != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (!Util.c(this.f6076a, descriptor.f6076a) || !Util.c(this.f6077b, descriptor.f6077b) || !Util.c(this.f6078c, descriptor.f6078c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f6076a.hashCode() * 31;
        String str = this.f6077b;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (hashCode + i2) * 31;
        String str2 = this.f6078c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }
}
