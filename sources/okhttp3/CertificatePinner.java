package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            Intrinsics.f(str, "pattern");
            Intrinsics.f(strArr, "pins");
            for (String pin : strArr) {
                this.pins.add(new Pin(str, pin));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.d0(this.pins), (CertificateChainCleaner) null, 2, (DefaultConstructorMarker) null);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String pin(Certificate certificate) {
            Intrinsics.f(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).a();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f41331e;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.e(encoded, "publicKey.encoded");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, (Object) null).t();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f41331e;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.e(encoded, "publicKey.encoded");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, (Object) null).u();
        }
    }

    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            boolean z2;
            Intrinsics.f(str, "pattern");
            Intrinsics.f(str2, "pin");
            if ((!StringsKt__StringsJVMKt.G(str, "*.", false, 2, (Object) null) || StringsKt__StringsKt.W(str, "*", 1, false, 4, (Object) null) != -1) && ((!StringsKt__StringsJVMKt.G(str, "**.", false, 2, (Object) null) || StringsKt__StringsKt.W(str, "*", 2, false, 4, (Object) null) != -1) && StringsKt__StringsKt.W(str, "*", 0, false, 6, (Object) null) != -1)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (StringsKt__StringsJVMKt.G(str2, "sha1/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.f41331e;
                        String substring = str2.substring(5);
                        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                        ByteString a2 = companion.a(substring);
                        if (a2 != null) {
                            this.hash = a2;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else if (StringsKt__StringsJVMKt.G(str2, "sha256/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha256";
                        ByteString.Companion companion2 = ByteString.f41331e;
                        String substring2 = str2.substring(7);
                        Intrinsics.e(substring2, "this as java.lang.String).substring(startIndex)");
                        ByteString a3 = companion2.a(substring2);
                        if (a3 != null) {
                            this.hash = a3;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else {
                        throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid pattern: " + str);
                }
            } else {
                throw new IllegalArgumentException(("Unexpected pattern: " + str).toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            if (Intrinsics.a(this.pattern, pin.pattern) && Intrinsics.a(this.hashAlgorithm, pin.hashAlgorithm) && Intrinsics.a(this.hash, pin.hash)) {
                return true;
            }
            return false;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            Intrinsics.f(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (Intrinsics.a(str, "sha256")) {
                return Intrinsics.a(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (Intrinsics.a(str, "sha1")) {
                return Intrinsics.a(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x003f A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean matchesHostname(java.lang.String r12) {
            /*
                r11 = this;
                java.lang.String r0 = "hostname"
                kotlin.jvm.internal.Intrinsics.f(r12, r0)
                java.lang.String r0 = r11.pattern
                java.lang.String r1 = "**."
                r2 = 0
                r3 = 2
                r4 = 0
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.G(r0, r1, r2, r3, r4)
                r1 = 1
                if (r0 == 0) goto L_0x0041
                java.lang.String r0 = r11.pattern
                int r0 = r0.length()
                int r7 = r0 + -3
                int r0 = r12.length()
                int r0 = r0 - r7
                int r3 = r12.length()
                int r4 = r3 - r7
                java.lang.String r5 = r11.pattern
                r6 = 3
                r8 = 0
                r9 = 16
                r10 = 0
                r3 = r12
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.x(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r3 == 0) goto L_0x0082
                if (r0 == 0) goto L_0x003f
                int r0 = r0 - r1
                char r12 = r12.charAt(r0)
                r0 = 46
                if (r12 != r0) goto L_0x0082
            L_0x003f:
                r2 = 1
                goto L_0x0082
            L_0x0041:
                java.lang.String r0 = r11.pattern
                java.lang.String r5 = "*."
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.G(r0, r5, r2, r3, r4)
                if (r0 == 0) goto L_0x007c
                java.lang.String r0 = r11.pattern
                int r0 = r0.length()
                int r7 = r0 + -1
                int r0 = r12.length()
                int r0 = r0 - r7
                int r3 = r12.length()
                int r4 = r3 - r7
                java.lang.String r5 = r11.pattern
                r6 = 1
                r8 = 0
                r9 = 16
                r10 = 0
                r3 = r12
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.x(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r3 == 0) goto L_0x0082
                r5 = 46
                int r6 = r0 + -1
                r7 = 0
                r8 = 4
                r9 = 0
                r4 = r12
                int r12 = kotlin.text.StringsKt__StringsKt.a0(r4, r5, r6, r7, r8, r9)
                r0 = -1
                if (r12 != r0) goto L_0x0082
                goto L_0x003f
            L_0x007c:
                java.lang.String r0 = r11.pattern
                boolean r2 = kotlin.jvm.internal.Intrinsics.a(r12, r0)
            L_0x0082:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.matchesHostname(java.lang.String):boolean");
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner2) {
        Intrinsics.f(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.f(str, "hostname");
        Intrinsics.f(list, "peerCertificates");
        check$okhttp(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void check$okhttp(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics.f(str, "hostname");
        Intrinsics.f(function0, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            List<X509Certificate> list = (List) function0.invoke();
            for (X509Certificate x509Certificate : list) {
                Iterator<Pin> it2 = findMatchingPins.iterator();
                ByteString byteString = null;
                ByteString byteString2 = null;
                while (true) {
                    if (it2.hasNext()) {
                        Pin next = it2.next();
                        String hashAlgorithm = next.getHashAlgorithm();
                        if (Intrinsics.a(hashAlgorithm, "sha256")) {
                            if (byteString == null) {
                                byteString = Companion.sha256Hash(x509Certificate);
                            }
                            if (Intrinsics.a(next.getHash(), byteString)) {
                                return;
                            }
                        } else if (Intrinsics.a(hashAlgorithm, "sha1")) {
                            if (byteString2 == null) {
                                byteString2 = Companion.sha1Hash(x509Certificate);
                            }
                            if (Intrinsics.a(next.getHash(), byteString2)) {
                                return;
                            }
                        } else {
                            throw new AssertionError("unsupported hashAlgorithm: " + next.getHashAlgorithm());
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list) {
                sb.append("\n    ");
                sb.append(Companion.pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            for (Pin append : findMatchingPins) {
                sb.append("\n    ");
                sb.append(append);
            }
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb2);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!Intrinsics.a(certificatePinner.pins, this.pins) || !Intrinsics.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        Intrinsics.f(str, "hostname");
        List<Pin> f2 = CollectionsKt__CollectionsKt.f();
        for (Object next : this.pins) {
            if (((Pin) next).matchesHostname(str)) {
                if (f2.isEmpty()) {
                    f2 = new ArrayList<>();
                }
                Intrinsics.d(f2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                TypeIntrinsics.a(f2).add(next);
            }
        }
        return f2;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i2;
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        if (certificateChainCleaner2 != null) {
            i2 = certificateChainCleaner2.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner2) {
        Intrinsics.f(certificateChainCleaner2, "certificateChainCleaner");
        if (Intrinsics.a(this.certificateChainCleaner, certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        Intrinsics.f(str, "hostname");
        Intrinsics.f(certificateArr, "peerCertificates");
        check(str, (List<? extends Certificate>) ArraysKt___ArraysKt.Q(certificateArr));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i2 & 2) != 0 ? null : certificateChainCleaner2);
    }
}
