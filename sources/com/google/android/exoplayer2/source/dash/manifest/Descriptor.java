package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class Descriptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f26305a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26306b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26307c;

    public Descriptor(String str, String str2, String str3) {
        this.f26305a = str;
        this.f26306b = str2;
        this.f26307c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Descriptor.class != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (!Util.c(this.f26305a, descriptor.f26305a) || !Util.c(this.f26306b, descriptor.f26306b) || !Util.c(this.f26307c, descriptor.f26307c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f26305a.hashCode() * 31;
        String str = this.f26306b;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (hashCode + i2) * 31;
        String str2 = this.f26307c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }
}
