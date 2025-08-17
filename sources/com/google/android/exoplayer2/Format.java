package com.google.android.exoplayer2;

import android.os.Bundle;
import com.facebook.common.time.Clock;
import com.facebook.hermes.intl.Constants;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Joiner;
import com.google.protobuf.CodedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.http2.Http2;

public final class Format implements Bundleable {
    private static final Format J = new Builder().G();
    private static final String K = Util.u0(0);
    private static final String L = Util.u0(1);
    private static final String M = Util.u0(2);
    private static final String N = Util.u0(3);
    private static final String O = Util.u0(4);
    private static final String P = Util.u0(5);
    private static final String Q = Util.u0(6);
    private static final String R = Util.u0(7);
    private static final String S = Util.u0(8);
    private static final String T = Util.u0(9);
    private static final String U = Util.u0(10);
    private static final String V = Util.u0(11);
    private static final String W = Util.u0(12);
    private static final String X = Util.u0(13);
    private static final String Y = Util.u0(14);
    private static final String Z = Util.u0(15);

    /* renamed from: a0  reason: collision with root package name */
    private static final String f23043a0 = Util.u0(16);

    /* renamed from: b0  reason: collision with root package name */
    private static final String f23044b0 = Util.u0(17);

    /* renamed from: c0  reason: collision with root package name */
    private static final String f23045c0 = Util.u0(18);

    /* renamed from: d0  reason: collision with root package name */
    private static final String f23046d0 = Util.u0(19);

    /* renamed from: e0  reason: collision with root package name */
    private static final String f23047e0 = Util.u0(20);

    /* renamed from: f0  reason: collision with root package name */
    private static final String f23048f0 = Util.u0(21);

    /* renamed from: g0  reason: collision with root package name */
    private static final String f23049g0 = Util.u0(22);

    /* renamed from: h0  reason: collision with root package name */
    private static final String f23050h0 = Util.u0(23);

    /* renamed from: i0  reason: collision with root package name */
    private static final String f23051i0 = Util.u0(24);

    /* renamed from: j0  reason: collision with root package name */
    private static final String f23052j0 = Util.u0(25);

    /* renamed from: k0  reason: collision with root package name */
    private static final String f23053k0 = Util.u0(26);

    /* renamed from: l0  reason: collision with root package name */
    private static final String f23054l0 = Util.u0(27);

    /* renamed from: m0  reason: collision with root package name */
    private static final String f23055m0 = Util.u0(28);

    /* renamed from: n0  reason: collision with root package name */
    private static final String f23056n0 = Util.u0(29);

    /* renamed from: o0  reason: collision with root package name */
    private static final String f23057o0 = Util.u0(30);

    /* renamed from: p0  reason: collision with root package name */
    private static final String f23058p0 = Util.u0(31);

    /* renamed from: q0  reason: collision with root package name */
    public static final Bundleable.Creator<Format> f23059q0 = new y0();
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    private int I;

    /* renamed from: b  reason: collision with root package name */
    public final String f23060b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23061c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23062d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23063e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23064f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23065g;

    /* renamed from: h  reason: collision with root package name */
    public final int f23066h;

    /* renamed from: i  reason: collision with root package name */
    public final int f23067i;

    /* renamed from: j  reason: collision with root package name */
    public final String f23068j;

    /* renamed from: k  reason: collision with root package name */
    public final Metadata f23069k;

    /* renamed from: l  reason: collision with root package name */
    public final String f23070l;

    /* renamed from: m  reason: collision with root package name */
    public final String f23071m;

    /* renamed from: n  reason: collision with root package name */
    public final int f23072n;

    /* renamed from: o  reason: collision with root package name */
    public final List<byte[]> f23073o;

    /* renamed from: p  reason: collision with root package name */
    public final DrmInitData f23074p;

    /* renamed from: q  reason: collision with root package name */
    public final long f23075q;

    /* renamed from: r  reason: collision with root package name */
    public final int f23076r;

    /* renamed from: s  reason: collision with root package name */
    public final int f23077s;

    /* renamed from: t  reason: collision with root package name */
    public final float f23078t;

    /* renamed from: u  reason: collision with root package name */
    public final int f23079u;

