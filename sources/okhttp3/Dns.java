package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private static final class DnsSystem implements Dns {
            public List<InetAddress> lookup(String str) {
                Intrinsics.f(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    Intrinsics.e(allByName, "getAllByName(hostname)");
                    return ArraysKt___ArraysKt.Q(allByName);
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
