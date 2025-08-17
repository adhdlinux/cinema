package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        public final SocketAdapter buildIfSupported(String str) {
            Intrinsics.f(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                Intrinsics.d(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                Intrinsics.d(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                Intrinsics.e(cls3, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, cls3);
            } catch (Exception e2) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e2);
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        Intrinsics.f(cls, "sslSocketClass");
        Intrinsics.f(cls2, "sslSocketFactoryClass");
        Intrinsics.f(cls3, "paramClass");
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.f(sSLSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.f(sSLSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        Intrinsics.c(readFieldOrNull);
        Class cls = X509TrustManager.class;
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, cls, "x509TrustManager");
        if (x509TrustManager == null) {
            return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, cls, "trustManager");
        }
        return x509TrustManager;
    }
}