    /* renamed from: v  reason: collision with root package name */
    public final float f23080v;

    /* renamed from: w  reason: collision with root package name */
    public final byte[] f23081w;

    /* renamed from: x  reason: collision with root package name */
    public final int f23082x;

    /* renamed from: y  reason: collision with root package name */
    public final ColorInfo f23083y;

    /* renamed from: z  reason: collision with root package name */
    public final int f23084z;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int A;
        /* access modifiers changed from: private */
        public int B;
        /* access modifiers changed from: private */
        public int C;
        /* access modifiers changed from: private */
        public int D;
        /* access modifiers changed from: private */
        public int E;
        /* access modifiers changed from: private */
        public int F;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f23085a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f23086b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f23087c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f23088d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f23089e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f23090f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f23091g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f23092h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public Metadata f23093i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f23094j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public String f23095k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f23096l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public List<byte[]> f23097m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public DrmInitData f23098n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public long f23099o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f23100p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public int f23101q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public float f23102r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public int f23103s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public float f23104t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public byte[] f23105u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public int f23106v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public ColorInfo f23107w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public int f23108x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public int f23109y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public int f23110z;

        public Format G() {
            return new Format(this);
        }

        public Builder H(int i2) {
            this.C = i2;
            return this;
        }

        public Builder I(int i2) {
            this.f23090f = i2;
            return this;
        }

        public Builder J(int i2) {
            this.f23108x = i2;
            return this;
        }

        public Builder K(String str) {
            this.f23092h = str;
            return this;
        }

        public Builder L(ColorInfo colorInfo) {
            this.f23107w = colorInfo;
            return this;
        }

        public Builder M(String str) {
            this.f23094j = str;
            return this;
        }

        public Builder N(int i2) {
            this.F = i2;
            return this;
        }

        public Builder O(DrmInitData drmInitData) {
            this.f23098n = drmInitData;
            return this;
        }

        public Builder P(int i2) {
            this.A = i2;
            return this;
        }

        public Builder Q(int i2) {
            this.B = i2;
            return this;
        }

        public Builder R(float f2) {
            this.f23102r = f2;
            return this;
        }

        public Builder S(int i2) {
            this.f23101q = i2;
            return this;
        }

        public Builder T(int i2) {
            this.f23085a = Integer.toString(i2);
            return this;
        }

        public Builder U(String str) {
            this.f23085a = str;
            return this;
        }

        public Builder V(List<byte[]> list) {
            this.f23097m = list;
            return this;
        }

        public Builder W(String str) {
            this.f23086b = str;
            return this;
        }

        public Builder X(String str) {
            this.f23087c = str;
            return this;
        }

        public Builder Y(int i2) {
            this.f23096l = i2;
            return this;
        }

        public Builder Z(Metadata metadata) {
            this.f23093i = metadata;
            return this;
        }

        public Builder a0(int i2) {
            this.f23110z = i2;
            return this;
        }

        public Builder b0(int i2) {
            this.f23091g = i2;
            return this;
        }

        public Builder c0(float f2) {
            this.f23104t = f2;
            return this;
        }

        public Builder d0(byte[] bArr) {
            this.f23105u = bArr;
            return this;
        }

        public Builder e0(int i2) {
            this.f23089e = i2;
            return this;
        }

        public Builder f0(int i2) {
            this.f23103s = i2;
            return this;
        }

        public Builder g0(String str) {
            this.f23095k = str;
            return this;
        }

        public Builder h0(int i2) {
            this.f23109y = i2;
            return this;
        }

        public Builder i0(int i2) {
            this.f23088d = i2;
            return this;
        }

        public Builder j0(int i2) {
            this.f23106v = i2;
            return this;
        }

        public Builder k0(long j2) {
            this.f23099o = j2;
            return this;
        }

        public Builder l0(int i2) {
            this.D = i2;
            return this;
        }

        public Builder m0(int i2) {
            this.E = i2;
            return this;
        }

        public Builder n0(int i2) {
            this.f23100p = i2;
            return this;
        }

