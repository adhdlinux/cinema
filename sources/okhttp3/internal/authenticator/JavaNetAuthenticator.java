package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JavaNetAuthenticator() {
        this((Dns) null, 1, (DefaultConstructorMarker) null);
    }

    public JavaNetAuthenticator(Dns dns) {
        Intrinsics.f(dns, "defaultDns");
        this.defaultDns = dns;
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        int i2;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i2 = -1;
        } else {
            i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i2 == 1) {
            return (InetAddress) CollectionsKt___CollectionsKt.C(dns.lookup(httpUrl.host()));
        }
        SocketAddress address = proxy.address();
        Intrinsics.d(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        Intrinsics.e(address2, "address() as InetSocketAddress).address");
        return address2;
    }

    public Request authenticate(Route route, Response response) throws IOException {
        boolean z2;
        Proxy proxy;
        Dns dns;
        PasswordAuthentication passwordAuthentication;
        String str;
        Address address;
        Intrinsics.f(response, "response");
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        if (response.code() == 407) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge next : challenges) {
            if (StringsKt__StringsJVMKt.t("Basic", next.scheme(), true)) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (z2) {
                    SocketAddress address2 = proxy.address();
                    Intrinsics.d(address2, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                    String hostName = inetSocketAddress.getHostName();
                    Intrinsics.e(proxy, "proxy");
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(hostName, connectToInetAddress(proxy, url, dns), inetSocketAddress.getPort(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = url.host();
                    Intrinsics.e(proxy, "proxy");
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(host, connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    if (z2) {
                        str = "Proxy-Authorization";
                    } else {
                        str = "Authorization";
                    }
                    String userName = passwordAuthentication.getUserName();
                    Intrinsics.e(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    Intrinsics.e(password, "auth.password");
                    return request.newBuilder().header(str, Credentials.basic(userName, new String(password), next.charset())).build();
                }
            }
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
