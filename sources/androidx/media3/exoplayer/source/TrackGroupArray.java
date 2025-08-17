package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public final class TrackGroupArray {

    /* renamed from: d  reason: collision with root package name */
    public static final TrackGroupArray f7176d = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: e  reason: collision with root package name */
    private static final String f7177e = Util.B0(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f7178a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<TrackGroup> f7179b;

    /* renamed from: c  reason: collision with root package name */
    private int f7180c;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f7179b = ImmutableList.o(trackGroupArr);
        this.f7178a = trackGroupArr.length;
        f();
    }

    private void f() {
        int i2 = 0;
        while (i2 < this.f7179b.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f7179b.size(); i4++) {
                if (this.f7179b.get(i2).equals(this.f7179b.get(i4))) {
                    Log.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    public TrackGroup b(int i2) {
        return this.f7179b.get(i2);
    }

    public ImmutableList<Integer> c() {
        return ImmutableList.n(Lists.l(this.f7179b, new z()));
    }

    public int d(TrackGroup trackGroup) {
        int indexOf = this.f7179b.indexOf(trackGroup);
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
        if (this.f7178a != trackGroupArray.f7178a || !this.f7179b.equals(trackGroupArray.f7179b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f7180c == 0) {
            this.f7180c = this.f7179b.hashCode();
        }
        return this.f7180c;
    }
}
