package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses = CollectionsKt__CollectionsKt.f();
    private int nextProxyIndex;
    private final List<Route> postponedRoutes = new ArrayList();
    private List<? extends Proxy> proxies = CollectionsKt__CollectionsKt.f();
    private final RouteDatabase routeDatabase;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getSocketHost(InetSocketAddress inetSocketAddress) {
            Intrinsics.f(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                Intrinsics.e(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.e(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> list) {
            Intrinsics.f(list, "routes");
            this.routes = list;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i2 = this.nextRouteIndex;
                this.nextRouteIndex = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address2, RouteDatabase routeDatabase2, Call call2, EventListener eventListener2) {
        Intrinsics.f(address2, "address");
        Intrinsics.f(routeDatabase2, "routeDatabase");
        Intrinsics.f(call2, "call");
        Intrinsics.f(eventListener2, "eventListener");
        this.address = address2;
        this.routeDatabase = routeDatabase2;
        this.call = call2;
        this.eventListener = eventListener2;
        resetNextProxy(address2.url(), address2.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i2 = this.nextProxyIndex;
            this.nextProxyIndex = i2 + 1;
            Proxy proxy = (Proxy) list.get(i2);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String str;
        int i2;
        List<InetAddress> list;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.address.url().host();
            i2 = this.address.url().port();
        } else {
            SocketAddress address2 = proxy.address();
            if (address2 instanceof InetSocketAddress) {
                Companion companion = Companion;
                Intrinsics.e(address2, "proxyAddress");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                str = companion.getSocketHost(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address2.getClass()).toString());
            }
        }
        boolean z2 = false;
        if (1 <= i2 && i2 < 65536) {
            z2 = true;
        }
        if (!z2) {
            throw new SocketException("No route to " + str + ':' + i2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            if (Util.canParseAsIpAddress(str)) {
                list = CollectionsKt__CollectionsJVMKt.b(InetAddress.getByName(str));
            } else {
                this.eventListener.dnsStart(this.call, str);
                list = this.address.dns().lookup(str);
                if (!list.isEmpty()) {
                    this.eventListener.dnsEnd(this.call, str, list);
                } else {
                    throw new UnknownHostException(this.address.dns() + " returned no addresses for " + str);
                }
            }
            for (InetAddress inetSocketAddress2 : list) {
                arrayList.add(new InetSocketAddress(inetSocketAddress2, i2));
            }
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List<Proxy> resetNextProxy$selectProxies = resetNextProxy$selectProxies(proxy, httpUrl, this);
        this.proxies = resetNextProxy$selectProxies;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, resetNextProxy$selectProxies);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        boolean z2;
        if (proxy != null) {
            return CollectionsKt__CollectionsJVMKt.b(proxy);
        }
        URI uri = httpUrl.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> select = routeSelector.address.proxySelector().select(uri);
        Collection collection = select;
        if (collection == null || collection.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        Intrinsics.e(select, "proxiesOrNull");
        return Util.toImmutableList(select);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                for (InetSocketAddress route : this.inetSocketAddresses) {
                    Route route2 = new Route(this.address, nextProxy, route);
                    if (this.routeDatabase.shouldPostpone(route2)) {
                        this.postponedRoutes.add(route2);
                    } else {
                        arrayList.add(route2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.u(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
