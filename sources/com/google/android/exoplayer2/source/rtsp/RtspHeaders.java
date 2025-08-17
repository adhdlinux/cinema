package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.List;
import java.util.Map;

final class RtspHeaders {

    /* renamed from: b  reason: collision with root package name */
    public static final RtspHeaders f26824b = new Builder().e();

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableListMultimap<String, String> f26825a;

    /* access modifiers changed from: private */
    public static String c(String str) {
        if (Ascii.a(str, TheTvdb.HEADER_ACCEPT)) {
            return TheTvdb.HEADER_ACCEPT;
        }
        if (Ascii.a(str, "Allow")) {
            return "Allow";
        }
        if (Ascii.a(str, "Authorization")) {
            return "Authorization";
        }
        if (Ascii.a(str, "Bandwidth")) {
            return "Bandwidth";
        }
        if (Ascii.a(str, "Blocksize")) {
            return "Blocksize";
        }
        if (Ascii.a(str, "Cache-Control")) {
            return "Cache-Control";
        }
        if (Ascii.a(str, "Connection")) {
            return "Connection";
        }
        if (Ascii.a(str, "Content-Base")) {
            return "Content-Base";
        }
        if (Ascii.a(str, "Content-Encoding")) {
            return "Content-Encoding";
        }
        if (Ascii.a(str, "Content-Language")) {
            return "Content-Language";
        }
        if (Ascii.a(str, "Content-Length")) {
            return "Content-Length";
        }
        if (Ascii.a(str, "Content-Location")) {
            return "Content-Location";
        }
        if (Ascii.a(str, TraktV2.HEADER_CONTENT_TYPE)) {
            return TraktV2.HEADER_CONTENT_TYPE;
        }
        if (Ascii.a(str, "CSeq")) {
            return "CSeq";
        }
        if (Ascii.a(str, "Date")) {
            return "Date";
        }
        if (Ascii.a(str, "Expires")) {
            return "Expires";
        }
        if (Ascii.a(str, "Location")) {
            return "Location";
        }
        if (Ascii.a(str, "Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (Ascii.a(str, "Proxy-Require")) {
            return "Proxy-Require";
        }
        if (Ascii.a(str, "Public")) {
            return "Public";
        }
        if (Ascii.a(str, "Range")) {
            return "Range";
        }
        if (Ascii.a(str, "RTP-Info")) {
            return "RTP-Info";
        }
        if (Ascii.a(str, "RTCP-Interval")) {
            return "RTCP-Interval";
        }
        if (Ascii.a(str, "Scale")) {
            return "Scale";
        }
        if (Ascii.a(str, "Session")) {
            return "Session";
        }
        if (Ascii.a(str, "Speed")) {
            return "Speed";
        }
        if (Ascii.a(str, "Supported")) {
            return "Supported";
        }
        if (Ascii.a(str, "Timestamp")) {
            return "Timestamp";
        }
        if (Ascii.a(str, "Transport")) {
            return "Transport";
        }
        if (Ascii.a(str, "User-Agent")) {
            return "User-Agent";
        }
        if (Ascii.a(str, "Via")) {
            return "Via";
        }
        if (Ascii.a(str, "WWW-Authenticate")) {
            return "WWW-Authenticate";
        }
        return str;
    }

    public ImmutableListMultimap<String, String> b() {
        return this.f26825a;
    }

    public String d(String str) {
        ImmutableList<String> e2 = e(str);
        if (e2.isEmpty()) {
            return null;
        }
        return (String) Iterables.d(e2);
    }

    public ImmutableList<String> e(String str) {
        return this.f26825a.o(c(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtspHeaders)) {
            return false;
        }
        return this.f26825a.equals(((RtspHeaders) obj).f26825a);
    }

    public int hashCode() {
        return this.f26825a.hashCode();
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ImmutableListMultimap.Builder<String, String> f26826a;

        public Builder() {
            this.f26826a = new ImmutableListMultimap.Builder<>();
        }

        public Builder b(String str, String str2) {
            this.f26826a.e(RtspHeaders.c(str.trim()), str2.trim());
            return this;
        }

        public Builder c(List<String> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String[] X0 = Util.X0(list.get(i2), ":\\s?");
                if (X0.length == 2) {
                    b(X0[0], X0[1]);
                }
            }
            return this;
        }

        public Builder d(Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                b((String) next.getKey(), (String) next.getValue());
            }
            return this;
        }

        public RtspHeaders e() {
            return new RtspHeaders(this);
        }

        public Builder(String str, String str2, int i2) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i2));
            if (str2 != null) {
                b("Session", str2);
            }
        }
    }

    private RtspHeaders(Builder builder) {
        this.f26825a = builder.f26826a.d();
    }
}
