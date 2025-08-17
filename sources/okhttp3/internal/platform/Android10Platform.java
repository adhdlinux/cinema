package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;

@SuppressSignatureCheck
public final class Android10Platform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final List<SocketAdapter> socketAdapters;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new Android10Platform();
            }
            return null;
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }
    }

    static {
        boolean z2;
        if (!Platform.Companion.isAndroid() || Build.VERSION.SDK_INT < 29) {
            z2 = false;
        } else {
            z2 = true;
        }
        isSupported = z2;
    }

    public Android10Platform() {
        SocketAdapter[] socketAdapterArr = {Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        ArrayList arrayList = new ArrayList();
        for (Object next : CollectionsKt__CollectionsKt.j(socketAdapterArr)) {
            if (((SocketAdapter) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.socketAdapters = arrayList;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.f(x509TrustManager, "trustManager");
        AndroidCertificateChainCleaner buildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        return super.buildCertificateChainCleaner(x509TrustManager);
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Object obj;
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        Iterator it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, list);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        Intrinsics.f(sSLSocket, "sslSocket");
        Iterator it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.f(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object obj;
        Intrinsics.f(sSLSocketFactory, "sslSocketFactory");
        Iterator it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((SocketAdapter) obj).matchesSocketFactory(sSLSocketFactory)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.trustManager(sSLSocketFactory);
        }
        return null;
    }
}
