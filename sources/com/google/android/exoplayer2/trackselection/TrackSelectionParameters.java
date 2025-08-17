package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import s0.l;

public class TrackSelectionParameters implements Bundleable {
    public static final TrackSelectionParameters B;
    @Deprecated
    public static final TrackSelectionParameters C;
    /* access modifiers changed from: private */
    public static final String D = Util.u0(1);
    /* access modifiers changed from: private */
    public static final String E = Util.u0(2);
    /* access modifiers changed from: private */
    public static final String F = Util.u0(3);
    /* access modifiers changed from: private */
    public static final String G = Util.u0(4);
    /* access modifiers changed from: private */
    public static final String H = Util.u0(5);
    /* access modifiers changed from: private */
    public static final String I = Util.u0(6);
    /* access modifiers changed from: private */
    public static final String J = Util.u0(7);
    /* access modifiers changed from: private */
    public static final String K = Util.u0(8);
    /* access modifiers changed from: private */
    public static final String L = Util.u0(9);
    /* access modifiers changed from: private */
    public static final String M = Util.u0(10);
    /* access modifiers changed from: private */
    public static final String N = Util.u0(11);
    /* access modifiers changed from: private */
    public static final String O = Util.u0(12);
    /* access modifiers changed from: private */
    public static final String P = Util.u0(13);
    /* access modifiers changed from: private */
    public static final String Q = Util.u0(14);
    /* access modifiers changed from: private */
    public static final String R = Util.u0(15);
    /* access modifiers changed from: private */
    public static final String S = Util.u0(16);
    /* access modifiers changed from: private */
    public static final String T = Util.u0(17);
    /* access modifiers changed from: private */
    public static final String U = Util.u0(18);
    /* access modifiers changed from: private */
    public static final String V = Util.u0(19);
    /* access modifiers changed from: private */
    public static final String W = Util.u0(20);
    /* access modifiers changed from: private */
    public static final String X = Util.u0(21);
    /* access modifiers changed from: private */
    public static final String Y = Util.u0(22);
    /* access modifiers changed from: private */
    public static final String Z = Util.u0(23);
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public static final String f27763a0 = Util.u0(24);
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public static final String f27764b0 = Util.u0(25);
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public static final String f27765c0 = Util.u0(26);
    @Deprecated

    /* renamed from: d0  reason: collision with root package name */
    public static final Bundleable.Creator<TrackSelectionParameters> f27766d0 = new l();
    public final ImmutableSet<Integer> A;

    /* renamed from: b  reason: collision with root package name */
    public final int f27767b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27768c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27769d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27770e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27771f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27772g;

    /* renamed from: h  reason: collision with root package name */
    public final int f27773h;

    /* renamed from: i  reason: collision with root package name */
    public final int f27774i;

    /* renamed from: j  reason: collision with root package name */
    public final int f27775j;

    /* renamed from: k  reason: collision with root package name */
    public final int f27776k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f27777l;

    /* renamed from: m  reason: collision with root package name */
    public final ImmutableList<String> f27778m;

    /* renamed from: n  reason: collision with root package name */
    public final int f27779n;

    /* renamed from: o  reason: collision with root package name */
    public final ImmutableList<String> f27780o;

    /* renamed from: p  reason: collision with root package name */
    public final int f27781p;

    /* renamed from: q  reason: collision with root package name */
    public final int f27782q;

    /* renamed from: r  reason: collision with root package name */
    public final int f27783r;

    /* renamed from: s  reason: collision with root package name */
    public final ImmutableList<String> f27784s;

    /* renamed from: t  reason: collision with root package name */
    public final ImmutableList<String> f27785t;

    /* renamed from: u  reason: collision with root package name */
    public final int f27786u;

    /* renamed from: v  reason: collision with root package name */
    public final int f27787v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f27788w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f27789x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f27790y;

    /* renamed from: z  reason: collision with root package name */
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> f27791z;

    static {
        TrackSelectionParameters A2 = new Builder().A();
        B = A2;
        C = A2;
    }

