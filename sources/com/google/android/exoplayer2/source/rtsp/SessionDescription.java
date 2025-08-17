package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;

final class SessionDescription {

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableMap<String, String> f26933a;

    /* renamed from: b  reason: collision with root package name */
    public final ImmutableList<MediaDescription> f26934b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26935c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26936d;

    /* renamed from: e  reason: collision with root package name */
    public final String f26937e;

    /* renamed from: f  reason: collision with root package name */
    public final int f26938f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f26939g;

    /* renamed from: h  reason: collision with root package name */
    public final String f26940h;

    /* renamed from: i  reason: collision with root package name */
    public final String f26941i;

    /* renamed from: j  reason: collision with root package name */
    public final String f26942j;

    /* renamed from: k  reason: collision with root package name */
    public final String f26943k;

    /* renamed from: l  reason: collision with root package name */
    public final String f26944l;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final HashMap<String, String> f26945a = new HashMap<>();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ImmutableList.Builder<MediaDescription> f26946b = new ImmutableList.Builder<>();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f26947c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f26948d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f26949e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f26950f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public Uri f26951g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f26952h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public String f26953i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f26954j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public String f26955k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public String f26956l;

        public Builder m(String str, String str2) {
            this.f26945a.put(str, str2);
            return this;
        }

        public Builder n(MediaDescription mediaDescription) {
            this.f26946b.d(mediaDescription);
            return this;
        }

        public SessionDescription o() {
            return new SessionDescription(this);
        }

        public Builder p(int i2) {
            this.f26947c = i2;
            return this;
        }

        public Builder q(String str) {
            this.f26952h = str;
            return this;
        }

        public Builder r(String str) {
            this.f26955k = str;
            return this;
        }

        public Builder s(String str) {
            this.f26953i = str;
            return this;
        }

        public Builder t(String str) {
            this.f26949e = str;
            return this;
        }

        public Builder u(String str) {
            this.f26956l = str;
            return this;
        }

        public Builder v(String str) {
            this.f26954j = str;
            return this;
        }

        public Builder w(String str) {
            this.f26948d = str;
            return this;
        }

        public Builder x(String str) {
            this.f26950f = str;
            return this;
        }

        public Builder y(Uri uri) {
            this.f26951g = uri;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SessionDescription.class != obj.getClass()) {
            return false;
        }
        SessionDescription sessionDescription = (SessionDescription) obj;
        if (this.f26938f != sessionDescription.f26938f || !this.f26933a.equals(sessionDescription.f26933a) || !this.f26934b.equals(sessionDescription.f26934b) || !Util.c(this.f26936d, sessionDescription.f26936d) || !Util.c(this.f26935c, sessionDescription.f26935c) || !Util.c(this.f26937e, sessionDescription.f26937e) || !Util.c(this.f26944l, sessionDescription.f26944l) || !Util.c(this.f26939g, sessionDescription.f26939g) || !Util.c(this.f26942j, sessionDescription.f26942j) || !Util.c(this.f26943k, sessionDescription.f26943k) || !Util.c(this.f26940h, sessionDescription.f26940h) || !Util.c(this.f26941i, sessionDescription.f26941i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int hashCode = (((217 + this.f26933a.hashCode()) * 31) + this.f26934b.hashCode()) * 31;
        String str = this.f26936d;
        int i10 = 0;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i11 = (hashCode + i2) * 31;
        String str2 = this.f26935c;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.hashCode();
        }
        int i12 = (i11 + i3) * 31;
        String str3 = this.f26937e;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.hashCode();
        }
        int i13 = (((i12 + i4) * 31) + this.f26938f) * 31;
        String str4 = this.f26944l;
        if (str4 == null) {
            i5 = 0;
        } else {
            i5 = str4.hashCode();
        }
        int i14 = (i13 + i5) * 31;
        Uri uri = this.f26939g;
        if (uri == null) {
            i6 = 0;
        } else {
            i6 = uri.hashCode();
        }
        int i15 = (i14 + i6) * 31;
        String str5 = this.f26942j;
        if (str5 == null) {
            i7 = 0;
        } else {
            i7 = str5.hashCode();
        }
        int i16 = (i15 + i7) * 31;
        String str6 = this.f26943k;
        if (str6 == null) {
            i8 = 0;
        } else {
            i8 = str6.hashCode();
        }
        int i17 = (i16 + i8) * 31;
        String str7 = this.f26940h;
        if (str7 == null) {
            i9 = 0;
        } else {
            i9 = str7.hashCode();
        }
        int i18 = (i17 + i9) * 31;
        String str8 = this.f26941i;
        if (str8 != null) {
            i10 = str8.hashCode();
        }
        return i18 + i10;
    }

    private SessionDescription(Builder builder) {
        this.f26933a = ImmutableMap.d(builder.f26945a);
        this.f26934b = builder.f26946b.k();
        this.f26935c = (String) Util.j(builder.f26948d);
        this.f26936d = (String) Util.j(builder.f26949e);
        this.f26937e = (String) Util.j(builder.f26950f);
        this.f26939g = builder.f26951g;
        this.f26940h = builder.f26952h;
        this.f26938f = builder.f26947c;
        this.f26941i = builder.f26953i;
        this.f26942j = builder.f26955k;
        this.f26943k = builder.f26956l;
        this.f26944l = builder.f26954j;
    }
}
