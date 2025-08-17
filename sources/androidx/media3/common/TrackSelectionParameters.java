package androidx.media3.common;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class TrackSelectionParameters {
    public static final TrackSelectionParameters C;
    @Deprecated
    public static final TrackSelectionParameters D;
    private static final String E = Util.B0(1);
    private static final String F = Util.B0(2);
    private static final String G = Util.B0(3);
    private static final String H = Util.B0(4);
    private static final String I = Util.B0(5);
    private static final String J = Util.B0(6);
    private static final String K = Util.B0(7);
    private static final String L = Util.B0(8);
    private static final String M = Util.B0(9);
    private static final String N = Util.B0(10);
    private static final String O = Util.B0(11);
    private static final String P = Util.B0(12);
    private static final String Q = Util.B0(13);
    private static final String R = Util.B0(14);
    private static final String S = Util.B0(15);
    private static final String T = Util.B0(16);
    private static final String U = Util.B0(17);
    private static final String V = Util.B0(18);
    private static final String W = Util.B0(19);
    private static final String X = Util.B0(20);
    private static final String Y = Util.B0(21);
    private static final String Z = Util.B0(22);

    /* renamed from: a0  reason: collision with root package name */
    private static final String f4399a0 = Util.B0(23);

    /* renamed from: b0  reason: collision with root package name */
    private static final String f4400b0 = Util.B0(24);

    /* renamed from: c0  reason: collision with root package name */
    private static final String f4401c0 = Util.B0(25);

    /* renamed from: d0  reason: collision with root package name */
    private static final String f4402d0 = Util.B0(26);

    /* renamed from: e0  reason: collision with root package name */
    private static final String f4403e0 = Util.B0(27);

    /* renamed from: f0  reason: collision with root package name */
    private static final String f4404f0 = Util.B0(28);

    /* renamed from: g0  reason: collision with root package name */
    private static final String f4405g0 = Util.B0(29);

    /* renamed from: h0  reason: collision with root package name */
    private static final String f4406h0 = Util.B0(30);

    /* renamed from: i0  reason: collision with root package name */
    private static final String f4407i0 = Util.B0(31);
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> A;
    public final ImmutableSet<Integer> B;

    /* renamed from: a  reason: collision with root package name */
    public final int f4408a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4409b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4410c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4411d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4412e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4413f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4414g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4415h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4416i;

    /* renamed from: j  reason: collision with root package name */
    public final int f4417j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f4418k;

    /* renamed from: l  reason: collision with root package name */
    public final ImmutableList<String> f4419l;

    /* renamed from: m  reason: collision with root package name */
    public final int f4420m;

    /* renamed from: n  reason: collision with root package name */
    public final ImmutableList<String> f4421n;

    /* renamed from: o  reason: collision with root package name */
    public final int f4422o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4423p;

    /* renamed from: q  reason: collision with root package name */
    public final int f4424q;

    /* renamed from: r  reason: collision with root package name */
    public final ImmutableList<String> f4425r;

    /* renamed from: s  reason: collision with root package name */
    public final AudioOffloadPreferences f4426s;

    /* renamed from: t  reason: collision with root package name */
    public final ImmutableList<String> f4427t;

    /* renamed from: u  reason: collision with root package name */
    public final int f4428u;

    /* renamed from: v  reason: collision with root package name */
    public final int f4429v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f4430w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f4431x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f4432y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f4433z;

    public static final class AudioOffloadPreferences {

        /* renamed from: d  reason: collision with root package name */
        public static final AudioOffloadPreferences f4434d = new Builder().d();

        /* renamed from: e  reason: collision with root package name */
        private static final String f4435e = Util.B0(1);

        /* renamed from: f  reason: collision with root package name */
        private static final String f4436f = Util.B0(2);

        /* renamed from: g  reason: collision with root package name */
        private static final String f4437g = Util.B0(3);

        /* renamed from: a  reason: collision with root package name */
        public final int f4438a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4439b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4440c;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f4441a = 0;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public boolean f4442b = false;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f4443c = false;

            public AudioOffloadPreferences d() {
                return new AudioOffloadPreferences(this);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioOffloadPreferences.class != obj.getClass()) {
                return false;
            }
            AudioOffloadPreferences audioOffloadPreferences = (AudioOffloadPreferences) obj;
            if (this.f4438a == audioOffloadPreferences.f4438a && this.f4439b == audioOffloadPreferences.f4439b && this.f4440c == audioOffloadPreferences.f4440c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f4438a + 31) * 31) + (this.f4439b ? 1 : 0)) * 31) + (this.f4440c ? 1 : 0);
        }

        private AudioOffloadPreferences(Builder builder) {
            this.f4438a = builder.f4441a;
            this.f4439b = builder.f4442b;
            this.f4440c = builder.f4443c;
        }
    }

    static {
        TrackSelectionParameters C2 = new Builder().C();
        C = C2;
        D = C2;
    }

    protected TrackSelectionParameters(Builder builder) {
        this.f4408a = builder.f4444a;
        this.f4409b = builder.f4445b;
        this.f4410c = builder.f4446c;
        this.f4411d = builder.f4447d;
        this.f4412e = builder.f4448e;
        this.f4413f = builder.f4449f;
        this.f4414g = builder.f4450g;
        this.f4415h = builder.f4451h;
        this.f4416i = builder.f4452i;
        this.f4417j = builder.f4453j;
        this.f4418k = builder.f4454k;
        this.f4419l = builder.f4455l;
        this.f4420m = builder.f4456m;
        this.f4421n = builder.f4457n;
        this.f4422o = builder.f4458o;
        this.f4423p = builder.f4459p;
        this.f4424q = builder.f4460q;
        this.f4425r = builder.f4461r;
        this.f4426s = builder.f4462s;
        this.f4427t = builder.f4463t;
        this.f4428u = builder.f4464u;
        this.f4429v = builder.f4465v;
        this.f4430w = builder.f4466w;
        this.f4431x = builder.f4467x;
        this.f4432y = builder.f4468y;
        this.f4433z = builder.f4469z;
        this.A = ImmutableMap.d(builder.A);
        this.B = ImmutableSet.m(builder.B);
    }

    public Builder a() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (this.f4408a == trackSelectionParameters.f4408a && this.f4409b == trackSelectionParameters.f4409b && this.f4410c == trackSelectionParameters.f4410c && this.f4411d == trackSelectionParameters.f4411d && this.f4412e == trackSelectionParameters.f4412e && this.f4413f == trackSelectionParameters.f4413f && this.f4414g == trackSelectionParameters.f4414g && this.f4415h == trackSelectionParameters.f4415h && this.f4418k == trackSelectionParameters.f4418k && this.f4416i == trackSelectionParameters.f4416i && this.f4417j == trackSelectionParameters.f4417j && this.f4419l.equals(trackSelectionParameters.f4419l) && this.f4420m == trackSelectionParameters.f4420m && this.f4421n.equals(trackSelectionParameters.f4421n) && this.f4422o == trackSelectionParameters.f4422o && this.f4423p == trackSelectionParameters.f4423p && this.f4424q == trackSelectionParameters.f4424q && this.f4425r.equals(trackSelectionParameters.f4425r) && this.f4426s.equals(trackSelectionParameters.f4426s) && this.f4427t.equals(trackSelectionParameters.f4427t) && this.f4428u == trackSelectionParameters.f4428u && this.f4429v == trackSelectionParameters.f4429v && this.f4430w == trackSelectionParameters.f4430w && this.f4431x == trackSelectionParameters.f4431x && this.f4432y == trackSelectionParameters.f4432y && this.f4433z == trackSelectionParameters.f4433z && this.A.equals(trackSelectionParameters.A) && this.B.equals(trackSelectionParameters.B)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f4408a + 31) * 31) + this.f4409b) * 31) + this.f4410c) * 31) + this.f4411d) * 31) + this.f4412e) * 31) + this.f4413f) * 31) + this.f4414g) * 31) + this.f4415h) * 31) + (this.f4418k ? 1 : 0)) * 31) + this.f4416i) * 31) + this.f4417j) * 31) + this.f4419l.hashCode()) * 31) + this.f4420m) * 31) + this.f4421n.hashCode()) * 31) + this.f4422o) * 31) + this.f4423p) * 31) + this.f4424q) * 31) + this.f4425r.hashCode()) * 31) + this.f4426s.hashCode()) * 31) + this.f4427t.hashCode()) * 31) + this.f4428u) * 31) + this.f4429v) * 31) + (this.f4430w ? 1 : 0)) * 31) + (this.f4431x ? 1 : 0)) * 31) + (this.f4432y ? 1 : 0)) * 31) + (this.f4433z ? 1 : 0)) * 31) + this.A.hashCode()) * 31) + this.B.hashCode();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public HashMap<TrackGroup, TrackSelectionOverride> A;
        /* access modifiers changed from: private */
        public HashSet<Integer> B;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f4444a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f4445b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f4446c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f4447d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f4448e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f4449f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f4450g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f4451h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f4452i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f4453j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f4454k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public ImmutableList<String> f4455l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f4456m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public ImmutableList<String> f4457n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f4458o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f4459p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public int f4460q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public ImmutableList<String> f4461r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public AudioOffloadPreferences f4462s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public ImmutableList<String> f4463t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public int f4464u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public int f4465v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public boolean f4466w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public boolean f4467x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public boolean f4468y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public boolean f4469z;

        @Deprecated
        public Builder() {
            this.f4444a = Integer.MAX_VALUE;
            this.f4445b = Integer.MAX_VALUE;
            this.f4446c = Integer.MAX_VALUE;
            this.f4447d = Integer.MAX_VALUE;
            this.f4452i = Integer.MAX_VALUE;
            this.f4453j = Integer.MAX_VALUE;
            this.f4454k = true;
            this.f4455l = ImmutableList.r();
            this.f4456m = 0;
            this.f4457n = ImmutableList.r();
            this.f4458o = 0;
            this.f4459p = Integer.MAX_VALUE;
            this.f4460q = Integer.MAX_VALUE;
            this.f4461r = ImmutableList.r();
            this.f4462s = AudioOffloadPreferences.f4434d;
            this.f4463t = ImmutableList.r();
            this.f4464u = 0;
            this.f4465v = 0;
            this.f4466w = false;
            this.f4467x = false;
            this.f4468y = false;
            this.f4469z = false;
            this.A = new HashMap<>();
            this.B = new HashSet<>();
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "audioOffloadPreferences", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void E(TrackSelectionParameters trackSelectionParameters) {
            this.f4444a = trackSelectionParameters.f4408a;
            this.f4445b = trackSelectionParameters.f4409b;
            this.f4446c = trackSelectionParameters.f4410c;
            this.f4447d = trackSelectionParameters.f4411d;
            this.f4448e = trackSelectionParameters.f4412e;
            this.f4449f = trackSelectionParameters.f4413f;
            this.f4450g = trackSelectionParameters.f4414g;
            this.f4451h = trackSelectionParameters.f4415h;
            this.f4452i = trackSelectionParameters.f4416i;
            this.f4453j = trackSelectionParameters.f4417j;
            this.f4454k = trackSelectionParameters.f4418k;
            this.f4455l = trackSelectionParameters.f4419l;
            this.f4456m = trackSelectionParameters.f4420m;
            this.f4457n = trackSelectionParameters.f4421n;
            this.f4458o = trackSelectionParameters.f4422o;
            this.f4459p = trackSelectionParameters.f4423p;
            this.f4460q = trackSelectionParameters.f4424q;
            this.f4461r = trackSelectionParameters.f4425r;
            this.f4462s = trackSelectionParameters.f4426s;
            this.f4463t = trackSelectionParameters.f4427t;
            this.f4464u = trackSelectionParameters.f4428u;
            this.f4465v = trackSelectionParameters.f4429v;
            this.f4466w = trackSelectionParameters.f4430w;
            this.f4467x = trackSelectionParameters.f4431x;
            this.f4468y = trackSelectionParameters.f4432y;
            this.f4469z = trackSelectionParameters.f4433z;
            this.B = new HashSet<>(trackSelectionParameters.B);
            this.A = new HashMap<>(trackSelectionParameters.A);
        }

        private static ImmutableList<String> F(String[] strArr) {
            ImmutableList.Builder k2 = ImmutableList.k();
            for (String f2 : (String[]) Assertions.f(strArr)) {
                k2.d(Util.R0((String) Assertions.f(f2)));
            }
            return k2.k();
        }

        public TrackSelectionParameters C() {
            return new TrackSelectionParameters(this);
        }

        public Builder D(int i2) {
            Iterator<TrackSelectionOverride> it2 = this.A.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().a() == i2) {
                    it2.remove();
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder G(TrackSelectionParameters trackSelectionParameters) {
            E(trackSelectionParameters);
            return this;
        }

        public Builder H(int i2) {
            this.f4465v = i2;
            return this;
        }

        public Builder I(int i2, int i3) {
            this.f4444a = i2;
            this.f4445b = i3;
            return this;
        }

        public Builder J(TrackSelectionOverride trackSelectionOverride) {
            D(trackSelectionOverride.a());
            this.A.put(trackSelectionOverride.f4397a, trackSelectionOverride);
            return this;
        }

        public Builder K(String str) {
            if (str == null) {
                return L(new String[0]);
            }
            return L(str);
        }

        public Builder L(String... strArr) {
            this.f4457n = F(strArr);
            return this;
        }

        public Builder M(Context context) {
            CaptioningManager captioningManager;
            if ((Util.f4714a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f4464u = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f4463t = ImmutableList.s(Util.b0(locale));
                }
            }
            return this;
        }

        public Builder N(int i2, boolean z2) {
            if (z2) {
                this.B.add(Integer.valueOf(i2));
            } else {
                this.B.remove(Integer.valueOf(i2));
            }
            return this;
        }

        public Builder O(int i2, int i3, boolean z2) {
            this.f4452i = i2;
            this.f4453j = i3;
            this.f4454k = z2;
            return this;
        }

        public Builder P(Context context, boolean z2) {
            Point S = Util.S(context);
            return O(S.x, S.y, z2);
        }

        public Builder(Context context) {
            this();
            M(context);
            P(context, true);
        }

        protected Builder(TrackSelectionParameters trackSelectionParameters) {
            E(trackSelectionParameters);
        }
    }
}
