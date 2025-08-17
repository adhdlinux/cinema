package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.exoplayer.audio.b1;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.http2.Http2;
import s0.b;
import s0.c;
import s0.d;
import s0.e;
import s0.f;
import s0.g;
import s0.h;
import s0.i;

public class DefaultTrackSelector extends MappingTrackSelector {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Ordering<Integer> f27656k = Ordering.b(new b());
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Ordering<Integer> f27657l = Ordering.b(new c());

    /* renamed from: d  reason: collision with root package name */
    private final Object f27658d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f27659e;

    /* renamed from: f  reason: collision with root package name */
    private final ExoTrackSelection.Factory f27660f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f27661g;

    /* renamed from: h  reason: collision with root package name */
    private Parameters f27662h;

    /* renamed from: i  reason: collision with root package name */
    private SpatializerWrapperV32 f27663i;

    /* renamed from: j  reason: collision with root package name */
    private AudioAttributes f27664j;

    private static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final int f27665f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f27666g;

        /* renamed from: h  reason: collision with root package name */
        private final String f27667h = DefaultTrackSelector.T(this.f27730e.f23062d);

        /* renamed from: i  reason: collision with root package name */
        private final Parameters f27668i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f27669j;

        /* renamed from: k  reason: collision with root package name */
        private final int f27670k;

        /* renamed from: l  reason: collision with root package name */
        private final int f27671l;

        /* renamed from: m  reason: collision with root package name */
        private final int f27672m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f27673n;

        /* renamed from: o  reason: collision with root package name */
        private final int f27674o;

        /* renamed from: p  reason: collision with root package name */
        private final int f27675p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f27676q;

        /* renamed from: r  reason: collision with root package name */
        private final int f27677r;

        /* renamed from: s  reason: collision with root package name */
        private final int f27678s;

        /* renamed from: t  reason: collision with root package name */
        private final int f27679t;

        /* renamed from: u  reason: collision with root package name */
        private final int f27680u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f27681v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f27682w;

