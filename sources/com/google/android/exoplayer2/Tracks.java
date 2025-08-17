package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracks implements Bundleable {

    /* renamed from: c  reason: collision with root package name */
    public static final Tracks f23528c = new Tracks(ImmutableList.r());

    /* renamed from: d  reason: collision with root package name */
    private static final String f23529d = Util.u0(0);

    /* renamed from: e  reason: collision with root package name */
    public static final Bundleable.Creator<Tracks> f23530e = new i2();

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<Group> f23531b;

    public static final class Group implements Bundleable {

        /* renamed from: g  reason: collision with root package name */
        private static final String f23532g = Util.u0(0);

        /* renamed from: h  reason: collision with root package name */
        private static final String f23533h = Util.u0(1);

        /* renamed from: i  reason: collision with root package name */
        private static final String f23534i = Util.u0(3);

        /* renamed from: j  reason: collision with root package name */
        private static final String f23535j = Util.u0(4);

        /* renamed from: k  reason: collision with root package name */
        public static final Bundleable.Creator<Group> f23536k = new j2();

        /* renamed from: b  reason: collision with root package name */
        public final int f23537b;

        /* renamed from: c  reason: collision with root package name */
        private final TrackGroup f23538c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f23539d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f23540e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean[] f23541f;

        public Group(TrackGroup trackGroup, boolean z2, int[] iArr, boolean[] zArr) {
            boolean z3;
            int i2 = trackGroup.f26002b;
            this.f23537b = i2;
            boolean z4 = false;
            if (i2 == iArr.length && i2 == zArr.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            this.f23538c = trackGroup;
            if (z2 && i2 > 1) {
                z4 = true;
            }
            this.f23539d = z4;
            this.f23540e = (int[]) iArr.clone();
            this.f23541f = (boolean[]) zArr.clone();
        }

        public TrackGroup b() {
            return this.f23538c;
        }

        public Format c(int i2) {
            return this.f23538c.c(i2);
        }

        public int d() {
            return this.f23538c.f26004d;
        }

        public boolean e() {
            return this.f23539d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            if (this.f23539d != group.f23539d || !this.f23538c.equals(group.f23538c) || !Arrays.equals(this.f23540e, group.f23540e) || !Arrays.equals(this.f23541f, group.f23541f)) {
                return false;
            }
            return true;
        }

        public boolean f() {
            return Booleans.b(this.f23541f, true);
        }

        public boolean g(int i2) {
            return this.f23541f[i2];
        }

        public boolean h(int i2) {
            return i(i2, false);
        }

        public int hashCode() {
            return (((((this.f23538c.hashCode() * 31) + (this.f23539d ? 1 : 0)) * 31) + Arrays.hashCode(this.f23540e)) * 31) + Arrays.hashCode(this.f23541f);
        }

        public boolean i(int i2, boolean z2) {
            int i3 = this.f23540e[i2];
            return i3 == 4 || (z2 && i3 == 3);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f23532g, this.f23538c.toBundle());
            bundle.putIntArray(f23533h, this.f23540e);
            bundle.putBooleanArray(f23534i, this.f23541f);
            bundle.putBoolean(f23535j, this.f23539d);
            return bundle;
        }
    }

    public Tracks(List<Group> list) {
        this.f23531b = ImmutableList.n(list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Tracks e(Bundle bundle) {
        ImmutableList<Group> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f23529d);
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.r();
        } else {
            immutableList = BundleableUtil.b(Group.f23536k, parcelableArrayList);
        }
        return new Tracks(immutableList);
    }

    public ImmutableList<Group> b() {
        return this.f23531b;
    }

    public boolean c() {
        return this.f23531b.isEmpty();
    }

    public boolean d(int i2) {
        for (int i3 = 0; i3 < this.f23531b.size(); i3++) {
            Group group = this.f23531b.get(i3);
            if (group.f() && group.d() == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.f23531b.equals(((Tracks) obj).f23531b);
    }

    public int hashCode() {
        return this.f23531b.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f23529d, BundleableUtil.d(this.f23531b));
        return bundle;
    }
}
