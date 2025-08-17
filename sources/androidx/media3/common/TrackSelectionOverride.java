package androidx.media3.common;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

public final class TrackSelectionOverride {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4395c = Util.B0(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4396d = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final TrackGroup f4397a;

    /* renamed from: b  reason: collision with root package name */
    public final ImmutableList<Integer> f4398b;

    public TrackSelectionOverride(TrackGroup trackGroup, int i2) {
        this(trackGroup, (List<Integer>) ImmutableList.s(Integer.valueOf(i2)));
    }

    public int a() {
        return this.f4397a.f4392c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverride.class != obj.getClass()) {
            return false;
        }
        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
        if (!this.f4397a.equals(trackSelectionOverride.f4397a) || !this.f4398b.equals(trackSelectionOverride.f4398b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f4397a.hashCode() + (this.f4398b.hashCode() * 31);
    }

    public TrackSelectionOverride(TrackGroup trackGroup, List<Integer> list) {
        if (list.isEmpty() || (((Integer) Collections.min(list)).intValue() >= 0 && ((Integer) Collections.max(list)).intValue() < trackGroup.f4390a)) {
            this.f4397a = trackGroup;
            this.f4398b = ImmutableList.n(list);
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