    protected TrackSelectionParameters(Builder builder) {
        this.f27767b = builder.f27792a;
        this.f27768c = builder.f27793b;
        this.f27769d = builder.f27794c;
        this.f27770e = builder.f27795d;
        this.f27771f = builder.f27796e;
        this.f27772g = builder.f27797f;
        this.f27773h = builder.f27798g;
        this.f27774i = builder.f27799h;
        this.f27775j = builder.f27800i;
        this.f27776k = builder.f27801j;
        this.f27777l = builder.f27802k;
        this.f27778m = builder.f27803l;
        this.f27779n = builder.f27804m;
        this.f27780o = builder.f27805n;
        this.f27781p = builder.f27806o;
        this.f27782q = builder.f27807p;
        this.f27783r = builder.f27808q;
        this.f27784s = builder.f27809r;
        this.f27785t = builder.f27810s;
        this.f27786u = builder.f27811t;
        this.f27787v = builder.f27812u;
        this.f27788w = builder.f27813v;
        this.f27789x = builder.f27814w;
        this.f27790y = builder.f27815x;
        this.f27791z = ImmutableMap.d(builder.f27816y);
        this.A = ImmutableSet.m(builder.f27817z);
    }

    public static TrackSelectionParameters B(Bundle bundle) {
        return new Builder(bundle).A();
    }

