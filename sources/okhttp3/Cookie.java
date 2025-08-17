package okhttp3;

import b0.y;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.model.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Cookie {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        private String domain;
        private long expiresAt = DatesKt.MAX_DATE;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path = "/";
        private boolean persistent;
        private boolean secure;
        private String value;

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j2 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j2, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        public final Builder domain(String str) {
            Intrinsics.f(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j2) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            if (j2 > DatesKt.MAX_DATE) {
                j2 = 253402300799999L;
            }
            this.expiresAt = j2;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            Intrinsics.f(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            Intrinsics.f(str, "name");
            if (Intrinsics.a(StringsKt__StringsKt.N0(str).toString(), str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String str) {
            Intrinsics.f(str, "path");
            if (StringsKt__StringsJVMKt.G(str, "/", false, 2, (Object) null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (Intrinsics.a(StringsKt__StringsKt.N0(str).toString(), str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z2) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z2;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
            if (r0 != ':') goto L_0x003e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int dateCharacterOffset(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L_0x0000:
                if (r7 >= r8) goto L_0x0046
                char r0 = r6.charAt(r7)
                r1 = 32
                r2 = 1
                if (r0 >= r1) goto L_0x000f
                r1 = 9
                if (r0 != r1) goto L_0x003d
            L_0x000f:
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L_0x003d
                r1 = 48
                r3 = 58
                r4 = 0
                if (r1 > r0) goto L_0x001e
                if (r0 >= r3) goto L_0x001e
                r1 = 1
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r1 != 0) goto L_0x003d
                r1 = 97
                if (r1 > r0) goto L_0x002b
                r1 = 123(0x7b, float:1.72E-43)
                if (r0 >= r1) goto L_0x002b
                r1 = 1
                goto L_0x002c
            L_0x002b:
                r1 = 0
            L_0x002c:
                if (r1 != 0) goto L_0x003d
                r1 = 65
                if (r1 > r0) goto L_0x0038
                r1 = 91
                if (r0 >= r1) goto L_0x0038
                r1 = 1
                goto L_0x0039
            L_0x0038:
                r1 = 0
            L_0x0039:
                if (r1 != 0) goto L_0x003d
                if (r0 != r3) goto L_0x003e
            L_0x003d:
                r4 = 1
            L_0x003e:
                r0 = r9 ^ 1
                if (r4 != r0) goto L_0x0043
                return r7
            L_0x0043:
                int r7 = r7 + 1
                goto L_0x0000
            L_0x0046:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.a(str, str2)) {
                return true;
            }
            if (!StringsKt__StringsJVMKt.s(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.canParseAsIpAddress(str)) {
                return false;
            }
            return true;
        }

        private final String parseDomain(String str) {
            if (!StringsKt__StringsJVMKt.s(str, ".", false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.m0(str, "."));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i2, int i3) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            String str2 = str;
            int i4 = i3;
            int dateCharacterOffset = dateCharacterOffset(str2, i2, i4, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            while (dateCharacterOffset < i4) {
                int dateCharacterOffset2 = dateCharacterOffset(str2, dateCharacterOffset + 1, i4, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i6 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.e(group, "matcher.group(1)");
                    i6 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.e(group2, "matcher.group(2)");
                    i9 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.e(group3, "matcher.group(3)");
                    i10 = Integer.parseInt(group3);
                } else if (i7 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.e(group4, "matcher.group(1)");
                    i7 = Integer.parseInt(group4);
                } else if (i8 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.e(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.e(locale, "US");
                    String lowerCase = group5.toLowerCase(locale);
                    Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.e(pattern, "MONTH_PATTERN.pattern()");
                    i8 = StringsKt__StringsKt.W(pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i5 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.e(group6, "matcher.group(1)");
                    i5 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str2, dateCharacterOffset2 + 1, i4, false);
            }
            if (70 > i5 || i5 >= 100) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                i5 += 1900;
            }
            if (i5 < 0 || i5 >= 70) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                i5 += 2000;
            }
            if (i5 >= 1601) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (i8 != -1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    if (1 > i7 || i7 >= 32) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (z6) {
                        if (i6 < 0 || i6 >= 24) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z7) {
                            if (i9 < 0 || i9 >= 60) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            if (z8) {
                                if (i10 < 0 || i10 >= 60) {
                                    z9 = false;
                                } else {
                                    z9 = true;
                                }
                                if (z9) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i5);
                                    gregorianCalendar.set(2, i8 - 1);
                                    gregorianCalendar.set(5, i7);
                                    gregorianCalendar.set(11, i6);
                                    gregorianCalendar.set(12, i9);
                                    gregorianCalendar.set(13, i10);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e2) {
                if (!new Regex("-?\\d+").g(str)) {
                    throw e2;
                } else if (StringsKt__StringsJVMKt.G(str, "-", false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return Clock.MAX_TIME;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.a(encodedPath, str)) {
                return true;
            }
            if (!StringsKt__StringsJVMKt.G(encodedPath, str, false, 2, (Object) null) || (!StringsKt__StringsJVMKt.s(str, "/", false, 2, (Object) null) && encodedPath.charAt(str.length()) != '/')) {
                return false;
            }
            return true;
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            Intrinsics.f(httpUrl, ImagesContract.URL);
            Intrinsics.f(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0103, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L_0x010b;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0115  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0138 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0139  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r26, okhttp3.HttpUrl r28, java.lang.String r29) {
            /*
                r25 = this;
                r0 = r25
                r7 = r29
                java.lang.String r1 = "url"
                r8 = r28
                kotlin.jvm.internal.Intrinsics.f(r8, r1)
                java.lang.String r1 = "setCookie"
                kotlin.jvm.internal.Intrinsics.f(r7, r1)
                r2 = 59
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                r1 = r29
                int r9 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 61
                r5 = 2
                r4 = r9
                int r1 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 0
                if (r1 != r9) goto L_0x0028
                return r2
            L_0x0028:
                r3 = 0
                r4 = 1
                java.lang.String r11 = okhttp3.internal.Util.trimSubstring$default(r7, r3, r1, r4, r2)
                int r5 = r11.length()
                if (r5 != 0) goto L_0x0036
                r5 = 1
                goto L_0x0037
            L_0x0036:
                r5 = 0
            L_0x0037:
                if (r5 != 0) goto L_0x016f
                int r5 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
                r6 = -1
                if (r5 == r6) goto L_0x0042
                goto L_0x016f
            L_0x0042:
                int r1 = r1 + r4
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r7, r1, r9)
                int r1 = okhttp3.internal.Util.indexOfControlOrNonAscii(r12)
                if (r1 == r6) goto L_0x004e
                return r2
            L_0x004e:
                int r9 = r9 + r4
                int r1 = r29.length()
                r5 = -1
                r10 = r2
                r22 = r10
                r15 = r5
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 1
                r23 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0066:
                if (r9 >= r1) goto L_0x00d6
                r2 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r2, (int) r9, (int) r1)
                r13 = 61
                int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r13, (int) r9, (int) r2)
                java.lang.String r9 = okhttp3.internal.Util.trimSubstring(r7, r9, r13)
                if (r13 >= r2) goto L_0x0081
                int r13 = r13 + 1
                java.lang.String r13 = okhttp3.internal.Util.trimSubstring(r7, r13, r2)
                goto L_0x0083
            L_0x0081:
                java.lang.String r13 = ""
            L_0x0083:
                java.lang.String r14 = "expires"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r14, r4)
                if (r14 == 0) goto L_0x0094
                int r9 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00d2 }
                long r23 = r0.parseExpires(r13, r3, r9)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                goto L_0x00a0
            L_0x0094:
                java.lang.String r14 = "max-age"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00a3
                long r15 = r0.parseMaxAge(r13)     // Catch:{  }
            L_0x00a0:
                r19 = 1
                goto L_0x00d2
            L_0x00a3:
                java.lang.String r14 = "domain"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00b2
                java.lang.String r10 = r0.parseDomain(r13)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                r20 = 0
                goto L_0x00d2
            L_0x00b2:
                java.lang.String r14 = "path"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00bd
                r22 = r13
                goto L_0x00d2
            L_0x00bd:
                java.lang.String r13 = "secure"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r13, r4)
                if (r13 == 0) goto L_0x00c8
                r17 = 1
                goto L_0x00d2
            L_0x00c8:
                java.lang.String r13 = "httponly"
                boolean r9 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r13, r4)
                if (r9 == 0) goto L_0x00d2
                r18 = 1
            L_0x00d2:
                int r9 = r2 + 1
                r2 = 0
                goto L_0x0066
            L_0x00d6:
                r1 = -9223372036854775808
                int r4 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x00de
            L_0x00dc:
                r13 = r1
                goto L_0x010f
            L_0x00de:
                int r1 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x010d
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r4 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r4 > 0) goto L_0x00f1
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r15 = r15 * r1
                goto L_0x00f6
            L_0x00f1:
                r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00f6:
                long r1 = r26 + r15
                int r4 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
                if (r4 < 0) goto L_0x0106
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00dc
                goto L_0x010b
            L_0x0106:
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x010b:
                r13 = r4
                goto L_0x010f
            L_0x010d:
                r13 = r23
            L_0x010f:
                java.lang.String r1 = r28.host()
                if (r10 != 0) goto L_0x0118
                r15 = r1
                r2 = 0
                goto L_0x0122
            L_0x0118:
                boolean r2 = r0.domainMatch(r1, r10)
                if (r2 != 0) goto L_0x0120
                r2 = 0
                return r2
            L_0x0120:
                r2 = 0
                r15 = r10
            L_0x0122:
                int r1 = r1.length()
                int r4 = r15.length()
                if (r1 == r4) goto L_0x0139
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.get()
                java.lang.String r1 = r1.getEffectiveTldPlusOne(r15)
                if (r1 != 0) goto L_0x0139
                return r2
            L_0x0139:
                java.lang.String r1 = "/"
                r4 = r22
                if (r4 == 0) goto L_0x014a
                r5 = 2
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.G(r4, r1, r3, r5, r2)
                if (r2 != 0) goto L_0x0147
                goto L_0x014a
            L_0x0147:
                r16 = r4
                goto L_0x0166
            L_0x014a:
                java.lang.String r2 = r28.encodedPath()
                r6 = 47
                r7 = 0
                r8 = 0
                r9 = 6
                r10 = 0
                r5 = r2
                int r4 = kotlin.text.StringsKt__StringsKt.a0(r5, r6, r7, r8, r9, r10)
                if (r4 == 0) goto L_0x0164
                java.lang.String r1 = r2.substring(r3, r4)
                java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.e(r1, r2)
            L_0x0164:
                r16 = r1
            L_0x0166:
                okhttp3.Cookie r1 = new okhttp3.Cookie
                r21 = 0
                r10 = r1
                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
                return r1
            L_0x016f:
                r1 = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            Intrinsics.f(httpUrl, ImagesContract.URL);
            Intrinsics.f(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Cookie parse = parse(httpUrl, values.get(i2));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList == null) {
                return CollectionsKt__CollectionsKt.f();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.e(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }

    private Cookie(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j2;
        this.domain = str3;
        this.path = str4;
        this.secure = z2;
        this.httpOnly = z3;
        this.persistent = z4;
        this.hostOnly = z5;
    }

    public /* synthetic */ Cookie(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j2, str3, str4, z2, z3, z4, z5);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m254deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m255deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m256deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m257deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m258deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m259deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m260deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m261deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m262deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics.a(cookie.name, this.name) && Intrinsics.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.a(cookie.domain, this.domain) && Intrinsics.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + y.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + a.a(this.secure)) * 31) + a.a(this.httpOnly)) * 31) + a.a(this.persistent)) * 31) + a.a(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z2;
        Intrinsics.f(httpUrl, ImagesContract.URL);
        if (this.hostOnly) {
            z2 = Intrinsics.a(httpUrl.host(), this.domain);
        } else {
            z2 = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z2 || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "toString()");
        return sb2;
    }

    public final String value() {
        return this.value;
    }
}
