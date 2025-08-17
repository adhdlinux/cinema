package com.google.android.exoplayer2.trackselection;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collections;
import java.util.List;
import s0.k;

public final class TrackSelectionOverride implements Bundleable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f27758d = Util.u0(0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f27759e = Util.u0(1);

    /* renamed from: f  reason: collision with root package name */
    public static final Bundleable.Creator<TrackSelectionOverride> f27760f = new k();

    /* renamed from: b  reason: collision with root package name */
    public final TrackGroup f27761b;

    /* renamed from: c  reason: collision with root package name */
    public final ImmutableList<Integer> f27762c;

    public TrackSelectionOverride(TrackGroup trackGroup, List<Integer> list) {
        if (list.isEmpty() || (((Integer) Collections.min(list)).intValue() >= 0 && ((Integer) Collections.max(list)).intValue() < trackGroup.f26002b)) {
            this.f27761b = trackGroup;
            this.f27762c = ImmutableList.n(list);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TrackSelectionOverride c(Bundle bundle) {
        return new TrackSelectionOverride(TrackGroup.f26001i.a((Bundle) Assertions.e(bundle.getBundle(f27758d))), Ints.c((int[]) Assertions.e(bundle.getIntArray(f27759e))));
    }

    public int b() {
        return this.f27761b.f26004d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverride.class != obj.getClass()) {
            return false;
        }
        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
        if (!this.f27761b.equals(trackSelectionOverride.f27761b) || !this.f27762c.equals(trackSelectionOverride.f27762c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f27761b.hashCode() + (this.f27762c.hashCode() * 31);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f27758d, this.f27761b.toBundle());
        bundle.putIntArray(f27759e, Ints.n(this.f27762c));
        return bundle;
    }
}
