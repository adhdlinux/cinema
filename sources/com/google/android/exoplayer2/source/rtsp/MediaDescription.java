package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;

final class MediaDescription {

    /* renamed from: a  reason: collision with root package name */
    public final String f26713a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26714b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26715c;

    /* renamed from: d  reason: collision with root package name */
    public final int f26716d;

    /* renamed from: e  reason: collision with root package name */
    public final int f26717e;

    /* renamed from: f  reason: collision with root package name */
    public final String f26718f;

    /* renamed from: g  reason: collision with root package name */
    public final String f26719g;

    /* renamed from: h  reason: collision with root package name */
    public final String f26720h;

    /* renamed from: i  reason: collision with root package name */
    public final ImmutableMap<String, String> f26721i;

    /* renamed from: j  reason: collision with root package name */
    public final RtpMapAttribute f26722j;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f26723a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f26724b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f26725c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f26726d;

        /* renamed from: e  reason: collision with root package name */
        private final HashMap<String, String> f26727e = new HashMap<>();
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f26728f = -1;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String f26729g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f26730h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public String f26731i;

        public Builder(String str, int i2, String str2, int i3) {
            this.f26723a = str;
            this.f26724b = i2;
            this.f26725c = str2;
            this.f26726d = i3;
        }

        private static String k(int i2, String str, int i3, int i4) {
            return Util.C("%d %s/%d/%d", Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4));
        }

        private static String l(int i2) {
            boolean z2;
            if (i2 < 96) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            if (i2 == 0) {
                return k(0, "PCMU", 8000, 1);
            }
            if (i2 == 8) {
                return k(8, "PCMA", 8000, 1);
            }
            if (i2 == 10) {
                return k(10, "L16", 44100, 2);
            }
            if (i2 == 11) {
                return k(11, "L16", 44100, 1);
            }
            throw new IllegalStateException("Unsupported static paylod type " + i2);
        }

        public Builder i(String str, String str2) {
            this.f26727e.put(str, str2);
            return this;
        }

        public MediaDescription j() {
            RtpMapAttribute rtpMapAttribute;
            try {
                if (this.f26727e.containsKey("rtpmap")) {
                    rtpMapAttribute = RtpMapAttribute.a((String) Util.j(this.f26727e.get("rtpmap")));
                } else {
                    rtpMapAttribute = RtpMapAttribute.a(l(this.f26726d));
                }
                return new MediaDescription(this, ImmutableMap.d(this.f26727e), rtpMapAttribute);
            } catch (ParserException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public Builder m(int i2) {
            this.f26728f = i2;
            return this;
        }

        public Builder n(String str) {
            this.f26730h = str;
            return this;
        }

        public Builder o(String str) {
            this.f26731i = str;
            return this;
        }

        public Builder p(String str) {
            this.f26729g = str;
            return this;
        }
    }

    public static final class RtpMapAttribute {

        /* renamed from: a  reason: collision with root package name */
        public final int f26732a;

        /* renamed from: b  reason: collision with root package name */
        public final String f26733b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26734c;

        /* renamed from: d  reason: collision with root package name */
        public final int f26735d;

        private RtpMapAttribute(int i2, String str, int i3, int i4) {
            this.f26732a = i2;
            this.f26733b = str;
            this.f26734c = i3;
            this.f26735d = i4;
        }

        public static RtpMapAttribute a(String str) throws ParserException {
            boolean z2;
            boolean z3;
            int i2;
            String[] X0 = Util.X0(str, " ");
            if (X0.length == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            int h2 = RtspMessageUtil.h(X0[0]);
            String[] W0 = Util.W0(X0[1].trim(), "/");
            if (W0.length >= 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            int h3 = RtspMessageUtil.h(W0[1]);
            if (W0.length == 3) {
                i2 = RtspMessageUtil.h(W0[2]);
            } else {
                i2 = -1;
            }
            return new RtpMapAttribute(h2, W0[0], h3, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RtpMapAttribute.class != obj.getClass()) {
                return false;
            }
            RtpMapAttribute rtpMapAttribute = (RtpMapAttribute) obj;
            if (this.f26732a == rtpMapAttribute.f26732a && this.f26733b.equals(rtpMapAttribute.f26733b) && this.f26734c == rtpMapAttribute.f26734c && this.f26735d == rtpMapAttribute.f26735d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((217 + this.f26732a) * 31) + this.f26733b.hashCode()) * 31) + this.f26734c) * 31) + this.f26735d;
        }
    }

    public ImmutableMap<String, String> a() {
        boolean z2;
        String str = this.f26721i.get("fmtp");
        if (str == null) {
            return ImmutableMap.k();
        }
        String[] X0 = Util.X0(str, " ");
        if (X0.length == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, str);
        String[] split = X0[1].split(";\\s?", 0);
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        for (String X02 : split) {
            String[] X03 = Util.X0(X02, "=");
            builder.f(X03[0], X03[1]);
        }
        return builder.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaDescription.class != obj.getClass()) {
            return false;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        if (!this.f26713a.equals(mediaDescription.f26713a) || this.f26714b != mediaDescription.f26714b || !this.f26715c.equals(mediaDescription.f26715c) || this.f26716d != mediaDescription.f26716d || this.f26717e != mediaDescription.f26717e || !this.f26721i.equals(mediaDescription.f26721i) || !this.f26722j.equals(mediaDescription.f26722j) || !Util.c(this.f26718f, mediaDescription.f26718f) || !Util.c(this.f26719g, mediaDescription.f26719g) || !Util.c(this.f26720h, mediaDescription.f26720h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        int hashCode = (((((((((((((217 + this.f26713a.hashCode()) * 31) + this.f26714b) * 31) + this.f26715c.hashCode()) * 31) + this.f26716d) * 31) + this.f26717e) * 31) + this.f26721i.hashCode()) * 31) + this.f26722j.hashCode()) * 31;
        String str = this.f26718f;
        int i4 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i5 = (hashCode + i2) * 31;
        String str2 = this.f26719g;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.hashCode();
        }
        int i6 = (i5 + i3) * 31;
        String str3 = this.f26720h;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    private MediaDescription(Builder builder, ImmutableMap<String, String> immutableMap, RtpMapAttribute rtpMapAttribute) {
        this.f26713a = builder.f26723a;
        this.f26714b = builder.f26724b;
        this.f26715c = builder.f26725c;
        this.f26716d = builder.f26726d;
        this.f26718f = builder.f26729g;
        this.f26719g = builder.f26730h;
        this.f26717e = builder.f26728f;
        this.f26720h = builder.f26731i;
        this.f26721i = immutableMap;
        this.f26722j = rtpMapAttribute;
    }
}
