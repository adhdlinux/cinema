package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        Intrinsics.e(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt__CollectionsKt.f();
            }
            ArrayList arrayList = new ArrayList();
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        if (Intrinsics.a(next.get(0), Integer.valueOf(i2))) {
                            Object obj = next.get(1);
                            if (obj != null) {
                                arrayList.add((String) obj);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt__CollectionsKt.f();
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.b(str, 0, 0, 3, (Object) null));
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        Iterable<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && ((Collection) subjectAltNames).isEmpty()) {
            return false;
        }
        for (String verifyHostname : subjectAltNames) {
            if (INSTANCE.verifyHostname(asciiToLowercase, verifyHostname)) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        Iterable<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && ((Collection) subjectAltNames).isEmpty()) {
            return false;
        }
        for (String canonicalHost2 : subjectAltNames) {
            if (Intrinsics.a(canonicalHost, HostnamesKt.toCanonicalHost(canonicalHost2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        Intrinsics.f(x509Certificate, "certificate");
        return CollectionsKt___CollectionsKt.N(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    public boolean verify(String str, SSLSession sSLSession) {
        Intrinsics.f(str, "host");
        Intrinsics.f(sSLSession, "session");
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            Intrinsics.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        Intrinsics.f(str, "host");
        Intrinsics.f(x509Certificate, "certificate");
        if (Util.canParseAsIpAddress(str)) {
            return verifyIpAddress(str, x509Certificate);
        }
        return verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        String str3;
        String str4 = str;
        String str5 = str2;
        if ((str4 == null || str.length() == 0) || StringsKt__StringsJVMKt.G(str4, ".", false, 2, (Object) null) || StringsKt__StringsJVMKt.s(str4, "..", false, 2, (Object) null)) {
            return false;
        }
        if ((str5 == null || str2.length() == 0) || StringsKt__StringsJVMKt.G(str5, ".", false, 2, (Object) null) || StringsKt__StringsJVMKt.s(str5, "..", false, 2, (Object) null)) {
            return false;
        }
        if (!StringsKt__StringsJVMKt.s(str4, ".", false, 2, (Object) null)) {
            str4 = str4 + '.';
        }
        String str6 = str4;
        if (!StringsKt__StringsJVMKt.s(str5, ".", false, 2, (Object) null)) {
            str3 = str5 + '.';
        } else {
            str3 = str5;
        }
        String asciiToLowercase = asciiToLowercase(str3);
        if (!StringsKt__StringsKt.L(asciiToLowercase, "*", false, 2, (Object) null)) {
            return Intrinsics.a(str6, asciiToLowercase);
        }
        if (!StringsKt__StringsJVMKt.G(asciiToLowercase, "*.", false, 2, (Object) null) || StringsKt__StringsKt.V(asciiToLowercase, '*', 1, false, 4, (Object) null) != -1 || str6.length() < asciiToLowercase.length() || Intrinsics.a("*.", asciiToLowercase)) {
            return false;
        }
        String substring = asciiToLowercase.substring(1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        if (!StringsKt__StringsJVMKt.s(str6, substring, false, 2, (Object) null)) {
            return false;
        }
        int length = str6.length() - substring.length();
        return length <= 0 || StringsKt__StringsKt.a0(str6, '.', length + -1, false, 4, (Object) null) == -1;
    }
}
