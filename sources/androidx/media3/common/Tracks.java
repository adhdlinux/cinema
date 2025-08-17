package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.List;

public final class Tracks {

    /* renamed from: b  reason: collision with root package name */
    public static final Tracks f4470b = new Tracks(ImmutableList.r());

    /* renamed from: c  reason: collision with root package name */
    private static final String f4471c = Util.B0(0);

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<Group> f4472a;

    public static final class Group {

        /* renamed from: f  reason: collision with root package name */
        private static final String f4473f = Util.B0(0);

        /* renamed from: g  reason: collision with root package name */
        private static final String f4474g = Util.B0(1);

        /* renamed from: h  reason: collision with root package name */
        private static final String f4475h = Util.B0(3);

        /* renamed from: i  reason: collision with root package name */
        private static final String f4476i = Util.B0(4);

        /* renamed from: a  reason: collision with root package name */
        public final int f4477a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackGroup f4478b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f4479c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f4480d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean[] f4481e;

        public Group(TrackGroup trackGroup, boolean z2, int[] iArr, boolean[] zArr) {
            boolean z3;
            int i2 = trackGroup.f4390a;
            this.f4477a = i2;
            boolean z4 = false;
            if (i2 == iArr.length && i2 == zArr.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            this.f4478b = trackGroup;
            if (z2 && i2 > 1) {
                z4 = true;
            }
            this.f4479c = z4;
            this.f4480d = (int[]) iArr.clone();
            this.f4481e = (boolean[]) zArr.clone();
        }

        public TrackGroup a() {
            return this.f4478b;
        }

        public Format b(int i2) {
            return this.f4478b.a(i2);
        }

        public int c() {
            return this.f4478b.f4392c;
        }

        public boolean d() {
            return this.f4479c;
        }

        public boolean e() {
            return Booleans.b(this.f4481e, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            if (this.f4479c != group.f4479c || !this.f4478b.equals(group.f4478b) || !Arrays.equals(this.f4480d, group.f4480d) || !Arrays.equals(this.f4481e, group.f4481e)) {
                return false;
            }
            return true;
        }

        public boolean f() {
            return g(false);
        }

        public boolean g(boolean z2) {
            for (int i2 = 0; i2 < this.f4480d.length; i2++) {
                if (j(i2, z2)) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(int i2) {
            return this.f4481e[i2];
        }

        public int hashCode() {
            return (((((this.f4478b.hashCode() * 31) + (this.f4479c ? 1 : 0)) * 31) + Arrays.hashCode(this.f4480d)) * 31) + Arrays.hashCode(this.f4481e);
        }

        public boolean i(int i2) {
            return j(i2, false);
        }

        public boolean j(int i2, boolean z2) {
            int i3 = this.f4480d[i2];
            return i3 == 4 || (z2 && i3 == 3);
        }
    }

    public Tracks(List<Group> list) {
        this.f4472a = ImmutableList.n(list);
    }

    public ImmutableList<Group> a() {
        return this.f4472a;
    }

    public boolean b() {
        return this.f4472a.isEmpty();
    }

    public boolean c(int i2) {
        for (int i3 = 0; i3 < this.f4472a.size(); i3++) {
            Group group = this.f4472a.get(i3);
            if (group.e() && group.c() == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean d(int i2) {
        return e(i2, false);
    }

    public boolean e(int i2, boolean z2) {
        for (int i3 = 0; i3 < this.f4472a.size(); i3++) {
            if (this.f4472a.get(i3).c() == i2 && this.f4472a.get(i3).g(z2)) {
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
        return this.f4472a.equals(((Tracks) obj).f4472a);
    }

    public int hashCode() {
        return this.f4472a.hashCode();
    }
}
