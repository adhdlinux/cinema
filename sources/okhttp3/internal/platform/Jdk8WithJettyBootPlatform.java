package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            Intrinsics.f(list, "protocols");
            this.protocols = list;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            boolean z2;
            Intrinsics.f(obj, "proxy");
            Intrinsics.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.a(name, "supports") && Intrinsics.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (!Intrinsics.a(name, "unsupported") || !Intrinsics.a(Void.TYPE, returnType)) {
                if (Intrinsics.a(name, "protocols")) {
                    if (objArr.length == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return this.protocols;
                    }
                }
                if ((Intrinsics.a(name, "selectProtocol") || Intrinsics.a(name, "select")) && Intrinsics.a(String.class, returnType) && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        Intrinsics.d(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                        List list = (List) obj2;
                        int size = list.size();
                        if (size >= 0) {
                            int i2 = 0;
                            while (true) {
                                Object obj3 = list.get(i2);
                                Intrinsics.d(obj3, "null cannot be cast to non-null type kotlin.String");
                                String str = (String) obj3;
                                if (!this.protocols.contains(str)) {
                                    if (i2 == size) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    this.selected = str;
                                    return str;
                                }
                            }
                        }
                        String str2 = this.protocols.get(0);
                        this.selected = str2;
                        return str2;
                    }
                }
                if ((!Intrinsics.a(name, "protocolSelected") && !Intrinsics.a(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj4 = objArr[0];
                Intrinsics.d(obj4, "null cannot be cast to non-null type kotlin.String");
                this.selected = (String) obj4;
                return null;
            }
            this.unsupported = true;
            return null;
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z2) {
            this.unsupported = z2;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform buildIfSupported() {
            Class<SSLSocket> cls = SSLSocket.class;
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                Intrinsics.e(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider", true, (ClassLoader) null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider", true, (ClassLoader) null);
                Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider", true, (ClassLoader) null);
                Method method = cls2.getMethod("put", new Class[]{cls, cls3});
                Method method2 = cls2.getMethod("get", new Class[]{cls});
                Method method3 = cls2.getMethod("remove", new Class[]{cls});
                Intrinsics.e(method, "putMethod");
                Intrinsics.e(method2, "getMethod");
                Intrinsics.e(method3, "removeMethod");
                Intrinsics.e(cls4, "clientProviderClass");
                Intrinsics.e(cls5, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method, method2, method3, cls4, cls5);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Intrinsics.f(method, "putMethod");
        Intrinsics.f(method2, "getMethod");
        Intrinsics.f(method3, "removeMethod");
        Intrinsics.f(cls, "clientProviderClass");
        Intrinsics.f(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Intrinsics.f(sSLSocket, "sslSocket");
        Intrinsics.f(list, "protocols");
        List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(alpnProtocolNames));
            this.putMethod.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.f(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
            Intrinsics.d(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, (Throwable) null, 6, (Object) null);
                return null;
            } else if (alpnProvider.getUnsupported()) {
                return null;
            } else {
                return alpnProvider.getSelected();
            }
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }
}
