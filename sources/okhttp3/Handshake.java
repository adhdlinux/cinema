package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

public final class Handshake {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion2, CipherSuite cipherSuite2, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.f(tlsVersion2, "tlsVersion");
        Intrinsics.f(cipherSuite2, "cipherSuite");
        Intrinsics.f(list, "localCertificates");
        Intrinsics.f(function0, "peerCertificatesFn");
        this.tlsVersion = tlsVersion2;
        this.cipherSuite = cipherSuite2;
        this.localCertificates = list;
        this.peerCertificates$delegate = LazyKt__LazyJVMKt.b(new Handshake$peerCertificates$2(function0));
    }

    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    public static final Handshake get(TlsVersion tlsVersion2, CipherSuite cipherSuite2, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion2, cipherSuite2, list, list2);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.e(type, "type");
        return type;
    }

    /* renamed from: -deprecated_cipherSuite  reason: not valid java name */
    public final CipherSuite m265deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    /* renamed from: -deprecated_localCertificates  reason: not valid java name */
    public final List<Certificate> m266deprecated_localCertificates() {
        return this.localCertificates;
    }

    /* renamed from: -deprecated_localPrincipal  reason: not valid java name */
    public final Principal m267deprecated_localPrincipal() {
        return localPrincipal();
    }

    /* renamed from: -deprecated_peerCertificates  reason: not valid java name */
    public final List<Certificate> m268deprecated_peerCertificates() {
        return peerCertificates();
    }

    /* renamed from: -deprecated_peerPrincipal  reason: not valid java name */
    public final Principal m269deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    /* renamed from: -deprecated_tlsVersion  reason: not valid java name */
    public final TlsVersion m270deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion != this.tlsVersion || !Intrinsics.a(handshake.cipherSuite, this.cipherSuite) || !Intrinsics.a(handshake.peerCertificates(), peerCertificates()) || !Intrinsics.a(handshake.localCertificates, this.localCertificates)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object D = CollectionsKt___CollectionsKt.D(this.localCertificates);
        X509Certificate x509Certificate = D instanceof X509Certificate ? (X509Certificate) D : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object D = CollectionsKt___CollectionsKt.D(peerCertificates());
        X509Certificate x509Certificate = D instanceof X509Certificate ? (X509Certificate) D : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        Iterable<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(peerCertificates, 10));
        for (Certificate name : peerCertificates) {
            arrayList.add(getName(name));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        Iterable<Certificate> iterable = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
        for (Certificate name2 : iterable) {
            arrayList2.add(getName(name2));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return Util.immutableListOf(Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return CollectionsKt__CollectionsKt.f();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final Handshake m271deprecated_get(SSLSession sSLSession) throws IOException {
            Intrinsics.f(sSLSession, "sslSession");
            return get(sSLSession);
        }

        public final Handshake get(SSLSession sSLSession) throws IOException {
            List<Certificate> list;
            Intrinsics.f(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (!(Intrinsics.a(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.a(cipherSuite, "SSL_NULL_WITH_NULL_NULL"))) {
                    CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol == null) {
                        throw new IllegalStateException("tlsVersion == null".toString());
                    } else if (!Intrinsics.a("NONE", protocol)) {
                        TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                        try {
                            list = toImmutableList(sSLSession.getPeerCertificates());
                        } catch (SSLPeerUnverifiedException unused) {
                            list = CollectionsKt__CollectionsKt.f();
                        }
                        return new Handshake(forJavaName2, forJavaName, toImmutableList(sSLSession.getLocalCertificates()), new Handshake$Companion$handshake$1(list));
                    } else {
                        throw new IOException("tlsVersion == NONE");
                    }
                } else {
                    throw new IOException("cipherSuite == " + cipherSuite);
                }
            } else {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
            Intrinsics.f(tlsVersion, "tlsVersion");
            Intrinsics.f(cipherSuite, "cipherSuite");
            Intrinsics.f(list, "peerCertificates");
            Intrinsics.f(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }
}
