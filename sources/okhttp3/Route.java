package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress) {
        Intrinsics.f(address2, "address");
        Intrinsics.f(proxy2, "proxy");
        Intrinsics.f(inetSocketAddress, "socketAddress");
        this.address = address2;
        this.proxy = proxy2;
        this.socketAddress = inetSocketAddress;
    }

    /* renamed from: -deprecated_address  reason: not valid java name */
    public final Address m354deprecated_address() {
        return this.address;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m355deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_socketAddress  reason: not valid java name */
    public final InetSocketAddress m356deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (!Intrinsics.a(route.address, this.address) || !Intrinsics.a(route.proxy, this.proxy) || !Intrinsics.a(route.socketAddress, this.socketAddress)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
