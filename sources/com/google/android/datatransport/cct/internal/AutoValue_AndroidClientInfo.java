package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class AutoValue_AndroidClientInfo extends AndroidClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f22326a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22327b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22328c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22329d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22330e;

    /* renamed from: f  reason: collision with root package name */
    private final String f22331f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22332g;

    /* renamed from: h  reason: collision with root package name */
    private final String f22333h;

    /* renamed from: i  reason: collision with root package name */
    private final String f22334i;

    /* renamed from: j  reason: collision with root package name */
    private final String f22335j;

    /* renamed from: k  reason: collision with root package name */
    private final String f22336k;

    /* renamed from: l  reason: collision with root package name */
    private final String f22337l;

    static final class Builder extends AndroidClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f22338a;

        /* renamed from: b  reason: collision with root package name */
        private String f22339b;

        /* renamed from: c  reason: collision with root package name */
        private String f22340c;

        /* renamed from: d  reason: collision with root package name */
        private String f22341d;

        /* renamed from: e  reason: collision with root package name */
        private String f22342e;

        /* renamed from: f  reason: collision with root package name */
        private String f22343f;

        /* renamed from: g  reason: collision with root package name */
        private String f22344g;

        /* renamed from: h  reason: collision with root package name */
        private String f22345h;

        /* renamed from: i  reason: collision with root package name */
        private String f22346i;

        /* renamed from: j  reason: collision with root package name */
        private String f22347j;

        /* renamed from: k  reason: collision with root package name */
        private String f22348k;

        /* renamed from: l  reason: collision with root package name */
        private String f22349l;

        Builder() {
        }

        public AndroidClientInfo a() {
            return new AutoValue_AndroidClientInfo(this.f22338a, this.f22339b, this.f22340c, this.f22341d, this.f22342e, this.f22343f, this.f22344g, this.f22345h, this.f22346i, this.f22347j, this.f22348k, this.f22349l);
        }

        public AndroidClientInfo.Builder b(String str) {
            this.f22349l = str;
            return this;
        }

        public AndroidClientInfo.Builder c(String str) {
            this.f22347j = str;
            return this;
        }

        public AndroidClientInfo.Builder d(String str) {
            this.f22341d = str;
            return this;
        }

        public AndroidClientInfo.Builder e(String str) {
            this.f22345h = str;
            return this;
        }

        public AndroidClientInfo.Builder f(String str) {
            this.f22340c = str;
            return this;
        }

        public AndroidClientInfo.Builder g(String str) {
            this.f22346i = str;
            return this;
        }

        public AndroidClientInfo.Builder h(String str) {
            this.f22344g = str;
            return this;
        }

        public AndroidClientInfo.Builder i(String str) {
            this.f22348k = str;
            return this;
        }

        public AndroidClientInfo.Builder j(String str) {
            this.f22339b = str;
            return this;
        }

        public AndroidClientInfo.Builder k(String str) {
            this.f22343f = str;
            return this;
        }

        public AndroidClientInfo.Builder l(String str) {
            this.f22342e = str;
            return this;
        }

        public AndroidClientInfo.Builder m(Integer num) {
            this.f22338a = num;
            return this;
        }
    }

    public String b() {
        return this.f22337l;
    }

    public String c() {
        return this.f22335j;
    }

    public String d() {
        return this.f22329d;
    }

    public String e() {
        return this.f22333h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f22326a;
        if (num != null ? num.equals(androidClientInfo.m()) : androidClientInfo.m() == null) {
            String str = this.f22327b;
            if (str != null ? str.equals(androidClientInfo.j()) : androidClientInfo.j() == null) {
                String str2 = this.f22328c;
                if (str2 != null ? str2.equals(androidClientInfo.f()) : androidClientInfo.f() == null) {
                    String str3 = this.f22329d;
                    if (str3 != null ? str3.equals(androidClientInfo.d()) : androidClientInfo.d() == null) {
                        String str4 = this.f22330e;
                        if (str4 != null ? str4.equals(androidClientInfo.l()) : androidClientInfo.l() == null) {
                            String str5 = this.f22331f;
                            if (str5 != null ? str5.equals(androidClientInfo.k()) : androidClientInfo.k() == null) {
                                String str6 = this.f22332g;
                                if (str6 != null ? str6.equals(androidClientInfo.h()) : androidClientInfo.h() == null) {
                                    String str7 = this.f22333h;
                                    if (str7 != null ? str7.equals(androidClientInfo.e()) : androidClientInfo.e() == null) {
                                        String str8 = this.f22334i;
                                        if (str8 != null ? str8.equals(androidClientInfo.g()) : androidClientInfo.g() == null) {
                                            String str9 = this.f22335j;
                                            if (str9 != null ? str9.equals(androidClientInfo.c()) : androidClientInfo.c() == null) {
                                                String str10 = this.f22336k;
                                                if (str10 != null ? str10.equals(androidClientInfo.i()) : androidClientInfo.i() == null) {
                                                    String str11 = this.f22337l;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f22328c;
    }

    public String g() {
        return this.f22334i;
    }

    public String h() {
        return this.f22332g;
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
        int i10;
        int i11;
        int i12;
        Integer num = this.f22326a;
        int i13 = 0;
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.hashCode();
        }
        int i14 = (i2 ^ 1000003) * 1000003;
        String str = this.f22327b;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        int i15 = (i14 ^ i3) * 1000003;
        String str2 = this.f22328c;
        if (str2 == null) {
            i4 = 0;
        } else {
            i4 = str2.hashCode();
        }
        int i16 = (i15 ^ i4) * 1000003;
        String str3 = this.f22329d;
        if (str3 == null) {
            i5 = 0;
        } else {
            i5 = str3.hashCode();
        }
        int i17 = (i16 ^ i5) * 1000003;
        String str4 = this.f22330e;
        if (str4 == null) {
            i6 = 0;
        } else {
            i6 = str4.hashCode();
        }
        int i18 = (i17 ^ i6) * 1000003;
        String str5 = this.f22331f;
        if (str5 == null) {
            i7 = 0;
        } else {
            i7 = str5.hashCode();
        }
        int i19 = (i18 ^ i7) * 1000003;
        String str6 = this.f22332g;
        if (str6 == null) {
            i8 = 0;
        } else {
            i8 = str6.hashCode();
        }
        int i20 = (i19 ^ i8) * 1000003;
        String str7 = this.f22333h;
        if (str7 == null) {
            i9 = 0;
        } else {
            i9 = str7.hashCode();
        }
        int i21 = (i20 ^ i9) * 1000003;
        String str8 = this.f22334i;
        if (str8 == null) {
            i10 = 0;
        } else {
            i10 = str8.hashCode();
        }
        int i22 = (i21 ^ i10) * 1000003;
        String str9 = this.f22335j;
        if (str9 == null) {
            i11 = 0;
        } else {
            i11 = str9.hashCode();
        }
        int i23 = (i22 ^ i11) * 1000003;
        String str10 = this.f22336k;
        if (str10 == null) {
            i12 = 0;
        } else {
            i12 = str10.hashCode();
        }
        int i24 = (i23 ^ i12) * 1000003;
        String str11 = this.f22337l;
        if (str11 != null) {
            i13 = str11.hashCode();
        }
        return i24 ^ i13;
    }

    public String i() {
        return this.f22336k;
    }

    public String j() {
        return this.f22327b;
    }

    public String k() {
        return this.f22331f;
    }

    public String l() {
        return this.f22330e;
    }

    public Integer m() {
        return this.f22326a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f22326a + ", model=" + this.f22327b + ", hardware=" + this.f22328c + ", device=" + this.f22329d + ", product=" + this.f22330e + ", osBuild=" + this.f22331f + ", manufacturer=" + this.f22332g + ", fingerprint=" + this.f22333h + ", locale=" + this.f22334i + ", country=" + this.f22335j + ", mccMnc=" + this.f22336k + ", applicationBuild=" + this.f22337l + "}";
    }

    private AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f22326a = num;
        this.f22327b = str;
        this.f22328c = str2;
        this.f22329d = str3;
        this.f22330e = str4;
        this.f22331f = str5;
        this.f22332g = str6;
        this.f22333h = str7;
        this.f22334i = str8;
        this.f22335j = str9;
        this.f22336k = str10;
        this.f22337l = str11;
    }
}
