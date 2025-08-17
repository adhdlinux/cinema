package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    final /* synthetic */ String $packageName;

    AndroidSocketAdapter$Companion$factory$1(String str) {
        this.$packageName = str;
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        return AndroidSocketAdapter.Companion.build(sSLSocket.getClass());
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        Intrinsics.e(name, "sslSocket.javaClass.name");
        return StringsKt__StringsJVMKt.G(name, this.$packageName + '.', false, 2, (Object) null);
    }
}
