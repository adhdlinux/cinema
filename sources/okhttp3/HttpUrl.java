package okhttp3;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.text.Regex;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    /* access modifiers changed from: private */
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword = "";
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername = "";
        private String host;
        private int port = -1;
        private String scheme;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* access modifiers changed from: private */
            public final int parsePort(String str, int i2, int i3) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, "", false, false, false, false, (Charset) null, 248, (Object) null));
                    boolean z2 = false;
                    if (1 <= parseInt && parseInt < 65536) {
                        z2 = true;
                    }
                    if (z2) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* access modifiers changed from: private */
            public final int portColonOffset(String str, int i2, int i3) {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt == '[') {
                        do {
                            i2++;
                            if (i2 >= i3) {
                                break;
                            }
                        } while (str.charAt(i2) == ']');
                    } else if (charAt == ':') {
                        return i2;
                    }
                    i2++;
                }
                return i3;
            }

            /* access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i2, int i3) {
                boolean z2;
                boolean z3;
                boolean z4;
                boolean z5;
                boolean z6;
                if (i3 - i2 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i2);
                if ((Intrinsics.h(charAt, 97) >= 0 && Intrinsics.h(charAt, 122) <= 0) || (Intrinsics.h(charAt, 65) >= 0 && Intrinsics.h(charAt, 90) <= 0)) {
                    int i4 = i2 + 1;
                    while (i4 < i3) {
                        char charAt2 = str.charAt(i4);
                        boolean z7 = false;
                        if ('a' > charAt2 || charAt2 >= '{') {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2 && ('A' > charAt2 || charAt2 >= '[')) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && ('0' > charAt2 || charAt2 >= ':')) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (!z4 && charAt2 != '+') {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (!z5 && charAt2 != '-') {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z6 || charAt2 == '.') {
                            z7 = true;
                        }
                        if (z7) {
                            i4++;
                        } else if (charAt2 == ':') {
                            return i4;
                        } else {
                            return -1;
                        }
                    }
                }
                return -1;
            }

            /* access modifiers changed from: private */
            public final int slashCount(String str, int i2, int i3) {
                int i4 = 0;
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i4++;
                    i2++;
                }
                return i4;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i2 = this.port;
            if (i2 != -1) {
                return i2;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            Intrinsics.c(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            if (Intrinsics.a(str, ".") || StringsKt__StringsJVMKt.t(str, "%2e", true)) {
                return true;
            }
            return false;
        }

        private final boolean isDotDot(String str) {
            if (Intrinsics.a(str, "..") || StringsKt__StringsJVMKt.t(str, "%2e.", true) || StringsKt__StringsJVMKt.t(str, ".%2e", true) || StringsKt__StringsJVMKt.t(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        private final void pop() {
            boolean z2;
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private final void push(String str, int i2, int i3, boolean z2, boolean z3) {
            boolean z4;
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z3, false, false, false, (Charset) null, 240, (Object) null);
            if (!isDot(canonicalize$okhttp$default)) {
                if (isDotDot(canonicalize$okhttp$default)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).length() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize$okhttp$default);
                } else {
                    this.encodedPathSegments.add(canonicalize$okhttp$default);
                }
                if (z2) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.c(list);
            int size = list.size() - 2;
            int c2 = ProgressionUtilKt.c(size, 0, -2);
            if (c2 <= size) {
                while (true) {
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    Intrinsics.c(list2);
                    if (Intrinsics.a(str, list2.get(size))) {
                        List<String> list3 = this.encodedQueryNamesAndValues;
                        Intrinsics.c(list3);
                        list3.remove(size + 1);
                        List<String> list4 = this.encodedQueryNamesAndValues;
                        Intrinsics.c(list4);
                        list4.remove(size);
                        List<String> list5 = this.encodedQueryNamesAndValues;
                        Intrinsics.c(list5);
                        if (list5.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                    if (size != c2) {
                        size -= 2;
                    } else {
                        return;
                    }
                }
            }
        }

        private final void resolvePath(String str, int i2, int i3) {
            boolean z2;
            if (i2 != i3) {
                char charAt = str.charAt(i2);
                if (charAt == '/' || charAt == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    i2++;
                } else {
                    List<String> list = this.encodedPathSegments;
                    list.set(list.size() - 1, "");
                }
                while (true) {
                    int i4 = i2;
                    while (true) {
                        if (i4 < i3) {
                            i2 = Util.delimiterOffset(str, "/\\", i4, i3);
                            if (i2 < i3) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            push(str, i4, i2, z2, true);
                            if (z2) {
                                i4 = i2 + 1;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            Intrinsics.f(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            Intrinsics.f(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            String str3;
            Intrinsics.f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.c(list2);
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null);
            } else {
                str3 = null;
            }
            list2.add(str3);
            return this;
        }

        public final Builder addPathSegment(String str) {
            Intrinsics.f(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            Intrinsics.f(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            String str3;
            Intrinsics.f(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, (Object) null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.c(list2);
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, (Object) null);
            } else {
                str3 = null;
            }
            list2.add(str3);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.scheme;
            if (str3 != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, (Object) null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, (Object) null);
                String str4 = this.host;
                if (str4 != null) {
                    int effectivePort = effectivePort();
                    Iterable<String> iterable = this.encodedPathSegments;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
                    for (String percentDecode$okhttp$default3 : iterable) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, percentDecode$okhttp$default3, 0, 0, false, 7, (Object) null));
                    }
                    List<String> list = this.encodedQueryNamesAndValues;
                    if (list != null) {
                        Iterable<String> iterable2 = list;
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable2, 10));
                        for (String str5 : iterable2) {
                            if (str5 != null) {
                                str2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, true, 3, (Object) null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str6 = this.encodedFragment;
                    if (str6 != null) {
                        str = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str6, 0, 0, false, 7, (Object) null);
                    } else {
                        str = null;
                    }
                    return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, effectivePort, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, (Charset) null, 179, (Object) null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            Intrinsics.f(str, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder encodedPath(String str) {
            Intrinsics.f(str, "encodedPath");
            if (StringsKt__StringsJVMKt.G(str, "/", false, 2, (Object) null)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + str).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder encodedUsername(String str) {
            Intrinsics.f(str, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, (Charset) null, 187, (Object) null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            Intrinsics.f(str, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, (Object) null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int i2;
            int delimiterOffset;
            char c2;
            int i3;
            String str2;
            boolean z2;
            boolean z3;
            int i4;
            String str3;
            int i5;
            boolean z4;
            String str4 = str;
            Intrinsics.f(str4, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str4, 0, 0, 3, (Object) null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str4, indexOfFirstNonAsciiWhitespace$default, 0, 2, (Object) null);
            Companion companion = Companion;
            int access$schemeDelimiterOffset = companion.schemeDelimiterOffset(str4, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str5 = "this as java.lang.String…ing(startIndex, endIndex)";
            char c3 = 65535;
            if (access$schemeDelimiterOffset != -1) {
                if (StringsKt__StringsJVMKt.D(str4, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = UriUtil.HTTPS_SCHEME;
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (StringsKt__StringsJVMKt.D(str4, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = UriUtil.HTTP_SCHEME;
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str4.substring(0, access$schemeDelimiterOffset);
                    Intrinsics.e(substring, str5);
                    sb.append(substring);
                    sb.append('\'');
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                if (str.length() > 6) {
                    str4 = StringsKt___StringsKt.V0(str4, 6) + "...";
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str4);
            }
            int access$slashCount = companion.slashCount(str4, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c4 = '?';
            char c5 = '#';
            if (access$slashCount >= 2 || httpUrl == null || !Intrinsics.a(httpUrl.scheme(), this.scheme)) {
                int i6 = indexOfFirstNonAsciiWhitespace$default + access$slashCount;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str4, "@/\\?#", i6, indexOfLastNonAsciiWhitespace$default);
                    if (delimiterOffset != indexOfLastNonAsciiWhitespace$default) {
                        c2 = str4.charAt(delimiterOffset);
                    } else {
                        c2 = 65535;
                    }
                    if (c2 == c3 || c2 == c5 || c2 == '/' || c2 == '\\' || c2 == c4) {
                        String str6 = str5;
                        i2 = indexOfLastNonAsciiWhitespace$default;
                        int i7 = delimiterOffset;
                        Companion companion2 = Companion;
                        int access$portColonOffset = companion2.portColonOffset(str4, i6, i7);
                        int i8 = access$portColonOffset + 1;
                    } else if (c2 == '@') {
                        if (!z5) {
                            int delimiterOffset2 = Util.delimiterOffset(str4, ':', i6, delimiterOffset);
                            Companion companion3 = HttpUrl.Companion;
                            String str7 = "%40";
                            int i9 = delimiterOffset;
                            int i10 = delimiterOffset2;
                            i4 = indexOfLastNonAsciiWhitespace$default;
                            String str8 = str5;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion3, str, i6, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                            if (z6) {
                                canonicalize$okhttp$default = this.encodedUsername + str7 + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            int i11 = i9;
                            int i12 = i10;
                            if (i12 != i11) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion3, str, i12 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                z4 = true;
                            } else {
                                z4 = z5;
                            }
                            z5 = z4;
                            str3 = str8;
                            z6 = true;
                            i5 = i11;
                        } else {
                            i4 = indexOfLastNonAsciiWhitespace$default;
                            String str9 = str5;
                            int i13 = delimiterOffset;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            StringBuilder sb3 = sb2;
                            str3 = str9;
                            i5 = i13;
                            sb3.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i6, i13, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null));
                            this.encodedPassword = sb3.toString();
                        }
                        i6 = i5 + 1;
                        str5 = str3;
                        indexOfLastNonAsciiWhitespace$default = i4;
                        c5 = '#';
                        c4 = '?';
                        c3 = 65535;
                    }
                }
                String str62 = str5;
                i2 = indexOfLastNonAsciiWhitespace$default;
                int i72 = delimiterOffset;
                Companion companion22 = Companion;
                int access$portColonOffset2 = companion22.portColonOffset(str4, i6, i72);
                int i82 = access$portColonOffset2 + 1;
                if (i82 < i72) {
                    i3 = i6;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i6, access$portColonOffset2, false, 4, (Object) null));
                    int access$parsePort = companion22.parsePort(str4, i82, i72);
                    this.port = access$parsePort;
                    if (access$parsePort != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        str2 = str62;
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String substring2 = str4.substring(i82, i72);
                        Intrinsics.e(substring2, str62);
                        sb4.append(substring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    i3 = i6;
                    str2 = str62;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i3, access$portColonOffset2, false, 4, (Object) null));
                    String str10 = this.scheme;
                    Intrinsics.c(str10);
                    this.port = companion4.defaultPort(str10);
                }
                if (this.host != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    indexOfFirstNonAsciiWhitespace$default = i72;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String substring3 = str4.substring(i3, access$portColonOffset2);
                    Intrinsics.e(substring3, str2);
                    sb5.append(substring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str4.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i2 = indexOfLastNonAsciiWhitespace$default;
            }
            int i14 = i2;
            int delimiterOffset3 = Util.delimiterOffset(str4, "?#", indexOfFirstNonAsciiWhitespace$default, i14);
            resolvePath(str4, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i14 && str4.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str4, '#', delimiterOffset3, i14);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 208, (Object) null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i14 && str4.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i14, "", true, false, false, true, (Charset) null, 176, (Object) null);
            }
            return this;
        }

        public final Builder password(String str) {
            Intrinsics.f(str, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        public final Builder port(int i2) {
            boolean z2 = false;
            if (1 <= i2 && i2 < 65536) {
                z2 = true;
            }
            if (z2) {
                this.port = i2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i2).toString());
        }

        public final Builder query(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, (Charset) null, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2;
            String str3 = this.host;
            String str4 = null;
            if (str3 != null) {
                str = new Regex("[\"<>^`{|}]").h(str3, "");
            } else {
                str = null;
            }
            this.host = str;
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<String> list = this.encodedPathSegments;
                list.set(i2, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i2), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, (Charset) null, 227, (Object) null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str5 = list2.get(i3);
                    if (str5 != null) {
                        str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str5, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, (Charset) null, 195, (Object) null);
                    } else {
                        str2 = null;
                    }
                    list2.set(i3, str2);
                }
            }
            String str6 = this.encodedFragment;
            if (str6 != null) {
                str4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str6, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, (Charset) null, 163, (Object) null);
            }
            this.encodedFragment = str4;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            Intrinsics.f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            Intrinsics.f(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, (Object) null));
            return this;
        }

        public final Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            Intrinsics.f(str, "scheme");
            if (StringsKt__StringsJVMKt.t(str, UriUtil.HTTP_SCHEME, true)) {
                this.scheme = UriUtil.HTTP_SCHEME;
            } else if (StringsKt__StringsJVMKt.t(str, UriUtil.HTTPS_SCHEME, true)) {
                this.scheme = UriUtil.HTTPS_SCHEME;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i2, String str) {
            boolean z2;
            Intrinsics.f(str, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, (Charset) null, 243, (Object) null);
            this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
            if (isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            Intrinsics.f(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.f(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i2, String str) {
            boolean z2;
            Intrinsics.f(str, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, (Charset) null, 251, (Object) null);
            if (isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setPort$okhttp(int i2) {
            this.port = i2;
        }

        public final Builder setQueryParameter(String str, String str2) {
            Intrinsics.f(str, "name");
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
            if (r1 != false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0091, code lost:
            if (r1 != r3.defaultPort(r2)) goto L_0x0093;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x0012
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L_0x0017
            L_0x0012:
                java.lang.String r1 = "//"
                r0.append(r1)
            L_0x0017:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L_0x0023
                r1 = 1
                goto L_0x0024
            L_0x0023:
                r1 = 0
            L_0x0024:
                r4 = 58
                if (r1 != 0) goto L_0x0035
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0032
                r1 = 1
                goto L_0x0033
            L_0x0032:
                r1 = 0
            L_0x0033:
                if (r1 == 0) goto L_0x0053
            L_0x0035:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0043
                goto L_0x0044
            L_0x0043:
                r2 = 0
            L_0x0044:
                if (r2 == 0) goto L_0x004e
                r0.append(r4)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L_0x004e:
                r1 = 64
                r0.append(r1)
            L_0x0053:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L_0x0077
                kotlin.jvm.internal.Intrinsics.c(r1)
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.K(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L_0x0072
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L_0x0077
            L_0x0072:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L_0x0077:
                int r1 = r6.port
                r2 = -1
                if (r1 != r2) goto L_0x0080
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x0099
            L_0x0080:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.scheme
                if (r2 == 0) goto L_0x0093
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                kotlin.jvm.internal.Intrinsics.c(r2)
                int r2 = r3.defaultPort(r2)
                if (r1 == r2) goto L_0x0099
            L_0x0093:
                r0.append(r4)
                r0.append(r1)
            L_0x0099:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto L_0x00b1
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.Intrinsics.c(r2)
                r1.toQueryString$okhttp(r2, r0)
            L_0x00b1:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto L_0x00bf
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            L_0x00bf:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String str) {
            Intrinsics.f(str, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z2) {
            int i2 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i2, str.length());
                push(str, i2, delimiterOffset, delimiterOffset < str.length(), z2);
                i2 = delimiterOffset + 1;
            } while (i2 <= str.length());
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i4, Object obj) {
            int i5 = i4;
            return companion.canonicalize$okhttp(str, (i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? str.length() : i3, str2, (i5 & 8) != 0 ? false : z2, (i5 & 16) != 0 ? false : z3, (i5 & 32) != 0 ? false : z4, (i5 & 64) != 0 ? false : z5, (i5 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i2, int i3) {
            int i4 = i2 + 2;
            if (i4 >= i3 || str.charAt(i2) != '%' || Util.parseHexDigit(str.charAt(i2 + 1)) == -1 || Util.parseHexDigit(str.charAt(i4)) == -1) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i2, int i3, boolean z2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = str.length();
            }
            if ((i4 & 4) != 0) {
                z2 = false;
            }
            return companion.percentDecode$okhttp(str, i2, i3, z2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
            if (isPercentEncoded(r1, r5, r2) == false) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            L_0x000b:
                if (r5 >= r2) goto L_0x00b9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L_0x0028
                r8 = 9
                if (r7 == r8) goto L_0x0023
                r8 = 10
                if (r7 == r8) goto L_0x0023
                r8 = 12
                if (r7 == r8) goto L_0x0023
                r8 = 13
                if (r7 != r8) goto L_0x0028
            L_0x0023:
                r8 = r14
                r12 = r19
                goto L_0x00b2
            L_0x0028:
                r8 = 43
                if (r7 != r8) goto L_0x0039
                if (r22 == 0) goto L_0x0039
                if (r20 == 0) goto L_0x0033
                java.lang.String r8 = "+"
                goto L_0x0035
            L_0x0033:
                java.lang.String r8 = "%2B"
            L_0x0035:
                r15.w(r8)
                goto L_0x0023
            L_0x0039:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L_0x0069
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L_0x0069
                r8 = 128(0x80, float:1.794E-43)
                if (r7 < r8) goto L_0x0049
                if (r23 == 0) goto L_0x0069
            L_0x0049:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.K(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L_0x0067
                if (r7 != r9) goto L_0x0062
                if (r20 == 0) goto L_0x0067
                if (r21 == 0) goto L_0x0062
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L_0x0063
                goto L_0x006c
            L_0x0062:
                r8 = r14
            L_0x0063:
                r15.M0(r7)
                goto L_0x00b2
            L_0x0067:
                r8 = r14
                goto L_0x006c
            L_0x0069:
                r8 = r14
                r12 = r19
            L_0x006c:
                if (r6 != 0) goto L_0x0073
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L_0x0073:
                if (r3 == 0) goto L_0x0087
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.Intrinsics.a(r3, r10)
                if (r10 == 0) goto L_0x007e
                goto L_0x0087
            L_0x007e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.I0(r1, r5, r10, r3)
                goto L_0x008a
            L_0x0087:
                r6.M0(r7)
            L_0x008a:
                boolean r10 = r6.V()
                if (r10 != 0) goto L_0x00b2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.HttpUrl.HEX_DIGITS
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.HttpUrl.HEX_DIGITS
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L_0x008a
            L_0x00b2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto L_0x000b
            L_0x00b9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i2, int i3, boolean z2) {
            int i4;
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i2 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i4));
                    if (!(parseHexDigit == -1 || parseHexDigit2 == -1)) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i2 = Character.charCount(codePointAt) + i4;
                    }
                } else if (codePointAt == 43 && z2) {
                    buffer.writeByte(32);
                    i2++;
                }
                buffer.M0(codePointAt);
                i2 += Character.charCount(codePointAt);
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m294deprecated_get(String str) {
            Intrinsics.f(str, ImagesContract.URL);
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m297deprecated_parse(String str) {
            Intrinsics.f(str, ImagesContract.URL);
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
            String str3 = str;
            int i4 = i3;
            String str4 = str2;
            Intrinsics.f(str, "<this>");
            Intrinsics.f(str4, "encodeSet");
            int i5 = i2;
            while (i5 < i4) {
                int codePointAt = str.codePointAt(i5);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z5) && !StringsKt__StringsKt.K(str4, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z2) {
                            if (z3) {
                                if (!isPercentEncoded(str, i5, i4)) {
                                    Buffer buffer = new Buffer();
                                    int i6 = i2;
                                    buffer.L0(str, i2, i5);
                                    writeCanonicalized(buffer, str, i5, i3, str2, z2, z3, z4, z5, charset);
                                    return buffer.f0();
                                }
                                if (codePointAt == 43 || !z4) {
                                    i5 += Character.charCount(codePointAt);
                                } else {
                                    Buffer buffer2 = new Buffer();
                                    int i62 = i2;
                                    buffer2.L0(str, i2, i5);
                                    writeCanonicalized(buffer2, str, i5, i3, str2, z2, z3, z4, z5, charset);
                                    return buffer2.f0();
                                }
                            }
                        }
                    }
                    if (codePointAt == 43) {
                    }
                    i5 += Character.charCount(codePointAt);
                }
                Buffer buffer22 = new Buffer();
                int i622 = i2;
                buffer22.L0(str, i2, i5);
                writeCanonicalized(buffer22, str, i5, i3, str2, z2, z3, z4, z5, charset);
                return buffer22.f0();
            }
            int i7 = i2;
            String substring = str.substring(i2, i3);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String str) {
            Intrinsics.f(str, "scheme");
            if (Intrinsics.a(str, UriUtil.HTTP_SCHEME)) {
                return 80;
            }
            if (Intrinsics.a(str, UriUtil.HTTPS_SCHEME)) {
                return 443;
            }
            return -1;
        }

        public final HttpUrl get(String str) {
            Intrinsics.f(str, "<this>");
            return new Builder().parse$okhttp((HttpUrl) null, str).build();
        }

        public final HttpUrl parse(String str) {
            Intrinsics.f(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i2, int i3, boolean z2) {
            Intrinsics.f(str, "<this>");
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z2)) {
                    Buffer buffer = new Buffer();
                    buffer.L0(str, i2, i4);
                    writePercentDecoded(buffer, str, i4, i3, z2);
                    return buffer.f0();
                }
            }
            String substring = str.substring(i2, i3);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb) {
            Intrinsics.f(list, "<this>");
            Intrinsics.f(sb, "out");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            Intrinsics.f(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int V = StringsKt__StringsKt.V(str, '&', i2, false, 4, (Object) null);
                if (V == -1) {
                    V = str.length();
                }
                int i3 = V;
                int V2 = StringsKt__StringsKt.V(str, '=', i2, false, 4, (Object) null);
                if (V2 == -1 || V2 > i3) {
                    String substring = str.substring(i2, i3);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add((Object) null);
                } else {
                    String substring2 = str.substring(i2, V2);
                    Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(V2 + 1, i3);
                    Intrinsics.e(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i2 = i3 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb) {
            Intrinsics.f(list, "<this>");
            Intrinsics.f(sb, "out");
            IntProgression i2 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, list.size()), 2);
            int a2 = i2.a();
            int b2 = i2.b();
            int d2 = i2.d();
            if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
                while (true) {
                    String str = list.get(a2);
                    String str2 = list.get(a2 + 1);
                    if (a2 > 0) {
                        sb.append('&');
                    }
                    sb.append(str);
                    if (str2 != null) {
                        sb.append('=');
                        sb.append(str2);
                    }
                    if (a2 != b2) {
                        a2 += d2;
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m296deprecated_get(URL url) {
            Intrinsics.f(url, ImagesContract.URL);
            return get(url);
        }

        public final HttpUrl get(URL url) {
            Intrinsics.f(url, "<this>");
            String url2 = url.toString();
            Intrinsics.e(url2, "toString()");
            return parse(url2);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m295deprecated_get(URI uri) {
            Intrinsics.f(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            Intrinsics.f(uri, "<this>");
            String uri2 = uri.toString();
            Intrinsics.e(uri2, "toString()");
            return parse(uri2);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i2, List<String> list, List<String> list2, String str5, String str6) {
        Intrinsics.f(str, "scheme");
        Intrinsics.f(str2, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);
        Intrinsics.f(str3, "password");
        Intrinsics.f(str4, "host");
        Intrinsics.f(list, "pathSegments");
        Intrinsics.f(str6, ImagesContract.URL);
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i2;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = Intrinsics.a(str, UriUtil.HTTPS_SCHEME);
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url2) {
        return Companion.get(url2);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m275deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m276deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m277deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m278deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m279deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m280deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m281deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m282deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m283deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m284deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m285deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m286deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m287deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m288deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m289deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m290deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m291deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m292deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m293deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt__StringsKt.V(this.url, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        boolean z2;
        if (this.password.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "";
        }
        int V = StringsKt__StringsKt.V(this.url, '@', 0, false, 6, (Object) null);
        String substring = this.url.substring(StringsKt__StringsKt.V(this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, V);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int V = StringsKt__StringsKt.V(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String substring = this.url.substring(V, Util.delimiterOffset(str, "?#", V, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int V = StringsKt__StringsKt.V(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", V, str.length());
        ArrayList arrayList = new ArrayList();
        while (V < delimiterOffset) {
            int i2 = V + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i2, delimiterOffset);
            String substring = this.url.substring(i2, delimiterOffset2);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            V = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int V = StringsKt__StringsKt.V(this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String substring = this.url.substring(V, Util.delimiterOffset(str, '#', V, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        boolean z2;
        if (this.username.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String str) {
        Intrinsics.f(str, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        IntProgression i2 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, list.size()), 2);
        int a2 = i2.a();
        int b2 = i2.b();
        int d2 = i2.d();
        if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
            while (!Intrinsics.a(str, this.queryNamesAndValues.get(a2))) {
                if (a2 != b2) {
                    a2 += d2;
                }
            }
            return this.queryNamesAndValues.get(a2 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i2 * 2);
            Intrinsics.c(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt__SetsKt.b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        IntProgression i2 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, this.queryNamesAndValues.size()), 2);
        int a2 = i2.a();
        int b2 = i2.b();
        int d2 = i2.d();
        if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
            while (true) {
                String str = this.queryNamesAndValues.get(a2);
                Intrinsics.c(str);
                linkedHashSet.add(str);
                if (a2 == b2) {
                    break;
                }
                a2 += d2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.e(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        Intrinsics.f(str, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt__CollectionsKt.f();
        }
        ArrayList arrayList = new ArrayList();
        IntProgression i2 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, this.queryNamesAndValues.size()), 2);
        int a2 = i2.a();
        int b2 = i2.b();
        int d2 = i2.d();
        if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
            while (true) {
                if (Intrinsics.a(str, this.queryNamesAndValues.get(a2))) {
                    arrayList.add(this.queryNamesAndValues.get(a2 + 1));
                }
                if (a2 == b2) {
                    break;
                }
                a2 += d2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.e(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.c(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        Intrinsics.f(str, "link");
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").h(builder, ""));
                Intrinsics.e(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String username() {
        return this.username;
    }

    public final Builder newBuilder(String str) {
        Intrinsics.f(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
