package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f22384a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f22385b;

    static final class Builder extends NetworkConnectionInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f22386a;

        /* renamed from: b  reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f22387b;

        Builder() {
        }

        public NetworkConnectionInfo a() {
            return new AutoValue_NetworkConnectionInfo(this.f22386a, this.f22387b);
        }

        public NetworkConnectionInfo.Builder b(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f22387b = mobileSubtype;
            return this;
        }

        public NetworkConnectionInfo.Builder c(NetworkConnectionInfo.NetworkType networkType) {
            this.f22386a = networkType;
            return this;
        }
    }

    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f22385b;
    }

    public NetworkConnectionInfo.NetworkType c() {
        return this.f22384a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f22384a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f22385b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.b() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2;
        NetworkConnectionInfo.NetworkType networkType = this.f22384a;
        int i3 = 0;
        if (networkType == null) {
            i2 = 0;
        } else {
            i2 = networkType.hashCode();
        }
        int i4 = (i2 ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f22385b;
        if (mobileSubtype != null) {
            i3 = mobileSubtype.hashCode();
        }
        return i4 ^ i3;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f22384a + ", mobileSubtype=" + this.f22385b + "}";
    }

    private AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f22384a = networkType;
        this.f22385b = mobileSubtype;
    }
}
