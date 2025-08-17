package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.audio.b1;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.unity3d.services.core.device.MimeTypes;
import e.x;
import h.b;
import h.c;
import h.d;
import h.e;
import h.f;
import h.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.http2.Http2;

public class DefaultTrackSelector extends MappingTrackSelector implements RendererCapabilities.Listener {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Ordering<Integer> f7369k = Ordering.b(new b());

    /* renamed from: d  reason: collision with root package name */
    private final Object f7370d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f7371e;

    /* renamed from: f  reason: collision with root package name */
    private final ExoTrackSelection.Factory f7372f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7373g;

    /* renamed from: h  reason: collision with root package name */
    private Parameters f7374h;

    /* renamed from: i  reason: collision with root package name */
    private SpatializerWrapperV32 f7375i;

    /* renamed from: j  reason: collision with root package name */
    private AudioAttributes f7376j;

    private static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final int f7377f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f7378g;

        /* renamed from: h  reason: collision with root package name */
        private final String f7379h;

        /* renamed from: i  reason: collision with root package name */
        private final Parameters f7380i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f7381j;

        /* renamed from: k  reason: collision with root package name */
        private final int f7382k;

        /* renamed from: l  reason: collision with root package name */
        private final int f7383l;

        /* renamed from: m  reason: collision with root package name */
        private final int f7384m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f7385n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f7386o;

        /* renamed from: p  reason: collision with root package name */
        private final int f7387p;

        /* renamed from: q  reason: collision with root package name */
        private final int f7388q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f7389r;

        /* renamed from: s  reason: collision with root package name */
        private final int f7390s;

        /* renamed from: t  reason: collision with root package name */
        private final int f7391t;

        /* renamed from: u  reason: collision with root package name */
        private final int f7392u;

        /* renamed from: v  reason: collision with root package name */
        private final int f7393v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f7394w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f7395x;

