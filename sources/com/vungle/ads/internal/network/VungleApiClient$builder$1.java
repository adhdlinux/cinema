package com.vungle.ads.internal.network;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class VungleApiClient$builder$1 extends ProxySelector {
    VungleApiClient$builder$1() {
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        try {
            ProxySelector.getDefault().connectFailed(uri, socketAddress, iOException);
        } catch (Exception unused) {
        }
    }

    public List<Proxy> select(URI uri) {
        try {
            List<Proxy> select = ProxySelector.getDefault().select(uri);
            Intrinsics.e(select, "{\n                      …ri)\n                    }");
            return select;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsJVMKt.b(Proxy.NO_PROXY);
        }
    }
}
