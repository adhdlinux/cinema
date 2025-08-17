package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public final class TrackGroupArray implements Bundleable {

    /* renamed from: e  reason: collision with root package name */
    public static final TrackGroupArray f26007e = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: f  reason: collision with root package name */
    private static final String f26008f = Util.u0(0);

    /* renamed from: g  reason: collision with root package name */
    public static final Bundleable.Creator<TrackGroupArray> f26009g = new w();

    /* renamed from: b  reason: collision with root package name */
    public final int f26010b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<TrackGroup> f26011c;

    /* renamed from: d  reason: collision with root package name */
    private int f26012d;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f26011c = ImmutableList.o(trackGroupArr);
        this.f26010b = trackGroupArr.length;
        e();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TrackGroupArray d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f26008f);
        if (parcelableArrayList == null) {
            return new TrackGroupArray(new TrackGroup[0]);
        }
        return new TrackGroupArray((TrackGroup[]) BundleableUtil.b(TrackGroup.f26001i, parcelableArrayList).toArray(new TrackGroup[0]));
    }

    private void e() {
        int i2 = 0;
        while (i2 < this.f26011c.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f26011c.size(); i4++) {
                if (this.f26011c.get(i2).equals(this.f26011c.get(i4))) {
                    Log.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    public TrackGroup b(int i2) {
        return this.f26011c.get(i2);
    }

    public int c(TrackGroup trackGroup) {
        int indexOf = this.f26011c.indexOf(trackGroup);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.f26010b != trackGroupArray.f26010b || !this.f26011c.equals(trackGroupArray.f26011c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f26012d == 0) {
            this.f26012d = this.f26011c.hashCode();
        }
        return this.f26012d;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f26008f, BundleableUtil.d(this.f26011c));
        return bundle;
    }
}