        public AudioTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, boolean z2, Predicate<Format> predicate, int i5) {
            super(i2, trackGroup, i3);
            int i6;
            boolean z3;
            int i7;
            int i8;
            boolean z4;
            boolean z5;
            boolean z6;
            int i9;
            boolean z7;
            this.f7380i = parameters;
            if (parameters.f7409s0) {
                i6 = 24;
            } else {
                i6 = 16;
            }
            boolean z8 = true;
            if (!parameters.f7405o0 || (i5 & i6) == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f7385n = z3;
            this.f7379h = DefaultTrackSelector.Y(this.f7441e.f4005d);
            this.f7381j = x.l(i4, false);
            int i10 = 0;
            while (true) {
                i7 = Integer.MAX_VALUE;
                if (i10 >= parameters.f4421n.size()) {
                    i10 = Integer.MAX_VALUE;
                    i8 = 0;
                    break;
                }
                i8 = DefaultTrackSelector.H(this.f7441e, parameters.f4421n.get(i10), false);
                if (i8 > 0) {
                    break;
                }
                i10++;
            }
            this.f7383l = i10;
            this.f7382k = i8;
            this.f7384m = DefaultTrackSelector.L(this.f7441e.f4007f, parameters.f4422o);
            Format format = this.f7441e;
            int i11 = format.f4007f;
            if (i11 == 0 || (i11 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f7386o = z4;
            if ((format.f4006e & 1) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f7389r = z5;
            int i12 = format.B;
            this.f7390s = i12;
            this.f7391t = format.C;
            int i13 = format.f4010i;
            this.f7392u = i13;
            if ((i13 == -1 || i13 <= parameters.f4424q) && ((i12 == -1 || i12 <= parameters.f4423p) && predicate.apply(format))) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f7378g = z6;
            String[] o02 = Util.o0();
            int i14 = 0;
            while (true) {
                if (i14 >= o02.length) {
                    i14 = Integer.MAX_VALUE;
                    i9 = 0;
                    break;
                }
                i9 = DefaultTrackSelector.H(this.f7441e, o02[i14], false);
                if (i9 > 0) {
                    break;
                }
                i14++;
            }
            this.f7387p = i14;
            this.f7388q = i9;
            int i15 = 0;
            while (true) {
                if (i15 < parameters.f4425r.size()) {
                    String str = this.f7441e.f4015n;
                    if (str != null && str.equals(parameters.f4425r.get(i15))) {
                        i7 = i15;
                        break;
                    }
                    i15++;
                } else {
                    break;
                }
            }
            this.f7393v = i7;
            if (x.h(i4) == 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f7394w = z7;
            this.f7395x = x.j(i4) != 64 ? false : z8;
            this.f7377f = f(i4, z2, i6);
        }

        public static int c(List<AudioTrackInfo> list, List<AudioTrackInfo> list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }

        public static ImmutableList<AudioTrackInfo> e(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, boolean z2, Predicate<Format> predicate, int i3) {
            ImmutableList.Builder k2 = ImmutableList.k();
            TrackGroup trackGroup2 = trackGroup;
            for (int i4 = 0; i4 < trackGroup2.f4390a; i4++) {
                k2.d(new AudioTrackInfo(i2, trackGroup, i4, parameters, iArr[i4], z2, predicate, i3));
            }
            return k2.k();
        }

        private int f(int i2, boolean z2, int i3) {
            if (!x.l(i2, this.f7380i.f7411u0)) {
                return 0;
            }
            if (!this.f7378g && !this.f7380i.f7404n0) {
                return 0;
            }
            Parameters parameters = this.f7380i;
            if (parameters.f4426s.f4438a == 2 && !DefaultTrackSelector.Z(parameters, i2, this.f7441e)) {
                return 0;
            }
            if (x.l(i2, false) && this.f7378g && this.f7441e.f4010i != -1) {
                Parameters parameters2 = this.f7380i;
                if (parameters2.f4433z || parameters2.f4432y || ((!parameters2.f7413w0 && z2) || parameters2.f4426s.f4438a == 2 || (i2 & i3) == 0)) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int a() {
            return this.f7377f;
        }

        /* renamed from: d */
        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering ordering;
            if (!this.f7378g || !this.f7381j) {
                ordering = DefaultTrackSelector.f7369k.g();
            } else {
                ordering = DefaultTrackSelector.f7369k;
            }
            ComparisonChain f2 = ComparisonChain.j().g(this.f7381j, audioTrackInfo.f7381j).f(Integer.valueOf(this.f7383l), Integer.valueOf(audioTrackInfo.f7383l), Ordering.d().g()).d(this.f7382k, audioTrackInfo.f7382k).d(this.f7384m, audioTrackInfo.f7384m).g(this.f7389r, audioTrackInfo.f7389r).g(this.f7386o, audioTrackInfo.f7386o).f(Integer.valueOf(this.f7387p), Integer.valueOf(audioTrackInfo.f7387p), Ordering.d().g()).d(this.f7388q, audioTrackInfo.f7388q).g(this.f7378g, audioTrackInfo.f7378g).f(Integer.valueOf(this.f7393v), Integer.valueOf(audioTrackInfo.f7393v), Ordering.d().g());
            if (this.f7380i.f4432y) {
                f2 = f2.f(Integer.valueOf(this.f7392u), Integer.valueOf(audioTrackInfo.f7392u), DefaultTrackSelector.f7369k.g());
            }
            ComparisonChain f3 = f2.g(this.f7394w, audioTrackInfo.f7394w).g(this.f7395x, audioTrackInfo.f7395x).f(Integer.valueOf(this.f7390s), Integer.valueOf(audioTrackInfo.f7390s), ordering).f(Integer.valueOf(this.f7391t), Integer.valueOf(audioTrackInfo.f7391t), ordering);
            if (Util.c(this.f7379h, audioTrackInfo.f7379h)) {
                f3 = f3.f(Integer.valueOf(this.f7392u), Integer.valueOf(audioTrackInfo.f7392u), ordering);
            }
            return f3.i();
        }

        /* renamed from: g */
        public boolean b(AudioTrackInfo audioTrackInfo) {
            int i2;
            String str;
            int i3;
            if ((this.f7380i.f7407q0 || ((i3 = this.f7441e.B) != -1 && i3 == audioTrackInfo.f7441e.B)) && (this.f7385n || ((str = this.f7441e.f4015n) != null && TextUtils.equals(str, audioTrackInfo.f7441e.f4015n)))) {
                Parameters parameters = this.f7380i;
                if ((parameters.f7406p0 || ((i2 = this.f7441e.C) != -1 && i2 == audioTrackInfo.f7441e.C)) && (parameters.f7408r0 || (this.f7394w == audioTrackInfo.f7394w && this.f7395x == audioTrackInfo.f7395x))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class ImageTrackInfo extends TrackInfo<ImageTrackInfo> implements Comparable<ImageTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final int f7396f;

        /* renamed from: g  reason: collision with root package name */
        private final int f7397g = this.f7441e.d();

        public ImageTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4) {
            super(i2, trackGroup, i3);
            this.f7396f = x.l(i4, parameters.f7411u0) ? 1 : 0;
        }

        public static int c(List<ImageTrackInfo> list, List<ImageTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<ImageTrackInfo> e(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr) {
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i3 = 0; i3 < trackGroup.f4390a; i3++) {
                k2.d(new ImageTrackInfo(i2, trackGroup, i3, parameters, iArr[i3]));
            }
            return k2.k();
        }

        public int a() {
            return this.f7396f;
        }

        /* renamed from: d */
        public int compareTo(ImageTrackInfo imageTrackInfo) {
            return Integer.compare(this.f7397g, imageTrackInfo.f7397g);
        }

        /* renamed from: f */
        public boolean b(ImageTrackInfo imageTrackInfo) {
            return false;
        }
    }

    private static final class OtherTrackScore implements Comparable<OtherTrackScore> {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7398b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7399c;

        public OtherTrackScore(Format format, int i2) {
            this.f7398b = (format.f4006e & 1) == 0 ? false : true;
            this.f7399c = x.l(i2, false);
        }

        /* renamed from: a */
        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.j().g(this.f7399c, otherTrackScore.f7399c).g(this.f7398b, otherTrackScore.f7398b).i();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parameters A0;
        @Deprecated
        public static final Parameters B0;
        private static final String C0 = Util.B0(1000);
        private static final String D0 = Util.B0(1001);
        private static final String E0 = Util.B0(1002);
        private static final String F0 = Util.B0(1003);
        private static final String G0 = Util.B0(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
        private static final String H0 = Util.B0(1005);
        private static final String I0 = Util.B0(1006);
        private static final String J0 = Util.B0(1007);
        private static final String K0 = Util.B0(1008);
        private static final String L0 = Util.B0(1009);
        private static final String M0 = Util.B0(1010);
        private static final String N0 = Util.B0(1011);
        private static final String O0 = Util.B0(1012);
        private static final String P0 = Util.B0(1013);
        private static final String Q0 = Util.B0(1014);
        private static final String R0 = Util.B0(1015);
        private static final String S0 = Util.B0(1016);
        private static final String T0 = Util.B0(1017);
        private static final String U0 = Util.B0(1018);

        /* renamed from: j0  reason: collision with root package name */
        public final boolean f7400j0;

        /* renamed from: k0  reason: collision with root package name */
        public final boolean f7401k0;

        /* renamed from: l0  reason: collision with root package name */
        public final boolean f7402l0;

        /* renamed from: m0  reason: collision with root package name */
        public final boolean f7403m0;

        /* renamed from: n0  reason: collision with root package name */
        public final boolean f7404n0;

        /* renamed from: o0  reason: collision with root package name */
        public final boolean f7405o0;

        /* renamed from: p0  reason: collision with root package name */
        public final boolean f7406p0;

        /* renamed from: q0  reason: collision with root package name */
        public final boolean f7407q0;

        /* renamed from: r0  reason: collision with root package name */
        public final boolean f7408r0;

        /* renamed from: s0  reason: collision with root package name */
        public final boolean f7409s0;

        /* renamed from: t0  reason: collision with root package name */
        public final boolean f7410t0;

        /* renamed from: u0  reason: collision with root package name */
        public final boolean f7411u0;

        /* renamed from: v0  reason: collision with root package name */
        public final boolean f7412v0;

        /* renamed from: w0  reason: collision with root package name */
        public final boolean f7413w0;

        /* renamed from: x0  reason: collision with root package name */
        public final boolean f7414x0;
        /* access modifiers changed from: private */

        /* renamed from: y0  reason: collision with root package name */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> f7415y0;
        /* access modifiers changed from: private */

        /* renamed from: z0  reason: collision with root package name */
        public final SparseBooleanArray f7416z0;

        public static final class Builder extends TrackSelectionParameters.Builder {
            /* access modifiers changed from: private */
            public boolean C;
            /* access modifiers changed from: private */
            public boolean D;
            /* access modifiers changed from: private */
            public boolean E;
            /* access modifiers changed from: private */
            public boolean F;
            /* access modifiers changed from: private */
            public boolean G;
            /* access modifiers changed from: private */
            public boolean H;
            /* access modifiers changed from: private */
            public boolean I;
            /* access modifiers changed from: private */
            public boolean J;
            /* access modifiers changed from: private */
            public boolean K;
            /* access modifiers changed from: private */
            public boolean L;
            /* access modifiers changed from: private */
            public boolean M;
            /* access modifiers changed from: private */
            public boolean N;
            /* access modifiers changed from: private */
            public boolean O;
            /* access modifiers changed from: private */
            public boolean P;
            /* access modifiers changed from: private */
            public boolean Q;
            /* access modifiers changed from: private */
            public final SparseArray<Map<TrackGroupArray, SelectionOverride>> R;
            /* access modifiers changed from: private */
            public final SparseBooleanArray S;

            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> j0(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
                }
                return sparseArray2;
            }

            private void k0() {
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = true;
                this.H = false;
                this.I = false;
                this.J = false;
                this.K = false;
                this.L = true;
                this.M = true;
                this.N = true;
                this.O = false;
                this.P = true;
                this.Q = false;
            }

            /* renamed from: h0 */
            public Parameters C() {
                return new Parameters(this);
            }

            /* renamed from: i0 */
            public Builder D(int i2) {
                super.D(i2);
                return this;
            }

            /* access modifiers changed from: protected */
            public Builder l0(TrackSelectionParameters trackSelectionParameters) {
                super.G(trackSelectionParameters);
                return this;
            }

            /* renamed from: m0 */
            public Builder H(int i2) {
                super.H(i2);
                return this;
            }

            public Builder n0(int i2, int i3) {
                super.I(i2, i3);
                return this;
            }

            /* renamed from: o0 */
            public Builder J(TrackSelectionOverride trackSelectionOverride) {
                super.J(trackSelectionOverride);
                return this;
            }

            /* renamed from: p0 */
            public Builder K(String str) {
                super.K(str);
                return this;
            }

            /* renamed from: q0 */
            public Builder L(String... strArr) {
                super.L(strArr);
                return this;
            }

            /* renamed from: r0 */
            public Builder M(Context context) {
                super.M(context);
                return this;
            }

            /* renamed from: s0 */
            public Builder N(int i2, boolean z2) {
                super.N(i2, z2);
                return this;
            }

            /* renamed from: t0 */
            public Builder O(int i2, int i3, boolean z2) {
                super.O(i2, i3, z2);
                return this;
            }

            /* renamed from: u0 */
            public Builder P(Context context, boolean z2) {
                super.P(context, z2);
                return this;
            }

            @Deprecated
            public Builder() {
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                k0();
            }

            public Builder(Context context) {
                super(context);
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                k0();
            }

            private Builder(Parameters parameters) {
                super((TrackSelectionParameters) parameters);
                this.C = parameters.f7400j0;
                this.D = parameters.f7401k0;
                this.E = parameters.f7402l0;
                this.F = parameters.f7403m0;
                this.G = parameters.f7404n0;
                this.H = parameters.f7405o0;
                this.I = parameters.f7406p0;
                this.J = parameters.f7407q0;
                this.K = parameters.f7408r0;
                this.L = parameters.f7409s0;
                this.M = parameters.f7410t0;
                this.N = parameters.f7411u0;
                this.O = parameters.f7412v0;
                this.P = parameters.f7413w0;
                this.Q = parameters.f7414x0;
                this.R = j0(parameters.f7415y0);
                this.S = parameters.f7416z0.clone();
            }
        }

        static {
            Parameters h02 = new Builder().C();
            A0 = h02;
            B0 = h02;
        }

        private static boolean d(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean e(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0 || !f(sparseArray.valueAt(i2), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean f(java.util.Map<androidx.media3.exoplayer.source.TrackGroupArray, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<androidx.media3.exoplayer.source.TrackGroupArray, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                androidx.media3.exoplayer.source.TrackGroupArray r1 = (androidx.media3.exoplayer.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = androidx.media3.common.util.Util.c(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters.f(java.util.Map, java.util.Map):boolean");
        }

        public static Parameters h(Context context) {
            return new Builder(context).C();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.f7400j0 == parameters.f7400j0 && this.f7401k0 == parameters.f7401k0 && this.f7402l0 == parameters.f7402l0 && this.f7403m0 == parameters.f7403m0 && this.f7404n0 == parameters.f7404n0 && this.f7405o0 == parameters.f7405o0 && this.f7406p0 == parameters.f7406p0 && this.f7407q0 == parameters.f7407q0 && this.f7408r0 == parameters.f7408r0 && this.f7409s0 == parameters.f7409s0 && this.f7410t0 == parameters.f7410t0 && this.f7411u0 == parameters.f7411u0 && this.f7412v0 == parameters.f7412v0 && this.f7413w0 == parameters.f7413w0 && this.f7414x0 == parameters.f7414x0 && d(this.f7416z0, parameters.f7416z0) && e(this.f7415y0, parameters.f7415y0)) {
                return true;
            }
            return false;
        }

        /* renamed from: g */
        public Builder a() {
            return new Builder();
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f7400j0 ? 1 : 0)) * 31) + (this.f7401k0 ? 1 : 0)) * 31) + (this.f7402l0 ? 1 : 0)) * 31) + (this.f7403m0 ? 1 : 0)) * 31) + (this.f7404n0 ? 1 : 0)) * 31) + (this.f7405o0 ? 1 : 0)) * 31) + (this.f7406p0 ? 1 : 0)) * 31) + (this.f7407q0 ? 1 : 0)) * 31) + (this.f7408r0 ? 1 : 0)) * 31) + (this.f7409s0 ? 1 : 0)) * 31) + (this.f7410t0 ? 1 : 0)) * 31) + (this.f7411u0 ? 1 : 0)) * 31) + (this.f7412v0 ? 1 : 0)) * 31) + (this.f7413w0 ? 1 : 0)) * 31) + (this.f7414x0 ? 1 : 0);
        }

        public boolean i(int i2) {
            return this.f7416z0.get(i2);
        }

        @Deprecated
        public SelectionOverride j(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.f7415y0.get(i2);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Deprecated
        public boolean k(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.f7415y0.get(i2);
            if (map == null || !map.containsKey(trackGroupArray)) {
                return false;
            }
            return true;
        }

        private Parameters(Builder builder) {
            super(builder);
            this.f7400j0 = builder.C;
            this.f7401k0 = builder.D;
            this.f7402l0 = builder.E;
            this.f7403m0 = builder.F;
            this.f7404n0 = builder.G;
            this.f7405o0 = builder.H;
            this.f7406p0 = builder.I;
            this.f7407q0 = builder.J;
            this.f7408r0 = builder.K;
            this.f7409s0 = builder.L;
            this.f7410t0 = builder.M;
            this.f7411u0 = builder.N;
            this.f7412v0 = builder.O;
            this.f7413w0 = builder.P;
            this.f7414x0 = builder.Q;
            this.f7415y0 = builder.R;
            this.f7416z0 = builder.S;
        }
    }

    public static final class SelectionOverride {

        /* renamed from: d  reason: collision with root package name */
        private static final String f7417d = Util.B0(0);

        /* renamed from: e  reason: collision with root package name */
        private static final String f7418e = Util.B0(1);

        /* renamed from: f  reason: collision with root package name */
        private static final String f7419f = Util.B0(2);

        /* renamed from: a  reason: collision with root package name */
        public final int f7420a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f7421b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7422c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.f7420a == selectionOverride.f7420a && Arrays.equals(this.f7421b, selectionOverride.f7421b) && this.f7422c == selectionOverride.f7422c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f7420a * 31) + Arrays.hashCode(this.f7421b)) * 31) + this.f7422c;
        }
    }

    private static class SpatializerWrapperV32 {

        /* renamed from: a  reason: collision with root package name */
        private final Spatializer f7423a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7424b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f7425c;

        /* renamed from: d  reason: collision with root package name */
        private Spatializer.OnSpatializerStateChangedListener f7426d;

        private SpatializerWrapperV32(Spatializer spatializer) {
            boolean z2;
            this.f7423a = spatializer;
            if (spatializer.getImmersiveAudioLevel() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7424b = z2;
        }

        public static SpatializerWrapperV32 g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                return null;
            }
            return new SpatializerWrapperV32(audioManager.getSpatializer());
        }

        public boolean a(AudioAttributes audioAttributes, Format format) {
            int i2;
            if (!"audio/eac3-joc".equals(format.f4015n) || format.B != 16) {
                i2 = format.B;
            } else {
                i2 = 12;
            }
            int M = Util.M(i2);
            if (M == 0) {
                return false;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(M);
            int i3 = format.C;
            if (i3 != -1) {
                channelMask.setSampleRate(i3);
            }
            return this.f7423a.canBeSpatialized(audioAttributes.a().f3921a, channelMask.build());
        }

        public void b(final DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.f7426d == null && this.f7425c == null) {
                this.f7426d = new Spatializer.OnSpatializerStateChangedListener() {
                    public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
                        defaultTrackSelector.W();
                    }

                    public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
                        defaultTrackSelector.W();
                    }
                };
                Handler handler = new Handler(looper);
                this.f7425c = handler;
                Spatializer spatializer = this.f7423a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new b1(handler), this.f7426d);
            }
        }

        public boolean c() {
            return this.f7423a.isAvailable();
        }

        public boolean d() {
            return this.f7423a.isEnabled();
        }

        public boolean e() {
            return this.f7424b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f7426d;
            if (onSpatializerStateChangedListener != null && this.f7425c != null) {
                this.f7423a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) Util.i(this.f7425c)).removeCallbacksAndMessages((Object) null);
                this.f7425c = null;
                this.f7426d = null;
            }
        }
    }

    private static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final int f7429f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f7430g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f7431h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f7432i;

        /* renamed from: j  reason: collision with root package name */
        private final int f7433j;

        /* renamed from: k  reason: collision with root package name */
        private final int f7434k;

        /* renamed from: l  reason: collision with root package name */
        private final int f7435l;

        /* renamed from: m  reason: collision with root package name */
        private final int f7436m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f7437n;

        public TextTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, String str) {
            super(i2, trackGroup, i3);
            boolean z2;
            boolean z3;
            ImmutableList<String> immutableList;
            int i5;
            boolean z4;
            boolean z5;
            boolean z6;
            int i6 = 0;
            this.f7430g = x.l(i4, false);
            int i7 = this.f7441e.f4006e & (~parameters.f4429v);
            if ((i7 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7431h = z2;
            if ((i7 & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f7432i = z3;
            if (parameters.f4427t.isEmpty()) {
                immutableList = ImmutableList.s("");
            } else {
                immutableList = parameters.f4427t;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= immutableList.size()) {
                    i8 = Integer.MAX_VALUE;
                    i5 = 0;
                    break;
                }
                i5 = DefaultTrackSelector.H(this.f7441e, immutableList.get(i8), parameters.f4430w);
                if (i5 > 0) {
                    break;
                }
                i8++;
            }
            this.f7433j = i8;
            this.f7434k = i5;
            int y2 = DefaultTrackSelector.L(this.f7441e.f4007f, parameters.f4428u);
            this.f7435l = y2;
            if ((this.f7441e.f4007f & 1088) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f7437n = z4;
            if (DefaultTrackSelector.Y(str) == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            int H = DefaultTrackSelector.H(this.f7441e, str, z5);
            this.f7436m = H;
            if (i5 > 0 || ((parameters.f4427t.isEmpty() && y2 > 0) || this.f7431h || (this.f7432i && H > 0))) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (x.l(i4, parameters.f7411u0) && z6) {
                i6 = 1;
            }
            this.f7429f = i6;
        }

        public static int c(List<TextTrackInfo> list, List<TextTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<TextTrackInfo> e(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, String str) {
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i3 = 0; i3 < trackGroup.f4390a; i3++) {
                k2.d(new TextTrackInfo(i2, trackGroup, i3, parameters, iArr[i3], str));
            }
            return k2.k();
        }

        public int a() {
            return this.f7429f;
        }

        /* renamed from: d */
        public int compareTo(TextTrackInfo textTrackInfo) {
            Ordering ordering;
            ComparisonChain g2 = ComparisonChain.j().g(this.f7430g, textTrackInfo.f7430g).f(Integer.valueOf(this.f7433j), Integer.valueOf(textTrackInfo.f7433j), Ordering.d().g()).d(this.f7434k, textTrackInfo.f7434k).d(this.f7435l, textTrackInfo.f7435l).g(this.f7431h, textTrackInfo.f7431h);
            Boolean valueOf = Boolean.valueOf(this.f7432i);
            Boolean valueOf2 = Boolean.valueOf(textTrackInfo.f7432i);
            if (this.f7434k == 0) {
                ordering = Ordering.d();
            } else {
                ordering = Ordering.d().g();
            }
            ComparisonChain d2 = g2.f(valueOf, valueOf2, ordering).d(this.f7436m, textTrackInfo.f7436m);
            if (this.f7435l == 0) {
                d2 = d2.h(this.f7437n, textTrackInfo.f7437n);
            }
            return d2.i();
        }

        /* renamed from: f */
        public boolean b(TextTrackInfo textTrackInfo) {
            return false;
        }
    }

    private static abstract class TrackInfo<T extends TrackInfo<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final int f7438b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackGroup f7439c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7440d;

        /* renamed from: e  reason: collision with root package name */
        public final Format f7441e;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> a(int i2, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i2, TrackGroup trackGroup, int i3) {
            this.f7438b = i2;
            this.f7439c = trackGroup;
            this.f7440d = i3;
            this.f7441e = trackGroup.a(i3);
        }

        public abstract int a();

        public abstract boolean b(T t2);
    }

    private static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f7442f;

        /* renamed from: g  reason: collision with root package name */
        private final Parameters f7443g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f7444h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f7445i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f7446j;

        /* renamed from: k  reason: collision with root package name */
        private final int f7447k;

        /* renamed from: l  reason: collision with root package name */
        private final int f7448l;

        /* renamed from: m  reason: collision with root package name */
        private final int f7449m;

        /* renamed from: n  reason: collision with root package name */
        private final int f7450n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f7451o;

        /* renamed from: p  reason: collision with root package name */
        private final boolean f7452p;

        /* renamed from: q  reason: collision with root package name */
        private final int f7453q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f7454r;

        /* renamed from: s  reason: collision with root package name */
        private final boolean f7455s;

        /* renamed from: t  reason: collision with root package name */
        private final int f7456t;

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00d9 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackInfo(int r5, androidx.media3.common.TrackGroup r6, int r7, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters r8, int r9, int r10, boolean r11) {
            /*
                r4 = this;
                r4.<init>(r5, r6, r7)
                r4.f7443g = r8
                boolean r5 = r8.f7402l0
                if (r5 == 0) goto L_0x000c
                r5 = 24
                goto L_0x000e
            L_0x000c:
                r5 = 16
            L_0x000e:
                boolean r6 = r8.f7401k0
                r7 = 1
                r0 = 0
                if (r6 == 0) goto L_0x001a
                r6 = r10 & r5
                if (r6 == 0) goto L_0x001a
                r6 = 1
                goto L_0x001b
            L_0x001a:
                r6 = 0
            L_0x001b:
                r4.f7452p = r6
                r6 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10 = -1
                if (r11 == 0) goto L_0x004b
                androidx.media3.common.Format r1 = r4.f7441e
                int r2 = r1.f4021t
                if (r2 == r10) goto L_0x002c
                int r3 = r8.f4408a
                if (r2 > r3) goto L_0x004b
            L_0x002c:
                int r2 = r1.f4022u
                if (r2 == r10) goto L_0x0034
                int r3 = r8.f4409b
                if (r2 > r3) goto L_0x004b
            L_0x0034:
                float r2 = r1.f4023v
                int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r3 == 0) goto L_0x0041
                int r3 = r8.f4410c
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x004b
            L_0x0041:
                int r1 = r1.f4010i
                if (r1 == r10) goto L_0x0049
                int r2 = r8.f4411d
                if (r1 > r2) goto L_0x004b
            L_0x0049:
                r1 = 1
                goto L_0x004c
            L_0x004b:
                r1 = 0
            L_0x004c:
                r4.f7442f = r1
                if (r11 == 0) goto L_0x0079
                androidx.media3.common.Format r11 = r4.f7441e
                int r1 = r11.f4021t
                if (r1 == r10) goto L_0x005a
                int r2 = r8.f4412e
                if (r1 < r2) goto L_0x0079
            L_0x005a:
                int r1 = r11.f4022u
                if (r1 == r10) goto L_0x0062
                int r2 = r8.f4413f
                if (r1 < r2) goto L_0x0079
            L_0x0062:
                float r1 = r11.f4023v
                int r2 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x006f
                int r2 = r8.f4414g
                float r2 = (float) r2
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 < 0) goto L_0x0079
            L_0x006f:
                int r11 = r11.f4010i
                if (r11 == r10) goto L_0x0077
                int r10 = r8.f4415h
                if (r11 < r10) goto L_0x0079
            L_0x0077:
                r10 = 1
                goto L_0x007a
            L_0x0079:
                r10 = 0
            L_0x007a:
                r4.f7444h = r10
                boolean r10 = e.x.l(r9, r0)
                r4.f7445i = r10
                androidx.media3.common.Format r10 = r4.f7441e
                float r11 = r10.f4023v
                int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r6 == 0) goto L_0x0092
                r6 = 1092616192(0x41200000, float:10.0)
                int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r6 < 0) goto L_0x0092
                r6 = 1
                goto L_0x0093
            L_0x0092:
                r6 = 0
            L_0x0093:
                r4.f7446j = r6
                int r6 = r10.f4010i
                r4.f7447k = r6
                int r6 = r10.d()
                r4.f7448l = r6
                androidx.media3.common.Format r6 = r4.f7441e
                int r6 = r6.f4007f
                int r10 = r8.f4420m
                int r6 = androidx.media3.exoplayer.trackselection.DefaultTrackSelector.L(r6, r10)
                r4.f7450n = r6
                androidx.media3.common.Format r6 = r4.f7441e
                int r6 = r6.f4007f
                if (r6 == 0) goto L_0x00b7
                r6 = r6 & r7
                if (r6 == 0) goto L_0x00b5
                goto L_0x00b7
            L_0x00b5:
                r6 = 0
                goto L_0x00b8
            L_0x00b7:
                r6 = 1
            L_0x00b8:
                r4.f7451o = r6
                r6 = 0
            L_0x00bb:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.f4419l
                int r10 = r10.size()
                if (r6 >= r10) goto L_0x00d9
                androidx.media3.common.Format r10 = r4.f7441e
                java.lang.String r10 = r10.f4015n
                if (r10 == 0) goto L_0x00d6
                com.google.common.collect.ImmutableList<java.lang.String> r11 = r8.f4419l
                java.lang.Object r11 = r11.get(r6)
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x00d6
                goto L_0x00dc
            L_0x00d6:
                int r6 = r6 + 1
                goto L_0x00bb
            L_0x00d9:
                r6 = 2147483647(0x7fffffff, float:NaN)
            L_0x00dc:
                r4.f7449m = r6
                int r6 = e.x.h(r9)
                r8 = 128(0x80, float:1.794E-43)
                if (r6 != r8) goto L_0x00e8
                r6 = 1
                goto L_0x00e9
            L_0x00e8:
                r6 = 0
            L_0x00e9:
                r4.f7454r = r6
                int r6 = e.x.j(r9)
                r8 = 64
                if (r6 != r8) goto L_0x00f4
                goto L_0x00f5
            L_0x00f4:
                r7 = 0
            L_0x00f5:
                r4.f7455s = r7
                androidx.media3.common.Format r6 = r4.f7441e
                java.lang.String r6 = r6.f4015n
                int r6 = androidx.media3.exoplayer.trackselection.DefaultTrackSelector.M(r6)
                r4.f7456t = r6
                int r5 = r4.i(r9, r5)
                r4.f7453q = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, androidx.media3.common.TrackGroup, int, androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters, int, int, boolean):void");
        }

        /* access modifiers changed from: private */
        public static int e(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain g2 = ComparisonChain.j().g(videoTrackInfo.f7445i, videoTrackInfo2.f7445i).d(videoTrackInfo.f7450n, videoTrackInfo2.f7450n).g(videoTrackInfo.f7451o, videoTrackInfo2.f7451o).g(videoTrackInfo.f7446j, videoTrackInfo2.f7446j).g(videoTrackInfo.f7442f, videoTrackInfo2.f7442f).g(videoTrackInfo.f7444h, videoTrackInfo2.f7444h).f(Integer.valueOf(videoTrackInfo.f7449m), Integer.valueOf(videoTrackInfo2.f7449m), Ordering.d().g()).g(videoTrackInfo.f7454r, videoTrackInfo2.f7454r).g(videoTrackInfo.f7455s, videoTrackInfo2.f7455s);
            if (videoTrackInfo.f7454r && videoTrackInfo.f7455s) {
                g2 = g2.d(videoTrackInfo.f7456t, videoTrackInfo2.f7456t);
            }
            return g2.i();
        }

        /* access modifiers changed from: private */
        public static int f(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering ordering;
            if (!videoTrackInfo.f7442f || !videoTrackInfo.f7445i) {
                ordering = DefaultTrackSelector.f7369k.g();
            } else {
                ordering = DefaultTrackSelector.f7369k;
            }
            ComparisonChain j2 = ComparisonChain.j();
            if (videoTrackInfo.f7443g.f4432y) {
                j2 = j2.f(Integer.valueOf(videoTrackInfo.f7447k), Integer.valueOf(videoTrackInfo2.f7447k), DefaultTrackSelector.f7369k.g());
            }
            return j2.f(Integer.valueOf(videoTrackInfo.f7448l), Integer.valueOf(videoTrackInfo2.f7448l), ordering).f(Integer.valueOf(videoTrackInfo.f7447k), Integer.valueOf(videoTrackInfo2.f7447k), ordering).i();
        }

        public static int g(List<VideoTrackInfo> list, List<VideoTrackInfo> list2) {
            return ComparisonChain.j().f((VideoTrackInfo) Collections.max(list, new e()), (VideoTrackInfo) Collections.max(list2, new e()), new e()).d(list.size(), list2.size()).f((VideoTrackInfo) Collections.max(list, new f()), (VideoTrackInfo) Collections.max(list2, new f()), new f()).i();
        }

        public static ImmutableList<VideoTrackInfo> h(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, int i3) {
            boolean z2;
            TrackGroup trackGroup2 = trackGroup;
            Parameters parameters2 = parameters;
            int x2 = DefaultTrackSelector.I(trackGroup2, parameters2.f4416i, parameters2.f4417j, parameters2.f4418k);
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i4 = 0; i4 < trackGroup2.f4390a; i4++) {
                int d2 = trackGroup2.a(i4).d();
                if (x2 == Integer.MAX_VALUE || (d2 != -1 && d2 <= x2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                k2.d(new VideoTrackInfo(i2, trackGroup, i4, parameters, iArr[i4], i3, z2));
            }
            return k2.k();
        }

        private int i(int i2, int i3) {
            if ((this.f7441e.f4007f & Http2.INITIAL_MAX_FRAME_SIZE) != 0 || !x.l(i2, this.f7443g.f7411u0)) {
                return 0;
            }
            if (!this.f7442f && !this.f7443g.f7400j0) {
                return 0;
            }
            if (x.l(i2, false) && this.f7444h && this.f7442f && this.f7441e.f4010i != -1) {
                Parameters parameters = this.f7443g;
                if (parameters.f4433z || parameters.f4432y || (i2 & i3) == 0) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int a() {
            return this.f7453q;
        }

        /* renamed from: j */
        public boolean b(VideoTrackInfo videoTrackInfo) {
            if ((this.f7452p || Util.c(this.f7441e.f4015n, videoTrackInfo.f7441e.f4015n)) && (this.f7443g.f7403m0 || (this.f7454r == videoTrackInfo.f7454r && this.f7455s == videoTrackInfo.f7455s))) {
                return true;
            }
            return false;
        }
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    private static void D(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int d2 = mappedTrackInfo.d();
        for (int i2 = 0; i2 < d2; i2++) {
            TrackGroupArray f2 = mappedTrackInfo.f(i2);
            if (parameters.k(i2, f2)) {
                SelectionOverride j2 = parameters.j(i2, f2);
                if (j2 == null || j2.f7421b.length == 0) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(f2.b(j2.f7420a), j2.f7421b, j2.f7422c);
                }
                definitionArr[i2] = definition;
            }
        }
    }

    private static void E(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int d2 = mappedTrackInfo.d();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < d2; i2++) {
            G(mappedTrackInfo.f(i2), trackSelectionParameters, hashMap);
        }
        G(mappedTrackInfo.h(), trackSelectionParameters, hashMap);
        for (int i3 = 0; i3 < d2; i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.e(i3)));
            if (trackSelectionOverride != null) {
                if (trackSelectionOverride.f4398b.isEmpty() || mappedTrackInfo.f(i3).d(trackSelectionOverride.f4397a) == -1) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(trackSelectionOverride.f4397a, Ints.n(trackSelectionOverride.f4398b));
                }
                definitionArr[i3] = definition;
            }
        }
    }

    private static void G(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map<Integer, TrackSelectionOverride> map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i2 = 0; i2 < trackGroupArray.f7178a; i2++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.A.get(trackGroupArray.b(i2));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = map.get(Integer.valueOf(trackSelectionOverride2.a()))) == null || (trackSelectionOverride.f4398b.isEmpty() && !trackSelectionOverride2.f4398b.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.a()), trackSelectionOverride2);
            }
        }
    }

    protected static int H(Format format, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f4005d)) {
            return 4;
        }
        String Y = Y(str);
        String Y2 = Y(format.f4005d);
        if (Y2 == null || Y == null) {
            if (!z2 || Y2 != null) {
                return 0;
            }
            return 1;
        } else if (Y2.startsWith(Y) || Y.startsWith(Y2)) {
            return 3;
        } else {
            if (Util.l1(Y2, "-")[0].equals(Util.l1(Y, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int I(TrackGroup trackGroup, int i2, int i3, boolean z2) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            for (int i6 = 0; i6 < trackGroup.f4390a; i6++) {
                Format a2 = trackGroup.a(i6);
                int i7 = a2.f4021t;
                if (i7 > 0 && (i4 = a2.f4022u) > 0) {
                    Point J = J(z2, i2, i3, i7, i4);
                    int i8 = a2.f4021t;
                    int i9 = a2.f4022u;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (((float) J.x) * 0.98f)) && i9 >= ((int) (((float) J.y) * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point J(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = androidx.media3.common.util.Util.k(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = androidx.media3.common.util.Util.k(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.J(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: private */
    public static int L(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static int M(String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals("video/dolby-vision")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    public boolean N(Format format) {
        boolean z2;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        synchronized (this.f7370d) {
            if (this.f7374h.f7410t0 && !this.f7373g && format.B > 2 && (!O(format) || (Util.f4714a >= 32 && (spatializerWrapperV322 = this.f7375i) != null && spatializerWrapperV322.e()))) {
                if (Util.f4714a < 32 || (spatializerWrapperV32 = this.f7375i) == null || !spatializerWrapperV32.e() || !this.f7375i.c() || !this.f7375i.d() || !this.f7375i.a(this.f7376j, format)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private static boolean O(Format format) {
        String str = format.f4015n;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List P(Parameters parameters, boolean z2, int[] iArr, int i2, TrackGroup trackGroup, int[] iArr2) {
        return AudioTrackInfo.e(i2, trackGroup, parameters, iArr2, z2, new g(this), iArr[i2]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int T(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    private static void U(Parameters parameters, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z2;
        int i2;
        int i3 = -1;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= mappedTrackInfo.d()) {
                z2 = false;
                break;
            }
            int e2 = mappedTrackInfo.e(i4);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i4];
            if (e2 != 1 && exoTrackSelection != null) {
                z2 = true;
                break;
            }
            if (e2 == 1 && exoTrackSelection != null && exoTrackSelection.length() == 1) {
                if (Z(parameters, iArr[i4][mappedTrackInfo.f(i4).d(exoTrackSelection.h())][exoTrackSelection.c(0)], exoTrackSelection.l())) {
                    i5++;
                    i3 = i4;
                }
            }
            i4++;
        }
        if (!z2 && i5 == 1) {
            if (parameters.f4426s.f4439b) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            RendererConfiguration rendererConfiguration = rendererConfigurationArr[i3];
            if (rendererConfiguration != null && rendererConfiguration.f5509b) {
                z3 = true;
            }
            rendererConfigurationArr[i3] = new RendererConfiguration(i2, z3);
        }
    }

    private static void V(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z2;
        boolean z3;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            if (i2 >= mappedTrackInfo.d()) {
                z2 = true;
                break;
            }
            int e2 = mappedTrackInfo.e(i2);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if ((e2 == 1 || e2 == 2) && exoTrackSelection != null && a0(iArr[i2], mappedTrackInfo.f(i2), exoTrackSelection)) {
                if (e2 == 1) {
                    if (i4 != -1) {
                        break;
                    }
                    i4 = i2;
                } else if (i3 != -1) {
                    break;
                } else {
                    i3 = i2;
                }
            }
            i2++;
        }
        z2 = false;
        if (i4 == -1 || i3 == -1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z2 && z3) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(0, true);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    /* access modifiers changed from: private */
    public void W() {
        boolean z2;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f7370d) {
            if (!this.f7374h.f7410t0 || this.f7373g || Util.f4714a < 32 || (spatializerWrapperV32 = this.f7375i) == null || !spatializerWrapperV32.e()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            f();
        }
    }

    private void X(Renderer renderer) {
        boolean z2;
        synchronized (this.f7370d) {
            z2 = this.f7374h.f7414x0;
        }
        if (z2) {
            g(renderer);
        }
    }

    protected static String Y(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static boolean Z(Parameters parameters, int i2, Format format) {
        boolean z2;
        boolean z3;
        if (x.g(i2) == 0) {
            return false;
        }
        if (parameters.f4426s.f4440c && (x.g(i2) & 2048) == 0) {
            return false;
        }
        if (!parameters.f4426s.f4439b) {
            return true;
        }
        if (format.E == 0 && format.F == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if ((x.g(i2) & 1024) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 || z3) {
            return true;
        }
        return false;
    }

    private static boolean a0(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int d2 = trackGroupArray.d(exoTrackSelection.h());
        for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
            if (x.k(iArr[d2][exoTrackSelection.c(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> g0(int i2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
        int i3;
        Object obj;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int d2 = mappedTrackInfo.d();
        int i4 = 0;
        while (i4 < d2) {
            if (i2 == mappedTrackInfo2.e(i4)) {
                TrackGroupArray f2 = mappedTrackInfo2.f(i4);
                int i5 = 0;
                while (i5 < f2.f7178a) {
                    TrackGroup b2 = f2.b(i5);
                    List<T> a2 = factory.a(i4, b2, iArr[i4][i5]);
                    boolean[] zArr = new boolean[b2.f4390a];
                    int i6 = 0;
                    while (i6 < b2.f4390a) {
                        TrackInfo trackInfo = (TrackInfo) a2.get(i6);
                        int a3 = trackInfo.a();
                        if (zArr[i6] || a3 == 0) {
                            i3 = d2;
                        } else {
                            if (a3 == 1) {
                                obj = ImmutableList.s(trackInfo);
                                i3 = d2;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i7 = i6 + 1;
                                while (i7 < b2.f4390a) {
                                    TrackInfo trackInfo2 = (TrackInfo) a2.get(i7);
                                    int i8 = d2;
                                    if (trackInfo2.a() == 2 && trackInfo.b(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                                    d2 = i8;
                                }
                                i3 = d2;
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i6++;
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                        d2 = i3;
                    }
                    int i9 = d2;
                    i5++;
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
                }
            }
            TrackInfo.Factory<T> factory2 = factory;
            i4++;
            mappedTrackInfo2 = mappedTrackInfo;
            d2 = d2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((TrackInfo) list.get(i10)).f7440d;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.f7439c, iArr2), Integer.valueOf(trackInfo3.f7438b));
    }

    private void j0(Parameters parameters) {
        boolean z2;
        Assertions.f(parameters);
        synchronized (this.f7370d) {
            if (!this.f7374h.equals(parameters)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7374h = parameters;
        }
        if (z2) {
            if (parameters.f7410t0 && this.f7371e == null) {
                Log.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            f();
        }
    }

    public Parameters.Builder F() {
        return b().a();
    }

    /* renamed from: K */
    public Parameters b() {
        Parameters parameters;
        synchronized (this.f7370d) {
            parameters = this.f7374h;
        }
        return parameters;
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition[] b0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        Pair<ExoTrackSelection.Definition, Integer> pair;
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[d2];
        Pair<ExoTrackSelection.Definition, Integer> h02 = h0(mappedTrackInfo, iArr, iArr2, parameters);
        String str = null;
        if (parameters.f4431x || h02 == null) {
            pair = d0(mappedTrackInfo, iArr, parameters);
        } else {
            pair = null;
        }
        if (pair != null) {
            definitionArr[((Integer) pair.second).intValue()] = (ExoTrackSelection.Definition) pair.first;
        } else if (h02 != null) {
            definitionArr[((Integer) h02.second).intValue()] = (ExoTrackSelection.Definition) h02.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> c02 = c0(mappedTrackInfo, iArr, iArr2, parameters);
        if (c02 != null) {
            definitionArr[((Integer) c02.second).intValue()] = (ExoTrackSelection.Definition) c02.first;
        }
        if (c02 != null) {
            Object obj = c02.first;
            str = ((ExoTrackSelection.Definition) obj).f7457a.a(((ExoTrackSelection.Definition) obj).f7458b[0]).f4005d;
        }
        Pair<ExoTrackSelection.Definition, Integer> f02 = f0(mappedTrackInfo, iArr, parameters, str);
        if (f02 != null) {
            definitionArr[((Integer) f02.second).intValue()] = (ExoTrackSelection.Definition) f02.first;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = mappedTrackInfo.e(i2);
            if (!(e2 == 2 || e2 == 1 || e2 == 3 || e2 == 4)) {
                definitionArr[i2] = e0(e2, mappedTrackInfo.f(i2), iArr[i2], parameters);
            }
        }
        return definitionArr;
    }

    public RendererCapabilities.Listener c() {
        return this;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> c0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < mappedTrackInfo.d()) {
                if (2 == mappedTrackInfo.e(i2) && mappedTrackInfo.f(i2).f7178a > 0) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return g0(1, mappedTrackInfo, iArr, new c(this, parameters, z2, iArr2), new a());
    }

    public void d(Renderer renderer) {
        X(renderer);
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> d0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters) throws ExoPlaybackException {
        if (parameters.f4426s.f4438a == 2) {
            return null;
        }
        return g0(4, mappedTrackInfo, iArr, new f(parameters), new d());
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition e0(int i2, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        if (parameters.f4426s.f4438a == 2) {
            return null;
        }
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.f7178a; i4++) {
            TrackGroup b2 = trackGroupArray.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < b2.f4390a; i5++) {
                if (x.l(iArr2[i5], parameters.f7411u0)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(b2.a(i5), iArr2[i5]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = b2;
                        i3 = i5;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i3);
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> f0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        if (parameters.f4426s.f4438a == 2) {
            return null;
        }
        return g0(3, mappedTrackInfo, iArr, new e(parameters, str), new c());
    }

    public boolean h() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> h0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        if (parameters.f4426s.f4438a == 2) {
            return null;
        }
        return g0(2, mappedTrackInfo, iArr, new d(parameters, iArr2), new b());
    }

    public void i0(Parameters.Builder builder) {
        j0(builder.C());
    }

    public void j() {
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f7370d) {
            if (Util.f4714a >= 32 && (spatializerWrapperV32 = this.f7375i) != null) {
                spatializerWrapperV32.f();
            }
        }
        super.j();
    }

    public void l(AudioAttributes audioAttributes) {
        boolean z2;
        synchronized (this.f7370d) {
            if (!this.f7376j.equals(audioAttributes)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7376j = audioAttributes;
        }
        if (z2) {
            W();
        }
    }

    public void m(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            j0((Parameters) trackSelectionParameters);
        }
        j0(new Parameters.Builder().l0(trackSelectionParameters).C());
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> q(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters;
        boolean z2;
        RendererConfiguration rendererConfiguration;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f7370d) {
            parameters = this.f7374h;
            if (parameters.f7410t0 && Util.f4714a >= 32 && (spatializerWrapperV32 = this.f7375i) != null) {
                spatializerWrapperV32.b(this, (Looper) Assertions.j(Looper.myLooper()));
            }
        }
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] b02 = b0(mappedTrackInfo, iArr, iArr2, parameters);
        E(mappedTrackInfo, parameters, b02);
        D(mappedTrackInfo, parameters, b02);
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = mappedTrackInfo.e(i2);
            if (parameters.i(i2) || parameters.B.contains(Integer.valueOf(e2))) {
                b02[i2] = null;
            }
        }
        ExoTrackSelection[] a2 = this.f7372f.a(b02, a(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            int e3 = mappedTrackInfo.e(i3);
            boolean z3 = true;
            if (parameters.i(i3) || parameters.B.contains(Integer.valueOf(e3))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || (mappedTrackInfo.e(i3) != -2 && a2[i3] == null)) {
                z3 = false;
            }
            if (z3) {
                rendererConfiguration = RendererConfiguration.f5507c;
            } else {
                rendererConfiguration = null;
            }
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
        if (parameters.f7412v0) {
            V(mappedTrackInfo, iArr, rendererConfigurationArr, a2);
        }
        if (parameters.f4426s.f4438a != 0) {
            U(parameters, mappedTrackInfo, iArr, rendererConfigurationArr, a2);
        }
        return Pair.create(rendererConfigurationArr, a2);
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, (TrackSelectionParameters) Parameters.h(context), factory);
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, Context context) {
        this.f7370d = new Object();
        this.f7371e = context != null ? context.getApplicationContext() : null;
        this.f7372f = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.f7374h = (Parameters) trackSelectionParameters;
        } else {
            this.f7374h = (context == null ? Parameters.A0 : Parameters.h(context)).a().l0(trackSelectionParameters).C();
        }
        this.f7376j = AudioAttributes.f3909g;
        boolean z2 = context != null && Util.J0(context);
        this.f7373g = z2;
        if (!z2 && context != null && Util.f4714a >= 32) {
            this.f7375i = SpatializerWrapperV32.g(context);
        }
        if (this.f7374h.f7410t0 && context == null) {
            Log.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
