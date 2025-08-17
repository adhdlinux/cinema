package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class CompositeSequenceableLoader implements SequenceableLoader {

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<SequenceableLoaderWithTrackTypes> f6856b;

    /* renamed from: c  reason: collision with root package name */
    private long f6857c;

    private static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {

        /* renamed from: b  reason: collision with root package name */
        private final SequenceableLoader f6858b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Integer> f6859c;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List<Integer> list) {
            this.f6858b = sequenceableLoader;
            this.f6859c = ImmutableList.n(list);
        }

        public ImmutableList<Integer> a() {
            return this.f6859c;
        }

        public long b() {
            return this.f6858b.b();
        }

        public boolean c() {
            return this.f6858b.c();
        }

        public long e() {
            return this.f6858b.e();
        }

        public void f(long j2) {
            this.f6858b.f(j2);
        }

        public boolean g(LoadingInfo loadingInfo) {
            return this.f6858b.g(loadingInfo);
        }
    }

    public CompositeSequenceableLoader(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        boolean z2;
        ImmutableList.Builder k2 = ImmutableList.k();
        if (list.size() == list2.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            k2.d(new SequenceableLoaderWithTrackTypes((SequenceableLoader) list.get(i2), list2.get(i2)));
        }
        this.f6856b = k2.k();
        this.f6857c = -9223372036854775807L;
    }

    public long b() {
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.f6856b.size(); i2++) {
            long b2 = this.f6856b.get(i2).b();
            if (b2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, b2);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public boolean c() {
        for (int i2 = 0; i2 < this.f6856b.size(); i2++) {
            if (this.f6856b.get(i2).c()) {
                return true;
            }
        }
        return false;
    }

    public long e() {
        long j2 = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.f6856b.size(); i2++) {
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = this.f6856b.get(i2);
            long e2 = sequenceableLoaderWithTrackTypes.e();
            if ((sequenceableLoaderWithTrackTypes.a().contains(1) || sequenceableLoaderWithTrackTypes.a().contains(2) || sequenceableLoaderWithTrackTypes.a().contains(4)) && e2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, e2);
            }
            if (e2 != Long.MIN_VALUE) {
                j3 = Math.min(j3, e2);
            }
        }
        if (j2 != Clock.MAX_TIME) {
            this.f6857c = j2;
            return j2;
        } else if (j3 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        } else {
            long j4 = this.f6857c;
            if (j4 != -9223372036854775807L) {
                return j4;
            }
            return j3;
        }
    }

    public void f(long j2) {
        for (int i2 = 0; i2 < this.f6856b.size(); i2++) {
            this.f6856b.get(i2).f(j2);
        }
    }

    public boolean g(LoadingInfo loadingInfo) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        do {
            long b2 = b();
            if (b2 == Long.MIN_VALUE) {
                break;
            }
            z2 = false;
            for (int i2 = 0; i2 < this.f6856b.size(); i2++) {
                long b3 = this.f6856b.get(i2).b();
                if (b3 == Long.MIN_VALUE || b3 > loadingInfo.f5395a) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (b3 == b2 || z3) {
                    z2 |= this.f6856b.get(i2).g(loadingInfo);
                }
            }
            z4 |= z2;
        } while (z2);
        return z4;
    }
}
