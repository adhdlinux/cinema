package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
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
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@SuppressSignatureCheck
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new AndroidPlatform();
            }
            return null;
        }

        public final boolean isSupported() {
            return AndroidPlatform.isSupported;
        }
    }

    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.f(x509TrustManager, "trustManager");
            Intrinsics.f(method, "findByIssuerAndSignatureMethod");
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((i2 & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        public final CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.f(x509TrustManager, "trustManager");
            Intrinsics.f(method, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(x509TrustManager, method);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.a(this.trustManager, customTrustRootIndex.trustManager) && Intrinsics.a(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{x509Certificate});
                Intrinsics.d(invoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e2) {
                throw new AssertionError("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return (this.trustManager.hashCode() * 31) + this.findByIssuerAndSignatureMethod.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        boolean z2 = false;
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        isSupported = z2;
    }

    public AndroidPlatform() {
        SocketAdapter[] socketAdapterArr = {StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, (String) null, 1, (Object) null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        ArrayList arrayList = new ArrayList();
        for (Object next : CollectionsKt__CollectionsKt.j(socketAdapterArr)) {
            if (((SocketAdapter) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.socketAdapters = arrayList;
        this.closeGuard = CloseGuard.Companion.get();
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.f(x509TrustManager, "trustManager");
        AndroidCertificateChainCleaner buildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        return super.buildCertificateChainCleaner(x509TrustManager);
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        Intrinsics.f(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            Intrinsics.e(declaredMethod, "method");
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
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

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Intrinsics.f(socket, "socket");
        Intrinsics.f(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e2);
            }
            throw e2;
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

    public Object getStackTraceForCloseable(String str) {
        Intrinsics.f(str, "closer");
        return this.closeGuard.createAndOpen(str);
    }

    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.f(str, "hostname");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i2 >= 23) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return true;
    }

    public void logCloseableLeak(String str, Object obj) {
        Intrinsics.f(str, "message");
        if (!this.closeGuard.warnIfOpen(obj)) {
            Platform.log$default(this, str, 5, (Throwable) null, 4, (Object) null);
        }
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