        public AudioTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, boolean z2, Predicate<Format> predicate) {
            super(i2, trackGroup, i3);
            int i5;
            int i6;
            boolean z3;
            boolean z4;
            boolean z5;
            int i7;
            boolean z6;
            this.f27668i = parameters;
            boolean z7 = false;
            this.f27669j = DefaultTrackSelector.L(i4, false);
            int i8 = 0;
            while (true) {
                i5 = Integer.MAX_VALUE;
                if (i8 >= parameters.f27780o.size()) {
                    i8 = Integer.MAX_VALUE;
                    i6 = 0;
                    break;
                }
                i6 = DefaultTrackSelector.D(this.f27730e, parameters.f27780o.get(i8), false);
                if (i6 > 0) {
                    break;
                }
                i8++;
            }
            this.f27671l = i8;
            this.f27670k = i6;
            this.f27672m = DefaultTrackSelector.H(this.f27730e.f23064f, parameters.f27781p);
            Format format = this.f27730e;
            int i9 = format.f23064f;
            if (i9 == 0 || (i9 & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f27673n = z3;
            if ((format.f23063e & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f27676q = z4;
            int i10 = format.f23084z;
            this.f27677r = i10;
            this.f27678s = format.A;
            int i11 = format.f23067i;
            this.f27679t = i11;
            if ((i11 == -1 || i11 <= parameters.f27783r) && ((i10 == -1 || i10 <= parameters.f27782q) && predicate.apply(format))) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f27666g = z5;
            String[] j02 = Util.j0();
            int i12 = 0;
            while (true) {
                if (i12 >= j02.length) {
                    i12 = Integer.MAX_VALUE;
                    i7 = 0;
                    break;
                }
                i7 = DefaultTrackSelector.D(this.f27730e, j02[i12], false);
                if (i7 > 0) {
                    break;
                }
                i12++;
            }
            this.f27674o = i12;
            this.f27675p = i7;
            int i13 = 0;
            while (true) {
                if (i13 < parameters.f27784s.size()) {
                    String str = this.f27730e.f23071m;
                    if (str != null && str.equals(parameters.f27784s.get(i13))) {
                        i5 = i13;
                        break;
                    }
                    i13++;
                } else {
                    break;
                }
            }
            this.f27680u = i5;
            if (b2.e(i4) == 128) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f27681v = z6;
            this.f27682w = b2.g(i4) == 64 ? true : z7;
            this.f27665f = f(i4, z2);
        }

        public static int c(List<AudioTrackInfo> list, List<AudioTrackInfo> list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }

        public static ImmutableList<AudioTrackInfo> e(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, boolean z2, Predicate<Format> predicate) {
            ImmutableList.Builder k2 = ImmutableList.k();
            TrackGroup trackGroup2 = trackGroup;
            for (int i3 = 0; i3 < trackGroup2.f26002b; i3++) {
                k2.d(new AudioTrackInfo(i2, trackGroup, i3, parameters, iArr[i3], z2, predicate));
            }
            return k2.k();
        }

        private int f(int i2, boolean z2) {
            if (!DefaultTrackSelector.L(i2, this.f27668i.f27700o0)) {
                return 0;
            }
            if (!this.f27666g && !this.f27668i.f27694i0) {
                return 0;
            }
            if (DefaultTrackSelector.L(i2, false) && this.f27666g && this.f27730e.f23067i != -1) {
                Parameters parameters = this.f27668i;
                if (parameters.f27790y || parameters.f27789x || (!parameters.f27702q0 && z2)) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int a() {
            return this.f27665f;
        }

        /* renamed from: d */
        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering ordering;
            Ordering ordering2;
            if (!this.f27666g || !this.f27669j) {
                ordering = DefaultTrackSelector.f27656k.g();
            } else {
                ordering = DefaultTrackSelector.f27656k;
            }
            ComparisonChain f2 = ComparisonChain.j().g(this.f27669j, audioTrackInfo.f27669j).f(Integer.valueOf(this.f27671l), Integer.valueOf(audioTrackInfo.f27671l), Ordering.d().g()).d(this.f27670k, audioTrackInfo.f27670k).d(this.f27672m, audioTrackInfo.f27672m).g(this.f27676q, audioTrackInfo.f27676q).g(this.f27673n, audioTrackInfo.f27673n).f(Integer.valueOf(this.f27674o), Integer.valueOf(audioTrackInfo.f27674o), Ordering.d().g()).d(this.f27675p, audioTrackInfo.f27675p).g(this.f27666g, audioTrackInfo.f27666g).f(Integer.valueOf(this.f27680u), Integer.valueOf(audioTrackInfo.f27680u), Ordering.d().g());
            Integer valueOf = Integer.valueOf(this.f27679t);
            Integer valueOf2 = Integer.valueOf(audioTrackInfo.f27679t);
            if (this.f27668i.f27789x) {
                ordering2 = DefaultTrackSelector.f27656k.g();
            } else {
                ordering2 = DefaultTrackSelector.f27657l;
            }
            ComparisonChain f3 = f2.f(valueOf, valueOf2, ordering2).g(this.f27681v, audioTrackInfo.f27681v).g(this.f27682w, audioTrackInfo.f27682w).f(Integer.valueOf(this.f27677r), Integer.valueOf(audioTrackInfo.f27677r), ordering).f(Integer.valueOf(this.f27678s), Integer.valueOf(audioTrackInfo.f27678s), ordering);
            Integer valueOf3 = Integer.valueOf(this.f27679t);
            Integer valueOf4 = Integer.valueOf(audioTrackInfo.f27679t);
            if (!Util.c(this.f27667h, audioTrackInfo.f27667h)) {
                ordering = DefaultTrackSelector.f27657l;
            }
            return f3.f(valueOf3, valueOf4, ordering).i();
        }

        /* renamed from: g */
        public boolean b(AudioTrackInfo audioTrackInfo) {
            int i2;
            String str;
            int i3;
            Parameters parameters = this.f27668i;
            if ((parameters.f27697l0 || ((i3 = this.f27730e.f23084z) != -1 && i3 == audioTrackInfo.f27730e.f23084z)) && (parameters.f27695j0 || ((str = this.f27730e.f23071m) != null && TextUtils.equals(str, audioTrackInfo.f27730e.f23071m)))) {
                Parameters parameters2 = this.f27668i;
                if ((parameters2.f27696k0 || ((i2 = this.f27730e.A) != -1 && i2 == audioTrackInfo.f27730e.A)) && (parameters2.f27698m0 || (this.f27681v == audioTrackInfo.f27681v && this.f27682w == audioTrackInfo.f27682w))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class OtherTrackScore implements Comparable<OtherTrackScore> {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27683b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f27684c;

        public OtherTrackScore(Format format, int i2) {
            this.f27683b = (format.f23063e & 1) == 0 ? false : true;
            this.f27684c = DefaultTrackSelector.L(i2, false);
        }

        /* renamed from: a */
        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.j().g(this.f27684c, otherTrackScore.f27684c).g(this.f27683b, otherTrackScore.f27683b).i();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        /* access modifiers changed from: private */
        public static final String F0 = Util.u0(1003);
        /* access modifiers changed from: private */
        public static final String G0 = Util.u0(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
        /* access modifiers changed from: private */
        public static final String H0 = Util.u0(1005);
        /* access modifiers changed from: private */
        public static final String I0 = Util.u0(1006);
        /* access modifiers changed from: private */
        public static final String J0 = Util.u0(1007);
        /* access modifiers changed from: private */
        public static final String K0 = Util.u0(1008);
        /* access modifiers changed from: private */
        public static final String L0 = Util.u0(1009);
        /* access modifiers changed from: private */
        public static final String M0 = Util.u0(1010);
        /* access modifiers changed from: private */
        public static final String N0 = Util.u0(1011);
        /* access modifiers changed from: private */
        public static final String O0 = Util.u0(1012);
        /* access modifiers changed from: private */
        public static final String P0 = Util.u0(1013);
        /* access modifiers changed from: private */
        public static final String Q0 = Util.u0(1014);
        /* access modifiers changed from: private */
        public static final String R0 = Util.u0(1015);
        /* access modifiers changed from: private */
        public static final String S0 = Util.u0(1016);
        public static final Bundleable.Creator<Parameters> T0 = new h();

        /* renamed from: t0  reason: collision with root package name */
        public static final Parameters f27685t0;
        @Deprecated

        /* renamed from: u0  reason: collision with root package name */
        public static final Parameters f27686u0;
        /* access modifiers changed from: private */

        /* renamed from: v0  reason: collision with root package name */
        public static final String f27687v0 = Util.u0(1000);
        /* access modifiers changed from: private */

        /* renamed from: w0  reason: collision with root package name */
        public static final String f27688w0 = Util.u0(1001);
        /* access modifiers changed from: private */

        /* renamed from: x0  reason: collision with root package name */
        public static final String f27689x0 = Util.u0(1002);

        /* renamed from: e0  reason: collision with root package name */
        public final boolean f27690e0;

        /* renamed from: f0  reason: collision with root package name */
        public final boolean f27691f0;

        /* renamed from: g0  reason: collision with root package name */
        public final boolean f27692g0;

        /* renamed from: h0  reason: collision with root package name */
        public final boolean f27693h0;

        /* renamed from: i0  reason: collision with root package name */
        public final boolean f27694i0;

        /* renamed from: j0  reason: collision with root package name */
        public final boolean f27695j0;

        /* renamed from: k0  reason: collision with root package name */
        public final boolean f27696k0;

        /* renamed from: l0  reason: collision with root package name */
        public final boolean f27697l0;

        /* renamed from: m0  reason: collision with root package name */
        public final boolean f27698m0;

        /* renamed from: n0  reason: collision with root package name */
        public final boolean f27699n0;

        /* renamed from: o0  reason: collision with root package name */
        public final boolean f27700o0;

        /* renamed from: p0  reason: collision with root package name */
        public final boolean f27701p0;

        /* renamed from: q0  reason: collision with root package name */
        public final boolean f27702q0;
        /* access modifiers changed from: private */

        /* renamed from: r0  reason: collision with root package name */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> f27703r0;
        /* access modifiers changed from: private */

        /* renamed from: s0  reason: collision with root package name */
        public final SparseBooleanArray f27704s0;

        static {
            Parameters b02 = new Builder().A();
            f27685t0 = b02;
            f27686u0 = b02;
        }

        private static boolean F(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
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

        private static boolean G(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0 || !H(sparseArray.valueAt(i2), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean H(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
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
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.Util.c(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.H(java.util.Map, java.util.Map):boolean");
        }

        public static Parameters J(Context context) {
            return new Builder(context).A();
        }

        private static int[] K(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
                iArr[i2] = sparseBooleanArray.keyAt(i2);
            }
            return iArr;
        }

        private static void P(Bundle bundle, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                for (Map.Entry entry : sparseArray.valueAt(i2).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray2.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(M0, Ints.n(arrayList));
                bundle.putParcelableArrayList(N0, BundleableUtil.d(arrayList2));
                bundle.putSparseParcelableArray(O0, BundleableUtil.e(sparseArray2));
            }
        }

        /* renamed from: I */
        public Builder A() {
            return new Builder();
        }

        public boolean L(int i2) {
            return this.f27704s0.get(i2);
        }

        @Deprecated
        public SelectionOverride M(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.f27703r0.get(i2);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Deprecated
        public boolean N(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.f27703r0.get(i2);
            if (map == null || !map.containsKey(trackGroupArray)) {
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.f27690e0 == parameters.f27690e0 && this.f27691f0 == parameters.f27691f0 && this.f27692g0 == parameters.f27692g0 && this.f27693h0 == parameters.f27693h0 && this.f27694i0 == parameters.f27694i0 && this.f27695j0 == parameters.f27695j0 && this.f27696k0 == parameters.f27696k0 && this.f27697l0 == parameters.f27697l0 && this.f27698m0 == parameters.f27698m0 && this.f27699n0 == parameters.f27699n0 && this.f27700o0 == parameters.f27700o0 && this.f27701p0 == parameters.f27701p0 && this.f27702q0 == parameters.f27702q0 && F(this.f27704s0, parameters.f27704s0) && G(this.f27703r0, parameters.f27703r0)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f27690e0 ? 1 : 0)) * 31) + (this.f27691f0 ? 1 : 0)) * 31) + (this.f27692g0 ? 1 : 0)) * 31) + (this.f27693h0 ? 1 : 0)) * 31) + (this.f27694i0 ? 1 : 0)) * 31) + (this.f27695j0 ? 1 : 0)) * 31) + (this.f27696k0 ? 1 : 0)) * 31) + (this.f27697l0 ? 1 : 0)) * 31) + (this.f27698m0 ? 1 : 0)) * 31) + (this.f27699n0 ? 1 : 0)) * 31) + (this.f27700o0 ? 1 : 0)) * 31) + (this.f27701p0 ? 1 : 0)) * 31) + (this.f27702q0 ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(f27687v0, this.f27690e0);
            bundle.putBoolean(f27688w0, this.f27691f0);
            bundle.putBoolean(f27689x0, this.f27692g0);
            bundle.putBoolean(Q0, this.f27693h0);
            bundle.putBoolean(F0, this.f27694i0);
            bundle.putBoolean(G0, this.f27695j0);
            bundle.putBoolean(H0, this.f27696k0);
            bundle.putBoolean(I0, this.f27697l0);
            bundle.putBoolean(R0, this.f27698m0);
            bundle.putBoolean(S0, this.f27699n0);
            bundle.putBoolean(J0, this.f27700o0);
            bundle.putBoolean(K0, this.f27701p0);
            bundle.putBoolean(L0, this.f27702q0);
            P(bundle, this.f27703r0);
            bundle.putIntArray(P0, K(this.f27704s0));
            return bundle;
        }

        public static final class Builder extends TrackSelectionParameters.Builder {
            /* access modifiers changed from: private */
            public boolean A;
            /* access modifiers changed from: private */
            public boolean B;
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
            public final SparseArray<Map<TrackGroupArray, SelectionOverride>> N;
            /* access modifiers changed from: private */
            public final SparseBooleanArray O;

            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> d0(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
                }
                return sparseArray2;
            }

            private void e0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray f0(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int append : iArr) {
                    sparseBooleanArray.append(append, true);
                }
                return sparseBooleanArray;
            }

            private void x0(Bundle bundle) {
                ImmutableList<TrackGroupArray> immutableList;
                SparseArray<SelectionOverride> sparseArray;
                int[] intArray = bundle.getIntArray(Parameters.M0);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Parameters.N0);
                if (parcelableArrayList == null) {
                    immutableList = ImmutableList.r();
                } else {
                    immutableList = BundleableUtil.b(TrackGroupArray.f26009g, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(Parameters.O0);
                if (sparseParcelableArray == null) {
                    sparseArray = new SparseArray<>();
                } else {
                    sparseArray = BundleableUtil.c(SelectionOverride.f27708i, sparseParcelableArray);
                }
                if (intArray != null && intArray.length == immutableList.size()) {
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        w0(intArray[i2], immutableList.get(i2), sparseArray.get(i2));
                    }
                }
            }

            /* renamed from: A0 */
            public Builder K(int i2, int i3, boolean z2) {
                super.K(i2, i3, z2);
                return this;
            }

            /* renamed from: B0 */
            public Builder L(Context context, boolean z2) {
                super.L(context, z2);
                return this;
            }

            /* renamed from: b0 */
            public Parameters A() {
                return new Parameters(this);
            }

            /* renamed from: c0 */
            public Builder B(int i2) {
                super.B(i2);
                return this;
            }

            /* access modifiers changed from: protected */
            public Builder g0(TrackSelectionParameters trackSelectionParameters) {
                super.E(trackSelectionParameters);
                return this;
            }

            public Builder h0(boolean z2) {
                this.H = z2;
                return this;
            }

            public Builder i0(boolean z2) {
                this.I = z2;
                return this;
            }

            public Builder j0(boolean z2) {
                this.F = z2;
                return this;
            }

            public Builder k0(boolean z2) {
                this.G = z2;
                return this;
            }

            public Builder l0(boolean z2) {
                this.M = z2;
                return this;
            }

            public Builder m0(boolean z2) {
                this.D = z2;
                return this;
            }

            public Builder n0(boolean z2) {
                this.B = z2;
                return this;
            }

            public Builder o0(boolean z2) {
                this.C = z2;
                return this;
            }

            public Builder p0(boolean z2) {
                this.J = z2;
                return this;
            }

            public Builder q0(boolean z2) {
                this.E = z2;
                return this;
            }

            public Builder r0(boolean z2) {
                this.K = z2;
                return this;
            }

            public Builder s0(boolean z2) {
                this.A = z2;
                return this;
            }

            /* renamed from: t0 */
            public Builder F(int i2) {
                super.F(i2);
                return this;
            }

            /* renamed from: u0 */
            public Builder G(TrackSelectionOverride trackSelectionOverride) {
                super.G(trackSelectionOverride);
                return this;
            }

            /* renamed from: v0 */
            public Builder H(Context context) {
                super.H(context);
                return this;
            }

            @Deprecated
            public Builder w0(int i2, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
                Map map = this.N.get(i2);
                if (map == null) {
                    map = new HashMap();
                    this.N.put(i2, map);
                }
                if (map.containsKey(trackGroupArray) && Util.c(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }

            /* renamed from: y0 */
            public Builder J(int i2, boolean z2) {
                super.J(i2, z2);
                return this;
            }

            public Builder z0(boolean z2) {
                this.L = z2;
                return this;
            }

            @Deprecated
            public Builder() {
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            public Builder(Context context) {
                super(context);
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                e0();
            }

            private Builder(Parameters parameters) {
                super((TrackSelectionParameters) parameters);
                this.A = parameters.f27690e0;
                this.B = parameters.f27691f0;
                this.C = parameters.f27692g0;
                this.D = parameters.f27693h0;
                this.E = parameters.f27694i0;
                this.F = parameters.f27695j0;
                this.G = parameters.f27696k0;
                this.H = parameters.f27697l0;
                this.I = parameters.f27698m0;
                this.J = parameters.f27699n0;
                this.K = parameters.f27700o0;
                this.L = parameters.f27701p0;
                this.M = parameters.f27702q0;
                this.N = d0(parameters.f27703r0);
                this.O = parameters.f27704s0.clone();
            }

            private Builder(Bundle bundle) {
                super(bundle);
                e0();
                Parameters parameters = Parameters.f27685t0;
                s0(bundle.getBoolean(Parameters.f27687v0, parameters.f27690e0));
                n0(bundle.getBoolean(Parameters.f27688w0, parameters.f27691f0));
                o0(bundle.getBoolean(Parameters.f27689x0, parameters.f27692g0));
                m0(bundle.getBoolean(Parameters.Q0, parameters.f27693h0));
                q0(bundle.getBoolean(Parameters.F0, parameters.f27694i0));
                j0(bundle.getBoolean(Parameters.G0, parameters.f27695j0));
                k0(bundle.getBoolean(Parameters.H0, parameters.f27696k0));
                h0(bundle.getBoolean(Parameters.I0, parameters.f27697l0));
                i0(bundle.getBoolean(Parameters.R0, parameters.f27698m0));
                p0(bundle.getBoolean(Parameters.S0, parameters.f27699n0));
                r0(bundle.getBoolean(Parameters.J0, parameters.f27700o0));
                z0(bundle.getBoolean(Parameters.K0, parameters.f27701p0));
                l0(bundle.getBoolean(Parameters.L0, parameters.f27702q0));
                this.N = new SparseArray<>();
                x0(bundle);
                this.O = f0(bundle.getIntArray(Parameters.P0));
            }
        }

        private Parameters(Builder builder) {
            super(builder);
            this.f27690e0 = builder.A;
            this.f27691f0 = builder.B;
            this.f27692g0 = builder.C;
            this.f27693h0 = builder.D;
            this.f27694i0 = builder.E;
            this.f27695j0 = builder.F;
            this.f27696k0 = builder.G;
            this.f27697l0 = builder.H;
            this.f27698m0 = builder.I;
            this.f27699n0 = builder.J;
            this.f27700o0 = builder.K;
            this.f27701p0 = builder.L;
            this.f27702q0 = builder.M;
            this.f27703r0 = builder.N;
            this.f27704s0 = builder.O;
        }
    }

    public static final class SelectionOverride implements Bundleable {

        /* renamed from: f  reason: collision with root package name */
        private static final String f27705f = Util.u0(0);

        /* renamed from: g  reason: collision with root package name */
        private static final String f27706g = Util.u0(1);

        /* renamed from: h  reason: collision with root package name */
        private static final String f27707h = Util.u0(2);

        /* renamed from: i  reason: collision with root package name */
        public static final Bundleable.Creator<SelectionOverride> f27708i = new i();

        /* renamed from: b  reason: collision with root package name */
        public final int f27709b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f27710c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27711d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27712e;

        public SelectionOverride(int i2, int[] iArr, int i3) {
            this.f27709b = i2;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f27710c = copyOf;
            this.f27711d = iArr.length;
            this.f27712e = i3;
            Arrays.sort(copyOf);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ SelectionOverride b(Bundle bundle) {
            boolean z2;
            int i2 = bundle.getInt(f27705f, -1);
            int[] intArray = bundle.getIntArray(f27706g);
            int i3 = bundle.getInt(f27707h, -1);
            if (i2 < 0 || i3 < 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.a(z2);
            Assertions.e(intArray);
            return new SelectionOverride(i2, intArray, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.f27709b == selectionOverride.f27709b && Arrays.equals(this.f27710c, selectionOverride.f27710c) && this.f27712e == selectionOverride.f27712e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f27709b * 31) + Arrays.hashCode(this.f27710c)) * 31) + this.f27712e;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(f27705f, this.f27709b);
            bundle.putIntArray(f27706g, this.f27710c);
            bundle.putInt(f27707h, this.f27712e);
            return bundle;
        }
    }

    private static class SpatializerWrapperV32 {

        /* renamed from: a  reason: collision with root package name */
        private final Spatializer f27713a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27714b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f27715c;

        /* renamed from: d  reason: collision with root package name */
        private Spatializer.OnSpatializerStateChangedListener f27716d;

        private SpatializerWrapperV32(Spatializer spatializer) {
            boolean z2;
            this.f27713a = spatializer;
            if (spatializer.getImmersiveAudioLevel() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f27714b = z2;
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
            if (!"audio/eac3-joc".equals(format.f23071m) || format.f23084z != 16) {
                i2 = format.f23084z;
            } else {
                i2 = 12;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(Util.G(i2));
            int i3 = format.A;
            if (i3 != -1) {
                channelMask.setSampleRate(i3);
            }
            return this.f27713a.canBeSpatialized(audioAttributes.b().f23668a, channelMask.build());
        }

        public void b(final DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.f27716d == null && this.f27715c == null) {
                this.f27716d = new Spatializer.OnSpatializerStateChangedListener(this) {
                    public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
                        defaultTrackSelector.S();
                    }

                    public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
                        defaultTrackSelector.S();
                    }
                };
                Handler handler = new Handler(looper);
                this.f27715c = handler;
                Spatializer spatializer = this.f27713a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new b1(handler), this.f27716d);
            }
        }

        public boolean c() {
            return this.f27713a.isAvailable();
        }

        public boolean d() {
            return this.f27713a.isEnabled();
        }

        public boolean e() {
            return this.f27714b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f27716d;
            if (onSpatializerStateChangedListener != null && this.f27715c != null) {
                this.f27713a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) Util.j(this.f27715c)).removeCallbacksAndMessages((Object) null);
                this.f27715c = null;
                this.f27716d = null;
            }
        }
    }

    private static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final int f27718f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f27719g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f27720h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f27721i;

        /* renamed from: j  reason: collision with root package name */
        private final int f27722j;

        /* renamed from: k  reason: collision with root package name */
        private final int f27723k;

        /* renamed from: l  reason: collision with root package name */
        private final int f27724l;

        /* renamed from: m  reason: collision with root package name */
        private final int f27725m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f27726n;

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
            this.f27719g = DefaultTrackSelector.L(i4, false);
            int i7 = this.f27730e.f23063e & (~parameters.f27787v);
            if ((i7 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f27720h = z2;
            if ((i7 & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f27721i = z3;
            if (parameters.f27785t.isEmpty()) {
                immutableList = ImmutableList.s("");
            } else {
                immutableList = parameters.f27785t;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= immutableList.size()) {
                    i8 = Integer.MAX_VALUE;
                    i5 = 0;
                    break;
                }
                i5 = DefaultTrackSelector.D(this.f27730e, immutableList.get(i8), parameters.f27788w);
                if (i5 > 0) {
                    break;
                }
                i8++;
            }
            this.f27722j = i8;
            this.f27723k = i5;
            int v2 = DefaultTrackSelector.H(this.f27730e.f23064f, parameters.f27786u);
            this.f27724l = v2;
            if ((this.f27730e.f23064f & 1088) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f27726n = z4;
            if (DefaultTrackSelector.T(str) == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            int D = DefaultTrackSelector.D(this.f27730e, str, z5);
            this.f27725m = D;
            if (i5 > 0 || ((parameters.f27785t.isEmpty() && v2 > 0) || this.f27720h || (this.f27721i && D > 0))) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (DefaultTrackSelector.L(i4, parameters.f27700o0) && z6) {
                i6 = 1;
            }
            this.f27718f = i6;
        }

        public static int c(List<TextTrackInfo> list, List<TextTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<TextTrackInfo> e(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, String str) {
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i3 = 0; i3 < trackGroup.f26002b; i3++) {
                k2.d(new TextTrackInfo(i2, trackGroup, i3, parameters, iArr[i3], str));
            }
            return k2.k();
        }

        public int a() {
            return this.f27718f;
        }

        /* renamed from: d */
        public int compareTo(TextTrackInfo textTrackInfo) {
            Ordering ordering;
            ComparisonChain g2 = ComparisonChain.j().g(this.f27719g, textTrackInfo.f27719g).f(Integer.valueOf(this.f27722j), Integer.valueOf(textTrackInfo.f27722j), Ordering.d().g()).d(this.f27723k, textTrackInfo.f27723k).d(this.f27724l, textTrackInfo.f27724l).g(this.f27720h, textTrackInfo.f27720h);
            Boolean valueOf = Boolean.valueOf(this.f27721i);
            Boolean valueOf2 = Boolean.valueOf(textTrackInfo.f27721i);
            if (this.f27723k == 0) {
                ordering = Ordering.d();
            } else {
                ordering = Ordering.d().g();
            }
            ComparisonChain d2 = g2.f(valueOf, valueOf2, ordering).d(this.f27725m, textTrackInfo.f27725m);
            if (this.f27724l == 0) {
                d2 = d2.h(this.f27726n, textTrackInfo.f27726n);
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
        public final int f27727b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackGroup f27728c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27729d;

        /* renamed from: e  reason: collision with root package name */
        public final Format f27730e;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> a(int i2, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i2, TrackGroup trackGroup, int i3) {
            this.f27727b = i2;
            this.f27728c = trackGroup;
            this.f27729d = i3;
            this.f27730e = trackGroup.c(i3);
        }

        public abstract int a();

        public abstract boolean b(T t2);
    }

    private static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27731f;

        /* renamed from: g  reason: collision with root package name */
        private final Parameters f27732g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f27733h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f27734i;

        /* renamed from: j  reason: collision with root package name */
        private final int f27735j;

        /* renamed from: k  reason: collision with root package name */
        private final int f27736k;

        /* renamed from: l  reason: collision with root package name */
        private final int f27737l;

        /* renamed from: m  reason: collision with root package name */
        private final int f27738m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f27739n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f27740o;

        /* renamed from: p  reason: collision with root package name */
        private final int f27741p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f27742q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f27743r;

        /* renamed from: s  reason: collision with root package name */
        private final int f27744s;

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00c8 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackInfo(int r5, com.google.android.exoplayer2.source.TrackGroup r6, int r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, int r10, boolean r11) {
            /*
                r4 = this;
                r4.<init>(r5, r6, r7)
                r4.f27732g = r8
                boolean r5 = r8.f27692g0
                if (r5 == 0) goto L_0x000c
                r5 = 24
                goto L_0x000e
            L_0x000c:
                r5 = 16
            L_0x000e:
                boolean r6 = r8.f27691f0
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
                r4.f27740o = r6
                r6 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10 = -1
                if (r11 == 0) goto L_0x004b
                com.google.android.exoplayer2.Format r1 = r4.f27730e
                int r2 = r1.f23076r
                if (r2 == r10) goto L_0x002c
                int r3 = r8.f27767b
                if (r2 > r3) goto L_0x004b
            L_0x002c:
                int r2 = r1.f23077s
                if (r2 == r10) goto L_0x0034
                int r3 = r8.f27768c
                if (r2 > r3) goto L_0x004b
            L_0x0034:
                float r2 = r1.f23078t
                int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r3 == 0) goto L_0x0041
                int r3 = r8.f27769d
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x004b
            L_0x0041:
                int r1 = r1.f23067i
                if (r1 == r10) goto L_0x0049
                int r2 = r8.f27770e
                if (r1 > r2) goto L_0x004b
            L_0x0049:
                r1 = 1
                goto L_0x004c
            L_0x004b:
                r1 = 0
            L_0x004c:
                r4.f27731f = r1
                if (r11 == 0) goto L_0x0079
                com.google.android.exoplayer2.Format r11 = r4.f27730e
                int r1 = r11.f23076r
                if (r1 == r10) goto L_0x005a
                int r2 = r8.f27771f
                if (r1 < r2) goto L_0x0079
            L_0x005a:
                int r1 = r11.f23077s
                if (r1 == r10) goto L_0x0062
                int r2 = r8.f27772g
                if (r1 < r2) goto L_0x0079
            L_0x0062:
                float r1 = r11.f23078t
                int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r6 == 0) goto L_0x006f
                int r6 = r8.f27773h
                float r6 = (float) r6
                int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r6 < 0) goto L_0x0079
            L_0x006f:
                int r6 = r11.f23067i
                if (r6 == r10) goto L_0x0077
                int r10 = r8.f27774i
                if (r6 < r10) goto L_0x0079
            L_0x0077:
                r6 = 1
                goto L_0x007a
            L_0x0079:
                r6 = 0
            L_0x007a:
                r4.f27733h = r6
                boolean r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.L(r9, r0)
                r4.f27734i = r6
                com.google.android.exoplayer2.Format r6 = r4.f27730e
                int r10 = r6.f23067i
                r4.f27735j = r10
                int r6 = r6.f()
                r4.f27736k = r6
                com.google.android.exoplayer2.Format r6 = r4.f27730e
                int r6 = r6.f23064f
                int r10 = r8.f27779n
                int r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.H(r6, r10)
                r4.f27738m = r6
                com.google.android.exoplayer2.Format r6 = r4.f27730e
                int r6 = r6.f23064f
                if (r6 == 0) goto L_0x00a6
                r6 = r6 & r7
                if (r6 == 0) goto L_0x00a4
                goto L_0x00a6
            L_0x00a4:
                r6 = 0
                goto L_0x00a7
            L_0x00a6:
                r6 = 1
            L_0x00a7:
                r4.f27739n = r6
                r6 = 0
            L_0x00aa:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.f27778m
                int r10 = r10.size()
                if (r6 >= r10) goto L_0x00c8
                com.google.android.exoplayer2.Format r10 = r4.f27730e
                java.lang.String r10 = r10.f23071m
                if (r10 == 0) goto L_0x00c5
                com.google.common.collect.ImmutableList<java.lang.String> r11 = r8.f27778m
                java.lang.Object r11 = r11.get(r6)
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x00c5
                goto L_0x00cb
            L_0x00c5:
                int r6 = r6 + 1
                goto L_0x00aa
            L_0x00c8:
                r6 = 2147483647(0x7fffffff, float:NaN)
            L_0x00cb:
                r4.f27737l = r6
                int r6 = com.google.android.exoplayer2.b2.e(r9)
                r8 = 128(0x80, float:1.794E-43)
                if (r6 != r8) goto L_0x00d7
                r6 = 1
                goto L_0x00d8
            L_0x00d7:
                r6 = 0
            L_0x00d8:
                r4.f27742q = r6
                int r6 = com.google.android.exoplayer2.b2.g(r9)
                r8 = 64
                if (r6 != r8) goto L_0x00e3
                goto L_0x00e4
            L_0x00e3:
                r7 = 0
            L_0x00e4:
                r4.f27743r = r7
                com.google.android.exoplayer2.Format r6 = r4.f27730e
                java.lang.String r6 = r6.f23071m
                int r6 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.I(r6)
                r4.f27744s = r6
                int r5 = r4.i(r9, r5)
                r4.f27741p = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, com.google.android.exoplayer2.source.TrackGroup, int, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, int, boolean):void");
        }

        /* access modifiers changed from: private */
        public static int e(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain g2 = ComparisonChain.j().g(videoTrackInfo.f27734i, videoTrackInfo2.f27734i).d(videoTrackInfo.f27738m, videoTrackInfo2.f27738m).g(videoTrackInfo.f27739n, videoTrackInfo2.f27739n).g(videoTrackInfo.f27731f, videoTrackInfo2.f27731f).g(videoTrackInfo.f27733h, videoTrackInfo2.f27733h).f(Integer.valueOf(videoTrackInfo.f27737l), Integer.valueOf(videoTrackInfo2.f27737l), Ordering.d().g()).g(videoTrackInfo.f27742q, videoTrackInfo2.f27742q).g(videoTrackInfo.f27743r, videoTrackInfo2.f27743r);
            if (videoTrackInfo.f27742q && videoTrackInfo.f27743r) {
                g2 = g2.d(videoTrackInfo.f27744s, videoTrackInfo2.f27744s);
            }
            return g2.i();
        }

        /* access modifiers changed from: private */
        public static int f(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering ordering;
            Ordering ordering2;
            if (!videoTrackInfo.f27731f || !videoTrackInfo.f27734i) {
                ordering = DefaultTrackSelector.f27656k.g();
            } else {
                ordering = DefaultTrackSelector.f27656k;
            }
            ComparisonChain j2 = ComparisonChain.j();
            Integer valueOf = Integer.valueOf(videoTrackInfo.f27735j);
            Integer valueOf2 = Integer.valueOf(videoTrackInfo2.f27735j);
            if (videoTrackInfo.f27732g.f27789x) {
                ordering2 = DefaultTrackSelector.f27656k.g();
            } else {
                ordering2 = DefaultTrackSelector.f27657l;
            }
            return j2.f(valueOf, valueOf2, ordering2).f(Integer.valueOf(videoTrackInfo.f27736k), Integer.valueOf(videoTrackInfo2.f27736k), ordering).f(Integer.valueOf(videoTrackInfo.f27735j), Integer.valueOf(videoTrackInfo2.f27735j), ordering).i();
        }

        public static int g(List<VideoTrackInfo> list, List<VideoTrackInfo> list2) {
            return ComparisonChain.j().f((VideoTrackInfo) Collections.max(list, new d()), (VideoTrackInfo) Collections.max(list2, new d()), new d()).d(list.size(), list2.size()).f((VideoTrackInfo) Collections.max(list, new e()), (VideoTrackInfo) Collections.max(list2, new e()), new e()).i();
        }

        public static ImmutableList<VideoTrackInfo> h(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, int i3) {
            boolean z2;
            TrackGroup trackGroup2 = trackGroup;
            Parameters parameters2 = parameters;
            int u2 = DefaultTrackSelector.E(trackGroup2, parameters2.f27775j, parameters2.f27776k, parameters2.f27777l);
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i4 = 0; i4 < trackGroup2.f26002b; i4++) {
                int f2 = trackGroup2.c(i4).f();
                if (u2 == Integer.MAX_VALUE || (f2 != -1 && f2 <= u2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                k2.d(new VideoTrackInfo(i2, trackGroup, i4, parameters, iArr[i4], i3, z2));
            }
            return k2.k();
        }

        private int i(int i2, int i3) {
            if ((this.f27730e.f23064f & Http2.INITIAL_MAX_FRAME_SIZE) != 0 || !DefaultTrackSelector.L(i2, this.f27732g.f27700o0)) {
                return 0;
            }
            if (!this.f27731f && !this.f27732g.f27690e0) {
                return 0;
            }
            if (DefaultTrackSelector.L(i2, false) && this.f27733h && this.f27731f && this.f27730e.f23067i != -1) {
                Parameters parameters = this.f27732g;
                if (parameters.f27790y || parameters.f27789x || (i2 & i3) == 0) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }

        public int a() {
            return this.f27741p;
        }

        /* renamed from: j */
        public boolean b(VideoTrackInfo videoTrackInfo) {
            if ((this.f27740o || Util.c(this.f27730e.f23071m, videoTrackInfo.f27730e.f23071m)) && (this.f27732g.f27693h0 || (this.f27742q == videoTrackInfo.f27742q && this.f27743r == videoTrackInfo.f27743r))) {
                return true;
            }
            return false;
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this((TrackSelectionParameters) Parameters.f27685t0, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    private static void A(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int d2 = mappedTrackInfo.d();
        for (int i2 = 0; i2 < d2; i2++) {
            TrackGroupArray f2 = mappedTrackInfo.f(i2);
            if (parameters.N(i2, f2)) {
                SelectionOverride M = parameters.M(i2, f2);
                if (M == null || M.f27710c.length == 0) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(f2.b(M.f27709b), M.f27710c, M.f27712e);
                }
                definitionArr[i2] = definition;
            }
        }
    }

    private static void B(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int d2 = mappedTrackInfo.d();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < d2; i2++) {
            C(mappedTrackInfo.f(i2), trackSelectionParameters, hashMap);
        }
        C(mappedTrackInfo.h(), trackSelectionParameters, hashMap);
        for (int i3 = 0; i3 < d2; i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.e(i3)));
            if (trackSelectionOverride != null) {
                if (trackSelectionOverride.f27762c.isEmpty() || mappedTrackInfo.f(i3).c(trackSelectionOverride.f27761b) == -1) {
                    definition = null;
                } else {
                    definition = new ExoTrackSelection.Definition(trackSelectionOverride.f27761b, Ints.n(trackSelectionOverride.f27762c));
                }
                definitionArr[i3] = definition;
            }
        }
    }

    private static void C(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map<Integer, TrackSelectionOverride> map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i2 = 0; i2 < trackGroupArray.f26010b; i2++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.f27791z.get(trackGroupArray.b(i2));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = map.get(Integer.valueOf(trackSelectionOverride2.b()))) == null || (trackSelectionOverride.f27762c.isEmpty() && !trackSelectionOverride2.f27762c.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.b()), trackSelectionOverride2);
            }
        }
    }

    protected static int D(Format format, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f23062d)) {
            return 4;
        }
        String T = T(str);
        String T2 = T(format.f23062d);
        if (T2 == null || T == null) {
            if (!z2 || T2 != null) {
                return 0;
            }
            return 1;
        } else if (T2.startsWith(T) || T.startsWith(T2)) {
            return 3;
        } else {
            if (Util.X0(T2, "-")[0].equals(Util.X0(T, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int E(TrackGroup trackGroup, int i2, int i3, boolean z2) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            for (int i6 = 0; i6 < trackGroup.f26002b; i6++) {
                Format c2 = trackGroup.c(i6);
                int i7 = c2.f23076r;
                if (i7 > 0 && (i4 = c2.f23077s) > 0) {
                    Point F = F(z2, i2, i3, i7, i4);
                    int i8 = c2.f23076r;
                    int i9 = c2.f23077s;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (((float) F.x) * 0.98f)) && i9 >= ((int) (((float) F.y) * 0.98f)) && i10 < i5) {
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
    private static android.graphics.Point F(boolean r3, int r4, int r5, int r6, int r7) {
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
            int r4 = com.google.android.exoplayer2.util.Util.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.F(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: private */
    public static int H(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static int I(String str) {
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
    public boolean J(Format format) {
        boolean z2;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        synchronized (this.f27658d) {
            if (this.f27662h.f27699n0 && !this.f27661g && format.f23084z > 2 && (!K(format) || (Util.f28808a >= 32 && (spatializerWrapperV322 = this.f27663i) != null && spatializerWrapperV322.e()))) {
                if (Util.f28808a < 32 || (spatializerWrapperV32 = this.f27663i) == null || !spatializerWrapperV32.e() || !this.f27663i.c() || !this.f27663i.d() || !this.f27663i.a(this.f27664j, format)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private static boolean K(Format format) {
        String str = format.f23071m;
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

    protected static boolean L(int i2, boolean z2) {
        int f2 = b2.f(i2);
        return f2 == 4 || (z2 && f2 == 3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List M(Parameters parameters, boolean z2, int i2, TrackGroup trackGroup, int[] iArr) {
        return AudioTrackInfo.e(i2, trackGroup, parameters, iArr, z2, new g(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
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

    /* access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z2;
        boolean z3 = false;
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
            if ((e2 == 1 || e2 == 2) && exoTrackSelection != null && U(iArr[i2], mappedTrackInfo.f(i2), exoTrackSelection)) {
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
        if (!(i4 == -1 || i3 == -1)) {
            z3 = true;
        }
        if (z2 && z3) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        boolean z2;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f27658d) {
            if (!this.f27662h.f27699n0 || this.f27661g || Util.f28808a < 32 || (spatializerWrapperV32 = this.f27663i) == null || !spatializerWrapperV32.e()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            d();
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int c2 = trackGroupArray.c(exoTrackSelection.h());
        for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
            if (b2.h(iArr[c2][exoTrackSelection.c(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> Z(int i2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
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
                while (i5 < f2.f26010b) {
                    TrackGroup b2 = f2.b(i5);
                    List<T> a2 = factory.a(i4, b2, iArr[i4][i5]);
                    boolean[] zArr = new boolean[b2.f26002b];
                    int i6 = 0;
                    while (i6 < b2.f26002b) {
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
                                while (i7 < b2.f26002b) {
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
            iArr2[i10] = ((TrackInfo) list.get(i10)).f27729d;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.f27728c, iArr2), Integer.valueOf(trackInfo3.f27727b));
    }

    private void b0(Parameters parameters) {
        boolean z2;
        Assertions.e(parameters);
        synchronized (this.f27658d) {
            if (!this.f27662h.equals(parameters)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f27662h = parameters;
        }
        if (z2) {
            if (parameters.f27699n0 && this.f27659e == null) {
                Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            d();
        }
    }

    /* renamed from: G */
    public Parameters b() {
        Parameters parameters;
        synchronized (this.f27658d) {
            parameters = this.f27662h;
        }
        return parameters;
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition[] V(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        String str;
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[d2];
        Pair<ExoTrackSelection.Definition, Integer> a02 = a0(mappedTrackInfo, iArr, iArr2, parameters);
        if (a02 != null) {
            definitionArr[((Integer) a02.second).intValue()] = (ExoTrackSelection.Definition) a02.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> W = W(mappedTrackInfo, iArr, iArr2, parameters);
        if (W != null) {
            definitionArr[((Integer) W.second).intValue()] = (ExoTrackSelection.Definition) W.first;
        }
        if (W == null) {
            str = null;
        } else {
            Object obj = W.first;
            str = ((ExoTrackSelection.Definition) obj).f27745a.c(((ExoTrackSelection.Definition) obj).f27746b[0]).f23062d;
        }
        Pair<ExoTrackSelection.Definition, Integer> Y = Y(mappedTrackInfo, iArr, parameters, str);
        if (Y != null) {
            definitionArr[((Integer) Y.second).intValue()] = (ExoTrackSelection.Definition) Y.first;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = mappedTrackInfo.e(i2);
            if (!(e2 == 2 || e2 == 1 || e2 == 3)) {
                definitionArr[i2] = X(e2, mappedTrackInfo.f(i2), iArr[i2], parameters);
            }
        }
        return definitionArr;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> W(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < mappedTrackInfo.d()) {
                if (2 == mappedTrackInfo.e(i2) && mappedTrackInfo.f(i2).f26010b > 0) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return Z(1, mappedTrackInfo, iArr, new f(this, parameters, z2), new c());
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition X(int i2, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.f26010b; i4++) {
            TrackGroup b2 = trackGroupArray.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < b2.f26002b; i5++) {
                if (L(iArr2[i5], parameters.f27700o0)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(b2.c(i5), iArr2[i5]);
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
    public Pair<ExoTrackSelection.Definition, Integer> Y(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        return Z(3, mappedTrackInfo, iArr, new d(parameters, str), new a());
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, Integer> a0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        return Z(2, mappedTrackInfo, iArr, new e(parameters, iArr2), new b());
    }

    public boolean e() {
        return true;
    }

    public void g() {
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f27658d) {
            if (Util.f28808a >= 32 && (spatializerWrapperV32 = this.f27663i) != null) {
                spatializerWrapperV32.f();
            }
        }
        super.g();
    }

    public void i(AudioAttributes audioAttributes) {
        boolean z2;
        synchronized (this.f27658d) {
            if (!this.f27664j.equals(audioAttributes)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f27664j = audioAttributes;
        }
        if (z2) {
            S();
        }
    }

    public void j(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            b0((Parameters) trackSelectionParameters);
        }
        b0(new Parameters.Builder().g0(trackSelectionParameters).A());
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> n(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters;
        boolean z2;
        RendererConfiguration rendererConfiguration;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f27658d) {
            parameters = this.f27662h;
            if (parameters.f27699n0 && Util.f28808a >= 32 && (spatializerWrapperV32 = this.f27663i) != null) {
                spatializerWrapperV32.b(this, (Looper) Assertions.i(Looper.myLooper()));
            }
        }
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] V = V(mappedTrackInfo, iArr, iArr2, parameters);
        B(mappedTrackInfo, parameters, V);
        A(mappedTrackInfo, parameters, V);
        for (int i2 = 0; i2 < d2; i2++) {
            int e2 = mappedTrackInfo.e(i2);
            if (parameters.L(i2) || parameters.A.contains(Integer.valueOf(e2))) {
                V[i2] = null;
            }
        }
        ExoTrackSelection[] a2 = this.f27660f.a(V, a(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            int e3 = mappedTrackInfo.e(i3);
            boolean z3 = true;
            if (parameters.L(i3) || parameters.A.contains(Integer.valueOf(e3))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || (mappedTrackInfo.e(i3) != -2 && a2[i3] == null)) {
                z3 = false;
            }
            if (z3) {
                rendererConfiguration = RendererConfiguration.f23450b;
            } else {
                rendererConfiguration = null;
            }
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
        if (parameters.f27701p0) {
            R(mappedTrackInfo, iArr, rendererConfigurationArr, a2);
        }
        return Pair.create(rendererConfigurationArr, a2);
    }

    public DefaultTrackSelector(Context context) {
        this(context, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, (TrackSelectionParameters) Parameters.J(context), factory);
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, (Context) null);
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, Context context) {
        this.f27658d = new Object();
        this.f27659e = context != null ? context.getApplicationContext() : null;
        this.f27660f = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.f27662h = (Parameters) trackSelectionParameters;
        } else {
            this.f27662h = (context == null ? Parameters.f27685t0 : Parameters.J(context)).A().g0(trackSelectionParameters).A();
        }
        this.f27664j = AudioAttributes.f23655h;
        boolean z2 = context != null && Util.A0(context);
        this.f27661g = z2;
        if (!z2 && context != null && Util.f28808a >= 32) {
            this.f27663i = SpatializerWrapperV32.g(context);
        }
        if (this.f27662h.f27699n0 && context == null) {
            Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
