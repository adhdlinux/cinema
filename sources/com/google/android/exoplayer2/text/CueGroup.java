package com.google.android.exoplayer2.text;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class CueGroup implements Bundleable {

    /* renamed from: d  reason: collision with root package name */
    public static final CueGroup f27236d = new CueGroup(ImmutableList.r(), 0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f27237e = Util.u0(0);

    /* renamed from: f  reason: collision with root package name */
    private static final String f27238f = Util.u0(1);

    /* renamed from: g  reason: collision with root package name */
    public static final Bundleable.Creator<CueGroup> f27239g = new b();

    /* renamed from: b  reason: collision with root package name */
    public final ImmutableList<Cue> f27240b;

    /* renamed from: c  reason: collision with root package name */
    public final long f27241c;

    public CueGroup(List<Cue> list, long j2) {
        this.f27240b = ImmutableList.n(list);
        this.f27241c = j2;
    }

    private static ImmutableList<Cue> b(List<Cue> list) {
        ImmutableList.Builder k2 = ImmutableList.k();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f27205e == null) {
                k2.d(list.get(i2));
            }
        }
        return k2.k();
    }

    /* access modifiers changed from: private */
    public static final CueGroup c(Bundle bundle) {
        ImmutableList<Cue> immutableList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f27237e);
        if (parcelableArrayList == null) {
            immutableList = ImmutableList.r();
        } else {
            immutableList = BundleableUtil.b(Cue.K, parcelableArrayList);
        }
        return new CueGroup(immutableList, bundle.getLong(f27238f));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f27237e, BundleableUtil.d(b(this.f27240b)));
        bundle.putLong(f27238f, this.f27241c);
        return bundle;
    }
}
