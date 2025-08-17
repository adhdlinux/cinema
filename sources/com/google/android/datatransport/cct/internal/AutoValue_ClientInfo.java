package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

final class AutoValue_ClientInfo extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f22351a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidClientInfo f22352b;

    static final class Builder extends ClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f22353a;

        /* renamed from: b  reason: collision with root package name */
        private AndroidClientInfo f22354b;

        Builder() {
        }

        public ClientInfo a() {
            return new AutoValue_ClientInfo(this.f22353a, this.f22354b);
        }

        public ClientInfo.Builder b(AndroidClientInfo androidClientInfo) {
            this.f22354b = androidClientInfo;
            return this;
        }

        public ClientInfo.Builder c(ClientInfo.ClientType clientType) {
            this.f22353a = clientType;
            return this;
        }
    }

    public AndroidClientInfo b() {
        return this.f22352b;
    }

    public ClientInfo.ClientType c() {
        return this.f22351a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f22351a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            AndroidClientInfo androidClientInfo = this.f22352b;
            if (androidClientInfo == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2;
        ClientInfo.ClientType clientType = this.f22351a;
        int i3 = 0;
        if (clientType == null) {
            i2 = 0;
        } else {
            i2 = clientType.hashCode();
        }
        int i4 = (i2 ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f22352b;
        if (androidClientInfo != null) {
            i3 = androidClientInfo.hashCode();
        }
        return i4 ^ i3;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f22351a + ", androidClientInfo=" + this.f22352b + "}";
    }

    private AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.f22351a = clientType;
        this.f22352b = androidClientInfo;
    }
}
