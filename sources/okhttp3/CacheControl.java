package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CacheControl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j2) {
            if (j2 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j2;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, (String) null, (DefaultConstructorMarker) null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i2, TimeUnit timeUnit) {
            boolean z2;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds((long) i2));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i2).toString());
        }

        public final Builder maxStale(int i2, TimeUnit timeUnit) {
            boolean z2;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds((long) i2));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i2).toString());
        }

        public final Builder minFresh(int i2, TimeUnit timeUnit) {
            boolean z2;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds((long) i2));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i2).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i2) {
            int length = str.length();
            while (i2 < length) {
                if (StringsKt__StringsKt.K(str2, str.charAt(i2), false, 2, (Object) null)) {
                    return i2;
                }
                i2++;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.indexOfElement(str, str2, i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.CacheControl parse(okhttp3.Headers r31) {
            /*
                r30 = this;
                r0 = r30
                r1 = r31
                java.lang.String r2 = "headers"
                kotlin.jvm.internal.Intrinsics.f(r1, r2)
                int r2 = r31.size()
                r5 = 1
                r7 = 0
                r8 = 1
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = -1
                r13 = -1
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = -1
                r18 = -1
                r19 = 0
                r20 = 0
                r21 = 0
            L_0x0023:
                if (r7 >= r2) goto L_0x0197
                java.lang.String r3 = r1.name(r7)
                java.lang.String r6 = r1.value(r7)
                java.lang.String r4 = "Cache-Control"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r3, r4, r5)
                if (r4 == 0) goto L_0x003a
                if (r9 == 0) goto L_0x0038
                goto L_0x0042
            L_0x0038:
                r9 = r6
                goto L_0x0043
            L_0x003a:
                java.lang.String r4 = "Pragma"
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.t(r3, r4, r5)
                if (r3 == 0) goto L_0x018c
            L_0x0042:
                r8 = 0
            L_0x0043:
                r3 = 0
            L_0x0044:
                int r4 = r6.length()
                if (r3 >= r4) goto L_0x018c
                java.lang.String r4 = "=,;"
                int r4 = r0.indexOfElement(r6, r4, r3)
                java.lang.String r3 = r6.substring(r3, r4)
                java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.e(r3, r5)
                java.lang.CharSequence r3 = kotlin.text.StringsKt__StringsKt.N0(r3)
                java.lang.String r3 = r3.toString()
                int r1 = r6.length()
                if (r4 == r1) goto L_0x00c0
                char r1 = r6.charAt(r4)
                r29 = r2
                r2 = 44
                if (r1 == r2) goto L_0x00c2
                char r1 = r6.charAt(r4)
                r2 = 59
                if (r1 != r2) goto L_0x007a
                goto L_0x00c2
            L_0x007a:
                int r4 = r4 + 1
                int r1 = okhttp3.internal.Util.indexOfNonWhitespace(r6, r4)
                int r2 = r6.length()
                if (r1 >= r2) goto L_0x00aa
                char r2 = r6.charAt(r1)
                r4 = 34
                if (r2 != r4) goto L_0x00aa
                int r1 = r1 + 1
                r24 = 34
                r26 = 0
                r27 = 4
                r28 = 0
                r23 = r6
                r25 = r1
                int r2 = kotlin.text.StringsKt__StringsKt.V(r23, r24, r25, r26, r27, r28)
                java.lang.String r1 = r6.substring(r1, r2)
                kotlin.jvm.internal.Intrinsics.e(r1, r5)
                r4 = 1
                int r2 = r2 + r4
                goto L_0x00c6
            L_0x00aa:
                java.lang.String r2 = ",;"
                int r2 = r0.indexOfElement(r6, r2, r1)
                java.lang.String r1 = r6.substring(r1, r2)
                kotlin.jvm.internal.Intrinsics.e(r1, r5)
                java.lang.CharSequence r1 = kotlin.text.StringsKt__StringsKt.N0(r1)
                java.lang.String r1 = r1.toString()
                goto L_0x00c6
            L_0x00c0:
                r29 = r2
            L_0x00c2:
                int r4 = r4 + 1
                r2 = r4
                r1 = 0
            L_0x00c6:
                java.lang.String r4 = "no-cache"
                r5 = 1
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x00d7
                r1 = r31
                r3 = r2
                r2 = r29
                r10 = 1
                goto L_0x0044
            L_0x00d7:
                java.lang.String r4 = "no-store"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x00e7
                r1 = r31
                r3 = r2
                r2 = r29
                r11 = 1
                goto L_0x0044
            L_0x00e7:
                java.lang.String r4 = "max-age"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x00fb
                r4 = -1
                int r12 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
            L_0x00f4:
                r1 = r31
                r3 = r2
                r2 = r29
                goto L_0x0044
            L_0x00fb:
                java.lang.String r4 = "s-maxage"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x0109
                r4 = -1
                int r13 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                goto L_0x00f4
            L_0x0109:
                java.lang.String r4 = "private"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x0119
                r1 = r31
                r3 = r2
                r2 = r29
                r14 = 1
                goto L_0x0044
            L_0x0119:
                java.lang.String r4 = "public"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x0129
                r1 = r31
                r3 = r2
                r2 = r29
                r15 = 1
                goto L_0x0044
            L_0x0129:
                java.lang.String r4 = "must-revalidate"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x013a
                r1 = r31
                r3 = r2
                r2 = r29
                r16 = 1
                goto L_0x0044
            L_0x013a:
                java.lang.String r4 = "max-stale"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x014a
                r3 = 2147483647(0x7fffffff, float:NaN)
                int r17 = okhttp3.internal.Util.toNonNegativeInt(r1, r3)
                goto L_0x00f4
            L_0x014a:
                java.lang.String r4 = "min-fresh"
                boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r3, r5)
                if (r4 == 0) goto L_0x0158
                r4 = -1
                int r18 = okhttp3.internal.Util.toNonNegativeInt(r1, r4)
                goto L_0x00f4
            L_0x0158:
                r4 = -1
                java.lang.String r1 = "only-if-cached"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.t(r1, r3, r5)
                if (r1 == 0) goto L_0x016a
                r1 = r31
                r3 = r2
                r2 = r29
                r19 = 1
                goto L_0x0044
            L_0x016a:
                java.lang.String r1 = "no-transform"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.t(r1, r3, r5)
                if (r1 == 0) goto L_0x017b
                r1 = r31
                r3 = r2
                r2 = r29
                r20 = 1
                goto L_0x0044
            L_0x017b:
                java.lang.String r1 = "immutable"
                boolean r1 = kotlin.text.StringsKt__StringsJVMKt.t(r1, r3, r5)
                if (r1 == 0) goto L_0x00f4
                r1 = r31
                r3 = r2
                r2 = r29
                r21 = 1
                goto L_0x0044
            L_0x018c:
                r29 = r2
                r4 = -1
                int r7 = r7 + 1
                r1 = r31
                r2 = r29
                goto L_0x0023
            L_0x0197:
                if (r8 != 0) goto L_0x019c
                r22 = 0
                goto L_0x019e
            L_0x019c:
                r22 = r9
            L_0x019e:
                okhttp3.CacheControl r1 = new okhttp3.CacheControl
                r23 = 0
                r9 = r1
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    private CacheControl(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str) {
        this.noCache = z2;
        this.noStore = z3;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i3;
        this.isPrivate = z4;
        this.isPublic = z5;
        this.mustRevalidate = z6;
        this.maxStaleSeconds = i4;
        this.minFreshSeconds = i5;
        this.onlyIfCached = z7;
        this.noTransform = z8;
        this.immutable = z9;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z2, boolean z3, int i2, int i3, boolean z4, boolean z5, boolean z6, int i4, int i5, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, i2, i3, z4, z5, z6, i4, i5, z7, z8, z9, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m236deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m237deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m238deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m239deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m240deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m241deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m242deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m243deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m244deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m245deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        boolean z2;
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = sb2;
        return sb2;
    }
}