    public Builder A() {
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
        if (this.f27767b == trackSelectionParameters.f27767b && this.f27768c == trackSelectionParameters.f27768c && this.f27769d == trackSelectionParameters.f27769d && this.f27770e == trackSelectionParameters.f27770e && this.f27771f == trackSelectionParameters.f27771f && this.f27772g == trackSelectionParameters.f27772g && this.f27773h == trackSelectionParameters.f27773h && this.f27774i == trackSelectionParameters.f27774i && this.f27777l == trackSelectionParameters.f27777l && this.f27775j == trackSelectionParameters.f27775j && this.f27776k == trackSelectionParameters.f27776k && this.f27778m.equals(trackSelectionParameters.f27778m) && this.f27779n == trackSelectionParameters.f27779n && this.f27780o.equals(trackSelectionParameters.f27780o) && this.f27781p == trackSelectionParameters.f27781p && this.f27782q == trackSelectionParameters.f27782q && this.f27783r == trackSelectionParameters.f27783r && this.f27784s.equals(trackSelectionParameters.f27784s) && this.f27785t.equals(trackSelectionParameters.f27785t) && this.f27786u == trackSelectionParameters.f27786u && this.f27787v == trackSelectionParameters.f27787v && this.f27788w == trackSelectionParameters.f27788w && this.f27789x == trackSelectionParameters.f27789x && this.f27790y == trackSelectionParameters.f27790y && this.f27791z.equals(trackSelectionParameters.f27791z) && this.A.equals(trackSelectionParameters.A)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f27767b + 31) * 31) + this.f27768c) * 31) + this.f27769d) * 31) + this.f27770e) * 31) + this.f27771f) * 31) + this.f27772g) * 31) + this.f27773h) * 31) + this.f27774i) * 31) + (this.f27777l ? 1 : 0)) * 31) + this.f27775j) * 31) + this.f27776k) * 31) + this.f27778m.hashCode()) * 31) + this.f27779n) * 31) + this.f27780o.hashCode()) * 31) + this.f27781p) * 31) + this.f27782q) * 31) + this.f27783r) * 31) + this.f27784s.hashCode()) * 31) + this.f27785t.hashCode()) * 31) + this.f27786u) * 31) + this.f27787v) * 31) + (this.f27788w ? 1 : 0)) * 31) + (this.f27789x ? 1 : 0)) * 31) + (this.f27790y ? 1 : 0)) * 31) + this.f27791z.hashCode()) * 31) + this.A.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(I, this.f27767b);
        bundle.putInt(J, this.f27768c);
        bundle.putInt(K, this.f27769d);
        bundle.putInt(L, this.f27770e);
        bundle.putInt(M, this.f27771f);
        bundle.putInt(N, this.f27772g);
        bundle.putInt(O, this.f27773h);
        bundle.putInt(P, this.f27774i);
        bundle.putInt(Q, this.f27775j);
        bundle.putInt(R, this.f27776k);
        bundle.putBoolean(S, this.f27777l);
        bundle.putStringArray(T, (String[]) this.f27778m.toArray(new String[0]));
        bundle.putInt(f27764b0, this.f27779n);
        bundle.putStringArray(D, (String[]) this.f27780o.toArray(new String[0]));
        bundle.putInt(E, this.f27781p);
        bundle.putInt(U, this.f27782q);
        bundle.putInt(V, this.f27783r);
        bundle.putStringArray(W, (String[]) this.f27784s.toArray(new String[0]));
        bundle.putStringArray(F, (String[]) this.f27785t.toArray(new String[0]));
        bundle.putInt(G, this.f27786u);
        bundle.putInt(f27765c0, this.f27787v);
        bundle.putBoolean(H, this.f27788w);
        bundle.putBoolean(X, this.f27789x);
        bundle.putBoolean(Y, this.f27790y);
        bundle.putParcelableArrayList(Z, BundleableUtil.d(this.f27791z.values()));
        bundle.putIntArray(f27763a0, Ints.n(this.A));
        return bundle;
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f27792a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f27793b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f27794c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f27795d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f27796e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f27797f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f27798g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f27799h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f27800i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f27801j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f27802k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public ImmutableList<String> f27803l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f27804m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public ImmutableList<String> f27805n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f27806o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f27807p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public int f27808q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public ImmutableList<String> f27809r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public ImmutableList<String> f27810s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public int f27811t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public int f27812u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public boolean f27813v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public boolean f27814w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public boolean f27815x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public HashMap<TrackGroup, TrackSelectionOverride> f27816y;
        /* access modifiers changed from: private */

        /* renamed from: z  reason: collision with root package name */
        public HashSet<Integer> f27817z;

        @Deprecated
        public Builder() {
            this.f27792a = Integer.MAX_VALUE;
            this.f27793b = Integer.MAX_VALUE;
            this.f27794c = Integer.MAX_VALUE;
            this.f27795d = Integer.MAX_VALUE;
            this.f27800i = Integer.MAX_VALUE;
            this.f27801j = Integer.MAX_VALUE;
            this.f27802k = true;
            this.f27803l = ImmutableList.r();
            this.f27804m = 0;
            this.f27805n = ImmutableList.r();
            this.f27806o = 0;
            this.f27807p = Integer.MAX_VALUE;
            this.f27808q = Integer.MAX_VALUE;
            this.f27809r = ImmutableList.r();
            this.f27810s = ImmutableList.r();
            this.f27811t = 0;
            this.f27812u = 0;
            this.f27813v = false;
            this.f27814w = false;
            this.f27815x = false;
            this.f27816y = new HashMap<>();
            this.f27817z = new HashSet<>();
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void C(TrackSelectionParameters trackSelectionParameters) {
            this.f27792a = trackSelectionParameters.f27767b;
            this.f27793b = trackSelectionParameters.f27768c;
            this.f27794c = trackSelectionParameters.f27769d;
            this.f27795d = trackSelectionParameters.f27770e;
            this.f27796e = trackSelectionParameters.f27771f;
            this.f27797f = trackSelectionParameters.f27772g;
            this.f27798g = trackSelectionParameters.f27773h;
            this.f27799h = trackSelectionParameters.f27774i;
            this.f27800i = trackSelectionParameters.f27775j;
            this.f27801j = trackSelectionParameters.f27776k;
            this.f27802k = trackSelectionParameters.f27777l;
            this.f27803l = trackSelectionParameters.f27778m;
            this.f27804m = trackSelectionParameters.f27779n;
            this.f27805n = trackSelectionParameters.f27780o;
            this.f27806o = trackSelectionParameters.f27781p;
            this.f27807p = trackSelectionParameters.f27782q;
            this.f27808q = trackSelectionParameters.f27783r;
            this.f27809r = trackSelectionParameters.f27784s;
            this.f27810s = trackSelectionParameters.f27785t;
            this.f27811t = trackSelectionParameters.f27786u;
            this.f27812u = trackSelectionParameters.f27787v;
            this.f27813v = trackSelectionParameters.f27788w;
            this.f27814w = trackSelectionParameters.f27789x;
            this.f27815x = trackSelectionParameters.f27790y;
            this.f27817z = new HashSet<>(trackSelectionParameters.A);
            this.f27816y = new HashMap<>(trackSelectionParameters.f27791z);
        }

        private static ImmutableList<String> D(String[] strArr) {
            ImmutableList.Builder k2 = ImmutableList.k();
            for (String e2 : (String[]) Assertions.e(strArr)) {
                k2.d(Util.H0((String) Assertions.e(e2)));
            }
            return k2.k();
        }

        private void I(Context context) {
            CaptioningManager captioningManager;
            if ((Util.f28808a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f27811t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f27810s = ImmutableList.s(Util.Z(locale));
                }
            }
        }

        public TrackSelectionParameters A() {
            return new TrackSelectionParameters(this);
        }

        public Builder B(int i2) {
            Iterator<TrackSelectionOverride> it2 = this.f27816y.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().b() == i2) {
                    it2.remove();
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder E(TrackSelectionParameters trackSelectionParameters) {
            C(trackSelectionParameters);
            return this;
        }

        public Builder F(int i2) {
            this.f27812u = i2;
            return this;
        }

        public Builder G(TrackSelectionOverride trackSelectionOverride) {
            B(trackSelectionOverride.b());
            this.f27816y.put(trackSelectionOverride.f27761b, trackSelectionOverride);
            return this;
        }

        public Builder H(Context context) {
            if (Util.f28808a >= 19) {
                I(context);
            }
            return this;
        }

        public Builder J(int i2, boolean z2) {
            if (z2) {
                this.f27817z.add(Integer.valueOf(i2));
            } else {
                this.f27817z.remove(Integer.valueOf(i2));
            }
            return this;
        }

        public Builder K(int i2, int i3, boolean z2) {
            this.f27800i = i2;
            this.f27801j = i3;
            this.f27802k = z2;
            return this;
        }

        public Builder L(Context context, boolean z2) {
            Point O = Util.O(context);
            return K(O.x, O.y, z2);
        }

        public Builder(Context context) {
            this();
            H(context);
            L(context, true);
        }

        protected Builder(TrackSelectionParameters trackSelectionParameters) {
            C(trackSelectionParameters);
        }

        protected Builder(Bundle bundle) {
            ImmutableList<TrackSelectionOverride> immutableList;
            String a2 = TrackSelectionParameters.I;
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.B;
            this.f27792a = bundle.getInt(a2, trackSelectionParameters.f27767b);
            this.f27793b = bundle.getInt(TrackSelectionParameters.J, trackSelectionParameters.f27768c);
            this.f27794c = bundle.getInt(TrackSelectionParameters.K, trackSelectionParameters.f27769d);
            this.f27795d = bundle.getInt(TrackSelectionParameters.L, trackSelectionParameters.f27770e);
            this.f27796e = bundle.getInt(TrackSelectionParameters.M, trackSelectionParameters.f27771f);
            this.f27797f = bundle.getInt(TrackSelectionParameters.N, trackSelectionParameters.f27772g);
            this.f27798g = bundle.getInt(TrackSelectionParameters.O, trackSelectionParameters.f27773h);
            this.f27799h = bundle.getInt(TrackSelectionParameters.P, trackSelectionParameters.f27774i);
            this.f27800i = bundle.getInt(TrackSelectionParameters.Q, trackSelectionParameters.f27775j);
            this.f27801j = bundle.getInt(TrackSelectionParameters.R, trackSelectionParameters.f27776k);
            this.f27802k = bundle.getBoolean(TrackSelectionParameters.S, trackSelectionParameters.f27777l);
            this.f27803l = ImmutableList.o((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.T), new String[0]));
            this.f27804m = bundle.getInt(TrackSelectionParameters.f27764b0, trackSelectionParameters.f27779n);
            this.f27805n = D((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.D), new String[0]));
            this.f27806o = bundle.getInt(TrackSelectionParameters.E, trackSelectionParameters.f27781p);
            this.f27807p = bundle.getInt(TrackSelectionParameters.U, trackSelectionParameters.f27782q);
            this.f27808q = bundle.getInt(TrackSelectionParameters.V, trackSelectionParameters.f27783r);
            this.f27809r = ImmutableList.o((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.W), new String[0]));
            this.f27810s = D((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.F), new String[0]));
            this.f27811t = bundle.getInt(TrackSelectionParameters.G, trackSelectionParameters.f27786u);
            this.f27812u = bundle.getInt(TrackSelectionParameters.f27765c0, trackSelectionParameters.f27787v);
            this.f27813v = bundle.getBoolean(TrackSelectionParameters.H, trackSelectionParameters.f27788w);
            this.f27814w = bundle.getBoolean(TrackSelectionParameters.X, trackSelectionParameters.f27789x);
            this.f27815x = bundle.getBoolean(TrackSelectionParameters.Y, trackSelectionParameters.f27790y);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.Z);
            if (parcelableArrayList == null) {
                immutableList = ImmutableList.r();
            } else {
                immutableList = BundleableUtil.b(TrackSelectionOverride.f27760f, parcelableArrayList);
            }
            this.f27816y = new HashMap<>();
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                TrackSelectionOverride trackSelectionOverride = immutableList.get(i2);
                this.f27816y.put(trackSelectionOverride.f27761b, trackSelectionOverride);
            }
            int[] iArr = (int[]) MoreObjects.a(bundle.getIntArray(TrackSelectionParameters.f27763a0), new int[0]);
            this.f27817z = new HashSet<>();
            for (int valueOf : iArr) {
                this.f27817z.add(Integer.valueOf(valueOf));
            }
        }
    }
}
