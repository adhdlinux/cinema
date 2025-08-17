package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final AndroidSocketAdapter build(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && !Intrinsics.a(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            Intrinsics.c(cls2);
            return new AndroidSocketAdapter(cls2);
        }

        public final DeferredSocketAdapter.Factory factory(String str) {
            Intrinsics.f(str, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(str);
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> cls) {
        Intrinsics.f(cls, "sslSocketClass");
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = cls.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        if (matchesSocket(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, new Object[]{Boolean.TRUE});
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, new Object[]{str});
                }
                this.setAlpnProtocols.invoke(sSLSocket, new Object[]{Platform.Companion.concatLengthPrefixed(list)});
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        if (!matchesSocket(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, Charsets.f40513b);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if ((cause instanceof NullPointerException) && Intrinsics.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e3);
        }
    }

    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