        public Builder() {
            this.f23090f = -1;
            this.f23091g = -1;
            this.f23096l = -1;
            this.f23099o = Clock.MAX_TIME;
            this.f23100p = -1;
            this.f23101q = -1;
            this.f23102r = -1.0f;
            this.f23104t = 1.0f;
            this.f23106v = -1;
            this.f23108x = -1;
            this.f23109y = -1;
            this.f23110z = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
        }

        private Builder(Format format) {
            this.f23085a = format.f23060b;
            this.f23086b = format.f23061c;
            this.f23087c = format.f23062d;
            this.f23088d = format.f23063e;
            this.f23089e = format.f23064f;
            this.f23090f = format.f23065g;
            this.f23091g = format.f23066h;
            this.f23092h = format.f23068j;
            this.f23093i = format.f23069k;
            this.f23094j = format.f23070l;
            this.f23095k = format.f23071m;
            this.f23096l = format.f23072n;
            this.f23097m = format.f23073o;
            this.f23098n = format.f23074p;
            this.f23099o = format.f23075q;
            this.f23100p = format.f23076r;
            this.f23101q = format.f23077s;
            this.f23102r = format.f23078t;
            this.f23103s = format.f23079u;
            this.f23104t = format.f23080v;
            this.f23105u = format.f23081w;
            this.f23106v = format.f23082x;
            this.f23107w = format.f23083y;
            this.f23108x = format.f23084z;
            this.f23109y = format.A;
            this.f23110z = format.B;
            this.A = format.C;
            this.B = format.D;
            this.C = format.E;
            this.D = format.F;
            this.E = format.G;
            this.F = format.H;
        }
    }

    private static <T> T d(T t2, T t3) {
        return t2 != null ? t2 : t3;
    }

    /* access modifiers changed from: private */
    public static Format e(Bundle bundle) {
        Builder builder = new Builder();
        BundleableUtil.a(bundle);
        String string = bundle.getString(K);
        Format format = J;
        builder.U((String) d(string, format.f23060b)).W((String) d(bundle.getString(L), format.f23061c)).X((String) d(bundle.getString(M), format.f23062d)).i0(bundle.getInt(N, format.f23063e)).e0(bundle.getInt(O, format.f23064f)).I(bundle.getInt(P, format.f23065g)).b0(bundle.getInt(Q, format.f23066h)).K((String) d(bundle.getString(R), format.f23068j)).Z((Metadata) d((Metadata) bundle.getParcelable(S), format.f23069k)).M((String) d(bundle.getString(T), format.f23070l)).g0((String) d(bundle.getString(U), format.f23071m)).Y(bundle.getInt(V, format.f23072n));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(h(i2));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i2++;
        }
        Builder O2 = builder.V(arrayList).O((DrmInitData) bundle.getParcelable(X));
        String str = Y;
        Format format2 = J;
        O2.k0(bundle.getLong(str, format2.f23075q)).n0(bundle.getInt(Z, format2.f23076r)).S(bundle.getInt(f23043a0, format2.f23077s)).R(bundle.getFloat(f23044b0, format2.f23078t)).f0(bundle.getInt(f23045c0, format2.f23079u)).c0(bundle.getFloat(f23046d0, format2.f23080v)).d0(bundle.getByteArray(f23047e0)).j0(bundle.getInt(f23048f0, format2.f23082x));
        Bundle bundle2 = bundle.getBundle(f23049g0);
        if (bundle2 != null) {
            builder.L(ColorInfo.f28843l.a(bundle2));
        }
        builder.J(bundle.getInt(f23050h0, format2.f23084z)).h0(bundle.getInt(f23051i0, format2.A)).a0(bundle.getInt(f23052j0, format2.B)).P(bundle.getInt(f23053k0, format2.C)).Q(bundle.getInt(f23054l0, format2.D)).H(bundle.getInt(f23055m0, format2.E)).l0(bundle.getInt(f23057o0, format2.F)).m0(bundle.getInt(f23058p0, format2.G)).N(bundle.getInt(f23056n0, format2.H));
        return builder.G();
    }

    private static String h(int i2) {
        return W + "_" + Integer.toString(i2, 36);
    }

    public static String j(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.f23060b);
        sb.append(", mimeType=");
        sb.append(format.f23071m);
        if (format.f23067i != -1) {
            sb.append(", bitrate=");
            sb.append(format.f23067i);
        }
        if (format.f23068j != null) {
            sb.append(", codecs=");
            sb.append(format.f23068j);
        }
        if (format.f23074p != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            while (true) {
                DrmInitData drmInitData = format.f23074p;
                if (i2 >= drmInitData.f24078e) {
                    break;
                }
                UUID uuid = drmInitData.f(i2).f24080c;
                if (uuid.equals(C.f22817b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.f22818c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.f22820e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.f22819d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.f22816a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i2++;
            }
            sb.append(", drm=[");
            Joiner.e(',').b(sb, linkedHashSet);
            sb.append(']');
        }
        if (!(format.f23076r == -1 || format.f23077s == -1)) {
            sb.append(", res=");
            sb.append(format.f23076r);
            sb.append("x");
            sb.append(format.f23077s);
        }
        if (format.f23078t != -1.0f) {
            sb.append(", fps=");
            sb.append(format.f23078t);
        }
        if (format.f23084z != -1) {
            sb.append(", channels=");
            sb.append(format.f23084z);
        }
        if (format.A != -1) {
            sb.append(", sample_rate=");
            sb.append(format.A);
        }
        if (format.f23062d != null) {
            sb.append(", language=");
            sb.append(format.f23062d);
        }
        if (format.f23061c != null) {
            sb.append(", label=");
            sb.append(format.f23061c);
        }
        if (format.f23063e != 0) {
            ArrayList arrayList = new ArrayList();
            if ((format.f23063e & 4) != 0) {
                arrayList.add("auto");
            }
            if ((format.f23063e & 1) != 0) {
                arrayList.add(Constants.COLLATION_DEFAULT);
            }
            if ((format.f23063e & 2) != 0) {
                arrayList.add("forced");
            }
            sb.append(", selectionFlags=[");
            Joiner.e(',').b(sb, arrayList);
            sb.append("]");
        }
        if (format.f23064f != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((format.f23064f & 1) != 0) {
                arrayList2.add(MediaTrack.ROLE_MAIN);
            }
            if ((format.f23064f & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((format.f23064f & 4) != 0) {
                arrayList2.add(MediaTrack.ROLE_SUPPLEMENTARY);
            }
            if ((format.f23064f & 8) != 0) {
                arrayList2.add(MediaTrack.ROLE_COMMENTARY);
            }
            if ((format.f23064f & 16) != 0) {
                arrayList2.add(MediaTrack.ROLE_DUB);
            }
            if ((format.f23064f & 32) != 0) {
                arrayList2.add(MediaTrack.ROLE_EMERGENCY);
            }
            if ((format.f23064f & 64) != 0) {
                arrayList2.add(MediaTrack.ROLE_CAPTION);
            }
            if ((format.f23064f & 128) != 0) {
                arrayList2.add(MediaTrack.ROLE_SUBTITLE);
            }
            if ((format.f23064f & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
                arrayList2.add(MediaTrack.ROLE_SIGN);
            }
            if ((format.f23064f & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((format.f23064f & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((format.f23064f & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((format.f23064f & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((format.f23064f & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((format.f23064f & Http2.INITIAL_MAX_FRAME_SIZE) != 0) {
                arrayList2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            Joiner.e(',').b(sb, arrayList2);
            sb.append("]");
        }
        return sb.toString();
    }

    public Builder b() {
        return new Builder();
    }

    public Format c(int i2) {
        return b().N(i2).G();
    }

    public boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i3 = this.I;
        if ((i3 == 0 || (i2 = format.I) == 0 || i3 == i2) && this.f23063e == format.f23063e && this.f23064f == format.f23064f && this.f23065g == format.f23065g && this.f23066h == format.f23066h && this.f23072n == format.f23072n && this.f23075q == format.f23075q && this.f23076r == format.f23076r && this.f23077s == format.f23077s && this.f23079u == format.f23079u && this.f23082x == format.f23082x && this.f23084z == format.f23084z && this.A == format.A && this.B == format.B && this.C == format.C && this.D == format.D && this.E == format.E && this.F == format.F && this.G == format.G && this.H == format.H && Float.compare(this.f23078t, format.f23078t) == 0 && Float.compare(this.f23080v, format.f23080v) == 0 && Util.c(this.f23060b, format.f23060b) && Util.c(this.f23061c, format.f23061c) && Util.c(this.f23068j, format.f23068j) && Util.c(this.f23070l, format.f23070l) && Util.c(this.f23071m, format.f23071m) && Util.c(this.f23062d, format.f23062d) && Arrays.equals(this.f23081w, format.f23081w) && Util.c(this.f23069k, format.f23069k) && Util.c(this.f23083y, format.f23083y) && Util.c(this.f23074p, format.f23074p) && g(format)) {
            return true;
        }
        return false;
    }

    public int f() {
        int i2;
        int i3 = this.f23076r;
        if (i3 == -1 || (i2 = this.f23077s) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public boolean g(Format format) {
        if (this.f23073o.size() != format.f23073o.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f23073o.size(); i2++) {
            if (!Arrays.equals(this.f23073o.get(i2), format.f23073o.get(i2))) {
                return false;
            }
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
        if (this.I == 0) {
            String str = this.f23060b;
            int i8 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i9 = (527 + i2) * 31;
            String str2 = this.f23061c;
            if (str2 != null) {
                i3 = str2.hashCode();
            } else {
                i3 = 0;
            }
            int i10 = (i9 + i3) * 31;
            String str3 = this.f23062d;
            if (str3 == null) {
                i4 = 0;
            } else {
                i4 = str3.hashCode();
            }
            int i11 = (((((((((i10 + i4) * 31) + this.f23063e) * 31) + this.f23064f) * 31) + this.f23065g) * 31) + this.f23066h) * 31;
            String str4 = this.f23068j;
            if (str4 == null) {
                i5 = 0;
            } else {
                i5 = str4.hashCode();
            }
            int i12 = (i11 + i5) * 31;
            Metadata metadata = this.f23069k;
            if (metadata == null) {
                i6 = 0;
            } else {
                i6 = metadata.hashCode();
            }
            int i13 = (i12 + i6) * 31;
            String str5 = this.f23070l;
            if (str5 == null) {
                i7 = 0;
            } else {
                i7 = str5.hashCode();
            }
            int i14 = (i13 + i7) * 31;
            String str6 = this.f23071m;
            if (str6 != null) {
                i8 = str6.hashCode();
            }
            this.I = ((((((((((((((((((((((((((((((((((i14 + i8) * 31) + this.f23072n) * 31) + ((int) this.f23075q)) * 31) + this.f23076r) * 31) + this.f23077s) * 31) + Float.floatToIntBits(this.f23078t)) * 31) + this.f23079u) * 31) + Float.floatToIntBits(this.f23080v)) * 31) + this.f23082x) * 31) + this.f23084z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.H;
        }
        return this.I;
    }

    public Bundle i(boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString(K, this.f23060b);
        bundle.putString(L, this.f23061c);
        bundle.putString(M, this.f23062d);
        bundle.putInt(N, this.f23063e);
        bundle.putInt(O, this.f23064f);
        bundle.putInt(P, this.f23065g);
        bundle.putInt(Q, this.f23066h);
        bundle.putString(R, this.f23068j);
        if (!z2) {
            bundle.putParcelable(S, this.f23069k);
        }
        bundle.putString(T, this.f23070l);
        bundle.putString(U, this.f23071m);
        bundle.putInt(V, this.f23072n);
        for (int i2 = 0; i2 < this.f23073o.size(); i2++) {
            bundle.putByteArray(h(i2), this.f23073o.get(i2));
        }
        bundle.putParcelable(X, this.f23074p);
        bundle.putLong(Y, this.f23075q);
        bundle.putInt(Z, this.f23076r);
        bundle.putInt(f23043a0, this.f23077s);
        bundle.putFloat(f23044b0, this.f23078t);
        bundle.putInt(f23045c0, this.f23079u);
        bundle.putFloat(f23046d0, this.f23080v);
        bundle.putByteArray(f23047e0, this.f23081w);
        bundle.putInt(f23048f0, this.f23082x);
        ColorInfo colorInfo = this.f23083y;
        if (colorInfo != null) {
            bundle.putBundle(f23049g0, colorInfo.toBundle());
        }
        bundle.putInt(f23050h0, this.f23084z);
        bundle.putInt(f23051i0, this.A);
        bundle.putInt(f23052j0, this.B);
        bundle.putInt(f23053k0, this.C);
        bundle.putInt(f23054l0, this.D);
        bundle.putInt(f23055m0, this.E);
        bundle.putInt(f23057o0, this.F);
        bundle.putInt(f23058p0, this.G);
        bundle.putInt(f23056n0, this.H);
        return bundle;
    }

    public Format k(Format format) {
        Metadata metadata;
        String str;
        if (this == format) {
            return this;
        }
        int k2 = MimeTypes.k(this.f23071m);
        String str2 = format.f23060b;
        String str3 = format.f23061c;
        if (str3 == null) {
            str3 = this.f23061c;
        }
        String str4 = this.f23062d;
        if ((k2 == 3 || k2 == 1) && (str = format.f23062d) != null) {
            str4 = str;
        }
        int i2 = this.f23065g;
        if (i2 == -1) {
            i2 = format.f23065g;
        }
        int i3 = this.f23066h;
        if (i3 == -1) {
            i3 = format.f23066h;
        }
        String str5 = this.f23068j;
        if (str5 == null) {
            String L2 = Util.L(format.f23068j, k2);
            if (Util.Y0(L2).length == 1) {
                str5 = L2;
            }
        }
        Metadata metadata2 = this.f23069k;
        if (metadata2 == null) {
            metadata = format.f23069k;
        } else {
            metadata = metadata2.c(format.f23069k);
        }
        float f2 = this.f23078t;
        if (f2 == -1.0f && k2 == 2) {
            f2 = format.f23078t;
        }
        int i4 = this.f23063e | format.f23063e;
        int i5 = this.f23064f | format.f23064f;
        return b().U(str2).W(str3).X(str4).i0(i4).e0(i5).I(i2).b0(i3).K(str5).Z(metadata).O(DrmInitData.e(format.f23074p, this.f23074p)).R(f2).G();
    }

    public Bundle toBundle() {
        return i(false);
    }

    public String toString() {
        return "Format(" + this.f23060b + ", " + this.f23061c + ", " + this.f23070l + ", " + this.f23071m + ", " + this.f23068j + ", " + this.f23067i + ", " + this.f23062d + ", [" + this.f23076r + ", " + this.f23077s + ", " + this.f23078t + "], [" + this.f23084z + ", " + this.A + "])";
    }

    private Format(Builder builder) {
        this.f23060b = builder.f23085a;
        this.f23061c = builder.f23086b;
        this.f23062d = Util.H0(builder.f23087c);
        this.f23063e = builder.f23088d;
        this.f23064f = builder.f23089e;
        int C2 = builder.f23090f;
        this.f23065g = C2;
        int D2 = builder.f23091g;
        this.f23066h = D2;
        this.f23067i = D2 != -1 ? D2 : C2;
        this.f23068j = builder.f23092h;
        this.f23069k = builder.f23093i;
        this.f23070l = builder.f23094j;
        this.f23071m = builder.f23095k;
        this.f23072n = builder.f23096l;
        this.f23073o = builder.f23097m == null ? Collections.emptyList() : builder.f23097m;
        DrmInitData f2 = builder.f23098n;
        this.f23074p = f2;
        this.f23075q = builder.f23099o;
        this.f23076r = builder.f23100p;
        this.f23077s = builder.f23101q;
        this.f23078t = builder.f23102r;
        int i2 = 0;
        this.f23079u = builder.f23103s == -1 ? 0 : builder.f23103s;
        this.f23080v = builder.f23104t == -1.0f ? 1.0f : builder.f23104t;
        this.f23081w = builder.f23105u;
        this.f23082x = builder.f23106v;
        this.f23083y = builder.f23107w;
        this.f23084z = builder.f23108x;
        this.A = builder.f23109y;
        this.B = builder.f23110z;
        this.C = builder.A == -1 ? 0 : builder.A;
        this.D = builder.B != -1 ? builder.B : i2;
        this.E = builder.C;
        this.F = builder.D;
        this.G = builder.E;
        if (builder.F != 0 || f2 == null) {
            this.H = builder.F;
        } else {
            this.H = 1;
        }
    }
}
